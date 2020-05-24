package com.example.appmusic.Adapter;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmusic.Activity.PlayMusicActivity;
import com.example.appmusic.Model.Baihat;
import com.example.appmusic.R;
import com.example.appmusic.database.baihat1;
import com.example.appmusic.database.database;

import java.io.File;
import java.util.ArrayList;

public class dsBHPhatnhacAdapter  extends RecyclerView.Adapter<dsBHPhatnhacAdapter.ViewHolder> {
    Context context;
    ArrayList<Baihat> arrayListbaihat=new ArrayList<>();

    public dsBHPhatnhacAdapter(Context context, ArrayList<Baihat> arrayListbaihat) {
        this.context = context;
        this.arrayListbaihat = arrayListbaihat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.dong_dsbaihat,parent,false);
        return new dsBHPhatnhacAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull dsBHPhatnhacAdapter.ViewHolder holder, int position) {
        Baihat baihat=arrayListbaihat.get(position);
if(baihat!=null) {
    holder.txtcasi.setText(baihat.getCasi());
    holder.txttenbaihet.setText(baihat.getTenbaihat());
    holder.txtindenx.setText(position + 1 + "");
}
    }

    @Override
    public int getItemCount() {
        return arrayListbaihat.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtindenx,txttenbaihet,txtcasi;
        ImageView dowload;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtindenx=itemView.findViewById(R.id.tvdcbaihat);
            txttenbaihet=itemView.findViewById(R.id.tvtenbaihat);
            txtcasi=itemView.findViewById(R.id.tencasi);
            dowload =itemView.findViewById(R.id.imagedowload);
            dowload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    database database=new database(context,"baihat.sqlite",null,1);
                    if(!database.checkBaihat(arrayListbaihat.get(getPosition()).getIdbaihat()))
                    {
                        Log.d("aa", "khong ton tai: ");
                        // neu ko ton tai thi cho dow ve
                        String linkbaihat=arrayListbaihat.get(getPosition()).getLinkbaihat();
                        // TODO cho nay get dc ten file cung nhu mime type cua file b tim hieu them de lam app nghe nhac

                        int vitri=linkbaihat.lastIndexOf('/');// lây ki tu / cuoi cung
                        String baihat=linkbaihat.substring(vitri+1,linkbaihat.length());// lây chuoi tu / den cuoi cung

                        // dong nay de dowload
                        DownloadManager.Request dmr = new DownloadManager.Request(Uri.parse(linkbaihat));
                        // If you know file name
                        String fileName = baihat;
                        //Alternative if you don't know filename
                        String fileName1 = URLUtil.guessFileName(linkbaihat, null, MimeTypeMap.getFileExtensionFromUrl(linkbaihat));
                        dmr.setTitle(fileName);
                        dmr.setDescription("Some descrition about file"); //optional
                        dmr.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);
                        dmr.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                        dmr.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
                        DownloadManager manager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
                        manager.enqueue(dmr);


                        File file1 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), fileName);
                        Toast.makeText(context,"dow thanh cong",Toast.LENGTH_LONG).show();
                        File file2=new File("../storage/sdcard0/Download/Phi Ái – Độ Ta Không Độ Nàng.mp3");

//                        MediaPlayer mediaPlayer=MediaPlayer.create(context, Uri.parse("../storage/sdcard0/Download/"+baihat));
//                        mediaPlayer.start();
                        String id= arrayListbaihat.get(getPosition()).getIdbaihat();
                        String tenbaihat=arrayListbaihat.get(getPosition()).getTenbaihat();
                        String tencasi=arrayListbaihat.get(getPosition()).getCasi();
                        String linkbaihatLocal="../storage/sdcard0/Download/"+baihat;
                        // them voao trong csdl
                        baihat1 Baihat=new baihat1(id,tenbaihat,tencasi,linkbaihatLocal);
                        database.insertBaihat(Baihat);




                    }else{
                        Log.d("aa", " ton tai: ");
                       // Toast.makeText(context,"da ton tai",Toast.LENGTH_LONG).show();
                    }
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                 // new PlayMusicActivity().phatnhac(Integer.parseInt(arrayListbaihat.get(getPosition()).getIdbaihat()));
                }
            });
        }
    }
}
