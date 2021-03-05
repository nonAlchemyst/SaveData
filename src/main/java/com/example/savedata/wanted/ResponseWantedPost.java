package com.example.savedata.wanted;

import com.google.gson.annotations.SerializedName;

public class ResponseWantedPost {

    @SerializedName("data")
    public Object data;

    @SerializedName("success")
    public boolean success;
}
