package com.example.countryapp.data.model;

public class Subjects {
    public String description;
    public Integer id;

    public Subjects(){ }

    public Integer getid(){
        return  id;
    }

    public void setid(Integer id){ this.id = id; }

    public String getDescription(){
        return  description;
    }

    public void setDescription(String description){ this.description = description; }
}
