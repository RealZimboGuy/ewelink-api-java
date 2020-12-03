package com.github.realzimboguy.ewelink.api.model;

public class Status {

    private int error;
    private Param params;
    private String deviceid;
    private String errmsg;

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public Param getParams() {
        return params;
    }

    public void setParams(Param params) {
        this.params = params;
    }


    @Override
    public String toString() {
        return "Status{" +
                "error=" + error +
                ", params=" + params +
                ", deviceid='" + deviceid + '\'' +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
