package com.superpak.sammengistu.flickmatch.activity;

import com.superpak.sammengistu.flickmatch.fragment.ExploreFlicksFragment;

import android.support.v4.app.Fragment;

/**
 * Created by SamMengistu on 9/2/16.
 */
public class ExploreFlickSectionActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return new ExploreFlicksFragment();
    }


}
