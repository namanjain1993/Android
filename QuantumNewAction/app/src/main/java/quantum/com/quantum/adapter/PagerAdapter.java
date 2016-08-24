package quantum.com.quantum.adapter;

/**
 * Created by Naman on 24/08/16.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import quantum.com.quantum.fragments.PostNowFragment;
import quantum.com.quantum.fragments.ScheduleFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                PostNowFragment tab1 = new PostNowFragment();
                return tab1;
            case 1:
                ScheduleFragment tab2 = new ScheduleFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
