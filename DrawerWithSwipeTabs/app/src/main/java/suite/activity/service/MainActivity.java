package suite.activity.service;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.androidbelieve.drawerwithswipetabs.R;

import suite.activity.helper.NavigationBarServiceHelper;
import suite.activity.helper.ToolBarServiceHelper;
import suite.fragments.TabFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new ToolBarServiceHelper(this).setToolBar();

        new NavigationBarServiceHelper(this).setNavigationBarView();

        /**
         * Lets inflate the very first fragment
         * Here , we are inflating the TabFragment as the first Fragment
         */
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();

    }

}