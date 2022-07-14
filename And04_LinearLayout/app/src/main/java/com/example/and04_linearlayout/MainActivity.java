package com.example.and04_linearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener
{

    /*  1.디자인 파일에 있는 버튼과 에딧텍스트를 자바코드에서 사용할수있게 찾아주기
        - 내가 사용할 위젯을 자바에서 찾을수있게 ID를 주기. (attribute)
        - findViewById라는 메소드를 이용해서 ↑ 해당하는 아이디로 위젯 찾아서 연결
    *   2.※ 버튼 클릭 이벤트를 만들고 log찍어보기 ※
    * */
    Button btn_login , btn_join ;//null
    EditText edt_id , edt_pw;//null

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);//<= xml <=> java (<-연결된 xml파일 내부에있는 위젯을 id로 찾기)

        btn_login = findViewById(R.id.btn_login);
        btn_join = findViewById(R.id.btn_join);
        edt_id = findViewById(R.id.edt_id); //반드시 이 처리를 해주고 사용하기
        edt_pw = findViewById(R.id.edt_pw); //반드시 이 처리를 해주고 사용하기

        View.OnClickListener vo = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("aaa" , " aaa" + v.getId() + " : " + R.id.btn_join + "");
            }
        };

        btn_join.setOnClickListener(vo);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // admin ← id, admin1234 ← pw
                // edt ← getText ← String 타입으로 바꾸고 비교

                Log.d("id", "" + edt_id.getText() + "");
                Log.d("pw", ""+ edt_pw.getText() + "");

                String id = String.valueOf(edt_id.getText());
                String pw = String.valueOf(edt_pw.getText());

                if(  id.equals("admin") && edt_pw.getText().toString().equals("admin1234")){
                    Log.d("login", "축하^^");
                }else{
                    Log.d("nologin", "로그인안됨");
                }
            }
        });
    }

    @Override
    public void onClick(View v) {//?
        Log.d("로그찍기", " 아무값");
    }
}