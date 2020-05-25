package com.example.appmusic.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.appmusic.Model.Baihat;

import java.util.ArrayList;

public class database extends SQLiteOpenHelper {



    public database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void queryData(String sql){

        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase.execSQL(sql);

    }



    public ArrayList getAllData(){
        ArrayList<Baihat> products = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from bathat", null);

        //Đến dòng đầu của tập dữ liệu
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            String idbaihat = cursor.getString(0);
            String tenbaihat = cursor.getString(1);
            String tencasi = cursor.getString(2);
            String linkbaihat = cursor.getString(3);


            products.add(new Baihat(idbaihat,tenbaihat," ",tencasi,linkbaihat));
            cursor.moveToNext();
        }

        cursor.close();

        return products;
    }
   public void insertBaihat(baihat1 product) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO bathat VALUES ('"+product.idbaihat+"','"+product.tenbaihat+"','"+product.tencasi+"','"+product.linkbaihat+"')");

    }
   public void deletaBaihat(String id) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from bathat where idbaihat='"+id+"'");

    }
    public boolean checkBaihat(String idbaihat) {
        SQLiteDatabase db = getReadableDatabase();
       // db.execSQL("select count('idbaihat') from bathat where idbaihat='"+product.idbaihat+"'");
        Cursor cursor=db.rawQuery("select * from bathat where idbaihat='"+idbaihat+"'",null);
        //cursor.moveToFirst();
        if (cursor!=null && cursor.moveToFirst()&&cursor.getString(0).equals(idbaihat) && cursor.getCount()>0){
            return true;
        }else{
            return false;
        }

//        if(cursor.isFirst()){
//            Log.d("aa", "duwx lieu bai hat dax ton tai: "+cursor.getString(0)+cursor.getString(1));
//            return true;
//        }else{
//            return false;
//        }
    }
}
