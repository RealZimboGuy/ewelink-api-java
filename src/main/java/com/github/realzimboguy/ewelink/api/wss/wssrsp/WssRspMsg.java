
package com.github.realzimboguy.ewelink.api.wss.wssrsp;



import com.github.realzimboguy.ewelink.api.model.home.Params;

import java.util.HashMap;
import java.util.Map;

public class WssRspMsg {

    private Integer error;
    private String action;
    private String deviceid;
    private String apikey;
    private String userAgent;
    private Params params;
    private String from;
    private Config config;
    private String seq;
    private String sequence;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "WssRspMsg{" +
                "error=" + error +
                ", action='" + action + '\'' +
                ", deviceid='" + deviceid + '\'' +
                ", apikey='" + apikey + '\'' +
                ", userAgent='" + userAgent + '\'' +
                ", params=" + params +
                ", from='" + from + '\'' +
                ", config=" + config +
                ", seq='" + seq + '\'' +
                ", sequence='" + sequence + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
