package suite.beans;

import android.app.Application;

/**
 * Created by Naman on 31/08/16.
 */
public class GlobalVariables extends Application {


    private boolean isFirstTimeWritingPost = true;
    private boolean isFacebookButtonClicked;
    private boolean isInstagramButtonClicked;
    private boolean isLinkedinButtonClicked;
    private boolean isTwitterButtonClicked;
    private String facebookEditText;
    private String instagramEditText;
    private String linkedinEditText;
    private String twitterEditText;
    private String universalEditText;

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
