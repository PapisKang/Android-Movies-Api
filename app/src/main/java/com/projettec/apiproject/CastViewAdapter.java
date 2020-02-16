package com.projettec.apiproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CastViewAdapter extends RecyclerView.Adapter<CastViewHolder> {

    private CastList casts;

    public CastViewAdapter(CastList casts) {
        this.casts = casts;
    }

    public CastList getCasts() {
        return casts;
    }

    public void setCasts(CastList casts) {
        this.casts = casts;
    }

    @NonNull
    @Override
    public CastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemcast, parent, false);
        return new CastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CastViewHolder holder, int position) {
        holder.display(casts.getCast().get(position));
    }

    @Override
    public int getItemCount() {
        return casts.getCast().size();
    }
}
