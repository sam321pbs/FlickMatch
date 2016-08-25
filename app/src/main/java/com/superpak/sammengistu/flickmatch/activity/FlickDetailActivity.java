package com.superpak.sammengistu.flickmatch.activity;

import com.superpak.sammengistu.flickmatch.fragment.FlickDetailFragment;

import android.support.v4.app.Fragment;


public class FlickDetailActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return new FlickDetailFragment();
    }

}
