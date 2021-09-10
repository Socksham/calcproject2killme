package com.example.calculatorprojectv2;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

        nBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;

                updateLabels();
            }
        });
    }

    private void updateLabels(){
        switch (count){
            case 1:
                count++;
                iLabel.setText("These are multiple pieces of information that are available to you");
                break;
            case 2:
                count++;
                iLabel.setText("This is the button limit, the number of button clicks available to you");
                //add in image view to point towards (hand drawn arrow file) the information
                break;
            case 3:
                count++;
                iLabel.setText("I like Cheese");
        }
    }
}
