package com.example.and10_intentresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_intent, login_intent;
    Button btn_call, btn_internet, btn_gps;
    // 안드로이드의 4대 컴포넌트 : (현) 액티비티
    // 4가지의 컴포넌트들 간의 통신을 담당 : Intent(전달)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findViewById(R.id.btn_intent).setOnClickListener();//View ( → Button ), 가능은 하다

        btn_intent = findViewById(R.id.btn_intent);
        login_intent = findViewById(R.id.login_intent);

        btn_call = findViewById(R.id.btn_call);
        btn_internet = findViewById(R.id.btn_internet);
        btn_gps = findViewById(R.id.btn_gps);

        btn_call.setOnClickListener(this);
        btn_gps.setOnClickListener(this);
        btn_internet.setOnClickListener(this);

        btn_intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //현재위치 → 이동할 위치 두개를 파라메터로 지정해둠
                //직접 LoginActivity라는 액티비티를 하나 만들고
                //메인액티비티의 버튼을 클릭했을 때 새로 띄워지게 처리해보기.

                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                startActivity(intent);
            }
        });

        login_intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.putExtra("test",  "넘길값");
                intent.putExtra("num",100);

                LoginDTO dto = new LoginDTO(11, "admin");
                //LoginDTO 타입을 요소로 가지는 ArrayList 만들기
                //size == 10
                ArrayList<LoginDTO> list = new ArrayList<LoginDTO>();
                for(int i=0; i<10; i++){
                    list.add(new LoginDTO(i, "pw" + i));
                }

                //LoginDTO dto = new LoginDTO();
                //dto.setId(11);
                //dto.setPw("admin");

                //intent.putExtra("id", dto.getId());
                //intent.putExtra("pw", dto.getPw());

                //직렬화 Serializable
                intent.putExtra("dto", dto);

                intent.putExtra("list", list);

                startActivity(intent);

            }
        });


        findViewById(R.id.test_intent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, TestActivity.class);
                intent.putExtra("test1", "하나");
                intent.putExtra("test2", 200);

                TestDTO dto = new TestDTO(3, "test3");
                intent.putExtra("dto", dto);

                //startActivity(intent);//실제 액티비티를 띄움
                //startActivity라는 메소드는 새창을 띄우는 용도로만 사용을함.
                //다음 액티비티의 작업이나 결과를 받아오기위해서는 다른 메소드를 사용.
                // intent (명시적 , 암시적 )
                // 명시적 : <- 내가 만든 클래스(바운더리)에서 작업이 되었을때를 의미함.
                // 암시적 : <- 내가 만들지 않은 어떠한 곳에서 작업이 되었을때(카메라,갤러리,인터넷 등)
                startActivityForResult(intent,REQ_TEST_CODE);

            }
        });

/*        Intent intent = new Intent(MainActivity.this, SubActivity.class);
        startActivityForResult(intent, REQ_SUB_CODE);*/
    }
    //상수 ←
    final int REQ_TEST_CODE = 1001;
    final int REQ_SUB_CODE = 1002;

    //어떤 액티비티가 종료되었는지를 어떻게 구별할까?
    //1001번 왜 썼을까? kakao에서는 왜 콜백을 만들었을까?
    @Override
    //성공과 실패를 알수있게 해줌, 마지막이 중요
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ_TEST_CODE){
            Log.d("TAG", "TestActivity가 종료 되었음");
            Log.d("TAG", "결과코드 " + resultCode);
            //intent를 받아왔음, 안에 들어있는 스트링값을 출력하기
            Log.d("intent에서 받아온 값", "intent String : " + data.getStringExtra("test12"));
        }else if(requestCode == REQ_SUB_CODE){
            Log.d("TAG", "SubActivity가 종료 되었음");
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_call){
            //안드로이드에서 기본적으로 제공하고 우리가 만들지 않은 작업을 하게 되면 임시적 인텐트라고 한다
            //전화걸기 (권한 매우 낮음 → 매니페스트 파일에 명시만 해놓으면 바로 사용가능한 부분 ) permission
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:/119"));
            startActivity(intent);
        }else if(v.getId() == R.id.btn_gps){
            //gps ← 권한을 승인 받아야함, 현재 위치를 노출해야할 때
            //현재위치를 얻어오기 위해서는 다른 권한이 필요함
            Intent intent = new Intent(Intent.ACTION_VIEW
            ,Uri.parse("https://www.google.com/maps?q=" + 35.1535583 + "," + 126.8879957 + "&z=" + 15)
            );
            startActivity(intent);
        }else if(v.getId() == R.id.btn_internet){
            //webView ← 안드로이드에서 인터넷으로 연결해줄 수 있는 기능을 가진 객체
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));
            startActivity(intent);
        }
    }
}