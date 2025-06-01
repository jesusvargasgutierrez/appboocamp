package com.example.countryapp.ui.main;

import androidx.lifecycle.LiveData;
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
import android.widget.Toast;

import com.example.countryapp.R;
import com.example.countryapp.data.model.Subjects;

import java.util.List;

public class ClassReservationFragment extends Fragment {

    private ClassReservationViewModel mViewModel;
    Spinner spnsubject;

    public static ClassReservationFragment newInstance() {
        return new ClassReservationFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ClassReservationViewModel.class);

        Toast.makeText(requireContext(),"onCreate",Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        //Toast.makeText(requireContext(),"onCreateView",Toast.LENGTH_SHORT).show();

        return inflater.inflate(R.layout.fragment_class_reservation, container, false);
    }

    public void init(View view){
        spnsubject = view.findViewById(R.id.selecttype);
    }

    @Override
    public void onViewCreated(@NonNull View view,@Nullable Bundle savedInstanceState) {
        //Toast.makeText(requireContext(),"onViewCreated",Toast.LENGTH_SHORT).show();
        init(view);
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
        //mViewModel.getSubjects("GGqO3U6lwOCdAinFWxJL0hhqeiBmKFkEWjxbRONE","subject", requireContext());
    }

}