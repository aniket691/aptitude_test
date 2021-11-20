package com.example.aptitudetestapp.ui.home;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aptitudetestapp.DataSaver.SharedPref;
import com.example.aptitudetestapp.ModelResponse.MasterResponse;
import com.example.aptitudetestapp.R;
import com.example.aptitudetestapp.RetrofitClient;
import com.example.aptitudetestapp.adapter.QuestionAdapter;

import com.example.aptitudetestapp.model.InputQues;
import com.example.aptitudetestapp.model.ResponseComingQues;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private List<InputQues> display_ques_list;
    private List<Integer> client_ans_list;
    private List<ResponseComingQues> server_ans_list;

    private RecyclerView question_recycler_view;
    private QuestionAdapter questions_adapter;

    private Button sub_btn;
    private TextView test;
    private TextView textView;

    int right_count = 0;
    int i = 0;
    String s1 = "";
    String s2 = "";

    class Down extends AsyncTask<Void, Void, List<ResponseComingQues>> {

        @Override
        protected List<ResponseComingQues> doInBackground(Void... voids) {

            Call<MasterResponse> call = RetrofitClient.getInstance()
                    .getApi()
                    .getQuesList();

            call.enqueue(new Callback<MasterResponse>() {
                @Override
                public void onResponse(Call<MasterResponse> call, Response<MasterResponse> response) {
                    if (response.isSuccessful()) {

                        server_ans_list = response.body().getQues();

                        for (int i = 0; i < server_ans_list.size(); i++) {
                            display_ques_list.add(new InputQues(server_ans_list.get(i).getQues(), server_ans_list.get(i).getOp1(),
                                    server_ans_list.get(i).getOp2(), server_ans_list.get(i).getOp3(), server_ans_list.get(i).getOp4()));
                        }
                        questions_adapter = new QuestionAdapter(getContext(), display_ques_list);
                        question_recycler_view.setAdapter(questions_adapter);
                        //necessary to set it other wise we cannot see items
                        question_recycler_view.setLayoutManager(new LinearLayoutManager(getContext()));

                    }
                }

                @Override
                public void onFailure(Call<MasterResponse> call, Throwable t) {
                    Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            return server_ans_list;
        }

        @Override
        protected void onPostExecute(List<ResponseComingQues> ml) {
            //Toast.makeText(getActivity(), String.valueOf(ml.size()), Toast.LENGTH_SHORT).show();
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        //find object
        question_recycler_view = v.findViewById(R.id.recycler_view);
        sub_btn = v.findViewById(R.id.submit_button);
        //test = v.findViewById(R.id.test);
        textView = v.findViewById(R.id.textView);

        new CountDownTimer(1200000, 1000) {
            public void onTick(long millisUntilFinished) {
                // Used for formatting digit to be in 2 digits only
                NumberFormat f = new DecimalFormat("00");
                long hour = (millisUntilFinished / 3600000) % 24;
                long min = (millisUntilFinished / 60000) % 60;
                long sec = (millisUntilFinished / 1000) % 60;
                textView.setText(f.format(hour) + ":" + f.format(min) + ":" + f.format(sec));
            }

            // When the task is over it will print 00:00:00 there
            public void onFinish() {
                textView.setText("00:00:00");
                calculateResult(v);
            }
        }.start();

        display_ques_list = new ArrayList<>();
        client_ans_list = new ArrayList<>();
        server_ans_list = new ArrayList<>();
        Down d = new Down();
        d.execute();

        //set listener
        sub_btn.setOnClickListener(this);
        return v;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void calculateResult(View v) {

        for (int i = 0; i < display_ques_list.size(); i++) {
            client_ans_list.add(display_ques_list.get(i).getWhich_checked());
            s1 += String.valueOf(display_ques_list.get(i).getWhich_checked());
        }

        for (int i = 0; i < server_ans_list.size(); i++) {
            s2 += String.valueOf(server_ans_list.get(i).getRight_option());
        }


        char arr1[] = s1.toCharArray();
        char arr2[] = s2.toCharArray();
        for (int i = 0; i < s1.length(); i++) {
            {
                if (arr1[i] == arr2[i])
                    right_count++;
            }
        }


        SharedPref sharedPref = SharedPref.getInstance(getContext());
        sharedPref.saveData("result", String.valueOf(right_count));
        NavController navController = Navigation.findNavController(v);
        navController.navigate(R.id.action_nav_home_to_showScoreFragment);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.submit_button) {
            calculateResult(v);
        }
    }

}