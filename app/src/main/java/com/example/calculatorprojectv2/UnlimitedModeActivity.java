package com.example.calculatorprojectv2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculatorprojectv2.utils.UnlimitedNumberGenerator;

import org.mariuszgromada.math.mxparser.Expression;

import java.util.ArrayList;

public class UnlimitedModeActivity extends AppCompatActivity {

    UnlimitedNumberGenerator generator = new UnlimitedNumberGenerator();

    TextView display, goalDisplay, buttonClickCounter, constraintDisplay, levelDisplay;
    //add a TextView for the number that the use has to reach
    Button bOne, bTwo, bThree, bFour, bFive, bSix, bSeven, bEight, bNine, bAdd, bSub,
            bMulti, bDiv, cButton;

    private int clickCounter = 0;

    private int level = 0;

    private String displayLabel = "";

    private int goal;
    private int numClicksAllowed;

    String constraint = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unlimited_mode);

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

        display = (TextView) findViewById(R.id.display);
        goalDisplay = (TextView) findViewById((R.id.goalDisplay));
        buttonClickCounter = (TextView) findViewById(R.id.buttonClickCounter);
        constraintDisplay = (TextView) findViewById(R.id.constraintDisplay);
        levelDisplay = (TextView) findViewById(R.id.levelLabel);

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

        bOne.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                handleNumBtnClick("1");
            }
        });

        bTwo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                handleNumBtnClick("2");
            }
        });

        bThree.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                handleNumBtnClick("3");
            }
        });

        bFour.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                handleNumBtnClick("4");
            }
        });

        bFive.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                handleNumBtnClick("5");
            }
        });

        bSix.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                handleNumBtnClick("6");
            }
        });

        bSeven.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                handleNumBtnClick("7");
            }
        });

        bEight.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                handleNumBtnClick("8");
            }
        });

        bNine.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                handleNumBtnClick("9");
            }
        });

        bAdd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                handleNumBtnClick("+");
            }
        });
        bSub.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                handleNumBtnClick("-");
            }
        });
        bMulti.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                handleNumBtnClick("*");
            }
        });
        cButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                calculate();
            }
        });

    }

    private void setGoal(int goalNum, int numClicks){
        clickCounter = 0;
        displayLabel = "";
        goalDisplay.setText("Goal: " + goalNum);
        constraintDisplay.setText(numClicks + " clicks");
        buttonClickCounter.setText("Button Clicks: " + numClicks);
        level++;
        levelDisplay.setText("Level: " + level);
        goal = goalNum;
        numClicksAllowed = numClicks;
        if(!constraint.equals("")){
            constraintDisplay.setText("Constraints: " + constraint);

        }else{
            constraintDisplay.setText("");

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

        if(clickCounter > numClicksAllowed){
            toast.show();
            displayLabel = "";
            display.setText(displayLabel);
            clickCounter = 0;
            buttonClickCounter.setText("Button Clicks: " + clickCounter);
        }
    }

    public void calculate(){
        Context contextTwo = getApplicationContext();
        CharSequence textOver = "Goal Overshot!";
        CharSequence textUnder = "Goal Undershot!";
        int durationTwo = Toast.LENGTH_SHORT;

        boolean err = false;

        Toast underShot = Toast.makeText(contextTwo, textUnder, durationTwo);
        Toast overShot = Toast.makeText(contextTwo, textOver, durationTwo);

        String expEval = display.getText().toString();

        Log.d("TAG", expEval);
        ArrayList<Integer> numbersFinal = new ArrayList<>();
        ArrayList<Boolean> numberOrOperations = new ArrayList<>();
        ArrayList<Character> operationsFinal = new ArrayList<>();

        boolean lastWasOperation = true;

        for(int i = 0; i < expEval.length(); i++){
            Log.d("TAG", String.valueOf(expEval.charAt(i)));
            if(expEval.charAt(i) == "+".charAt(0) || expEval.charAt(i) == "-".charAt(0) || expEval.charAt(i) == "*".charAt(0)){
                operationsFinal.add(expEval.charAt(i));
                numberOrOperations.add(true);
                lastWasOperation = true;
            }else{
                if(lastWasOperation){
                    numbersFinal.add(Integer.parseInt(String.valueOf(expEval.charAt(i))));
                    lastWasOperation = false;
                }else{
                    String numIn = numbersFinal.get(numbersFinal.size() - 1).toString();
                    numIn += String.valueOf(expEval.charAt(i));
                    numbersFinal.set(numbersFinal.size() - 1, Integer.parseInt(numIn));
                    lastWasOperation = false;
                }
                if(i != 0){
                    numberOrOperations.add(false);
                }
            }
        }
        Log.d("TAG", "DIE");
        Log.d("TAG", String.valueOf(numbersFinal));
        Log.d("TAG", String.valueOf(operationsFinal));

        if(!constraint.equals("")){
            for(int d = 0; d < operationsFinal.size(); d++){
                Log.d("TAG", constraint);
                if(!String.valueOf(operationsFinal.get(d)).equals(constraint)){
                    err = true;
                }
            }
        }

       if(!err){
           int finalNum = 0;
           for(int z = 0; z < numbersFinal.size(); z++){
               if(z == 0){
                   finalNum += numbersFinal.get(z);
               }else{
                   if(operationsFinal.get(z - 1) == "+".charAt(0)){
                       finalNum += numbersFinal.get(z);
                   }else if(operationsFinal.get(z - 1) == "-".charAt(0)){
                       finalNum -= numbersFinal.get(z);
                   }else{
                       finalNum *= numbersFinal.get(z);
                   }

               }
               Log.d("TAG", String.valueOf(finalNum));
           }

           expEval = expEval.replaceAll("×", "*");


           Expression exp = new Expression(expEval);


           String resultS = String.valueOf(exp.calculate());


           double result = Double.parseDouble(resultS);

               if (finalNum == goal){
                   newGoal();
               } else {
                   if (finalNum > goal){
                       overShot.show();
                   } else {
                       underShot.show();
                   }

                   displayLabel = "";
                   clickCounter = 0;
               }

               display.setText(displayLabel);
               buttonClickCounter.setText("Button Clicks: " + clickCounter);
       }else{
           Toast error = Toast.makeText(contextTwo, "Did not meet constraints!", durationTwo);
            error.show();
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

}