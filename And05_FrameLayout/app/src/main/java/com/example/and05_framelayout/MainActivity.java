package com.example.and05_framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_img;
    ImageView imgv1, imgv2, imgv3 ;
    String var ;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_img = findViewById(R.id.btn_img);
        imgv1 = findViewById(R.id.imgv1);
        imgv2 = findViewById(R.id.imgv2);
        imgv3 = findViewById(R.id.imgv3);
        var = "put things after connecting setContentView design";

        btn_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                while(true) {
                    ++i;
                    if (i == 1) {
                        imgv3.setVisibility(View.GONE);
                        break;
                    } else if (i == 2) {
                        imgv2.setVisibility(View.GONE);
                        break;
                    } else if (i == 3) {
                        imgv3.setVisibility(View.VISIBLE);
                        imgv2.setVisibility(View.VISIBLE);
                        break;
                    } else if (i == 4) {
                        i = 0;
                        continue;
                    }//if
                }
            }
        });

    }

    @Override
    public void onClick(View v) {

    }
}