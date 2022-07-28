package com.example.and14_allview.recyclerview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and14_allview.R;

import java.util.ArrayList;

public class RecyclerFragment extends Fragment {

    RecyclerView recview;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler, container, false);

        recview = v.findViewById(R.id.recview);

        ArrayList<AheDTO> list = new ArrayList<>();

        list.add(new AheDTO("lazy", "cat", 5, R.drawable.cat1 ));
        list.add(new AheDTO("cute", "cat", 1, R.drawable.cat2 ));
        list.add(new AheDTO("gray", "cat", 1, R.drawable.cat3 ));
        list.add(new AheDTO("black", "cat", 2, R.drawable.cat4 ));
        list.add(new AheDTO("spotted", "cat", 1, R.drawable.cat5 ));

        Rec_Adapter adapter = new Rec_Adapter(inflater, list);
        recview.setAdapter(adapter);

        /* Layoutmanager ← 가로인지 세로인지를 설정해서 넣을 수가 있음 필수임 */
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
          //getContext() , RecyclerView.VERTICAL , false
          getContext() , RecyclerView.HORIZONTAL , false
        );
        recview.setLayoutManager(layoutManager);
        // 첫번째 파라메터(context, 액티비티면 this고 Fragment면 받아와서 넘기면 됨)
        // 두번째 파라메터(방향 가로 또는 세로)
        // 세번째 파라메터(반대로 순서를 바꿀건지 여부, 대부분 false)

        /*1.목록을 가지는 모든 뷰는 Adapter가 필요함.
         *    -1-1.한칸마다 보여질 데이터를 묶어놓은 객체 == DTO(ArrayList)
         *    -1-2.한칸마다 보여질 데이터를 디자인해놓은 파일 == res\layout\xml
         * 2.Adapter 생성 ※※※※※※※※※※※ 리사클러뷰는 별도의 어댑터를 사용한다 ※※※※※※※※※※※
         *    -2-1. 클래스를 추가한다.
         *    -2-2. extends(상속)을 받아서 어댑터가 된다.
         * 3.ListView<=>Adapter연결
         * */

        return v;
    }
}