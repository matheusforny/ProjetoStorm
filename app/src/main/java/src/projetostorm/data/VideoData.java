package src.projetostorm.data;

/**
 * Created by x on 01/04/2016.
 */
public class VideoData {

    private String videoID;
    private String videoName;
    private String videoDescription;

    public VideoData(String videoID, String name, String description) {
        this.videoID = videoID;
        this.videoName = name;
        this.videoDescription = description;
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
}
