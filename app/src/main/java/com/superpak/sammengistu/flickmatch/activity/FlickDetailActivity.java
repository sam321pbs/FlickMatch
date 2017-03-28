package com.superpak.sammengistu.flickmatch.activity;

import com.superpak.sammengistu.flickmatch.fragment.FlickDetailFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;


public class FlickDetailActivity extends SingleFragmentActivity {

    @Override
    public void onCreate(Bundle savedState) {
        super.onCreate(savedState);

    }
    @Override
    public Fragment createFragment() {
        String flickTitle = getIntent().getStringExtra("Movie Title");
        return  FlickDetailFragment.newInstance(flickTitle);
    }

}
