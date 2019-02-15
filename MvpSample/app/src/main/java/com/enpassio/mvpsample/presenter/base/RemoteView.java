package com.enpassio.mvpsample.presenter.base;

/**
 * Created by Abhishek Raj on 2/15/2019.
 */

public interface RemoteView {

    void showProgress();

    void hideProgress();

    void showUnauthorizedError();

    void showEmpty();

    void showError(String errorMessage);

    void showMessageLayout(boolean show);
}
