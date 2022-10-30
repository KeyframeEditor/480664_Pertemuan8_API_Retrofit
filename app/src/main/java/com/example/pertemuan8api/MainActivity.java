package com.example.pertemuan8api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pertemuan8api.api.RandomActivity;
import com.example.pertemuan8api.api.RetrofitClient;
import com.example.pertemuan8api.recyclerview.ActivityData;
import com.example.pertemuan8api.recyclerview.randomActivityAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView textView1;
    TextView textView2;
    Button button1;
    RecyclerView recyclerview;
    private ArrayList<ActivityData> activityDataArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        button1 = findViewById(R.id.button1);

        //Recyclerview
        recyclerview = findViewById(R.id.recyclerview);
        randomActivityAdapter randomactivityadapter;
        randomactivityadapter = new randomActivityAdapter(this,activityDataArrayList);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(randomactivityadapter);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getRandomActivity(randomactivityadapter);
            }
        });
    }

    //get random data ini sudah secara otomatis request data di background
    // kalau mau secara manual jalan di bg, maka harus menggunakan equator

    private void getRandomActivity(randomActivityAdapter randomActivityAdapter){
        Call<RandomActivity> caller = RetrofitClient.getInstance().getMyApi().getActivity();

        //enqueue
        caller.enqueue(new Callback<RandomActivity>() {
            @Override
            public void onResponse(Call<RandomActivity> call, Response<RandomActivity> response) {
                RandomActivity randomActivity  = response.body();

                String activity = randomActivity.getActivity();
                String type = randomActivity.getType();
                String difficulty = randomActivity.getAccessibility();
                Double difficulty_double = Double.parseDouble(difficulty);

                if (difficulty_double >= 0.8 ){
                    difficulty = "Hard to do";
                }
                else if(difficulty_double >= 0.4){
                    difficulty = "Fair difficulty";
                }
                else{
                    difficulty = "Easy to do";
                }

                activityDataArrayList.add(new ActivityData(activity,type,difficulty));
                randomActivityAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<RandomActivity> call, Throwable t) {
            }
        });
        //end enqueue
    }
}