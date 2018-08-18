package com.justhand.appjam.zaza.model;

import android.location.Location;

import com.google.gson.annotations.SerializedName;

public class near_user {
    //이름, 성별, 나이, 관심성별, 위치

    @SerializedName("name")
    public String name;

    @SerializedName("gender")
    public String gender;

    @SerializedName("age")
    public int age;

    @SerializedName("inter_gender")
    public String inter_gender;

    @SerializedName("location")
    public Location location;


}
