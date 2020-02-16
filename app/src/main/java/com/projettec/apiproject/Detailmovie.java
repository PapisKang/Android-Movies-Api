package com.projettec.apiproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Detailmovie extends AppCompatActivity {
    String id;

    private List<MovieList> movies;
    private MovieDetail movieDetail;

    private String api_key = "a81b1ae5592ff614fb9e04942951e6fe";
    private String language = "en-US";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailmovie);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        if (intent != null){
            if (intent.hasExtra("id")){
                id=intent.getStringExtra("id");
            }
        }

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create());


        Retrofit retrofit = builder.build();
        Tmbd data = retrofit.create(Tmbd.class);
        Call<MovieDetail> call = data.movieDetail(id,api_key, language);

        call.enqueue(new Callback<MovieDetail>() {
            @Override
            public void onResponse(Call<MovieDetail> call, Response<MovieDetail> response) {

                movieDetail=response.body();
                TextView movieId=findViewById(R.id.id);
                TextView releaseDate=findViewById(R.id.release_date);
                TextView vote=findViewById(R.id.vote);
                TextView genre=findViewById(R.id.genre);
                TextView movieName=findViewById(R.id.name);
                TextView movieOverview=findViewById(R.id.overview);
                TextView productions=findViewById(R.id.productions);
                TextView homepage=findViewById(R.id.homepage);
                TextView runtime=findViewById(R.id.runtime);
                ImageView movieImage=findViewById(R.id.img);
                movieId.setText(movieDetail.getId());
                releaseDate.setText(movieDetail.getRelease_date());
                runtime.setText(movieDetail.getRuntime()+" minutes");
                String genretext="";
                String htmlcompanieText="<br/><ul>";
                for(Production_companie p : movieDetail.getProduction_companies()){
                    htmlcompanieText+="<li>"+p.getName() +" ("+p.getOrigin_country()+")"+"</li>";
                }
                htmlcompanieText+="</ul>";

                for(Genre g : movieDetail.getGenres()){
                    genretext+=g.getName()+", ";
                }
                genretext=genretext.substring(0, genretext.length() - 2);

                String votetext="";
                votetext=movieDetail.getVote_average()+" ("+movieDetail.getVote_count()+")  ";

                //homepage.setMovementMethod(LinkMovementMethod.getInstance());
                homepage.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v)
                    {
                        v.getContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(movieDetail.getHomepage())));
                    }
                });

                genre.setText(genretext);
                movieName.setText(movieDetail.getTitle());
                vote.setText(" "+votetext);
                productions.setText(Html.fromHtml(htmlcompanieText));
                movieOverview.setText(movieDetail.getOverview());
                new DownloadImageTask(movieImage).execute("https://image.tmdb.org/t/p/original"+movieDetail.getBackdrop_path());




            }

            @Override
            public void onFailure(Call<MovieDetail> call, Throwable t) {
                Toast.makeText(Detailmovie.this, "Error...!!!", Toast.LENGTH_SHORT).show();
            }
        });



        Call<Movies> call2 = data.movies(api_key, language);

        call2.enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call2, Response<Movies> response) {

                Movies list =response.body();

                RecyclerView myRecyclerView = findViewById(R.id.moviesimilarRecyclerView);
                myRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL,false));
                myRecyclerView.setAdapter( new SimilarMovieAdapter(list));
                System.out.println(list);




            }

            @Override
            public void onFailure(Call<Movies> call2, Throwable t) {
                Toast.makeText(Detailmovie.this, "Error...!!!", Toast.LENGTH_SHORT).show();
            }
        });


        Call<CastList> call3 = data.movieCasting(id,api_key, language);

        call3.enqueue(new Callback<CastList>() {
            @Override
            public void onResponse(Call<CastList> call, Response<CastList> response) {

                CastList list =response.body();

                RecyclerView myRecyclerView = findViewById(R.id.castingRecyclerView);
                myRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL,false));
                myRecyclerView.setAdapter( new CastViewAdapter(list));



            }

            @Override
            public void onFailure(Call<CastList> call, Throwable t) {
                Toast.makeText(Detailmovie.this, "Error...!!!", Toast.LENGTH_SHORT).show();
            }
        });

        Call<VideoYoutubeList> call4 = data.youtubeVideo(id,api_key, language);

        call4.enqueue(new Callback<VideoYoutubeList>() {
            @Override
            public void onResponse(Call<VideoYoutubeList> call, Response<VideoYoutubeList> response) {

                VideoYoutubeList list =response.body();

                RecyclerView myRecyclerView = findViewById(R.id.videoRecyclerView);
                myRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL,false));
                myRecyclerView.setAdapter( new VideoYoutubeAdapter(list));



            }

            @Override
            public void onFailure(Call<VideoYoutubeList> call, Throwable t) {
                Toast.makeText(Detailmovie.this, "Error...!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
