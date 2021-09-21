package com.example.calculatorprojectv2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculatorprojectv2.utils.UnlimitedNumberGenerator;

import org.mariuszgromada.math.mxparser.Expression;

public class first_fight_scene extends AppCompatActivity {
    TextView display, goalDisplay, buttonClickCounter, constraintDisplay, levelDisplay, timerLabel;

    Button bOne, bTwo, bThree, bFour, bFive, bSix, bSeven, bEight, bNine, bAdd, bSub, bMulti, cButton, clearButton;

    MediaPlayer backgroundMusic;

    UnlimitedNumberGenerator generator;

    CountDownTimer count;

    KeepCount sTProgress;

    private int level = 1;
    private int clickCounter = 0;
    private String displayLabel = "";
    private int goal;
    private int numClicksAllowed;

    String constraint = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_fight_scene);

        generator = new UnlimitedNumberGenerator();
        sTProgress = getIntent().getParcelableExtra("count");

        Log.d("TAG", "Count After: " + sTProgress.getCount());

        bOne = (Button) findViewById(R.id.buttonOne);
        bTwo = (Button) findViewById(R.id.buttonTwo);
        bThree = (Button) findViewById(R.id.buttonThree);
        bFour = (Button) findViewById(R.id.buttonFour);
        bFive = (Button) findViewById(R.id.buttonFive);
        bSix = (Button) findViewById(R.id.buttonSix);
        bSeven = (Button) findViewById(R.id.buttonSeven);
        bEight = (Button) findViewById(R.id.buttonEight);
        bNine = (Button) findViewById(R.id.buttonNine);
        bAdd = (Button) findViewById(R.id.additionButton);
        bSub = (Button) findViewById(R.id.subtractionButton);
        bMulti = (Button) findViewById(R.id.multiplicationButton);
        cButton = (Button) findViewById(R.id.calculateButton);
        clearButton = (Button) findViewById(R.id.backspaceButton);
        //^^ Calc Buttons

        display = (TextView) findViewById(R.id.display);
        goalDisplay = (TextView) findViewById((R.id.goalDisplay));
        buttonClickCounter = (TextView) findViewById(R.id.buttonClickCounter);
        constraintDisplay = (TextView) findViewById(R.id.constraintDisplay);
        levelDisplay = (TextView) findViewById(R.id.levelLabel);
        timerLabel = (TextView) findViewById(R.id.timerLabel);
        //^^Calc labels

        count = new CountDownTimer(30000, 1000) { //30 seconds

            public void onTick(long millisUntilFinished) {
                timerLabel.setText("Time: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                if (level < 5){
                    sTProgress.fgdTrue();
                    deathScreen();
                }
            }
        }.start();

        //Start
        int min = 3;
        int max = 10;

        int clicks = (int)Math.floor(Math.random()*(max-min+1)+min);

        if(clicks % 2 == 0){
            clicks += 1;
        }

        constraint = "";

        int number = generator.getNumber(clicks);
        //End

        playMusic();

        setGoal(number, clicks);

        bOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumBtnClick("1");
            }
        });

        bTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumBtnClick("2");
            }
        });

        bThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumBtnClick("3");
            }
        });

        bFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumBtnClick("4");
            }
        });

        bFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumBtnClick("5");
            }
        });

        bSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumBtnClick("6");
            }
        });

        bSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumBtnClick("7");
            }
        });

        bEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumBtnClick("8");
            }
        });

        bNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumBtnClick("9");
            }
        });

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumBtnClick("+");
            }
        });

        bSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumBtnClick("-");
            }
        });

        bMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNumBtnClick("*");
            }
        });

        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayLabel = "";
                display.setText(displayLabel);
                clickCounter = 0;
                buttonClickCounter.setText("Button Clicks: " + clickCounter);
            }
        });
    }

    private void playMusic(){
        if (backgroundMusic == null){
            backgroundMusic = MediaPlayer.create(this, R.raw.light_your_sword);
            backgroundMusic.start();
            backgroundMusic.setLooping(true);
        } else {
            backgroundMusic.release();
            backgroundMusic = null;
        }
    }

    @SuppressLint("SetTextI18n")
    public void handleNumBtnClick(String btn){
        Context context = getApplicationContext();
        CharSequence keystrokeOver = "Too many Button Presses!";
        CharSequence sillyGoose = "I said Addition you silly goose :)";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, keystrokeOver, duration);
        Toast fgd = Toast.makeText(context, sillyGoose, duration);

        clickCounter++;
        buttonClickCounter.setText("Button Clicks: " + clickCounter);
        displayLabel = displayLabel.concat(btn);
        display.setText(displayLabel);

        if (clickCounter > numClicksAllowed){
            toast.show();
            displayLabel = "";
            display.setText(displayLabel);
            clickCounter = 0;
            buttonClickCounter.setText("Button Clicks: " + clickCounter);
        }
    }

    private void setGoal(int goalNum, int numClicks){
        clickCounter = 0;
        displayLabel = "";
        goalDisplay.setText("Goal: " + goalNum);
        constraintDisplay.setText(numClicks + " clicks");
        buttonClickCounter.setText("Button Clicks: " + numClicks);
        goal = goalNum;
        numClicksAllowed = numClicks;
    }

    private void calculate(){
        Context contextTwo = getApplicationContext();
        CharSequence textOver = "Goal Overshot!";
        CharSequence textUnder = "Goal Undershot!";
        CharSequence sillyGoose = "You can't do that you silly goose";
        int durationTwo = Toast.LENGTH_SHORT;

        Toast underShot = Toast.makeText(contextTwo, textUnder, durationTwo);
        Toast overShot = Toast.makeText(contextTwo, textOver, durationTwo);
        Toast fgd = Toast.makeText(contextTwo, sillyGoose, durationTwo);

        String expEval = display.getText().toString();
        Expression exp = new Expression(expEval);
        String resultS = String.valueOf(exp.calculate());

        if (display.getText().toString().equals(goal + "")){
            fgd.show();
            displayLabel = "";
            display.setText(displayLabel);

            clickCounter = 0;
            buttonClickCounter.setText("Button Clicks: " + clickCounter);

            return;
        }

        if (Double.parseDouble(resultS) == goal){
            if (level <= 5){
                newGoal();

                displayLabel = "";
                display.setText(displayLabel);

                level++;
            } else {
                backToStory();
            }

            clickCounter = 0;
        } else if (Double.parseDouble(resultS) < goal){
            displayLabel = "";
            display.setText(displayLabel);

            underShot.show();

            clickCounter = 0;
        } else {
            displayLabel = "";
            display.setText(displayLabel);

            overShot.show();

            clickCounter = 0;
        }
    }

    public void newGoal(){
        if(Math.random() < 0.5){
            int min = 3;
            int max = 10;

            int clicks = (int)Math.floor(Math.random()*(max-min+1)+min);

            if(clicks % 2 == 0){
                clicks += 1;
            }

            int operationGetter = (int)Math.floor(Math.random()*(3-1+1)+1);

            String operation = "+";
            if(operationGetter == 1){
                operation = "*";
            }else if(operationGetter == 2){
                operation = "-";
            }

            constraint = operation;

            int number = generator.getNumber(clicks, operation);

            setGoal(number, clicks);
        }else{
            int min = 3;
            int max = 10;

            int clicks = (int)Math.floor(Math.random()*(max-min+1)+min);

            if(clicks % 2 == 0){
                clicks += 1;
            }

            constraint = "";

            int number = generator.getNumber(clicks);

            setGoal(number, clicks);
        }
    }

    private void backToStory(){
        Intent intent = new Intent(this, ActualStoryMode.class);
        startActivity(intent);

        backgroundMusic.release();
    }

    private void deathScreen(){
        Intent intent = new Intent(this, death_screen.class);
        startActivity(intent);

        backgroundMusic.stop();
    }
}