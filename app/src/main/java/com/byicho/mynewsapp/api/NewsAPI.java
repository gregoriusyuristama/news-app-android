package com.byicho.mynewsapp.api;

import com.byicho.mynewsapp.model.NewsItemModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NewsAPI {
    String API_KEY = "fbb6e0a558844a99846bfb3d0c622e62";

    @Headers("X-Api-Key: " + API_KEY)
    @GET("everything?q=energy")
    Call<NewsItemModel> getEnergyNews(@Query("page") int page);

    @Headers("X-Api-Key: "+ API_KEY)
    @GET("top-headlines?country=us")
    Call<NewsItemModel> getHeadlineNews();
}
