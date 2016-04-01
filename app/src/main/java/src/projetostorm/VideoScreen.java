package src.projetostorm;

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

    private static final String VIDEO_URL = "http://www.html5videoplayer.net/videos/toystory.mp4";
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_screen);

        videoView = (VideoView) findViewById(R.id.videoView);
        Uri videoURI = Uri.parse(VIDEO_URL);
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoURI(videoURI);
        videoView.start();
        videoView.requestFocus();
    }

}
