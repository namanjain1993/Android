package suite.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Naman on 26/08/16.
 */
public class PreferenceManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "SUITE_WELCOME";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static final String FB_BTN_CLICKED = "IsFBBtnClicked";
    private static final String INSTA_BTN_CLICKED = "IsInstaBtnClicked";
    private static final String TWITTER_BTN_CLICKED = "IsTwitterBtnClicked";
    private static final String LINKEDIN_BTN_CLICKED = "IsLinkedinBtnClicked";
    private static final String UNIVERSAL_BTN_CLICKED = "IsUniversalBtnClicked";

    public PreferenceManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }


    public void setFBButtonClicked(boolean isFBButtonClicked) {
        editor.putBoolean(FB_BTN_CLICKED, isFBButtonClicked);
        editor.commit();
    }

    public boolean isFBButtonClicked() {
        return pref.getBoolean(FB_BTN_CLICKED, false);
    }

    public void setInstaButtonClicked(boolean isInstaButtonClicked) {
        editor.putBoolean(INSTA_BTN_CLICKED, isInstaButtonClicked);
        editor.commit();
    }

    public boolean isInstaButtonClicked() {
        return pref.getBoolean(INSTA_BTN_CLICKED, false);
    }

    public void setTwitterButtonClicked(boolean isTwitterButtonClicked) {
        editor.putBoolean(TWITTER_BTN_CLICKED, isTwitterButtonClicked);
        editor.commit();
    }

    public boolean isTwitterButtonClicked() {
        return pref.getBoolean(TWITTER_BTN_CLICKED, false);
    }

    public void setLinkedinButtonClicked(boolean isLinkedinButtonClicked) {
        editor.putBoolean(LINKEDIN_BTN_CLICKED, isLinkedinButtonClicked);
        editor.commit();
    }

    public boolean isLinkedinButtonClicked() {
        return pref.getBoolean(LINKEDIN_BTN_CLICKED, false);
    }

    public void setUniversalButtonClicked(boolean isUniversalButtonClicked) {
        editor.putBoolean(UNIVERSAL_BTN_CLICKED, isUniversalButtonClicked);
        editor.commit();
    }

    public boolean isUniversalButtonClicked() {
        return pref.getBoolean(UNIVERSAL_BTN_CLICKED, false);
    }

}
