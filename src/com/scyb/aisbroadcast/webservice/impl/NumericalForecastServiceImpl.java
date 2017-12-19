package com.scyb.aisbroadcast.webservice.impl;

import com.scyb.aisbroadcast.ais.service.IAisMsgCommondService;
import com.scyb.aisbroadcast.webservice.INumericalForecastService;
import com.scyb.aisbroadcast.webservice.bo.NumericalForecastBo;
import com.scyb.aisbroadcast.webservice.service.IWebserviceService;
import org.apache.log4j.Logger;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by foo on 2017/6/29.
 */
@WebService(endpointInterface = "com.scyb.aisbroadcast.webservice.INumericalForecastService")
public class NumericalForecastServiceImpl implements INumericalForecastService {

    private Logger log = Logger.getLogger(this.getClass());
    private IWebserviceService webserviceServiceImpl;
    private IAisMsgCommondService aisMsgCommondServiceImpl;

    public void setWebserviceServiceImpl(IWebserviceService webserviceServiceImpl) {
        this.webserviceServiceImpl = webserviceServiceImpl;
    }

    public void setAisMsgCommondServiceImpl(IAisMsgCommondService aisMsgCommondServiceImpl) {
        this.aisMsgCommondServiceImpl = aisMsgCommondServiceImpl;
    }

    @Override
    public int numericalForecastService(List<NumericalForecastBo> numericalForecastBoList) {
        int resuleValue = 0;
        log.info("服务被调用,接收数据:" + numericalForecastBoList.toString());
        resuleValue = webserviceServiceImpl.saveWebserviceService(numericalForecastBoList.toString());
        aisMsgCommondServiceImpl.numericalForecastCommond(numericalForecastBoList);
        return resuleValue;
    }
}
