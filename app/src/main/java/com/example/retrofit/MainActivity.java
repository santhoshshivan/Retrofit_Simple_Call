package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;

import com.example.retrofit.Api.Api;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RetrofitClient retrofitClient;
    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        retrofitClient = RetrofitClient.getInstance();
        api = retrofitClient.getApi();
        getData();

//        Call<ResponseBody> call = api.getResponse();
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                if(!response.isSuccessful()){
//                    Log.d(TAG, "onResponse: response Code: "+response.code());
//                    Log.d(TAG, "onResponse: responce Message: "+response.message());
//                }
//
//                try {
//                    Log.d(TAG, "onResponse: response : "+response.body().string());
//                    getData();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Log.d(TAG, "onFailure: Throwable: "+t);
//            }
//        });


    }
    public  void getData(){
        Call<JsonArray> call1 = api.getRes();
        call1.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                if (!response.isSuccessful()){
                    Log.d(TAG, "onResponse: recCode: "+response.code());
                }
                Log.d(TAG, "onResponse: response Reader: "+response.body());
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                t.printStackTrace();

            }
        });

    }
}