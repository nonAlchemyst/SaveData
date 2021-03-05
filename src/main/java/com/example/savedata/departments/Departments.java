package com.example.savedata.departments;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Departments {
    @GET("/api/department/")
    Call<ResponseDepartments> getDepartments();
}
