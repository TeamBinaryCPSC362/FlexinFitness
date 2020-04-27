package com.example.flexinfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Tutorial extends AppCompatActivity implements View.OnClickListener
{
    Button playPushUps;
    Button playCrunches;
    Button playSquats;
    Button playLunges;

    VideoView pushups_video;
    VideoView crunches_video;
    VideoView squats_video;
    VideoView lunges_video;

    MediaController mediaController;

    // region onCreate() =======================================================
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        playPushUps = findViewById(R.id.pushUpsButton);
        playCrunches = findViewById(R.id.crunchesButton);
        playSquats = findViewById(R.id.squatsButton);
        playLunges = findViewById(R.id.lungesButton);

        pushups_video = findViewById(R.id.webView1);
        crunches_video = findViewById(R.id.webView2);
        squats_video = findViewById(R.id.webView3);
        lunges_video = findViewById(R.id.webView4);

        playPushUps.setOnClickListener(this);
        playCrunches.setOnClickListener(this);
        playSquats.setOnClickListener(this);
        playLunges.setOnClickListener(this);
    } // endregion onCreate()


    // region onClick() ========================================================
    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
        case R.id.pushUpsButton:
            play_pushups();
            break;

        case R.id.crunchesButton:
            play_crunches();
            break;

        case R.id.squatsButton:
            play_squats();
            break;

        case R.id.lungesButton:
            playVideo4();
            break;
        }
    } // endregion onClick()


    // region play_pushups() ===================================================
    public void play_pushups()
    {
        mediaController = new MediaController(this);

        String pathToVideo = "android.resource://com.example.flexinfitness/"
                + R.raw.pushups_video_final;
        Uri uri = Uri.parse(pathToVideo);
        pushups_video.setVideoURI(uri);
        pushups_video.requestFocus();
        pushups_video.setMediaController(mediaController);
        mediaController.setAnchorView(pushups_video);

        pushups_video.start();
    } // endregion play_pushups()


    // region play_crunches() ==================================================
    public void play_crunches()
    {
        mediaController = new MediaController(this);

        String pathToVideo = "android.resource://com.example.flexinfitness/"
                + R.raw.crunches_video_final;
        Uri uri = Uri.parse(pathToVideo);
        crunches_video.setVideoURI(uri);
        crunches_video.requestFocus();
        crunches_video.setMediaController(mediaController);
        mediaController.setAnchorView(crunches_video);

        crunches_video.start();
    } // endregion play_crunches()


    // region play_squats() ====================================================
    public void play_squats()
    {
        mediaController = new MediaController(this);

        String pathToVideo = "android.resource://com.example.flexinfitness/"
                + R.raw.squat_video_final;
        Uri uri = Uri.parse(pathToVideo);
        squats_video.setVideoURI(uri);
        squats_video.requestFocus();
        squats_video.setMediaController(mediaController);
        mediaController.setAnchorView(squats_video);

        squats_video.start();
    } // endregion play_squats()


    // region play_lunges() ====================================================
    public void playVideo4()
    {
        mediaController = new MediaController(this);

        String pathToVideo = "android.resource://com.example.flexinfitness/"
                + R.raw.lunges_video_final;
        Uri uri = Uri.parse(pathToVideo);
        lunges_video.setVideoURI(uri);
        lunges_video.requestFocus();
        lunges_video.setMediaController(mediaController);
        mediaController.setAnchorView(lunges_video);

        lunges_video.start();
    } // endregion play_lunges()

} // end tutorial class
