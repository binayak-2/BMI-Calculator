package com.binayak.apps.bmi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    EditText weightET, heightETinch, heightETfeet;
    Button calcBT;
    TextView dispTV, dispTV2;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.main_actionBar);
        setSupportActionBar(myToolbar);
        initUI();
        setListeners();
    }

    private void initUI()
    {
        weightET = (EditText) findViewById(R.id.main_weightET);
        heightETinch = (EditText) findViewById(R.id.main_heightETin);
        heightETfeet = (EditText) findViewById(R.id.main_heightETft);
        calcBT = (Button) findViewById(R.id.main_calcBT);
        dispTV = (TextView) findViewById(R.id.main_tv);
        dispTV2 = (TextView) findViewById(R.id.main_tv2);

    }

    private void setListeners()
    {
        calcBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double wt = Double.parseDouble(weightET.getText().toString());
                double htin = Double.parseDouble(heightETinch.getText().toString());
                double htft = Double.parseDouble(heightETfeet.getText().toString());
                double htmtr = (htft*12+htin)/39.37;
                result = wt/(htmtr*htmtr);
                dispTV.setText("The Body Mass Index (BMI) is "+String.format("%.2f",result));
                calculateRange();
            }
        });

    }

    private void calculateRange()
    {
        if(result < 18.5)
        {
            dispTV2.setText("It falls in underweight range.");
        }
        else if(result >= 18.5 && result <= 24.9)
        {
            dispTV2.setText("It falls in healthy weight range.");
        }
        else if(result >= 25.0 && result <= 29.9)
        {
            dispTV2.setText("It falls in overweight range.");
        }
        else if(result >= 30.0)
        {
            dispTV2.setText("It falls in obese range.");
        }
        else {
            dispTV2.setText("Invalid Input");

        }
    }

}