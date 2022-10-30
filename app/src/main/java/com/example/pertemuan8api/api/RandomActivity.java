package com.example.pertemuan8api.api;

import com.google.gson.annotations.SerializedName;

public class RandomActivity {

    @SerializedName("key")
    private String key;

    @SerializedName("activity")
    private String activity;

    @SerializedName("type")
    private String type;

    @SerializedName("accessibility")
    private String accessibility;

    public String getKey() {
        return key;
    }

    public String getActivity() {
        return activity;
    }

    public String getType() {
        return type;
    }

    public String getAccessibility() {
        return accessibility;
    }
}
