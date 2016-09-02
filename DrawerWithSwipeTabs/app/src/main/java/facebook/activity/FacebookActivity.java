package facebook.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.androidbelieve.drawerwithswipetabs.R;
import com.facebook.FacebookSdk;

import facebook.activity.listener.FacebookActivityListner;

/**
 * Created by Naman on 02/09/16.
 */
public class FacebookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.facebook_login_layout);

        new FacebookActivityListner(this).setCallBackListner();

    }
}
