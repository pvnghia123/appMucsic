package com.example.appmusic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmusic.Activity.ListbaifhatActivity;
import com.example.appmusic.Model.Album;
import com.example.appmusic.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.viewHolder> {

    Context context;
    ArrayList<Album> arrayListalbum;

    public AlbumAdapter(Context context, ArrayList<Album> arrayListalbum) {
        this.context = context;
        this.arrayListalbum = arrayListalbum;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.dong_album,parent,false);

        return (new viewHolder(view));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Album album=arrayListalbum.get(position);
        holder.tvnamebaihat.setText(album.getTenalbum());
        holder.tvnamecasi.setText(album.getTencasialbum());
        Picasso.with(context).load(album.getHinhalbum()).into(holder.imageViewalbum);
    }

    @Override
    public int getItemCount() {
        try {
            return arrayListalbum.size();
        }catch (Exception e){
            return 0;
        }
    }

    class viewHolder extends RecyclerView.ViewHolder{

        ImageView imageViewalbum;
        TextView tvnamebaihat,tvnamecasi;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewalbum=itemView.findViewById(R.id.imviewalbum);
            tvnamebaihat=itemView.findViewById(R.id.tvnameablbum);
            tvnamecasi=itemView.findViewById(R.id.tvnamecasialbum);
            imageViewalbum.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(context, ListbaifhatActivity.class);
                    intent.putExtra("idalbum",arrayListalbum.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
