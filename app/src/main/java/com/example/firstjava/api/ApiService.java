package com.example.firstjava.api;

import com.example.firstjava.model.News;

import retrofit2.Call;

public class ApiService {
    public static final String BASE_URl = "http://newsapi.org/v2/";//static is equal to companion object
    // public static final String Login_Url="";
    public static  ApiInteface apiInterface = getApi();

    public static ApiInteface getApi() {

        apiInterface= ApiClient.getApiClient(BASE_URl)
                .create(ApiInteface.class);
        return apiInterface;
    }
    public static Call<News> getNews(String query,String apikey){
        return apiInterface.getNews(query,apikey);
    }
//    public static ApiInteface getLoginApi(){
//        return ApiClient.getApiClient(Login_Url)
//                .create(ApiInteface.class);
//    }
}
