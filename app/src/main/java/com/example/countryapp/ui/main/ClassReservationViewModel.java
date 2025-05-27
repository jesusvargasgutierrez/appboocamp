package com.example.countryapp.ui.main;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.example.countryapp.Repositorio.GlobalRepository;

public class ClassReservationViewModel extends ViewModel {

    private GlobalRepository globalRepository;

    public ClassReservationViewModel(){
        globalRepository = new GlobalRepository();
    }

    public void getSubjects(String _token, String EndpointName, Context context){
        globalRepository.getSubjects(_token, EndpointName, context);
    }
}