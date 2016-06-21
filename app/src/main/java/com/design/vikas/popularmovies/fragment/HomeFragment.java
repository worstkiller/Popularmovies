package com.design.vikas.popularmovies.fragment;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.design.vikas.popularmovies.BuildConfig;
import com.design.vikas.popularmovies.R;
import com.design.vikas.popularmovies.activity.SettingsFragment;
import com.design.vikas.popularmovies.adapter.RecyclerviewAdapter;
import com.design.vikas.popularmovies.interfaces.MoviesInterface;
import com.design.vikas.popularmovies.model.ResponseDetailModel;
import com.design.vikas.popularmovies.model.ResponseModel;
import com.design.vikas.popularmovies.util.WebUrl;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vikas kumar on 6/15/2016.
 */

/* Restrofit is an open source android networking project used for making network call better way
   hosted here - http://square.github.io/retrofit/
   API used for movies data is - http://api.themoviedb.org
 */
public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerviewAdapter adapter;
    List<ResponseDetailModel> detailModels = new ArrayList<>();
    Retrofit retrofit;
    MoviesInterface moviesInterface;
    String stringSortValue ;
    SharedPreferences preferences;
    static String KEY_TITLE = "title";
    static String KEY_DESC = "description";
    static String KEY_RATING = "rating";
    static String KEY_RELEASE_DATE = "release";
    static String KEY_IMAGE_LINK = "IMAGE";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PreferenceManager.setDefaultValues(getActivity(), R.xml.pref, false);
        preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        stringSortValue = preferences.getString(SettingsFragment.SORT_ORDER, null);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        bindView(view);
        setupWithRecyclewView();
        setupListener();
        makeDataRequest();
        return view;
    }

    private void setupListener() {
        adapter.setOnItemClickListener(new RecyclerviewAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {

                  if (v.getId() == R.id.ivMoviesPoster) {
                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_TITLE, detailModels.get(position).getTitle());
                    bundle.putString(KEY_DESC, detailModels.get(position).getOverview());
                    bundle.putString(KEY_RELEASE_DATE, detailModels.get(position).getReleaseDate());
                    bundle.putString(KEY_RATING, String.valueOf(detailModels.get(position).getVoteAverage()));
                    bundle.putString(KEY_IMAGE_LINK, detailModels.get(position).getPosterPath());

                    DetailsFragment detailsFragment = new DetailsFragment();
                    detailsFragment.setArguments(bundle);

                    getActivity().getFragmentManager().
                            beginTransaction().replace(R.id.flContainer, detailsFragment).
                            addToBackStack("details").commit();
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        stringSortValue = preferences.getString(SettingsFragment.SORT_ORDER, null);
        makeDataRequest();
    }

    private void makeDataRequest() {
        //network call to movies api goes here
        retrofit = new Retrofit.Builder().
                baseUrl(WebUrl.URL).
                addConverterFactory(GsonConverterFactory.create()).
                build();

        moviesInterface = retrofit.create(MoviesInterface.class);

        Call<ResponseModel> modelCall = moviesInterface.responseModelCall(stringSortValue, BuildConfig.APIKEY);
        modelCall.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                detailModels = response.body().getResults();
                adapter = new RecyclerviewAdapter(detailModels,getActivity());
                adapter.notifyDataSetChanged();
                recyclerView.swapAdapter(adapter, false);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

                Toast.makeText(getActivity(),"data could not be loaded",Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setupWithRecyclewView() {
        //setting here the recyclew view
        adapter = new RecyclerviewAdapter(detailModels,getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        }
        else    recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setAdapter(adapter);
    }


    private void bindView(View view) {
        //binding views here
        recyclerView = (RecyclerView)view.findViewById(R.id.rvMovies);
    }

}
