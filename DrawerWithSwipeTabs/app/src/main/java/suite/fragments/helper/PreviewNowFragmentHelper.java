package suite.fragments.helper;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.androidbelieve.drawerwithswipetabs.R;

import commons.utils.GlobalVariables;
import suite.listeners.PreviewNowFragmentListener;

/**
 * Created by Naman on 01/09/16.
 */
public class PreviewNowFragmentHelper {

    private static View rootView;
    private static GlobalVariables globalVariables;

    private static EditText editText;
    private static ImageButton universalImageButton;
    private static ImageButton facebookImageButton;
    private static ImageButton linkedinImageButton;
    private static ImageButton instagramImageButton;
    private static ImageButton twitterImageButton;
    private static Button postNowButton;
    private static boolean isAlreadyInitialized;

    public PreviewNowFragmentHelper(View rootView) {
        if (!isAlreadyInitialized) {
            isAlreadyInitialized = true;
            this.rootView = rootView;
            this.globalVariables = (GlobalVariables) rootView.getContext().getApplicationContext();
            initializeElements();
        }
    }


    public View removeUncheckedElements() {


        universalImageButton.setVisibility(View.GONE);

        if (!globalVariables.isFacebookButtonClicked()) {
            facebookImageButton.setVisibility(View.GONE);
        }

        if (!globalVariables.isLinkedinButtonClicked()) {
            linkedinImageButton.setVisibility(View.GONE);
        }

        if (!globalVariables.isTwitterButtonClicked()) {
            twitterImageButton.setVisibility(View.GONE);
        }

        if (!globalVariables.isInstagramButtonClicked()) {
            instagramImageButton.setVisibility(View.GONE);
        }

        editText.setText(globalVariables.getUniversalEditText());


        return rootView;

    }

    /*private void highLightFirstElement() {

        if (globalVariables.isFacebookButtonClicked()) {
            facebookImageButton.setImageResource(R.drawable.facebook_glow);
            return;
        }

        if (globalVariables.isInstagramButtonClicked()) {
            instagramImageButton.setImageResource(R.drawable.instagram_glow);
            return;
        }

        if (globalVariables.isLinkedinButtonClicked()) {
            linkedinImageButton.setImageResource(R.drawable.linkedin_glow);
            return;
        }

        if (globalVariables.isTwitterButtonClicked()) {
            twitterImageButton.setImageResource(R.drawable.twitter_glow);
            return;
        }
    }*/

    public View setListners() {
        postNowButton.setOnClickListener(new PreviewNowFragmentListener(postNowButton));
        facebookImageButton.setOnClickListener(new PreviewNowFragmentListener(facebookImageButton));
        instagramImageButton.setOnClickListener(new PreviewNowFragmentListener(instagramImageButton));
        linkedinImageButton.setOnClickListener(new PreviewNowFragmentListener(linkedinImageButton));
        twitterImageButton.setOnClickListener(new PreviewNowFragmentListener(twitterImageButton));
        editText.addTextChangedListener(new PreviewNowFragmentListener(editText));

        return rootView;
    }


    private void initializeElements() {

        universalImageButton = (ImageButton) rootView.findViewById(R.id.universal_btn);
        facebookImageButton = (ImageButton) rootView.findViewById(R.id.fb_btn);
        instagramImageButton = (ImageButton) rootView.findViewById(R.id.instagram_btn);
        linkedinImageButton = (ImageButton) rootView.findViewById(R.id.linkedin_btn);
        twitterImageButton = (ImageButton) rootView.findViewById(R.id.twitter_btn);
        postNowButton = (Button) rootView.findViewById(R.id.preview_postnow_btn);
        editText = (EditText) rootView.findViewById(R.id.editText_post);

    }
}
