package com.example.and09_layoutinflater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity{
    Button btn_inflate; // 레이아웃 인플레이션 ( 자바 <-> xml ) 연결이 되고나서 최기화를 시킬 수 있다 ( 디자인에 있는 위젯을 연결 findViewById )
    // 인터페이스 ( 자바에서 어떤 객체의 사용방법을 정의해놓은 것 ) ← 설계도
    // 옵저버 패턴 ( 정의, 구현, 실행 ) 세개로 나눔
    // 정의 따로, 구현부 따로, 실행부를 따로 구현 해놓고 실행 되면 구현부를 실행

    // 자바 ← 안드로이드의 기능은 대부분 구현이 되어있음 ( == IOS )
    // 어느정도 이상의 커스터마이징은 개인정보침해나 해킹의 위험요소

    // 레이아웃 인플레이트(인플레이션 과정을 통한 화면 붙이기) 과정
    // 1. 화면이 붙을 레이아웃을 액티비티 내부에 미리 만들어 놓는다 ( 무너가를 담을 통을 마련함 )
    // 2. 화면에 붙일 레이아웃을 별도로 만든다 ( ↑ 통에 넣을 내용물을 만든다. )
    // 3. 자바코드를 이용해서 레이아웃 인플레이션 과정을 만듬 ← 프래그먼트라는 기증의 구조를 이해하기 위해서는 반드시 알아야함

    LinearLayout linear;
    RelativeLayout relative;

    Button btn_sub1;
    ImageView imgv_sub1;

    Button btn_sub2;
    ImageView imgv_sub2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_inflate = findViewById(R.id.btn_inflate);
        linear = findViewById(R.id.linear); //어디에 붙일지를 ← (null이 아니라) id를 찾아서 지정함
        LayoutInflater inflater = getLayoutInflater(); //레이아웃을 붙일 대 필요한 것, 첫번재방법
        //LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE); //두번째방법

        //LayoutInflater(기능)을 이용해서 현재 자바코드에 있는 activity_main 안쪽에
        //다른 xml(레이아웃)을 붙이는 처리

        relative = findViewById(R.id.relative);
        //LayoutInflater inflater1 = getLayoutInflater();

        btn_inflate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("태그", "하이");
                inflater.inflate(R.layout.main_sub1 , linear , true);
                btn_sub1 = findViewById(R.id.btn_sub1);

                inflater.inflate(R.layout.main_sub2, relative, true);
                btn_sub2 = findViewById(R.id.btn_sub2);


            }
        });

    }
}