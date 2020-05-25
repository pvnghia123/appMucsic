package com.example.appmusic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmusic.Activity.PlayMusicActivity;
import com.example.appmusic.Activity.Playnhac_Off_Activity;
import com.example.appmusic.Model.Baihat;
import com.example.appmusic.R;
import com.example.appmusic.database.baihat1;
import com.example.appmusic.database.database;

import java.util.ArrayList;

public class dsBaihat_offAdapter extends RecyclerView.Adapter<dsBaihat_offAdapter.Viewholder>  {

    Context context;
    ArrayList<Baihat> arrayList=new ArrayList<>();// cai này con sửa Bai hat chua phải là cuôi cùng

    public dsBaihat_offAdapter(Context context, ArrayList<Baihat> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.dong_dsbaihat_off,parent,false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        Baihat baihat=arrayList.get(position);
        holder.txtindenx.setText(position+1+"");
        holder.txttenbaihet.setText(baihat.getTenbaihat());
        holder.txtcasi.setText(baihat.getCasi());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {
        TextView txtindenx,txttenbaihet,txtcasi;
        ImageView xoa;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            txtindenx=itemView.findViewById(R.id.tvdcbaihat);
            txttenbaihet=itemView.findViewById(R.id.tvtenbaihat);
            txtcasi=itemView.findViewById(R.id.tencasi);
            xoa =itemView.findViewById(R.id.imagedowload);
            xoa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String id=arrayList.get(getPosition()).getIdbaihat();
                    database database=new database(context,"baihat.sqlite",null,1);
                    database.deletaBaihat(id);
                    Toast.makeText(context,"xoa thanh cong",Toast.LENGTH_LONG).show();




                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // database database=new database(context,"baihat.sqlite",null,1);
                    // lay du lieu
                    String id=arrayList.get(getPosition()).getIdbaihat();
                    String tencasi=arrayList.get(getPosition()).getCasi();
                    String tenbaihat=arrayList.get(getPosition()).getTenbaihat();
                    String linkbaihat=arrayList.get(getPosition()).getLinkbaihat();

                    Log.d("link", linkbaihat);
                    // gan du lieu
                    Baihat baihat=new Baihat(id,tenbaihat,"",tencasi,linkbaihat);
                    Intent intent=new Intent(context, Playnhac_Off_Activity.class);
                    intent.putExtra("cakhuc",baihat);
                    context.startActivity(intent);

                }
            });
        }
    }
}
