package com.byicho.mynewsapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NewsItemModel{
   private String status;
   private int totalResults;
   @SerializedName("articles")
   private ArrayList<ArticleModel> articleModels;

    public NewsItemModel(String status, int totalResults, ArrayList<ArticleModel> articleModels) {
        this.status = status;
        this.totalResults = totalResults;
        this.articleModels = articleModels;
    }

    public NewsItemModel() { }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<ArticleModel> getArticles() {
        return articleModels;
    }

    public void setArticles(ArrayList<ArticleModel> articleModels) {
        this.articleModels = articleModels;
    }
}

