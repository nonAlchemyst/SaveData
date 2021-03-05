package com.example.savedata.test;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestResponse{

    @SerializedName("userId")
    @Expose
    private Integer userId;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("body")
    @Expose
    private String body;

    public TestResponse(Integer userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }
}
