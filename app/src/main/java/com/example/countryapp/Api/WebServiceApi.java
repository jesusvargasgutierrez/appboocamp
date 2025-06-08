package com.example.countryapp.Api;
import com.example.countryapp.Request.ApiResonseRanking;
import com.example.countryapp.Request.ApiResponse;
import com.example.countryapp.data.model.Courts;
import com.example.countryapp.data.model.ScheduleRequest;
import com.example.countryapp.data.model.Schedules;
import com.example.countryapp.data.model.Subjects;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface WebServiceApi {
    @GET("listrecord")
    Call<List<Subjects>> getsubjects(
            @Query("_token") String _token,
            @Query("EndpointName") String EndpointName
    );

    @GET("listrecord")
    Call<List<Courts>> getcourts(
            @Query("_token") String _token,
            @Query("EndpointName") String EndpointName
    );

    @GET("getrecordwhere")
    Call<ApiResponse> getschedules(
            @Query("_token") String _token,
            @Query("EndpointName") String EndpointName,
            @Query("where") String where
    );

    @GET("getrecordwhere")
    Call<ApiResonseRanking> getrankings(
            @Query("_token") String _token,
            @Query("EndpointName") String EndpointName,
            @Query("where") String where
    );

    /*@POST("getrecordwhere")
    Call<ApiResponse> getschedules(@Body ScheduleRequest request);*/
}
