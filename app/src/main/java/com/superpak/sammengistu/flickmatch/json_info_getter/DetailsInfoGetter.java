package com.superpak.sammengistu.flickmatch.json_info_getter;

import com.superpak.sammengistu.flickmatch.BuildConfig;
import com.superpak.sammengistu.flickmatch.model.Flick;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;


public class DetailsInfoGetter {

    public static final String TAG = "DetailsInfoGetter55";
    public static final String OMDB_TITLE = "Title";
    public static final String OMDB_YEAR = "Year";
    public static final String OMDB_RATED = "Rated";
    public static final String OMDB_RUNTIME = "Runtime";
    public static final String OMDB_GENRE = "Genre";
    public static final String OMDB_DIRECTOR = "Director";
    public static final String OMDB_PLOT = "Plot";
    public static final String OMDB_AWARDS = "Awards";
    public static final String OMDB_IMDB_ID = "imdbID";
    public static final String OMDB_METASCORE = "Metascore";
    public static final String OMDB_IMDB_RATING = "imdbRating";
    public static final String OMDB_TOMATO_METER = "tomatoMeter";
    public static final String OMDB_PRODUCTION_STUDIO = "Production";

    //gets details
    public static final String OMDB_URL_BEGINNING = "http://www.omdbapi.com/?" ;
    public static final String OMDB_URL_ENDING_DETAILS = "&y=&plot=full&r=json&tomatoes=true";
    public static final String OMDB_BY_TITLE = "t=";

    //gets poster
    public static final String OMDB_POSTER_BEGINNING_URL = "http://img.omdbapi.com/?";
    public static final String OMDB_BY_ID = "i=";
    //TODO: remove Api key
    public static final String OMDB_API_KEY = "&apikey=" + BuildConfig.OMDB_API_KEY;

    /**
     * Coverts the JSON object into a movie object with the information it gets from the web
     *
     * @param title - the title of the movie to get details for
     * @return - List of movie objects
     */
    public static Flick setUpFlickPosterObjectsFromTMDB(String title) {

        Log.i(TAG, "called");
        Flick flick = new Flick();
        try {
            //Convert Json String to Json Object
            JSONObject omdbFlickJsonObject = new JSONObject(
                ExploreFlickSectionGetter.getJsonFromURL(OMDB_URL_BEGINNING + OMDB_BY_TITLE
                    + turnTitleInToURLFormat(title) + OMDB_URL_ENDING_DETAILS));

//            "http://www.omdbapi.com/?t=The+Avengers&y=&plot=short&r=json&tomatoes=true").getTitle();

            Log.i(TAG, "JSON = " + omdbFlickJsonObject);

            flick = new Flick(omdbFlickJsonObject.getString(OMDB_TITLE),
                omdbFlickJsonObject.getString(OMDB_YEAR),
                omdbFlickJsonObject.getString(OMDB_RATED),
                omdbFlickJsonObject.getString(OMDB_RUNTIME),
                omdbFlickJsonObject.getString(OMDB_GENRE),
                omdbFlickJsonObject.getString(OMDB_DIRECTOR),
                omdbFlickJsonObject.getString(OMDB_PLOT),
                omdbFlickJsonObject.getString(OMDB_AWARDS),
                omdbFlickJsonObject.getString(OMDB_IMDB_ID),
                omdbFlickJsonObject.getString(OMDB_METASCORE),
                omdbFlickJsonObject.getString(OMDB_IMDB_RATING),
                omdbFlickJsonObject.getString(OMDB_TOMATO_METER),
                omdbFlickJsonObject.getString(OMDB_PRODUCTION_STUDIO),
                OMDB_POSTER_BEGINNING_URL + OMDB_BY_ID +
                    omdbFlickJsonObject.getString(OMDB_IMDB_ID) + OMDB_API_KEY);


        } catch (JSONException e) {
            Log.i(TAG, "Exception = " + e.getMessage());
        }

        return flick;
    }

    private static String turnTitleInToURLFormat(String title) {
        //TODO: MAy cause error
        return title.replaceAll(" ", "+");
    }
}
