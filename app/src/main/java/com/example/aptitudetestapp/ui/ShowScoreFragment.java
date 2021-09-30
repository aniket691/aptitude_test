package com.example.aptitudetestapp.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aptitudetestapp.DataSaver.SharedPref;
import com.example.aptitudetestapp.R;

public class ShowScoreFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_show_score, container, false);
        TextView textView = v.findViewById(R.id.result);
        SharedPref sharedPref = SharedPref.getInstance(getContext());
        String res = sharedPref.getData("result");
        textView.setText(res);
        return v;
    }
}