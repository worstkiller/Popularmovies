package com.design.vikas.popularmovies.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.design.vikas.popularmovies.R;
import com.design.vikas.popularmovies.model.ResponseDetailModel;
import com.squareup.picasso.Picasso;

/**
 * Created by vikas kumar on 6/21/2016.
 */
public class DetailsFragment extends Fragment {

    String title, desc, release, rating, image;
    TextView tvName,tvDesc,tvRating,tvDate;
    ImageView ivPoster;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_details,container,false);
        bindViews(view);
        getData(savedInstanceState);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setData();
    }

    private void setData() {
        //set the received data here
        tvRating.setText(rating);
        tvName.setText(title);
        tvDate.setText(release);
        tvDesc.setText(desc);
        Picasso.with(getActivity()).
                load("http://image.tmdb.org/t/p/w342/" + image).
                placeholder(R.drawable.placeholder).into(ivPoster);
    }

    private void getData(Bundle bundle) {
        //get bundle data
        bundle =  getArguments();
        ResponseDetailModel detailModel = bundle.getParcelable(HomeFragment.KEY_PARCEL);
        title = detailModel.getOriginalTitle();
        desc =  detailModel.getOverview();
        release = detailModel.getReleaseDate();
        rating = String.valueOf(detailModel.getVoteAverage());
        image = detailModel.getPosterPath();
        Log.d("parcel data",detailModel.getTitle()+"");
    }

    private void bindViews(View view) {
        //set views here
        ivPoster = (ImageView)view.findViewById(R.id.ivDetailsMovieImage);
        tvDate = (TextView)view.findViewById(R.id.tvDetailsDate);
        tvDesc = (TextView)view.findViewById(R.id.tvDetailsDesc);
        tvName = (TextView)view.findViewById(R.id.tvDetailsTitle);
        tvRating = (TextView)view.findViewById(R.id.tvDetailsRating);
    }
}
