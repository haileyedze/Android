package com.example.and10_intentresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class TestActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Intent intent = getIntent();
        String test1 = intent.getStringExtra("test1");
        int test2 = intent.getIntExtra("test2", -1);
        Log.d("test1", test1);
        Log.d("test2", test2+"");

        TestDTO dto = (TestDTO) intent.getSerializableExtra("dto");
        Log.d("dto", dto.getTestString() + dto.getTestInt());

        findViewById(R.id.btn_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reIntent = new Intent();
                reIntent.putExtra("test12", "테스트가 끝남");
                //결과 코드를 지정한다
                setResult(RESULT_OK, reIntent);

                //액티비티를 종료함(끝)
                finish();
            }
        });

    }
}