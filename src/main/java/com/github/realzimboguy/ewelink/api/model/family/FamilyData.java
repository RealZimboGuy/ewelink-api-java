
package com.github.realzimboguy.ewelink.api.model.family;


import com.github.realzimboguy.ewelink.api.model.home.Family;
import com.github.realzimboguy.ewelink.api.model.home.FamilyInfo;
import com.github.realzimboguy.ewelink.api.model.home.Thing;
import com.github.realzimboguy.ewelink.api.model.home.ThingInfo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class FamilyData {


    @SerializedName("familyList")
    @Expose
    private List<Family> familyList;

    public List<Family> getFamilyList() {

        return familyList;
    }

    public void setFamilyList(List<Family> familyList) {

        this.familyList = familyList;
    }

}
