package com.superpak.sammengistu.flickmatch;

/**
 * Created by SamMengistu on 8/30/16.
 */
public class FlickConstants {

    //TODO: Remove Api key


    //Api parts
    public static final String PART_BEFORE_API = "?api_key=";

    public static final String THE_MOVIE_DB_BEGINNING_URL =
        "http://api.themoviedb.org/3/";

    //ExploreFlickSectionGetter network info
    public static final String POPULAR_MOVIES_URL =
        "http://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key="
            + API_KEY;

    public static final String TOP_RATED_MOVIES_URL =
        "http://api.themoviedb.org/3/movie/top_rated" + PART_BEFORE_API
            + API_KEY;
    public static final String UPCOMING_MOVIES_URL =
        "http://api.themoviedb.org/3/movie/upcoming" + PART_BEFORE_API
            + API_KEY;

    public static final String NOW_PLAYING_URL =
        "http://api.themoviedb.org/3/movie/now_playing" + PART_BEFORE_API
            + API_KEY;

    public static final String POPULAR_TV_SHOWS_URL =
        "http://api.themoviedb.org/3/tv/popular" + PART_BEFORE_API +  API_KEY;

    public static final String TOP_RATED_TV_SHOWS_URL =
        "http://api.themoviedb.org/3/tv/top_rated" + PART_BEFORE_API + API_KEY;

    public static final String ON_THE_AIR_TV_SHOWS_URL =
        "http://api.themoviedb.org/3/tv/on_the_air" + PART_BEFORE_API + API_KEY;

    public static final String AIRING_TODAY_URL =
        "http://api.themoviedb.org/3/tv/airing_today" + PART_BEFORE_API
            + API_KEY;

    public static final String VIDEO = "/videos" + PART_BEFORE_API;
    public static final String MOVIE_INFO_BASE_URL = "http://api.themoviedb.org/3/movie/";
    public static final String REVIEWS = "/reviews" + PART_BEFORE_API;
    public static final String YOUTUBE_BASE_URL = "http://www.youtube.com/watch?v=";


}
