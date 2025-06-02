package com.example.countryapp.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.countryapp.R;
import com.example.countryapp.data.model.Schedules;
import com.example.countryapp.data.model.Subjects;

public class RankingFragment extends Fragment {

    private RankingViewModel mViewModel;
    Spinner spnsubject;

    public static RankingFragment newInstance() {
        return new RankingFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RankingViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ranking, container, false);
    }

    public void init(View view){
        spnsubject = view.findViewById(R.id.selecttype);
    }

    @Override
    public void onViewCreated(@NonNull View view,@Nullable Bundle savedInstanceState) {
        //Toast.makeText(requireContext(),"onViewCreated",Toast.LENGTH_SHORT).show();
        init(view);
        actionscontrols();
    }

    public void actionscontrols(){
        mViewModel = new ViewModelProvider(this).get(RankingViewModel.class);

        mViewModel.getSubjects("GGqO3U6lwOCdAinFWxJL0hhqeiBmKFkEWjxbRONE","subject", requireContext()).observe(getViewLifecycleOwner(), subjects -> {
            if (subjects != null && !subjects.isEmpty()) {
                Log.d("Subject", "response ready");
                ArrayAdapter<Subjects> adapter = new ArrayAdapter<>(
                        requireContext(),
                        android.R.layout.simple_spinner_item,
                        subjects
                );
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spnsubject.setAdapter(adapter);
            } else {
                Log.d("Subject", "response ready");
            }
        });
    }


}