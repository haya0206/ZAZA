package com.justhand.appjam.zaza;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class user_model implements Serializable{
    @SerializedName("name")
    private String name;

    @SerializedName("age")
    private String age;

    @SerializedName("bio")
    private String bio;

    @SerializedName("my_gender")
    private String my_gender;

    @SerializedName("taste_gender")
    private String taste_gender;

    public user_model(String name, String age, String bio, String my_gender, String taste_gender){
        this.name = name;
        this.age = age;
        this.bio = bio;
        this.my_gender = my_gender;
        this.taste_gender = taste_gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getMy_gender() {
        return my_gender;
    }

    public void setMy_gender(String my_gender) {
        this.my_gender = my_gender;
    }

    public String getTaste_gender() {
        return taste_gender;
    }

    public void setTaste_gender(String taste_gender) {
        this.taste_gender = taste_gender;
    }
}
