package com.example.appmusic.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmusic.Activity.PlayMusicActivity;
import com.example.appmusic.Adapter.dsbaihatadapter;
import com.example.appmusic.R;

public class fragment_Play_ds_baihat  extends Fragment {
    View view;
    RecyclerView recyclerViewdsNhac;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_ds_cac_baihat,container,false);
        recyclerViewdsNhac=view.findViewById(R.id.recviewDSnhac);
        if(PlayMusicActivity.baihatArrayList.size()>0){
        dsbaihatadapter dsbaihatadapter = new dsbaihatadapter(getActivity(),PlayMusicActivity.baihatArrayList);
        recyclerViewdsNhac.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewdsNhac.setAdapter(dsbaihatadapter);

        }
        return view;
    }
}
