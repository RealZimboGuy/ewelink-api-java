
package com.github.realzimboguy.ewelink.api.model.login;

import java.util.HashMap;
import java.util.Map;

public class Extra {

    private String ipCountry;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getIpCountry() {
        return ipCountry;
    }

    public void setIpCountry(String ipCountry) {
        this.ipCountry = ipCountry;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
