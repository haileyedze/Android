package com.example.and10_intentresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn_intent, login_intent;
    // 안드로이드의 4대 컴포넌트 : (현) 액티비티
    // 4가지의 컴포넌트들 간의 통신을 담당 : Intent(전달)

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findViewById(R.id.btn_intent).setOnClickListener();//View ( → Button ), 가능은 하다

        btn_intent = findViewById(R.id.btn_intent);
        login_intent = findViewById(R.id.login_intent);

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
    }
}