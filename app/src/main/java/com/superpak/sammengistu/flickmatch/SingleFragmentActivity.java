package com.superpak.sammengistu.flickmatch;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;


public abstract class SingleFragmentActivity extends AppCompatActivity {

    public abstract Fragment createFragment();

    private Fragment mFragment;

    //By default call this but gets override to use the appropriate view
    protected int getLayoutResId() {
        return R.layout.activity_fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        FragmentManager fragmentManager = getSupportFragmentManager();

        mFragment = fragmentManager.findFragmentById(R.id.fragment_container);

        mFragment = createFragment();

        fragmentManager.beginTransaction()
            .add(R.id.fragment_container, mFragment )
            .commit();
    }
}
