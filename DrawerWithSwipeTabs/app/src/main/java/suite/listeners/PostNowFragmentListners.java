package suite.listeners;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidbelieve.drawerwithswipetabs.R;

import suite.activity.service.MainActivity;
import commons.utils.GlobalVariables;
import suite.fragments.PreviewNowFragment;
import commons.constants.Constants;

/**
 * Created by Naman on 30/08/16.
 */
public class PostNowFragmentListners implements View.OnClickListener, View.OnFocusChangeListener, TextWatcher {


    private static AppCompatActivity context;
    private static GlobalVariables globalVariables;
    private static View rootView;
    private static View view;
    private static LinearLayout addMediaImageButton;
    private static ImageButton facebookImgBtn;
    private static ImageButton linkedinImgBtn;
    private static ImageButton twitterImgBtn;
    private static ImageButton instagramImgBtn;
    private static TextView universalleftCharecterTextView;
    private static Fragment fragment;
    private static boolean isAlreadyInitialized;

    public PostNowFragmentListners(View view, Fragment fragment) {
        if (!isAlreadyInitialized) {
            isAlreadyInitialized = true;
            this.rootView = view.getRootView();
            this.view = view;
            context = (AppCompatActivity) rootView.getContext();
            this.fragment = fragment;
            initializeRequiredVariables(rootView);
        }
    }

    @Override
    public void onClick(View view) {

        ImageButton imageButton;
        switch (view.getId()) {
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
            case R.id.add_media_btn:
                addMediaButtonClicked(view);
                break;
            case R.id.previewnow_btn:
                previewNowButtonClicked();
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
                case R.id.add_media_btn:
                    addMediaButtonClicked(view);
                    break;
                case R.id.previewnow_btn:
                    previewNowButtonClicked();
                    break;
                default:
            }
        }

    }


    private void changeFBButtonState(View view) {
        if (globalVariables.isFacebookButtonClicked()) {
            globalVariables.setFacebookButtonClicked(false);
            facebookImgBtn.setImageResource(R.drawable.facebook_dark);
        } else {
            globalVariables.setFacebookButtonClicked(true);
            facebookImgBtn.setImageResource(R.drawable.facebook_glow);
        }
    }

    private void changeInstagramButtonState(View view) {
        if (globalVariables.isInstagramButtonClicked()) {
            globalVariables.setInstagramButtonClicked(false);
            instagramImgBtn.setImageResource(R.drawable.instagram_dark);
        } else {
            globalVariables.setInstagramButtonClicked(true);
            instagramImgBtn.setImageResource(R.drawable.instagram_glow);
        }
    }

    private void changeTwitterButtonState(View view) {
        if (globalVariables.isTwitterButtonClicked()) {
            globalVariables.setTwitterButtonClicked(false);
            twitterImgBtn.setImageResource(R.drawable.twitter_dark);
        } else {
            globalVariables.setTwitterButtonClicked(true);
            twitterImgBtn.setImageResource(R.drawable.twitter_glow);
        }
    }

    private void changeLinkedinButtonState(View view) {
        if (globalVariables.isLinkedinButtonClicked()) {
            globalVariables.setLinkedinButtonClicked(false);
            linkedinImgBtn.setImageResource(R.drawable.linkedin_dark);
        } else {
            globalVariables.setLinkedinButtonClicked(true);
            linkedinImgBtn.setImageResource(R.drawable.linkedin_glow);
        }
    }

    private void addMediaButtonClicked(View view) {

        Intent intent = new Intent();
        intent.setType("image/*,video/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        fragment.startActivityForResult(Intent.createChooser(intent, "Select Media"), Constants.PICK_MEDIA_REQUEST);

    }


    private void previewNowButtonClicked() {

        MainActivity mainActivity = (MainActivity) context;
        mainActivity.replaceFragments(PreviewNowFragment.class);

    }

    private void initializeRequiredVariables(View rootView) {

        globalVariables = (GlobalVariables) rootView.getContext().getApplicationContext();
        facebookImgBtn = (ImageButton) rootView.findViewById(R.id.fb_btn);
        instagramImgBtn = (ImageButton) rootView.findViewById(R.id.instagram_btn);
        linkedinImgBtn = (ImageButton) rootView.findViewById(R.id.linkedin_btn);
        twitterImgBtn = (ImageButton) rootView.findViewById(R.id.twitter_btn);
        universalleftCharecterTextView = (TextView) rootView.findViewById(R.id.left_charecter_text);
        addMediaImageButton = (LinearLayout) rootView.findViewById(R.id.add_media_btn);

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (charSequence != null && charSequence.length() > 0) {
            universalleftCharecterTextView.setText(String.valueOf(charSequence.length()) + " Charecters Typed");
        }

    }

    @Override
    public void afterTextChanged(Editable editable) {
        String text = editable.toString();
        if (globalVariables.isFirstTimeWritingPost()) {
            globalVariables.setFirstTimeWritingPost(false);
            globalVariables.setUniversalEditText(text);
            globalVariables.setFacebookEditText(text);
            globalVariables.setInstagramEditText(text);
            globalVariables.setLinkedinEditText(text);
            globalVariables.setTwitterEditText(text);
        } else {
            globalVariables.setFirstTimeWritingPost(false);
            globalVariables.setUniversalEditText(text);

        }
    }
}
