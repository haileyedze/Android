package com.example.and08_resource;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.activity_teacher);
        //setContentView(R.layout.drawable_test);



        Log.d("리소스 값 : ", " " + R.string.string_ahe);
        Log.d("리소스 값 : ", " " + getString(R.string.another_ahe)); //getString 이용해야 제대로 나옴

    }
}