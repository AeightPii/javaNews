package com.example.firstjava.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.firstjava.R;
import com.example.firstjava.ViewModel.ArticleViewModel;
import com.example.firstjava.model.News;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class ArticleListFragment extends Fragment {

        RecyclerView recyclerView;
        ProgressBar progressBar;
        TextView textView;
        private ArticleViewModel articleViewModel;
        ArticleListAdapter articleListAdapter = new ArticleListAdapter();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root=inflater.inflate(R.layout.fragment_article_list, container, false);
        //View a=root.findViewById(R.id.loadingView);
        recyclerView = root.findViewById(R.id.recAtricle);
        articleViewModel = new ViewModelProvider(this)
                .get(ArticleViewModel.class);
        articleViewModel.loadResults();
        articleViewModel.getResult().observe(
                getViewLifecycleOwner(),



             news ->{
                    articleListAdapter.updateArticle(
                            news.getArticles()

                    );
                 articleListAdapter.notifyDataSetChanged();
             }
        );
        setupRecyclerView();
        return root;
    }
    private void setupRecyclerView(){
        recyclerView.setAdapter(articleListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
       // progressBar.setVisibility(View.VISIBLE);
    }


}