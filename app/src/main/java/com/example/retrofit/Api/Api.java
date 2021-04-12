package com.example.retrofit.Api;

import android.util.JsonReader;

import com.example.retrofit.model.Users;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {


    @GET("marvel")
    Call<ResponseBody> getResponse();

    @GET("marvel")
    Call<JsonArray> getRes();

    @GET("users")
    Call<List<Users>> getUsers();

    @GET("users/{id}")
    Call<Users> getUsersById(@Path("id") int id);
}
