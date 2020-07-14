package com.example.firstjava;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.widget.TextView;

import com.example.firstjava.api.ApiService;
import com.example.firstjava.model.ArticlesItem;
import com.example.firstjava.model.News;

public class MainActivity extends AppCompatActivity {
    News news;
    String errorMessage;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //textView= findViewById(R.id.txt_text);
       // loadNews();
    }


}