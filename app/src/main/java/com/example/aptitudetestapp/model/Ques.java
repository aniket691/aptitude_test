package com.example.aptitudetestapp.model;


import java.util.HashMap;
import java.util.Map;

public class Ques {

    private String ques;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}