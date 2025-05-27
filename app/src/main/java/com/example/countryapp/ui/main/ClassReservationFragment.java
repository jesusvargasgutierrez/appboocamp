package com.example.countryapp.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.countryapp.R;

public class ClassReservationFragment extends Fragment {

    private ClassReservationViewModel mViewModel;

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

    @Override
    public void onViewCreated(@NonNull View view,@Nullable Bundle savedInstanceState) {
        //Toast.makeText(requireContext(),"onViewCreated",Toast.LENGTH_SHORT).show();
        mViewModel = new ViewModelProvider(this).get(ClassReservationViewModel.class);

        mViewModel.getSubjects("cSWH1FRdM6Azd7HLBpIo0oTgCewU9eTzX4ebRXtT","subject", requireContext());
    }

}