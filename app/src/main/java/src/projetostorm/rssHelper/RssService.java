package src.projetostorm.rssHelper;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import android.util.Log;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.List;

import src.projetostorm.data.CodeConstants;
import src.projetostorm.data.RssItem;

/**
 * Created by x on 11/04/2016.
 */
public class RssService extends IntentService {

    public RssService() {
        super("RssService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        List<RssItem> rssItems = null;

        try {
            Parser parser = new Parser();
            rssItems = parser.parse(getInputStream(CodeConstants.BLOG_FEED));
        } catch (XmlPullParserException e) {
            Log.w(e.getMessage(), e);
        } catch (IOException e) {
            Log.w(e.getMessage(), e);
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("items", (Serializable) rssItems);
        ResultReceiver receiver = intent.getParcelableExtra(CodeConstants.INTENT_FEED_DATA);
        receiver.send(0, bundle);
    }

    public InputStream getInputStream(String link) {
        try {
            URL url = new URL(link);
            return url.openConnection().getInputStream();
        } catch (IOException e) {
            return null;
        }
    }
}
