package com.projettec.apiproject;


import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import android.widget.TextView;

import java.util.NoSuchElementException;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieViewHolder extends RecyclerView.ViewHolder {


    private TextView movieId;
    private TextView movieName;
    private TextView movieOverview;
    private ImageView movieImage;


    public MovieViewHolder(@NonNull final View itemView) {
        super(itemView);

        movieId=itemView.findViewById(R.id.id);
        movieName=itemView.findViewById(R.id.name);
        movieOverview=itemView.findViewById(R.id.overview);
        movieImage=itemView.findViewById(R.id.img);
        movieImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {

                    Intent intent=new Intent(itemView.getContext(),Detailmovie.class);
                    intent.putExtra("id",movieId.getText().toString());

                    itemView.getContext().startActivity(intent);


                //itemView.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=Hxy8BZGQ5Jo")));


            }
        });
    }

    void display(MovieList movieList){
       movieName.setText(movieList.getTitle());
       movieId.setText(movieList.getId());
       movieOverview.setText(movieList.getOverview());

       new DownloadImageTask(movieImage).execute("https://image.tmdb.org/t/p/original"+movieList.getBackdrop_path());

    }



}
