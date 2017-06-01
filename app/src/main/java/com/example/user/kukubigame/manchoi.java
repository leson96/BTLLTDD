package com.example.user.kukubigame;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 16/4/2017.
 */

public class manchoi extends AppCompatActivity {
    TextView txttime, txtdiem;
    Button btpause;
    GridView grview;
    long time_pause =0;
    Congcuhotro congcu = new Congcuhotro();
    ArrayList arr;
    int i;

    Integer string_Image[] = new Integer[]{R.drawable.mat1, R.drawable.mat2,R.drawable.mat3, R.drawable.mat4};


    int diem,so0, kiemtra = 0;

     CountDownTimer time;

@Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_man_choi);  // ket voi layout man choi
        findID();
//    if(time_pause !=0) {
//        MainActivity.level = time_pause;
//    }
        time = new CountDownTimer(MainActivity.level, 100) //dem tu 30k mili s xuong 0
        {

            public void onTick(long millisUntilFinished)  /// trong khi dem 1000milisecond
            {
                txttime.setText(millisUntilFinished / 1000 + " ");
            }

            public void onFinish() {
                kiemtra = 1;
                time.cancel();
                // txttime.setText("0");
                result();

            } // sau khi dem
        }.start();


        caidatgriview();
        setdulieu();
        setsukien();

    }
    private void findID(){
        btpause = (Button) findViewById(R.id.btPause);
        grview = (GridView)findViewById(R.id.grview);
        txtdiem = (TextView)findViewById(R.id.txtdiem);
        txttime = (TextView)findViewById(R.id.txttime);
//        imageButtonPause = (ImageButton) findViewById(R.id.ibtPause);
        diem=0;
    }

    private void caidatgriview(){
        if(diem<10) {
            grview.setNumColumns(3);
            so0=6;
        }else{
            grview.setNumColumns(diem/10+2); //  10<= 3 <20
            so0=(diem/10+2)*(diem/10+2); //so o gap doi
        }
        i =0;
    }
    private  void  setdulieu(){
      if(MainActivity.mode == 0) {
            arr = new ArrayList(congcu.taobangmau(so0));

            Adapter adapter = new Adapter(manchoi.this, R.layout.layout_man_choi, arr);
            grview.setAdapter(adapter);
        }
        else
            if(MainActivity.mode ==1)
        {
            arr = new ArrayList(congcu.taoBangHinh(so0));
            AdapterImages adapterImages = new AdapterImages(manchoi.this, R.layout.layout_man_choi,arr);
            grview.setAdapter(adapterImages);
        }
        txtdiem.setText(Integer.toString(diem));
    }
    private  int check()
    {
        grview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (grview.getCheckedItemPosition() == congcu.dapan || grview.getCheckedItemPosition() == congcu.dapan1)
                    i++;
            }
        });

        return i;

    }
    private void setsukien(){

        grview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == congcu.dapan || position == congcu.dapan1)
                    i++;
                if (i==2) {
                    caidatgriview();
                    time.start(); // dung thi dat lai time
                    diem = diem + 5;
                    setdulieu();
                }
            }
        });

//                    if (congcu.arrDapan != null) {
//                        for (int i = 0; i < 2; i++) {
//                            if (grview.getCheckedItemPosition() == congcu.arrDapan.get(i)) {
//                                congcu.arrDapan.remove(i);
//                            }
//                        }
//                    }
                        //if(position == congcu.arrDapan[0] && position ==congcu.dapan1 && kiemtra==0)
//                     if (congcu.arrDapan == null) {
//                        caidatgriview();
//                        time.start(); // dung thi dat lai time
//                        diem = diem + 5;
//                        setdulieu();
//                    }

        btpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                try {
//                    time.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                //time_pause = Integer.parseInt(txttime.getText().toString())*1000;

                time.cancel();

                AlertDialog.Builder builder = new AlertDialog.Builder(manchoi.this);

                builder.setTitle("Pause")

                        .setMessage("Do you want to continue !!!")
                        .setIcon(R.drawable.ic_help_24dp)
                        .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                                time.start();
//                                time= new CountDownTimer(t , 100) //dem tu 30k mili s xuong 0
//                                {
//
//                                    public void onTick(long millisUntilFinished)  /// trong khi dem 1000milisecond
//                                    {
//                                        txttime.setText(millisUntilFinished / 1000+" ");
//                                    }
//
//                                    public void onFinish() {
//                                        kiemtra =1;
//                                        time.cancel();
//                                        // txttime.setText("0");
//                                        result();
//
//                                    } // sau khi dem
//                                }.start();

                            }
                        })
                        .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        }).show();
            }
        });

    }
    private void result(){
        Intent intent = new Intent(getApplicationContext(), result.class);

        intent.putExtra("SCORE", diem);

        startActivity(intent);
       // finish();
       // finish();
    }
}
