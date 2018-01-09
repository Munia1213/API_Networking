package com.example.munia.retrofitexample;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by munia on 1/8/2018.
 */

public interface FlowerServiceAPI {

    @GET("feeds/flowers.json")
    Call<ArrayList<FlowerResponse>> getFlowerResponse();

}
