
package com.github.realzimboguy.ewelink.api.model.home;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Data {

    @SerializedName("familyInfo")
    @Expose
    private FamilyInfo familyInfo;
    @SerializedName("thingInfo")
    @Expose
    private ThingInfo thingInfo;

    @Override
    public String toString() {
        return "Data{" +
                "familyInfo=" + familyInfo +
                ", thingInfo=" + thingInfo +
                '}';
    }

    public FamilyInfo getFamilyInfo() {
        return familyInfo;
    }

    public void setFamilyInfo(FamilyInfo familyInfo) {
        this.familyInfo = familyInfo;
    }

    public ThingInfo getThingInfo() {
        return thingInfo;
    }

    public void setThingInfo(ThingInfo thingInfo) {
        this.thingInfo = thingInfo;
    }

}
