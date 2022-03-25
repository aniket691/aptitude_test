package com.example.aptitudetestapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.aptitudetestapp.R;
import com.example.aptitudetestapp.model.QandA;

import java.util.ArrayList;
import java.util.List;

public class ShowQuestionFragment extends Fragment implements View.OnClickListener,
        RadioGroup.OnCheckedChangeListener {

    Button next;
    Button submit;
    TextView text_view;
    TextView text_view_score;
    RadioGroup radioGroup;
    List<QandA> QansAObj;
    String option = "";
    int count = 0;
    int i = 0;

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

        QansAObj.add(new QandA(1, "ques1", "10", "tcs", "10", "20", "30", "40",
                "tandw"));
        QansAObj.add(new QandA(2, "ques2", "20", "tcs", "10", "20", "30", "40",
                "tandw"));
        QansAObj.add(new QandA(3, "ques3", "30", "tcs", "10", "20", "30", "40",
                "tandw"));

        text_view.setText(QansAObj.get(0).getQues());

        RadioButton radioButton1 = (RadioButton) radioGroup.getChildAt(0);
        radioButton1.setText(QansAObj.get(0).getOp1());

        RadioButton radioButton2 = (RadioButton) radioGroup.getChildAt(1);
        radioButton2.setText(QansAObj.get(0).getOp2());

        RadioButton radioButton3 = (RadioButton) radioGroup.getChildAt(2);
        radioButton3.setText(QansAObj.get(0).getOp3());

        RadioButton radioButton4 = (RadioButton) radioGroup.getChildAt(3);
        radioButton4.setText(QansAObj.get(0).getOp4());


        next.setOnClickListener(this);
        submit.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(this);

        return v;
    }

    boolean areQuestionAvailable(int i, List<QandA> QansAObj) {
        return i < QansAObj.size();
    }

    boolean isOptionRight(String option, int i, List<QandA> QansAObj) {
        return option.equals(QansAObj.get(i).getRight_option());
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.next_button) {

            if (areQuestionAvailable(i, QansAObj) && isOptionRight(option, i, QansAObj)) {
                count++;
            }

            ++i;

            if (areQuestionAvailable(i, QansAObj)) {
                RadioButton radioButton1 = (RadioButton) radioGroup.getChildAt(0);
                radioButton1.setText(QansAObj.get(i).getOp1());

                RadioButton radioButton2 = (RadioButton) radioGroup.getChildAt(1);
                radioButton2.setText(QansAObj.get(i).getOp2());

                RadioButton radioButton3 = (RadioButton) radioGroup.getChildAt(2);
                radioButton3.setText(QansAObj.get(i).getOp3());

                RadioButton radioButton4 = (RadioButton) radioGroup.getChildAt(3);
                radioButton4.setText(QansAObj.get(i).getOp4());
            }

        }

        if (v.getId() == R.id.submit_button) {
            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_content_main);
            Bundle bundle = new Bundle();
            bundle.putString("score", String.valueOf(count));
            navController.navigate(R.id.showScoreFragment, bundle);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == -1) return;
        RadioButton radioButton = radioGroup.findViewById(i);
        option = radioButton.getText().toString();
    }
}