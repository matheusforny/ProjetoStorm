package src.projetostorm.listHelper;

import java.util.ArrayList;

import src.projetostorm.data.VideoData;

/**
 * Created by x on 03/04/2016.
 */
public class VideoListHelper {

    private static boolean hasInitialized = false;
    private static ArrayList<VideoData> videoDataArrayList;

    public static void initialize(){
        if(!hasInitialized) {
            videoDataArrayList = new ArrayList<VideoData>();

            videoDataArrayList.add(new VideoData("ll21Z4uLMv0", "Aberturas Pellek",
                    "Pellek Cantando Aberturas"));
            videoDataArrayList.add(new VideoData("vplj75kxhBA", "Know Know Know",
                    "Abertura Gintama 17"));

            hasInitialized = true;
        }
    }

    public static ArrayList<VideoData> getVideoDataArrayList(){
        return videoDataArrayList;
    }
}
