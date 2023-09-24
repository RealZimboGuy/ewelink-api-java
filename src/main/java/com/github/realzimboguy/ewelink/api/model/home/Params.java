
package com.github.realzimboguy.ewelink.api.model.home;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Params {

    @SerializedName("bindInfos")
    @Expose
    private BindInfos bindInfos;
    @SerializedName("version")
    @Expose
    private Integer version;
    @SerializedName("sledOnline")
    @Expose
    private String sledOnline;
    @SerializedName("fwVersion")
    @Expose
    private String fwVersion;
    @SerializedName("staMac")
    @Expose
    private String staMac;
    @SerializedName("rssi")
    @Expose
    private Integer rssi;
    @SerializedName("init")
    @Expose
    private Integer init;
    @SerializedName("alarmType")
    @Expose
    private String alarmType;
    @SerializedName("alarmVValue")
    @Expose
    private List<Integer> alarmVValue;
    @SerializedName("alarmCValue")
    @Expose
    private List<Integer> alarmCValue;
    @SerializedName("alarmPValue")
    @Expose
    private List<Integer> alarmPValue;
    @SerializedName("switch")
    @Expose
    private String _switch;
    @SerializedName("startup")
    @Expose
    private String startup;
    @SerializedName("pulse")
    @Expose
    private String pulse;
    @SerializedName("pulseWidth")
    @Expose
    private Integer pulseWidth;
    @SerializedName("power")
    @Expose
    private String power;
    @SerializedName("voltage")
    @Expose
    private String voltage;
    @SerializedName("current")
    @Expose
    private String current;
    @SerializedName("oneKwh")
    @Expose
    private String oneKwh;
    @SerializedName("uiActive")
    @Expose
    private Integer uiActive;
    @SerializedName("timeZone")
    @Expose
    private Integer timeZone;
    @SerializedName("only_device")
    @Expose
    private OnlyDevice onlyDevice;
    @SerializedName("ssid")
    @Expose
    private String ssid;
    @SerializedName("bssid")
    @Expose
    private String bssid;
    @SerializedName("timers")
    @Expose
    private List<Timer> timers;
    @SerializedName("hundredDaysKwh")
    @Expose
    private String hundredDaysKwh;
    @SerializedName("demNextFetchTime")
    @Expose
    private Long demNextFetchTime;
    @SerializedName("rstReason")
    @Expose
    private Integer rstReason;
    @SerializedName("exccause")
    @Expose
    private Integer exccause;
    @SerializedName("epc1")
    @Expose
    private Integer epc1;
    @SerializedName("epc2")
    @Expose
    private Integer epc2;
    @SerializedName("epc3")
    @Expose
    private Integer epc3;
    @SerializedName("excvaddr")
    @Expose
    private Integer excvaddr;
    @SerializedName("depc")
    @Expose
    private Integer depc;
    @SerializedName("p2pinfo")
    @Expose
    private P2pinfo p2pinfo;
    @SerializedName("batteryinfo")
    @Expose
    private Batteryinfo batteryinfo;
    @SerializedName("record")
    @Expose
    private Record record;
    @SerializedName("endTime")
    @Expose
    private String endTime;
    @SerializedName("startTime")
    @Expose
    private String startTime;

    public BindInfos getBindInfos() {
        return bindInfos;
    }

    public void setBindInfos(BindInfos bindInfos) {
        this.bindInfos = bindInfos;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getSledOnline() {
        return sledOnline;
    }

    public void setSledOnline(String sledOnline) {
        this.sledOnline = sledOnline;
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

    public String getSwitch() {
        return _switch;
    }

    public void setSwitch(String _switch) {
        this._switch = _switch;
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

    public Long getDemNextFetchTime() {
        return demNextFetchTime;
    }

    public void setDemNextFetchTime(Long demNextFetchTime) {
        this.demNextFetchTime = demNextFetchTime;
    }

    public Integer getRstReason() {
        return rstReason;
    }

    public void setRstReason(Integer rstReason) {
        this.rstReason = rstReason;
    }

    public Integer getExccause() {
        return exccause;
    }

    public void setExccause(Integer exccause) {
        this.exccause = exccause;
    }

    public Integer getEpc1() {
        return epc1;
    }

    public void setEpc1(Integer epc1) {
        this.epc1 = epc1;
    }

    public Integer getEpc2() {
        return epc2;
    }

    public void setEpc2(Integer epc2) {
        this.epc2 = epc2;
    }

    public Integer getEpc3() {
        return epc3;
    }

    public void setEpc3(Integer epc3) {
        this.epc3 = epc3;
    }

    public Integer getExcvaddr() {
        return excvaddr;
    }

    public void setExcvaddr(Integer excvaddr) {
        this.excvaddr = excvaddr;
    }

    public Integer getDepc() {
        return depc;
    }

    public void setDepc(Integer depc) {
        this.depc = depc;
    }

    public P2pinfo getP2pinfo() {
        return p2pinfo;
    }

    public void setP2pinfo(P2pinfo p2pinfo) {
        this.p2pinfo = p2pinfo;
    }

    public Batteryinfo getBatteryinfo() {
        return batteryinfo;
    }

    public void setBatteryinfo(Batteryinfo batteryinfo) {
        this.batteryinfo = batteryinfo;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
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

}
