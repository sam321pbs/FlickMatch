package com.superpak.sammengistu.flickmatch.fragment;

import com.squareup.picasso.Picasso;
import com.superpak.sammengistu.flickmatch.R;
import com.superpak.sammengistu.flickmatch.json_info_getter.DetailsInfoGetter;
import com.superpak.sammengistu.flickmatch.model.Flick;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FlickDetailFragment extends Fragment {

    private static final String TAG = "FlickDetailFragment";
    @BindView(R.id.detail_movie_poster)
    ImageView mMoviePosterImageView;
    @BindView(R.id.detail_title_of_flick)
    TextView mTitleTextView;
    @BindView(R.id.detail_rotten_tomatoe_score)
    TextView mTomatoRatingTextView;
    @BindView(R.id.detail_imdb_score)
    TextView mImdbScoreTextView;
    @BindView(R.id.detail_metascore)
    TextView mMetascore;
    @BindView(R.id.detail_release_year)
    TextView mRealeaseYearTextView;
    @BindView(R.id.detail_runtime)
    TextView mRunTimeTextView;
    @BindView(R.id.detail_movie_rating)
    TextView mFlickRatedTextView;
    @BindView(R.id.detail_genre)
    TextView mGenreTextView;
    @BindView(R.id.detail_movie_synopsis)
    TextView mSynopsisTextView;
    @BindView(R.id.detail_studio)
    TextView mStudioTextView;
    @BindView(R.id.detail_awards)
    TextView mAwardsTextView;

    private Flick mCurrentFlick;

    GetFlickDetailListener mCallBack;

    // Container Activity must implement this interface
    public interface GetFlickDetailListener {
        void onFlickSelected(String title);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallBack = (GetFlickDetailListener) context;
        } catch (ClassCastException e) {

        }
    }

    @Override
    public void onCreate(Bundle onSavedInstanceState) {
        super.onCreate(onSavedInstanceState);

    }

    private void updateView() {
        mTitleTextView.setText(mCurrentFlick.getTitle());
        mTomatoRatingTextView.setText(mCurrentFlick.getTomatoMeter());
        mImdbScoreTextView.setText(mCurrentFlick.getIMDBRating());
        mMetascore.setText(mCurrentFlick.getMetascore());
        mRealeaseYearTextView.setText(mCurrentFlick.getYear());
        mRunTimeTextView.setText(mCurrentFlick.getRuntime());
        mFlickRatedTextView.setText(mCurrentFlick.getRated());
        mGenreTextView.setText(mCurrentFlick.getGenre());
        mSynopsisTextView.setText(mCurrentFlick.getPlot());
        mStudioTextView.setText(mCurrentFlick.getProductionStudio());
        mAwardsTextView.setText(mCurrentFlick.getAwards());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View flickDetailView = inflater.inflate(R.layout.fragment_detail_flick, container, false);
        ButterKnife.bind(FlickDetailFragment.this, flickDetailView);

        Log.i(TAG, "Got Movie name = " + getArguments().getString("Movie Title", "N/A"));

        //Todo:MAke its own class
        new AsyncTask<Void, Void,Flick>(){

            @Override
            protected Flick doInBackground(Void... params) {
//                Log.i("FLICK DETAIL", "" + DetailsInfoGetter.setUpFlickPosterObjectsFromTMDB(
//                    "http://www.omdbapi.com/?t=The+Avengers&y=&plot=short&r=json&tomatoes=true").getTitle());
                return DetailsInfoGetter.setUpFlickPosterObjectsFromTMDB(
                    getArguments().getString("Movie Title", "N/A"));
            }

            @Override
            protected void onPostExecute(Flick flick) {
                Log.i(TAG, "Poster URL = " + flick.getIMDBId());
                Log.i(TAG , flick.getTitle());
                Picasso.with(getActivity())
                    .load(flick.getIMDBId())
                    .resize(250,
                       400)
                    .centerCrop()
                    //TODO: add place holder images
//            .placeholder(R.drawable.empty_poster)
//            .error(R.drawable.empty_poster)
                    .into(mMoviePosterImageView);
                mCurrentFlick = flick;
                updateView();
            }
        }.execute();

        return flickDetailView;
    }

    public static FlickDetailFragment newInstance(String title){
        Bundle args = new Bundle();
        args.putString("Movie Title", title);

        FlickDetailFragment flickDetailFragment = new FlickDetailFragment();
        flickDetailFragment.setArguments(args);

        return flickDetailFragment;
    }
}
