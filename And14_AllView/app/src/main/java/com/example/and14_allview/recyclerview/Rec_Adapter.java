package com.example.and14_allview.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and14_allview.R;

import java.util.ArrayList;

public class Rec_Adapter extends RecyclerView.Adapter<Rec_Adapter.RecHolder> {

    // Recycler ← 재활용 : 뷰홀더(ViewHolder)를 강제 한다. (무조건 만들어야함)
    // 가로, 세로, 지그재그(잘사용안함)를 제공함
    // 1. ViewHolder클래스를 상속받은 inner class를 만든다
    // 2. RecyclerView.Adapter를 상속받음 RecyclerView<VH> == VH: ViewHolder(이너클래스를 의미함)

    LayoutInflater inflater;
    ArrayList<AheDTO> list;

    public Rec_Adapter(LayoutInflater inflater, ArrayList<AheDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public RecHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = inflater.inflate(R.layout.item_listview, parent, false);
        RecHolder holder = new RecHolder(v);
        return holder;
    }

    // 데이터바인딩 ( view ↔ dto ) 연결부 GridAdapter.bind()
    @Override
    public void onBindViewHolder(@NonNull RecHolder holder, int position) {
        // holder ↔ dto 연결 ( holder개수 == list.size() )
        holder.imgv.setImageResource(list.get(position).getImg_id());
        holder.mainTV1.setText(list.get(position).getName());
        holder.mainTV2.setText(list.get(position).getSpecies());
        holder.subTV.setText(list.get(position).getAge()+"");
    }

    // 리사이클러뷰의 아이템 갯수를 지정함
    @Override
    public int getItemCount() {
        return list.size();
    }

    // 1. 어떤 이름이든 일단 extends RecyclerView.ViewHolder를 상속받아서 ViewHolder구조를 만들기
    public class RecHolder extends RecyclerView.ViewHolder{
        //@NonNul ← null 을 넣으면 안됨
        ImageView imgv;
        TextView mainTV1, mainTV2, subTV;
        public RecHolder(@NonNull View v) {
            super(v);
            imgv = v.findViewById(R.id.imgv);
            mainTV1 = v.findViewById(R.id.mainTV1);
            mainTV2 = v.findViewById(R.id.mainTV2);
            subTV = v.findViewById(R.id.subTV);
            //position

        }
    }
}
