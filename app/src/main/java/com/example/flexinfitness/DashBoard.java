package com.example.flexinfitness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class DashBoard extends AppCompatActivity implements View.OnClickListener {
    Button logout;
    Button btn_log;
    Button btn_settings;
    Button btn_workoutPlanner;
    Button btn_tutorials;

    TextView txtV_name;


    // region 0nCreate() =======================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        final FirebaseAuth mAuth = FirebaseAuth.getInstance();

        logout = findViewById(R.id.logOutButton);
        txtV_name = findViewById(R.id.nameTextView);
        btn_log = findViewById(R.id.btn_log);
        btn_settings = findViewById(R.id.btn_settings);
        btn_workoutPlanner = findViewById(R.id.btn_workoutPlanner);
        btn_tutorials = findViewById(R.id.btn_tutorials);

        btn_log.setOnClickListener(this);
        btn_settings.setOnClickListener(this);
        btn_workoutPlanner.setOnClickListener(this);
        btn_tutorials.setOnClickListener(this);


        final GoogleSignInAccount signInAccount =
                GoogleSignIn.getLastSignedInAccount(this);
        if (signInAccount != null) {
            // Retrieves user info to display.
            txtV_name.setText(signInAccount.getDisplayName());

            // Listens for a click on the sign out button.
            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final GoogleSignInOptions signInOptions = new
                            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN)
                            .requestIdToken(getString(R.string.default_web_client_id))
                            .requestEmail()
                            .build();

                    // Creates the current google sign in client instance
                    final GoogleSignInClient signInClient = GoogleSignIn.getClient(DashBoard.this, signInOptions);

                    // Signs out if firebase client
                    mAuth.signOut();
                    // Attempts to sign out of google client and listens for a success or failure
                    signInClient.signOut().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(DashBoard.this, signInAccount.getEmail() + " Logged out Successfull!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(DashBoard.this, signInAccount.getEmail() + " Failed to log out!", Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            });
        } else {
            // If they're in the application without being logged into, send them to the login screen.
            mAuth.signOut();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    }// endregion onCreate()


    // region onClick() ========================================================
    @Override
    public void onClick(View v)
    {
        switch( v.getId()) {

        case R.id.btn_log:
            Intent gotoLOGDIARYHOMEPAGE = new Intent(getApplicationContext(), Log.class);
            startActivity(gotoLOGDIARYHOMEPAGE);
            break;

        case R.id.btn_workoutPlanner:
            Intent workoutPlanner = new Intent(DashBoard.this, WorkoutPlanner.class);
            startActivity(workoutPlanner);
            break;

        case R.id.btn_tutorials:
            Intent tutorial = new Intent(DashBoard.this, Tutorial.class);
            startActivity(tutorial);
            break;

        case R.id.btn_settings:
            Intent goToSettings = new Intent(getApplicationContext(), settingOptions.class);
            startActivity(goToSettings);
            break;

        default:
            break;
        }
    } // endregion onClick()

} // endregion DashBoard clases

