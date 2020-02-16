package com.projettec.apiproject;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements  SearchView.OnQueryTextListener {

    SearchView editsearch;
    private List<MovieList> movies;
    Movies list;
    private String api_key = "a81b1ae5592ff614fb9e04942951e6fe";
    private String language = "en-US";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Movies");
        //movies= new ArrayList<>();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create());


        Retrofit retrofit = builder.build();
        Tmbd data = retrofit.create(Tmbd.class);
        Call<Movies> call = data.movies(api_key, language);




        call.enqueue(new Callback<Movies>() {
            @Override
            public void onResponse(Call<Movies> call, Response<Movies> response) {

                 list =response.body();


                RecyclerView myRecyclerView = findViewById(R.id.moviesListRecyclerView);
                myRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false));
                myRecyclerView.setAdapter( new MovieAdapter(list));



            }



            @Override
            public void onFailure(Call<Movies> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error...!!!", Toast.LENGTH_SHORT).show();
            }
        });



        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) findViewById(R.id.simpleSearchView);
        editsearch.setOnQueryTextListener(this);





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        //getMenuInflater().inflate(R.menu.search, menu);


        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {



        newText = newText.toLowerCase(Locale.getDefault());

        Movies mv =new Movies(new ArrayList<MovieList>());


            for (MovieList wp : list.getResults()) {
                if (wp.getTitle().toLowerCase(Locale.getDefault()).contains(newText)) {
                    mv.getResults().add(wp);
                }
            }



        RecyclerView myRecyclerView = findViewById(R.id.moviesListRecyclerView);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false));
        myRecyclerView.setAdapter( new MovieAdapter(mv));
        return false;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.action_about :
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setCancelable(true);
                builder.setTitle("About");
                builder.setMessage("Application réalisée par:\n ABDOUL AZIZ SY\n PAPE NGAGNE NDIAYE");


                builder.show();
               return true;

                default: return super.onOptionsItemSelected(item);

        }

    }
}
