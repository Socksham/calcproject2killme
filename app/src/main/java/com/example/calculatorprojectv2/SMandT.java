package com.example.calculatorprojectv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SMandT extends AppCompatActivity {

    Button tBtn, sBtn;
    ImageView tIV, sIV;
    TextView tLabel, sLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smand_t);

        tBtn = (Button) findViewById(R.id.tutorialButton);
        sBtn = (Button) findViewById(R.id.storyModeButton);
        //^^ Buttons changing activities

        tIV = (ImageView) findViewById(R.id.arrowTutorial);
        sIV = (ImageView) findViewById(R.id.arrowStoryMode);
        //^^ Arrow images on the screen

        tLabel = (TextView) findViewById(R.id.tutorialLabel);
        sLabel = (TextView) findViewById(R.id.storyModeLabel);
        //^^ Description of button function

        startAnimation();

        tBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTutorial();
            }
        });
    }

    private void startAnimation(){
        Animation animationOne = AnimationUtils.loadAnimation(this, R.anim.slide_right);
        Animation animationTwo = AnimationUtils.loadAnimation(this, R.anim.slide_left);

        tBtn.setAnimation(animationOne);
        tIV.setAnimation(animationOne);
        tLabel.setAnimation(animationOne);

        sBtn.setAnimation(animationTwo);
        sIV.setAnimation(animationTwo);
        sLabel.setAnimation(animationTwo);
    }

    private void openTutorial(){
        Intent intent = new Intent(this, TutorialActivity.class);
        startActivity(intent);
    }
}