package com.superpak.sammengistu.flickmatch.async;

import com.superpak.sammengistu.flickmatch.json_info_getter.ExploreFlickSectionGetter;
import com.superpak.sammengistu.flickmatch.model.FlickPoster;
import com.superpak.sammengistu.flickmatch.adapters.FlickPosterAdapter;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.GridView;

import java.util.List;

public class RetrieveFlickPosterAsync extends AsyncTask<String, Void, List<FlickPoster>> {


    private GridView mMoviePosterGridView;
    private Activity mActivity;
    private Boolean mIsTvSelection;

    public RetrieveFlickPosterAsync(GridView moviePosterGridView, Activity activity,
                                    boolean isTvSelection) {
        mMoviePosterGridView = moviePosterGridView;
        mActivity = activity;
        mIsTvSelection = isTvSelection;
    }

    @Override
    protected List<FlickPoster> doInBackground(String... params) {
         List<FlickPoster> flickPostersObjects = ExploreFlickSectionGetter.setUpFlickPosterObjectsFromTMDB(
            params[0], mIsTvSelection);
        return flickPostersObjects;
    }

    @Override
    protected void onPostExecute(List<FlickPoster> flickPosters) {

        mMoviePosterGridView.setAdapter(
            new FlickPosterAdapter(mActivity, flickPosters, mMoviePosterGridView));

    }
}
