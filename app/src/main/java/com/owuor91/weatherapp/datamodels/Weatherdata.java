
package com.owuor91.weatherapp.datamodels;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Weatherdata {

    @SerializedName("weatherObservation")
    @Expose
    private WeatherObservation weatherObservation;

    /**
     * 
     * @return
     *     The weatherObservation
     */
    public WeatherObservation getWeatherObservation() {
        return weatherObservation;
    }

    /**
     * 
     * @param weatherObservation
     *     The weatherObservation
     */
    public void setWeatherObservation(WeatherObservation weatherObservation) {
        this.weatherObservation = weatherObservation;
    }

}
