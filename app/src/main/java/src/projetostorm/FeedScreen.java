package src.projetostorm;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import src.projetostorm.data.TempVideoList;
import src.projetostorm.data.VideoData;
import src.projetostorm.layoutHelper.SlidingTabLayout;
import src.projetostorm.layoutHelper.ViewPagerAdapter;

public class FeedScreen extends AppCompatActivity {

    private ArrayList<VideoData> videoDatas;
    private Toolbar toolbar;
    private ViewPager pager;
    private ViewPagerAdapter adapter;
    private SlidingTabLayout tabs;
    private CharSequence titles[] = {"Video","Artigos"};
    private int numberOfTabs = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_screen);

        getExtras();

        TempVideoList.initialize();
        initializeTabs();

        //initializeVideoListView();
        //registerClickCallBackOnVideoList();

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
        /*videoDatas = TempVideoList.getVideoDataArrayList();
        String[] videoNames = {videoDatas.get(0).getVideoName(), videoDatas.get(1).getVideoName()};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.video_list_item,
                videoNames
        );

        videoListView = (ListView) findViewById(R.id.videoListContainer);
        videoListView.setAdapter(adapter);*/

    }

    private void initializeTabs(){

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        adapter =  new ViewPagerAdapter(getSupportFragmentManager(), titles, numberOfTabs);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true);

        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        tabs.setViewPager(pager);
    }

    private void registerClickCallBackOnVideoList(){
        /*videoListView = (ListView) findViewById(R.id.videoListContainer);
        videoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Intent throwbackIntent = new Intent(FeedScreen.this, VideoScreen.class);
                throwbackIntent.putExtra("VIDEO_ID",
                        TempVideoList.getVideoDataArrayList().get(arg2).getVideoID());
                startActivity(throwbackIntent);
            }
        });*/
    }
}
