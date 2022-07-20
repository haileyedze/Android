package com.example.and10_intentresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    Button cc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        cc = findViewById(R.id.cc);

        cc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();//이전 액티비티에서 Intent로 새로운 창을 띄울 때 사용한 Intent를 가지고 옴
        String test = intent.getStringExtra("test");
        int num = intent.getIntExtra("num", -1);
        int num1 = intent.getIntExtra("num1", -1);
        Log.d("메인 액티비티에서 가져온 값 : ", test);
        Log.d("메인 액티비티에서 가져온 값 : ", num+"");
        Log.d("메인 액티비티에서 가져온 값 : ", num1+"");

        //dto타입이 Serializable
        LoginDTO dto = (LoginDTO) intent.getSerializableExtra("dto");
        Log.d("id", dto.getId() + "");
        Log.d("pw", dto.getPw());

        //ArrayList 받기
        ArrayList<LoginDTO> list = (ArrayList<LoginDTO>) intent.getSerializableExtra("list");
        for(int i=0; i<list.size(); i++) {
            Log.d("list의 id값", list.get(i).getId() + "");
            Log.d("list의 pw값", list.get(i).getPw());
            Log.d("list의 사이즈", list.size() + "");
        }
    }
}