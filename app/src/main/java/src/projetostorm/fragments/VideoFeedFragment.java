package src.projetostorm.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ListFragment;
import android.support.v4.os.ResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import src.projetostorm.R;
import src.projetostorm.VideoScreen;
import src.projetostorm.data.RssItem;
import src.projetostorm.data.VideoData;
import src.projetostorm.listHelper.RssAdapter;
import src.projetostorm.listHelper.VideoListHelper;
import src.projetostorm.youtubeHelper.YoutubeAdapter;

/**
 * Created by x on 10/04/2016.
 */
public class VideoFeedFragment extends ListFragment implements OnItemClickListener {

    private View view;
    private ProgressBar progressBar;
    private Handler handler;
    private List<VideoData> videoDatas;
    private Bundle savedInstanceState;

    //TODO: IMPLEMENTAR BARRA DE PROGRESSO

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(view == null) {
            view = inflater.inflate(R.layout.article_list_container, container, false);
            startService();
        } else {
            ViewGroup parent = (ViewGroup) view.getParent();
            parent.removeView(view);
        }

        this.savedInstanceState = savedInstanceState;

        return view;
    }

    private void startService() {
        VideoListHelper.initialize(getContext());
        handler = new Handler();
        searchOnYoutube("MdM Melhores do Mundo");
    }

    private void searchOnYoutube(final String keywords){
        new Thread(){
            public void run(){;
                videoDatas = VideoListHelper.search(keywords);
                handler.post(new Runnable(){
                    public void run(){
                        YoutubeAdapter youtubeAdapter = new YoutubeAdapter(getActivity(),
                                videoDatas);
                        setListAdapter(youtubeAdapter);
                        getListView().setOnItemClickListener(VideoFeedFragment.this);
                    }
                });
            }
        }.start();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        YoutubeAdapter adapter = (YoutubeAdapter) parent.getAdapter();
        VideoData data = (VideoData) adapter.getItem(position);
        Intent intent = new Intent(getActivity(), VideoScreen.class);
        intent.putExtra("VIDEO_ID", data.getVideoID());
        startActivity(intent);
    }
}