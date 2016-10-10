package com.owuor91.weatherapp.services;

import com.owuor91.weatherapp.datamodels.Geodata;
import com.owuor91.weatherapp.restclient.ApiClient;
import com.owuor91.weatherapp.restclient.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by johno_000 on 10/10/2016.
 */
public class GeodataService {
    public void getGeodata(){
        ApiInterface apiInterface = ApiClient.createService(ApiInterface.class);
        Call<Geodata> geodataCall = apiInterface.getGeodata(24.283, -5.083, 41.878, 4.883, "owuor91");
        geodataCall.enqueue(new Callback<Geodata>() {
            @Override
            public void onResponse(Call<Geodata> call, Response<Geodata> response) {

            }

            @Override
            public void onFailure(Call<Geodata> call, Throwable t) {

            }
        });
    }
}
