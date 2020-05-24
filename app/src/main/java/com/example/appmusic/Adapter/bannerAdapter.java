package com.example.appmusic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.appmusic.Activity.ListbaifhatActivity;
import com.example.appmusic.Model.Quangcao;
import com.example.appmusic.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class bannerAdapter extends PagerAdapter
{
    Context context;
    ArrayList<Quangcao> arrayListbanner;

    public bannerAdapter(Context context, ArrayList<Quangcao> arrayListbanner) {
        this.context = context;
        this.arrayListbanner = arrayListbanner;
    }

    @Override
    public int getCount() {
       if(arrayListbanner.size()!=0){
        return arrayListbanner.size();
       }else
           return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {
        final LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.dong_banner,null);
        ImageView imageViewbackgroud=view.findViewById(R.id.idbackgroudbanner);
        ImageView imgbanner=view.findViewById(R.id.imageviewbanner);
        TextView txttitle=view.findViewById(R.id.Textviewtitllebannerbaihat);
        TextView txtnd=view.findViewById(R.id.txtnd);
        Picasso.with(context).load(arrayListbanner.get(position).getHinhanh()).into(imageViewbackgroud);
        Picasso.with(context).load(arrayListbanner.get(position).getHinhbaihat()).into(imgbanner);

        txttitle.setText(arrayListbanner.get(position).getTenbaihat());
        txtnd.setText(arrayListbanner.get(position).getNoidung());


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,"da click",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(context, ListbaifhatActivity.class);
                intent.putExtra("banner",arrayListbanner.get(position));
                context.startActivity(intent);
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(   (View) object);
    }
}
