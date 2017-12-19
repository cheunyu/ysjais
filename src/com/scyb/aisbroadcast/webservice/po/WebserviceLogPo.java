package com.scyb.aisbroadcast.webservice.po;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by foo on 2017/6/30.
 */
@Entity
@Table(name = "webservice_log", schema = "ysjais", catalog = "")
public class WebserviceLogPo {
    private long logId;
    private String content;
    private Timestamp createTime;

    @Id
    @Column(name = "LOG_ID")
    public long getLogId() {
        return logId;
    }

    public void setLogId(long logId) {
        this.logId = logId;
    }

    @Basic
    @Column(name = "CONTENT")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "CREATE_TIME")
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

        WebserviceLogPo that = (WebserviceLogPo) o;

        if (logId != that.logId) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (logId ^ (logId >>> 32));
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
