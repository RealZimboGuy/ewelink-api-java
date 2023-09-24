
package com.github.realzimboguy.ewelink.api.model.home;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Settings {

    @SerializedName("opsNotify")
    @Expose
    private Integer opsNotify;
    @SerializedName("opsHistory")
    @Expose
    private Integer opsHistory;
    @SerializedName("alarmNotify")
    @Expose
    private Integer alarmNotify;
    @SerializedName("wxAlarmNotify")
    @Expose
    private Integer wxAlarmNotify;
    @SerializedName("wxOpsNotify")
    @Expose
    private Integer wxOpsNotify;
    @SerializedName("wxDoorbellNotify")
    @Expose
    private Integer wxDoorbellNotify;
    @SerializedName("appDoorbellNotify")
    @Expose
    private Integer appDoorbellNotify;
    @SerializedName("offlineNotify")
    @Expose
    private Integer offlineNotify;

    public Integer getOpsNotify() {
        return opsNotify;
    }

    public void setOpsNotify(Integer opsNotify) {
        this.opsNotify = opsNotify;
    }

    public Integer getOpsHistory() {
        return opsHistory;
    }

    public void setOpsHistory(Integer opsHistory) {
        this.opsHistory = opsHistory;
    }

    public Integer getAlarmNotify() {
        return alarmNotify;
    }

    public void setAlarmNotify(Integer alarmNotify) {
        this.alarmNotify = alarmNotify;
    }

    public Integer getWxAlarmNotify() {
        return wxAlarmNotify;
    }

    public void setWxAlarmNotify(Integer wxAlarmNotify) {
        this.wxAlarmNotify = wxAlarmNotify;
    }

    public Integer getWxOpsNotify() {
        return wxOpsNotify;
    }

    public void setWxOpsNotify(Integer wxOpsNotify) {
        this.wxOpsNotify = wxOpsNotify;
    }

    public Integer getWxDoorbellNotify() {
        return wxDoorbellNotify;
    }

    public void setWxDoorbellNotify(Integer wxDoorbellNotify) {
        this.wxDoorbellNotify = wxDoorbellNotify;
    }

    public Integer getAppDoorbellNotify() {
        return appDoorbellNotify;
    }

    public void setAppDoorbellNotify(Integer appDoorbellNotify) {
        this.appDoorbellNotify = appDoorbellNotify;
    }

    public Integer getOfflineNotify() {
        return offlineNotify;
    }

    public void setOfflineNotify(Integer offlineNotify) {
        this.offlineNotify = offlineNotify;
    }

}
