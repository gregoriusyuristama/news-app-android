package com.byicho.mynewsapp.Core.services;

import com.byicho.mynewsapp.Core.api.NewsAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsService {


    private static final String URL = "https://newsapi.org/v2/";
    private final NewsAPI newsApi;
    private static NewsService singleton;

    public NewsService() {
        Retrofit mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL)
                .build();

        newsApi = mRetrofit.create(NewsAPI.class);
    }

    public static NewsService getInstance() {
        if (singleton == null) {
            synchronized (NewsService.class){
                if (singleton == null){
                    singleton = new NewsService();
                }
            }
        }
        return  singleton;
    }

    public NewsAPI getNewsApi() {
        return newsApi;
    }
}
