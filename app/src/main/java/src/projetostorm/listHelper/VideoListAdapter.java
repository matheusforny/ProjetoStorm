package src.projetostorm.listHelper;

import android.content.Context;
import android.widget.ArrayAdapter;

import src.projetostorm.R;

/**
 * Created by x on 10/04/2016.
 */
public class VideoListAdapter {

    private static ArrayAdapter<String> arrayAdapter;

    public static void initialize(Context context, String[] videoNames)
    {
        arrayAdapter = new ArrayAdapter<String>(
                context,
                R.layout.video_list_item,
                videoNames
        );
    }

    public static ArrayAdapter getArrayAdapter(){
        return arrayAdapter;
    }

}
