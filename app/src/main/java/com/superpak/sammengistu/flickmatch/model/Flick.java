package com.superpak.sammengistu.flickmatch.model;


public class Flick {

    private String mTitle;
    private String mYear;
    private String mRated;
    private String mRuntime;
    private String mGenre;
    private String mDirector;
    private String mPlot;
    private String mAwards;
    private String mPoster;
    private String mMetascore;
    private String mIMDBRating;
    private String mTomatoMeter;
    private String mProductionStudio;
    private String mIMDBId;

    public Flick() {
    }

    public Flick(String title, String year, String rated, String runtime, String genre,
                 String director, String plot, String awards, String poster,
                 String metascore, String IMDBRating,
                 String tomatoMeter, String productionStudio,
                 String imdbId) {

        mTitle = title;
        mYear = year;
        mRated = rated;
        mRuntime = runtime;
        mGenre = genre;
        mDirector = director;
        mPlot = plot;
        mAwards = awards;
        mPoster = poster;
        mMetascore = metascore;
        mIMDBRating = IMDBRating;
        mTomatoMeter = tomatoMeter;
        mProductionStudio = productionStudio;
        mIMDBId = imdbId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getYear() {
        return mYear;
    }

    public String getRated() {
        return mRated;
    }

    public String getRuntime() {
        return mRuntime;
    }

    public String getGenre() {
        return mGenre;
    }

    public String getDirector() {
        return mDirector;
    }

    public String getPlot() {
        return mPlot;
    }

    public String getAwards() {
        return mAwards;
    }

    public String getPoster() {
        return mPoster;
    }

    public String getMetascore() {
        return mMetascore;
    }

    public String getIMDBRating() {
        return mIMDBRating;
    }

    public String getTomatoMeter() {
        return mTomatoMeter;
    }

    public String getProductionStudio() {
        return mProductionStudio;
    }

    public String getIMDBId() {
        return mIMDBId;
    }
}
