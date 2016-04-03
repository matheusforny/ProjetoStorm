package src.projetostorm.data;

import java.util.ArrayList;

/**
 * Created by x on 03/04/2016.
 */
public class TempVideoList {

    private static ArrayList<VideoData> videoDataArrayList;

    public static void initialize(){
        videoDataArrayList = new ArrayList<VideoData>();

        videoDataArrayList.add(new VideoData("ll21Z4uLMv0", "Aberturas Pellek",
                "Pellek Cantando Aberturas"));
        videoDataArrayList.add(new VideoData("vplj75kxhBA", "Know Know Know",
                "Abertura Gintama 17"));
    }

    public static ArrayList<VideoData> getVideoDataArrayList(){
        return videoDataArrayList;
    }
}
