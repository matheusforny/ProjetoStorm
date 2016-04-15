package src.projetostorm.data;

/**
 * Created by x on 11/04/2016.
 */
public class RssItem {

    private final String title;
    private final String link;
    private final String description;
    private final String thumbnailURL;

    public RssItem(String title, String link, String description, String thumbnailURL) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.thumbnailURL = thumbnailURL;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() { return description; }

    public String getThumbnailURL() { return thumbnailURL; }
}
