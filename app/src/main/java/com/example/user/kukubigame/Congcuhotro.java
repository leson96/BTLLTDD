package com.example.user.kukubigame;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by User on 16/4/2017.
 */

public class Congcuhotro {
    static int dapAn;
    static int dapAn1;
    Random r = new Random();
    Integer string[] = new Integer[]{R.drawable.mat1, R.drawable.mat2,R.drawable.mat3, R.drawable.mat4};
    public ArrayList<Integer> taoBangHinh(int n) {

        ArrayList<Integer> a = new ArrayList<>();
        int x, y,z;
        x = r.nextInt(n);
        dapAn = x;
        while(true){
            z=r.nextInt(n);
            if(z!=x){
                dapAn1 = z;
                break;
            }
        }
        y = r.nextInt(string.length/2);
        for (int i= 0; i<n ; i++){
            if (i == x){
                a.add(string[y*2]);
            }else if(i==z){  a.add(string[y*2]);}else{
                a.add(string[y*2+1]);
            }

        }
        return a;

    }