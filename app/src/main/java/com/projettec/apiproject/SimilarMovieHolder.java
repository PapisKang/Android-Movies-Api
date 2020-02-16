package com.projettec.apiproject;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SimilarMovieHolder extends RecyclerView.ViewHolder {

    private TextView movieId;
    private ImageView movieImage;

    public SimilarMovieHolder(@NonNull View itemView) {
        super(itemView);

        movieId=itemView.findViewById(R.id.idposter);
        movieImage=itemView.findViewById(R.id.poster);
        movieImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {

                Intent intent=new Intent(v.getContext(),Detailmovie.class);
                intent.putExtra("id",movieId.getText().toString());

                v.getContext().startActivity(intent);


                //itemView.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=Hxy8BZGQ5Jo")));


            }
        });
    }
    void display(MovieList movieList){

        movieId.setText(movieList.getId());
        new DownloadImageTask(movieImage).execute("https://image.tmdb.org/t/p/w500"+movieList.getPoster_path());
    }
}
