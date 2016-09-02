package login.fragment.listeners;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.androidbelieve.drawerwithswipetabs.R;

/**
 * Created by Naman on 02/09/16.
 */
public class LoginActivityListners implements View.OnClickListener, View.OnFocusChangeListener {

    private static View rootView;
    private static AppCompatActivity context;
    private static ImageButton facebookImageButton;
    private static ImageButton instagramImageButton;
    private static ImageButton twitterImageButton;
    private static ImageButton linkedinImageButton;

    public LoginActivityListners(View view) {
        this.rootView = view.getRootView();
        context = (AppCompatActivity) rootView.getContext();
        initialize();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fb_glow_btn:
                facebookButtonclicked(view);
                break;
            case R.id.instagram_glow_btn:
                instagramButtonclicked(view);
                break;
            case R.id.linkedin_glow_btn:
                linkedinButtonclicked(view);
                break;
            case R.id.twitter_glow_btn:
                twitterButtonclicked(view);
                break;
            default:
                break;
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        switch (view.getId()) {
            case R.id.fb_glow_btn:
                facebookButtonclicked(view);
                break;
            case R.id.instagram_glow_btn:
                instagramButtonclicked(view);
                break;
            case R.id.linkedin_glow_btn:
                linkedinButtonclicked(view);
                break;
            case R.id.twitter_glow_btn:
                twitterButtonclicked(view);
                break;
            default:
                break;
        }
    }

    private void facebookButtonclicked(View view) {
        /*
        Start FB SDK Activity
         */
    }

    private void instagramButtonclicked(View view) {

    }

    private void linkedinButtonclicked(View view) {

    }

    private void twitterButtonclicked(View view) {

    }


    private void initialize() {
        facebookImageButton = (ImageButton) rootView.findViewById(R.id.fb_glow_btn);
        instagramImageButton = (ImageButton) rootView.findViewById(R.id.instagram_glow_btn);
        linkedinImageButton = (ImageButton) rootView.findViewById(R.id.linkedin_glow_btn);
        twitterImageButton = (ImageButton) rootView.findViewById(R.id.twitter_glow_btn);
    }

}
