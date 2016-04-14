package src.projetostorm.youtubeHelper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import src.projetostorm.R;
import src.projetostorm.data.VideoData;

/**
 * Created by x on 13/04/2016.
 */
public class YoutubeAdapter extends BaseAdapter {

    private final List<VideoData> items;
    private final Context context;

    public YoutubeAdapter(Context context, List<VideoData> items) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.video_feed_item, null);
            holder = new ViewHolder();

            holder.itemTitle = (TextView) convertView.findViewById(R.id.video_title);
            holder.itemThumbnail = (ImageView)convertView.findViewById(R.id.video_thumbnail);
            holder.itemDescription = (TextView)convertView.findViewById(R.id.video_description);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.itemTitle.setText(items.get(position).getVideoName());
        holder.itemDescription.setText(items.get(position).getVideoDescription());
        Picasso.with(context).load(items.get(position).getVideoThumbnailURL())
                .into(holder.itemThumbnail);
        return convertView;
    }

    static class ViewHolder {
        TextView itemTitle;
        ImageView itemThumbnail;
        TextView itemDescription;
    }

}
