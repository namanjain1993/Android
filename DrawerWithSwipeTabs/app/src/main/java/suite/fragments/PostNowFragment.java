package suite.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.androidbelieve.drawerwithswipetabs.R;

import suite.utils.LastClicked;
import suite.utils.PreferenceManager;


/**
 * Created by Naman on 14/08/16.
 */
public class PostNowFragment extends Fragment implements View.OnClickListener, View.OnFocusChangeListener {


    private PreferenceManager preferenceManager;

    private EditText universalEditText;
    private EditText facebookEditText;
    private EditText instagramEditText;
    private EditText twitterEditText;
    private EditText linkedinEditText;

    private TextView universalleftCharecterTextView;
    private TextView facebookleftCharecterTextView;
    private TextView linkedinleftCharecterTextView;
    private TextView twitterleftCharecterTextView;
    private TextView instagramleftCharecterTextView;

    private ImageButton universalBtn;
    private ImageButton facebookImgBtn;
    private ImageButton linkedinImgBtn;
    private ImageButton twitterImgBtn;
    private ImageButton instagramImgBtn;


    private LastClicked lastClickedButton;

    String universalPost;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        preferenceManager = new PreferenceManager(this.getActivity());

        View rootView = inflater.inflate(R.layout.fragment_postnow, container, false);

        universalleftCharecterTextView = (TextView) rootView.findViewById(R.id.left_charecter_text);

        universalEditText = (EditText) rootView.findViewById(R.id.editText_post);
        universalEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                universalleftCharecterTextView.setText(String.valueOf(charSequence.length()) + " Charecters");
            }

            @Override
            public void afterTextChanged(Editable editable) {
                universalPost = editable.toString();
            }
        });


        universalBtn = (ImageButton) rootView.findViewById(R.id.universal_btn);
        universalBtn.setOnClickListener(this);
        universalBtn.setOnFocusChangeListener(this);


        facebookImgBtn = (ImageButton) rootView.findViewById(R.id.fb_btn);
        facebookImgBtn.setOnFocusChangeListener(this);
        facebookImgBtn.setOnClickListener(this);

        linkedinImgBtn = (ImageButton) rootView.findViewById(R.id.linkedin_btn);
        linkedinImgBtn.setOnFocusChangeListener(this);
        linkedinImgBtn.setOnClickListener(this);

        instagramImgBtn = (ImageButton) rootView.findViewById(R.id.instagram_btn);
        instagramImgBtn.setOnFocusChangeListener(this);
        instagramImgBtn.setOnClickListener(this);

        twitterImgBtn = (ImageButton) rootView.findViewById(R.id.twitter_btn);
        twitterImgBtn.setOnFocusChangeListener(this);
        twitterImgBtn.setOnClickListener(this);


        return rootView;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.universal_btn:
                lastClickedButton = LastClicked.ALL;
                universalBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        changeUniversalButtonState(view);
                    }
                });
            case R.id.fb_btn:
                lastClickedButton = LastClicked.FB;
                facebookImgBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        changeFBButtonState(view);
                    }
                });
            case R.id.instagram_btn:
                lastClickedButton = LastClicked.INSTAGRAM;
                instagramImgBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        changeInstagramButtonState(view);
                    }
                });
            case R.id.twitter_btn:
                lastClickedButton = LastClicked.TWITTER;
                twitterImgBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        changeTwitterButtonState(view);
                    }
                });
            case R.id.linkedin_btn:
                lastClickedButton = LastClicked.LINKEDIN;
                linkedinImgBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        changeLinkedinButtonState(view);
                    }
                });
            default: ;
        }

    }

    @Override
    public void onFocusChange(View view, boolean isFocusChanged) {

        if (isFocusChanged) {
            switch (view.getId()) {
                case R.id.universal_btn:
                    lastClickedButton = LastClicked.ALL;
                    universalBtn.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        @Override
                        public void onFocusChange(View view, boolean b) {
                            changeUniversalButtonState(view);
                        }
                    });
                case R.id.fb_btn:
                    lastClickedButton = LastClicked.FB;
                    facebookImgBtn.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        @Override
                        public void onFocusChange(View view, boolean b) {
                            changeFBButtonState(view);
                        }
                    });
                case R.id.instagram_btn:
                    lastClickedButton = LastClicked.INSTAGRAM;
                    instagramImgBtn.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        @Override
                        public void onFocusChange(View view, boolean b) {
                            changeInstagramButtonState(view);
                        }
                    });
                case R.id.twitter_btn:
                    lastClickedButton = LastClicked.TWITTER;
                    twitterImgBtn.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        @Override
                        public void onFocusChange(View view, boolean b) {
                            changeTwitterButtonState(view);
                        }
                    });
                case R.id.linkedin_btn:
                    lastClickedButton = LastClicked.LINKEDIN;
                    linkedinImgBtn.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                        @Override
                        public void onFocusChange(View view, boolean b) {
                            changeLinkedinButtonState(view);
                        }
                    });
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
}
