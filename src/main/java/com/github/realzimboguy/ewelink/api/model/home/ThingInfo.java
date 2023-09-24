
package com.github.realzimboguy.ewelink.api.model.home;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ThingInfo {

    @SerializedName("thingList")
    @Expose
    private List<Thing> thingList;
    @SerializedName("total")
    @Expose
    private Integer total;

    @Override
    public String toString() {
        return "ThingInfo{" +
                "thingList=" + thingList +
                ", total=" + total +
                '}';
    }

    public List<Thing> getThingList() {
        return thingList;
    }

    public void setThingList(List<Thing> thingList) {
        this.thingList = thingList;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
