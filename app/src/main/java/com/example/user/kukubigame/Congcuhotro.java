package com.example.user.kukubigame;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by User on 16/4/2017.
 */

public class Congcuhotro {
    static int dapan;
    static int dapan1;
    Random r = new Random();
    String string[] = new String[]{"#d7d720","#fefe00","#20d720","#00fe00","#20d7d7","#00ffff","#2020d7","#2f2fff","#d80707","#ff4242"};

   // Integer string_Image[] = new Integer[]{R.drawable.mat1, R.drawable.mat2,R.drawable.mat3, R.drawable.mat4};

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
//    public ArrayList<Integer> taoBangHinh(int n) {
//
//        ArrayList<Integer> a = new ArrayList<>();
//        int x, y,z;
//        x = r.nextInt(n);
//        dapan = x;
//        y = r.nextInt(10);
//        for (int i =0 ;i<n;i++)
//        {
//            if(i ==x){
//                a.add(string_Image[y]);
//            }
//            else
//                a.add(string_Image[y+1]);
//        }
////        while(true){
////            z=r.nextInt(n);
////            if(z!=x){
////                dapan1 = z;
////                break;
////            }
////        }
////        y = r.nextInt(string.length/2);
////        for (int i= 0; i<n ; i++){
////            if (i == x){
////                a.add(string_Image[y*2]);
////            }else if(i==z){  a.add(string_Image[y*2]);}else{
////                a.add(string_Image[y*2+1]);
////            }
////
////        }
//        return a;
//
//    }
    }

