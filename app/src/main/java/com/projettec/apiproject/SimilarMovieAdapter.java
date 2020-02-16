package com.projettec.apiproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SimilarMovieAdapter extends RecyclerView.Adapter<SimilarMovieHolder> {

    private Movies movies;


    public SimilarMovieAdapter(Movies movies) {
        this.movies = movies;
    }

    public Movies getMovies() {
        return movies;
    }

    @NonNull
    @Override
    public SimilarMovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemmovieposter, parent, false);
        return new SimilarMovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimilarMovieHolder holder, int position) {
        holder.display(movies.getResults().get(position));
    }

    @Override
    public int getItemCount() {
        return movies.getResults().size();
    }
}
