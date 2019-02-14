package com.enpassio.mvpsample.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.enpassio.mvpsample.R;
import com.enpassio.mvpsample.data.model.Article;

import java.util.ArrayList;

/**
 * Created by Abhishek Raj on 2/14/2019.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private static ArrayList<Article> listOfArticle;
    /* Store the context for easy access */
    private Context mContext;

    public NewsAdapter(Context context, ArrayList<Article> articleLisr) {
        listOfArticle = articleLisr;
        mContext = context;
    }

    private Context getContext() {
        return mContext;
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        /* Inflate the custom layout */
        View newsView = inflater.inflate(R.layout.news_list_item, parent, false);

        /* Return a new holder instance */
        return new ViewHolder(context, newsView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder viewHolder, int position) {
        /* Get the data model based on position */
        Article currentArticle = listOfArticle.get(position);

    }

    @Override
    public int getItemCount() {
        return listOfArticle.size();
    }

    public void setArticleData(ArrayList<Article> articleList) {
        listOfArticle = articleList;
    }

    /*
     Provide a direct reference to each of the views within a data item
     Used to cache the views within the item layout for fast access
     */
    static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView articlePosterImageView;
        private final TextView articlePublishDateTextView;
        private final TextView articleAuthorTextView;
        private final TextView articleTitleTextView;

        private ViewHolder(Context context, View itemView) {
            super(itemView);
            articlePosterImageView = itemView.findViewById(R.id.image_view_article_poster);
            articlePublishDateTextView = itemView.findViewById(R.id.text_view_published_date);
            articleAuthorTextView = itemView.findViewById(R.id.text_view_author);
            articleTitleTextView = itemView.findViewById(R.id.text_view_article_title);
        }
    }
}
