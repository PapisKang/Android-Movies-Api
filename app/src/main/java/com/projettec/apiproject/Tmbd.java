package com.projettec.apiproject;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.converter.gson.*;

import java.util.List;

public interface Tmbd {

    @GET("3/discover/movie")
    Call<Movies> movies(@Query("api_key") String api_key,@Query("language") String lang);

    @GET("3/movie/{movie_id}")
    Call<MovieDetail> movieDetail(@Path("movie_id") String movieId,@Query("api_key") String api_key,@Query("language") String lang);

    @GET("3/movie/{movie_id}/similar")
    Call<MovieDetail> movieSimilar(@Path("movie_id") String movieId,@Query("api_key") String api_key,@Query("language") String lang);

    @GET("3/movie/{movie_id}/credits")
    Call<CastList> movieCasting(@Path("movie_id") String movieId,@Query("api_key") String api_key,@Query("language") String lang);

    @GET("3/movie/{movie_id}/videos")
    Call<VideoYoutubeList> youtubeVideo(@Path("movie_id") String movieId,@Query("api_key") String api_key,@Query("language") String lang);


}
