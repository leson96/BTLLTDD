package com.example.user.kukubigame;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 16/4/2017.
 */

public class Adapter extends ArrayAdapter<String>{
    Context ct;
    ArrayList<String> arr;

    public Adapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        this.ct = context;
        this.arr = new ArrayList<>(objects);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        LayoutInflater inflater = (LayoutInflater)ct.getSystemService(ct.LAYOUT_INFLATER_SERVICE);
        row = inflater.inflate(R.layout.item,null);
        if(arr!=null&&arr.size()>0){
            com.example.user.kukubigame.textview a = (com.example.user.kukubigame.textview)row.findViewById(R.id.item);
            a.setBackgroundColor(Color.parseColor(arr.get(position)));
        }
        return row;
    }
}

