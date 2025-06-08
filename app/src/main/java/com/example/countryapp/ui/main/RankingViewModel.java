package com.example.countryapp.ui.main;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.countryapp.Repositorio.GlobalRepository;
import com.example.countryapp.data.model.Rankings;
import com.example.countryapp.data.model.Subjects;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankingViewModel extends ViewModel {
    private GlobalRepository globalRepository;
    private final MutableLiveData<List<Rankings>> mutableLiveData;

    private MutableLiveData<String> errorLiveData;

    public LiveData<List<Rankings>> getRankings(){
        return mutableLiveData;
    }

    public LiveData<String> getError(){
        return errorLiveData;
    }

    public RankingViewModel(){
        globalRepository = new GlobalRepository();
        mutableLiveData = new MutableLiveData<>();
        errorLiveData = new MutableLiveData<>();
    }

    public LiveData<List<Subjects>> getSubjects(String _token, String EndpointName, Context context){
        return globalRepository.getSubjects(_token, EndpointName, context);
    }

    public LiveData<List<Rankings>> getRankings(String _token, String EndpointName, Integer where, Context context){
        List<Map<String, Object>> whereList = new ArrayList<>();
        Map<String, Object> condition = new HashMap<>();
        condition.put("id_type", where);
        whereList.add(condition);

        Gson gson = new Gson();

        String whereJson = gson.toJson(whereList);

        return globalRepository.getRankings(_token, EndpointName, whereJson, context);
    }
}