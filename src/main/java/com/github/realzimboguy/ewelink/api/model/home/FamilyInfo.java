
package com.github.realzimboguy.ewelink.api.model.home;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class FamilyInfo {

    @SerializedName("familyList")
    @Expose
    private List<Family> familyList;
    @SerializedName("currentFamilyId")
    @Expose
    private String currentFamilyId;
    @SerializedName("hasChangedCurrentFamily")
    @Expose
    private Boolean hasChangedCurrentFamily;

    @Override
    public String toString() {
        return "FamilyInfo{" +
                "familyList=" + familyList +
                ", currentFamilyId='" + currentFamilyId + '\'' +
                ", hasChangedCurrentFamily=" + hasChangedCurrentFamily +
                '}';
    }

    public List<Family> getFamilyList() {
        return familyList;
    }

    public void setFamilyList(List<Family> familyList) {
        this.familyList = familyList;
    }

    public String getCurrentFamilyId() {
        return currentFamilyId;
    }

    public void setCurrentFamilyId(String currentFamilyId) {
        this.currentFamilyId = currentFamilyId;
    }

    public Boolean getHasChangedCurrentFamily() {
        return hasChangedCurrentFamily;
    }

    public void setHasChangedCurrentFamily(Boolean hasChangedCurrentFamily) {
        this.hasChangedCurrentFamily = hasChangedCurrentFamily;
    }

}
