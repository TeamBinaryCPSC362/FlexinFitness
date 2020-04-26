package com.example.flexinfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class LogInstance extends AppCompatActivity
{
    EditText    edtxt_workoutName;
    EditText    edtxt_workoutDate;
    EditText    edtxt_workoutTime;
    EditText    edtxt_workoutDuration;
    EditText    edtxt_userWeight;

    LinearLayout scrollViewLinearLayout;
    ImageView   imgV_picture;

    String workoutName;
    String workoutDate;
    String workoutTime;
    String workoutDuration;
    String userWeight;

    Bitmap picture;
    String currentPhotoPath;
    String[] editTextdata = new String[40];


    // region onCreate() =======================================================
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_proof);

        edtxt_workoutName = findViewById(R.id.txtV_workoutName);
        edtxt_workoutDate = findViewById(R.id.txtV_workoutDate);
        edtxt_workoutTime = findViewById(R.id.txtV_workoutTime);
        edtxt_workoutDuration = findViewById(R.id.txtV_workoutDuration);
        edtxt_userWeight = findViewById(R.id.txtV_userWeight);

        scrollViewLinearLayout = findViewById(R.id.scrollViewLinearLayout);
        imgV_picture = findViewById(R.id.imgV_picture);

        getWorkoutData();
        createAndSetEditTexts();
        setWorkoutData();
    } // endregion onCreate()


    // region getWorkoutData() =================================================
    /*
      In order to get the bundle of information that we passed from 'log',
      after clicking the newly created TextView, we need to declare a new
      intent to capture the one that we passed in
    */
    public void getWorkoutData()
    {
        Intent workoutData;
        workoutData = getIntent();

        workoutName = workoutData.getExtras().getString("WORKOUT_NAME");
        workoutDate = workoutData.getExtras().getString("WORKOUT_DATE");
        workoutDuration  = workoutData.getExtras().getString("DURATION");
        workoutTime = workoutData.getExtras().getString("START_TIME");
        userWeight = workoutData.getExtras().getString("BODYWEIGHT");
        currentPhotoPath = workoutData.getExtras().getString("picturePath");
        editTextdata = workoutData.getStringArrayExtra("data");

        picture = BitmapFactory.decodeFile(currentPhotoPath);
    } // endregion getWorkoutData()


    // region setWorkoutData() =================================================
    public void setWorkoutData()
    {
        edtxt_workoutName.setText(workoutName);
        edtxt_workoutDate.setText(workoutDate);
        edtxt_workoutTime.setText(workoutTime);
        edtxt_workoutDuration.setText(workoutDuration);
        edtxt_userWeight.setText(userWeight);

        imgV_picture.setImageBitmap(picture);
    } // endregion setWorkoutData() p


    // region createAndSetEditTexts() ==========================================
    // create EditText, add to layout, set text
    public void createAndSetEditTexts()
    {
        for(int index=0; (null !=(editTextdata[index])) ;++index) {

            EditText exerciseEntry = new EditText(LogInstance.this);
            exerciseEntry.setId(View.generateViewId());
            exerciseEntry.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
            exerciseEntry.setSingleLine(false);

            LinearLayout.LayoutParams llp_edittext = new
                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            exerciseEntry.setLayoutParams(llp_edittext);

            scrollViewLinearLayout.addView(exerciseEntry);

            exerciseEntry.setText(editTextdata[index]);
        }
    }// endregion createEditTexts()

} // end log_proof class =======================================================
