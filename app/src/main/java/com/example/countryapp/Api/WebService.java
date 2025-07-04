package com.example.countryapp.Api;
import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebService {
    private static final String BASE_URL = "https://d7d9-177-236-37-59.ngrok-free.app/ws/";
    private static WebService instance;

    private Retrofit retrofit;

    private WebService() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request originalRequest = chain.request();
                    Request requestWithUserAgent = originalRequest.newBuilder()
                            .header("User-Agent", "Mozilla/5.0 (Android)")
                            .build();
                    Log.d("CSRF", "Headers: " + requestWithUserAgent.headers().toString());
                    return chain.proceed(requestWithUserAgent);
                })
                .addInterceptor(httpLoggingInterceptor)
                .build();

        // Retrofit usando ese cliente
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized WebService getInstance() {
        if (instance == null) {
            instance = new WebService();
        }
        return instance;
    }

    public WebServiceApi createService() {
        return retrofit.create(WebServiceApi.class);
    }
}
