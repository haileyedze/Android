package com.example.practice_gorilla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.practice_gorilla.listview.ListFragment1;
import com.example.practice_gorilla.listview.ListFragment2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //frame 1
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new ListFragment1()).commit();

        //frame 2
        getSupportFragmentManager().beginTransaction().replace(R.id.container_2, new ListFragment2()).commit();

    }
}