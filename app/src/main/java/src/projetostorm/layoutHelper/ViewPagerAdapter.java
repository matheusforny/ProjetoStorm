package src.projetostorm.layoutHelper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import src.projetostorm.fragments.ArticleFeedFragment;
import src.projetostorm.fragments.VideoFeedFragment;

/**
 * Created by x on 10/04/2016.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private CharSequence titles[];
    private int numberOfTabs;

    public ViewPagerAdapter(FragmentManager fragmentManager, CharSequence titles[],
                            int numberOfTabs) {
        super(fragmentManager);

        this.titles = titles;
        this.numberOfTabs = numberOfTabs;

    }

    @Override
    public Fragment getItem(int position) {

        if(position == 0) {
            VideoFeedFragment videoFeed = new VideoFeedFragment();
            return videoFeed;
        }
        else {
            ArticleFeedFragment articleFeed = new ArticleFeedFragment();
            return articleFeed;
        }

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
