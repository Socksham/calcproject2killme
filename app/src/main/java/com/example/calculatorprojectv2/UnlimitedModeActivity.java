package com.example.calculatorprojectv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.calculatorprojectv2.utils.UnlimitedNumberGenerator;

public class UnlimitedModeActivity extends AppCompatActivity {

    Button checker;

    UnlimitedNumberGenerator generator = new UnlimitedNumberGenerator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unlimited_mode);

        checker = findViewById(R.id.button);

        checker.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // Functionality for the button...
                Log.d("TAG", "GOT HERE");
                int i = generator.getNumber(6, "+");
                Log.d("TAG", String.valueOf(i));
            }
        });
    }


}