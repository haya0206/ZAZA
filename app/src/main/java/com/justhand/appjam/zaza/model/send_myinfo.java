package com.justhand.appjam.zaza.model;

import android.location.Location;

import com.google.gson.annotations.SerializedName;

public class send_myinfo {
    @SerializedName("location")
    public Location location;

    @SerializedName("inter_gender")
    public String inter_gender;
}
