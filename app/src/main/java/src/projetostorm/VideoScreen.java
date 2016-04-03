package src.projetostorm;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import src.projetostorm.data.CodeKeys;

public class VideoScreen extends YouTubeBaseActivity {

    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        getExtras();

        //TODO: FIX PRE-FULLSCREEN PROBLEM
    }

    private void initializeYoutube(final String videoID){
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubePlayer);
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.setFullscreen(true);
                youTubePlayer.loadVideo(videoID);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
    }

    private void getExtras(){
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            if(extras.containsKey("VIDEO_ID")) {
                initializeYoutube(extras.getString("VIDEO_ID"));
                youTubePlayerView.initialize(CodeKeys.YOUTUBE_API_KEY, onInitializedListener);
            }
            else
                throwback();
        } else
            throwback();
    }

    private void throwback(){
        Intent throwbackIntent = new Intent(VideoScreen.this, FeedScreen.class);
        throwbackIntent.putExtra("NO_URL_FLAG", true);
        startActivity(throwbackIntent);
    }

}
