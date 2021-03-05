package com.example.savedata.wanted;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Wanted {

    @GET("api/criminal_case/")
    Call<ResponseWanted> getWanted(@Header("user_id") String user_id, @Header("token")String token);
}
