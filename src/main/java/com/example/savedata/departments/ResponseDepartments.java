package com.example.savedata.departments;

import com.google.gson.annotations.SerializedName;

public class ResponseDepartments {
    @SerializedName("data")
    DepartmentResponseData[] data;

    @SerializedName("success")
    boolean success;
}
class DepartmentResponseData {

    @SerializedName("id")
    public String id;

    @SerializedName("address")
    public String address;

    @SerializedName("boss")
    public String boss;

    @SerializedName("name")
    public String name;

    @SerializedName("phone")
    public String phone;

    @SerializedName("email")
    public String email;

    @SerializedName("description")
    public String description;

    @SerializedName("coords")
    public String coords;
}
