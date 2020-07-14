package com.example.firstjava.ViewModel;

import com.example.firstjava.api.ApiService;
import com.example.firstjava.model.News;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleViewModel extends ViewModel {
    MutableLiveData<News> result = new MutableLiveData<>();
    MutableLiveData<Boolean> loadError = new MutableLiveData<>();
    MutableLiveData<Boolean> loading = new MutableLiveData<>();

    public MutableLiveData<News> getResult() {
        return result;
    }

    public void setResult(MutableLiveData<News> result) {
        this.result = result;
    }

    public MutableLiveData<Boolean> getLoadError() {
        return loadError;
    }

    public void setLoadError(MutableLiveData<Boolean> loadError) {
        this.loadError = loadError;
    }

    public MutableLiveData<Boolean> getLoading() {
        return loading;
    }

    public void setLoading(MutableLiveData<Boolean> loading) {
        this.loading = loading;
    }
    public void loadResults(){
        loading.setValue(true);
        String apiKey = "3dab19420a6d4704859e2182c79b4418";
        Call<News> newsCall = ApiService.getNews(
                "technologies", apiKey
        );
        newsCall.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if (response.isSuccessful() && response.body() != null) {
                   loading.setValue(false);
                   result.setValue(response.body());

                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
               loading.setValue(false);
               loadError.setValue(true);
            }
        });
    }
}
