package com.example.user.kukubigame;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by User on 16/4/2017.
 */

public class Congcuhotro {
    static int dapan;
    Random r = new Random();
    String string[] = new String[]{"#d7d720","#fefe00","#20d720","#00fe00","#20d7d7","#00ffff","#2020d7","#2f2fff","#d80707","#ff4242"};
    public ArrayList<String> taobangmau(int n){
        int x, y;
        ArrayList<String> a =  new ArrayList<>();
        x = r.nextInt(n); // 0->3
        dapan=x;
        y = r.nextInt(10);
        if(y%2==1)
        {
            y--;
        }
        for (int i = 0; i<n; i++)
        {
           if(i==x) {
               a.add(string[y]);
           }else {
               a.add(string[y+1]);
           }

        }
        return a;


        }
    }

