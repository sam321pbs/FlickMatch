package com.superpak.sammengistu.flickmatch.model;


public class SearchItem {

    private String mFlickTitle;
    private String mIMDBFlickId;
    private String mFlickType;
    private String mFlickYear;

    public SearchItem(String flickTitle, String IMDBFlickId, String flickType, String flickYear) {
        mFlickTitle = flickTitle;
        mIMDBFlickId = IMDBFlickId;
        mFlickType = flickType;
        mFlickYear = flickYear;
    }

    public String getFlickTitle() {
        return mFlickTitle;
    }

    public String getIMDBFlickId() {
        return mIMDBFlickId;
    }

    public String getFlickType() {
        return mFlickType;
    }

    public String getFlickYear() {
        return mFlickYear;
    }
}
