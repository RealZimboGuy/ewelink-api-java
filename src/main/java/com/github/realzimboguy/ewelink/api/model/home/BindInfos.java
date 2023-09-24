
package com.github.realzimboguy.ewelink.api.model.home;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class BindInfos {

    @SerializedName("alexa")
    @Expose
    private List<String> alexa;
    @SerializedName("gaction")
    @Expose
    private List<String> gaction;

    public List<String> getAlexa() {
        return alexa;
    }

    public void setAlexa(List<String> alexa) {
        this.alexa = alexa;
    }

    public List<String> getGaction() {
        return gaction;
    }

    public void setGaction(List<String> gaction) {
        this.gaction = gaction;
    }

}
