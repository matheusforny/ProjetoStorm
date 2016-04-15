package src.projetostorm.rssHelper;

import android.util.Xml;

import com.google.android.youtube.player.YouTubePlayer;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import src.projetostorm.data.RssItem;

/**
 * Created by x on 11/04/2016.
 */
public class Parser {

    private final String ns = null;

    public List<RssItem> parse(InputStream inputStream) throws XmlPullParserException, IOException {
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(inputStream, null);
            parser.nextTag();
            return readFeed(parser);
        } finally {
            inputStream.close();
        }
    }

    private List<RssItem> readFeed(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, null, "rss");
        String title = null;
        String link = null;
        String description = null;
        String thumbnailURL = null;
        List<RssItem> items = new ArrayList<>();
        while (parser.next() != XmlPullParser.END_DOCUMENT) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("title")) {
                title = readData(parser, "title");
            } else if (name.equals("link")) {
                link = readData(parser, "link");
            } else if( name.equals("description")) {
                description = readData(parser, "description");
            } else if (name.equals("url")) {
                thumbnailURL = readData(parser, "url");
            }
            if (title != null && link != null && thumbnailURL != null) {
                RssItem item = new RssItem(title, link, description, thumbnailURL);
                items.add(item);
                title = null;
                link = null;
            }
        }
        return items;
    }

    private String readData(XmlPullParser parser, String data) throws XmlPullParserException,
            IOException {
        parser.require(XmlPullParser.START_TAG, ns, data);
        String result = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, data);
        return result;
    }

    private String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }

}
