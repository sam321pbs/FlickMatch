package com.superpak.sammengistu.flickmatch.adapters;

import com.squareup.picasso.Picasso;
import com.superpak.sammengistu.flickmatch.activity.FlickDetailActivity;
import com.superpak.sammengistu.flickmatch.model.FlickPoster;
import com.superpak.sammengistu.flickmatch.R;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;


public class FlickPosterAdapter extends BaseAdapter {

    private Activity mActivity;
    private List<FlickPoster> mMovieList;
    private GridView mGridView;

    public FlickPosterAdapter(Activity activity, List<FlickPoster> movies, GridView gridView) {
        mActivity = activity;
        mMovieList = movies;
        mGridView = gridView;
    }

    @Override
    public int getCount() {
        return mMovieList.size();
    }

    @Override
    public Object getItem(int position) {
        return mMovieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

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

        moviePosterViewHolder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity, FlickDetailActivity.class);
                intent.putExtra("Movie Title", mMovieList.get(position).getFlickTitle());

                mActivity.startActivity(intent);
            }
        });

        Picasso.with(mActivity)
            .load(mMovieList.get(position).getPosterURL())
            .resize(mGridView.getColumnWidth(),
                mGridView.getHeight() / 2)
            .centerCrop()
            //TODO: add place holder images
//            .placeholder(R.drawable.empty_poster)
//            .error(R.drawable.empty_poster)
            .into(moviePosterViewHolder.mImageView);
        
        moviePosterViewHolder.position = position;
        return convertView;
    }

    //Used to recycle views
    static class MoviePosterViewHolder {
        ImageView mImageView;
        int position;
    }
}
