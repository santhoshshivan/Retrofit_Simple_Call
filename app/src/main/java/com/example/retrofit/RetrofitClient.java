package com.example.retrofit;

import com.example.retrofit.Api.Api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient mInstance= null;
    private String Base_Url = "https://simplifiedcoding.net/demos/";
    private Retrofit retrofit;
    private Api mApi;

    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().callTimeout(1, TimeUnit.MINUTES).connectTimeout(30,TimeUnit.SECONDS).build();
    private RetrofitClient(){

        retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).baseUrl(Base_Url).build();
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
