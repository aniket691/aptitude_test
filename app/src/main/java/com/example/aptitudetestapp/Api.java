package com.example.aptitudetestapp;

import com.example.aptitudetestapp.ModelResponse.MasterResponse;
import com.example.aptitudetestapp.model.ResponseQuote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("getques.php")
    Call<MasterResponse> getQuesList(
    );

    @GET("quotes.php")
    Call<List<ResponseQuote>> getQutes();
}
