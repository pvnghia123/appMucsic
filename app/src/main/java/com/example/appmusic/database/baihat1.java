package com.example.appmusic.database;

public class baihat1 {
    String idbaihat;
    String tenbaihat;
    String tencasi;
    String linkbaihat;

    public baihat1(String idbaihat, String tenbaihat, String tencasi, String linkbaihat) {
        this.idbaihat = idbaihat;
        this.tenbaihat = tenbaihat;
        this.tencasi = tencasi;
        this.linkbaihat = linkbaihat;
    }

    public String getIdbaihat() {
        return idbaihat;
    }



    public String getTenbaihat() {
        return tenbaihat;
    }

    public void setTenbaihat(String tenbaihat) {
        this.tenbaihat = tenbaihat;
    }

    public String getTencasi() {
        return tencasi;
    }

    public void setTencasi(String tencasi) {
        this.tencasi = tencasi;
    }

    public String getLinkbaihat() {
        return linkbaihat;
    }

    public void setLinkbaihat(String linkbaihat) {
        this.linkbaihat = linkbaihat;
    }
}
