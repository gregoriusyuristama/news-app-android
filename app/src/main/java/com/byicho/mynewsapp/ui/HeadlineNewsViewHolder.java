package com.byicho.mynewsapp.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.byicho.mynewsapp.R;

public class HeadlineNewsViewHolder extends RecyclerView.ViewHolder {

    ImageView newsImage;
    TextView newsTitle, newsDesc;

    public HeadlineNewsViewHolder(@NonNull View itemView) {
        super(itemView);
        newsImage = itemView.findViewById(R.id.headlineImage);
        newsTitle = itemView.findViewById(R.id.headlineTitle);
        newsDesc = itemView.findViewById(R.id.headlineDesc);
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