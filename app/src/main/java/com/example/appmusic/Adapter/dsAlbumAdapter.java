package com.example.appmusic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmusic.Activity.ListbaifhatActivity;
import com.example.appmusic.Model.Album;
import com.example.appmusic.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class dsAlbumAdapter extends RecyclerView.Adapter<dsAlbumAdapter.ViewHolder> {
    Context context;
    ArrayList<Album> arrayList;

    public dsAlbumAdapter(Context context, ArrayList<Album> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }
    @NonNull
    @Override
    public dsAlbumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.dong_dsalbum,parent,false);
        return new dsAlbumAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull dsAlbumAdapter.ViewHolder holder, int position) {
        Album album=arrayList.get(position);
        Picasso.with(context).load(album.getHinhalbum()).into(holder.imageView);
        holder.txttenabum.setText(album.getTenalbum());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView txttenabum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imgdsAbum);
            txttenabum=itemView.findViewById(R.id.tvdsAlbum);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, ListbaifhatActivity.class);
                    intent.putExtra("idalbum",arrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });



        }
    }
}
