package com.scyb.aisbroadcast.webservice.impl;

import com.scyb.aisbroadcast.ais.service.IAisMsgCommondService;
import com.scyb.aisbroadcast.ais.service.IAisMsgForecastService;
import com.scyb.aisbroadcast.webservice.IMessageService;
import com.scyb.aisbroadcast.webservice.bo.MessageBo;
import com.scyb.aisbroadcast.webservice.service.IWebserviceService;
import org.apache.log4j.Logger;

import javax.jws.WebService;

/**
 * Created by foo on 2017/6/30.
 */
@WebService(endpointInterface ="com.scyb.aisbroadcast.webservice.IMessageService")
public class MessageServiceImpl implements IMessageService {

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
    public int messageService(MessageBo msgBo) {
        log.info("服务被调用,接收数据:" + msgBo.toString());
        webserviceServiceImpl.saveWebserviceService(msgBo.toString());
        aisMsgCommondServiceImpl.messageCommond(msgBo);
        return 0;
    }
}
