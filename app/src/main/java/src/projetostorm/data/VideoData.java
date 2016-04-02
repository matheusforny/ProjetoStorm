package src.projetostorm.data;

/**
 * Created by x on 01/04/2016.
 */
public class VideoData {

    private String videoUrl;
    private String videoName;
    private String videoDescription;
    private String[] videoTags;

    public VideoData(String url, String name, String description, String[] tags) {
        this.videoUrl = url;
        this.videoName = name;
        this.videoDescription = description;
        this.videoTags = tags;
    }

    public String getVideoUrl(){
        return this.videoUrl;
    }

    public String getVideoName(){
        return this.videoName;
    }

    public String getVideoDescription(){
        return this.videoDescription;
    }

    public String[] getVideoTags(){
        return this.videoTags;
    }
}
