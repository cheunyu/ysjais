package com.scyb.aisbroadcast.bd.bo;

import java.sql.Timestamp;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2015/8/7
 * Time:13:20
 */
public class NumericalForecast {
    private String guid;
    private String forecastTime;
    private String windSpeedList;
    private String windDirectionList;
    private String waterSpeedList;
    private String waterDirectionList;
    private String waveHighList;
    private String waveDirectionList;
    private String bdMsg;
    private Timestamp createTime;
    private String mmsi;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getForecastTime() {
        return forecastTime;
    }

    public void setForecastTime(String forecastTime) {
        this.forecastTime = forecastTime;
    }

    public String getWindSpeedList() {
        return windSpeedList;
    }

    public void setWindSpeedList(String windSpeedList) {
        this.windSpeedList = windSpeedList;
    }

    public String getWindDirectionList() {
        return windDirectionList;
    }

    public void setWindDirectionList(String windDirectionList) {
        this.windDirectionList = windDirectionList;
    }

    public String getWaterSpeedList() {
        return waterSpeedList;
    }

    public void setWaterSpeedList(String waterSpeedList) {
        this.waterSpeedList = waterSpeedList;
    }

    public String getWaterDirectionList() {
        return waterDirectionList;
    }

    public void setWaterDirectionList(String waterDirectionList) {
        this.waterDirectionList = waterDirectionList;
    }

    public String getWaveHighList() {
        return waveHighList;
    }

    public void setWaveHighList(String waveHighList) {
        this.waveHighList = waveHighList;
    }

    public String getWaveDirectionList() {
        return waveDirectionList;
    }

    public void setWaveDirectionList(String waveDirectionList) {
        this.waveDirectionList = waveDirectionList;
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

    public String getMmsi() {
        return mmsi;
    }

    public void setMmsi(String mmsi) {
        this.mmsi = mmsi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NumericalForecast that = (NumericalForecast) o;

        if (guid != null ? !guid.equals(that.guid) : that.guid != null) return false;
        if (forecastTime != null ? !forecastTime.equals(that.forecastTime) : that.forecastTime != null) return false;
        if (windSpeedList != null ? !windSpeedList.equals(that.windSpeedList) : that.windSpeedList != null)
            return false;
        if (windDirectionList != null ? !windDirectionList.equals(that.windDirectionList) : that.windDirectionList != null)
            return false;
        if (waterSpeedList != null ? !waterSpeedList.equals(that.waterSpeedList) : that.waterSpeedList != null)
            return false;
        if (waterDirectionList != null ? !waterDirectionList.equals(that.waterDirectionList) : that.waterDirectionList != null)
            return false;
        if (waveHighList != null ? !waveHighList.equals(that.waveHighList) : that.waveHighList != null) return false;
        if (waveDirectionList != null ? !waveDirectionList.equals(that.waveDirectionList) : that.waveDirectionList != null)
            return false;
        if (bdMsg != null ? !bdMsg.equals(that.bdMsg) : that.bdMsg != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (mmsi != null ? !mmsi.equals(that.mmsi) : that.mmsi != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = guid != null ? guid.hashCode() : 0;
        result = 31 * result + (forecastTime != null ? forecastTime.hashCode() : 0);
        result = 31 * result + (windSpeedList != null ? windSpeedList.hashCode() : 0);
        result = 31 * result + (windDirectionList != null ? windDirectionList.hashCode() : 0);
        result = 31 * result + (waterSpeedList != null ? waterSpeedList.hashCode() : 0);
        result = 31 * result + (waterDirectionList != null ? waterDirectionList.hashCode() : 0);
        result = 31 * result + (waveHighList != null ? waveHighList.hashCode() : 0);
        result = 31 * result + (waveDirectionList != null ? waveDirectionList.hashCode() : 0);
        result = 31 * result + (bdMsg != null ? bdMsg.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (mmsi != null ? mmsi.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "NumericalForecast{" +
                "guid='" + guid + '\'' +
                ", forecastTime='" + forecastTime + '\'' +
                ", windSpeedList='" + windSpeedList + '\'' +
                ", windDirectionList='" + windDirectionList + '\'' +
                ", waterSpeedList='" + waterSpeedList + '\'' +
                ", waterDirectionList='" + waterDirectionList + '\'' +
                ", waveHighList='" + waveHighList + '\'' +
                ", waveDirectionList='" + waveDirectionList + '\'' +
                ", bdMsg='" + bdMsg + '\'' +
                ", createTime=" + createTime +
                ", mmsi='" + mmsi + '\'' +
                '}';
    }
}
