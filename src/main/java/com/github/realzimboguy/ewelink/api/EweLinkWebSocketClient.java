package com.github.realzimboguy.ewelink.api;

import com.github.realzimboguy.ewelink.api.wss.WssLogin;
import com.github.realzimboguy.ewelink.api.wss.WssResponse;
import com.github.realzimboguy.ewelink.api.wss.wssrsp.WssRspMsg;
import com.google.gson.Gson;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

public class EweLinkWebSocketClient extends WebSocketClient {

    Logger logger = LoggerFactory.getLogger(EweLinkWebSocketClient.class);

    private WssResponse wssResponse;
    private String wssLogin;
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
            wssResponse.onMessage(s);
            wssResponse.onMessageParsed(gson.fromJson(s, WssRspMsg.class));
        }
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        logger.warn("WS onCloseCalled, system will self-recover {} {} {}",i,s,b);
    }

    @Override
    public void onError(Exception e) {
        wssResponse.onError(e.getMessage());
    }
}
