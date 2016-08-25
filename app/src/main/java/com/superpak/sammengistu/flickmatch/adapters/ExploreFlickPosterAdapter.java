package com.superpak.sammengistu.flickmatch.adapters;

import com.superpak.sammengistu.flickmatch.R;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ExploreFlickPosterAdapter extends RecyclerView.Adapter<ExploreFlickPosterAdapter
    .FlickPosterAdapterViewHolder> {

    private Context mAppContext;
    private LinearLayoutManager mLinearLayoutManager;

    public ExploreFlickPosterAdapter(Context appContext, LinearLayoutManager linearLayoutManager) {
        mAppContext = appContext;
        mLinearLayoutManager = linearLayoutManager;
    }

    @Override
    public FlickPosterAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mAppContext);

        View v = inflater.inflate(R.layout.explore_flick_recycler_view_item, parent, false);

        return new FlickPosterAdapterViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return 10;
    }


    @Override
    public void onBindViewHolder(FlickPosterAdapterViewHolder holder, int position) {

        holder.mPoster.setImageResource(R.mipmap.secret_life_of_pets_cover);
        holder.mTitle.setText("Secret Life Of Pets");

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

//Scroll item 2 to 20 pixels from the top
//        linearLayoutManager.scrollToPositionWithOffset(2, 20);

        if (position == 0) {

            layoutParams.setMarginStart(0);
            layoutParams.setMarginEnd(25);
        } else if (position == getItemCount() - 1) {

            layoutParams.setMarginStart(25);
            layoutParams.setMarginEnd(0);

        } else {
            layoutParams.setMarginStart(25);
            layoutParams.setMarginEnd(25);

        }
        holder.mFlickMoviewPosterLinearLayout.setLayoutParams(layoutParams);

    }

    public class FlickPosterAdapterViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout mFlickMoviewPosterLinearLayout;
        public ImageView mPoster;
        public TextView mTitle;

        public FlickPosterAdapterViewHolder(View itemView) {
            super(itemView);

            mPoster = (ImageView) itemView.findViewById(R.id.explore_movie_item_poster);
            mTitle = (TextView) itemView.findViewById(R.id.explore_movie_item_title);
            mFlickMoviewPosterLinearLayout = (LinearLayout) itemView.findViewById(R.id.linear_layout_poster);

        }
    }
}
