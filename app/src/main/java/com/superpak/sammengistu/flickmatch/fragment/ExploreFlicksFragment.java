package com.superpak.sammengistu.flickmatch.fragment;

import com.superpak.sammengistu.flickmatch.MoviePoseterAdapter;
import com.superpak.sammengistu.flickmatch.R;
import com.superpak.sammengistu.flickmatch.adapters.ExploreFlickSectionAdapter;

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
    private View mParentView;
    private GridView mMoviePosterGridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_explore_flicks, container, false);

        mParentView = getActivity().findViewById(R.id.app_bar_main);

        mRecyclerView = (RecyclerView) view
            .findViewById(R.id.explorer_movie_section_titles_recycler_view);

        mMoviePosterGridView = (GridView) view.findViewById(R.id.movie_grid_view);

        mMoviePosterGridView.setAdapter(new MoviePoseterAdapter(getActivity()));

        LinearLayoutManager layoutManager
            = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        ExploreFlickSectionAdapter exploreFlickSectionAdapter =
            new ExploreFlickSectionAdapter(getActivity(),
                (CoordinatorLayout) view);


        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setAdapter(exploreFlickSectionAdapter);

        return view;
    }

}
