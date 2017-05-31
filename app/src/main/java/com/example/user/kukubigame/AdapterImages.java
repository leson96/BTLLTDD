package com.example.user.kukubigame;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quang Vinh on 5/28/2017.
 */

public class AdapterImages extends ArrayAdapter<Integer> {
    Context context;
    ArrayList<Integer> images;

    public AdapterImages(@NonNull Context context, @LayoutRes int resource, @NonNull List<Integer> objects) {
        super(context, resource, objects);
        this.context = context;
        this.images = new ArrayList<>(objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        ImageView imgView;
//        imgView = new ImageView(context);
//        imgView.setImageResource(images.get(position));
//        return imgView;

        View row = convertView;
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        row = inflater.inflate(R.layout.item,null);
        if(images!=null&&images.size()>0){
            com.example.user.kukubigame.textview a = (com.example.user.kukubigame.textview)row.findViewById(R.id.item);
           // a.setBackground((images.get(position)));
            a.setBackgroundResource(images.get(position));
        }
        return row;
    }
}
