package com.example.aptitudetestapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.aptitudetestapp.R;
import com.example.aptitudetestapp.model.QandA;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener,
        RadioGroup.OnCheckedChangeListener {

    Button next;
    Button submit;
    TextView text_view;
    TextView text_view_score;
    RadioGroup radioGroup;
    List<QandA> QansAObj;
    int count = 0;
    int next_ques_getter = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        next = v.findViewById(R.id.next_button);
        submit = v.findViewById(R.id.submit_button);
        radioGroup = v.findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(this);
        text_view = v.findViewById(R.id.text_view);
        text_view_score = v.findViewById(R.id.score_temp);
        QansAObj = new ArrayList<>();

        QansAObj.add(new QandA(1, "We are driving along a highway at a constant speed of 55 miles per hour (mph). You observe a car one half mile behind you. The car is moving fast and zooms past you exactly one minute later. How fast is this car traveling (mph) if its speed is constant?",
                "85", "tcs",
                "85", "88", "72", "71",
                "tsd"));

        QansAObj.add(new QandA(2, "A certain sum of money is sufficient to pay either George’s wages for 15 days or mark’s wages for 10 days, for how long will it suffice it both George and mark work together?",
                "6", "tcs",
                "9", "8", "6", "5",
                "taw"));

        next.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {

        if (next_ques_getter < QansAObj.size()) {
            radioGroup.clearCheck();
            //fetch ques

            text_view.setText(QansAObj.get(next_ques_getter).getQues());
            //fetch options
            RadioButton radioButton1 = (RadioButton) radioGroup.getChildAt(0);
            radioButton1.setText(QansAObj.get(next_ques_getter).getOp1());

            RadioButton radioButton2 = (RadioButton) radioGroup.getChildAt(1);
            radioButton2.setText(QansAObj.get(next_ques_getter).getOp2());

            RadioButton radioButton3 = (RadioButton) radioGroup.getChildAt(2);
            radioButton3.setText(QansAObj.get(next_ques_getter).getOp3());

            RadioButton radioButton4 = (RadioButton) radioGroup.getChildAt(3);
            radioButton4.setText(QansAObj.get(next_ques_getter).getOp4());

            next_ques_getter++;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == -1) return;
        RadioButton radioButton = radioGroup.findViewById(i);
        String name = radioButton.getText().toString();
        Toast.makeText(getActivity(), name, Toast.LENGTH_SHORT).show();
    }
}