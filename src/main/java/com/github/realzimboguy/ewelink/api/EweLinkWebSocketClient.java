package com.github.realzimboguy.ewelink.api;

import com.github.realzimboguy.ewelink.api.model.StatusChange;
import com.github.realzimboguy.ewelink.api.wss.WssLogin;
import com.github.realzimboguy.ewelink.api.wss.WssResponse;
import com.github.realzimboguy.ewelink.api.wss.wssrsp.WssRspMsg;
import com.google.gson.Gson;
import net.jodah.expiringmap.ExpiringMap;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public class EweLinkWebSocketClient extends WebSocketClient {

    Logger logger = LoggerFactory.getLogger(EweLinkWebSocketClient.class);

    private WssResponse wssResponse;
    private String wssLogin;

    Map<String, WssRspMsg> map = ExpiringMap.builder()
            .maxSize(100)
            .expiration(60, TimeUnit.SECONDS)
            .build();

    Gson gson = new Gson();

    public void setWssResponse(WssResponse wssResponse) {
        this.wssResponse = wssResponse;
    }

    public void setWssLogin(String wssLogin) {
        this.wssLogin = wssLogin;
    }

    public EweLinkWebSocketClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        send(wssLogin);
    }

    @Override
    public void onMessage(String s) {
        if (s!= null && s.equalsIgnoreCase("pong")){
            //swallow this as its just a ping/pong
            logger.debug(s);
        }else {
            parseMessage(s);
            wssResponse.onMessage(s);

        }
    }

    private void parseMessage(String s) {
        WssRspMsg rsp = gson.fromJson(s, WssRspMsg.class);
        map.put(rsp.getSequence(), rsp);

        wssResponse.onMessageParsed(rsp);
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        logger.warn("WS onCloseCalled, system will self-recover {} {} {}",i,s,b);
    }

    @Override
    public void onError(Exception e) {
        wssResponse.onError(e.getMessage());
    }


    public boolean sendAndWait(String text, String sequence) throws InterruptedException {
        super.send(text);

        //waits a total of 15 seconds

        for (int i = 0; i < 30; i++) {
            //wait 1 second
            Thread.sleep(500);

            if (map.containsKey(sequence)){
                WssRspMsg s = map.remove(sequence);
                if (s.getError() != null && s.getError() ==0 ){
                    return true;
                }else {
                    return false;
                }
            }

        }
        return false;


    }
    @Override
    public void send(String text) {
        super.send(text);
    }
}
