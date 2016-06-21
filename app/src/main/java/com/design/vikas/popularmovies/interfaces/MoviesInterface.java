package com.design.vikas.popularmovies.interfaces;

import com.design.vikas.popularmovies.model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by vikas kumar on 6/16/2016.
 */
public interface MoviesInterface {
    @GET("/3/movie/{sort}?")
    Call<ResponseModel> responseModelCall(@Path("sort") String sort_by, @Query("api_key") String api_key);

}
