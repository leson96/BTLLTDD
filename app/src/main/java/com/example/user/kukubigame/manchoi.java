package com.example.user.kukubigame;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 16/4/2017.
 */

public class manchoi extends AppCompatActivity {
    TextView txttime, txtdiem;

    GridView grview;
    Congcuhotro congcu = new Congcuhotro();
    ArrayList arr;
    int diem,so0, kiemtra = 0;
    CountDownTimer time= new CountDownTimer(MainActivity.level, 10) //dem tu 30k mili s xuong 10k
    {

        public void onTick(long millisUntilFinished)  /// trong khi dem
        {
            txttime.setText(millisUntilFinished / 1000+" ");
        }

        public void onFinish() {
            kiemtra =1;
            txttime.setText("0");

           result();
    } // sau khi dem
    }.start();

@Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_man_choi);  // ket voi layout man choi
        findID();
        caidatgriview();

        setdulieu();
        setsukien();

    }
    private void findID(){
        grview = (GridView)findViewById(R.id.grview);
        txtdiem = (TextView)findViewById(R.id.txtdiem);
        txttime = (TextView)findViewById(R.id.txttime);
//        imageButtonPause = (ImageButton) findViewById(R.id.ibtPause);
        diem=0;
    }

    private void caidatgriview(){
        if(diem<10) {
            grview.setNumColumns(2);
            so0=4;
        }else{
            grview.setNumColumns(diem/10+2); //  10<= 3 <20
            so0=(diem/10+2)*(diem/10+2); //so o gap doi
        }

    }
    private  void  setdulieu(){
        arr = new ArrayList(congcu.taobangmau(so0));
        Adapter adapter = new Adapter(manchoi.this,R.layout.layout_man_choi,arr);
        grview.setAdapter(adapter);
        txtdiem.setText(Integer.toString(diem));
    }
    private void setsukien(){

        grview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==congcu.dapan &&kiemtra==0)
                {
                    caidatgriview();
                    time.start(); // dung thi dat lai time
                    diem=diem+5;
                    setdulieu();
                }


            }
        });
    }
    private void result(){
        Intent intent = new Intent(getApplicationContext(), result.class);

        intent.putExtra("SCORE", diem);

        startActivity(intent);
        finish();
    }
}
