package com.justhand.appjam.zaza.API;

import com.justhand.appjam.zaza.model.send_myinfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface API{
    @POST("/getNear/")
    Call<List<send_myinfo>> singup(@Body send_myinfo send_myinfo);

}