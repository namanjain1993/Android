package suite.fragments.listeners;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.androidbelieve.drawerwithswipetabs.R;

import suite.utils.Keys;
import suite.utils.LastLongPressed;
import suite.utils.PreferenceManager;

/**
 * Created by Naman on 30/08/16.
 */
public class PostNowListners implements View.OnClickListener, View.OnFocusChangeListener, View.OnLongClickListener {

    View rootView;
    private PreferenceManager preferenceManager;

    private View view;

    private EditText editText;

    private ImageButton universalBtn;
    private ImageButton facebookImgBtn;
    private ImageButton linkedinImgBtn;
    private ImageButton twitterImgBtn;
    private ImageButton instagramImgBtn;

    private TextView universalleftCharecterTextView;

    public PostNowListners(View rootView, View view, PreferenceManager preferenceManager) {
        this.rootView = rootView;
        this.preferenceManager = preferenceManager;
        this.view = view;
        initializeRequiredVariables(rootView);
    }

    @Override
    public void onClick(View view) {

        ImageButton imageButton;
        switch (view.getId()) {
            case R.id.universal_btn:
                changeUniversalButtonState(view);
                break;
            case R.id.fb_btn:
                changeFBButtonState(view);
                break;
            case R.id.instagram_btn:
                changeInstagramButtonState(view);
                break;
            case R.id.twitter_btn:
                changeTwitterButtonState(view);
                break;
            case R.id.linkedin_btn:
                changeLinkedinButtonState(view);
                break;
            default:
                break;
        }

    }

    @Override
    public void onFocusChange(View view, boolean isFocusChanged) {

        ImageButton imageButton;

        if (isFocusChanged) {
            switch (view.getId()) {
                case R.id.universal_btn:
                    changeUniversalButtonState(view);
                    break;
                case R.id.fb_btn:
                    changeFBButtonState(view);
                    break;
                case R.id.instagram_btn:
                    changeInstagramButtonState(view);
                    break;
                case R.id.twitter_btn:
                    changeTwitterButtonState(view);
                    break;
                case R.id.linkedin_btn:
                    changeLinkedinButtonState(view);
                    break;
                default:
            }
        }

    }


    private void changeUniversalButtonState(View view) {
        if (preferenceManager.isUniversalButtonClicked()) {
            preferenceManager.setUniversalButtonClicked(false);
            universalBtn.setImageResource(R.drawable.all_dark);
        } else {
            preferenceManager.setUniversalButtonClicked(true);
            universalBtn.setImageResource(R.drawable.all_glow);
        }
    }


    private void changeFBButtonState(View view) {
        if (preferenceManager.isFBButtonClicked()) {
            preferenceManager.setFBButtonClicked(false);
            facebookImgBtn.setImageResource(R.drawable.facebook_dark);
        } else {
            preferenceManager.setFBButtonClicked(true);
            facebookImgBtn.setImageResource(R.drawable.facebook_glow);
        }
    }

    private void changeInstagramButtonState(View view) {
        if (preferenceManager.isInstaButtonClicked()) {
            preferenceManager.setInstaButtonClicked(false);
            instagramImgBtn.setImageResource(R.drawable.instagram_dark);
        } else {
            preferenceManager.setInstaButtonClicked(true);
            instagramImgBtn.setImageResource(R.drawable.instagram_glow);
        }
    }

    private void changeTwitterButtonState(View view) {
        if (preferenceManager.isTwitterButtonClicked()) {
            preferenceManager.setTwitterButtonClicked(false);
            twitterImgBtn.setImageResource(R.drawable.twitter_dark);
        } else {
            preferenceManager.setTwitterButtonClicked(true);
            twitterImgBtn.setImageResource(R.drawable.twitter_glow);
        }
    }

    private void changeLinkedinButtonState(View view) {
        if (preferenceManager.isLinkedinButtonClicked()) {
            preferenceManager.setLinkedinButtonClicked(false);
            linkedinImgBtn.setImageResource(R.drawable.linkedin_dark);
        } else {
            preferenceManager.setLinkedinButtonClicked(true);
            linkedinImgBtn.setImageResource(R.drawable.linkedin_glow);
        }
    }

    @Override
    public boolean onLongClick(View view) {
        switch (view.getId()) {
            case R.id.universal_btn:
                Keys.LAST_LONG_PRESSED = LastLongPressed.UNIVERSAL;
                universalBtn = (ImageButton) view;
                onLongPressUniversalBtn();
                break;
            case R.id.fb_btn:
                Keys.LAST_LONG_PRESSED = LastLongPressed.FB;
                onLongPressFBBtn();
                break;
            case R.id.instagram_btn:
                Keys.LAST_LONG_PRESSED = LastLongPressed.INSTAGRAM;
                onLongPressInstagramBtn();
                break;
            case R.id.twitter_btn:
                Keys.LAST_LONG_PRESSED = LastLongPressed.TWITTER;
                onLongPressTwitterBtn();
                break;
            case R.id.linkedin_btn:
                Keys.LAST_LONG_PRESSED = LastLongPressed.LINKEDIN;
                onLongPressLinkedinBtn();
                break;
            default:
                break;
        }

        return true;
    }

    private void onLongPressUniversalBtn() {
        editText.setText(Keys.FACEBOOK_TEXT);
        universalBtn.setImageResource(R.drawable.editing);
    }

    private void onLongPressFBBtn() {
        editText.setText(Keys.FACEBOOK_TEXT);
        facebookImgBtn.setImageResource(R.drawable.editing);
    }

    private void onLongPressInstagramBtn() {
        editText.setText(Keys.INSTAGRAM_TEXT);
        instagramImgBtn.setImageResource(R.drawable.editing);
    }

    private void onLongPressLinkedinBtn() {
        editText.setText(Keys.LINKEDIN_TEXT);
        linkedinImgBtn.setImageResource(R.drawable.editing);
    }

    private void onLongPressTwitterBtn() {
        editText.setText(Keys.TWITTER_TEXT);
        twitterImgBtn.setImageResource(R.drawable.editing);
    }


    private void initializeRequiredVariables(View rootView) {

        editText = (EditText) rootView.findViewById(R.id.editText_post);
        universalBtn = (ImageButton) rootView.findViewById(R.id.universal_btn);
        facebookImgBtn = (ImageButton) rootView.findViewById(R.id.fb_btn);
        instagramImgBtn = (ImageButton) rootView.findViewById(R.id.instagram_btn);
        linkedinImgBtn = (ImageButton) rootView.findViewById(R.id.linkedin_btn);
        twitterImgBtn = (ImageButton) rootView.findViewById(R.id.twitter_btn);

    }
}
