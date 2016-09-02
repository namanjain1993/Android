package commons.utils;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

/**
 * Created by Naman on 31/08/16.
 */
public class GlobalVariables extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
    }


    private boolean isFirstTimeWritingPost = true;
    private boolean isFacebookButtonClicked;
    private boolean isInstagramButtonClicked;
    private boolean isLinkedinButtonClicked;
    private boolean isTwitterButtonClicked;
    private boolean isFacebookButtonPreviewClicked;
    private boolean isInstagramButtonPreviewClicked;
    private boolean isLinkedinButtonPreviewClicked;
    private boolean isTwitterButtonPreviewClicked;
    private String facebookEditText;
    private String instagramEditText;
    private String linkedinEditText;
    private String twitterEditText;
    private String universalEditText;
    private String currentEditingButton;


    public boolean isFacebookButtonPreviewClicked() {
        return isFacebookButtonPreviewClicked;
    }

    public void setFacebookButtonPreviewClicked(boolean facebookButtonPreviewClicked) {
        isFacebookButtonPreviewClicked = facebookButtonPreviewClicked;
    }

    public boolean isInstagramButtonPreviewClicked() {
        return isInstagramButtonPreviewClicked;
    }

    public void setInstagramButtonPreviewClicked(boolean instagramButtonPreviewClicked) {
        isInstagramButtonPreviewClicked = instagramButtonPreviewClicked;
    }

    public boolean isLinkedinButtonPreviewClicked() {
        return isLinkedinButtonPreviewClicked;
    }

    public void setLinkedinButtonPreviewClicked(boolean linkedinButtonPreviewClicked) {
        isLinkedinButtonPreviewClicked = linkedinButtonPreviewClicked;
    }

    public boolean isTwitterButtonPreviewClicked() {
        return isTwitterButtonPreviewClicked;
    }

    public void setTwitterButtonPreviewClicked(boolean twitterButtonPreviewClicked) {
        isTwitterButtonPreviewClicked = twitterButtonPreviewClicked;
    }

    public String getCurrentEditingButton() {
        return currentEditingButton;
    }

    public void setCurrentEditingButton(String currentEditingButton) {
        this.currentEditingButton = currentEditingButton;
    }

    public String getUniversalEditText() {
        return universalEditText;
    }

    public void setUniversalEditText(String universalEditText) {
        this.universalEditText = universalEditText;
    }

    public boolean isFirstTimeWritingPost() {
        return isFirstTimeWritingPost;
    }

    public void setFirstTimeWritingPost(boolean firstTimeWritingPost) {
        isFirstTimeWritingPost = firstTimeWritingPost;
    }

    public String getTwitterEditText() {
        return twitterEditText;
    }

    public void setTwitterEditText(String twitterEditText) {
        this.twitterEditText = twitterEditText;
    }

    public String getLinkedinEditText() {
        return linkedinEditText;
    }

    public void setLinkedinEditText(String linkedinEditText) {
        this.linkedinEditText = linkedinEditText;
    }

    public String getInstagramEditText() {
        return instagramEditText;
    }

    public void setInstagramEditText(String instagramEditText) {
        this.instagramEditText = instagramEditText;
    }

    public String getFacebookEditText() {
        return facebookEditText;
    }

    public void setFacebookEditText(String facebookEditText) {
        this.facebookEditText = facebookEditText;
    }


    public boolean isFacebookButtonClicked() {
        return isFacebookButtonClicked;
    }

    public void setFacebookButtonClicked(boolean facebookButtonClicked) {
        isFacebookButtonClicked = facebookButtonClicked;
    }

    public boolean isInstagramButtonClicked() {
        return isInstagramButtonClicked;
    }

    public void setInstagramButtonClicked(boolean instagramButtonClicked) {
        isInstagramButtonClicked = instagramButtonClicked;
    }

    public boolean isLinkedinButtonClicked() {
        return isLinkedinButtonClicked;
    }

    public void setLinkedinButtonClicked(boolean linkedinButtonClicked) {
        isLinkedinButtonClicked = linkedinButtonClicked;
    }

    public boolean isTwitterButtonClicked() {
        return isTwitterButtonClicked;
    }

    public void setTwitterButtonClicked(boolean twitterButtonClicked) {
        isTwitterButtonClicked = twitterButtonClicked;
    }


}
