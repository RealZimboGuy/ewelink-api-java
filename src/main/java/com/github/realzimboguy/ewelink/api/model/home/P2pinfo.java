
package com.github.realzimboguy.ewelink.api.model.home;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class P2pinfo {

    @SerializedName("apilicense")
    @Expose
    private String apilicense;
    @SerializedName("did")
    @Expose
    private String did;
    @SerializedName("crc")
    @Expose
    private String crc;
    @SerializedName("passwd")
    @Expose
    private String passwd;
    @SerializedName("imei")
    @Expose
    private String imei;

    public String getApilicense() {
        return apilicense;
    }

    public void setApilicense(String apilicense) {
        this.apilicense = apilicense;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getCrc() {
        return crc;
    }

    public void setCrc(String crc) {
        this.crc = crc;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

}
