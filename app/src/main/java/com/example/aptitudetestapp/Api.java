package com.example.aptitudetestapp;

import com.example.aptitudetestapp.ModelResponse.MasterResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("getques.php")
    Call<MasterResponse> getQuesList(
    );
}
