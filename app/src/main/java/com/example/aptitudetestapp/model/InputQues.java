package com.example.aptitudetestapp.model;


public class InputQues {

    String ques = "";
    String right_option = "";
    int which_checked = 0;
    String op1 = "1";
    String op2 = "2";
    String op3 = "3";
    String op4 = "4";



    public InputQues(String ques,String op1, String op2, String op3, String op4) {
        this.ques = ques;
        this.op1  = op1;
        this.op2  = op2;
        this.op3  = op3;
        this.op4  = op4;
    }



    public String getOp1() {
        return op1;
    }

    public void setOp1(String op1) {
        this.op1 = op1;
    }

    public String getOp2() {
        return op2;
    }

    public void setOp2(String op2) {
        this.op2 = op2;
    }

    public String getOp3() {
        return op3;
    }

    public void setOp3(String op3) {
        this.op3 = op3;
    }

    public String getOp4() {
        return op4;
    }

    public void setOp4(String op4) {
        this.op4 = op4;
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