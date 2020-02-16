package com.projettec.apiproject;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CastViewHolder extends RecyclerView.ViewHolder {

    private TextView castName;
    private ImageView profilImage;

    public CastViewHolder(@NonNull View itemView) {
        super(itemView);

        castName=itemView.findViewById(R.id.name);
        profilImage=itemView.findViewById(R.id.profil);

    }
    void display(Cast cast){
        if (cast.getProfile_path()!=null){
            castName.setText(cast.getName());
            new DownloadImageTask(profilImage).execute("https://image.tmdb.org/t/p/original"+cast.getProfile_path());
        }

    }
}
