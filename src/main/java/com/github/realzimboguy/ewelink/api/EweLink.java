package com.github.realzimboguy.ewelink.api;

import com.github.realzimboguy.ewelink.api.errors.DeviceOfflineError;
import com.github.realzimboguy.ewelink.api.model.Param;
import com.github.realzimboguy.ewelink.api.model.StatusChange;
import com.github.realzimboguy.ewelink.api.model.home.Homepage;
import com.github.realzimboguy.ewelink.api.model.home.OutletSwitch;
import com.github.realzimboguy.ewelink.api.model.home.Params;
import com.github.realzimboguy.ewelink.api.model.home.Thing;
import com.github.realzimboguy.ewelink.api.model.login.LoginRequest;
import com.github.realzimboguy.ewelink.api.model.login.LoginResponse;
import com.github.realzimboguy.ewelink.api.wss.WssLogin;
import com.github.realzimboguy.ewelink.api.wss.WssResponse;
import com.github.realzimboguy.ewelink.api.wss.wssrsp.WssRspMsg;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.List;


public class EweLink {

    Logger logger = LoggerFactory.getLogger(EweLink.class);

    private static String region;
    private String email;
    private String password;
    private String countryCode;
    private int activityTimer;
    private String baseUrl = "TBA";
    public static final String APP_ID = "Uw83EKZFxdif7XFXEsrpduz5YyjP7nTl";
    private static final String APP_SECRET = "mXLOjea0woSMvK9gw7Fjsy7YlFO4iSu6";
    private static boolean isLoggedIn = false;
    private static long lastActivity = 0L;
    private static final int TIMEOUT = 5000;


    private static String accessToken;
    private static String apiKey;
    private static WssResponse clientWssResponse;

    private static EweLinkWebSocketClient eweLinkWebSocketClient = null;
    private static Thread webSocketMonitorThread = null;
    Gson gson = new Gson();

    public EweLink(String region,String email, String password,String countryCode, int activityTimer) {
      this.region = region;
      this.email = email;
      this.password = password;
      this.countryCode = countryCode;

      if (region!= null) {
          baseUrl = "https://"+region+"-apia.coolkit.cc/v2/";
      }
      if (activityTimer < 30) {
          activityTimer = 30;
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


        loginRequest.setLang("en");
        loginRequest.setCountryCode(countryCode);
        loginRequest.setOs("Android");
        loginRequest.setModel("Pixel 4a (5G)_bramble");
        loginRequest.setRomVersion("13");
        loginRequest.setAppVersion("5.0.0");
        loginRequest.setEmail(email);
        loginRequest.setPassword(password);


        logger.info(gson.toJson(loginRequest));

        conn.setRequestProperty("Content-Type","application/json" );
        conn.setRequestProperty("Authorization","Sign " +getAuthMac(gson.toJson(loginRequest)));
        conn.setRequestProperty("X-Ck-Nonce",Util.getNonce());
        conn.setRequestProperty("X-Ck-Appid",APP_ID);


        logger.info("Login Request:{}"+loginRequest.toString());


        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());

        wr.writeBytes(gson.toJson(loginRequest));

        wr.flush();
        wr.close();
        int responseCode = conn.getResponseCode();
        InputStream is;

        logger.info("Login Response Code :"+ responseCode);

        if (responseCode >= 400) is = conn.getErrorStream();
        else is = conn.getInputStream();

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            logger.info("Login Response Raw:{}"+response.toString());

            LoginResponse loginResponse = gson.fromJson(response.toString(),LoginResponse.class);

            logger.info("Login Response:{}"+loginResponse.toString());

            if (loginResponse.getError() > 0){
                //something wrong with login, throw exception back up with msg
                throw new Exception(loginResponse.getMsg());

            }else {
                accessToken = loginResponse.getData().getAt();
                apiKey = loginResponse.getData().getUser().getApikey();
                logger.info("accessToken:{}"+accessToken);
                logger.info("apiKey:{}"+apiKey);

                isLoggedIn = true;
                lastActivity = new Date().getTime();


            }

        }

    }

    public void getWebSocket(WssResponse wssResponse) throws Exception {
        if (!isLoggedIn){
            throw new Exception("Not Logged In, please call login Method");
        }

        eweLinkWebSocketClient = new EweLinkWebSocketClient(new URI("wss://"+ region+"-pconnect3.coolkit.cc:8080/api/ws"));
        clientWssResponse = wssResponse;
        eweLinkWebSocketClient.setWssResponse(clientWssResponse);
        eweLinkWebSocketClient.setWssLogin(gson.toJson(new WssLogin(accessToken,apiKey,APP_ID,Util.getNonce())));
        eweLinkWebSocketClient.connect();

        if(webSocketMonitorThread == null) {
            webSocketMonitorThread = new Thread(new WebSocketMonitor());
            webSocketMonitorThread.start();
        }


    }

    public List<Thing> getThings() throws Exception {
        return getHomePage().getData().getThingInfo().getThingList();
    }
    public Homepage getHomePage() throws Exception {

        if (!isLoggedIn){
            throw new Exception("Not Logged In, please call login Method");
        }
        if (lastActivity + (activityTimer * 60 * 1000) < new Date().getTime()){
            logger.info("Longer than last Activity, perform login Again");
            login();
        }


        URL url = new URL(baseUrl + "homepage");
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type","application/json" );
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Authorization","Bearer " +accessToken);
        conn.setConnectTimeout(TIMEOUT);
        conn.setReadTimeout(TIMEOUT);

        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());

        wr.writeBytes(gson.toJson("{\n" +
                "  \"getFamily\": {},\n" +
                "  \"getThing\": {\n" +
                "    \"num\": 300\n" +
                "  },\n" +
                "  \"lang\": \"en\"\n" +
                "}"));

        wr.flush();
        wr.close();
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
            logger.debug("getHome Response Raw:{}",response.toString());

            Homepage homepage = gson.fromJson(response.toString(), Homepage.class);

            logger.debug("getHome Response:{}",gson.toJson(homepage));

            if (homepage.getError() > 0){
                //something wrong with login, throw exception back up with msg
                throw new Exception("getHome Error:" + gson.toJson(homepage));

            }else {
                logger.info("getHome:{}",gson.toJson(homepage));
                lastActivity = new Date().getTime();
                return homepage;
            }

        }

    }


    public boolean setDeviceStatusByName(String name, String status) throws Exception{

        if (!isLoggedIn){
            throw new Exception("Not Logged In, please call login Method");
        }
        if (lastActivity + (activityTimer * 60 * 1000) < new Date().getTime()){
            logger.info("Longer than last Activity, perform login Again");
            login();
        }

        String selectedDeviceId = null;
        for (Thing thing : getThings()) {
            if (thing.getItemData().getName().equalsIgnoreCase(name)){
                selectedDeviceId = thing.getItemData().getDeviceid();
            }
        }

        if (selectedDeviceId == null) {
            throw new Exception("No Device id Found for Device Name:" + name);
        }

        return setDeviceStatus(selectedDeviceId,status);

    }

    public boolean setDeviceStatus(String deviceId, String status) throws Exception{

        if (!isLoggedIn){
            throw new Exception("Not Logged In, please call login Method");
        }

        if (eweLinkWebSocketClient == null ){

            //possibly means someone has called set status but not done a WSS init, we create a dummy one in this case
            getWebSocket(new WssResponse() {
                @Override
                public void onMessage(String s) {

                }

                @Override
                public void onMessageParsed(WssRspMsg rsp) {

                }

                @Override
                public void onError(String error) {

                }
            });
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


        StatusChange statusChange = new StatusChange();
        statusChange.setSequence(new Date().getTime() + "");
        statusChange.setUserAgent("app");
        statusChange.setAction("update");
        statusChange.setDeviceid(deviceId);
        statusChange.setApikey(apiKey);
        statusChange.setSelfApikey(apiKey);
        Params params = new Params();
        params.setSwitch(status);
        statusChange.setParams(params);

        logger.debug("StatusChange WS Request:{}",gson.toJson(statusChange));

        return eweLinkWebSocketClient.sendAndWait(gson.toJson(statusChange),statusChange.getSequence());


    }

    /**
     * you will need to populate the outlet switch based on the type device you have and not just the one you want to change (i think), not sure if this will break if you send more or less outlets than requred,example
     * output
     * "switches": [ { "switch": "off", "outlet": 0 }, { "switch": "on", "outlet": 1 }, { "switch": "off", "outlet": 2 }, { "switch": "off", "outlet": 3 } ]
     * @param deviceId
     * @param outletSwitches
     * @return
     * @throws Exception
     */
    public boolean setMultiDeviceStatus(String deviceId, List<OutletSwitch> outletSwitches) throws Exception{

        if (!isLoggedIn){
            throw new Exception("Not Logged In, please call login Method");
        }

        if (eweLinkWebSocketClient == null ){

            //possibly means someone has called set status but not done a WSS init, we create a dummy one in this case
            getWebSocket(new WssResponse() {
                @Override
                public void onMessage(String s) {

                }

                @Override
                public void onMessageParsed(WssRspMsg rsp) {

                }

                @Override
                public void onError(String error) {

                }
            });
        }

        if (lastActivity + (activityTimer * 60 * 1000) < new Date().getTime()){
            logger.info("Longer than last Activity, perform login Again");
            login();
        }

        logger.info("Setting device {} status on multi output {}",deviceId,gson.toJson(outletSwitches));


        StatusChange statusChange = new StatusChange();
        statusChange.setSequence(new Date().getTime() + "");
        statusChange.setUserAgent("app");
        statusChange.setAction("update");
        statusChange.setDeviceid(deviceId);
        statusChange.setApikey(apiKey);
        statusChange.setSelfApikey(apiKey);
        Params params = new Params();
        params.setSwitches(outletSwitches);
        statusChange.setParams(params);

        logger.debug("StatusChange WS Request:{}",gson.toJson(statusChange));

        return eweLinkWebSocketClient.sendAndWait(gson.toJson(statusChange),statusChange.getSequence());


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


    public class WebSocketMonitor implements  Runnable
    {

        Logger logger = LoggerFactory.getLogger(WebSocketMonitor.class);
        Gson gson = new Gson();


        @Override
        public void run() {

            logger.info("Websocket Monitor Thread start");

            while (true) {
                try {
                    Thread.sleep(30000);
                    logger.debug("send websocket ping");
                    eweLinkWebSocketClient.send("ping");

                } catch (Exception e) {
                    logger.error("Error in sening websocket ping:",e);
                    logger.info("Try reconnect to websocket");
                    try {
                        eweLinkWebSocketClient = new EweLinkWebSocketClient(new URI("wss://"+ region+"-pconnect3.coolkit.cc:8080/api/ws"));
                        eweLinkWebSocketClient.setWssResponse(clientWssResponse);
                        eweLinkWebSocketClient.setWssLogin(gson.toJson(new WssLogin(accessToken,apiKey,APP_ID,Util.getNonce())));
                        eweLinkWebSocketClient.connect();

                    }catch (Exception c) {
                        logger.error("Error trying to reconnect:",c);
                    }
                }
            }
        }
    }


}


