package com.example.countryapp.data.model;

public class Rankings {
    public String player_name;
    public Integer id, position;

    public Rankings(Integer id, String player_name, Integer position) {
        this.id = id;
        this.player_name = player_name;
        this.position = position;
    }

    public Integer getid(){
        return  id;
    }

    public Integer getposition(){
        return  position;
    }

    public String getplayername(){
        return  player_name;
    }

    @Override
    public String toString() {
        return player_name;
    }
}
