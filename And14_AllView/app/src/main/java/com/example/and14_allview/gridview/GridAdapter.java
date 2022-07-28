package com.example.and14_allview.gridview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.and14_allview.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class GridAdapter extends BaseAdapter {

    ArrayList<AheDTO> list;
    LayoutInflater inflater;

    /*setter 이용해도 됨*/
    public GridAdapter(ArrayList<AheDTO> list, LayoutInflater inflater) {
        this.list = list;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //convertView 부분은 우리한테 내용물을 넣으라고 null인 상태로 비워져서 들어오는 변수
    //return을 해주면 알아서 붙임(os)
    //parent : getCount만큼 나눈 공간을 position별로 한 칸 씩 우리한테 줌
    //↑ 두가지는 붙일 내용물과 붙일 공간. ※ LayoutInflater ※
    //ViewHolder라는 것을 만들어보기 ! ( View(위젯)용 DTO ) ← RecyclerView에서는 ViewHolder를 강제함
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*convertView*/
        convertView = inflater.inflate(R.layout.item_gridview, parent, false);

        GridViewHolder viewHolder = new GridViewHolder(convertView);
        viewHolder.bind(list.get(position));
/*      ImageView imgv = convertView.findViewById(R.id.imgv);
        imgv.setImageResource(list.get(position).getImg_id());

        TextView mainTV1 = convertView.findViewById(R.id.mainTV1);
        mainTV1.setText(list.get(position).getName());

        TextView mainTV2 = convertView.findViewById(R.id.mainTV2);
        mainTV2.setText(list.get(position).getSpecies());

        TextView subTV = convertView.findViewById(R.id.subTV);
        subTV.setText(list.get(position).getAge()+"");*/
        return convertView;


    }

    // ? Inner Class < GridAdapter에 GridViewHolder라는 클래스
    public class GridViewHolder {
        ImageView imgv;
        TextView mainTV1, mainTV2, subTV;

        View view;

        public GridViewHolder(View view) {
            //this.view = view;
            imgv = view.findViewById(R.id.imgv);
            mainTV1 = view.findViewById(R.id.mainTV1);
            mainTV2 = view.findViewById(R.id.mainTV2);
            subTV = view.findViewById(R.id.subTV);
        }

        public void bind(AheDTO dto) {
            imgv.setImageResource(dto.getImg_id());
            mainTV1.setText(dto.getName());
            mainTV2.setText(dto.getSpecies());
            subTV.setText(dto.getAge()+"");
        }

    }
}
