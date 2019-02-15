package com.enpassio.mvpsample.presenter.base;

import android.support.annotation.NonNull;

/**
 * Created by Abhishek Raj on 2/15/2019.
 */

public abstract class BasePresenter<V> {

    public V mView;

    public final void attachView(@NonNull V view) {
        mView = view;
    }

    public final void detachView() {
        mView = null;
    }

    /**
     * Check if the view is attached.
     * This checking is only necessary when returning from an asynchronous call
     */
    protected final boolean isViewAttached() {
        return mView != null;
    }
}
