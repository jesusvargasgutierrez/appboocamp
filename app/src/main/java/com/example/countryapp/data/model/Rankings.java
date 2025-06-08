package com.example.countryapp.data.model;

public class Rankings {
    public String description;
    public Integer id, position;

    public Rankings(Integer id, String description, Integer position) {
        this.id = id;
        this.description = description;
        this.position = position;
    }

    public Integer getid(){
        return  id;
    }

    public void setid(Integer id){ this.id = id; }

    public Integer getposition(){
        return  position;
    }

    public void setposition(Integer position){ this.position = position; }

    public String getdescription(){
        return  description;
    }

    @Override
    public String toString() {
        return description;
    }

    public void setdescription(String description){ this.description = description; }
}
