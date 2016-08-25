package com.superpak.sammengistu.flickmatch.fragment;

import com.superpak.sammengistu.flickmatch.adapters.ExploreFlickPosterAdapter;
import com.superpak.sammengistu.flickmatch.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ExploreFlicksFragment extends Fragment {

    private RecyclerView mRecyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_explore_flicks, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager
            = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        ExploreFlickPosterAdapter exploreFlickPosterAdapter =
            new ExploreFlickPosterAdapter(getActivity(), layoutManager);

        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setAdapter(exploreFlickPosterAdapter);
        return view;
    }
}
