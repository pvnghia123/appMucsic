package com.example.appmusic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmusic.Model.Baihat;
import com.example.appmusic.R;
import com.example.appmusic.database.baihat1;

import java.util.ArrayList;

public class dsBaihat_offAdapter extends RecyclerView.Adapter<dsBaihat_offAdapter.Viewholder>  {

    Context context;
    ArrayList<baihat1> arrayList=new ArrayList<>();// cai này con sửa Bai hat chua phải là cuôi cùng

    public dsBaihat_offAdapter(Context context, ArrayList<baihat1> arrayList) {
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

        baihat1 baihat=arrayList.get(position);
        holder.txtindenx.setText(position+1+"");
        holder.txttenbaihet.setText(baihat.getTenbaihat());
        holder.txtcasi.setText(baihat.getTencasi());

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
        }
    }
}
