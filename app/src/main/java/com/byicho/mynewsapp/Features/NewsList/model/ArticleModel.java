package com.byicho.mynewsapp.Features.NewsList.model;


import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class ArticleModel {
    @SerializedName("source")
    private SourceModel sourceModel;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private Date publishedAt;
    private String content;



    public ArticleModel(SourceModel sourceModel, String author, String title, String description, String url, String urlToImage, Date publishedAt, String content) {
        this.sourceModel = sourceModel;
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
    }


    public SourceModel getSource() {
        return sourceModel;
    }

    public void setSource(SourceModel sourceModel) {
        this.sourceModel = sourceModel;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
