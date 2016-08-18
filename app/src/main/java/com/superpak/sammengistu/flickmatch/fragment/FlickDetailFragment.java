package com.superpak.sammengistu.flickmatch.fragment;

import com.superpak.sammengistu.flickmatch.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FlickDetailFragment extends Fragment {

    @Override
    public void onCreate(Bundle onSavedInstanceState) {
        super.onCreate(onSavedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View flikDetailView = inflater.inflate(R.layout.fragment_detail_flick, container, false);

        return flikDetailView;
    }
}
