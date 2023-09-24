
package com.github.realzimboguy.ewelink.api.model.login;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class User {

    @SerializedName("timezone")
    @Expose
    private Timezone timezone;
    @SerializedName("accountLevel")
    @Expose
    private Integer accountLevel;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("apikey")
    @Expose
    private String apikey;
    @SerializedName("accountConsult")
    @Expose
    private Boolean accountConsult;
    @SerializedName("appForumEnterHide")
    @Expose
    private Boolean appForumEnterHide;
    @SerializedName("appVersion")
    @Expose
    private String appVersion;
    @SerializedName("denyRecharge")
    @Expose
    private Boolean denyRecharge;
    @SerializedName("ipCountry")
    @Expose
    private String ipCountry;

    public Timezone getTimezone() {
        return timezone;
    }

    public void setTimezone(Timezone timezone) {
        this.timezone = timezone;
    }

    public Integer getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(Integer accountLevel) {
        this.accountLevel = accountLevel;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public Boolean getAccountConsult() {
        return accountConsult;
    }

    public void setAccountConsult(Boolean accountConsult) {
        this.accountConsult = accountConsult;
    }

    public Boolean getAppForumEnterHide() {
        return appForumEnterHide;
    }

    public void setAppForumEnterHide(Boolean appForumEnterHide) {
        this.appForumEnterHide = appForumEnterHide;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public Boolean getDenyRecharge() {
        return denyRecharge;
    }

    public void setDenyRecharge(Boolean denyRecharge) {
        this.denyRecharge = denyRecharge;
    }

    public String getIpCountry() {
        return ipCountry;
    }

    public void setIpCountry(String ipCountry) {
        this.ipCountry = ipCountry;
    }

}
