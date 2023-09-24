
package com.github.realzimboguy.ewelink.api.model.home;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Do {

    @SerializedName("switch")
    @Expose
    private String _switch;

    public String getSwitch() {
        return _switch;
    }

    public void setSwitch(String _switch) {
        this._switch = _switch;
    }

}
