
package com.github.realzimboguy.ewelink.api.model.devices;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Params {

    private BindInfos bindInfos;
    private String sledOnline;
    @SerializedName("switch")
    private String _switch;
    private String power;
    private String voltage;
    private String current;
    private String fwVersion;
    private String staMac;
    private Integer rssi;
    private Integer init;
    private String alarmType;
    private List<Integer> alarmVValue = null;
    private List<Integer> alarmCValue = null;
    private List<Integer> alarmPValue = null;
    private String oneKwh;
    private Integer uiActive;
    private Integer timeZone;
    private Integer version;
    private String startup;
    private String pulse;
    private Integer pulseWidth;
    private List<Timer> timers = null;
    private String hundredDaysKwh;
    private OnlyDevice onlyDevice;
    private String ssid;
    private String bssid;
    private String endTime;
    private String startTime;

    private String subDevId;
    private String parentid;
    private String battery;
    private String trigTime;
    private String temperature;
    private String humidity;


    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public BindInfos getBindInfos() {
        return bindInfos;
    }

    public void setBindInfos(BindInfos bindInfos) {
        this.bindInfos = bindInfos;
    }

    public String getSledOnline() {
        return sledOnline;
    }

    public void setSledOnline(String sledOnline) {
        this.sledOnline = sledOnline;
    }

    public String getSwitch() {
        return _switch;
    }

    public void setSwitch(String _switch) {
        this._switch = _switch;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getVoltage() {
        return voltage;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getFwVersion() {
        return fwVersion;
    }

    public void setFwVersion(String fwVersion) {
        this.fwVersion = fwVersion;
    }

    public String getStaMac() {
        return staMac;
    }

    public void setStaMac(String staMac) {
        this.staMac = staMac;
    }

    public Integer getRssi() {
        return rssi;
    }

    public void setRssi(Integer rssi) {
        this.rssi = rssi;
    }

    public Integer getInit() {
        return init;
    }

    public void setInit(Integer init) {
        this.init = init;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public List<Integer> getAlarmVValue() {
        return alarmVValue;
    }

    public void setAlarmVValue(List<Integer> alarmVValue) {
        this.alarmVValue = alarmVValue;
    }

    public List<Integer> getAlarmCValue() {
        return alarmCValue;
    }

    public void setAlarmCValue(List<Integer> alarmCValue) {
        this.alarmCValue = alarmCValue;
    }

    public List<Integer> getAlarmPValue() {
        return alarmPValue;
    }

    public void setAlarmPValue(List<Integer> alarmPValue) {
        this.alarmPValue = alarmPValue;
    }

    public String getOneKwh() {
        return oneKwh;
    }

    public void setOneKwh(String oneKwh) {
        this.oneKwh = oneKwh;
    }

    public Integer getUiActive() {
        return uiActive;
    }

    public void setUiActive(Integer uiActive) {
        this.uiActive = uiActive;
    }

    public Integer getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(Integer timeZone) {
        this.timeZone = timeZone;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getStartup() {
        return startup;
    }

    public void setStartup(String startup) {
        this.startup = startup;
    }

    public String getPulse() {
        return pulse;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse;
    }

    public Integer getPulseWidth() {
        return pulseWidth;
    }

    public void setPulseWidth(Integer pulseWidth) {
        this.pulseWidth = pulseWidth;
    }

    public List<Timer> getTimers() {
        return timers;
    }

    public void setTimers(List<Timer> timers) {
        this.timers = timers;
    }

    public String getHundredDaysKwh() {
        return hundredDaysKwh;
    }

    public void setHundredDaysKwh(String hundredDaysKwh) {
        this.hundredDaysKwh = hundredDaysKwh;
    }

    public OnlyDevice getOnlyDevice() {
        return onlyDevice;
    }

    public void setOnlyDevice(OnlyDevice onlyDevice) {
        this.onlyDevice = onlyDevice;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getBssid() {
        return bssid;
    }

    public void setBssid(String bssid) {
        this.bssid = bssid;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public String get_switch() {
        return _switch;
    }

    public void set_switch(String _switch) {
        this._switch = _switch;
    }

    public String getSubDevId() {
        return subDevId;
    }

    public void setSubDevId(String subDevId) {
        this.subDevId = subDevId;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getTrigTime() {
        return trigTime;
    }

    public void setTrigTime(String trigTime) {
        this.trigTime = trigTime;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @Override
    public String toString() {
        return "Params{" +
                "bindInfos=" + bindInfos +
                ", sledOnline='" + sledOnline + '\'' +
                ", _switch='" + _switch + '\'' +
                ", power='" + power + '\'' +
                ", voltage='" + voltage + '\'' +
                ", current='" + current + '\'' +
                ", fwVersion='" + fwVersion + '\'' +
                ", staMac='" + staMac + '\'' +
                ", rssi=" + rssi +
                ", init=" + init +
                ", alarmType='" + alarmType + '\'' +
                ", alarmVValue=" + alarmVValue +
                ", alarmCValue=" + alarmCValue +
                ", alarmPValue=" + alarmPValue +
                ", oneKwh='" + oneKwh + '\'' +
                ", uiActive=" + uiActive +
                ", timeZone=" + timeZone +
                ", version=" + version +
                ", startup='" + startup + '\'' +
                ", pulse='" + pulse + '\'' +
                ", pulseWidth=" + pulseWidth +
                ", timers=" + timers +
                ", hundredDaysKwh='" + hundredDaysKwh + '\'' +
                ", onlyDevice=" + onlyDevice +
                ", ssid='" + ssid + '\'' +
                ", bssid='" + bssid + '\'' +
                ", endTime='" + endTime + '\'' +
                ", startTime='" + startTime + '\'' +
                ", subDevId='" + subDevId + '\'' +
                ", parentid='" + parentid + '\'' +
                ", battery='" + battery + '\'' +
                ", trigTime='" + trigTime + '\'' +
                ", temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
