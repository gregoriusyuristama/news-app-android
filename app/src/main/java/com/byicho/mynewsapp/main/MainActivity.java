package com.byicho.mynewsapp.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.byicho.mynewsapp.R;
import com.byicho.mynewsapp.databinding.ActivityMainBinding;
import com.byicho.mynewsapp.utils.EndlessRecyclerViewScrollListener;
import com.byicho.mynewsapp.viewmodel.MainViewModel;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel viewModel;
    private EnergyNewsAdapter allEnergyNewsAdapter;
    private HeadlineNewsAdapter headlineNewsAdapter;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initProgressBar();
        initAdapter();
        initObserver();
        initScrollListener();
        fetchData();
    }

    private void initAdapter() {
        allEnergyNewsAdapter = new EnergyNewsAdapter(getApplicationContext());
        binding.allEnergyNews.setLayoutManager(new LinearLayoutManager(this));
        binding.allEnergyNews.setAdapter(allEnergyNewsAdapter);

        headlineNewsAdapter = new HeadlineNewsAdapter(getApplicationContext());
        binding.allHeadLineNews.setAdapter(headlineNewsAdapter);
    }

    private void initObserver() {
        viewModel.energyData.observe(this, newsItemModel -> {
            if (allEnergyNewsAdapter.energyNews.getArticles().size() > 0) {
                allEnergyNewsAdapter.energyNews.getArticles().addAll(newsItemModel.getArticles());
            } else {
                allEnergyNewsAdapter.setEnergyNews(newsItemModel);
            }
            progress.dismiss();
        });

        viewModel.headlineNews.observe(this, newsItemModel -> headlineNewsAdapter.setHeadlineNews(newsItemModel));
    }

    private void initScrollListener() {
        EndlessRecyclerViewScrollListener scrollListener = new EndlessRecyclerViewScrollListener((LinearLayoutManager) binding.allEnergyNews.getLayoutManager()) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                // Triggered only when new data needs to be appended to the list
                // Add whatever code is needed to append new items to the bottom of the list
                progress.show();
                viewModel.fetchNextAllEnergyData();
            }
        };
        // Adds the scroll listener to RecyclerView
        binding.allEnergyNews.addOnScrollListener(scrollListener);
    }

    private void initProgressBar(){
        progress = new ProgressDialog(this);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading news...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
    }

    private void fetchData() {
        viewModel.fetchAllEnergyData();
        viewModel.fetchHeadlineNews();
    }


}