
package com.github.realzimboguy.ewelink.api.model.home;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Tags {

    @SerializedName("m_ac4b_bret")
    @Expose
    private String mAc4bBret;
    @SerializedName("disable_timers")
    @Expose
    private List<DisableTimer> disableTimers;
    @SerializedName("deviceIconType")
    @Expose
    private Integer deviceIconType;

    public String getmAc4bBret() {
        return mAc4bBret;
    }

    public void setmAc4bBret(String mAc4bBret) {
        this.mAc4bBret = mAc4bBret;
    }

    public List<DisableTimer> getDisableTimers() {
        return disableTimers;
    }

    public void setDisableTimers(List<DisableTimer> disableTimers) {
        this.disableTimers = disableTimers;
    }

    public Integer getDeviceIconType() {
        return deviceIconType;
    }

    public void setDeviceIconType(Integer deviceIconType) {
        this.deviceIconType = deviceIconType;
    }

}
