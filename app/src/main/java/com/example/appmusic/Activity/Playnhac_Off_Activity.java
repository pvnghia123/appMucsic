package com.example.appmusic.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import com.example.appmusic.Model.Baihat;
import com.example.appmusic.R;

public class Playnhac_Off_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playnhac__off_);

        Intent intent=getIntent();
        Baihat baihat = (Baihat) intent.getSerializableExtra("cakhuc");

        if(baihat!=null) {


            MediaPlayer mediaPlayer =  MediaPlayer.create(Playnhac_Off_Activity.this, Uri.parse(baihat.getLinkbaihat()));
            mediaPlayer.start();

        }
    }
}
