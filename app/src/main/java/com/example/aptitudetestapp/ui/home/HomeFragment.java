package com.example.aptitudetestapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aptitudetestapp.ModelResponse.AnswerResponse;
import com.example.aptitudetestapp.ModelResponse.QuestionListResponse;
import com.example.aptitudetestapp.R;
import com.example.aptitudetestapp.RetrofitClient;
import com.example.aptitudetestapp.adapter.QuestionAdapter;

import com.example.aptitudetestapp.model.Ques;
import com.example.aptitudetestapp.model.Question;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private List<Question> questions_list;
    private List<Ques> questions_list_temp;
    private RecyclerView question_recycler_view;
    private QuestionAdapter questions_adapter;

    private Button sub_btn;
    private TextView test;
    private List<Integer> ans_input_list;
    int right_count = 0;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);

        //find object
        question_recycler_view = v.findViewById(R.id.recycler_view);


//        Toast.makeText(getActivity(), String.valueOf(questions_list_temp.size()), Toast.LENGTH_SHORT).show();
        sub_btn = v.findViewById(R.id.submit_button);
        test = v.findViewById(R.id.test);

        questions_list_temp = new ArrayList<>();

        Call<QuestionListResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .getQuesList();

        call.enqueue(new Callback<QuestionListResponse>() {
            @Override
            public void onResponse(Call<QuestionListResponse> call, Response<QuestionListResponse> response) {
                if (response.isSuccessful()) {
                    questions_list_temp = response.body().getQues();
                    Toast.makeText(getActivity(), String.valueOf(questions_list_temp.size()), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<QuestionListResponse> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        questions_list = new ArrayList<>();
        ans_input_list = new ArrayList<>();

        //create adapter and assign it to recycler view
        questions_adapter = new QuestionAdapter(getContext(), questions_list);
        question_recycler_view.setAdapter(questions_adapter);
        //necessary to set it other wise we cannot see items
        question_recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));

        //set listener
        sub_btn.setOnClickListener(this);

        return v;

    }

    private int getRightAns(List<Question> questions_list) {
        for (int i = 0; i < questions_list.size(); i++) {
            String ques = questions_list.get(i).getDec();
            Call<AnswerResponse> call = RetrofitClient
                    .getInstance()
                    .getApi()
                    .getAns(ques);
            call.enqueue(new Callback<AnswerResponse>() {
                @Override
                public void onResponse(Call<AnswerResponse> call, Response<AnswerResponse> response) {
                    AnswerResponse answerResponse = response.body();
                    if (response.isSuccessful()) {
                        Toast.makeText(getActivity(), answerResponse.getAns(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<AnswerResponse> call, Throwable t) {
                    Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        }
        return 0;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.submit_button) {
            for (int i = 0; i < questions_list.size(); i++) {
                ans_input_list.add(questions_list.get(i).getWhichChecked());
            }
            int c = getRightAns(questions_list);
            test.setText(String.valueOf(c));
        }
    }

}