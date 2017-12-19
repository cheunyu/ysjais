package com.scyb.aisbroadcast.webservice.impl;

import com.scyb.aisbroadcast.ais.service.IAisMsgCommondService;
import com.scyb.aisbroadcast.ais.service.IAisMsgForecastService;
import com.scyb.aisbroadcast.webservice.IGeneralForecastService;
import com.scyb.aisbroadcast.webservice.bo.GeneralForecastBo;
import com.scyb.aisbroadcast.webservice.service.IWebserviceService;
import org.apache.log4j.Logger;

import javax.jws.WebService;

/**
 * Created by foo on 2017/6/29.
 * 常规预报WebService服务接口实现类
 */
@WebService(endpointInterface = "com.scyb.aisbroadcast.webservice.IGeneralForecastService")
public class GeneralForecastServiceImpl implements IGeneralForecastService {

    private Logger log = Logger.getLogger(this.getClass());
    private IWebserviceService webserviceServiceImpl;
    private IAisMsgForecastService aisMsgForecastServiceImpl;
    private IAisMsgCommondService aisMsgCommondServiceImpl;

    public void setWebserviceServiceImpl(IWebserviceService webserviceServiceImpl) {
        this.webserviceServiceImpl = webserviceServiceImpl;
    }

    public void setAisMsgForecastServiceImpl(IAisMsgForecastService aisMsgForecastServiceImpl) {
        this.aisMsgForecastServiceImpl = aisMsgForecastServiceImpl;
    }

    public void setAisMsgCommondServiceImpl(IAisMsgCommondService aisMsgCommondServiceImpl) {
        this.aisMsgCommondServiceImpl = aisMsgCommondServiceImpl;
    }

    @Override
    public int generalForecastService(GeneralForecastBo generalForecastBo) {
        log.info("服务被调用,接收数据:" + generalForecastBo.toString());
        try {
            webserviceServiceImpl.saveWebserviceService(generalForecastBo.toString());
        }catch (Exception e){
            return 1;
        }
        aisMsgCommondServiceImpl.generalForecastCommond(generalForecastBo);
        return 0;
    }
}
