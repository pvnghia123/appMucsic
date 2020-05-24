package com.example.appmusic.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmusic.Activity.dsalbumActivity;
import com.example.appmusic.Adapter.AlbumAdapter;
import com.example.appmusic.Model.Album;
import com.example.appmusic.R;
import com.example.appmusic.Service.APIService;
import com.example.appmusic.Service.dataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_album_moi extends Fragment {
    View view;
    RecyclerView recyclerView;
    TextView textViewAlbum;
    AlbumAdapter albumAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_album_moi,container,false);
        recyclerView=view.findViewById(R.id.recyclerAlbum);
        textViewAlbum=view.findViewById(R.id.tvxemthemAblum);
        textViewAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), dsalbumActivity.class);
                startActivity(intent);
            }
        });
        getdata();
        return view;
    }

    private void getdata() {
        dataService dataService= APIService.getService();
        Call<List<Album>> callback=dataService.getAlbum();

        callback.enqueue(new Callback<List<Album>>() {

            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                ArrayList<Album> arrayListAlbum= (ArrayList<Album>) response.body();
                albumAdapter=new AlbumAdapter(getActivity(),arrayListAlbum);
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(albumAdapter);
            }
            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                Log.d("aaa", "ko char ve cai gi");
            }
        });
    }

}

