package com.example.zahfit_trainer.pages;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zahfit_trainer.R;


public class MainFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        Initialize view
        View view = inflater.inflate(R.layout.fragment_main, container, false);

//        assign value
        TextView textView = view.findViewById(R.id.textViewMain);

////        get title
//        String sTitle = getArguments().getString("title");
//
//        textView.setText(sTitle);

        return view;
//        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}