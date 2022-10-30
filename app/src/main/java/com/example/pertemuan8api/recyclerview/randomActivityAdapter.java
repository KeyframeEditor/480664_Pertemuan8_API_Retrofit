package com.example.pertemuan8api.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pertemuan8api.R;

import java.util.ArrayList;

public class randomActivityAdapter extends RecyclerView.Adapter<randomActivityAdapter.ViewHolder> {

    private final ArrayList<ActivityData> values;
    private final LayoutInflater inflater;

    public randomActivityAdapter(Context context, ArrayList<ActivityData> values) {
        this.values = values;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public randomActivityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_activity, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull randomActivityAdapter.ViewHolder holder, int position) {
        final ActivityData activityData = values.get(position);
        holder.txtActivityName.setText(String.valueOf(activityData.getActivityName()));
        holder.txtType.setText(String.valueOf(activityData.getActivityType()));
        holder.txtDifficulty.setText(String.valueOf(activityData.getActivityDifficulty()));
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtActivityName;
        TextView txtType;
        TextView txtDifficulty;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtActivityName = itemView.findViewById(R.id.txt_Activity);
            txtType = itemView.findViewById(R.id.txt_type);
            txtDifficulty = itemView.findViewById(R.id.txt_difficulty);
        }
    }
}
