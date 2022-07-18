package com.example.and05_framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_img1, btn_img2;
    ImageView imgv1, imgv2, imgv3 ;
    ImageView imgv[] = new ImageView[3];
    String var ;
    int i = 0;

    //teacher's
    ArrayList<ImageView> list = new ArrayList<>();
    int flag = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_img1 = findViewById(R.id.btn_img1);
        btn_img2 = findViewById(R.id.btn_img2);
        imgv1 = findViewById(R.id.imgv1);
        imgv2 = findViewById(R.id.imgv2);
        imgv3 = findViewById(R.id.imgv3);

        list.add(imgv1);
        list.add(imgv2);
        list.add(imgv3);

        imgv = new ImageView[]{findViewById(R.id.imgv1), findViewById(R.id.imgv2), findViewById(R.id.imgv3)};

        var = "put things after connecting setContentView design";

        btn_img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                while(true) {
//                    ++i;
//                    if (i == 1) {
//                        imgv3.setVisibility(View.GONE);
//                        break;
//                    } else if (i == 2) {
//                        imgv2.setVisibility(View.GONE);
//                        break;
//                    } else if (i == 3) {
//                        imgv3.setVisibility(View.VISIBLE);
//                        imgv2.setVisibility(View.VISIBLE);
//                        break;
//                    } else if (i == 4) {
//                        i = 0;
//                        continue;
//                    }//if
//                }//while

                i++;
//                if (i == 1 || i == 4) {
//                    //2가 보임
//                    imgv3.setVisibility(View.GONE);
//                    imgv2.setVisibility(View.VISIBLE);
//                    i = 1;
//                } else if (i == 2) {
//                    //1이 보임
//                    imgv3.setVisibility(View.GONE);
//                    imgv2.setVisibility(View.GONE);
//                } else if (i == 3) {
//                    //3이 보임
//                    imgv3.setVisibility(View.VISIBLE);
//                    imgv2.setVisibility(View.VISIBLE);
//                    i = 0;
//                }//if
                if (i == 1 || i == 4) {
                    //2가 보임
                    imgv[2].setVisibility(View.GONE);
                    imgv[1].setVisibility(View.VISIBLE);
                    i = 1;
                } else if (i == 2) {
                    //1이 보임
                    imgv[2].setVisibility(View.GONE);
                    imgv[1].setVisibility(View.GONE);
                } else if (i == 3) {
                    //3이 보임
                    imgv[2].setVisibility(View.VISIBLE);
                    imgv[1].setVisibility(View.VISIBLE);
                    i = 0;
                }//if
            }//onclick
        });

        btn_img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i--;
//                if(i==0){
//                    //3이 보임
//                    imgv3.setVisibility(View.VISIBLE);
//                    imgv2.setVisibility(View.VISIBLE);
//                    i=3;
//                } else if (i == 1) {
//                    //2가 보임
//                    imgv3.setVisibility(View.GONE);
//                    imgv2.setVisibility(View.VISIBLE);
//                } else if (i == 2 || i==-1) {
//                    //1이 보임
//                    imgv3.setVisibility(View.GONE);
//                    imgv2.setVisibility(View.GONE);
//                    i=2;
//                }//if
                if(i==0){
                    //3이 보임
                    imgv[2].setVisibility(View.VISIBLE);
                    imgv[1].setVisibility(View.VISIBLE);
                    i=3;
                } else if (i == 1) {
                    //2가 보임
                    imgv[2].setVisibility(View.GONE);
                    imgv[1].setVisibility(View.VISIBLE);
                } else if (i == 2 || i==-1) {
                    //1이 보임
                    imgv[2].setVisibility(View.GONE);
                    imgv[1].setVisibility(View.GONE);
                    i=2;
                }//if
            }//onclick;
        });
    }

    public void imbvv(){
        imgv[2].setVisibility(View.GONE);
        imgv[1].setVisibility(View.GONE);
        imgv[0].setVisibility(View.GONE);


        
    }//메서드

    //==========================2번 방법==========================
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_img1){
            flag ++ ;

        }else{
            flag -- ;


        }

        setImageGone();
        if(flag>2) flag = 0;
        else if(flag<0) flag = 2;
    }
    public void setImageGone(){
        for (int i = 0 ; i<list.size() ; i ++){
            list.get(i).setVisibility(View.GONE);
        }
        list.get(flag).setVisibility(View.VISIBLE);
    }

//==========================1번 방법==========================


 /*   @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_img1){
            flag ++ ;
            if(flag <=4 ) flag = 1;
            setImageGone();
        }else{
            flag -- ;
            if(flag <=0 ) flag = 3;
            setImageGone();
        }
    }*/

   /* public void setImageGone() {
        imgv1.setVisibility(View.GONE);
        imgv2.setVisibility(View.GONE);
        imgv3.setVisibility(View.GONE);

        if (flag == 1) {
            imgv1.setVisibility(View.VISIBLE);
        } else if (flag == 2) {
            imgv2.setVisibility(View.VISIBLE);
        } else if (flag == 3) {
            imgv3.setVisibility(View.VISIBLE);
        }
    }*/
    //==========================1번 방법==========================
}