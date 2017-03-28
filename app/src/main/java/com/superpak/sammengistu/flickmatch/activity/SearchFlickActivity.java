package com.superpak.sammengistu.flickmatch.activity;

import com.superpak.sammengistu.flickmatch.R;
import com.superpak.sammengistu.flickmatch.async.RetrieveSearchResultsAsync;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;


public class SearchFlickActivity extends AppCompatActivity {

    public static String TAG = "SearchActivity";
    public ListView mSearchQueryFlickListView;

    @Override
    public void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        setContentView(R.layout.search_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_search);
        setSupportActionBar(toolbar);

        mSearchQueryFlickListView = (ListView) findViewById(android.R.id.list);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager)this.getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(this.getComponentName()));
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                RetrieveSearchResultsAsync mRetrieveSearchResultsAsync;
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    Log.i(TAG, "search = " + newText);

                    if (mRetrieveSearchResultsAsync != null) {
                        mRetrieveSearchResultsAsync.cancel(true);
                    }

                    //TODO: search and set adapter
                   mRetrieveSearchResultsAsync = new
                       RetrieveSearchResultsAsync(SearchFlickActivity.this,
                       mSearchQueryFlickListView);
                    mRetrieveSearchResultsAsync.execute(newText);

                    return false;
                }
            });
        }
        return super.onCreateOptionsMenu(menu);
    }
}
