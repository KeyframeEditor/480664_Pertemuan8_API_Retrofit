package com.example.pertemuan8api.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance = null;
    private Api myApi;
//    private final static String BASE_URL = "https://random-data-api.com/api/v2/";
//    private final static String BASE_URL = "https://gorest.co.in/public/v2/";
//    private final static String API_KEY = "Bearer b66a85ca3c6b44467cd20bcd24e43ff20af8951c60f68280f0169633a9c0d9af";
    private final static String BASE_URL = "https://www.boredapi.com/api/";
    private final static String API_KEY = "586b59304a2e4fdd9bc209cc89ce1cff";

    private RetrofitClient(){
//        Interceptor interceptor = new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request request = chain.request().newBuilder().addHeader("Authorization",API_KEY).build();
//                return chain.proceed(request);
//            }
//        };

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        builder.interceptors().add(interceptor);
        OkHttpClient client = builder.build();
        //Retrofit akan mengambil data dari base URL, lalu akan dikonversi menggunakan gson converter
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).client(client)
                .build();
        myApi = retrofit.create(Api.class);
    }
    public static synchronized RetrofitClient getInstance(){
        if (instance == null){
            instance = new RetrofitClient();
        }
        return instance;
    }

    public Api getMyApi(){
        return myApi;
    }
}
