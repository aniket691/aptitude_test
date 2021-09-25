package com.example.aptitudetestapp.model;


import java.util.List;

public class Question {

    String dec;
    String ans;
    int whichChecked;

    public int getWhichChecked() {
        return whichChecked;
    }

    public void setWhichChecked(int whichChecked) {
        this.whichChecked = whichChecked;
    }

    public Question(String dec, String ans) {
        this.dec = dec;
        this.ans = ans;
    }

    public String getDec() {
        return dec;
    }

    public void setDec(String dec) {
        this.dec = dec;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

}