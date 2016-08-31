package suite.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidbelieve.drawerwithswipetabs.R;

import suite.fragments.helper.PreviewNowFragmentHelper;


public class PreviewNowFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_previewnow, container, false);

        PreviewNowFragmentHelper fragmentHelper = new PreviewNowFragmentHelper(rootView);

        rootView = fragmentHelper.removeUncheckedElements();
        rootView = fragmentHelper.setListners();


        return rootView;
    }

}
