package com.example.countryapp.data.model;

public class CourtReservation {
    public Integer id_court_reservation;
    public Integer id_court;
    public String court_name;
    public String date_reservation;
    public String hour_reservation;
    public Integer id_user;
    public String username;

    public CourtReservation(Integer id_court_reservation, Integer id_court, String court_name, String date_reservation, String hour_reservation, Integer id_user, String username) {
        this.id_court_reservation = id_court_reservation;
        this.id_court = id_court;
        this.court_name = court_name;
        this.date_reservation = date_reservation;
        this.hour_reservation = hour_reservation;
        this.id_user = id_user;
        this.username = username;
    }

    public Integer getId_court_reservation() {
        return id_court_reservation;
    }

    public void setId_court_reservation(Integer id_court_reservation) {
        this.id_court_reservation = id_court_reservation;
    }

    public Integer getId_court() {
        return id_court;
    }

    public void setId_court(Integer id_court) {
        this.id_court = id_court;
    }

    public String getCourt_name() {
        return court_name;
    }

    public void setCourt_name(String court_name) {
        this.court_name = court_name;
    }

    public String getDate_reservation() {
        return date_reservation;
    }

    public void setDate_reservation(String date_reservation) {
        this.date_reservation = date_reservation;
    }

    public String getHour_reservation() {
        return hour_reservation;
    }

    public void setHour_reservation(String hour_reservation) {
        this.hour_reservation = hour_reservation;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
