package quantum.com.quantum.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import quantum.com.quantum.fragments.PostNowFragment;
import quantum.com.quantum.fragments.ScheduleFragment;

/**
 * Created by Naman on 23/08/16.
 */
public class FragmentSelectorAdaptor extends FragmentPagerAdapter {

    public FragmentSelectorAdaptor(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new PostNowFragment();
            case 1:
                return new ScheduleFragment();

            default:
                return new PostNowFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Post Now";
            case 1:
                return "SCHEDULE";

            default:
                return "";
        }
    }

}
