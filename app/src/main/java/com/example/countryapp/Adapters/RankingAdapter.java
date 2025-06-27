package com.example.countryapp.Adapters;
import android.util.Log;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_rankings, parent, false);
        return new RankingAdapter.RepositoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RankingAdapter.RepositoryViewHolder holder, int position) {
        Rankings item = rankings.get(position);

        holder.txtPosition.setText("Posicion ranking: "+String.valueOf(item.getid()));
        holder.txtName.setText("Nombre: "+item.getplayername());
        holder.txtSubject.setText("Puntaje: "+String.valueOf(item.getid()));
    }

    @Override
    public int getItemCount() {
        return rankings.size();
    }

    public void setData(List<Rankings> rankings){
        this.rankings = rankings;
        Log.d("setdatarankingchanged", rankings.size()+"");
        notifyDataSetChanged();
    }

    public class RepositoryViewHolder extends RecyclerView.ViewHolder{
        TextView txtName, txtSubject, txtPosition;

        private RepositoryViewHolder(@NonNull View itemView){
            super(itemView);
            txtPosition = itemView.findViewById(R.id.txtPosition);
            txtName = itemView.findViewById(R.id.txtName);
            txtSubject = itemView.findViewById(R.id.txtSubject);
        }
    }
}
