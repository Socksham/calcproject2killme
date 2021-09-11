package com.example.calculatorprojectv2;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TutorialActivity extends AppCompatActivity {

    Button nBtn;
    TextView mLabel, iLabel, iTwoLabel;
    ImageView dOne, dTwo;

    private int count = 0;
    private String[] iLabelText= new String[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        nBtn = (Button) findViewById(R.id.nextButton);
        //^^ Button that switches the TextViews to different texts

        mLabel = (TextView) findViewById(R.id.titleLabel);
        iLabel = (TextView) findViewById(R.id.instructionLabelOne);
        iTwoLabel = (TextView) findViewById(R.id.instructionLabelTwo);
        //^^ TextViews displaying everything

        dOne = (ImageView) findViewById(R.id.descImage);
        dTwo = (ImageView) findViewById(R.id.arrowGuide);
        //^^ ImageView that displays the information

        iLabelText[0] = "These are multiple pieces of information that are available to you";
        iLabelText[1] = "This is the button limit, the number of button clicks available to you"; //case 2
        iLabelText[2] = "This is the operation Constraint, where it tells you what operation you can use"; //case 3
        iLabelText[3] = "This is the level display you're currently on"; //case 4
        iLabelText[4] = "This is the Goal Number to get to"; //case 5
        iLabelText[5] = "Finally, this is the Display where your numbers will be displayed"; //case 6
        iLabelText[6] = "Now, let's get some practice in!"; //case 7
        //^^ All Array Entries

        nBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count < 7){
                    count++;

                    updateLabels();
                } else {
                    returnMenu();
                }
            }
        });
    }

    private void updateLabels(){
        switch (count){
            case 2:
                dOne.setVisibility(View.VISIBLE);
                dTwo.setVisibility(View.VISIBLE);
                break;
            case 3:
                dOne.setImageResource(R.drawable.guidessoneconstraints);
                break;
            case 4:
                //Level Display
                break;
            case 5:
                dOne.setImageResource(R.drawable.guidesstwogoal);
                break;
            case 6:
                dOne.setImageResource(R.drawable.guidesstwodisplay);
                break;
            case 7:
                dOne.setVisibility(View.INVISIBLE);
                dTwo.setVisibility(View.INVISIBLE);
                break;
        }

        iLabel.setText(iLabelText[count - 1]);
    }

    private void returnMenu(){
        Intent intent = new Intent(this, SMandT.class);
        startActivity(intent);
    }
}
