package com.example.munia.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    String fUrl = "http://services.hanselandpetal.com/feeds/flowers.json";
    private final String BASE_URL = "http://services.hanselandpetal.com/";
    private FlowerServiceAPI flowerServiceAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
                .build();
        flowerServiceAPI = retrofit.create(FlowerServiceAPI.class);

        Call<ArrayList<FlowerResponse>>arrayListCall =
                flowerServiceAPI.getFlowerResponse();
        arrayListCall.enqueue(new Callback<ArrayList<FlowerResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<FlowerResponse>> call, Response<ArrayList<FlowerResponse>> response) {
                if (response.code() == 200){
                    ArrayList<FlowerResponse>flowerResponses = response.body();
                    Toast.makeText(MainActivity.this, ""+flowerResponses.size(), Toast.LENGTH_SHORT).show();
                    
                }

            }

            @Override
            public void onFailure(Call<ArrayList<FlowerResponse>> call, Throwable t) {

            }
        });
    }




}
