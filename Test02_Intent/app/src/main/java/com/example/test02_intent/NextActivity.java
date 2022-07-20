package com.example.test02_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {
    TextView tv_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        tv_intent = findViewById(R.id.tv_intent);

        Intent intent = getIntent();

        LoginDTO dto = (LoginDTO) intent.getSerializableExtra("dto");

        tv_intent.setText("id = " + dto.getId() + "\npw =" + dto.getPw() );

    }
}