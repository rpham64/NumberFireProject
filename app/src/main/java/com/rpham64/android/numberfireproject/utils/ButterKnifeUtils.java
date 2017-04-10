package com.rpham64.android.numberfireproject.utils;

import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by Rudolf on 4/9/2017.
 */

public class ButterKnifeUtils {

    public static final ButterKnife.Action<View> GONE = new ButterKnife.Action<View>() {
        @Override
        public void apply(View view, int index) {
            view.setVisibility(View.GONE);
        }
    };

    public static final ButterKnife.Action<View> VISIBLE = new ButterKnife.Action<View>() {
        @Override
        public void apply(View view, int index) {
            view.setVisibility(View.VISIBLE);
        }
    };
}
