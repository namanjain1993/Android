package suite.listeners;

import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.androidbelieve.drawerwithswipetabs.R;

import commons.utils.GlobalVariables;

/**
 * Created by Naman on 01/09/16.
 */
public class PreviewNowFragmentListener implements View.OnClickListener, View.OnFocusChangeListener, TextWatcher {

    private static View rootView;
    private static View view;
    private static AppCompatActivity context;
    private static GlobalVariables globalVariables;
    private static EditText editText;
    private static ImageButton facebookImageButton;
    private static ImageButton instagramImageButton;
    private static ImageButton twitterImageButton;
    private static ImageButton linkedinImageButton;
    private static boolean isAlreadyInitialized;

    public PreviewNowFragmentListener(View view) {
        if (!isAlreadyInitialized) {
            isAlreadyInitialized = true;
            this.rootView = view.getRootView();
            this.view = view;
            this.context = (AppCompatActivity) rootView.getContext();
            initializeElements(rootView);
        }
    }

    private void initializeElements(View rootView) {
        globalVariables = (GlobalVariables) rootView.getContext().getApplicationContext();
        editText = (EditText) rootView.findViewById(R.id.editText_post);
        facebookImageButton = (ImageButton) rootView.findViewById(R.id.fb_btn);
        instagramImageButton = (ImageButton) rootView.findViewById(R.id.instagram_btn);
        linkedinImageButton = (ImageButton) rootView.findViewById(R.id.linkedin_btn);
        twitterImageButton = (ImageButton) rootView.findViewById(R.id.twitter_btn);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fb_btn:
                facebookPreviewButtonClicked(view);
                break;
            case R.id.instagram_btn:
                instagramPreviewButtonClicked(view);
                break;
            case R.id.linkedin_btn:
                linkedinPreviewButtonClicked(view);
                break;
            case R.id.twitter_btn:
                twitterPreviewButtonClicked(view);
                break;
            default:
                break;
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        switch (view.getId()) {
            case R.id.fb_btn:
                facebookPreviewButtonClicked(view);
                break;
            case R.id.instagram_btn:
                instagramPreviewButtonClicked(view);
                break;
            case R.id.linkedin_btn:
                linkedinPreviewButtonClicked(view);
                break;
            case R.id.twitter_btn:
                twitterPreviewButtonClicked(view);
                break;
            default:
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

        if (editable != null) {

            switch (globalVariables.getCurrentEditingButton()) {
                case "Facebook":
                    globalVariables.setFacebookEditText(editable.toString());
                    break;
                case "Instagram":
                    globalVariables.setInstagramEditText(editable.toString());
                    break;
                case "Linkedin":
                    globalVariables.setLinkedinEditText(editable.toString());
                    break;
                case "Twitter":
                    globalVariables.setTwitterEditText(editable.toString());
                    break;
                default:
                    break;
            }

        }
    }

    private void facebookPreviewButtonClicked(View view) {
        globalVariables.setCurrentEditingButton("Facebook");
        editText.setText(globalVariables.getFacebookEditText());
        facebookImageButton.setImageResource(R.drawable.facebook_glow);
        instagramImageButton.setImageResource(R.drawable.instagram_dark);
        linkedinImageButton.setImageResource(R.drawable.linkedin_dark);
        twitterImageButton.setImageResource(R.drawable.twitter_dark);
    }

    private void instagramPreviewButtonClicked(View view) {
        globalVariables.setCurrentEditingButton("Instagram");
        editText.setText(globalVariables.getInstagramEditText());
        facebookImageButton.setImageResource(R.drawable.facebook_dark);
        instagramImageButton.setImageResource(R.drawable.instagram_glow);
        linkedinImageButton.setImageResource(R.drawable.linkedin_dark);
        twitterImageButton.setImageResource(R.drawable.twitter_dark);
    }

    private void linkedinPreviewButtonClicked(View view) {
        globalVariables.setCurrentEditingButton("Linkedin");
        editText.setText(globalVariables.getLinkedinEditText());
        facebookImageButton.setImageResource(R.drawable.facebook_dark);
        instagramImageButton.setImageResource(R.drawable.instagram_dark);
        linkedinImageButton.setImageResource(R.drawable.linkedin_glow);
        twitterImageButton.setImageResource(R.drawable.twitter_dark);
    }

    private void twitterPreviewButtonClicked(View view) {
        globalVariables.setCurrentEditingButton("Twitter");
        editText.setText(globalVariables.getTwitterEditText());
        facebookImageButton.setImageResource(R.drawable.facebook_dark);
        instagramImageButton.setImageResource(R.drawable.instagram_dark);
        linkedinImageButton.setImageResource(R.drawable.linkedin_dark);
        twitterImageButton.setImageResource(R.drawable.twitter_glow);
    }


}
