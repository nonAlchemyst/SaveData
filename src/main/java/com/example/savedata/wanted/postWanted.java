package com.example.savedata.wanted;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface postWanted {
    @POST("api/criminal_case")
    Call<ResponseWantedPost> postCases(@Header("user_id") String user_id, @Header("token")String token,
                                   @Query("id")             String id,
                                   @Query("category")       String category,
                                   @Query("detective")      String detective,
                                   @Query("client")         String client,
                                   @Query("number")         String number,
                                   @Query("description")    String description,
                                   @Query("create_date")    String create_date);
}
