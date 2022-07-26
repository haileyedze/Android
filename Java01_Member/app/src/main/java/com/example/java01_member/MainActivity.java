package com.example.java01_member;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    MemberClass memberClass = new MemberClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("멤버 private", "private은 클래스 내부에서만 사용이 가능하다");
                Log.d("멤버 default", memberClass.default_str);
                Log.d("멤버 public", memberClass.public_str);
            }
        });

    }
}