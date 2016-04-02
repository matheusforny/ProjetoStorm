package src.projetostorm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoScreen extends AppCompatActivity {

    private String videoURL;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_screen);

        getExtras();

        //TODO: FIX VIDEO SIZE;
    }

    private void getExtras(){
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            if(extras.containsKey("VIDEO_URL")) {
                videoURL = extras.getString("VIDEO_URL");
                playVideo();
            }
            else
                throwback();
        } else
            throwback();
    }

    private void playVideo(){
        videoView = (VideoView) findViewById(R.id.videoView);
        Uri videoURI = Uri.parse(videoURL);
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoURI(videoURI);
        videoView.start();
        videoView.requestFocus();
    }

    private void throwback(){
        Intent throwbackIntent = new Intent(VideoScreen.this, FeedScreen.class);
        throwbackIntent.putExtra("NO_URL_FLAG", true);
        startActivity(throwbackIntent);
    }

}
