package com.github.realzimboguy.ewelink.api;

import com.github.realzimboguy.ewelink.api.model.devices.DeviceItem;
import com.github.realzimboguy.ewelink.api.model.devices.Devices;
import com.github.realzimboguy.ewelink.api.wss.WssResponse;
import com.github.realzimboguy.ewelink.api.wss.wssrsp.WssRspMsg;

public class TestCode {

    public static void main(String[] args) {


        EweLink eweLink = new EweLink("eu", "asdf@gmail.com", "asdf", 60);

        try {
            eweLink.login();

            Devices getDevices = eweLink.getDevices();

            for (DeviceItem devicelist : getDevices.getDevicelist()) {
                System.out.println(devicelist.getDeviceid());
                System.out.println(devicelist.getName());

                System.out.println(eweLink.getDeviceStatus(devicelist.getDeviceid()));

            }

            eweLink.getWebSocket(new WssResponse() {

                @Override
                public void onMessage(String s) {
                    //if you want the raw json data
                    System.out.println("on message in test raw:" + s);

                }

                @Override
                public void onMessageParsed(WssRspMsg rsp) {

                    if (rsp.getError() == null) {

                        //normal scenario
                        StringBuilder sb = new StringBuilder();
                        sb.append("Device:").append(rsp.getDeviceid()).append(" - ");
                        if (rsp.getParams() != null) {
                            sb.append("Switch:").append(rsp.getParams().getSwitch()).append(" - ");
                            sb.append("Voltage:").append(rsp.getParams().getVoltage()).append(" - ");
                            sb.append("Power:").append(rsp.getParams().getPower()).append(" - ");
                            sb.append("Current:").append(rsp.getParams().getCurrent()).append(" - ");
                        }

                        System.out.println(sb.toString());

                    } else if (rsp.getError() == 0) {
                        //this is from a login response
                        System.out.println("login success");
                    } else if (rsp.getError() > 0) {
                        System.out.println("login error:" + rsp.toString());
                    }
                }

                @Override
                public void onError(String error) {
                    System.out.println("onError in test, this should never be called");
                    System.out.println(error);

                }
            });


//            System.out.println(eweLink.getDevice("10009ce53b"));

//            System.out.println(eweLink.setDeviceStatusByName("Pool Tank","off"));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
