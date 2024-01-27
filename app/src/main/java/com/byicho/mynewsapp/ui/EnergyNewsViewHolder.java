package com.byicho.mynewsapp.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.byicho.mynewsapp.R;

public class EnergyNewsViewHolder extends RecyclerView.ViewHolder {
    ImageView newsImage;
    TextView newsTitle, newsDesc;


    public EnergyNewsViewHolder(@NonNull View itemView) {
        super(itemView);
        newsImage = itemView.findViewById(R.id.newsImage);
        newsTitle = itemView.findViewById(R.id.newsTitle);
        newsDesc = itemView.findViewById(R.id.newsDescription);
    }

    public ImageView getNewsImage() {
        return newsImage;
    }

    public TextView getNewsTitle() {
        return newsTitle;
    }

    public TextView getNewsDesc() {
        return newsDesc;
    }
}
