package com.byicho.mynewsapp.Features.NewsList.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.byicho.mynewsapp.R;
import com.byicho.mynewsapp.Features.NewsList.model.ArticleModel;
import com.byicho.mynewsapp.Features.NewsList.model.NewsItemModel;
import com.byicho.mynewsapp.Features.NewsList.view.HeadlineNewsViewHolder;
import com.github.islamkhsh.CardSliderAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HeadlineNewsAdapter extends CardSliderAdapter<HeadlineNewsViewHolder> {

    Context context;
    NewsItemModel headlineNews;

    public HeadlineNewsAdapter(Context context) {
        this.context = context;
        this.headlineNews = new NewsItemModel();
        headlineNews.setArticles(new ArrayList<ArticleModel>());
    }

    @Override
    public void bindVH(@NonNull HeadlineNewsViewHolder headlineNewsViewHolder, int i) {

        ArticleModel article = headlineNews.getArticles().get(i);
        String imageUrl = headlineNews.getArticles().get(i).getUrlToImage();
        if ( imageUrl != null && !imageUrl.isEmpty()) {
            Picasso.get().load(imageUrl)
                    .fit()
                    .centerCrop()
                    .into(headlineNewsViewHolder.getNewsImage());
        } else {
            Picasso.get().load(R.drawable.no_image)
                    .fit()
                    .centerInside()
                    .into(headlineNewsViewHolder.getNewsImage());
        }
        headlineNewsViewHolder.getNewsTitle().setText(headlineNews.getArticles().get(i).getTitle());
        headlineNewsViewHolder.getNewsDesc().setText(headlineNews.getArticles().get(i).getDescription());
        headlineNewsViewHolder.setNewsUrl(headlineNews.getArticles().get(i).getUrl());
    }

    @NonNull
    @Override
    public HeadlineNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HeadlineNewsViewHolder(LayoutInflater.from(context).inflate(R.layout.news_headline, parent, false));
    }

    @Override
    public int getItemCount() {
        return headlineNews.getArticles().size();
    }

    public void setHeadlineNews(NewsItemModel headlineNews) {
        this.headlineNews = headlineNews;
        notifyDataSetChanged();
    }
}
