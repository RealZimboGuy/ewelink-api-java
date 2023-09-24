
package com.github.realzimboguy.ewelink.api.model.home;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Family__1 {

    @SerializedName("familyid")
    @Expose
    private String familyid;
    @SerializedName("index")
    @Expose
    private Integer index;

    public String getFamilyid() {
        return familyid;
    }

    public void setFamilyid(String familyid) {
        this.familyid = familyid;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

}
