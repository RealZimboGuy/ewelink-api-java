package com.github.realzimboguy.ewelink.api.model;

import com.github.realzimboguy.ewelink.api.model.home.Params;

public class StatusChange {



    private Integer error;
    private String sequence;
    private String userAgent;
    private String action;
    private String deviceid;
    private String apikey;
    private String selfApikey;
    private Params params;


    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
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

    public String getSelfApikey() {
        return selfApikey;
    }

    public void setSelfApikey(String selfApikey) {
        this.selfApikey = selfApikey;
    }


    @Override
    public String toString() {
        return "StatusChange{" +
                "error=" + error +
                ", sequence='" + sequence + '\'' +
                ", userAgent='" + userAgent + '\'' +
                ", action='" + action + '\'' +
                ", deviceid='" + deviceid + '\'' +
                ", apikey='" + apikey + '\'' +
                ", selfApikey='" + selfApikey + '\'' +
                ", params=" + params +
                '}';
    }
}
