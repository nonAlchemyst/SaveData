package com.example.savedata.test;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;

public class ResponseTest{

    @SerializedName("userId")
    @Expose
    public Integer userId;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("body")
    @Expose
    public String body;


}







