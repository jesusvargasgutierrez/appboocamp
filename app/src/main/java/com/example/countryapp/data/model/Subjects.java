package com.example.countryapp.data.model;

public class Subjects {
    public String description;
    public Integer id;

    public Subjects(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId(){
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
