package com.scyb.aisbroadcast.webservice.bo;

import java.sql.Timestamp;

/**
 * Created by foo on 2017/6/30.
 */
public class MessageBo {

    private String mmsi;
    private String sType;
    private String content;

    public MessageBo() {
    }

    public MessageBo(String mmsi, String sType, String content) {
        this.mmsi = mmsi;
        this.sType = sType;
        this.content = content;
    }

    public String getMmsi() {
        return mmsi;
    }

    public void setMmsi(String mmsi) {
        this.mmsi = mmsi;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getsType() {
        return sType;
    }

    public void setsType(String sType) {
        this.sType = sType;
    }

    @Override
    public String toString() {
        return "MessageBo{" +
                "mmsi='" + mmsi + '\'' +
                ", sType='" + sType + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
