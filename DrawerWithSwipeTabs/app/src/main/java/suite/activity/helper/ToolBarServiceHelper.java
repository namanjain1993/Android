package suite.activity.helper;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.androidbelieve.drawerwithswipetabs.R;

/**
 * Created by Naman on 28/08/16.
 */
public class ToolBarServiceHelper {

    private AppCompatActivity context;
    private Toolbar mToolBar;

    public ToolBarServiceHelper(Context base) {
        this.context = (AppCompatActivity) base;
    }


    public void setToolBar(){

        mToolBar = (Toolbar) context.findViewById(R.id.toolbar);
        context.setSupportActionBar(mToolBar);
        context.getSupportActionBar().setTitle(R.string.app_name);

    }

}
