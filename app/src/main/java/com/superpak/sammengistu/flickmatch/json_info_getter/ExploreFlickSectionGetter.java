package com.superpak.sammengistu.flickmatch.json_info_getter;

import com.superpak.sammengistu.flickmatch.model.FlickPoster;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * This class gets the movie info from the web
 */
public class ExploreFlickSectionGetter {

    private static String TAG = "MovieInfoGetter55";

    private static final String BASE_URL_FOR_POSTER =
        "http://image.tmdb.org/t/p/";

    private static final String IMAGE_SIZE = "w185/";

    //Info from json
    private static final String RESULT = "results";
    private static final String POSTER_PATH = "poster_path";
    private static final String MOVIE_TITLE = "original_title";
    private static final String ORIGINAL_TITLE_TV = "original_name";
    private final String MOVIE_SYNOPSIS = "overview";
    private final String MOVIE_RATING = "vote_average";
    private final String MOVIE_RELEASE_DATE = "release_date";
    private final String MOVIE_ID = "id";
    private final String MOVIE_YOUTUBE_ID = "key";
    private final String REVIEW_AUTHOR = "author";
    private final String REVIEW_CONTENT = "content";

    /**
     * Uses the OKHTTP Library to get the json object from the web
     *
     * @param urlForTypeOfMovies - the destination to get the web info from
     * @return - json object
     */
    public static String getJsonFromURL(String urlForTypeOfMovies) {
        String jsonFromTMDB = "";

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
            .url(urlForTypeOfMovies)
            .build();
        try {

            Response response = client.newCall(request).execute();
            jsonFromTMDB = response.body().string();

        } catch (IOException e) {

        }
        return jsonFromTMDB;
    }

    /**
     * Coverts the JSON object into a movie object with the information it gets from the web
     *
     * @param url - the destination to get the web info from
     * @return - List of movie objects
     */
    public static List<FlickPoster> setUpFlickPosterObjectsFromTMDB(String url,
                                                                    boolean isTvRequest) {
        List<FlickPoster> flickPosters = new ArrayList<>();

        try {
            //Convert Json String to Json Object
            JSONObject moviesJsonObject = new JSONObject(getJsonFromURL(url));

            //Get the Json Array
            JSONArray moviesJsonArray = moviesJsonObject.getJSONArray(RESULT);

            for (int i = 0; i < moviesJsonArray.length(); i++) {
                JSONObject jsonObject = moviesJsonArray.getJSONObject(i);

                FlickPoster newFlick;
                if (isTvRequest){
                    newFlick = new FlickPoster(
                        BASE_URL_FOR_POSTER + IMAGE_SIZE + jsonObject.getString(POSTER_PATH),
                        jsonObject.getString(ORIGINAL_TITLE_TV));
                } else {
                    newFlick = new FlickPoster(
                        BASE_URL_FOR_POSTER + IMAGE_SIZE + jsonObject.getString(POSTER_PATH),
                        jsonObject.getString(MOVIE_TITLE));
                }

                flickPosters.add(newFlick);

            }

            return flickPosters;
        } catch (JSONException e) {
            Log.i(TAG, "Exception = " + e.getMessage());
        }

        return flickPosters;
    }
}