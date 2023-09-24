package com.github.realzimboguy.ewelink.api.model.login;

public class LoginRequest {

    private String lang;
    private String countryCode;
    private String email;
    private String password;
    private String os;
    private String model;
    private String romVersion;
    private String appVersion;

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRomVersion() {
        return romVersion;
    }

    public void setRomVersion(String romVersion) {
        this.romVersion = romVersion;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "lang='" + lang + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", os='" + os + '\'' +
                ", model='" + model + '\'' +
                ", romVersion='" + romVersion + '\'' +
                ", appVersion='" + appVersion + '\'' +
                '}';
    }
}
