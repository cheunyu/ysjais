package com.scyb.aisbroadcast.webservice.service.impl;

import com.scyb.aisbroadcast.webservice.dao.IWebserviceDao;
import com.scyb.aisbroadcast.webservice.po.WebserviceLogPo;
import com.scyb.aisbroadcast.webservice.service.IWebserviceService;
import org.apache.log4j.Logger;


/**
 * Created by foo on 2017/6/30.
 */
public class WebserviceServiceImpl implements IWebserviceService{

    private Logger log = Logger.getLogger(this.getClass());
    private IWebserviceDao webserviceDaoImpl;
    private WebserviceLogPo webserviceLogPo = new WebserviceLogPo();

    public void setWebserviceDaoImpl(IWebserviceDao webserviceDaoImpl) {
        this.webserviceDaoImpl = webserviceDaoImpl;
    }

    @Override
    public int saveWebserviceService(String data) {
        webserviceLogPo.setContent(data);
        try {
            webserviceDaoImpl.saveWebserviceLog(webserviceLogPo);
        }catch (Exception e) {
            log.info(e.getMessage());
            return 1;
        }
        return 0;
    }
}
