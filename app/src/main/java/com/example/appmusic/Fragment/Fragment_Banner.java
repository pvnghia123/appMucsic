package com.example.appmusic.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.appmusic.Adapter.bannerAdapter;
import com.example.appmusic.Model.Quangcao;
import com.example.appmusic.R;
import com.example.appmusic.Service.APIService;
import com.example.appmusic.Service.dataService;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Banner extends Fragment {
    View view;
    ViewPager viewPager;
    CircleIndicator circleIndicator;
    bannerAdapter bannerAdapter;
    Runnable runnable;
    Handler handler;
    int customitem;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_banner, container, false);

        anhxa();
        getData();
        return view;

    }

    private void anhxa(){
        viewPager=view.findViewById(R.id.viewpaper);
        circleIndicator=view.findViewById(R.id.indicatordefa );

    }
    private void getData() {
        dataService dataService= APIService.getService();
        Call<List<Quangcao>> callback=dataService.getDatabanner();
        callback.enqueue(new Callback<List<Quangcao>>() {
            @Override
            public void onResponse(Call<List<Quangcao>> call, Response<List<Quangcao>> response) {
                ArrayList<Quangcao> banner= (ArrayList<Quangcao>) response.body();
               // Log.d("bbb", banner.get(0).getTenbaihat());
                bannerAdapter=new bannerAdapter(getActivity(),banner);
                viewPager.setAdapter(bannerAdapter);
                circleIndicator.setViewPager(viewPager);
                handler=new Handler();
                runnable=new Runnable() {
                    @Override
                    public void run() {
                        customitem = viewPager.getCurrentItem();
                        customitem++;
                        if (customitem >= viewPager.getAdapter().getCount()) {
                            customitem = 0;
                        }

                        viewPager.setCurrentItem(customitem,true);
                        handler.postDelayed(runnable,4500);
                    }
                };
                handler.postDelayed(runnable,4500);

            }
            @Override
            public void onFailure(Call<List<Quangcao>> call, Throwable t) {
                Log.d("bbb", "eoc ra");
            }
        });
    }
}
