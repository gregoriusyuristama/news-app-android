package com.byicho.mynewsapp.Features.NewsList.view;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.byicho.mynewsapp.R;

public class HeadlineNewsViewHolder extends RecyclerView.ViewHolder {

    ImageView newsImage;
    TextView newsTitle, newsDesc;
    String newsUrl;

    public HeadlineNewsViewHolder(@NonNull View itemView) {
        super(itemView);
        newsImage = itemView.findViewById(R.id.headlineImage);
        newsTitle = itemView.findViewById(R.id.headlineTitle);
        newsDesc = itemView.findViewById(R.id.headlineDesc);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(newsUrl));
                browserIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                view.getContext().startActivity(browserIntent);
            }
        });
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

    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl;
    }
}