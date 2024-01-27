package com.byicho.mynewsapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.byicho.mynewsapp.R;
import com.byicho.mynewsapp.model.ArticleModel;
import com.byicho.mynewsapp.model.NewsItemModel;
import com.byicho.mynewsapp.ui.EnergyNewsViewHolder;
import com.github.islamkhsh.CardSliderAdapter;
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
    }

    @NonNull
    @Override
    public EnergyNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EnergyNewsViewHolder(LayoutInflater.from(context).inflate(R.layout.news_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EnergyNewsViewHolder holder, int position) {
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
