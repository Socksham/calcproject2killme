package com.example.calculatorprojectv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;

public class SMandT extends AppCompatActivity {

    Button tBtn, sBtn, uBtn;
    ImageView tIV, sIV;
    TextView tLabel, sLabel, uLabel;
    MediaPlayer sAOGotToWin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smand_t);

        tBtn = (Button) findViewById(R.id.tutorialButton);
        sBtn = (Button) findViewById(R.id.storyModeButton);
        uBtn = (Button) findViewById(R.id.unlimitedModeButton);
        //^^ Buttons changing activities

        tIV = (ImageView) findViewById(R.id.arrowTutorial);
        sIV = (ImageView) findViewById(R.id.arrowStoryMode);
        //^^ Arrow images on the screen

        tLabel = (TextView) findViewById(R.id.tutorialLabel);
        sLabel = (TextView) findViewById(R.id.storyModeLabel);
        uLabel = (TextView) findViewById(R.id.unlimitedModeLabel);
        //^^ Description of button function

        startAnimation();
        playMusic();

        tBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTutorial();
            }
        });

        uBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUnlimited();
            }
        });
    }

    private void startAnimation(){
        Animation animationOne = AnimationUtils.loadAnimation(this, R.anim.slide_right);
        Animation animationTwo = AnimationUtils.loadAnimation(this, R.anim.slide_left);
        Animation animationThree = AnimationUtils.loadAnimation(this, R.anim.slide_up);

        tBtn.setAnimation(animationOne);
        tIV.setAnimation(animationOne);
        tLabel.setAnimation(animationOne);

        sBtn.setAnimation(animationTwo);
        sIV.setAnimation(animationTwo);
        sLabel.setAnimation(animationTwo);

        uBtn.setAnimation(animationThree);
        uLabel.setAnimation(animationThree);
    }

    private void openTutorial(){
        Intent intent = new Intent(this, TutorialActivity.class);
        startActivity(intent);

    }

    private void openUnlimited(){
        Intent intent = new Intent(this, UnlimitedModeActivity.class);
        startActivity(intent);

        sAOGotToWin.stop();
    }

    private void playMusic(){
        if (sAOGotToWin == null){
            sAOGotToWin = MediaPlayer.create(this, R.raw.got_to_win);
            sAOGotToWin.start();
            sAOGotToWin.setLooping(true);
        } else {
            sAOGotToWin.release();
            sAOGotToWin = null;
        }
    }
}