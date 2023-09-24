
package com.github.realzimboguy.ewelink.api.model.home;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Thing {

    @SerializedName("itemType")
    @Expose
    private Integer itemType;
    @SerializedName("itemData")
    @Expose
    private ItemData itemData;
    @SerializedName("index")
    @Expose
    private Integer index;

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public ItemData getItemData() {
        return itemData;
    }

    public void setItemData(ItemData itemData) {
        this.itemData = itemData;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Thing{" +
                "itemType=" + itemType +
                ", itemData=" + itemData +
                ", index=" + index +
                '}';
    }
}
