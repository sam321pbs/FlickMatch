package com.superpak.sammengistu.flickmatch.adapters;

import com.superpak.sammengistu.flickmatch.MovieSections;
import com.superpak.sammengistu.flickmatch.R;
import com.superpak.sammengistu.flickmatch.async.RetrieveFlickPosterAsync;
import com.superpak.sammengistu.flickmatch.activity.SingleFragmentActivity;

import android.app.Activity;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;


public class ExploreFlickSectionAdapter extends RecyclerView.Adapter<ExploreFlickSectionAdapter
    .FlickPosterAdapterViewHolder> {

    private Activity mActivity;
    private FlickPosterAdapterViewHolder mCurrentSection;
    private CoordinatorLayout mCoordinatorLayout;
    private GridView mGridViewPosters;

    public ExploreFlickSectionAdapter(Activity activity, CoordinatorLayout coordinatorLayout,
                                      GridView gridViewPosters) {
        mActivity = activity;
        mCoordinatorLayout = coordinatorLayout;
        mGridViewPosters = gridViewPosters;
    }

    @Override
    public FlickPosterAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mActivity);

        View v = inflater.inflate(R.layout.explore_title_section_item, parent, false);

        return new FlickPosterAdapterViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return MovieSections.values().length;
    }


    @Override
    public void onBindViewHolder(FlickPosterAdapterViewHolder holder, int position) {

        mCurrentSection = holder;

        switch (position) {
            case 0:
                setTitleAndOnCLick(MovieSections.POPULAR_MOVIES);
                break;
            case 1:
                setTitleAndOnCLick(MovieSections.NOW_PLAYING_MOVIES);
                break;
            case 2:
                setTitleAndOnCLick(MovieSections.UPCOMING_MOVIES);
                break;
            case 3:
                setTitleAndOnCLick(MovieSections.TOP_RATED_MOVIES);
                break;
            case 4:
                setTitleAndOnCLick(MovieSections.ON_THE_AIR_TV_SHOWS);
                break;
            case 5:
                setTitleAndOnCLick(MovieSections.POPULAR_TV_SHOWS);
                break;
            case 6:
                setTitleAndOnCLick(MovieSections.AIRING_TODAY_TV_SHOWS);
                break;
            case 7:
                setTitleAndOnCLick(MovieSections.TOP_RATED_TV_SHOWS);
        }
    }

    private void setTitleAndOnCLick(final MovieSections movieSections){
        mCurrentSection.mTitle.setText(movieSections.getTitleName());

        mCurrentSection.mTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("SECTIONADAPTER" , movieSections.getURLPoster());
                Snackbar.make(mCoordinatorLayout, movieSections.getTitleName(),
                    Snackbar.LENGTH_SHORT).show();
                SingleFragmentActivity.sToolbar.setTitle(movieSections.getTitleName());

                if (movieSections.toString().contains("TV")){
                    new RetrieveFlickPosterAsync(mGridViewPosters,
                        mActivity, true).execute(movieSections.getURLPoster());
                } else {
                    new RetrieveFlickPosterAsync(mGridViewPosters,
                        mActivity,false).execute(movieSections.getURLPoster());
                }
            }
        });

    }

    public class FlickPosterAdapterViewHolder extends RecyclerView.ViewHolder {

        public TextView mTitle;

        public FlickPosterAdapterViewHolder(View itemView) {
            super(itemView);

            mTitle = (TextView) itemView.findViewById(R.id.explore_movie_section_item_title);

        }
    }
}
