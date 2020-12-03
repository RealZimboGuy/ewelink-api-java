
package com.github.realzimboguy.ewelink.api.model.devices;

import java.util.HashMap;
import java.util.Map;

public class DevConfig {

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "DevConfig{" +
                "additionalProperties=" + additionalProperties +
                '}';
    }
}
