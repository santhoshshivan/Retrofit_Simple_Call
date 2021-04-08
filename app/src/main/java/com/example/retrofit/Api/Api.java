package com.example.retrofit.Api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

@GET("marvel")
Call<ResponseBody> getResponse();
}
