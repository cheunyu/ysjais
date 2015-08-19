package com.scyb.aisbroadcast.bd.bo;

import java.sql.Timestamp;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2015/7/29
 * Time:14:04
 */
public class GeneralForecast {
    private String guid;
    private String mmsi;
    private String waveHigh;
    private String waterTemperature;
    private String tideHighTime;
    private String tideHigh;
    private String tideLowTime;
    private String tideLow;
    private String bdMsg;
    private Timestamp createTime;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
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

    public String getBdMsg() {
        return bdMsg;
    }

    public void setBdMsg(String bdMsg) {
        this.bdMsg = bdMsg;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeneralForecast that = (GeneralForecast) o;

        if (!guid.equals(that.guid)) return false;
        if (!mmsi.equals(that.mmsi)) return false;
        if (!waveHigh.equals(that.waveHigh)) return false;
        if (!waterTemperature.equals(that.waterTemperature)) return false;
        if (!tideHighTime.equals(that.tideHighTime)) return false;
        if (!tideHigh.equals(that.tideHigh)) return false;
        if (!tideLowTime.equals(that.tideLowTime)) return false;
        if (!tideLow.equals(that.tideLow)) return false;
        if (!bdMsg.equals(that.bdMsg)) return false;
        return createTime.equals(that.createTime);

    }

    @Override
    public int hashCode() {
        int result = guid.hashCode();
        result = 31 * result + mmsi.hashCode();
        result = 31 * result + waveHigh.hashCode();
        result = 31 * result + waterTemperature.hashCode();
        result = 31 * result + tideHighTime.hashCode();
        result = 31 * result + tideHigh.hashCode();
        result = 31 * result + tideLowTime.hashCode();
        result = 31 * result + tideLow.hashCode();
        result = 31 * result + bdMsg.hashCode();
        result = 31 * result + createTime.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "GeneralForecast{}";
    }

    public GeneralForecast() {
    }

    public GeneralForecast(String guid, String mmsi, String waveHigh, String waterTemperature, String tideHighTime, String tideHigh, String tideLowTime, String tideLow, String bdMsg, Timestamp createTime) {
        this.guid = guid;
        this.mmsi = mmsi;
        this.waveHigh = waveHigh;
        this.waterTemperature = waterTemperature;
        this.tideHighTime = tideHighTime;
        this.tideHigh = tideHigh;
        this.tideLowTime = tideLowTime;
        this.tideLow = tideLow;
        this.bdMsg = bdMsg;
        this.createTime = createTime;
    }
}
