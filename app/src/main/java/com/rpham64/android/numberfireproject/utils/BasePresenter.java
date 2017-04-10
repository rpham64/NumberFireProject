package com.rpham64.android.numberfireproject.utils;

/**
 * Created by Rudolf on 4/9/2017.
 */

public class BasePresenter<T> implements IPresenter<T> {

    private T mView;

    public BasePresenter() {

    }

    @Override
    public void attachView(T mvpView) {
        mView = mvpView;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {
        mView = null;
    }

    @Override
    public T getView() {
        return mView;
    }
}