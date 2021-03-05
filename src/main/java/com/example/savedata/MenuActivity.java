package com.example.savedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.savedata.departments.DepartmentActivity;
import com.example.savedata.wanted.WantedActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void OnClickPhotoRobot(View view){
        Intent intent = new Intent(this, photorobot_activity.class);
        startActivity(intent);
    }

    public void onClickDepartments(View view) {
        Intent intent = new Intent(this, DepartmentActivity.class);
        startActivity(intent);
    }

    public void onClickAboutUs(View view) {
        Intent intent = new Intent(this, AboutUs.class);
        startActivity(intent);
    }

    public void onClickPaint(View view) {
        Intent intent = new Intent(this, PaintActivity.class);
        startActivity(intent);
    }

    public void onClickWanted(View view){
        Intent intent = new Intent(this, WantedActivity.class);
        startActivity(intent);
    }
}