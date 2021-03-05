package com.example.savedata.wanted;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseWanted {
    @SerializedName("data")
    public WantedResponseData[] data;

    @SerializedName("success")
    public boolean success;
}

