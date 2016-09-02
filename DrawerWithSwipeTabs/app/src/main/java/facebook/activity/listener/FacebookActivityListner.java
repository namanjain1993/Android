package facebook.activity.listener;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.androidbelieve.drawerwithswipetabs.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

/**
 * Created by Naman on 02/09/16.
 */
public class FacebookActivityListner {


    private AppCompatActivity context;

    private TextView info;
    private LoginButton loginButton;
    private CallbackManager callbackManager;

    public FacebookActivityListner(AppCompatActivity context) {
        this.context = context;
        initialize();
    }

    private void initialize() {
        info = (TextView) context.findViewById(R.id.info);
        loginButton = (LoginButton) context.findViewById(R.id.login_button);
        callbackManager = CallbackManager.Factory.create();
    }


    public void setCallBackListner() {

    }


}
