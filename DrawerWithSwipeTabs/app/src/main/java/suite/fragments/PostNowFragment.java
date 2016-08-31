package suite.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.androidbelieve.drawerwithswipetabs.R;

import suite.fragments.helper.PostNowFragmentHelper;
import suite.utils.ApplicationPreferenceManager;


/**
 * Created by Naman on 14/08/16.
 */
public class PostNowFragment extends Fragment {


    private ApplicationPreferenceManager preferenceManager;

    private ImageButton universalBtn;
    private ImageButton facebookImgBtn;
    private ImageButton linkedinImgBtn;
    private ImageButton twitterImgBtn;
    private ImageButton instagramImgBtn;

    private Button previewNowButton;

    private EditText universalEditText;

    private TextView universalleftCharecterTextView;
    private TextView facebookleftCharecterTextView;
    private TextView instagramleftCharecterTextView;
    private TextView twitterleftCharecterTextView;
    private TextView linkdinleftCharecterTextView;

    private String universalPost;

    private boolean fragmentReloaded;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_postnow, container, false);

        PostNowFragmentHelper fragmentHelper = new PostNowFragmentHelper(rootView);
        rootView = fragmentHelper.setListners(rootView);

        if (!fragmentReloaded) {
            /*
            This is first time code, when instance is created
             */
            fragmentReloaded = true;

        } else {
            /*
            This executes when when back button is pressed
             */
            rootView = fragmentHelper.prefillViews();
        }


        return rootView;
    }
}
