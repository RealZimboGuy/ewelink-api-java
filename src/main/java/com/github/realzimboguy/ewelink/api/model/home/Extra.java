
package com.github.realzimboguy.ewelink.api.model.home;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Extra {

    @SerializedName("uiid")
    @Expose
    private Integer uiid;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("brandId")
    @Expose
    private String brandId;
    @SerializedName("apmac")
    @Expose
    private String apmac;
    @SerializedName("mac")
    @Expose
    private String mac;
    @SerializedName("ui")
    @Expose
    private String ui;
    @SerializedName("modelInfo")
    @Expose
    private String modelInfo;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("manufacturer")
    @Expose
    private String manufacturer;
    @SerializedName("staMac")
    @Expose
    private String staMac;
    @SerializedName("chipid")
    @Expose
    private String chipid;

    public Integer getUiid() {
        return uiid;
    }

    public void setUiid(Integer uiid) {
        this.uiid = uiid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getApmac() {
        return apmac;
    }

    public void setApmac(String apmac) {
        this.apmac = apmac;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getUi() {
        return ui;
    }

    public void setUi(String ui) {
        this.ui = ui;
    }

    public String getModelInfo() {
        return modelInfo;
    }

    public void setModelInfo(String modelInfo) {
        this.modelInfo = modelInfo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getStaMac() {
        return staMac;
    }

    public void setStaMac(String staMac) {
        this.staMac = staMac;
    }

    public String getChipid() {
        return chipid;
    }

    public void setChipid(String chipid) {
        this.chipid = chipid;
    }

    @Override
    public String toString() {
        return "Extra{" +
                "uiid=" + uiid +
                ", description='" + description + '\'' +
                ", brandId='" + brandId + '\'' +
                ", apmac='" + apmac + '\'' +
                ", mac='" + mac + '\'' +
                ", ui='" + ui + '\'' +
                ", modelInfo='" + modelInfo + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", staMac='" + staMac + '\'' +
                ", chipid='" + chipid + '\'' +
                '}';
    }
}
