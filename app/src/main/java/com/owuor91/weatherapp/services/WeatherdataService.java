package com.owuor91.weatherapp.services;

import com.owuor91.weatherapp.datamodels.WeatherObservation;
import com.owuor91.weatherapp.datamodels.Weatherdata;
import com.owuor91.weatherapp.restclient.ApiClient;
import com.owuor91.weatherapp.restclient.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by johno_000 on 10/10/2016.
 */
public class WeatherdataService {
    public void getWeatherData(){
        ApiInterface apiInterface = ApiClient.createService(ApiInterface.class);
        Call<Weatherdata> weatherdataCall = apiInterface.getWeatherdata("HKNW", "owuor91");
        weatherdataCall.enqueue(new Callback<Weatherdata>() {
            @Override
            public void onResponse(Call<Weatherdata> call, Response<Weatherdata> response) {
                if (response.isSuccessful()){
                    WeatherObservation nairobiWeatherData = response.body().getWeatherObservation();
                    nairobiWeatherData.save();
                }
            }

            @Override
            public void onFailure(Call<Weatherdata> call, Throwable t) {

            }
        });
    }
}
