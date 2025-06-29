package com.example.countryapp.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.countryapp.R;
import com.example.countryapp.Repositorio.GlobalRepository;
import com.example.countryapp.data.model.CourtReservation;
import com.example.countryapp.data.model.Courts;
import com.example.countryapp.data.model.ReservationClass;
import com.example.countryapp.data.model.Schedules;
import com.example.countryapp.data.model.Subjects;
import com.example.countryapp.reservationscourts;

import java.util.Calendar;

public class ReservationscourtsFragment extends Fragment {

    EditText etddate, edthour;
    Button btnfecha,btnsave;
    Spinner spncourts;
    private reservationscourtsViewModel mViewModel;


    public static ReservationscourtsFragment newInstance() {
        return new ReservationscourtsFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(reservationscourtsViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.reservations_courts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,@Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init(view);
        actionscontrols();
    }

    public void init(View view){
        etddate = view.findViewById(R.id.etddate);
        edthour = view.findViewById(R.id.edthour);
        spncourts = view.findViewById(R.id.selectcourts);
        btnsave = view.findViewById(R.id.btnsave);
    }

    public void actionscontrols(){
        Calendar ca = Calendar.getInstance();

        edthour.setOnClickListener(v -> {
            int hour = ca.get(Calendar.HOUR_OF_DAY);
            int minute = ca.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(
                    getContext(),
                    (view, selectedHour, selectedMinute) -> {
                        String amPm = selectedHour >= 12 ? "PM" : "AM";
                        int hourFormatted = selectedHour % 12;
                        if (hourFormatted == 0) hourFormatted = 12;

                        String time = String.format("%02d:%02d %s", hourFormatted, selectedMinute, amPm);
                        edthour.setText(time);
                    },
                    hour,
                    minute,
                    false
            );

            timePickerDialog.show();
        });

        etddate.setOnClickListener(v -> {
            int year = ca.get(Calendar.YEAR);
            int month = ca.get(Calendar.MONTH);
            int day = ca.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(requireContext(),
                    (view1, year1, month1, dayOfMonth) -> {
                        String dateText = dayOfMonth + "/" + (month1 + 1) + "/" + year1;
                        etddate.setText(dateText);
                    }, year, month, day);

            datePickerDialog.show();
        });

        mViewModel = new ViewModelProvider(this).get(reservationscourtsViewModel.class);

        mViewModel.getCourts("GGqO3U6lwOCdAinFWxJL0hhqeiBmKFkEWjxbRONE","court", requireContext()).observe(getViewLifecycleOwner(), courts -> {
            if (courts != null && !courts.isEmpty()) {
                Log.d("court", "response ready");
                ArrayAdapter<Courts> adapter = new ArrayAdapter<>(
                        requireContext(),
                        android.R.layout.simple_spinner_item,
                        courts
                );
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spncourts.setAdapter(adapter);
            } else {
                Log.d("Subject", "response ready");
            }
        });

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Courts court = (Courts) spncourts.getSelectedItem();

                CourtReservation courtreservation = new CourtReservation();
                courtreservation.EndpointName = "courtsreservation";
                courtreservation.id_court_reservation = 1;
                courtreservation.id_court = court.getid();
                courtreservation.court_name = court.getDescription();
                courtreservation.date_reservation = String.valueOf(etddate.getText());
                courtreservation.hour_reservation = String.valueOf(edthour.getText());
                courtreservation.id_user = 1;
                courtreservation.username = "username";

                mViewModel.InsertReservation(courtreservation);

                Toast.makeText(requireContext(),"Reservacion realizada con exito!",Toast.LENGTH_LONG).show();

            }
        });
    }
}