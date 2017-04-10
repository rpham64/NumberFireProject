package com.rpham64.android.numberfireproject.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.orhanobut.logger.Logger;
import com.rpham64.android.numberfireproject.network.BasketballDataResponse;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Rudolf on 4/9/2017.
 */

public class JsonUtils {

    public static final String TAG = JsonUtils.class.getName();

    public static String loadJSONFromAsset(Context context) {

        String json = null;

        try {

            InputStream is = context.getAssets().open("basketballData.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        Logger.json(json);

        return json;
    }

    public static BasketballDataResponse parseJSON(String json) {
        Gson gson = new GsonBuilder().create();
        BasketballDataResponse response = gson.fromJson(json, BasketballDataResponse.class);
        return response;
    }

    public static BasketballDataResponse getBasketballDataResponse(Context context) {
        String json = loadJSONFromAsset(context);
        return parseJSON(json);
    }
}
