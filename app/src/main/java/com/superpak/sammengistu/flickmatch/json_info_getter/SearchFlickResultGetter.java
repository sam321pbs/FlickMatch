package com.superpak.sammengistu.flickmatch.json_info_getter;

import com.superpak.sammengistu.flickmatch.FlickConstants;
import com.superpak.sammengistu.flickmatch.model.SearchItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class SearchFlickResultGetter {

    public static String TAG = "SearchFlickResultGetter";
    public static String SEARCH_OMDB_JSON = "Search";
    public static String SEARCH_OMDB_TITLE = "Title";
    public static String SEARCH_OMDB_YEAR = "Year";
    public static String SEARCH_OMDB_TYPE = "Type";
    public static String SEARCH_OMDB_IMDB_ID = "imdbID";


    public static List<SearchItem> getSearchResults(String queryString){
        List<SearchItem> searchItems = new ArrayList<>();

        //Todo: retrieve json
        String searchJson = ExploreFlickSectionGetter.getJsonFromURL(
            FlickConstants.SEARCH_BEGINNING + formatStringForSearch(queryString));
        //Todo: convert to search items

        return convertJSONToSearchItems(searchJson);
    }

    private static List<SearchItem> convertJSONToSearchItems (String json) {
        List<SearchItem> searchItems = new ArrayList<>();

        try {


            JSONObject jsonObject = new JSONObject(json);

            Log.i(TAG, "json object = " + jsonObject.toString());
            JSONArray jsonArray = jsonObject.getJSONArray(SEARCH_OMDB_JSON);

            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObjectCurrentFlick = jsonArray.getJSONObject(i);
                SearchItem searchItem = new SearchItem(
                    jsonObjectCurrentFlick.getString(DetailsInfoGetter.OMDB_TITLE),
                    jsonObjectCurrentFlick.getString(DetailsInfoGetter.OMDB_IMDB_ID),
                    jsonObjectCurrentFlick.getString(SEARCH_OMDB_TYPE),
                    jsonObjectCurrentFlick.getString(DetailsInfoGetter.OMDB_YEAR));

                searchItems.add(searchItem);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return searchItems;
    }

    private static String formatStringForSearch(String queryString) {
        String newString = queryString;

        newString = newString.replaceAll(" ", "+");

        if (newString.endsWith("+")){
            newString = newString.substring(0, newString.length() - 1);
        }

        Log.i(TAG, "formatted = " + newString);
        return newString;
    }

}
