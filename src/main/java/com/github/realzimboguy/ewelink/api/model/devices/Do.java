
package com.github.realzimboguy.ewelink.api.model.devices;

import java.util.HashMap;
import java.util.Map;

public class Do {

    private String _switch;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getSwitch() {
        return _switch;
    }

    public void setSwitch(String _switch) {
        this._switch = _switch;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
