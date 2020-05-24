package com.example.appmusic.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.appmusic.Adapter.seachAdapter;
import com.example.appmusic.Model.Baihat;
import com.example.appmusic.R;
import com.example.appmusic.Service.APIService;
import com.example.appmusic.Service.dataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class seachActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageView imageView;
    EditText editText;
    TextView khongcodulieu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seach);

        recyclerView=findViewById(R.id.recviewSeach);
        imageView=findViewById(R.id.butBack);
        editText=findViewById(R.id.editTextSeach);
        khongcodulieu=findViewById(R.id.khongdulieu);

       // setDataseach("độ");

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode==KeyEvent.KEYCODE_ENTER) {
                    String chuoi = String.valueOf(editText.getText());

                    setDataseach(chuoi);





                    Toast.makeText(seachActivity.this,chuoi,Toast.LENGTH_LONG).show();
                    return true;
                }
                return false;
            }
        });



       // SearchView searchView =toolbar.getAct
    }
    private void setDataseach(String chuoi){
        dataService dataService= APIService.getService();
        Call<List<Baihat>> callback=dataService.getdsbaihatSeach(chuoi);
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {// tra ve
                ArrayList<Baihat> arrayList= (ArrayList<Baihat>) response.body();
                if(arrayList.size()>0){// gan du lieu len risaicoview
                    seachAdapter seachAdapter=new seachAdapter(seachActivity.this,arrayList);
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(seachActivity.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(seachAdapter);
                    recyclerView.setVisibility(View.VISIBLE);
                    khongcodulieu.setVisibility(View.GONE);
                }else{
                    khongcodulieu.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                }
            }
            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });

    }
}
