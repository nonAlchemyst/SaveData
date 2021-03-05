package com.example.savedata.test;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface postJsonplaceholder {
    @POST("posts")
    Call<ResponseTest> post(@Header("Content-type") String type,@Body TestResponse testResponse);
}
