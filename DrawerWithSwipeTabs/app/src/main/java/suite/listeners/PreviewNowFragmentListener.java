package suite.listeners;

import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

/**
 * Created by Naman on 01/09/16.
 */
public class PreviewNowFragmentListener implements View.OnClickListener, View.OnFocusChangeListener, TextWatcher {

    private static View rootView;
    private static View view;
    private static AppCompatActivity context;
    private boolean isAlreadyInitialized;

    public PreviewNowFragmentListener(View view) {
        if (!isAlreadyInitialized) {
            isAlreadyInitialized = true;
            this.rootView = view.getRootView();
            this.view = view;
            context = (AppCompatActivity) rootView.getContext();
            initializeElements(rootView);
        }
    }

    private void initializeElements(View rootView) {

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onFocusChange(View view, boolean b) {

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
