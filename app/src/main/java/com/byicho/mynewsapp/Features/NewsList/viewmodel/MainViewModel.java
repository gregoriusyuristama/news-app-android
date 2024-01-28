package com.byicho.mynewsapp.Features.NewsList.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.byicho.mynewsapp.Features.NewsList.model.NewsItemModel;
import com.byicho.mynewsapp.Core.services.NewsService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    public MutableLiveData<NewsItemModel> energyData = new MutableLiveData<>();
    public MutableLiveData<NewsItemModel> headlineNews = new MutableLiveData<>();

    private int page = 1;

    public void fetchAllEnergyData() {
        NewsService.getInstance().getNewsApi().getEnergyNews(page).enqueue(new Callback<NewsItemModel>() {
            @Override
            public void onResponse(@NonNull Call<NewsItemModel> call, @NonNull Response<NewsItemModel> response) {
                assert response.body() != null;
                energyData.postValue(response.body());
//                System.out.println(response.body().toString());
            }

            @Override
            public void onFailure(@NonNull Call<NewsItemModel> call, @NonNull Throwable t) {
                System.out.println("Error"+t.getMessage());
            }
        });
    }

    public void fetchHeadlineNews() {
        NewsService.getInstance().getNewsApi().getHeadlineNews().enqueue(new Callback<NewsItemModel>() {
            @Override
            public void onResponse(@NonNull Call<NewsItemModel> call, @NonNull Response<NewsItemModel> response) {
                assert response.body() != null;
                headlineNews.postValue(response.body());
                System.out.println(response.body().getArticles().get(0).getTitle());
            }

            @Override
            public void onFailure(@NonNull Call<NewsItemModel> call, @NonNull Throwable t) {
                System.out.println("Error"+t.getMessage());
            }
        });
    }

    public void fetchNextAllEnergyData() {
        page += 1;
        NewsService.getInstance().getNewsApi().getEnergyNews(page).enqueue(new Callback<NewsItemModel>() {
            @Override
            public void onResponse(@NonNull Call<NewsItemModel> call, @NonNull Response<NewsItemModel> response) {
                assert response.body() != null;
                energyData.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<NewsItemModel> call, @NonNull Throwable t) {
                System.out.println("Error"+t.getMessage());
            }
        });
    }


}
