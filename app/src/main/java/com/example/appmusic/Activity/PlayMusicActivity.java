package com.example.appmusic.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
;

import com.example.appmusic.Adapter.viewpaperAdapter;
import com.example.appmusic.Fragment.fragment_Play_ds_baihat;
import com.example.appmusic.Fragment.fragment_dianhac;
import com.example.appmusic.Fragment.fragment_dsBHPhatnhac;
import com.example.appmusic.Model.Baihat;
import com.example.appmusic.R;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

public class PlayMusicActivity extends AppCompatActivity {


    Toolbar toolbar;
    TextView tvTimesong,tvTotaltimeSong;
    SeekBar seekBar;
    ImageButton butplay,butrepeat,butNext,butPre,butRandom;
    ViewPager viewPagerPlayMusic;
    static viewpaperAdapter viewpaperAdapter;
    MediaPlayer mediaPlayer;
   public static ArrayList<Baihat> baihatArrayList=new ArrayList<>();

    fragment_dianhac fragment_dianhac;
    fragment_dsBHPhatnhac fragment_dsBHPhatnhac;
    int vitri=0;
    boolean repeat=false;
    boolean checkrandom=false;
    boolean next=false;


    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);

        init();
        getDataFromIntent();
        addviewpaper();
        eventClick();

    }

    private void eventClick() {
        Handler handler=new Handler();
//      handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if(viewpaperAdapter.getItem(1)!=null){
//                    if (baihatArrayList.size()>0){
//                        fragment_dianhac.Play
//                    }
//                }
//
//            }
//        },500);
        butplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {// su kien nut play
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    butplay.setImageResource(R.drawable.iconplay);
                }else{
                    mediaPlayer.start();
                    butplay.setImageResource(R.drawable.iconpause);
                }
            }
        });
        butrepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {// su kien lap laij
                if(repeat==false){// neu lap la
                    if(checkrandom==true){
                        checkrandom=false;
                        butrepeat.setImageResource((R.drawable.iconsyned));
                        butRandom.setImageResource((R.drawable.iconsuffle));
                    }
                    butrepeat.setImageResource(R.drawable.iconsyned);
                    repeat=true;
                }else{
                    butrepeat.setImageResource((R.drawable.iconrepeat));
                    repeat=false;
                }
            }
        });
        butRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {// nut ramdom
                if(checkrandom==false){
                    if(repeat==true){
                        repeat=false;
                        butRandom.setImageResource((R.drawable.iconshuffled));
                        butrepeat.setImageResource((R.drawable.iconrepeat));

                    }
                    butRandom.setImageResource(R.drawable.iconshuffled);
                    checkrandom=true;

                }else{
                    butRandom.setImageResource((R.drawable.iconsuffle));
                    checkrandom=false;
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {// nhan nut next
                if(baihatArrayList.size() > 0){
                    if(mediaPlayer.isPlaying()||mediaPlayer!=null){// neu dang chay ma nex
                            mediaPlayer.stop();
                            mediaPlayer.release();
                            mediaPlayer=null;
                    }
                    if(vitri < baihatArrayList.size()){
                        butplay.setImageResource(R.drawable.iconpause);
                        vitri++;
                        if(repeat==true){
                            vitri--;
                            //repeat=false;

                        }
                        if(vitri>=baihatArrayList.size()){//== vitri cuoi
                            vitri=0;
                        }
                        if(checkrandom==true){
                            Random random=new Random();
                            int index=random.nextInt(baihatArrayList.size()-1);
                            vitri=index;
                        }
                    }
                    new PlayMp3().execute(baihatArrayList.get(vitri).getLinkbaihat());
                    getSupportActionBar().setTitle(baihatArrayList.get(vitri).getTenbaihat());
                    UpdateTime();
                }

            }
        });
        butPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {// nut tro ve
                if(baihatArrayList.size()>0){
                    if(mediaPlayer.isPlaying()||mediaPlayer!=null){// dang chay
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer=null;
                    }
                    if(vitri<baihatArrayList.size()){
                        butplay.setImageResource(R.drawable.iconpause);
                        vitri--;
                        if(vitri<0){
                            vitri=baihatArrayList.size()-1;
                        }
                        if(repeat==true){// lap
                            vitri+=1;
                        }
                        if(checkrandom==true){
                            Random random=new Random();
                            int index=random.nextInt(baihatArrayList.size()-1);
                            vitri=index;
                        }

                    }
                    new PlayMp3().execute(baihatArrayList.get(vitri).getLinkbaihat());
                    getSupportActionBar().setTitle(baihatArrayList.get(vitri).getTenbaihat());
                    UpdateTime();
                }
            }
        });

    }

    private void getDataFromIntent() {
        Intent intent=getIntent();
        baihatArrayList.clear();
        if(intent!=null) {
            if (intent.hasExtra("cakhuc")) {
                Baihat baihat = (Baihat) intent.getSerializableExtra("cakhuc");
                Log.d("aa", "bai hat: "+baihat.getTenbaihat());
                baihatArrayList.add(baihat);
            }
            if (intent.hasExtra("list")) {
                ArrayList<Baihat> arrayList = (ArrayList<Baihat>) intent.getSerializableExtra("list");
                baihatArrayList = arrayList;

                for (int i = 0; i < arrayList.size(); i++) {
                    Log.d("aa", baihatArrayList.get(i).getTenbaihat());
                }

            }
        }
    }

    public void init(){
        toolbar=findViewById(R.id.toolbarPlaynhac);
        tvTimesong=findViewById(R.id.tvtimesong);
        tvTotaltimeSong=findViewById(R.id.tctotalttimesong);
        seekBar=findViewById(R.id.seekbarsong);
        butNext=findViewById(R.id.butnext);
        butplay=findViewById(R.id.butPlay);
        butPre=findViewById(R.id.butorpreview);
        butRandom=findViewById(R.id.butsuffle);
        butrepeat=findViewById(R.id.butRepeat);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(Color.WHITE);
        viewPagerPlayMusic=findViewById(R.id.viewpaper);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {// chuc nang tro ve

                finish();
                mediaPlayer.stop();
                baihatArrayList.clear();
            }
        });



    }
    public void addviewpaper(){
        viewpaperAdapter=new viewpaperAdapter(getSupportFragmentManager());
        fragment_dianhac=new fragment_dianhac();
        fragment_dsBHPhatnhac =new fragment_dsBHPhatnhac();

        viewpaperAdapter.addFragment(fragment_dianhac);
        viewpaperAdapter.addFragment(fragment_dsBHPhatnhac);
        Log.d("aaa", "init: ");
        viewPagerPlayMusic.setAdapter(viewpaperAdapter);

        if(baihatArrayList.size()>0){/// chay ngay khi mo giao dien

            getSupportActionBar().setTitle(baihatArrayList.get(0).getTenbaihat());
            new PlayMp3().execute(baihatArrayList.get(0).getLinkbaihat());
            butplay.setImageResource(R.drawable.iconpause);
        }
    }

    class PlayMp3 extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            return strings[0];
        }

        @Override
        protected void onPostExecute(String baihat) {
            super.onPostExecute(baihat);
            mediaPlayer=new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                }
            });
            try {
                mediaPlayer.setDataSource(baihat);
                mediaPlayer.prepare();

            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaPlayer.start();
            TimeSong();
            UpdateTime();
        }


    }
    private void TimeSong() {
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("mm:ss");
        tvTimesong.setText(simpleDateFormat.format(mediaPlayer.getDuration()));
        seekBar.setMax(mediaPlayer.getDuration());
    }
    private void UpdateTime(){
        final Handler handler=new Handler();// cap nhap laij seekbar
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(mediaPlayer!=null){
                    seekBar.setProgress(mediaPlayer.getCurrentPosition());
                    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("mm:ss");
                    tvTotaltimeSong.setText(simpleDateFormat.format(mediaPlayer.getCurrentPosition()));
                    handler.postDelayed(this,300);
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {// khi heets  bat hat
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            next=true;

                        }
                    });
                }
            }
        },300);
        final Handler handler1=new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(next==true){
                    if(baihatArrayList.size() > 0){
                        if(mediaPlayer.isPlaying()||mediaPlayer!=null){// neu dang chay ma nex
                            mediaPlayer.stop();
                            mediaPlayer.release();
                            mediaPlayer=null;
                        }
                        if(vitri < baihatArrayList.size()){
                            butplay.setImageResource(R.drawable.iconpause);
                            vitri++;
                            if(repeat==true){
                                vitri--;
                                //repeat=false;

                            }
                            if(vitri>=baihatArrayList.size()){//== vitri cuoi
                                vitri=0;
                            }
                            if(checkrandom==true){
                                Random random=new Random();
                                int index=random.nextInt(baihatArrayList.size()-1);
                                vitri=index;
                            }
                        }
                        new PlayMp3().execute(baihatArrayList.get(vitri).getLinkbaihat());
                        getSupportActionBar().setTitle(baihatArrayList.get(vitri).getTenbaihat());
                        UpdateTime();
                    }
                    next=false;
                    handler1.removeCallbacks(this);
                    //new Dialog

                }else{
                    handler1.postDelayed(this,1000);
                }
            }
        },1000);

    }
    public void phatnhac(int vitri){
        new PlayMp3().execute(baihatArrayList.get(vitri).getLinkbaihat());
        getSupportActionBar().setTitle(baihatArrayList.get(vitri).getTenbaihat());
        UpdateTime();
    }
}
