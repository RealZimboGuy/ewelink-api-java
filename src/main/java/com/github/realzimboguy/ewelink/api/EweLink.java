package com.github.realzimboguy.ewelink.api;

import com.github.realzimboguy.ewelink.api.model.devices.DeviceItem;
import com.github.realzimboguy.ewelink.api.model.devices.Devices;
import com.github.realzimboguy.ewelink.api.model.Status;
import com.github.realzimboguy.ewelink.api.model.StatusChange;
import com.github.realzimboguy.ewelink.api.model.login.LoginRequest;
import com.github.realzimboguy.ewelink.api.model.login.LoginResponse;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;


public class EweLink {

    Logger logger = LoggerFactory.getLogger(EweLink.class);

    private String region;
    private String email;
    private String password;
    private int activityTimer;
    private String baseUrl = "https://eu-api.coolkit.cc:8080/api/";
    private static final String APP_ID = "YzfeftUVcZ6twZw1OoVKPRFYTrGEg01Q";
    private static final String APP_SECRET = "4G91qSoboqYO4Y0XJ0LPPKIsq8reHdfa";
    private static boolean isLoggedIn = false;
    private static long lastActivity = 0L;
    private static final int TIMEOUT = 5000;


    private static String accessToken;
    private static String apiKey;


    Gson gson = new Gson();

    public EweLink(String region,String email, String password, int activityTimer) {
      this.region = region;
      this.email = email;
      this.password = password;
      if (region!= null) {
          baseUrl = "https://" + region + "-api.coolkit.cc:8080/api/";
      }
      if (activityTimer == 0) {
          activityTimer = 1;
      }
      this.activityTimer = activityTimer;

      logger.info("EweLinkApi startup params : {} {}", region,email);

    }

    public void login() throws Exception{


        URL url = new URL(baseUrl + "user/login");

        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json; utf-8");
        conn.setRequestProperty("Accept", "application/json");

        conn.setConnectTimeout(TIMEOUT);
        conn.setReadTimeout(TIMEOUT);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setAppid(APP_ID);
        loginRequest.setEmail(email);
        loginRequest.setPassword(password);
        loginRequest.setTs(new Date().getTime() + "");
        loginRequest.setVersion("8");
        loginRequest.setNonce(Util.getNonce());

        conn.setRequestProperty("Authorization","Sign " +getAuthMac(gson.toJson(loginRequest)));

        logger.debug("Login Request:{}",loginRequest.toString());


        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());

        wr.writeBytes(gson.toJson(loginRequest));

        wr.flush();
        wr.close();
        int responseCode = conn.getResponseCode();
        InputStream is;

        logger.debug("Login Response Code :{}",responseCode);

        if (responseCode >= 400) is = conn.getErrorStream();
        else is = conn.getInputStream();

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            logger.debug("Login Response Raw:{}",response.toString());

            LoginResponse loginResponse = gson.fromJson(response.toString(),LoginResponse.class);

            logger.debug("Login Response:{}",loginResponse.toString());

            if (loginResponse.getError() > 0){
                //something wrong with login, throw exception back up with msg
                throw new Exception(loginResponse.getMsg());

            }else {
                accessToken = loginResponse.getAt();
                apiKey = loginResponse.getUser().getApikey();
                logger.info("accessToken:{}",accessToken);
                logger.info("apiKey:{}",apiKey);

                isLoggedIn = true;
                lastActivity = new Date().getTime();


            }

        }

    }

    public Devices getDevices() throws Exception {

        if (!isLoggedIn){
            throw new Exception("Not Logged In, please call login Method");
        }
        if (lastActivity + (activityTimer * 60 * 1000) < new Date().getTime()){
            logger.info("Longer than last Activity, perform login Again");
            login();
        }


        URL url = new URL(baseUrl + "/user/device?lang=en&appid="+APP_ID+"&ts="+new Date().getTime()+"&version=8&getTags=1");

        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json; utf-8");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Authorization","Bearer " +accessToken);
        conn.setConnectTimeout(TIMEOUT);
        conn.setReadTimeout(TIMEOUT);


        int responseCode = conn.getResponseCode();
        InputStream is;

        if (responseCode >= 400) is = conn.getErrorStream();
        else is = conn.getInputStream();

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            logger.debug("GetDevices Response Raw:{}",response.toString());

            Devices getDevices = gson.fromJson(response.toString(), Devices.class);

            logger.debug("GetDevices Response:{}",getDevices.toString());

            if (getDevices.getError() > 0){
                //something wrong with login, throw exception back up with msg
                throw new Exception("Get Devices Error:" + getDevices.toString());

            }else {
                logger.info("getDevices:{}",getDevices.toString());
                lastActivity = new Date().getTime();
                return getDevices;
            }

        }

    }

    public DeviceItem getDevice(String deviceId) throws Exception {

        if (!isLoggedIn){
            throw new Exception("Not Logged In, please call login Method");
        }
        if (lastActivity + (activityTimer * 60 * 1000) < new Date().getTime()){
            logger.info("Longer than last Activity, perform login Again");
            login();
        }


        URL url = new URL(baseUrl + "/user/device/"+deviceId+"?deviceid="+deviceId+"" +
                "&lang=en" +
                "&appid="+APP_ID+"" +
                "&ts="+new Date().getTime()+"&version=8");

        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json; utf-8");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Authorization","Bearer " +accessToken);
        conn.setConnectTimeout(TIMEOUT);
        conn.setReadTimeout(TIMEOUT);


        int responseCode = conn.getResponseCode();
        InputStream is;

        if (responseCode >= 400) is = conn.getErrorStream();
        else is = conn.getInputStream();

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            logger.debug("GetDevice Response Raw:{}",response.toString());

            DeviceItem device = gson.fromJson(response.toString(), DeviceItem.class);

            logger.debug("GetDevice Response:{}",device.toString());

            if (device.getError() > 0){
                //something wrong with login, throw exception back up with msg
                throw new Exception("Get Device Error:" + device.toString());

            }else {
                logger.info("getDevice:{}",device.toString());
                lastActivity = new Date().getTime();
                return device;
            }

        }

    }

    public Status getDeviceStatus(String deviceId) throws Exception {

        if (!isLoggedIn){
            throw new Exception("Not Logged In, please call login Method");
        }
        if (lastActivity + (activityTimer * 60 * 1000) < new Date().getTime()){
            logger.info("Longer than last Activity, perform login Again");
            login();
        }


        URL url = new URL(baseUrl + "/user/device/status?deviceid="+deviceId+"" +
                "&lang=en" +
                "&appid="+APP_ID+"" +
                "&ts="+new Date().getTime()+"&version=8&params=switch|switches");

        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json; utf-8");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Authorization","Bearer " +accessToken);
        conn.setConnectTimeout(TIMEOUT);
        conn.setReadTimeout(TIMEOUT);


        int responseCode = conn.getResponseCode();
        InputStream is;

        if (responseCode >= 400) is = conn.getErrorStream();
        else is = conn.getInputStream();

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            logger.debug("Status Response Raw:{}",response.toString());

            Status status = gson.fromJson(response.toString(), Status.class);

            logger.debug("Status Response:{}",status.toString());

            if (status.getError() > 0){
                //something wrong with login, throw exception back up with msg
                throw new Exception("Status Error:" + status.toString());

            }else {
                logger.info("Status:{}",status.toString());
                lastActivity = new Date().getTime();
                //this is not returned but to be nice we do
                status.setDeviceid(deviceId);
                return status;
            }

        }

    }

    public Status setDeviceStatusByName(String name, String status) throws Exception{

        if (!isLoggedIn){
            throw new Exception("Not Logged In, please call login Method");
        }
        if (lastActivity + (activityTimer * 60 * 1000) < new Date().getTime()){
            logger.info("Longer than last Activity, perform login Again");
            login();
        }

        Devices devices = getDevices();
        String selectedDeviceId = null;
        for (DeviceItem deviceItem : devices.getDevicelist()) {
            if (deviceItem.getName().equalsIgnoreCase(name)){
                selectedDeviceId = deviceItem.getDeviceid();
            }
        }

        if (selectedDeviceId == null) {
            throw new Exception("No Device id Found for Device Name:" + name);
        }

        return setDeviceStatus(selectedDeviceId,status);

    }

    public Status setDeviceStatus(String deviceId, String status) throws Exception{

        if (!isLoggedIn){
            throw new Exception("Not Logged In, please call login Method");
        }
        if (lastActivity + (activityTimer * 60 * 1000) < new Date().getTime()){
            logger.info("Longer than last Activity, perform login Again");
            login();
        }

        if (status.equalsIgnoreCase("on")){
            status = "on";
        }else {
            status = "off";
        }
        logger.info("Setting device {} status to {}",deviceId,status);

        URL url = new URL(baseUrl + "user/device/status");

        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json; utf-8");
        conn.setRequestProperty("Accept", "application/json");

        conn.setConnectTimeout(TIMEOUT);
        conn.setReadTimeout(TIMEOUT);

        StatusChange statusChange = new StatusChange();
        statusChange.setAppid(APP_ID);
        statusChange.setDeviceid(deviceId);
        statusChange.setTs(new Date().getTime() + "");
        statusChange.setVersion("8");
        statusChange.setParams("{\"switch\":\""+status+"\"}");


        conn.setRequestProperty("Authorization","Bearer " +accessToken);

        logger.debug("StatusChange Request:{}",statusChange.toString());


        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());

        wr.writeBytes(gson.toJson(statusChange));

        wr.flush();
        wr.close();
        int responseCode = conn.getResponseCode();
        InputStream is;

        logger.debug("StatusChange Response Code :{}",responseCode);

        if (responseCode >= 400) is = conn.getErrorStream();
        else is = conn.getInputStream();

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            logger.debug("StatusChange Response Raw:{}",response.toString());

            Status statusRsp = gson.fromJson(response.toString(),Status.class);

            logger.debug("StatusChange Response:{}",statusRsp.toString());

            if (statusRsp.getError() > 0){
                //something wrong with login, throw exception back up with msg
                throw new Exception(statusRsp.getErrmsg());

            }else {


                isLoggedIn = true;
                lastActivity = new Date().getTime();
                return statusRsp;

            }

        }

    }

    private static String getAuthMac (String data) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {

        Mac sha256_HMAC = null;

        byte[] byteKey = APP_SECRET.getBytes("UTF-8");
        final String HMAC_SHA256 = "HmacSHA256";
        sha256_HMAC = Mac.getInstance(HMAC_SHA256);
        SecretKeySpec keySpec = new SecretKeySpec(byteKey, HMAC_SHA256);
        sha256_HMAC.init(keySpec);
        byte[] mac_data = sha256_HMAC.
                doFinal(data.getBytes("UTF-8"));

        return Base64.getEncoder().encodeToString(mac_data);


    }


}


