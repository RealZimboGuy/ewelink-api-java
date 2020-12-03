package com.ewelink.api;

import com.ewelink.api.model.devices.DeviceItem;
import com.ewelink.api.model.devices.Devices;

public class TestApp {
    private static final String APP_ID = "YzfeftUVcZ6twZw1OoVKPRFYTrGEg01Q";
    private static final String APP_SECRET = "4G91qSoboqYO4Y0XJ0LPPKIsq8reHdfa";

    public static void main(String[] args) {

        EweLink eweLink = new EweLink("eu","brettnetster@gmail.com","dildo123",10);

        try {
            eweLink.login();

//            eweLink.getDevices();

//            Thread.sleep(2000);
            Devices getDevices = eweLink.getDevices();

            for (DeviceItem devicelist : getDevices.getDevicelist()) {
                System.out.println(devicelist.getDeviceid());
                System.out.println(devicelist.getName());

                eweLink.getDeviceStatus(devicelist.getDeviceid());

            }


            Thread.sleep(2000);
            System.out.println(eweLink.getDevice("10009ce53b"));

            Thread.sleep(6500);
            System.out.println("after sleep");
            System.out.println(eweLink.getDevice("10009ce53b"));


//            System.out.println(eweLink.setDeviceStatusByName("Pool pump","off"));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
