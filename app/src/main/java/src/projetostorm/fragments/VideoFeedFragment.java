package src.projetostorm.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;

import src.projetostorm.R;
import src.projetostorm.VideoScreen;
import src.projetostorm.data.VideoListHelper;
import src.projetostorm.data.VideoData;

/**
 * Created by x on 10/04/2016.
 */
public class VideoFeedFragment extends ListFragment implements OnItemClickListener {

    private ArrayList<VideoData> videoDatas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.video_list_container, container, false);

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        videoDatas = VideoListHelper.getVideoDataArrayList();
        String[] videoNames = {videoDatas.get(0).getVideoName(), videoDatas.get(1).getVideoName()};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity().getApplicationContext(),
                R.layout.video_list_item,
                videoNames
        );

        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        Intent intent = new Intent(getActivity(), VideoScreen.class);
        intent.putExtra("VIDEO_ID", VideoListHelper.getVideoDataArrayList().get(arg2).getVideoID());
        startActivity(intent);
    }
}
