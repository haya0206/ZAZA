package com.justhand.appjam.zaza.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APImanager  {
    public static String URL = "serverURL/";
    private static APImanager apimanager;

    private Retrofit retrofit;
    private API api;

    public APImanager getInstance(){
        apimanager = new APImanager();

        return apimanager;
    }

    public API requestServer(){
        retrofit = new Retrofit.Builder().
                baseUrl(URL).
                addConverterFactory(GsonConverterFactory.create()).
                build();

        return retrofit.create(API.class);
    }
}
