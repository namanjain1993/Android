package suite.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Naman on 26/08/16.
 */
public class ApplicationPreferenceManager {


    static SharedPreferences pref;
    static SharedPreferences.Editor editor;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "SUITE_WELCOME";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public ApplicationPreferenceManager(Context context) {

        pref = context.getApplicationContext().getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();

    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

}
