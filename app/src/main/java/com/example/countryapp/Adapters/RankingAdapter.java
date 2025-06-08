package com.example.countryapp.Adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countryapp.R;
import com.example.countryapp.data.model.Rankings;

import java.util.List;

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.RepositoryViewHolder>{
    private List<Rankings> rankings;

    public RankingAdapter(List<Rankings> rankings){
        this.rankings = rankings;
    }

    @NonNull
    @Override
    public RankingAdapter.RepositoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_ranking, parent, false);
        return new RankingAdapter.RepositoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RankingAdapter.RepositoryViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return rankings.size();
    }

    public void setData(List<Rankings> rankings){
        this.rankings = rankings;
        notifyDataSetChanged();
    }

    public class RepositoryViewHolder extends RecyclerView.ViewHolder{
        TextView txtName, txtSubject, txtPosition;

        private RepositoryViewHolder(@NonNull View itemView){
            super(itemView);
            /*txtPosition = itemView.findViewById(R.id.txtStars);
            txtName = itemView.findViewById(R.id.txtName);
            txtSubject = itemView.findViewById(R.id.txtLenguaje);*/
        }
    }
}
