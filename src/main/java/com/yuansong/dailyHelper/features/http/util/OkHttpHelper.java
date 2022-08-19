package com.yuansong.dailyHelper.features.http.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OkHttpHelper {

    private OkHttpHelper(){}

    private static OkHttpClient getOkHttpClient() {
        return OkHttpUtil.getOkHttpClient();
    }

    public static String doGet2(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = getOkHttpClient().newCall(request).execute();
        return response.body().string();
    }

    public static String doGet(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        return getOkHttpClient().newCall(request).execute().body().string();
    }

}
