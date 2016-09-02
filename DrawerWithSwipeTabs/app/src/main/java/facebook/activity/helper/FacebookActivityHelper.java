package facebook.activity.helper;

import android.view.View;

/**
 * Created by Naman on 02/09/16.
 */
public class FacebookActivityHelper {


    private static View rootView;
    private static boolean isAlreadyInitialized;

    public FacebookActivityHelper(View rootView) {
        if (isAlreadyInitialized) {
            this.isAlreadyInitialized = true;
            this.rootView = rootView;
        }

    }
}
