
package com.github.realzimboguy.ewelink.api.model.devices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Devices {

    private int error;
    private List<DeviceItem> devicelist = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public List<DeviceItem> getDevicelist() {
        return devicelist;
    }

    public void setDevicelist(List<DeviceItem> devicelist) {
        this.devicelist = devicelist;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "GetDevices{" +
                "error=" + error +
                ", devicelist=" + devicelist +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
