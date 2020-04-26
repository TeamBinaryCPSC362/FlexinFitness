package com.example.flexinfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Vector;

public class WorkoutPlanner extends AppCompatActivity implements View.OnClickListener
{
    Button doneButton;
    Button submitButton;

    EditText workoutNameEditText;
    EditText dateToPerformEditText;
    EditText timeToPerformEditText;
    EditText restBetweenSetsEditText;

    LinearLayout linearLayout;


    // region onCreate() ======================================================
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_planner);

        doneButton = findViewById(R.id.doneButton);
        submitButton = findViewById(R.id.submitButton);

        workoutNameEditText = findViewById(R.id.workoutNameEditText);
        dateToPerformEditText = findViewById(R.id.dateToPerformEditText);
        timeToPerformEditText = findViewById(R.id.timeToPerformEditText);
        restBetweenSetsEditText = findViewById(R.id.restBetweenSetsEditText);

        linearLayout = findViewById(R.id.linearLayoutInsideScrollView);

        doneButton.setOnClickListener(this);
        submitButton.setOnClickListener(this);

        workoutNameEditText.setOnClickListener(this);
        dateToPerformEditText.setOnClickListener(this);
        timeToPerformEditText.setOnClickListener(this);
        restBetweenSetsEditText.setOnClickListener(this);
    } // endregion onCreate()


    // region onClick() ========================================================
    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {

        case R.id.submitButton:
            Vector<String> inputs = getInputs();
            addView(inputs);
            clearEditTexts();
            break;

        case R.id.doneButton:
            Intent backToDashboard = new Intent(this, DashBoard.class);
            startActivity(backToDashboard);
            break;
        }
    } // endregion onClick()


    // region getInputs() ======================================================
    public Vector<String> getInputs()
    {
        // get strings
        String str_workoutName = workoutNameEditText.getText().toString();
        String str_dateToPerform = dateToPerformEditText.getText().toString();
        String str_timeToPerform = timeToPerformEditText.getText().toString();
        String str_restBetweenSets = restBetweenSetsEditText.getText().toString();

        // add to vector
        Vector<String> inputs = new Vector<>();
        inputs.add(str_workoutName.toUpperCase());
        inputs.add(str_dateToPerform.toUpperCase());
        inputs.add(str_timeToPerform.toUpperCase());
        inputs.add(str_restBetweenSets.toUpperCase());

        return inputs;
    } // endregion getInputs()


    // region addView() ========================================================
    @SuppressLint("SetTextI18n")
    public void addView(Vector<String> inputs)
    {
        // create exercise entry
        TextView workoutEntry = new TextView(WorkoutPlanner.this);
        workoutEntry.setId(View.generateViewId());

        LinearLayout.LayoutParams llp_edittext = new
                LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        workoutEntry.setLayoutParams(llp_edittext);

        // text properties
        workoutEntry.setTextColor(Color.BLACK);
        workoutEntry.setTextSize(20);
        workoutEntry.setGravity(Gravity.CENTER);
        workoutEntry.setBackgroundColor(Color.LTGRAY);

        // set one line of text
        workoutEntry.setText(inputs.get(0) + "     " + inputs.get(1) + "\n" + "TIME " +
                            inputs.get(2) +"   REST " + inputs.get(3));
        // add the view to the layout
        linearLayout.addView(workoutEntry);
    } // endregion addView()


    // region clearEditTexts() =================================================
    public void clearEditTexts()
    {
        workoutNameEditText.getText().clear();
        dateToPerformEditText.getText().clear();
        timeToPerformEditText.getText().clear();
        restBetweenSetsEditText.getText().clear();
    } // endregion clearEditTexts()

} // end workoutPlanner class