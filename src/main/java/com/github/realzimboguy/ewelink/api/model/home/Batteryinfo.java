
package com.github.realzimboguy.ewelink.api.model.home;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Batteryinfo {

    @SerializedName("battery_voltage")
    @Expose
    private Integer batteryVoltage;
    @SerializedName("battery_health")
    @Expose
    private String batteryHealth;
    @SerializedName("battery_value")
    @Expose
    private Integer batteryValue;
    @SerializedName("battery_temperature")
    @Expose
    private Integer batteryTemperature;
    @SerializedName("battery_status")
    @Expose
    private String batteryStatus;

    public Integer getBatteryVoltage() {
        return batteryVoltage;
    }

    public void setBatteryVoltage(Integer batteryVoltage) {
        this.batteryVoltage = batteryVoltage;
    }

    public String getBatteryHealth() {
        return batteryHealth;
    }

    public void setBatteryHealth(String batteryHealth) {
        this.batteryHealth = batteryHealth;
    }

    public Integer getBatteryValue() {
        return batteryValue;
    }

    public void setBatteryValue(Integer batteryValue) {
        this.batteryValue = batteryValue;
    }

    public Integer getBatteryTemperature() {
        return batteryTemperature;
    }

    public void setBatteryTemperature(Integer batteryTemperature) {
        this.batteryTemperature = batteryTemperature;
    }

    public String getBatteryStatus() {
        return batteryStatus;
    }

    public void setBatteryStatus(String batteryStatus) {
        this.batteryStatus = batteryStatus;
    }

}
