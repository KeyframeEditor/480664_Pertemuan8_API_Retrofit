package com.example.pertemuan8api.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("activity")
    Call<RandomActivity> getActivity();
}
