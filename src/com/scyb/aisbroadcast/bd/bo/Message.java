package com.scyb.aisbroadcast.bd.bo;

import java.sql.Timestamp;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2015/8/17
 * Time:10:45
 */
public class Message {
    private String guid;
    private String mmsi;
    private String content;
    private String bdMsg;
    private Timestamp createTime;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
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

        Message message = (Message) o;

        if (guid != null ? !guid.equals(message.guid) : message.guid != null) return false;
        if (mmsi != null ? !mmsi.equals(message.mmsi) : message.mmsi != null) return false;
        if (content != null ? !content.equals(message.content) : message.content != null) return false;
        if (bdMsg != null ? !bdMsg.equals(message.bdMsg) : message.bdMsg != null) return false;
        if (createTime != null ? !createTime.equals(message.createTime) : message.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = guid != null ? guid.hashCode() : 0;
        result = 31 * result + (mmsi != null ? mmsi.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (bdMsg != null ? bdMsg.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
