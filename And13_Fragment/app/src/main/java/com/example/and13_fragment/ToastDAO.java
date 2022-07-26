package com.example.and13_fragment;

import android.content.Context;
import android.widget.Toast;

public class ToastDAO {
    /*
    Context context;
    Context의 기능을 여러 메소드에서(ToastDAO) 사용한다면 생성자를 사용해서
    Context  자체를 필드로 두고 사용하는 것이 편하고,
    showToast 메소드 하나에서만 사용한다면 파라메터로 만들어주기
    */

    public void showToast(Context context, String text){
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}
