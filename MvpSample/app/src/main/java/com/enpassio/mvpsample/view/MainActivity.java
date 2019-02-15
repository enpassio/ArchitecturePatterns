package com.enpassio.mvpsample.view;

import android.os.Bundle;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.enpassio.mvpsample.R;
import com.enpassio.mvpsample.data.model.Article;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText searchQueryEditText;
    private ImageButton searchButton;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView mainRecyclerView;
    private ContentLoadingProgressBar contentLoadingProgressBar;

    private NewsAdapter newsAdapter;
    private String usersSearchQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize views
        searchQueryEditText = findViewById(R.id.search_query_edit_text);
        searchButton = findViewById(R.id.search_button);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        mainRecyclerView = findViewById(R.id.recycler_view_news_content);
        contentLoadingProgressBar = findViewById(R.id.content_loading_progress_bar);

        //set adapter
        newsAdapter = new NewsAdapter(this, new ArrayList<Article>());
        mainRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainRecyclerView.setAdapter(newsAdapter);

        //set click lister=ner on search button and start search
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usersSearchQuery = searchQueryEditText.getText().toString();
                if (usersSearchQuery.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please input a query for news", Toast.LENGTH_SHORT).show();
                } else {
                    //on the presenter instance, send this search query to fetch data for
                    //mainActivityPresenter.onTopicSearched(usersSearchQuery); //where mainActivityPresenter is presenter instance
                }
            }
        });

        //setup refresh layout
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (usersSearchQuery == null || usersSearchQuery.isEmpty()) {
                    //if there is no search input made, search for top headlines from NewsApi.org
                    //mainActivityPresenter.onInitialListRequested("Top headlines"); //where mainActivityPresenter is presenter instance
                } else {
                    //mainActivityPresenter.onTopicSearched(usersSearchQuery); //where mainActivityPresenter is presenter instance
                }
            }
        });
    }
}
