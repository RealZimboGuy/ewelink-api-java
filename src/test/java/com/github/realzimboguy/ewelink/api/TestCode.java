package com.github.realzimboguy.ewelink.api;

import com.github.realzimboguy.ewelink.api.errors.DeviceOfflineError;
import com.github.realzimboguy.ewelink.api.model.home.Thing;
import com.github.realzimboguy.ewelink.api.wss.WssResponse;
import com.github.realzimboguy.ewelink.api.wss.wssrsp.WssRspMsg;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class TestCode {


    private static final Logger logger = LoggerFactory.getLogger(TestCode.class);

    public static void main(String[] args) {


        Gson gson = new Gson();
        EweLink eweLink = new EweLink("eu", "test@gmail.com", "test", "+263",60);

        try {
            eweLink.login();

            List<Thing> things = eweLink.getThings();


            logger.info("PRINT DEVICE_ID, NAME, ONLINE, SWITCH, VOLTAGE");
            for (Thing thing : things) {
                logger.info("{}, {}, {}, {}, {}",
                        thing.getItemData().getDeviceid() ,
                        thing.getItemData().getName() ,
                        thing.getItemData().getOnline(),
                        thing.getItemData().getParams().getSwitch(),
                        thing.getItemData().getParams().getVoltage());
            }
            logger.info("PRINT JSON OBJECTS");
            for (Thing thing : things) {
                logger.info("{} ",gson.toJson(thing));
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


            Thread.sleep(10000);
            System.out.println(eweLink.setDeviceStatus("1000f40d35", "on"));
            Thread.sleep(5000);
            System.out.println(eweLink.setDeviceStatus("1000f40d35", "off"));




        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
