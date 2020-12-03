package com.github.realzimboguy.ewelink.api.model;

import com.google.gson.annotations.SerializedName;

public class Param {

    @SerializedName("switch")
    private String switchValue;

    public String getSwitchValue() {
        return switchValue;
    }

    public void setSwitchValue(String switchValue) {
        this.switchValue = switchValue;
    }

    @Override
    public String toString() {
        return "Param{" +
                "switchValue='" + switchValue + '\'' +
                '}';
    }
}
