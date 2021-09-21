package com.example.calculatorprojectv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class death_screen extends AppCompatActivity {
    Button dBtn;
    TextView dLabel;
    MediaPlayer backgroundMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_death_screen);

        dBtn = (Button) findViewById(R.id.startOverButton);

        dLabel = (TextView) findViewById(R.id.youDiedLabel);

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
            backgroundMusic = MediaPlayer.create(this, R.raw.despaired);
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

        dLabel.setAnimation(fadeIn);
    }
}