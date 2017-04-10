package com.rpham64.android.numberfireproject.utils;

/**
 * Created by Rudolf on 4/9/2017.
 */

public interface IPresenter<T> {
    void attachView(T mvpView);

    void detachView();

    void onResume();
    void onPause();
    void onDestroy();

    T getView();
}
