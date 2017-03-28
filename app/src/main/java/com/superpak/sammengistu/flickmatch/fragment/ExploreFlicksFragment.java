package com.superpak.sammengistu.flickmatch.fragment;

import com.superpak.sammengistu.flickmatch.MovieSections;
import com.superpak.sammengistu.flickmatch.R;
import com.superpak.sammengistu.flickmatch.adapters.ExploreFlickSectionAdapter;
import com.superpak.sammengistu.flickmatch.async.RetrieveFlickPosterAsync;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;


public class ExploreFlicksFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private GridView mMoviePosterGridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_explore_flicks, container, false);

        mRecyclerView = (RecyclerView) view
            .findViewById(R.id.explorer_movie_section_titles_recycler_view);

        mMoviePosterGridView = (GridView) view.findViewById(R.id.movie_grid_view);


      new RetrieveFlickPosterAsync(mMoviePosterGridView,
          getActivity(), false).execute(MovieSections.POPULAR_MOVIES.getURLPoster());

        LinearLayoutManager layoutManager
            = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        ExploreFlickSectionAdapter exploreFlickSectionAdapter =
            new ExploreFlickSectionAdapter(getActivity(),
                (CoordinatorLayout) view, mMoviePosterGridView);


        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setAdapter(exploreFlickSectionAdapter);

        return view;
    }

}
