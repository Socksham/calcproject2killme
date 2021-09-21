package com.example.calculatorprojectv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class WinningScreen extends AppCompatActivity {
    Button dBtn;
    TextView wLabel, descLabel;
    MediaPlayer backgroundMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning_screen);

        dBtn = (Button) findViewById(R.id.startOverButton);

        wLabel = (TextView) findViewById(R.id.winnerLabel);
        descLabel = (TextView) findViewById(R.id.descLabel);

        playMusic();
        playAnimation();

        dBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnToMenu();
            }
        });
    }

    private void playMusic(){
        if (backgroundMusic == null){
            backgroundMusic = MediaPlayer.create(this, R.raw.a_tender_feeling);
            backgroundMusic.start();
            backgroundMusic.setLooping(true);
        } else {
            backgroundMusic.release();
            backgroundMusic = null;
        }
    }

    private void returnToMenu(){
        Intent intent = new Intent(this, SMandT.class);
        startActivity(intent);

        backgroundMusic.stop();
    }

    private void playAnimation(){
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        wLabel.setAnimation(fadeIn);
        descLabel.setAnimation(fadeIn);
    }
}