package src.projetostorm.rssHelper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import src.projetostorm.R;
import src.projetostorm.data.RssItem;

/**
 * Created by x on 11/04/2016.
 */
public class RssAdapter extends BaseAdapter{

    private final List<RssItem> items;
    private final Context context;

    public RssAdapter(Context context, List<RssItem> items) {
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
            convertView = View.inflate(context, R.layout.article_feed_item, null);
            holder = new ViewHolder();

            holder.itemTitle = (TextView)convertView.findViewById(R.id.article_title);
            holder.itemThumbnail = (ImageView)convertView.findViewById(R.id.article_thumbnail);
            holder.itemDescription = (TextView)convertView.findViewById(R.id.article_description);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.itemTitle.setText(items.get(position).getTitle());
        holder.itemDescription.setText(items.get(position).getDescription());
        Picasso.with(context).load(items.get(position).getThumbnailURL())
                .into(holder.itemThumbnail);
        return convertView;
    }

    static class ViewHolder {
        TextView itemTitle;
        ImageView itemThumbnail;
        TextView itemDescription;
    }

}
