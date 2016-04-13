package src.projetostorm;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import src.projetostorm.data.CodeConstants;
import src.projetostorm.listHelper.VideoListHelper;
import src.projetostorm.layoutHelper.SlidingTabLayout;
import src.projetostorm.layoutHelper.ViewPagerAdapter;

public class FeedScreen extends AppCompatActivity {

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

        initializeTabs();

    }

    private void getExtras(){
        Bundle extras = getIntent().getExtras();

        if(extras != null)
        {
            if(extras.getBoolean(CodeConstants.INTENT_NO_URL_DATA))
                Toast.makeText(FeedScreen.this, R.string.error_youtube_feed,
                        Toast.LENGTH_SHORT).show();
        }
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
}
