package com.example.firstjava.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firstjava.R;
import com.example.firstjava.model.ArticlesItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.ArticleViewHolder> {

    List<ArticlesItem> articlesItems=new ArrayList<ArticlesItem>();

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article_list, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        holder.title.setText(articlesItems.get(position).getTitle());
        Picasso.get()
                .load(articlesItems.get(position).getUrlToImage())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return articlesItems.size();
    }

    public void updateArticle(List<ArticlesItem> articlesItems) {
        this.articlesItems = articlesItems;
        notifyDataSetChanged();
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView imageView;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.article_title);
            imageView = itemView.findViewById(R.id.article_img);
        }
    }
}
