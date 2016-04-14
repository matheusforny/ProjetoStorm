package src.projetostorm.data;

/**
 * Created by x on 01/04/2016.
 */
public class VideoData {

    private String videoID;
    private String videoName;
    private String videoDescription;
    private String videoThumbnailURL;

    public VideoData(String videoID, String name, String description, String videoThumbnailURL) {
        this.videoID = videoID;
        this.videoName = name;
        this.videoDescription = description;
        this.videoThumbnailURL = videoThumbnailURL;
    }

    public String getVideoID(){
        return this.videoID;
    }

    public String getVideoName(){
        return this.videoName;
    }

    public String getVideoDescription(){
        return this.videoDescription;
    }

    public String getVideoThumbnailURL() { return this.videoThumbnailURL; }
}
