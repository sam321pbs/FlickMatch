package com.superpak.sammengistu.flickmatch.adapters;

import com.squareup.picasso.Picasso;
import com.superpak.sammengistu.flickmatch.R;
import com.superpak.sammengistu.flickmatch.json_info_getter.DetailsInfoGetter;
import com.superpak.sammengistu.flickmatch.model.SearchItem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class FlickSearchAdapter extends ArrayAdapter<SearchItem> {

    private Context mAppContext;
    private List<SearchItem> mSearchItems;

    public FlickSearchAdapter (Context context, List<SearchItem> searchItems){
        super(context, -1, searchItems);
        mAppContext = context;
        mSearchItems = searchItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater)
            mAppContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.search_query_item, parent, false);

        TextView titleFlick = (TextView) view.findViewById(R.id.search_title_movie);
        TextView yearFlick = (TextView) view.findViewById(R.id.search_movie_year);
        TextView flickType = (TextView) view.findViewById(R.id.search_type);

        ImageView imageView = (ImageView) view.findViewById(R.id.search_item_picture);

        titleFlick.setText(mSearchItems.get(position).getFlickTitle());
        yearFlick.setText(mSearchItems.get(position).getFlickYear());
        flickType.setText(mSearchItems.get(position).getFlickType());

        //Todo: get flick Image and Set with picasso


        Picasso.with(mAppContext)
            .load(
                DetailsInfoGetter.OMDB_POSTER_BEGINNING_URL + DetailsInfoGetter.OMDB_BY_ID +
                    mSearchItems.get(position).getIMDBFlickId() + DetailsInfoGetter.OMDB_API_KEY)
            .resize(80, 100)
            .centerCrop()
            //TODO: add place holder images
//            .placeholder(R.drawable.empty_poster)
//            .error(R.drawable.empty_poster)
            .into(imageView);


        return view;
    }
}
