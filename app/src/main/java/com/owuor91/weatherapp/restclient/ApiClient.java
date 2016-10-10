package com.owuor91.weatherapp.restclient;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by johno_000 on 10/10/2016.
 */
public class ApiClient {
    public static final String BASE_API_URL = "http://api.geonames.org";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_API_URL).addConverterFactory(GsonConverterFactory.create());

    public static <C> C createService(Class<C> serviceClass){
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }
}
