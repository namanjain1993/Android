package suite.fragments;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
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

import java.io.IOException;
import java.io.InputStream;

import suite.fragments.helper.PostNowFragmentHelper;
import commons.utils.ApplicationPreferenceManager;
import commons.constants.Constants;


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

        PostNowFragmentHelper fragmentHelper = new PostNowFragmentHelper(rootView, this);
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constants.PICK_MEDIA_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();

            try {

                InputStream inputStream = getContext().getContentResolver().openInputStream(uri);
                Drawable image = Drawable.createFromStream(inputStream, uri.toString());

                EditText editText = (EditText) getView().findViewById(R.id.editText_post);

                if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    editText.setBackgroundDrawable(image);
                } else {
                    editText.setBackground(image);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
