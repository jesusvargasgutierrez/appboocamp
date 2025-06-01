package com.example.countryapp.Repositorio;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.countryapp.Api.WebService;
import com.example.countryapp.Api.WebServiceApi;
import com.example.countryapp.Request.ApiResponse;
import com.example.countryapp.data.model.Subjects;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
                if (response.isSuccessful() && response.body() != null) {
                    liveData.postValue(response.body());
                } else {
                    liveData.postValue(new ArrayList<>()); // vacío si falla
                }
            }
            @Override
            public void onFailure(Call<List<Subjects>> call, Throwable t) {
                liveData.postValue(new ArrayList<>()); // o manejar error
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
}
