
package com.github.realzimboguy.ewelink.api.model.family;


import com.github.realzimboguy.ewelink.api.model.home.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class FamilyPage {

    @SerializedName("error")
    @Expose
    private Integer error;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("data")
    @Expose
    private FamilyData   data;

    @Override
    public String toString() {
        return "FamilyPage{" +
                "error=" + error +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public FamilyData getData() {
        return data;
    }

    public void setData(FamilyData data) {
        this.data = data;
    }

}
