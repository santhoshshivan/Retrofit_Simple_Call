package com.example.retrofit;

import android.util.Log;

import com.example.retrofit.Api.Api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.LoggingEventListener;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;

public class RetrofitClient {

    private static RetrofitClient mInstance= null;
//    private String Base_Url = "https://simplifiedcoding.net/demos/";
    private String Base_Url = "https://jsonplaceholder.typicode.com/";
    private Retrofit retrofit;
    private Api mApi;

//    OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
//            .callTimeout(1, TimeUnit.MINUTES)
//            .connectTimeout(30,TimeUnit.SECONDS)
//            .build();

    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.setPrettyPrinting().create();

    private RetrofitClient(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(getClient(loggingInterceptor)).baseUrl(Base_Url)
                .build();
    }

    private OkHttpClient getClient(HttpLoggingInterceptor interceptor){
        return new OkHttpClient().newBuilder()
                .callTimeout(1, TimeUnit.MINUTES)
                .addInterceptor(interceptor)
                .addInterceptor(chain -> {
                    Request request = chain.request();
                    Request newReq = request.newBuilder().build();
                    return chain.proceed(newReq);
                })
                .connectTimeout(30,TimeUnit.SECONDS)
                .build();
    }
    public  static synchronized RetrofitClient getInstance(){
        if (mInstance == null){
            mInstance = new RetrofitClient();

        }
        return mInstance;
    }
    public   Api getApi( ){
        mApi = retrofit.create(Api.class);
        return mApi;
    }
}
