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
import com.example.appmusic.Model.Playlist;
import com.example.appmusic.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class dsPlaylistAdapter  extends RecyclerView.Adapter<dsPlaylistAdapter.ViewHolder>{
   Context context;
   ArrayList<Playlist> arrayList;

   // danh sach bai hat online

    public dsPlaylistAdapter(Context context, ArrayList<Playlist> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.dong_dsplaylist,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Playlist playlist=arrayList.get(position);
        Picasso.with(context).load(playlist.getHinh()).into(holder.imageView);
        holder.txttenPlaylist.setText(playlist.getTen());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView txttenPlaylist;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imgdsPlaylist);
            txttenPlaylist=itemView.findViewById(R.id.tvdsPlaylist);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, ListbaifhatActivity.class);
                    intent.putExtra("itemPlaylist",arrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });



        }
    }
}
