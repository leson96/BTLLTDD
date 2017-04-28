package com.example.user.kukubigame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class result extends AppCompatActivity {
    Button bttryAgain, btHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        bttryAgain = (Button) findViewById(R.id.btTryAgain);
        btHome = (Button) findViewById(R.id.btHome);
        TextView txtScore = (TextView) findViewById(R.id.scoreText);
        TextView txtHighScore = (TextView)findViewById(R.id.highScoreText);


        int score = getIntent().getIntExtra("SCORE", 0); //score dc lay tu Intent("SCORE", )
        txtScore.setText(score +"");

        SharedPreferences sharedPreferences = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE); //SharePrefernces luu highscore

        int highScoreFast = sharedPreferences.getInt("HIGH_SCORE_FAST",0);
        int highScoreNormal = sharedPreferences.getInt("HIGH_SCORE_NORMAL",1);

        if(MainActivity.level ==5000) {
            if (score > highScoreNormal) { //xet dk de luu high score
                txtHighScore.setText("High Score : " + score);

                //luu
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("HIGH_SCORE_NORMAL", score);
                editor.commit();
            } else {
                txtHighScore.setText("High Score : " + highScoreNormal);
            }
        }
        else{
            if (score > highScoreFast) { //xet dk de luu high score
                txtHighScore.setText("High Score : " + score);

                //luu
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("HIGH_SCORE_FAST", score);
                editor.commit();
            } else {
                txtHighScore.setText("High Score : " + highScoreFast);
            }
        }

        bttryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), manchoi.class));
                finish();
            }
        });
        btHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });
    }
//    private void tryAgain()
//    {
//        bttryAgain.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
//    }
}
