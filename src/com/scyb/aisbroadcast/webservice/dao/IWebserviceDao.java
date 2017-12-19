package com.scyb.aisbroadcast.webservice.dao;

import com.scyb.aisbroadcast.common.dao.IBaseDao;
import com.scyb.aisbroadcast.webservice.po.WebserviceLogPo;

/**
 * Created by foo on 2017/6/30.
 */
public interface IWebserviceDao extends IBaseDao{

    /**
     * 存储Webservice记录到日记表
     * */
    public boolean saveWebserviceLog(WebserviceLogPo WebservicePo);
}
