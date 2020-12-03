
package com.github.realzimboguy.ewelink.api.model.devices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeviceItem {

    private int error;
    private int msg;
    private Settings settings;
    private Family family;
    private String group;
    private Boolean online;
    private List<Object> shareUsersInfo = null;
    private List<Object> groups = null;
    private List<Object> devGroups = null;
    private String id;
    private String name;
    private String type;
    private String deviceid;
    private String apikey;
    private Extra extra;
    private Params params;
    private String createdAt;
    private Integer v;
    private String onlineTime;
    private String ip;
    private String location;
    private String offlineTime;
    private String deviceStatus;
    private Tags tags;
    private List<Object> sharedTo = null;
    private String devicekey;
    private String deviceUrl;
    private String brandName;
    private Boolean showBrand;
    private String brandLogoUrl;
    private String productModel;
    private DevConfig devConfig;
    private Integer uiid;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public List<Object> getShareUsersInfo() {
        return shareUsersInfo;
    }

    public void setShareUsersInfo(List<Object> shareUsersInfo) {
        this.shareUsersInfo = shareUsersInfo;
    }

    public List<Object> getGroups() {
        return groups;
    }

    public void setGroups(List<Object> groups) {
        this.groups = groups;
    }

    public List<Object> getDevGroups() {
        return devGroups;
    }

    public void setDevGroups(List<Object> devGroups) {
        this.devGroups = devGroups;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public String getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(String onlineTime) {
        this.onlineTime = onlineTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOfflineTime() {
        return offlineTime;
    }

    public void setOfflineTime(String offlineTime) {
        this.offlineTime = offlineTime;
    }

    public String getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }

    public List<Object> getSharedTo() {
        return sharedTo;
    }

    public void setSharedTo(List<Object> sharedTo) {
        this.sharedTo = sharedTo;
    }

    public String getDevicekey() {
        return devicekey;
    }

    public void setDevicekey(String devicekey) {
        this.devicekey = devicekey;
    }

    public String getDeviceUrl() {
        return deviceUrl;
    }

    public void setDeviceUrl(String deviceUrl) {
        this.deviceUrl = deviceUrl;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Boolean getShowBrand() {
        return showBrand;
    }

    public void setShowBrand(Boolean showBrand) {
        this.showBrand = showBrand;
    }

    public String getBrandLogoUrl() {
        return brandLogoUrl;
    }

    public void setBrandLogoUrl(String brandLogoUrl) {
        this.brandLogoUrl = brandLogoUrl;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public DevConfig getDevConfig() {
        return devConfig;
    }

    public void setDevConfig(DevConfig devConfig) {
        this.devConfig = devConfig;
    }

    public Integer getUiid() {
        return uiid;
    }

    public void setUiid(Integer uiid) {
        this.uiid = uiid;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public int getMsg() {
        return msg;
    }

    public void setMsg(int msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "DeviceItem{" +
                "error=" + error +
                ", msg=" + msg +
                ", settings=" + settings +
                ", family=" + family +
                ", group='" + group + '\'' +
                ", online=" + online +
                ", shareUsersInfo=" + shareUsersInfo +
                ", groups=" + groups +
                ", devGroups=" + devGroups +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", deviceid='" + deviceid + '\'' +
                ", apikey='" + apikey + '\'' +
                ", extra=" + extra +
                ", params=" + params +
                ", createdAt='" + createdAt + '\'' +
                ", v=" + v +
                ", onlineTime='" + onlineTime + '\'' +
                ", ip='" + ip + '\'' +
                ", location='" + location + '\'' +
                ", offlineTime='" + offlineTime + '\'' +
                ", deviceStatus='" + deviceStatus + '\'' +
                ", tags=" + tags +
                ", sharedTo=" + sharedTo +
                ", devicekey='" + devicekey + '\'' +
                ", deviceUrl='" + deviceUrl + '\'' +
                ", brandName='" + brandName + '\'' +
                ", showBrand=" + showBrand +
                ", brandLogoUrl='" + brandLogoUrl + '\'' +
                ", productModel='" + productModel + '\'' +
                ", devConfig=" + devConfig +
                ", uiid=" + uiid +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
