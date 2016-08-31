package suite.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.androidbelieve.drawerwithswipetabs.R;

import suite.fragments.listeners.PostNowListners;
import suite.utils.Keys;
import suite.utils.LastLongPressed;
import suite.utils.PreferenceManager;


/**
 * Created by Naman on 14/08/16.
 */
public class PostNowFragment extends Fragment {


    private PreferenceManager preferenceManager;

    private ImageButton universalBtn;
    private ImageButton facebookImgBtn;
    private ImageButton linkedinImgBtn;
    private ImageButton twitterImgBtn;
    private ImageButton instagramImgBtn;

    private EditText universalEditText;

    private TextView universalleftCharecterTextView;
    private TextView facebookleftCharecterTextView;
    private TextView instagramleftCharecterTextView;
    private TextView twitterleftCharecterTextView;
    private TextView linkdinleftCharecterTextView;

    private String universalPost;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        preferenceManager = new PreferenceManager(this.getActivity());

        View rootView = inflater.inflate(R.layout.fragment_postnow, container, false);

        AppCompatActivity context = (AppCompatActivity) getActivity();

        universalBtn = (ImageButton) rootView.findViewById(R.id.universal_btn);
        universalBtn.setOnClickListener(new PostNowListners(rootView, universalBtn, preferenceManager));
        universalBtn.setOnFocusChangeListener(new PostNowListners(rootView, universalBtn, preferenceManager));
        universalBtn.setOnLongClickListener(new PostNowListners(rootView, universalBtn, preferenceManager));


        facebookImgBtn = (ImageButton) rootView.findViewById(R.id.fb_btn);
        facebookImgBtn.setOnFocusChangeListener(new PostNowListners(rootView, facebookImgBtn, preferenceManager));
        facebookImgBtn.setOnClickListener(new PostNowListners(rootView, facebookImgBtn, preferenceManager));
        facebookImgBtn.setOnLongClickListener(new PostNowListners(rootView, universalBtn, preferenceManager));

        linkedinImgBtn = (ImageButton) rootView.findViewById(R.id.linkedin_btn);
        linkedinImgBtn.setOnFocusChangeListener(new PostNowListners(rootView, linkedinImgBtn, preferenceManager));
        linkedinImgBtn.setOnClickListener(new PostNowListners(rootView, linkedinImgBtn, preferenceManager));
        linkedinImgBtn.setOnLongClickListener(new PostNowListners(rootView, universalBtn, preferenceManager));

        instagramImgBtn = (ImageButton) rootView.findViewById(R.id.instagram_btn);
        instagramImgBtn.setOnFocusChangeListener(new PostNowListners(rootView, instagramImgBtn, preferenceManager));
        instagramImgBtn.setOnClickListener(new PostNowListners(rootView, instagramImgBtn, preferenceManager));
        instagramImgBtn.setOnLongClickListener(new PostNowListners(rootView, universalBtn, preferenceManager));

        twitterImgBtn = (ImageButton) rootView.findViewById(R.id.twitter_btn);
        twitterImgBtn.setOnFocusChangeListener(new PostNowListners(rootView, twitterImgBtn, preferenceManager));
        twitterImgBtn.setOnClickListener(new PostNowListners(rootView, twitterImgBtn, preferenceManager));
        twitterImgBtn.setOnLongClickListener(new PostNowListners(rootView, universalBtn, preferenceManager));

        universalleftCharecterTextView = (TextView) rootView.findViewById(R.id.left_charecter_text);

        universalEditText = (EditText) rootView.findViewById(R.id.editText_post);
        universalEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //universalleftCharecterTextView.setText(String.valueOf(charSequence.length()) + " Charecters");

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (Keys.IS_FIRST_TIME_WRITING_POST && Keys.LAST_LONG_PRESSED == LastLongPressed.UNIVERSAL) {
                    Keys.UNIVERSAL_TEXT = editable.toString();
                    Keys.FACEBOOK_TEXT = editable.toString();
                    Keys.INSTAGRAM_TEXT = editable.toString();
                    Keys.LINKEDIN_TEXT = editable.toString();
                    Keys.TWITTER_TEXT = editable.toString();
                } else if (Keys.LAST_LONG_PRESSED == LastLongPressed.UNIVERSAL) {
                    Keys.UNIVERSAL_TEXT = editable.toString();
                    universalBtn.setImageResource(R.drawable.all_glow);
                } else if (Keys.LAST_LONG_PRESSED == LastLongPressed.FB) {
                    Keys.FACEBOOK_TEXT = editable.toString();
                    facebookImgBtn.setImageResource(R.drawable.facebook_glow);
                } else if (Keys.LAST_LONG_PRESSED == LastLongPressed.INSTAGRAM) {
                    Keys.INSTAGRAM_TEXT = editable.toString();
                    instagramImgBtn.setImageResource(R.drawable.instagram_glow);
                } else if (Keys.LAST_LONG_PRESSED == LastLongPressed.TWITTER) {
                    Keys.TWITTER_TEXT = editable.toString();
                    twitterImgBtn.setImageResource(R.drawable.twitter_glow);
                } else if (Keys.LAST_LONG_PRESSED == LastLongPressed.LINKEDIN) {
                    Keys.LINKEDIN_TEXT = editable.toString();
                    linkedinImgBtn.setImageResource(R.drawable.linkedin_glow);
                }

                if (Keys.IS_FIRST_TIME_WRITING_POST) {
                    Keys.IS_FIRST_TIME_WRITING_POST = false;
                }

            }
        });


        return rootView;
    }
}
