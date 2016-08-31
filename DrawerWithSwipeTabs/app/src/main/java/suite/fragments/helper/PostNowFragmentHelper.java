package suite.fragments.helper;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.androidbelieve.drawerwithswipetabs.R;

import suite.beans.GlobalVariables;
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
    private static boolean isAleardyInitialized;

    public PostNowFragmentHelper(View rootView) {
        if (!isAleardyInitialized) {
            isAleardyInitialized = true;
            this.rootView = rootView;
            this.globalVariables = (GlobalVariables) rootView.getContext().getApplicationContext();
            initializeElements();
        }
    }


    public View setListners(View rootView) {

        universalImageButton.setOnClickListener(new PostNowFragmentListners(universalImageButton));
        universalImageButton.setOnFocusChangeListener(new PostNowFragmentListners(universalImageButton));


        facebookImageButton.setOnFocusChangeListener(new PostNowFragmentListners(facebookImageButton));
        facebookImageButton.setOnClickListener(new PostNowFragmentListners(facebookImageButton));

        linkedinImageButton.setOnFocusChangeListener(new PostNowFragmentListners(linkedinImageButton));
        linkedinImageButton.setOnClickListener(new PostNowFragmentListners(linkedinImageButton));

        instagramImageButton.setOnFocusChangeListener(new PostNowFragmentListners(instagramImageButton));
        instagramImageButton.setOnClickListener(new PostNowFragmentListners(instagramImageButton));

        twitterImageButton.setOnFocusChangeListener(new PostNowFragmentListners(twitterImageButton));
        twitterImageButton.setOnClickListener(new PostNowFragmentListners(twitterImageButton));


        previewNowButton.setOnFocusChangeListener(new PostNowFragmentListners(previewNowButton));
        previewNowButton.setOnClickListener(new PostNowFragmentListners(previewNowButton));

        universalEditText = (EditText) rootView.findViewById(R.id.editText_post);
        universalEditText.addTextChangedListener(new PostNowFragmentListners(universalEditText));

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
        universalEditText = (EditText) rootView.findViewById(R.id.editText_post);
        universalImageButton = (ImageButton) rootView.findViewById(R.id.universal_btn);
        facebookImageButton = (ImageButton) rootView.findViewById(R.id.fb_btn);
        instagramImageButton = (ImageButton) rootView.findViewById(R.id.instagram_btn);
        linkedinImageButton = (ImageButton) rootView.findViewById(R.id.linkedin_btn);
        twitterImageButton = (ImageButton) rootView.findViewById(R.id.twitter_btn);
        previewNowButton = (Button) rootView.findViewById(R.id.previewnow_btn);
        universalleftCharecterTextView = (TextView) rootView.findViewById(R.id.left_charecter_text);
    }

}
