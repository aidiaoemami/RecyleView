package com.aidiaoemami.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.aidiaoemami.recycleview.adapter.MovieAdapter;
import com.aidiaoemami.recycleview.model.MovieModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MovieAdapter adapter;
    RecyclerView rv;
    List<MovieModel> listMovie = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
    }
    public void initRecyclerView(){
        adapter = new MovieAdapter(this);
        rv = findViewById(R.id.rv_movie);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);
        rv.setNestedScrollingEnabled(false);
        rv.hasFixedSize();
        adapter.setOnItemClickListener(new MovieAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent i = new Intent(MainActivity.this, DetailMovieActivity.class);
                i.putExtra("name",listMovie.get(position).getName());
                i.putExtra("rating",listMovie.get(position).getRating());
                i.putExtra("jadwal",listMovie.get(position).getJadwal());
                i.putExtra("deskripsi",listMovie.get(position).getDesCription());
                startActivity(i);
            }
        });
        loadItem();
    }
    public void loadItem(){
        listMovie.add(new MovieModel("Nama : Avengers", "Rating : 4.5", "Jadwal : 17.00 - 21.00", "Description"));
        listMovie.add(new MovieModel("Nama : Avengers", "Rating : 4.5", "Jadwal : 17.00 - 21.00", "Description"));
        listMovie.add(new MovieModel("Nama : Avengers", "Rating : 4.5", "Jadwal : 17.00 - 21.00", "Description"));
        listMovie.add(new MovieModel("Nama : Avengers", "Rating : 4.5", "Jadwal : 17.00 - 21.00", "Description"));
        listMovie.add(new MovieModel("Nama : Avengers", "Rating : 4.5", "Jadwal : 17.00 - 21.00", "Description"));
        listMovie.add(new MovieModel("Nama : Avengers", "Rating : 4.5", "Jadwal : 17.00 - 21.00", "Description"));
        listMovie.add(new MovieModel("Nama : Avengers", "Rating : 4.5", "Jadwal : 17.00 - 21.00", "Description"));
        listMovie.add(new MovieModel("Nama : Avengers", "Rating : 4.5", "Jadwal : 17.00 - 21.00", "Description"));
        adapter.addAll(listMovie);
    }
}
