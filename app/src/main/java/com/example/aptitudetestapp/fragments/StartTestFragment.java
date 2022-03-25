package com.example.aptitudetestapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.aptitudetestapp.R;

public class StartTestFragment extends Fragment implements View.OnClickListener {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_start_test, container, false);
        Button b = v.findViewById(R.id.btnStart);
        b.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnStart) {
            NavController navController = Navigation.findNavController(v);
            navController.navigate(R.id.action_startTestFragment_to_nav_home);
        }
    }
}