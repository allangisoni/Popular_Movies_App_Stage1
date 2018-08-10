package com.example.android.pendomoviz.rest;

import com.example.android.pendomoviz.model.MovizResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TMdbApiInterface {

    @GET("movie/top_rated")
    Call<MovizResponse> getTopratedMovies(@Query("api_key") String apiKey);

    @GET("movie/popular")
    Call<MovizResponse> getPopularMovies(@Query("api_key") String apiKey);

    @GET("movie/id")
    Call<MovizResponse> getMovieDetails(@Path("id") int id , @Query("api_key") String apiKey);
}
