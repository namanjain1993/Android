package suite.activity.service;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.androidbelieve.drawerwithswipetabs.R;

import suite.activity.helper.NavigationBarServiceHelper;
import suite.activity.helper.ToolBarServiceHelper;
import suite.fragments.TabFragment;
import suite.utils.ApplicationPreferenceManager;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new ApplicationPreferenceManager(this);

        new ToolBarServiceHelper(this).setToolBar();

        new NavigationBarServiceHelper(this).setNavigationBarView();

        /**
         * Lets inflate the very first fragment
         * Here , we are inflating the TabFragment as the first Fragment
         */
        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.addToBackStack(null).replace(R.id.containerView, new TabFragment()).commit();

    }


    public void replaceFragments(Class fragmentClass) {
        Fragment fragment = null;

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.containerView);
        frameLayout.removeAllViews();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().addToBackStack(null).replace(R.id.containerView, fragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();

    }

    @Override
    public void onBackPressed() {

        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
        } else {
            getSupportFragmentManager().popBackStack();
        }

    }


}