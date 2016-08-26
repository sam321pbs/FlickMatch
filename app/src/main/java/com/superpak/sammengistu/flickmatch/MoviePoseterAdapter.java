package com.superpak.sammengistu.flickmatch;

import android.app.Activity;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by SamMengistu on 8/26/16.
 */
public class MoviePoseterAdapter extends BaseAdapter {

    private List<String> mMoviesPosterList;
    private Activity mActivity;
    private String mMovieTypes;
    private List<Movie> mMovieList;
    private GridView mGridView;

    public MoviePoseterAdapter(Activity activity) {
        mActivity = activity;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return mMoviesPosterList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MoviePosterViewHolder moviePosterViewHolder;

        if (convertView == null) {

            moviePosterViewHolder = new MoviePosterViewHolder();
            moviePosterViewHolder.position = position;
            // if it's not recycled, initialize the view
            LayoutInflater inflater = mActivity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.explorer_movie_poster_layout, parent, false);

            moviePosterViewHolder.mImageView = (ImageView)
                convertView.findViewById(R.id.explorer_poster_image_view);

            convertView.setTag(moviePosterViewHolder);
        } else {
            moviePosterViewHolder = (MoviePosterViewHolder) convertView.getTag();
        }

        moviePosterViewHolder.mImageView.setImageResource(R.mipmap.secret_life_of_pets_cover);
        
        moviePosterViewHolder.position = position;
        return convertView;
    }

    //Used to recycle views
    static class MoviePosterViewHolder {
        ImageView mImageView;
        int position;
    }
}
