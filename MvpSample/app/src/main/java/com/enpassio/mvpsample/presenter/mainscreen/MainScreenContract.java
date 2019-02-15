package com.enpassio.mvpsample.presenter.mainscreen;

import com.enpassio.mvpsample.data.model.Article;
import com.enpassio.mvpsample.presenter.base.RemoteView;

import java.util.List;

/**
 * Created by Abhishek Raj on 2/15/2019.
 */

public interface MainScreenContract {

    interface ViewActions {
        void onInitialListRequested();

        void onTopicSearched(String searchQuery);
    }

    interface RecyclerView extends RemoteView {

        void showArticles(List<Article> characterList);

        void showSearchedTopicArticles(List<Article> characterList);
    }
}