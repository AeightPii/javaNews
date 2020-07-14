package com.example.firstjava.api;

import com.example.firstjava.model.News;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class ApiClient {
    //public static final String BASE_URl = "http://newsapi.org/v2/";//static is equal to companion object
    public static Retrofit retrofit ;

    public static Retrofit getApiClient(String BASE_URl) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
