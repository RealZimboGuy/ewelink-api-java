
package com.github.realzimboguy.ewelink.api.wss.wssrsp;

import java.util.HashMap;
import java.util.Map;

public class Config {

    private Integer hb;
    private Integer hbInterval;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getHb() {
        return hb;
    }

    public void setHb(Integer hb) {
        this.hb = hb;
    }

    public Integer getHbInterval() {
        return hbInterval;
    }

    public void setHbInterval(Integer hbInterval) {
        this.hbInterval = hbInterval;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Config{" +
                "hb=" + hb +
                ", hbInterval=" + hbInterval +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
