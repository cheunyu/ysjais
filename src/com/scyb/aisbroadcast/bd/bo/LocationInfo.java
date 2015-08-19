package com.scyb.aisbroadcast.bd.bo;

import java.sql.Timestamp;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2015/8/6
 * Time:9:12
 */
public class LocationInfo {
    private String guid;
    private String l1Latitude;
    private String l1Longitude;
    private String l2Latitude;
    private String l2Longitude;
    private String l3Latitude;
    private String l3Longitude;
    private String l4Latitude;
    private String l4Longitude;
    private String l5Latitude;
    private String l5Longitude;
    private Timestamp createTime;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getL1Latitude() {
        return l1Latitude;
    }

    public void setL1Latitude(String l1Latitude) {
        this.l1Latitude = l1Latitude;
    }

    public String getL1Longitude() {
        return l1Longitude;
    }

    public void setL1Longitude(String l1Longitude) {
        this.l1Longitude = l1Longitude;
    }

    public String getL2Latitude() {
        return l2Latitude;
    }

    public void setL2Latitude(String l2Latitude) {
        this.l2Latitude = l2Latitude;
    }

    public String getL2Longitude() {
        return l2Longitude;
    }

    public void setL2Longitude(String l2Longitude) {
        this.l2Longitude = l2Longitude;
    }

    public String getL3Latitude() {
        return l3Latitude;
    }

    public void setL3Latitude(String l3Latitude) {
        this.l3Latitude = l3Latitude;
    }

    public String getL3Longitude() {
        return l3Longitude;
    }

    public void setL3Longitude(String l3Longitude) {
        this.l3Longitude = l3Longitude;
    }

    public String getL4Latitude() {
        return l4Latitude;
    }

    public void setL4Latitude(String l4Latitude) {
        this.l4Latitude = l4Latitude;
    }

    public String getL4Longitude() {
        return l4Longitude;
    }

    public void setL4Longitude(String l4Longitude) {
        this.l4Longitude = l4Longitude;
    }

    public String getL5Latitude() {
        return l5Latitude;
    }

    public void setL5Latitude(String l5Latitude) {
        this.l5Latitude = l5Latitude;
    }

    public String getL5Longitude() {
        return l5Longitude;
    }

    public void setL5Longitude(String l5Longitude) {
        this.l5Longitude = l5Longitude;
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

        LocationInfo that = (LocationInfo) o;

        if (guid != null ? !guid.equals(that.guid) : that.guid != null) return false;
        if (l1Latitude != null ? !l1Latitude.equals(that.l1Latitude) : that.l1Latitude != null) return false;
        if (l1Longitude != null ? !l1Longitude.equals(that.l1Longitude) : that.l1Longitude != null) return false;
        if (l2Latitude != null ? !l2Latitude.equals(that.l2Latitude) : that.l2Latitude != null) return false;
        if (l2Longitude != null ? !l2Longitude.equals(that.l2Longitude) : that.l2Longitude != null) return false;
        if (l3Latitude != null ? !l3Latitude.equals(that.l3Latitude) : that.l3Latitude != null) return false;
        if (l3Longitude != null ? !l3Longitude.equals(that.l3Longitude) : that.l3Longitude != null) return false;
        if (l4Latitude != null ? !l4Latitude.equals(that.l4Latitude) : that.l4Latitude != null) return false;
        if (l4Longitude != null ? !l4Longitude.equals(that.l4Longitude) : that.l4Longitude != null) return false;
        if (l5Latitude != null ? !l5Latitude.equals(that.l5Latitude) : that.l5Latitude != null) return false;
        if (l5Longitude != null ? !l5Longitude.equals(that.l5Longitude) : that.l5Longitude != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = guid != null ? guid.hashCode() : 0;
        result = 31 * result + (l1Latitude != null ? l1Latitude.hashCode() : 0);
        result = 31 * result + (l1Longitude != null ? l1Longitude.hashCode() : 0);
        result = 31 * result + (l2Latitude != null ? l2Latitude.hashCode() : 0);
        result = 31 * result + (l2Longitude != null ? l2Longitude.hashCode() : 0);
        result = 31 * result + (l3Latitude != null ? l3Latitude.hashCode() : 0);
        result = 31 * result + (l3Longitude != null ? l3Longitude.hashCode() : 0);
        result = 31 * result + (l4Latitude != null ? l4Latitude.hashCode() : 0);
        result = 31 * result + (l4Longitude != null ? l4Longitude.hashCode() : 0);
        result = 31 * result + (l5Latitude != null ? l5Latitude.hashCode() : 0);
        result = 31 * result + (l5Longitude != null ? l5Longitude.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LocationInfo{" +
                "guid='" + guid + '\'' +
                ", l1Latitude='" + l1Latitude + '\'' +
                ", l1Longitude='" + l1Longitude + '\'' +
                ", l2Latitude='" + l2Latitude + '\'' +
                ", l2Longitude='" + l2Longitude + '\'' +
                ", l3Latitude='" + l3Latitude + '\'' +
                ", l3Longitude='" + l3Longitude + '\'' +
                ", l4Latitude='" + l4Latitude + '\'' +
                ", l4Longitude='" + l4Longitude + '\'' +
                ", l5Latitude='" + l5Latitude + '\'' +
                ", l5Longitude='" + l5Longitude + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
