package com.superpak.sammengistu.flickmatch.model;

/**
 * Created by SamMengistu on 8/30/16.
 */
public class FlickPoster {

    private String mPosterURL ;
    private String mFlickTitle;

    public FlickPoster(String posterURL, String flickTitle) {
        mPosterURL = posterURL;
        mFlickTitle = flickTitle;
    }

    public String getPosterURL() {
        return mPosterURL;
    }

    public String getFlickTitle() {
        return mFlickTitle;
    }
}
