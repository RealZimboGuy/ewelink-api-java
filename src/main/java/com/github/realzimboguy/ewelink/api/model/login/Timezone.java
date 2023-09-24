
package com.github.realzimboguy.ewelink.api.model.login;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Timezone {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("offset")
    @Expose
    private Integer offset;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

}
