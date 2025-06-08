package com.example.countryapp.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.countryapp.Adapters.RankingAdapter;
import com.example.countryapp.R;
import com.example.countryapp.data.model.Rankings;
import com.example.countryapp.data.model.Schedules;
import com.example.countryapp.data.model.Subjects;

import java.util.ArrayList;
import java.util.List;

public class RankingFragment extends Fragment {

    private RankingViewModel mViewModel;
    private RecyclerView recyclerViewUsers;
    private RankingAdapter rankingAdapter;
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
        //spnsubject = view.findViewById(R.id.selecttype);
        recyclerViewUsers = view.findViewById(R.id.recyclerranking);
        recyclerViewUsers.setLayoutManager(new LinearLayoutManager(requireContext()));
        rankingAdapter = new RankingAdapter(new ArrayList<>());
        recyclerViewUsers.setAdapter(rankingAdapter);
    }

    @Override
    public void onViewCreated(@NonNull View view,@Nullable Bundle savedInstanceState) {
        //Toast.makeText(requireContext(),"onViewCreated",Toast.LENGTH_SHORT).show();
        init(view);
        //actionscontrols();
        setupViewModel();
    }

    public void actionscontrols(){
        mViewModel = new ViewModelProvider(this).get(RankingViewModel.class);

        mViewModel.getSubjects("GGqO3U6lwOCdAinFWxJL0hhqeiBmKFkEWjxbRONE","subject", requireContext()).observe(getViewLifecycleOwner(), subjects -> {
            if (subjects != null && !subjects.isEmpty()) {
                Log.d("Subject1", "response ready");
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

    private void setupViewModel(){
        mViewModel = new RankingViewModel();
        mViewModel.getRankings().observe(getViewLifecycleOwner(), new Observer<List<Rankings>>() {
            @Override
            public void onChanged(List<Rankings> gitHubUsers) {
                Log.d("rankingchanged", gitHubUsers.size()+"");
                rankingAdapter.setData(gitHubUsers);
            }
        });

        mViewModel.getError().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.d("rankingslist", "ranking fail");
            }
        });

        mViewModel.getRankings("GGqO3U6lwOCdAinFWxJL0hhqeiBmKFkEWjxbRONE","rankings", 1,requireContext());
    }

}