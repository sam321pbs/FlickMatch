package com.superpak.sammengistu.flickmatch.activity;

import com.superpak.sammengistu.flickmatch.R;
import com.superpak.sammengistu.flickmatch.fragment.ExploreFlicksFragment;
import com.superpak.sammengistu.flickmatch.fragment.FlickDetailFragment;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public abstract class SingleFragmentActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener,
   FlickDetailFragment.GetFlickDetailListener {

    public abstract Fragment createFragment();

    private Fragment mFragment;
    private FragmentManager mFragmentManager;
    public static Toolbar sToolbar;

    //By default call this but gets override to use the appropriate view
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        mFragmentManager = getSupportFragmentManager();

        mFragment = mFragmentManager.findFragmentById(R.id.fragment_container);
        handleIntent(getIntent());
        mFragment = createFragment();

        mFragmentManager.beginTransaction()
            .add(R.id.fragment_container, mFragment)
            .commit();

        sToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(sToolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, sToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        mFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        if (id == R.id.nav_camera) {
            // Handle the camera action

            mFragment = new FlickDetailFragment();


        } else if (id == R.id.nav_gallery) {

            mFragment = new ExploreFlicksFragment();

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        switchContent(mFragment);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }


    public void switchContent(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().
            remove(mFragment).commit();

        mFragment = fragment;
        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit();

    }

    @Override
    public void onFlickSelected(String title){
        mFragment = new FlickDetailFragment();

        Bundle bundle = new Bundle();
        bundle.putString("Movie Title", title);
        mFragment.setArguments(bundle);

        switchContent(mFragment);
    }

    private void handleIntent(Intent intent) {

        Log.i("SingleFragmentAct", "Query = " + "nada");

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            //use the query to search your data somehow
            Log.i("SingleFragmentAct", "Query = " + query);
        }
    }
}
