package com.example.and13_fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class TestFragment2 extends Fragment {

    // 서브프래그먼트가 생성될 때 상위 액티비티에서 받아오는 방식
    Context context;

    // 생성자를 이용해서 액티비티로부터 Context를 받아온다
    // ※ 3번째 방법 필요한 기능(객체)이 있고 생성하거나 받아올 수 없는 상황이라면,
    // 객체가 생성될 때 해당하는 기능을 받아오면 된다
    public TestFragment2(Context context) {
        this.context = context;
    }

    Button btn_sub;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         View v = inflater.inflate(R.layout.fragment_test2, container, false);

        btn_sub = v.findViewById(R.id.btn_sub);

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Context는 어떠한 기능을 사용하기위해서 상위 액티비티에서 무언가를 받아옴
                //Toast.makeText(v.getContext() ,"하이", Toast.LENGTH_SHORT).show(); //←오류 날 소지가 많음 X
                //Toast.makeText(getContext(), "하이", Toast.LENGTH_SHORT).show();    // 1.Fragment 에서 Context 기능을 받아오기 위한 1번째 방법
                //Toast.makeText(getActivity(), "하이", Toast.LENGTH_SHORT).show();   // 2.Fragment 에서 Context 기능을 받아오기 위한 2번째 방법
                Toast.makeText(context, "하이", Toast.LENGTH_SHORT).show();      // 3.Fragment 에서 Context 기능을 받아오기 위한 3번째 방법
            }
        });

        return v;
    }
}