package suite.fragments.helper;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidbelieve.drawerwithswipetabs.R;

import commons.utils.GlobalVariables;
import suite.listeners.PostNowFragmentListners;

/**
 * Created by Naman on 01/09/16.
 */
public class PostNowFragmentHelper {

    private static View rootView;
    private static GlobalVariables globalVariables;
    private static EditText universalEditText;
    private static Button previewNowButton;
    private static ImageButton universalImageButton;
    private static ImageButton facebookImageButton;
    private static ImageButton instagramImageButton;
    private static ImageButton linkedinImageButton;
    private static ImageButton twitterImageButton;
    private static TextView universalleftCharecterTextView;
    private static LinearLayout addMediaLayoutButton;
    private static boolean isAleardyInitialized;
    private static Fragment fragment;

    public PostNowFragmentHelper(View rootView, Fragment fragment) {
        if (!isAleardyInitialized) {
            isAleardyInitialized = true;
            this.rootView = rootView;
            this.fragment = fragment;
            initializeElements();
        }
    }


    public View setListners(View rootView) {

        universalImageButton.setOnClickListener(new PostNowFragmentListners(universalImageButton, fragment));
        universalImageButton.setOnFocusChangeListener(new PostNowFragmentListners(universalImageButton, fragment));


        facebookImageButton.setOnFocusChangeListener(new PostNowFragmentListners(facebookImageButton, fragment));
        facebookImageButton.setOnClickListener(new PostNowFragmentListners(facebookImageButton, fragment));

        linkedinImageButton.setOnFocusChangeListener(new PostNowFragmentListners(linkedinImageButton, fragment));
        linkedinImageButton.setOnClickListener(new PostNowFragmentListners(linkedinImageButton, fragment));

        instagramImageButton.setOnFocusChangeListener(new PostNowFragmentListners(instagramImageButton, fragment));
        instagramImageButton.setOnClickListener(new PostNowFragmentListners(instagramImageButton, fragment));

        twitterImageButton.setOnFocusChangeListener(new PostNowFragmentListners(twitterImageButton, fragment));
        twitterImageButton.setOnClickListener(new PostNowFragmentListners(twitterImageButton, fragment));


        previewNowButton.setOnFocusChangeListener(new PostNowFragmentListners(previewNowButton, fragment));
        previewNowButton.setOnClickListener(new PostNowFragmentListners(previewNowButton, fragment));

        universalEditText = (EditText) rootView.findViewById(R.id.editText_post);
        universalEditText.addTextChangedListener(new PostNowFragmentListners(universalEditText, fragment));

        addMediaLayoutButton.setOnFocusChangeListener(new PostNowFragmentListners(addMediaLayoutButton, fragment));
        addMediaLayoutButton.setOnClickListener(new PostNowFragmentListners(addMediaLayoutButton, fragment));

        return rootView;

    }

    public View prefillViews() {

        universalEditText.setText(globalVariables.getUniversalEditText());

        if (globalVariables.isFacebookButtonClicked()) {
            facebookImageButton.setImageResource(R.drawable.facebook_glow);
        }

        if (globalVariables.isInstagramButtonClicked()) {
            instagramImageButton.setImageResource(R.drawable.instagram_glow);
        }

        if (globalVariables.isLinkedinButtonClicked()) {
            linkedinImageButton.setImageResource(R.drawable.linkedin_glow);
        }

        if (globalVariables.isTwitterButtonClicked()) {
            twitterImageButton.setImageResource(R.drawable.twitter_glow);
        }

        return rootView;

    }

    private void initializeElements() {
        globalVariables = (GlobalVariables) rootView.getContext().getApplicationContext();
        universalEditText = (EditText) rootView.findViewById(R.id.editText_post);
        universalImageButton = (ImageButton) rootView.findViewById(R.id.universal_btn);
        facebookImageButton = (ImageButton) rootView.findViewById(R.id.fb_btn);
        instagramImageButton = (ImageButton) rootView.findViewById(R.id.instagram_btn);
        linkedinImageButton = (ImageButton) rootView.findViewById(R.id.linkedin_btn);
        twitterImageButton = (ImageButton) rootView.findViewById(R.id.twitter_btn);
        previewNowButton = (Button) rootView.findViewById(R.id.previewnow_btn);
        universalleftCharecterTextView = (TextView) rootView.findViewById(R.id.left_charecter_text);
        addMediaLayoutButton = (LinearLayout) rootView.findViewById(R.id.add_media_btn);
    }

}
