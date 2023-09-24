
package com.github.realzimboguy.ewelink.api.model.home;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Timer {

    @SerializedName("mId")
    @Expose
    private String mId;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("at")
    @Expose
    private String at;
    @SerializedName("coolkit_timer_type")
    @Expose
    private String coolkitTimerType;
    @SerializedName("enabled")
    @Expose
    private Integer enabled;
    @SerializedName("do")
    @Expose
    private Do__1 _do;

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public String getCoolkitTimerType() {
        return coolkitTimerType;
    }

    public void setCoolkitTimerType(String coolkitTimerType) {
        this.coolkitTimerType = coolkitTimerType;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Do__1 getDo() {
        return _do;
    }

    public void setDo(Do__1 _do) {
        this._do = _do;
    }

}
