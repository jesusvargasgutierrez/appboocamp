package com.example.countryapp.ui.main;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.countryapp.Repositorio.GlobalRepository;
import com.example.countryapp.Request.ApiResponse;
import com.example.countryapp.data.model.ScheduleRequest;
import com.example.countryapp.data.model.Schedules;
import com.example.countryapp.data.model.Subjects;
import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

public class ClassReservationViewModel extends ViewModel {

    private GlobalRepository globalRepository;

    public ClassReservationViewModel(){
        globalRepository = new GlobalRepository();
    }

    public LiveData<List<Subjects>> getSubjects(String _token, String EndpointName, Context context){
        return globalRepository.getSubjects(_token, EndpointName, context);
    }

    public LiveData<List<Schedules>> getSchedules(String _token, String EndpointName, Integer where, Context context){
        List<Map<String, Object>> whereList = new ArrayList<>();
        Map<String, Object> condition = new HashMap<>();
        condition.put("id_type_schedule", where);
        whereList.add(condition);

        Gson gson = new Gson();

        String whereJson = gson.toJson(whereList);

        ScheduleRequest request = new ScheduleRequest(_token, EndpointName, whereList);

        return globalRepository.getSchedules(_token, EndpointName, whereJson, context);
    }
}