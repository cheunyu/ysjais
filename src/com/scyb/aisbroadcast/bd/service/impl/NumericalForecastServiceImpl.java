package com.scyb.aisbroadcast.bd.service.impl;

import com.scyb.aisbroadcast.ais.service.IAisMsgForecastService;
import com.scyb.aisbroadcast.ais.service.ISendMessageService;
import com.scyb.aisbroadcast.ais.util.CharacterConvertAisCodeUtil;
import com.scyb.aisbroadcast.ais.util.SerialDataUtil;
import com.scyb.aisbroadcast.bd.bo.NumericalForecast;
import com.scyb.aisbroadcast.bd.dao.INumericalForecastDao;
import com.scyb.aisbroadcast.bd.service.INumericalForecastService;
import com.scyb.aisbroadcast.common.bo.GlobalVariable;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2015/8/4
 * Time:10:42
 */
public class NumericalForecastServiceImpl implements INumericalForecastService {

    private INumericalForecastDao numericalForecastDaoImpl;
    private IAisMsgForecastService aisMsgForecastServiceImpl;
    private CharacterConvertAisCodeUtil characterConvertAisCodeUtil;
    private SerialDataUtil serialDataUtil;
    private ISendMessageService sendMessageServiceImpl;
    private Logger log = Logger.getLogger(this.getClass());


    public void setAisMsgForecastServiceImpl(IAisMsgForecastService aisMsgForecastServiceImpl) {
        this.aisMsgForecastServiceImpl = aisMsgForecastServiceImpl;
    }

    public void setNumericalForecastDaoImpl(INumericalForecastDao numericalForecastDaoImpl) {
        this.numericalForecastDaoImpl = numericalForecastDaoImpl;
    }

    public void setCharacterConvertAisCodeUtil(CharacterConvertAisCodeUtil characterConvertAisCodeUtil) {
        this.characterConvertAisCodeUtil = characterConvertAisCodeUtil;
    }

    public void setSerialDataUtil(SerialDataUtil serialDataUtil) {
        this.serialDataUtil = serialDataUtil;
    }

    public void setSendMessageServiceImpl(ISendMessageService sendMessageServiceImpl) {
        this.sendMessageServiceImpl = sendMessageServiceImpl;
    }

    @Override
    public void addNumericalForcastService(NumericalForecast numericalForecast) {
        numericalForecastDaoImpl.saveNumericalForecast(numericalForecast);
    }

    @Override
    public void sendNumericalForcastService(NumericalForecast numericalForecast) {
//        List<String> numericalForecastList = aisMsgForecastServiceImpl.numericalForecastMsg(numericalForecast);
//        for (int i = 0; i < numericalForecastList.size(); i++) {
//            String iecCode = characterConvertAisCodeUtil.convertAisCode(numericalForecastList.get(i));
//            List<String> aisMsgList = serialDataUtil.generationABM(iecCode, numericalForecast.getMmsi());
//            sendMessageServiceImpl.sendMessages(aisMsgList);
//        }
    }

    @Override
    public void sendNumericalForecastPlanService() {
        if (GlobalVariable.getNumericalForecastMsgList().size() > 0) {
            for (int i = 0; i < GlobalVariable.getNumericalForecastMsgList().size(); i++) {
                String iecCode = characterConvertAisCodeUtil.convertAisCode(GlobalVariable.getNumericalForecastMsgList().get(i));
                List<String> aisMsgList = serialDataUtil.generationBBM(iecCode);
                sendMessageServiceImpl.sendMessages(aisMsgList);
            }
        }
    }
}
