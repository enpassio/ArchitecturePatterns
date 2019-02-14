package com.enpassio.mvpsample.utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import com.enpassio.mvpsample.data.model.Article;

import java.util.ArrayList;

/**
 * Created by Abhishek Raj on 2/14/2019.
 */

public class MyDiffUtilCallback extends DiffUtil.Callback {

    ArrayList<Article> newList;
    ArrayList<Article> oldList;

    public MyDiffUtilCallback(ArrayList<Article> newList, ArrayList<Article> oldList) {
        this.newList = newList;
        this.oldList = oldList;
    }

    @Override
    public int getOldListSize() {
        return oldList != null ? oldList.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return newList != null ? newList.size() : 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return true;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        int result = newList.get(newItemPosition).compareTo(oldList.get(oldItemPosition));
        return result == 0;
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        Bundle diff = new Bundle();
        if (!(newItemPosition >= newList.size()) && !(oldItemPosition >= oldList.size())) {
            Article newArticle = newList.get(newItemPosition);
            Article oldArticle = oldList.get(oldItemPosition);
            if (!newArticle.getUrl().equals(oldArticle.getUrl())) {
                diff.putString("url", newArticle.getUrl());
            }
            if (diff.size() == 0) {
                return null;
            }
        }
        return diff;
    }
}