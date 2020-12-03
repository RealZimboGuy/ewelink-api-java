
package com.github.realzimboguy.ewelink.api.model.devices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tags {

    private String mAc4bBret;
    private List<DisableTimer> disableTimers = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getMAc4bBret() {
        return mAc4bBret;
    }

    public void setMAc4bBret(String mAc4bBret) {
        this.mAc4bBret = mAc4bBret;
    }

    public List<DisableTimer> getDisableTimers() {
        return disableTimers;
    }

    public void setDisableTimers(List<DisableTimer> disableTimers) {
        this.disableTimers = disableTimers;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
