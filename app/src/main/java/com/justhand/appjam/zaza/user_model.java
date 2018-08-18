package com.justhand.appjam.zaza;

import java.io.Serializable;

public class user_model implements Serializable {
    private String name;
    private String age;
    private String bio;
    private String my_gender;
    private String taste_gender;

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
