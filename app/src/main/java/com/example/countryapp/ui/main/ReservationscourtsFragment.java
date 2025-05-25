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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.countryapp.R;
import com.example.countryapp.reservationscourts;

import java.util.Calendar;

public class ReservationscourtsFragment extends Fragment {

    EditText etddate, edthour;
    Button btnfecha;
    private reservationscourtsViewModel mViewModel;

    public static ReservationscourtsFragment newInstance() {
        return new ReservationscourtsFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(reservationscourtsViewModel.class);
        // TODO: Use the ViewModel
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
    }
}