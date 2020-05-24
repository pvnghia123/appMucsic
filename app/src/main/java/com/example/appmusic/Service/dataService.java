package com.example.appmusic.Service;


import com.example.appmusic.Model.Album;
import com.example.appmusic.Model.Baihat;
import com.example.appmusic.Model.Playlist;
import com.example.appmusic.Model.Quangcao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface dataService {
@GET ("server/quangcao.php")
    Call<List<Quangcao>> getDatabanner();

@GET ("server/playlist.php")
    Call<List<Playlist>> getPlaylist();
@GET("server/album.php")
    Call<List<Album>> getAlbum();

@FormUrlEncoded
@POST("server/danhsachbaihat.php")
Call<List<Baihat>> getdsbaihatQC(@Field("idquangcao") String idquangcao);
@FormUrlEncoded
@POST("server/danhsachbaihat.php")
    Call<List<Baihat>> getdsbaihatPlaylist(@Field("idplaylist") String idplaylist);

@GET ("server/dsplaylist.php")
    Call<List<Playlist>> getdsPlayList();
@GET ("server/dsalbum.php")
    Call<List<Album>> getdsAlbum();
    @FormUrlEncoded
    @POST("server/danhsachbaihat.php")
    Call<List<Baihat>> getdsbaihatAlbum(@Field("idalbum") String idalbum);

    @FormUrlEncoded
    @POST("server/seach.php")
    Call<List<Baihat>> getdsbaihatSeach(@Field("key") String key);
}
