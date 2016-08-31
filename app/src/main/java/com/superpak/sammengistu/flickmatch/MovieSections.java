package com.superpak.sammengistu.flickmatch;

/**
 * Created by SamMengistu on 8/26/16.
 */
public enum MovieSections {

    POPULAR_MOVIES("Popular Movies", FlickConstants.THE_MOVIE_DB_BEGINNING_URL +
        "discover/movie?sort_by=popularity.desc&api_key=" + FlickConstants.API_KEY),
    TOP_RATED_MOVIES("Top Rated Movies", FlickConstants.THE_MOVIE_DB_BEGINNING_URL +
        "movie/top_rated" +FlickConstants.PART_BEFORE_API + FlickConstants.API_KEY ),
    UPCOMING_MOVIES("Upcoming Movies", FlickConstants.THE_MOVIE_DB_BEGINNING_URL +
        "movie/upcoming" + FlickConstants.PART_BEFORE_API + FlickConstants.API_KEY),
    NOW_PLAYING_MOVIES("Now Playing Movies", FlickConstants.THE_MOVIE_DB_BEGINNING_URL +
        "movie/now_playing" + FlickConstants.PART_BEFORE_API + FlickConstants.API_KEY),

    POPULAR_TV_SHOWS("Popular Tv Shows", FlickConstants.THE_MOVIE_DB_BEGINNING_URL +
        "tv/popular" +FlickConstants.PART_BEFORE_API + FlickConstants.API_KEY),
    ON_THE_AIR_TV_SHOWS("On The Air Tv Shows", FlickConstants.THE_MOVIE_DB_BEGINNING_URL +
        "tv/on_the_air" +FlickConstants.PART_BEFORE_API + FlickConstants.API_KEY),
    AIRING_TODAY_TV_SHOWS("Airing Today Tv Shows", FlickConstants.THE_MOVIE_DB_BEGINNING_URL +
        "tv/airing_today" +FlickConstants.PART_BEFORE_API + FlickConstants.API_KEY),
    TOP_RATED_TV_SHOWS("Top Rated Tv Shows", FlickConstants.THE_MOVIE_DB_BEGINNING_URL +
        "tv/top_rated" + FlickConstants.PART_BEFORE_API + FlickConstants.API_KEY);

    String mTitleName;
    String URLPoster;

    MovieSections(String name, String url) {
        mTitleName = name;
        URLPoster = url;
    }

    public String getTitleName() {
        return mTitleName;
    }

    public String getURLPoster() {
        return URLPoster;
    }
}
