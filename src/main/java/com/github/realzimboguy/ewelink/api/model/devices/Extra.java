
package com.github.realzimboguy.ewelink.api.model.devices;

import java.util.HashMap;
import java.util.Map;

public class Extra {

    private Extra_ extra;
    private String id;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Extra_ getExtra() {
        return extra;
    }

    public void setExtra(Extra_ extra) {
        this.extra = extra;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
