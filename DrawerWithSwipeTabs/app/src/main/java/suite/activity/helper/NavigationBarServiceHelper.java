package suite.activity.helper;

import android.content.Context;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.androidbelieve.drawerwithswipetabs.R;

import suite.fragments.TabFragment;

/**
 * Created by Naman on 28/08/16.
 */
public class NavigationBarServiceHelper {

    private AppCompatActivity context;
    private FragmentManager mFragmentManager;
    private Toolbar mToolBar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    public NavigationBarServiceHelper(Context base) {
        this.context = (AppCompatActivity) base;
    }

    public void setNavigationBarView() {

        mFragmentManager = context.getSupportFragmentManager();
        mToolBar = (Toolbar) context.findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) context.findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) context.findViewById(R.id.navBar);

        setNavigationItemListener();
        setActionBarToggle();

    }


    private void setNavigationItemListener() {

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();


                if (menuItem.getItemId() == R.id.nav_item_home) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();

                }

                if (menuItem.getItemId() == R.id.nav_item_accounts) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();
                }

                if (menuItem.getItemId() == R.id.nav_item_anlytics) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();
                }

                if (menuItem.getItemId() == R.id.nav_item_timezone) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();
                }

                return false;
            }

        });

    }


    private void setActionBarToggle(){

        /**
         * Setup Drawer Toggle of the Toolbar
         */
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(context, mDrawerLayout, mToolBar, R.string.open_drawer, R.string.close_drawer) {

            @Override
            public void onDrawerStateChanged(int newState) {
                if (newState == DrawerLayout.STATE_SETTLING) {
                    if (!isDrawerOpen()) {
                        context.getSupportActionBar().setTitle(R.string.open_nav_icon);
                    } else {
                        context.getSupportActionBar().setTitle(R.string.app_name);
                    }
                    context.invalidateOptionsMenu();
                }
            }

        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();

    }


    private boolean isDrawerOpen() {

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            return true;
        } else {
            return false;
        }

    }


}
