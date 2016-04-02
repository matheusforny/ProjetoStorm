package src.projetostorm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;

import src.projetostorm.data.VideoData;

public class FeedScreen extends AppCompatActivity {

    private ArrayList<VideoData> arrayOfVideoData;
    private ArrayList<Button> arrayOfButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_screen);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        getExtras();
        createVideoDatas();
        configureButtons();
        setTestButton();
    }

    private void getExtras(){
        Bundle extras = getIntent().getExtras();

        if(extras != null)
        {
            if(extras.getBoolean("NO_URL_FLAG"))
                Toast.makeText(FeedScreen.this, "Problema na URL do video selecionado",
                        Toast.LENGTH_SHORT).show();
        }
    }

    private void createVideoDatas(){
        arrayOfVideoData = new ArrayList<VideoData>();
        String[] videoTags = {"Toy", "Story"};

        arrayOfVideoData.add(new VideoData("http://www.html5videoplayer.net/videos/toystory.mp4",
                "Toy Story", "Video Toy Story", videoTags));
    }

    private void configureButtons(){
        arrayOfButtons = new ArrayList<Button>();

        arrayOfButtons.add((Button) this.findViewById(R.id.testButton));
        arrayOfButtons.get(0).setText(arrayOfVideoData.get(0).getVideoName());
    }

    private void setTestButton() {
        arrayOfButtons.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changeScreenIntent = new Intent(FeedScreen.this, VideoScreen.class);
                //changeScreenIntent.putExtra("VIDEO_URL", arrayOfVideoData.get(0).getVideoUrl());
                startActivity(changeScreenIntent);
            }
        });
    }
}
