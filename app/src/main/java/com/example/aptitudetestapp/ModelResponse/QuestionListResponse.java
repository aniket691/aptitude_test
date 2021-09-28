package com.example.aptitudetestapp.ModelResponse;

import com.example.aptitudetestapp.model.Ques;
import com.example.aptitudetestapp.model.Question;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;
import java.util.List;


public class QuestionListResponse {

    @SerializedName("q")
    private List<Ques> ques = null;
    @SerializedName("error")
    private String error;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Ques> getQues() {
        return ques;
    }

    public void setQues(List<Ques> ques) {
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

