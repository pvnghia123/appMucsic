package com.example.appmusic.Activity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.appmusic.Adapter.dsAlbumAdapter;
import com.example.appmusic.Model.Album;
import com.example.appmusic.Model.Playlist;
import com.example.appmusic.R;
import com.example.appmusic.Service.APIService;
import com.example.appmusic.Service.dataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class dsalbumActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    Toolbar toolbar;
    dsAlbumAdapter dsAlbumAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsalbum);

        anhxa();
        init();
        getData();

    }
    private void anhxa() {
        toolbar=findViewById(R.id.toolbardsalbum);
        recyclerView=findViewById(R.id.dsalbum);
    }
    private void getData() {
        dataService dataService= APIService.getService();
        Call<List<Album>> callback=dataService. getdsAlbum();
        Log.d("aa", "chay toi day");
        callback.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                ArrayList<Album> arrayList= (ArrayList<Album>) response.body();
                Log.d("aa", arrayList.get(0).getTenalbum());

                dsAlbumAdapter=new dsAlbumAdapter(dsalbumActivity.this,arrayList);
                recyclerView.setLayoutManager(new GridLayoutManager(dsalbumActivity.this,2));
                recyclerView.setAdapter(dsAlbumAdapter);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }
    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Lists Album");
        toolbar.setTitleTextColor(Color.BLUE);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
