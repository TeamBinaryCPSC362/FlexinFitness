package com.example.flexinfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Calculators extends AppCompatActivity implements View.OnClickListener
{
    // INPUTS
    TextView txtV_age;
    TextView txtV_weight;
    TextView txtV_height;
    TextView txt_activityLevel;

    EditText edtxt_age;
    EditText edtxt_weight;
    EditText edtxt_height;
    EditText edtxt_activityLevel;

    // OUTPUTS


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculators);

        // connecting views
        // setting onclick listeners
    } // end onCreate()

    @Override
    public void onClick(View v)
    {
        // switch(R.id.<switch conditional>)
        //         ....
    } // end onClick()
} // end Calculators class
