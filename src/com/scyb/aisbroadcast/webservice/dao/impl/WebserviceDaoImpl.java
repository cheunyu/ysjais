package com.scyb.aisbroadcast.webservice.dao.impl;

import com.scyb.aisbroadcast.common.dao.impl.BaseDaoImpl;
import com.scyb.aisbroadcast.webservice.dao.IWebserviceDao;
import com.scyb.aisbroadcast.webservice.po.WebserviceLogPo;
import org.apache.log4j.Logger;

/**
 * Created by foo on 2017/6/30.
 */
public class WebserviceDaoImpl extends BaseDaoImpl implements IWebserviceDao{

    private Logger log = Logger.getLogger(this.getClass());

    @Override
    public boolean saveWebserviceLog(WebserviceLogPo WebservicePo) {
        super.save(WebservicePo);
        return false;
    }
}
