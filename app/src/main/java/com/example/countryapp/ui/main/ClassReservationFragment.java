package com.example.countryapp.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.countryapp.R;
import com.example.countryapp.data.model.Schedules;
import com.example.countryapp.data.model.Subjects;

import java.util.List;

public class ClassReservationFragment extends Fragment {

    private ClassReservationViewModel mViewModel;
    Spinner spnsubject, spnschedule, selectheven;
    private Button btnsave;

    public static ClassReservationFragment newInstance() {
        return new ClassReservationFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ClassReservationViewModel.class);

        //Toast.makeText(requireContext(),"onCreate",Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        //Toast.makeText(requireContext(),"onCreateView",Toast.LENGTH_SHORT).show();

        return inflater.inflate(R.layout.fragment_class_reservation, container, false);
    }

    public void init(View view){
        spnsubject = view.findViewById(R.id.selecttype);
        spnschedule = view.findViewById(R.id.selectmorning);
        selectheven = view.findViewById(R.id.selectheven);
        btnsave = view.findViewById(R.id.btnsave);
    }

    @Override
    public void onViewCreated(@NonNull View view,@Nullable Bundle savedInstanceState) {
        //Toast.makeText(requireContext(),"onViewCreated",Toast.LENGTH_SHORT).show();
        init(view);
        actionscontrols();
    }

    public void actionscontrols(){
        mViewModel = new ViewModelProvider(this).get(ClassReservationViewModel.class);

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

        mViewModel.getSchedules("WehcDH5nlWmhUK1xQn2opiIiV0QuYYFnGcJRwKgM","schedule",1, requireContext()).observe(getViewLifecycleOwner(), schedules -> {
            if (schedules != null && !schedules.isEmpty()) {
                Log.d("schedules", "response ready");
                ArrayAdapter<Schedules> adapter = new ArrayAdapter<>(
                        requireContext(),
                        android.R.layout.simple_spinner_item,
                        schedules
                );
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spnschedule.setAdapter(adapter);
            } else {
                Log.d("schedules", "response ready");
            }
        });

        mViewModel.getSchedules("GGqO3U6lwOCdAinFWxJL0hhqeiBmKFkEWjxbRONE","schedule",2, requireContext()).observe(getViewLifecycleOwner(), schedules -> {
            if (schedules != null && !schedules.isEmpty()) {
                Log.d("Subject", "response ready");
                ArrayAdapter<Schedules> adapter = new ArrayAdapter<>(
                        requireContext(),
                        android.R.layout.simple_spinner_item,
                        schedules
                );
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                selectheven.setAdapter(adapter);
            } else {
                Log.d("Subject", "response ready");
            }
        });

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Subjects classtype = (Subjects) spnsubject.getSelectedItem();
                Schedules scheduleopcmat = (Schedules) spnschedule.getSelectedItem();
                Schedules scheduleopcvesp = (Schedules) spnschedule.getSelectedItem();

                String msg = "Valor seleccionado para clase: "+String.valueOf(classtype.getId())
                              + "\n" + " horario matutino: "+String.valueOf(scheduleopcmat.getid())
                             + "\n" + " horario vespertino: "+String.valueOf(scheduleopcvesp.getid());

                Toast.makeText(requireContext(),msg,Toast.LENGTH_LONG).show();

            }
        });
    }

}