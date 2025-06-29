package com.example.countryapp.ui.main;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.countryapp.Repositorio.GlobalRepository;
import com.example.countryapp.data.model.CourtReservation;
import com.example.countryapp.data.model.Courts;
import com.example.countryapp.data.model.ReservationClass;
import com.example.countryapp.data.model.Subjects;

import java.util.List;

public class reservationscourtsViewModel extends ViewModel {
    private GlobalRepository globalRepository;

    public reservationscourtsViewModel(){
        globalRepository = new GlobalRepository();
    }

    public LiveData<List<Courts>> getCourts(String _token, String EndpointName, Context context){
        return globalRepository.getCourts(_token, EndpointName, context);
    }

    public void InsertReservation(CourtReservation classreservation){
        globalRepository.insertreservationcourts(classreservation);
    }
}