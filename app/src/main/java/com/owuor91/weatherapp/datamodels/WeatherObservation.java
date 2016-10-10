
package com.owuor91.weatherapp.datamodels;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

@Generated("org.jsonschema2pojo")
public class WeatherObservation extends SugarRecordn{

    @SerializedName("elevation")
    @Expose
    private int elevation;
    @SerializedName("lng")
    @Expose
    private double lng;
    @SerializedName("observation")
    @Expose
    private String observation;
    @SerializedName("ICAO")
    @Expose
    private String iCAO;
    @SerializedName("clouds")
    @Expose
    private String clouds;
    @SerializedName("dewPoint")
    @Expose
    private String dewPoint;
    @SerializedName("cloudsCode")
    @Expose
    private String cloudsCode;
    @SerializedName("datetime")
    @Expose
    private String datetime;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("temperature")
    @Expose
    private String temperature;
    @SerializedName("humidity")
    @Expose
    private int humidity;
    @SerializedName("stationName")
    @Expose
    private String stationName;
    @SerializedName("weatherCondition")
    @Expose
    private String weatherCondition;
    @SerializedName("windDirection")
    @Expose
    private int windDirection;
    @SerializedName("hectoPascAltimeter")
    @Expose
    private int hectoPascAltimeter;
    @SerializedName("windSpeed")
    @Expose
    private String windSpeed;
    @SerializedName("lat")
    @Expose
    private double lat;

    /**
     * 
     * @return
     *     The elevation
     */
    public int getElevation() {
        return elevation;
    }

    /**
     * 
     * @param elevation
     *     The elevation
     */
    public void setElevation(int elevation) {
        this.elevation = elevation;
    }

    /**
     * 
     * @return
     *     The lng
     */
    public double getLng() {
        return lng;
    }

    /**
     * 
     * @param lng
     *     The lng
     */
    public void setLng(double lng) {
        this.lng = lng;
    }

    /**
     * 
     * @return
     *     The observation
     */
    public String getObservation() {
        return observation;
    }

    /**
     * 
     * @param observation
     *     The observation
     */
    public void setObservation(String observation) {
        this.observation = observation;
    }

    /**
     * 
     * @return
     *     The iCAO
     */
    public String getICAO() {
        return iCAO;
    }

    /**
     * 
     * @param iCAO
     *     The ICAO
     */
    public void setICAO(String iCAO) {
        this.iCAO = iCAO;
    }

    /**
     * 
     * @return
     *     The clouds
     */
    public String getClouds() {
        return clouds;
    }

    /**
     * 
     * @param clouds
     *     The clouds
     */
    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    /**
     * 
     * @return
     *     The dewPoint
     */
    public String getDewPoint() {
        return dewPoint;
    }

    /**
     * 
     * @param dewPoint
     *     The dewPoint
     */
    public void setDewPoint(String dewPoint) {
        this.dewPoint = dewPoint;
    }

    /**
     * 
     * @return
     *     The cloudsCode
     */
    public String getCloudsCode() {
        return cloudsCode;
    }

    /**
     * 
     * @param cloudsCode
     *     The cloudsCode
     */
    public void setCloudsCode(String cloudsCode) {
        this.cloudsCode = cloudsCode;
    }

    /**
     * 
     * @return
     *     The datetime
     */
    public String getDatetime() {
        return datetime;
    }

    /**
     * 
     * @param datetime
     *     The datetime
     */
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    /**
     * 
     * @return
     *     The countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * 
     * @param countryCode
     *     The countryCode
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * 
     * @return
     *     The temperature
     */
    public String getTemperature() {
        return temperature;
    }

    /**
     * 
     * @param temperature
     *     The temperature
     */
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    /**
     * 
     * @return
     *     The humidity
     */
    public int getHumidity() {
        return humidity;
    }

    /**
     * 
     * @param humidity
     *     The humidity
     */
    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    /**
     * 
     * @return
     *     The stationName
     */
    public String getStationName() {
        return stationName;
    }

    /**
     * 
     * @param stationName
     *     The stationName
     */
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    /**
     * 
     * @return
     *     The weatherCondition
     */
    public String getWeatherCondition() {
        return weatherCondition;
    }

    /**
     * 
     * @param weatherCondition
     *     The weatherCondition
     */
    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    /**
     * 
     * @return
     *     The windDirection
     */
    public int getWindDirection() {
        return windDirection;
    }

    /**
     * 
     * @param windDirection
     *     The windDirection
     */
    public void setWindDirection(int windDirection) {
        this.windDirection = windDirection;
    }

    /**
     * 
     * @return
     *     The hectoPascAltimeter
     */
    public int getHectoPascAltimeter() {
        return hectoPascAltimeter;
    }

    /**
     * 
     * @param hectoPascAltimeter
     *     The hectoPascAltimeter
     */
    public void setHectoPascAltimeter(int hectoPascAltimeter) {
        this.hectoPascAltimeter = hectoPascAltimeter;
    }

    /**
     * 
     * @return
     *     The windSpeed
     */
    public String getWindSpeed() {
        return windSpeed;
    }

    /**
     * 
     * @param windSpeed
     *     The windSpeed
     */
    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    /**
     * 
     * @return
     *     The lat
     */
    public double getLat() {
        return lat;
    }

    /**
     * 
     * @param lat
     *     The lat
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

}
