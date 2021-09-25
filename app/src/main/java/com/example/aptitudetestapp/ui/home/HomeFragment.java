package com.example.aptitudetestapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aptitudetestapp.R;
import com.example.aptitudetestapp.adapter.QuestionAdapter;

import com.example.aptitudetestapp.model.Question;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private List<Question> questions_list;
    private RecyclerView question_recycler_view;
    private QuestionAdapter questions_adapter;

    private Button sub_btn;
    private TextView test;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);

        //find object
        question_recycler_view = v.findViewById(R.id.recycler_view);
        sub_btn = v.findViewById(R.id.submit_button);
        test = v.findViewById(R.id.test);

        questions_list = new ArrayList<>();
        questions_list.add(new Question("questions", "A"));
        questions_list.add(new Question("question2", "B"));

        //create adapter and assign it to recycler view
        questions_adapter = new QuestionAdapter(getContext(), questions_list);
        question_recycler_view.setAdapter(questions_adapter);
        //necessary to set it other wise we cannot see items
        question_recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));

        //set listener
        sub_btn.setOnClickListener(this);

        return v;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.submit_button) {
            for (int i = 0; i < questions_list.size(); i++) {
                test.setText(String.valueOf(questions_list.get(i).getWhichChecked()) + " ");
            }
        }
    }
}