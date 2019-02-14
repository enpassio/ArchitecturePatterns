package com.enpassio.mvpsample.view;

import android.os.Bundle;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageButton;

import com.enpassio.mvpsample.R;

public class MainActivity extends AppCompatActivity {

    private EditText searchQueryEditText;
    private ImageButton searchButton;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView mainRecyclerView;
    private ContentLoadingProgressBar contentLoadingProgressBar;

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
    }
}
