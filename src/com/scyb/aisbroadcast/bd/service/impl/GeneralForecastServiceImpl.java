package com.scyb.aisbroadcast.bd.service.impl;

import com.scyb.aisbroadcast.ais.service.IAisMsgForecastService;
import com.scyb.aisbroadcast.ais.service.ISendMessageService;
import com.scyb.aisbroadcast.ais.util.CharacterConvertAisCodeUtil;
import com.scyb.aisbroadcast.ais.util.SerialDataUtil;
import com.scyb.aisbroadcast.bd.bo.GeneralForecast;
import com.scyb.aisbroadcast.bd.dao.IGeneralForecastDao;
import com.scyb.aisbroadcast.bd.service.IGeneralForecastService;
import com.scyb.aisbroadcast.common.bo.GlobalVariable;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2015/7/31
 * Time:10:57
 */
public class GeneralForecastServiceImpl implements IGeneralForecastService {

    private Logger log = Logger.getLogger(this.getClass());
    private IGeneralForecastDao generalForecastDaoImpl;
    private IAisMsgForecastService aisMsgForecastServiceImpl;
    private CharacterConvertAisCodeUtil characterConvertAisCodeUtil;
    private SerialDataUtil serialDataUtil;
    private ISendMessageService sendMessageServiceImpl;

    public void setSendMessageServiceImpl(ISendMessageService sendMessageServiceImpl) {
        this.sendMessageServiceImpl = sendMessageServiceImpl;
    }

    public void setSerialDataUtil(SerialDataUtil serialDataUtil) {
        this.serialDataUtil = serialDataUtil;
    }

    public void setCharacterConvertAisCodeUtil(CharacterConvertAisCodeUtil characterConvertAisCodeUtil) {
        this.characterConvertAisCodeUtil = characterConvertAisCodeUtil;
    }

    public void setAisMsgForecastServiceImpl(IAisMsgForecastService aisMsgForecastServiceImpl) {
        this.aisMsgForecastServiceImpl = aisMsgForecastServiceImpl;
    }

    public void setGeneralForecastDaoImpl(IGeneralForecastDao generalForecastDaoImpl) {
        this.generalForecastDaoImpl = generalForecastDaoImpl;
    }

    @Override
    public void addGeneralForcastService(GeneralForecast generalForecast) {
        generalForecastDaoImpl.saveGeneralForecast(generalForecast);
    }

    @Override
    public void sendGeneralForcastService(GeneralForecast generalForecast) {
        String msg = aisMsgForecastServiceImpl.generalForecastMsg(generalForecast);
        String iecCode = characterConvertAisCodeUtil.convertAisCode(msg);
        List<String> aisMsgList = serialDataUtil.generationABM(iecCode, generalForecast.getMmsi());
        sendMessageServiceImpl.sendMessages(aisMsgList);
    }

    @Override
    public void sendGeneralForecastPlanService() {
        if(!"".equals(GlobalVariable.getGeneralForecastMsg())) {
            String iecCode = characterConvertAisCodeUtil.convertAisCode(GlobalVariable.getGeneralForecastMsg());
            List<String> aisMsgList = serialDataUtil.generationBBM(iecCode);
            sendMessageServiceImpl.sendMessages(aisMsgList);
        }
    }
}