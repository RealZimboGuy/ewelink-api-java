
package com.github.realzimboguy.ewelink.api.model.home;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Family {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("apikey")
    @Expose
    private String apikey;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("index")
    @Expose
    private Integer index;
    @SerializedName("roomList")
    @Expose
    private List<Room> roomList;
    @SerializedName("familyType")
    @Expose
    private Integer familyType;
    @SerializedName("members")
    @Expose
    private List<Object> members;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public Integer getFamilyType() {
        return familyType;
    }

    public void setFamilyType(Integer familyType) {
        this.familyType = familyType;
    }

    public List<Object> getMembers() {
        return members;
    }

    public void setMembers(List<Object> members) {
        this.members = members;
    }

}
