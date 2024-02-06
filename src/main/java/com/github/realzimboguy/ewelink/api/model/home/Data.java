
package com.github.realzimboguy.ewelink.api.model.home;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Data {

    @SerializedName("familyInfo")
    @Expose
    private FamilyInfo familyInfo;
    @SerializedName("thingInfo")
    @Expose
    private ThingInfo thingInfo;

    @SerializedName("thingList")
    @Expose
    private List<Thing> thingList;

    public List<Thing> getThingList() {

        return thingList;
    }

    public void setThingList(List<Thing> thingList) {

        this.thingList = thingList;
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

    @Override
    public String toString() {

        return "Data{" +
                "familyInfo=" + familyInfo +
                ", thingInfo=" + thingInfo +
                ", thingList=" + thingList +
                '}';
    }
}
