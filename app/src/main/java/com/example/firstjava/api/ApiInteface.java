package com.example.firstjava.api;

import com.example.firstjava.model.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface ApiInteface {
    @GET("everything")
    Call<News> getNews(
            @Query("q") String keyword,
            @Query("apiKey") String apiKey
    );
}
