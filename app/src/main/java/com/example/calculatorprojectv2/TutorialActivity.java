package com.example.calculatorprojectv2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TutorialActivity extends AppCompatActivity {

    Button nBtn;
    TextView mLabel, iLabel, iTwoLabel;

    private int count = 0;

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

        switch (count){
            case 0:
                count++;
                mLabel.setVisibility(View.GONE);
                iLabel.setText("These are multiple pieces of information that are available to you");
                break;
            case 1:
                count++;
                iLabel.setText("Such as the constraint information");
                iTwoLabel.setVisibility(View.VISIBLE);
                break;
        }
    }
}