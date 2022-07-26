package com.example.and13_fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    // 메인액티비티 안에 어떤 곳에 붙였을까? xml을 만들어서
    // View : 위젯 ( xml에서 디자인할 수 있는 모든 것들)
    // 화면에 보이는 모든 것들(모두 뷰클래스의 상속을 받았다) ex)위젯
    //ViewGroup : 안에 묶어서 넣을 수 있는 구조를 가진 위젯(Layout)

    //LayOutInflate.inflate(R,layout.내가만든xml, ViewGroup , true)
    TestFragment testFragment = new TestFragment();
    TestFragment2 subFragment = new TestFragment2(this);
    //괄호 안에 getApplicationContext() 쓸 수 있음
    TestFragment3 subFragment3 = new TestFragment3();
    //static Button btn_change, btn_toast;
    Button btn_change, btn_toast;
    ToastDAO dao = new ToastDAO();
    static FragmentManager fragmentManager;

    boolean b = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_change = findViewById(R.id.btn_change);
        btn_toast = findViewById(R.id.btn_toast);

        fragmentManager = getSupportFragmentManager();

        btn_toast.setOnClickListener(new View.OnClickListener() { //interface 되어있음
            @Override
            public void onClick(View v) {
                dao.showToast(MainActivity.this, "문자열 보여주기");
            }
        });


        btn_change.setTag(0);
        //위젯에 어떤 상태정보를 넣어두고 사용하기 위한 것 ( Object형태여서 뭐든지 넣을 수 있다 )


        // FragmentManager ← 필요함 ( 프래그먼트를 붙이는 처리를 한다 )
        // 액티비티 기준으로 FragmentManager를 초기화 하는 방식 ( 사용준비 )
        // Transaction ( DB ) : INSERT, UPDATE, DELETE → COMMIT, ROLLBACK을 해줘야만 작업이 확정 됨
        // FRAGMENT도 COMMIT이 필요하다

        //getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();

    }

    @Override
    protected void onStart() {
        super.onStart();
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int btnTag = (int) btn_change.getTag();//Object
                //int btnTag = Integer.parseInt(btn_change.getTag().toString());
                if(btnTag == 0){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, testFragment).commit();
                    btn_change.setTag(1);
                }else if(btnTag == 1){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, subFragment).commit();
                    btn_change.setTag(2);
                }else if(btnTag == 2){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, subFragment3).commit();
                    btn_change.setTag(0);
                }
            }
        });
    }


    //static 키워드를 이용해서 멤버를 static멤버로 만들기
    //static이 붙으면 static 멤버다 != static이 안붙으면 static 멤버가 아니다.

    //두가지 멤버가 있음 : static 멤버, instance 멤버

    //static은 항상 메모리에 먼저 가있어야함
    //인스턴스 멤버는 new를 통해서 인스턴스화 과정을 실행해야 메모리에 올라감
    //static int aa = 0;

    //static메소드를 안드로이드에서 사용했을 때 불편한 점
    //대부분의 안드로이드에서 사용되는 멤버들은 Context, FragmentManager 등 인스턴스 멤버임
    //static에서 구현 하려면 하나씩 static으로 만들거나 해야하는 불편한 점이 많음(메모르 용량 많이 씀)
    //MainActivity activity = new MainActivity();
    //↓ 방식은 사용을 자제하자!(안된다고 무조건 static 쓰지 말자 ))
   /*public static void mainMethod(){
        //int aa = 0;
        Log.d("메인메소드", "mainMethod: ");
        Toast.makeText(this, "어떻게 하지?", Toast.LENGTH_SHORT).show();
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int btnTag = (int) btn_change.getTag();//Object
                //int btnTag = Integer.parseInt(btn_change.getTag().toString());
                if(btnTag == 0){
                    //getSupportFragmentManager() ← 메소드 ( return fragment )
                    fragmentManager.beginTransaction().replace(R.id.container, new TestFragment()).commit();
                    btn_change.setTag(1);
                }else if(btnTag == 1){
                    fragmentManager.beginTransaction().replace(R.id.container, new TestFragment2(v.getContext())).commit();
                    btn_change.setTag(2);
                }else if(btnTag == 2){
                    fragmentManager.beginTransaction().replace(R.id.container, new TestFragment3()).commit();
                    btn_change.setTag(0);
                }
            }
        });
    }*/
    
    //모든 멤버에 접근이 가능함
    public void mainMethodI(){
        Log.d("메인메소드", "mainMethod: ");
        Toast.makeText(this, "메인메소드를 보여줍니다", Toast.LENGTH_SHORT).show();
    }
    
}