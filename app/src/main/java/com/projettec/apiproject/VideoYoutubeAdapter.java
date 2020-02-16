package com.projettec.apiproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VideoYoutubeAdapter extends RecyclerView.Adapter<VideoYoutubeHolder> {

    private VideoYoutubeList videos;


    public VideoYoutubeAdapter(VideoYoutubeList videos) {
        this.videos = videos;
    }

    public VideoYoutubeList getVideos() {
        return videos;
    }

    @NonNull
    @Override
    public VideoYoutubeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.videoyoutube, parent, false);
        return new VideoYoutubeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoYoutubeHolder holder, int position) {
        holder.display(videos.getResults().get(position));
    }

    @Override
    public int getItemCount() {
        return videos.getResults().size();
    }
}
