package com.example.appmusic.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmusic.Adapter.dsBaihat_offAdapter;
import com.example.appmusic.Model.Baihat;
import com.example.appmusic.R;
import com.example.appmusic.database.baihat1;
import com.example.appmusic.database.database;

import java.util.ArrayList;

public class Fragment_ca_nhan extends Fragment {
    View view;
    Toolbar toolbar;
    Button button;
    RecyclerView recyclerView_off;
   static ArrayList<baihat1> arrayList=new ArrayList<>();



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view =inflater.inflate(R.layout.fragment_ca_nhan,container,false);
        button=view.findViewById(R.id.tvPhatAll);
        toolbar=view.findViewById(R.id.tb);
        recyclerView_off=view.findViewById(R.id.recyviewds_offline);
        khoitao();
        dsBaihat_offAdapter dsBaihat_offAdapter=new dsBaihat_offAdapter(getActivity(),arrayList);
        recyclerView_off.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView_off.setAdapter(dsBaihat_offAdapter);
        return view;
    }

    public void khoitao(){ // cai nay là tam


        database database=new database(getActivity(),"baihat.sqlite",null,1);
        database.queryData("Create table if not exists bathat (idbaihat integer primary key,tenbaihat varchar(250),tencasi varchar(250),linkbaihat varchar(250))");


      //  baihat1 baihat11=new baihat1(1,"dotakhong do nang","onlyc"," ");

       // database.insertBaihat(baihat11);
       // database.deletaBaihat(baihat11);

        arrayList=database.getAllData();




//        arrayList.add(new Baihat(" ","dộ ta không độ nàng"," ","onlyc"," "));
//        arrayList.add(new Baihat(" ","gọi tên cô đơn"," ","onlyc"," "));
    }


}
