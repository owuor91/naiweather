package com.owuor91.weatherapp.restclient;

import com.owuor91.weatherapp.datamodels.Geodata;
import com.owuor91.weatherapp.datamodels.Weatherdata;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by johno_000 on 10/10/2016.
 */
public interface ApiInterface {
    @GET("/citiesJSON")
    Call<Geodata> getGeodata(@Query("north") double north, @Query("south") double south, @Query("east") double east, @Query("west") double west, @Query("username") String username);

    @GET("/weatherIcaoJSON")
    Call<Weatherdata> getWeatherdata(@Query("ICAO") String icao, @Query("username") String username);
}
