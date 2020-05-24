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

import com.example.appmusic.Activity.PlayMusicActivity;
import com.example.appmusic.Model.Baihat;
import com.example.appmusic.R;

import java.util.ArrayList;

public class seachAdapter extends RecyclerView.Adapter<seachAdapter.Viewholder> {

    Context context;
    ArrayList<Baihat> arrayList = new ArrayList<>();// cai này con sửa Bai hat chua phải là cuôi cùng

    public seachAdapter(Context context, ArrayList<Baihat> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }
//
    @NonNull
    @Override
    public seachAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_dsbaihat_off, parent, false);

        return new seachAdapter.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull seachAdapter.Viewholder holder, int position) {
        Baihat baihat = arrayList.get(position);
        holder.txtindenx.setText(position + 1 + "");
        holder.txttenbaihet.setText(baihat.getTenbaihat());
        holder.txtcasi.setText(baihat.getCasi());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {
        TextView txtindenx, txttenbaihet, txtcasi;
        ImageView xoa;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            txtindenx = itemView.findViewById(R.id.tvdcbaihat);
            txttenbaihet = itemView.findViewById(R.id.tvtenbaihat);
            txtcasi = itemView.findViewById(R.id.tencasi);
            xoa = itemView.findViewById(R.id.imagedowload);

            // bat su kien ticon
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, PlayMusicActivity.class);
                    intent.putExtra("cakhuc",arrayList.get(getLayoutPosition()));
                    context.startActivity(intent);
                }
            });

        }
    }
}