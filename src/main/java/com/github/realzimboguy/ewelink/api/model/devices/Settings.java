
package com.github.realzimboguy.ewelink.api.model.devices;

import java.util.HashMap;
import java.util.Map;

public class Settings {

    private Integer opsNotify;
    private Integer opsHistory;
    private Integer alarmNotify;
    private Integer wxAlarmNotify;
    private Integer wxOpsNotify;
    private Integer wxDoorbellNotify;
    private Integer appDoorbellNotify;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
