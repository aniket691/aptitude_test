package com.example.aptitudetestapp.model;

public class QandA {

    int id;
    String ques;
    String right_option;
    String topic;
    String op1;
    String op2;
    String op3;
    String op4;
    String question_type;

    public QandA(int id, String ques, String right_option, String topic, String op1, String op2, String op3, String op4,
                 String question_type) {
        this.id = id;
        this.ques = ques;
        this.right_option = right_option;
        this.topic = topic;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        this.op4 = op4;
        this.question_type = question_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
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

    public String getQuestion_type() {
        return question_type;
    }

    public void setQuestion_type(String question_type) {
        this.question_type = question_type;
    }
}
