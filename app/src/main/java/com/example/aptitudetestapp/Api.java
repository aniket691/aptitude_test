package com.example.aptitudetestapp;

import com.example.aptitudetestapp.ModelResponse.AnswerResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("ans.php")
    Call<AnswerResponse> getAns(
            @Field("q") String ans
    );
}
