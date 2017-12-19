package com.scyb.aisbroadcast.webservice.bo;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2015/8/7
 * Time:13:20
 */
public class NumericalForecastBo {

    private String mmsi;
    private String sType;
    private String forecastTime;
    private String lon;
    private String lat;
    private String windSpeed;
    private String windDirection;
    private String waterSpeed;
    private String waterDirection;
    private String waveHigh;
    private String waveDirection;

    public NumericalForecastBo() {
    }

    public NumericalForecastBo(String mmsi, String sType, String forecastTime, String lon, String lat, String windSpeed, String windDirection, String waterSpeed, String waterDirection, String waveHigh, String waveDirection) {
        this.mmsi = mmsi;
        this.sType = sType;
        this.forecastTime = forecastTime;
        this.lon = lon;
        this.lat = lat;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.waterSpeed = waterSpeed;
        this.waterDirection = waterDirection;
        this.waveHigh = waveHigh;
        this.waveDirection = waveDirection;
    }

    public String getMmsi() {
        return mmsi;
    }

    public void setMmsi(String mmsi) {
        this.mmsi = mmsi;
    }

    public String getsType() {
        return sType;
    }

    public void setsType(String sType) {
        this.sType = sType;
    }

    public String getForecastTime() {
        return forecastTime;
    }

    public void setForecastTime(String forecastTime) {
        this.forecastTime = forecastTime;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getWaterSpeed() {
        return waterSpeed;
    }

    public void setWaterSpeed(String waterSpeed) {
        this.waterSpeed = waterSpeed;
    }

    public String getWaterDirection() {
        return waterDirection;
    }

    public void setWaterDirection(String waterDirection) {
        this.waterDirection = waterDirection;
    }

    public String getWaveHigh() {
        return waveHigh;
    }

    public void setWaveHigh(String waveHigh) {
        this.waveHigh = waveHigh;
    }

    public String getWaveDirection() {
        return waveDirection;
    }

    public void setWaveDirection(String waveDirection) {
        this.waveDirection = waveDirection;
    }

    @Override
    public String toString() {
        return "NumericalForecastBo{" +
                "mmsi='" + mmsi + '\'' +
                ", sType='" + sType + '\'' +
                ", forecastTime='" + forecastTime + '\'' +
                ", lon='" + lon + '\'' +
                ", lat='" + lat + '\'' +
                ", windSpeed='" + windSpeed + '\'' +
                ", windDirection='" + windDirection + '\'' +
                ", waterSpeed='" + waterSpeed + '\'' +
                ", waterDirection='" + waterDirection + '\'' +
                ", waveHigh='" + waveHigh + '\'' +
                ", waveDirection='" + waveDirection + '\'' +
                '}';
    }
}
