package com.example.appmusic.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.appmusic.Adapter.dsPlaylistAdapter;
import com.example.appmusic.Model.Playlist;
import com.example.appmusic.R;
import com.example.appmusic.Service.APIService;
import com.example.appmusic.Service.dataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class dsPlayList2Activity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    dsPlaylistAdapter dsPlaylistAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds_play_list2);
        anhxa();
        init();
        getData();
    }

    private void getData() {
        dataService dataService= APIService.getService();
        Call<List<Playlist>> callback=dataService.getdsPlayList();
        callback.enqueue(new Callback<List<Playlist>>() {
            @Override
            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                ArrayList<Playlist> arrayList= (ArrayList<Playlist>) response.body();
                dsPlaylistAdapter=new dsPlaylistAdapter(dsPlayList2Activity.this,arrayList);
                recyclerView.setLayoutManager(new GridLayoutManager(dsPlayList2Activity.this,2));
                recyclerView.setAdapter(dsPlaylistAdapter);
            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {

            }
        });
    }

    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("PlayLists");
        toolbar.setTitleTextColor(Color.BLUE);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void anhxa() {
        toolbar=findViewById(R.id.toolbardsPlaylist);
        recyclerView=findViewById(R.id.dsPlaylist);
    }
}
