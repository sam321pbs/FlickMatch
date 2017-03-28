package com.superpak.sammengistu.flickmatch.async;

import com.superpak.sammengistu.flickmatch.adapters.FlickSearchAdapter;
import com.superpak.sammengistu.flickmatch.json_info_getter.SearchFlickResultGetter;
import com.superpak.sammengistu.flickmatch.model.SearchItem;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import java.util.List;

public class RetrieveSearchResultsAsync extends AsyncTask<String, Void, List<SearchItem>> {

    private Context mContext;
    private ListView mListView;

    public RetrieveSearchResultsAsync(Context context, ListView listView) {
        mContext = context;
        mListView = listView;
    }

    @Override
    protected List<SearchItem> doInBackground(String... params) {
        return SearchFlickResultGetter.getSearchResults(params[0].toLowerCase());
    }

    @Override
    protected void onPostExecute(List<SearchItem> searchItems) {
        FlickSearchAdapter flickSearchAdapter =
            new FlickSearchAdapter(mContext, searchItems);

        mListView.setAdapter(flickSearchAdapter);
    }
}
