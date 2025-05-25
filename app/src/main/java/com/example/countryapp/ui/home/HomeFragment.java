package com.example.countryapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.countryapp.ClassReservation;
import com.example.countryapp.MainActivity;
import com.example.countryapp.R;
import com.example.countryapp.databinding.FragmentHomeBinding;
import com.example.countryapp.ui.contact.ContactFragment;
import com.example.countryapp.ui.main.ClassReservationFragment;
import com.example.countryapp.ui.main.ReservationscourtsFragment;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    ImageButton btnhours,btnreservation,btnranking,btnmatchgames,btnevents,btncontact;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        init(view);
        actionscontrols();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view,@Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void actionscontrols(){
        btnhours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.homefragment, new ClassReservationFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        btnreservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.homefragment, new ClassReservationFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        btncontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.homefragment, new ContactFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    public void init(View view){
        btnhours = view.findViewById(R.id.btnhours);
        btnreservation = view.findViewById(R.id.btnreservations);
        btncontact = view.findViewById(R.id.btncontact);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}