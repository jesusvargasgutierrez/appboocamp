package com.example.countryapp.Api;
import com.example.countryapp.Request.ApiResponse;
import com.example.countryapp.data.model.Subjects;

import java.util.List;

import javax.security.auth.Subject;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WebServiceApi {
    @GET("listrecord")
    Call<List<Subjects>> getsubjects(
            @Query("_token") String _token,
            @Query("EndpointName") String EndpointName
    );
}
