package com.example.aptitudetestapp.ModelResponse;

import com.example.aptitudetestapp.model.ResponseComingQues;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;
import java.util.List;


public class MasterResponse {


    @SerializedName("error")
    private String error;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    @SerializedName("q")
    private List<ResponseComingQues> ques = null;

    public List<ResponseComingQues> getQues() {
        return ques;
    }

    public void setQues(List<ResponseComingQues> ques) {
        this.ques = ques;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}

