
package com.github.realzimboguy.ewelink.api.model.login;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Data {

    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("at")
    @Expose
    private String at;
    @SerializedName("rt")
    @Expose
    private String rt;
    @SerializedName("region")
    @Expose
    private String region;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

}
