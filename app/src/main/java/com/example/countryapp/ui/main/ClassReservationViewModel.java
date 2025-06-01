package com.example.countryapp.ui.main;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.countryapp.Repositorio.GlobalRepository;
import com.example.countryapp.Request.ApiResponse;
import com.example.countryapp.data.model.Subjects;

import java.util.List;

public class ClassReservationViewModel extends ViewModel {

    private GlobalRepository globalRepository;

    public ClassReservationViewModel(){
        globalRepository = new GlobalRepository();
    }

    public LiveData<List<Subjects>> getSubjects(String _token, String EndpointName, Context context){
        return globalRepository.getSubjects(_token, EndpointName, context);
    }
}