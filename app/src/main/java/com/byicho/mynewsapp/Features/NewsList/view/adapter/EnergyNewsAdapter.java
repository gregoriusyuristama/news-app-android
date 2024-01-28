package com.byicho.mynewsapp.Features.NewsList.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.byicho.mynewsapp.R;
import com.byicho.mynewsapp.Features.NewsList.model.ArticleModel;
import com.byicho.mynewsapp.Features.NewsList.model.NewsItemModel;
import com.byicho.mynewsapp.Features.NewsList.view.EnergyNewsViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class EnergyNewsAdapter extends RecyclerView.Adapter<EnergyNewsViewHolder> {


    Context context;
    NewsItemModel energyNews;

    public EnergyNewsAdapter(Context context) {
        this.context = context;
        this.energyNews = new NewsItemModel();
        energyNews.setArticles(new ArrayList<ArticleModel>());
    }


    private void populateItemRow(EnergyNewsViewHolder holder, int position) {
        holder.getNewsTitle().setText(energyNews.getArticles().get(position).getTitle());
        holder.getNewsDesc().setText(energyNews.getArticles().get(position).getDescription());
        String imageUrl = energyNews.getArticles().get(position).getUrlToImage();
        if ( imageUrl != null && !imageUrl.isEmpty()) {
            Picasso.get().load(imageUrl)
                    .fit()
                    .centerCrop()
                    .into(holder.getNewsImage());
        } else {
            Picasso.get().load(R.drawable.no_image)
                    .fit()
                    .centerInside()
                    .into(holder.getNewsImage());
        }
        holder.setNewsUrl(energyNews.getArticles().get(position).getUrl());
    }

    @NonNull
    @Override
    public EnergyNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EnergyNewsViewHolder(LayoutInflater.from(context).inflate(R.layout.news_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EnergyNewsViewHolder holder, int position) {
        populateItemRow(holder, position);
    }
    @Override
    public int getItemCount() {
        return energyNews.getArticles().size();
    }
//
    public void setEnergyNews(NewsItemModel energyNews) {
        this.energyNews = energyNews;
        notifyDataSetChanged();
    }

    public NewsItemModel getEnergyNews() {
        return energyNews;
    }
}
