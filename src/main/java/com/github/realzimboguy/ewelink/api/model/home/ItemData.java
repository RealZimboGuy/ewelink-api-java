
package com.github.realzimboguy.ewelink.api.model.home;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ItemData {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("deviceid")
    @Expose
    private String deviceid;
    @SerializedName("apikey")
    @Expose
    private String apikey;
    @SerializedName("extra")
    @Expose
    private Extra extra;
    @SerializedName("brandName")
    @Expose
    private String brandName;
    @SerializedName("brandLogo")
    @Expose
    private String brandLogo;
    @SerializedName("showBrand")
    @Expose
    private Boolean showBrand;
    @SerializedName("productModel")
    @Expose
    private String productModel;
    @SerializedName("tags")
    @Expose
    private Tags tags;
    @SerializedName("devConfig")
    @Expose
    private DevConfig devConfig;
    @SerializedName("settings")
    @Expose
    private Settings settings;
    @SerializedName("devGroups")
    @Expose
    private List<Object> devGroups;
    @SerializedName("family")
    @Expose
    private Family__1 family;
    @SerializedName("shareTo")
    @Expose
    private List<Object> shareTo;
    @SerializedName("devicekey")
    @Expose
    private String devicekey;
    @SerializedName("online")
    @Expose
    private Boolean online;
    @SerializedName("params")
    @Expose
    private Params params;
    @SerializedName("isSupportGroup")
    @Expose
    private Boolean isSupportGroup;
    @SerializedName("isSupportedOnMP")
    @Expose
    private Boolean isSupportedOnMP;
    @SerializedName("isSupportChannelSplit")
    @Expose
    private Boolean isSupportChannelSplit;
    @SerializedName("deviceFeature")
    @Expose
    private DeviceFeature deviceFeature;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }

    public Boolean getShowBrand() {
        return showBrand;
    }

    public void setShowBrand(Boolean showBrand) {
        this.showBrand = showBrand;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }

    public DevConfig getDevConfig() {
        return devConfig;
    }

    public void setDevConfig(DevConfig devConfig) {
        this.devConfig = devConfig;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public List<Object> getDevGroups() {
        return devGroups;
    }

    public void setDevGroups(List<Object> devGroups) {
        this.devGroups = devGroups;
    }

    public Family__1 getFamily() {
        return family;
    }

    public void setFamily(Family__1 family) {
        this.family = family;
    }

    public List<Object> getShareTo() {
        return shareTo;
    }

    public void setShareTo(List<Object> shareTo) {
        this.shareTo = shareTo;
    }

    public String getDevicekey() {
        return devicekey;
    }

    public void setDevicekey(String devicekey) {
        this.devicekey = devicekey;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    public Boolean getIsSupportGroup() {
        return isSupportGroup;
    }

    public void setIsSupportGroup(Boolean isSupportGroup) {
        this.isSupportGroup = isSupportGroup;
    }

    public Boolean getIsSupportedOnMP() {
        return isSupportedOnMP;
    }

    public void setIsSupportedOnMP(Boolean isSupportedOnMP) {
        this.isSupportedOnMP = isSupportedOnMP;
    }

    public Boolean getIsSupportChannelSplit() {
        return isSupportChannelSplit;
    }

    public void setIsSupportChannelSplit(Boolean isSupportChannelSplit) {
        this.isSupportChannelSplit = isSupportChannelSplit;
    }

    public DeviceFeature getDeviceFeature() {
        return deviceFeature;
    }

    public void setDeviceFeature(DeviceFeature deviceFeature) {
        this.deviceFeature = deviceFeature;
    }


    @Override
    public String toString() {
        return "ItemData{" +
                "name='" + name + '\'' +
                ", deviceid='" + deviceid + '\'' +
                ", apikey='" + apikey + '\'' +
                ", extra=" + extra +
                ", brandName='" + brandName + '\'' +
                ", brandLogo='" + brandLogo + '\'' +
                ", showBrand=" + showBrand +
                ", productModel='" + productModel + '\'' +
                ", tags=" + tags +
                ", devConfig=" + devConfig +
                ", settings=" + settings +
                ", devGroups=" + devGroups +
                ", family=" + family +
                ", shareTo=" + shareTo +
                ", devicekey='" + devicekey + '\'' +
                ", online=" + online +
                ", params=" + params +
                ", isSupportGroup=" + isSupportGroup +
                ", isSupportedOnMP=" + isSupportedOnMP +
                ", isSupportChannelSplit=" + isSupportChannelSplit +
                ", deviceFeature=" + deviceFeature +
                '}';
    }
}
