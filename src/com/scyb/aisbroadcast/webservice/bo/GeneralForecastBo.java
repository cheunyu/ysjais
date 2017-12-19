package com.scyb.aisbroadcast.webservice.bo;

import java.sql.Timestamp;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2015/7/29
 * Time:14:04
 */
public class GeneralForecastBo {
    private String mmsi;
    private String sType;
    private String waveHigh;
    private String waterTemperature;
    private String tideHighTime;
    private String tideHigh;
    private String tideLowTime;
    private String tideLow;

    public String getsType() {
        return sType;
    }

    public void setsType(String sType) {
        this.sType = sType;
    }

    public void setMmsi(String mmsi) {
        this.mmsi = mmsi;
    }

    public String getMmsi() {
        return mmsi;
    }

    public String getWaveHigh() {
        return waveHigh;
    }

    public void setWaveHigh(String waveHigh) {
        this.waveHigh = waveHigh;
    }

    public String getWaterTemperature() {
        return waterTemperature;
    }

    public void setWaterTemperature(String waterTemperature) {
        this.waterTemperature = waterTemperature;
    }

    public String getTideHighTime() {
        return tideHighTime;
    }

    public void setTideHighTime(String tideHighTime) {
        this.tideHighTime = tideHighTime;
    }

    public String getTideHigh() {
        return tideHigh;
    }

    public void setTideHigh(String tideHigh) {
        this.tideHigh = tideHigh;
    }

    public String getTideLowTime() {
        return tideLowTime;
    }

    public void setTideLowTime(String tideLowTime) {
        this.tideLowTime = tideLowTime;
    }

    public String getTideLow() {
        return tideLow;
    }

    public void setTideLow(String tideLow) {
        this.tideLow = tideLow;
    }

    @Override
    public String toString() {
        return "GeneralForecastBo{" +
                "mmsi='" + mmsi + '\'' +
                ", sType='" + sType + '\'' +
                ", waveHigh='" + waveHigh + '\'' +
                ", waterTemperature='" + waterTemperature + '\'' +
                ", tideHighTime='" + tideHighTime + '\'' +
                ", tideHigh='" + tideHigh + '\'' +
                ", tideLowTime='" + tideLowTime + '\'' +
                ", tideLow='" + tideLow + '\'' +
                '}';
    }

    public GeneralForecastBo() {
    }

    public GeneralForecastBo(String mmsi, String sType, String waveHigh, String waterTemperature, String tideHighTime, String tideHigh, String tideLowTime, String tideLow) {
        this.mmsi = mmsi;
        this.sType = sType;
        this.waveHigh = waveHigh;
        this.waterTemperature = waterTemperature;
        this.tideHighTime = tideHighTime;
        this.tideHigh = tideHigh;
        this.tideLowTime = tideLowTime;
        this.tideLow = tideLow;
    }
}
