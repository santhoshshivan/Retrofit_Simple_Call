package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.retrofit.Api.Api;

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

        Call<ResponseBody> call = api.getResponse();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(!response.isSuccessful()){
                    Log.d(TAG, "onResponse: response Code: "+response.code());
                    Log.d(TAG, "onResponse: responce Message: "+response.message());
                }

                try {
                    Log.d(TAG, "onResponse: response : "+response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d(TAG, "onFailure: Throwable: "+t);
            }
        });

    }
}