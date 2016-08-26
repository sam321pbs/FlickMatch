package com.superpak.sammengistu.flickmatch;

/**
 * Created by SamMengistu on 8/26/16.
 */
public enum MovieSections {

    TOP_RATED_MOVIES("Top Rated Movies"),
    UPCOMING_MOVIES("Upcoming Movies"),
    NOW_PLAYING_MOVIES("Now Playing Movies"),
    POPULAR_MOVIES("Popular Movies"),
    POPULAR_TV_SHOWS("Popular Movies"),
    ON_THE_AIR_TV_SHOWS("On The Air Tv Shows"),
    AIRING_TODAY_TV_SHOWS("Airing Today Tv Shows");

    String mTitleName;

    MovieSections(String name) {
        mTitleName = name;
    }

    public String getTitleName() {
        return mTitleName;
    }

}
