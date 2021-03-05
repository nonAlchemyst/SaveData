package com.example.savedata;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.savedata.wanted.ResponseWanted;
import com.example.savedata.wanted.ResponseWantedPost;
import com.example.savedata.wanted.Wanted;
import com.example.savedata.wanted.WantedActivity;
import com.example.savedata.wanted.WantedListAdapter;
import com.example.savedata.wanted.WantedResponseData;
import com.example.savedata.wanted.postWanted;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class criminal_case_fragment extends Fragment {

    Button getCriminalCase, postCriminalCase, post;
    ListView crimList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_criminal_case_fragment, container, false);


        getCriminalCase = view.findViewById(R.id.getCriminalCase);
        getCriminalCase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCriminalCase();
            }
        });
        postCriminalCase = view.findViewById(R.id.postCriminalCase);
        postCriminalCase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CardView) view.findViewById(R.id.postCard)).setVisibility(View.VISIBLE);
            }
        });
        post = view.findViewById(R.id.post);
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CardView) view.findViewById(R.id.postCard)).setVisibility(View.GONE);
                postCriminalCase();
            }
        });

        crimList = view.findViewById(R.id.criminalList);

        return view;
    }


    void getCriminalCase(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mad2019.hakta.pro/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Wanted service = retrofit.create(Wanted.class);
        Call<ResponseWanted> responseDataCall = service.getWanted(Global.loginData.getId(), Global.loginData.getToken());
        responseDataCall.enqueue(new Callback<ResponseWanted>() {
            @Override
            public void onResponse(Call<ResponseWanted> call, Response<ResponseWanted> response) {
                if(response.code() != 200) return;
                if(response.body().success){
                    fillList(response.body().data);
                }
            }

            @Override
            public void onFailure(Call<ResponseWanted> call, Throwable throwable) {
                Toast.makeText(getContext(), "Something is wrong with internet connect", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void postCriminalCase(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mad2019.hakta.pro/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        postWanted service = retrofit.create(postWanted.class);
        Call<ResponseWantedPost> responseDataCall = service.postCases(Global.loginData.getId(), Global.loginData.getToken(), "321", "CategoryNULL", "123","11","11","","");
        responseDataCall.enqueue(new Callback<ResponseWantedPost>() {
            @Override
            public void onResponse(Call<ResponseWantedPost> call, Response<ResponseWantedPost> response) {
                //if(response.code() != 200) return;
                Toast.makeText(getContext(), "Работает", Toast.LENGTH_SHORT).show();
                Log.d("message",response.body().data.toString());
            }

            @Override
            public void onFailure(Call<ResponseWantedPost> call, Throwable throwable) {
                Toast.makeText(getContext(), "Something is wrong with internet connect", Toast.LENGTH_SHORT).show();
            }
        });


/*
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mad2019.hakta.pro/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TestResponse testResponse = new TestResponse(11, "How to post", "Rabotaet");
        postJsonplaceholder service = retrofit.create(postJsonplaceholder.class);
        Call<ResponseTest> responseTestCall = service.post("Content-type': 'application/json; charset=UTF-8", testResponse);
        responseTestCall.enqueue(new Callback<ResponseTest>() {
            @Override
            public void onResponse(Call<ResponseTest> call, Response<ResponseTest> response) {
                Toast.makeText(WantedActivity.this, "Работает", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseTest> call, Throwable throwable) {
                Toast.makeText(WantedActivity.this, "not Работает", Toast.LENGTH_SHORT).show();
            }
        });
*/
    }



    void fillList(WantedResponseData[] data) {
        WantedListAdapter adapter = new WantedListAdapter(getContext(), R.layout.wanted_criminal_items, data);
        crimList.setAdapter(adapter);
    }
}