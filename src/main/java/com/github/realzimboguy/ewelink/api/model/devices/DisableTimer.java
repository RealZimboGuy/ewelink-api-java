
package com.github.realzimboguy.ewelink.api.model.devices;

import java.util.HashMap;
import java.util.Map;

public class DisableTimer {

    private String mId;
    private String type;
    private String at;
    private String coolkitTimerType;
    private Integer enabled;
    private Do_ _do;
    private String period;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getMId() {
        return mId;
    }

    public void setMId(String mId) {
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

    public Do_ getDo() {
        return _do;
    }

    public void setDo(Do_ _do) {
        this._do = _do;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
