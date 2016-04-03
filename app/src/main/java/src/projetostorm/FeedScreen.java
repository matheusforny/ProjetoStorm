package src.projetostorm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import src.projetostorm.data.TempVideoList;
import src.projetostorm.data.VideoData;

public class FeedScreen extends AppCompatActivity {

    private ListView videoListView;
    private ArrayList<VideoData> videoDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_screen);

        getExtras();

        TempVideoList.initialize();

        initializeVideoListView();
        registerClickCallBackOnVideoList();

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

    private void initializeVideoListView(){
        videoDatas = TempVideoList.getVideoDataArrayList();
        String[] videoNames = {videoDatas.get(0).getVideoName(), videoDatas.get(1).getVideoName()};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.video_list_item,
                videoNames
        );

        videoListView = (ListView) findViewById(R.id.videoListView);
        videoListView.setAdapter(adapter);

    }

    private void registerClickCallBackOnVideoList(){
        videoListView = (ListView) findViewById(R.id.videoListView);
        videoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Intent throwbackIntent = new Intent(FeedScreen.this, VideoScreen.class);
                throwbackIntent.putExtra("VIDEO_ID",
                        TempVideoList.getVideoDataArrayList().get(arg2).getVideoID());
                startActivity(throwbackIntent);
            }
        });
    }
}
