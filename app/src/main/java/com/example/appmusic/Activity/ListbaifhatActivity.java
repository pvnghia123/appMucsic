package com.example.appmusic.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.example.appmusic.Adapter.dsbaihatadapter;
import com.example.appmusic.Model.Album;
import com.example.appmusic.Model.Baihat;
import com.example.appmusic.Model.Playlist;
import com.example.appmusic.Model.Quangcao;
import com.example.appmusic.R;
import com.example.appmusic.Service.APIService;
import com.example.appmusic.Service.dataService;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListbaifhatActivity extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    RecyclerView recyclerViewdsbaihat;
    FloatingActionButton floatingActionButton;
    Quangcao quangcao;
    Playlist playlist;
    Album album;
    ArrayList<Baihat> mangbaihat;
    dsbaihatadapter dsbaihatadapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listbaifhat);

        anhxa();
        DataIntent();
        init();
        if(quangcao!=null&&!quangcao.getTenbaihat().equals("")){
            Log.d("aa", "chay qua day ");
            try {
                setValueInView(quangcao.getTenbaihat(),quangcao.getHinhanh());
                Log.d("aa", "chay qua day 1");
            } catch (Exception e) {
                e.printStackTrace();
            }
            getDataQuangCao(quangcao.getIdquancao());
        }
        if(playlist!=null&&!playlist.getTen().equals("")){
            try {
                setValueInView(playlist.getTen(),playlist.getHinh());

            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.d("aa", "onCreate: vao day ");
            getDataPlaylist(playlist.getIdplaylist());

        }
        if(album!=null&&!album.getTenalbum().equals("")){
            try {
                setValueInView(album.getTenalbum(),album.getHinhalbum());
            } catch (Exception e) {
                e.printStackTrace();
            }
            getDataAlbum(album.getIdalbum());
        }
    }

    private void getDataAlbum(String idalbum) {
        dataService dataService=APIService.getService();
        Call<List<Baihat >> callback=dataService.getdsbaihatAlbum(idalbum);
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                mangbaihat=(ArrayList<Baihat>) response.body();
                dsbaihatadapter =new dsbaihatadapter(ListbaifhatActivity.this,mangbaihat);
                recyclerViewdsbaihat.setLayoutManager(new LinearLayoutManager(ListbaifhatActivity.this));
                recyclerViewdsbaihat.setAdapter(dsbaihatadapter);
                evenClick();
            }
            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });

    }

    private void getDataPlaylist(String idplaylist) {
        Log.d("aa", "onCreate: vao day 1");
        dataService dataService=APIService.getService();
        Call<List<Baihat>> callback=dataService.getdsbaihatPlaylist(idplaylist);
        Log.d("aa", "onCreate: vao day 2 "+idplaylist);
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                mangbaihat= (ArrayList<Baihat>) response.body();
                Log.d("aa", "onCreate: vao day 3 ");
               // Log.d("aa", mangbaihat.get(0).getTenbaihat());

                dsbaihatadapter =new dsbaihatadapter(ListbaifhatActivity.this,mangbaihat);
                recyclerViewdsbaihat.setLayoutManager(new LinearLayoutManager(ListbaifhatActivity.this));
                recyclerViewdsbaihat.setAdapter(dsbaihatadapter);
                evenClick();
            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });
    }

    private void getDataQuangCao(String idquancao) {
        dataService dataService= APIService.getService();
        Call<List<Baihat>> callback=dataService.getdsbaihatQC(idquancao);
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                mangbaihat=(ArrayList<Baihat>) response.body();
                //Log.d("bb", mangbaihat.get(0).getTenbaihat());
                dsbaihatadapter=new dsbaihatadapter(ListbaifhatActivity.this,mangbaihat);
                recyclerViewdsbaihat.setLayoutManager(new LinearLayoutManager(ListbaifhatActivity.this));
                recyclerViewdsbaihat.setAdapter(dsbaihatadapter);
                evenClick();
            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });
    }

    private void setValueInView(String ten,String hinh) throws Exception {
        collapsingToolbarLayout.setTitle(ten);
        URL url=new URL(hinh);
        Bitmap bitmap=BitmapFactory.decodeStream(url.openConnection().getInputStream());
        BitmapDrawable bitmapDrawable=new BitmapDrawable(getResources(),bitmap);
        collapsingToolbarLayout.setBackground(bitmapDrawable);
       // Picasso.with(this).load(hinh).into(im)

    }

    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
      //  floatingActionButton.setEnabled(false);
}

    private void anhxa() {
        coordinatorLayout=findViewById(R.id.coordinatorlayout);
        collapsingToolbarLayout=findViewById(R.id.collapsinglayout);
        toolbar=findViewById(R.id.toolbarbaihat);
        recyclerViewdsbaihat=findViewById(R.id.recycldanhsachbaihat);
        floatingActionButton=findViewById(R.id.floatingbutton);


    }

    private void DataIntent() {
        Intent intent =getIntent();
        if (intent!=null){
            if(intent.hasExtra("banner")){
                quangcao= (Quangcao) intent.getSerializableExtra("banner");
               // Toast.makeText(this,quangcao.getTenbaihat(),Toast.LENGTH_LONG).show();
            }
            if(intent.hasExtra("itemPlaylist")){
                playlist= (Playlist) intent.getSerializableExtra("itemPlaylist");
            }
            if(intent.hasExtra("idalbum")){
                album= (Album) intent.getSerializableExtra("idalbum");
            }
        }


    }

    private void evenClick(){
        //floatingActionButton.setEnabled(true);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ListbaifhatActivity.this,PlayMusicActivity.class);
                intent.putExtra("list",mangbaihat);
                startActivity(intent);
            }
        });

    }
}
