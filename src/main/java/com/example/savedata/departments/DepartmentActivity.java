package com.example.savedata.departments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.savedata.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DepartmentActivity extends AppCompatActivity{

    ListView depList;
    Button getDepartment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);
        getDepartments();
        depList = findViewById(R.id.departmentsList);
    }

    void getDepartments(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mad2019.hakta.pro/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Departments service = retrofit.create(Departments.class);
        Call<ResponseDepartments> responseDataCall = service.getDepartments();
        responseDataCall.enqueue(new Callback<ResponseDepartments>() {
            @Override
            public void onResponse(Call<ResponseDepartments> call, Response<ResponseDepartments> response) {
                if(response.body().success){
                    fillList(response.body().data);
                }
            }

            @Override
            public void onFailure(Call<ResponseDepartments> call, Throwable throwable) {
                Toast.makeText(DepartmentActivity.this, "Something is wrong with internet connect", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void fillList(DepartmentResponseData[] data) {
        DepartmentsListAdapter adapter = new DepartmentsListAdapter(this, R.layout.departments_item, data);
        depList.setAdapter(adapter);
    }

}
