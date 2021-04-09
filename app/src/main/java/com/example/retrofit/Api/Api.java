package com.example.retrofit.Api;

import android.util.JsonReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {


    @GET("marvel")
    Call<ResponseBody> getResponse();

    @GET("marvel")
    Call<JsonArray> getRes();
}
