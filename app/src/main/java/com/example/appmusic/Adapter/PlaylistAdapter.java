package com.example.appmusic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appmusic.Model.Playlist;
import com.example.appmusic.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlaylistAdapter extends ArrayAdapter<Playlist> {
    public PlaylistAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }
    class viewHolder{
        TextView txtplaylist;
        ImageView imbackground,implaylist;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
      viewHolder viewHolder=null;
      if(viewHolder==null){
          LayoutInflater inflater= LayoutInflater.from(getContext());
          convertView= inflater.inflate(R.layout.dong_playlist,null);

          viewHolder=new viewHolder();
          viewHolder.txtplaylist=convertView.findViewById(R.id.tvtitlePlayslit);
          viewHolder.imbackground=convertView.findViewById(R.id.imbackgroundpl);
          viewHolder.implaylist=convertView.findViewById(R.id.imiconplaylist);
          convertView.setTag(viewHolder);
      }else{
          viewHolder=(viewHolder)convertView.getTag();
      }
        Playlist playlist=(Playlist)getItem(position);
        Picasso.with(getContext()).load(playlist.getHinh()).into(viewHolder.imbackground);
        Picasso.with(getContext()).load(playlist.getIcon()).into(viewHolder.implaylist);
        viewHolder.txtplaylist.setText(playlist.getTen());

        return  convertView;
    }
}
