package src.projetostorm.listHelper;

import android.content.Context;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import src.projetostorm.data.CodeKeys;
import src.projetostorm.data.VideoData;

/**
 * Created by x on 03/04/2016.
 */
public class VideoListHelper {

    private static boolean hasInitialized = false;
    private static YouTube youtube;
    private static YouTube.Search.List query;

    public static void initialize(Context context){

        youtube = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(),
                new HttpRequestInitializer() {
                    @Override
                    public void initialize(HttpRequest httpRequest) throws IOException {}
                }).setApplicationName("Projeto Storm").build();

        try {
            query = youtube.search().list("id,snippet");
            query.setKey(CodeKeys.YOUTUBE_API_KEY);
            query.setType("video");
            query.setFields("items(id/videoId,snippet/title,snippet/description,snippet/thumbnails/default/url)");
        } catch (IOException e) {

        }
    }

    public static List<VideoData> search(String keywords){
        query.setQ(keywords);
        try{
            SearchListResponse response = query.execute();
            List<SearchResult> results = response.getItems();

            List<VideoData> items = new ArrayList<VideoData>();
            for(SearchResult result:results){
                VideoData item = new VideoData(result.getId().getVideoId(),
                        result.getSnippet().getTitle(), result.getSnippet().getDescription());
                items.add(item);
            }
            return items;
        }catch(IOException e){
            return null;
        }
    }}
