package com.example.appmusic.Service;

public class APIService {

    static String base_url="https://apinghenhac.000webhostapp.com/";
   public static dataService getService(){
        return APIRetrofitClient.getClient(base_url).create(dataService.class);
    }
}
