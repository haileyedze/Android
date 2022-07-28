package com.example.practice_gorilla.listview;

import android.graphics.Outline;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.practice_gorilla.R;

import java.util.ArrayList;

public class ListFragment1 extends Fragment {

    ListView listView1;
    /*ImageView img_btn;*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_list1, container, false);

        listView1 = v.findViewById(R.id.listView1);

/*        img_btn = v.findViewById(R.id.img_btn);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            img_btn.setOutlineProvider(new ViewOutlineProvider() {
                @Override
                public void getOutline(View view, Outline outline) {
                    outline.setRoundRect(0,0, view.getWidth(), view.getHeight() + 200, 40);
                }
            });

            img_btn.setClipToOutline(true);
        }*/

        ArrayList<GorillaDTO> list = new ArrayList<>();
        list.add(new GorillaDTO(R.drawable.cat1, R.drawable.play, R.color.color1,
                "LOVE FM", "김태현의 정치쇼 3,4부"));
        list.add(new GorillaDTO(R.drawable.cat2, R.drawable.pause, R.color.color2,
                "POWER FM", "아름다운 이 아침 김창완입니다"));
        list.add(new GorillaDTO(R.drawable.cat3, R.drawable.play, R.color.color3,
                "고릴라디오FM", "classic 20"));
        list.add(new GorillaDTO(R.drawable.cat4, R.drawable.play, R.color.color4,
                "CLOSE FM", "윤신향의 CLOSE"));
        list.add(new GorillaDTO(R.drawable.cat5, R.drawable.play, R.color.color5,
                "LOVE FM", "천사랑의 LOVE.LOVE.LOVE"));

        ListAdapter1 adapter1 = new ListAdapter1(list, inflater);
        listView1.setAdapter(adapter1);

        return v;
    }
}