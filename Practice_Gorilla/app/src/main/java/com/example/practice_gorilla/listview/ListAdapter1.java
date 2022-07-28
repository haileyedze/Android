package com.example.practice_gorilla.listview;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.practice_gorilla.R;

import java.util.ArrayList;

public class ListAdapter1 extends BaseAdapter {

    ArrayList<GorillaDTO> list;
    LayoutInflater inflater;

    public ListAdapter1(ArrayList<GorillaDTO> list, LayoutInflater inflater) {
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.item_listview1, parent, false);
        ImageView img_btn = convertView.findViewById(R.id.img_btn);
        img_btn.setImageResource(list.get(position).getImg_btn());

        ImageView button = convertView.findViewById(R.id.button);
        button.setImageResource(list.get(position).getButton());

        ImageView bg_img = convertView.findViewById(R.id.bg_img);
        bg_img.setImageResource(list.get(position).getBg_img());

        TextView fm = convertView.findViewById(R.id.fm);
        fm.setText(list.get(position).getFm());

        TextView title = convertView.findViewById(R.id.title);
        title.setText(list.get(position).getTitle());

        return convertView;
    }
}
