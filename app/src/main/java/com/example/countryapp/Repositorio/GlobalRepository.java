package com.example.countryapp.Repositorio;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.countryapp.Api.WebService;
import com.example.countryapp.Api.WebServiceApi;
import com.example.countryapp.Request.ApiResonseRanking;
import com.example.countryapp.Request.ApiResponse;
import com.example.countryapp.data.model.CourtReservation;
import com.example.countryapp.data.model.Courts;
import com.example.countryapp.data.model.Rankings;
import com.example.countryapp.data.model.ReservationClass;
import com.example.countryapp.data.model.ScheduleRequest;
import com.example.countryapp.data.model.Schedules;
import com.example.countryapp.data.model.Subjects;
import com.google.android.gms.common.api.Api;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.security.auth.Subject;

import kotlin.jvm.internal.markers.KMutableIterable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GlobalRepository {

    private WebServiceApi webServiceApi;

    public GlobalRepository(){
        webServiceApi = WebService.getInstance().createService();
    }

    public LiveData<List<Subjects>> getSubjects(String _token, String EndpointName, Context context){
        //Call<List<Subjects>> call = webServiceApi.getsubjects(_token,EndpointName);

        MutableLiveData<List<Subjects>> liveData = new MutableLiveData<>();

        webServiceApi.getsubjects(_token, EndpointName).enqueue(new Callback<List<Subjects>>() {
            @Override
            public void onResponse(Call<List<Subjects>> call, Response<List<Subjects>> response) {
                Log.d("API subject", "Código: " + response.code());
                Log.d("API subject", "Cuerpo: " + response.errorBody());
                if (response.isSuccessful() && response.body() != null) {
                    liveData.postValue(response.body());
                } else {
                    liveData.postValue(new ArrayList<>());
                }
            }
            @Override
            public void onFailure(Call<List<Subjects>> call, Throwable t) {
                Log.d("API subjectfail", "Cuerpo: " + t.getMessage());
                liveData.postValue(new ArrayList<>());
            }
        });

        return liveData;

        /*call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if(response.isSuccessful() && response.body() != null && response.body().isSuccess()){

                }else{
                    Toast.makeText(context, "Error al consultar las clases", Toast.LENGTH_LONG);
                }
            }
            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Toast.makeText(context, "Error al consultar las clases: "+ t.getMessage(), Toast.LENGTH_LONG);
            }
        });*/
    }

    public LiveData<List<Courts>> getCourts(String _token, String EndpointName, Context context){
        MutableLiveData<List<Courts>> liveData = new MutableLiveData<>();

        webServiceApi.getcourts(_token, EndpointName).enqueue(new Callback<List<Courts>>() {
            @Override
            public void onResponse(Call<List<Courts>> call, Response<List<Courts>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    liveData.postValue(response.body());
                } else {
                    liveData.postValue(new ArrayList<>());
                }
            }
            @Override
            public void onFailure(Call<List<Courts>> call, Throwable t) {
                liveData.postValue(new ArrayList<>());
            }
        });

        return liveData;
    }

    public LiveData<List<Schedules>> getSchedules(String _token, String EndpointName, String where, Context context) {
        MutableLiveData<List<Schedules>> liveData = new MutableLiveData<>();

        webServiceApi.getschedules( _token, EndpointName, where).enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                Log.d("API schedule", "Código: " + response.code());
                Log.d("API schedule", "Cuerpo: " + response.errorBody());

                if (response.isSuccessful()) {
                    Log.d("API schedule", "recibido");
                    liveData.postValue(response.body().getInformation());
                } else {
                    Log.d("API schedule", "no Recibidos");
                    try {
                        String errorMsg = response.errorBody() != null ? response.errorBody().string() : "Cuerpo vacío";
                        Log.e("API_ERROR", "Código: " + response.code() + "\nError: " + errorMsg);
                    } catch (IOException e) {
                        Log.e("API_ERROR", "Error al leer el errorBody: " + e.getMessage());
                    }
                    liveData.postValue(Collections.emptyList());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                liveData.postValue(Collections.emptyList());
            }
        });

        return liveData;
    }

    public LiveData<List<Rankings>> getRankings(String _token, String EndpointName, String where, Context context) {
        MutableLiveData<List<Rankings>> liveData = new MutableLiveData<>();

        webServiceApi.getrankings( _token, EndpointName, where).enqueue(new Callback<ApiResonseRanking>() {
            @Override
            public void onResponse(Call<ApiResonseRanking> call, Response<ApiResonseRanking> response) {
                Log.d("API ranking", "Código: " + response.code());
                Log.d("API ranking", "Cuerpo: " + response.errorBody());
                if (response.isSuccessful()) {
                    liveData.postValue(response.body().getInformation());
                    Log.d("API ranking", "Cuerpo ok: " + response.body().getInformation());
                } else {
                    try {
                        String errorMsg = response.errorBody() != null ? response.errorBody().string() : "Cuerpo vacío";
                        Log.e("API_ERROR", "Código: " + response.code() + "\nError: " + errorMsg);
                    } catch (IOException e) {
                        Log.e("API_ERROR", "Error al leer el errorBody: " + e.getMessage());
                    }
                    liveData.postValue(Collections.emptyList());
                }
            }

            @Override
            public void onFailure(Call<ApiResonseRanking> call, Throwable t) {
                liveData.postValue(Collections.emptyList());
            }
        });

        return liveData;
    }

    public void insertreservation(ReservationClass classreservation) {
        webServiceApi.insertrecordclass(classreservation).enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                //Log.d("API insert", "Código: " + response.code());
                //Log.d("API insert", "Cuerpo: " + response.errorBody());
                if (response.isSuccessful()) {
                    //Log.d("API insert", "Cuerpo ok: " + response.body().getInformation());
                } else {
                    try {
                        String errorMsg = response.errorBody() != null ? response.errorBody().string() : "Cuerpo vacío";
                        //Log.e("API_ERROR", "Código: " + response.code() + "\nError: " + errorMsg);
                    } catch (IOException e) {
                        //Log.e("API_ERROR", "Error al leer el errorBody: " + e.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {

            }
        });
    }

    public void insertreservationcourts(CourtReservation courtreservation) {
        webServiceApi.insrdreservationcourts(courtreservation).enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                //Log.d("API insert", "Código: " + response.code());
                //Log.d("API insert", "Cuerpo: " + response.errorBody());
                if (response.isSuccessful()) {
                    //Log.d("API insert", "Cuerpo ok: " + response.body().getInformation());
                } else {
                    try {
                        String errorMsg = response.errorBody() != null ? response.errorBody().string() : "Cuerpo vacío";
                        //Log.e("API_ERROR", "Código: " + response.code() + "\nError: " + errorMsg);
                    } catch (IOException e) {
                        //Log.e("API_ERROR", "Error al leer el errorBody: " + e.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {

            }
        });
    }
}
