package com.example.user.kukubigame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static int mode =0 ;
    Button btNormal, btExit, btFast;
    TextView txtHighScore;
    RadioButton rbtColor, rbtImage;
    RadioGroup rbtGroup;
    static int level ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btNormal = (Button) findViewById(R.id.btNormal);
        btExit = (Button) findViewById(R.id.btExit);
        txtHighScore = (TextView) findViewById(R.id.highScore);
        btFast = (Button) findViewById(R.id.btFast);
        rbtGroup = (RadioGroup) findViewById(R.id.rbtGroup);
        rbtColor = (RadioButton) findViewById(R.id.rbtColor);
        rbtImage = (RadioButton) findViewById(R.id.rbtImage);


        SharedPreferences sharedPreferences = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE); //SharePrefernces luu highscore
        int highScoreFast = sharedPreferences.getInt("HIGH_SCORE_FAST",0);
        int highScoreNormal= sharedPreferences.getInt("HIGH_SCORE_NORMAL",0);
        if(highScoreFast >= highScoreNormal)
            txtHighScore.setText("High score : "+highScoreFast);
        else
            txtHighScore.setText("High score : "+highScoreNormal);



        Play(btNormal);
        Play(btFast);

        btExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);

            }
        });

    }
    private void Play(View v)
    {



        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioGroup = rbtGroup.getCheckedRadioButtonId();
                switch (radioGroup)
                {
                    case R.id.rbtColor:
                        mode = 0;
                        break;
                    case R.id.rbtImage:
                        mode = 1;
                        break;
                }
                if(v == btFast)
                {
                    level = 4000;
                }
                else if(v == btNormal) level = 6000;

                Intent i = new Intent(MainActivity.this,manchoi.class);


                startActivity(i);

               // finish();

            }
        });


    }
}
