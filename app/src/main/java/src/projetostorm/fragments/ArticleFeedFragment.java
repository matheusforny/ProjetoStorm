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
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import src.projetostorm.R;
import src.projetostorm.data.RssItem;
import src.projetostorm.listHelper.RssAdapter;
import src.projetostorm.rssHelper.RssService;

/**
 * Created by x on 10/04/2016.
 */
public class ArticleFeedFragment extends ListFragment implements AdapterView.OnItemClickListener {

    private View view;
    private ProgressBar progressBar;

    //TODO: IMPLEMENTAR BARRA DE PROGRESSO

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        return view;
    }

    private void startService() {
        Intent intent = new Intent(getActivity(), RssService.class);
        intent.putExtra("DADO_FEED", resultReceiver);
        getActivity().startService(intent);
    }

    private final ResultReceiver resultReceiver = new ResultReceiver(new Handler()) {
        @SuppressWarnings("unchecked")
        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            List<RssItem> items = (List<RssItem>) resultData.getSerializable("items");
            if (items != null) {
                RssAdapter adapter = new RssAdapter(getActivity(), items);
                setListAdapter(adapter);
            } else {
                Toast.makeText(getActivity(), "Erro com o feed",
                        Toast.LENGTH_LONG).show();
            }
            //progressBar.setVisibility(View.GONE);
            getListView().setVisibility(View.VISIBLE);
            getListView().setOnItemClickListener(ArticleFeedFragment.this);
        };
    };

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        RssAdapter adapter = (RssAdapter) parent.getAdapter();
        RssItem item = (RssItem) adapter.getItem(position);
        Uri uri = Uri.parse(item.getLink());
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}