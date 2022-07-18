package com.example.test001;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_img_cg, btn_scroll_cg;
    ImageView imgv1, imgv2, imgv3, scImgv1, scImgv2, scImgv3;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_img_cg = findViewById(R.id.btn_img_cg);
        btn_scroll_cg = findViewById(R.id.btn_scroll_cg);

        imgv1 = findViewById(R.id.imgv1);
        imgv2 = findViewById(R.id.imgv2);
        imgv3 = findViewById(R.id.imgv3);

        scImgv1 = findViewById(R.id.scImgv1);
        scImgv2 = findViewById(R.id.scImgv2);
        scImgv3 = findViewById(R.id.scImgv3);

        btn_img_cg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                if(i==4){
                    i=1;
                }
                imageGone();
            }
        });

        btn_scroll_cg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                if(i==4){
                    i=1;
                }
                scImageGone();
            }
        });

    }

    public void imageGone(){
        imgv1.setVisibility(View.GONE);
        imgv2.setVisibility(View.GONE);
        imgv3.setVisibility(View.GONE);

        if(i==1){
            imgv1.setVisibility(View.VISIBLE);
        }else if(i==2){
            imgv2.setVisibility(View.VISIBLE);
        }else if(i==3){
            imgv3.setVisibility(View.VISIBLE);
        }
    }

    public void scImageGone(){
        scImgv1.setVisibility(View.GONE);
        scImgv2.setVisibility(View.GONE);
        scImgv3.setVisibility(View.GONE);

        if(i==1){
            scImgv1.setVisibility(View.VISIBLE);
        }else if(i==2){
            scImgv2.setVisibility(View.VISIBLE);
        }else if(i==3){
            scImgv3.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {

    }
}