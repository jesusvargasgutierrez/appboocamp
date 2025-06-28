package com.example.countryapp.data.model;

public class ReservationClass {
    public String EndpointName;
    public Integer id_reservation;
    public Integer id_classtype;
    public String class_type;
    public Integer id_schedulemat;
    public String schedule_mat;
    public Integer id_schedulevesp;
    public String schedule_vesp;
    public Integer id_user;
    public String username;

    /*public ReservationClass(Integer id_reservation, Integer id_classtype, String classtype, Integer id_schedulemat, String schedulemat, Integer id_schedulevesp, String schedulevesp, Integer id_user, String username) {
        this.id_reservation = id_reservation;
        this.id_classtype = id_classtype;
        this.classtype = classtype;
        this.id_schedulemat = id_schedulemat;
        this.schedulemat = schedulemat;
        this.id_schedulevesp = id_schedulevesp;
        this.schedulevesp = schedulevesp;
        this.id_user = id_user;
        this.username = username;
    }*/

    public String getEndpointName() {
        return EndpointName;
    }

    public void setEndpointName(String endpointName) {
        EndpointName = endpointName;
    }

    public Integer getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(Integer id_reservation) {
        this.id_reservation = id_reservation;
    }

    public Integer getId_classtype() {
        return id_classtype;
    }

    public void setId_classtype(Integer id_classtype) {
        this.id_classtype = id_classtype;
    }

    public String getClasstype() {
        return class_type;
    }

    public void setClasstype(String classtype) {
        this.class_type = classtype;
    }

    public Integer getId_schedulemat() {
        return id_schedulemat;
    }

    public void setId_schedulemat(Integer id_schedulemat) {
        this.id_schedulemat = id_schedulemat;
    }

    public String getSchedulemat() {
        return schedule_mat;
    }

    public void setSchedulemat(String schedulemat) {
        this.schedule_mat = schedulemat;
    }

    public Integer getId_schedulevesp() {
        return id_schedulevesp;
    }

    public void setId_schedulevesp(Integer id_schedulevesp) {
        this.id_schedulevesp = id_schedulevesp;
    }

    public String getSchedulevesp() {
        return schedule_vesp;
    }

    public void setSchedulevesp(String schedulevesp) {
        this.schedule_vesp = schedulevesp;
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
