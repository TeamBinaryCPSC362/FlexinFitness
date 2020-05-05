package com.example.flexinfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculators extends AppCompatActivity
{
    Button btn_calculate;

    // INPUTS
    TextView txtV_age;
    TextView txtV_weight;
    TextView txtV_height;
    TextView txtV_activityLevel;

    EditText edtxt_age;
    EditText edtxt_weight;
    EditText edtxt_height;
    EditText edtxt_activityLevel;

    // OUTPUTS
    TextView txtV_bmi;
    TextView txtV_caloriesNeeded;

    TextView txtV_bmiResult;
    TextView txtV_caloriesNeededResult;

    // DATA
    String str_age;
    String str_height;
    String str_weight;
    String str_activityLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculators);

        // connecting views & setting onclick listeners
        btn_calculate = findViewById(R.id.btn_calculate);

        txtV_age = findViewById(R.id.txtV_age);
        txtV_weight = findViewById(R.id.txtV_weight);
        txtV_height = findViewById(R.id.txtV_height);
        txtV_activityLevel = findViewById(R.id.txtV_activityLevel);

        edtxt_age = findViewById(R.id.edtxt_age);
        edtxt_weight = findViewById(R.id.edtxt_weight);
        edtxt_height = findViewById(R.id.edtxt_height);
        edtxt_activityLevel = findViewById(R.id.edtxt_activityLevel);

        txtV_bmi = findViewById(R.id.txtV_bmi);
        txtV_caloriesNeeded = findViewById(R.id.txtV_caloriesNeeded);

        txtV_bmiResult = findViewById(R.id.txtV_bmiResult);
        txtV_caloriesNeededResult = findViewById(R.id.txtV_caloriesNeededResult);
    } // end onCreate()

    public void calculate(View view)
    {
        str_age = edtxt_age.getText().toString();
        str_height = edtxt_height.getText().toString();
        str_weight = edtxt_weight.getText().toString();
        str_activityLevel = edtxt_activityLevel.getText().toString();
    }

} // end Calculators class