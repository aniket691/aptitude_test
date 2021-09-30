package com.example.aptitudetestapp.model;


public class InputQues {

    String ques = "";
    String right_option = "";
    int which_checked = 0;

    public InputQues(String ques) {
        this.ques = ques;
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public String getRight_option() {
        return right_option;
    }

    public void setRight_option(String right_option) {
        this.right_option = right_option;
    }

    public int getWhich_checked() {
        return which_checked;
    }

    public void setWhich_checked(int which_checked) {
        this.which_checked = which_checked;
    }

}