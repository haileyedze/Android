package com.example.and02_exlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "AHE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //안드로이드에서 디자인을 하는 방식 javaCode vs Android.xml

        //context : 현재 화면에 보여지는 객체가 어떤 것인지.
        TextView tv_name = new TextView(this);
        tv_name.setText(" A H E ");
        tv_name.setGravity(Gravity.CENTER); //추후 위젯 사용시 다시 공부 예정(정렬)

        ImageView imgv = new ImageView( this );
        imgv.setImageResource(R.drawable.ic_launcher_background);

        Button btn = new Button(this);
        btn.setText("클릭해보기");
        //위젯들이 화면에 보이기 위해서는 반드시 Layout(View → ViewGroup 상속받은 종류의 위젯이 필요함)
        //Layout이라는 것은 위젯을 어떤 식으로 정렬(위치)해서 보여질지의 규칙이 정해져있는 판

        //차곡차곡 쌓는 방식(정렬방식_ : LinearLayout 세로로 쌓을지, 가로로 쌓을지를 결정 후 위젯을 넣으면 자동으로 정렬됨
        //제약(링커, 앵커)을 두고 부모나 다른 위젯을 기준으로 해당하는 위젯의 위치를 결정하는 방식 : ConstraintLayout

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);   //추후 위젯 사용시 다시 공부할 예정(정렬)
        layout.addView(tv_name);
        layout.addView(imgv);
        layout.addView(btn);

        setContentView(layout); //← 자바로 짠 경우
        //setContentView(R.layout.activity_main); ← XML로 짠 경우

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "버튼 눌림", Toast.LENGTH_LONG).show();
                //Toast.__(어디, 무엇, 보여질 시간).show()
            }
        });



    }
}