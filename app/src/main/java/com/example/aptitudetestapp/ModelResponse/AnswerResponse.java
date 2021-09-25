package com.example.aptitudetestapp.ModelResponse;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;


public class AnswerResponse {

    @SerializedName("questions")
    private String ans;

    private String error;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public AnswerResponse(String ans, String error, Map<String, Object> additionalProperties) {
        this.ans = ans;
        this.error = error;
        this.additionalProperties = additionalProperties;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }


    public String getError() {
        return error;
    }


    public void setError(String error) {
        this.error = error;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
