package com.example.countryapp.data.model;

import com.google.gson.annotations.SerializedName;

public class Schedules {
    @SerializedName("description")
    public String description;

    @SerializedName("id")
    public Integer id;

    public Schedules(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getid(){
        return  id;
    }

    public void setid(Integer id){ this.id = id; }

    public String getDescription(){
        return  description;
    }

    @Override
    public String toString() {
        return description;
    }

    public void setDescription(String description){ this.description = description; }
}
