package com.scyb.aisbroadcast.ais.service.impl;

import com.scyb.aisbroadcast.ais.service.IAisMsgCommondService;
import com.scyb.aisbroadcast.ais.service.IAisMsgForecastService;
import com.scyb.aisbroadcast.ais.service.ISendMessageService;
import com.scyb.aisbroadcast.ais.util.CharacterConvertAisCodeUtil;
import com.scyb.aisbroadcast.ais.util.SerialDataUtil;
import com.scyb.aisbroadcast.webservice.bo.GeneralForecastBo;
import com.scyb.aisbroadcast.webservice.bo.MessageBo;
import com.scyb.aisbroadcast.webservice.bo.NumericalForecastBo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by foo on 2017/7/3.
 */
public class AisMsgCommondServiceImpl implements IAisMsgCommondService {

    private IAisMsgForecastService aisMsgForecastServiceImpl;
    private ISendMessageService sendMessageServiceImpl;
    private CharacterConvertAisCodeUtil characterConvertAisCodeUtil;
    private SerialDataUtil serialDataUtil;
    private Logger log = Logger.getLogger(this.getClass());

    public void setAisMsgForecastServiceImpl(IAisMsgForecastService aisMsgForecastServiceImpl) {
        this.aisMsgForecastServiceImpl = aisMsgForecastServiceImpl;
    }

    public void setSendMessageServiceImpl(ISendMessageService sendMessageServiceImpl) {
        this.sendMessageServiceImpl = sendMessageServiceImpl;
    }

    public void setCharacterConvertAisCodeUtil(CharacterConvertAisCodeUtil characterConvertAisCodeUtil) {
        this.characterConvertAisCodeUtil = characterConvertAisCodeUtil;
    }

    public void setSerialDataUtil(SerialDataUtil serialDataUtil) {
        this.serialDataUtil = serialDataUtil;
    }

    @Override
    public int generalForecastCommond(GeneralForecastBo generalForecastBo) {
        String generalForecastMsg = aisMsgForecastServiceImpl.generalForecastMsg(generalForecastBo);
        log.info(generalForecastMsg);
        /*ASCII、汉字转AIS收发码方法*/
        String iecCode = characterConvertAisCodeUtil.convertAisCode(generalForecastMsg);
        List<String> aisMsgList = new ArrayList<String>();
        if("-1".equals(generalForecastBo.getsType())) {
            aisMsgList = serialDataUtil.generationBBM(iecCode);
        }else {
            aisMsgList = serialDataUtil.generationABM(iecCode, generalForecastBo.getMmsi());
        }
        sendMessageServiceImpl.sendMessages(aisMsgList);
        return 0;
    }

    @Override
    public int numericalForecastCommond(List<NumericalForecastBo> numericalForecastBoList) {
        List<String> numericalForecastList = aisMsgForecastServiceImpl.numericalForecastMsg(numericalForecastBoList);
        List<String> aisMsgList = new ArrayList<String>();
        for (int i = 0; i < numericalForecastList.size(); i++) {
            log.info(numericalForecastList.get(i));
            /*ASCII、汉字转AIS收发码方法*/
            String iecCode = characterConvertAisCodeUtil.convertAisCode(numericalForecastList.get(i));
            if("-1".equals(numericalForecastBoList.get(0).getsType())) {
                aisMsgList = serialDataUtil.generationBBM(iecCode);
            }else {
                aisMsgList = serialDataUtil.generationABM(iecCode, numericalForecastBoList.get(0).getMmsi());
            }
            sendMessageServiceImpl.sendMessages(aisMsgList);
        }
        return 0;
    }

    /**
     * 短消息控制
     *
     * @param msgBo
     */
    @Override
    public int messageCommond(MessageBo msgBo) {
        log.info(msgBo.getContent());
        /*ASCII、汉字转AIS收发码方法*/
        String iecCode = characterConvertAisCodeUtil.convertAisCode(msgBo.getContent());
        List<String> aisMsgList = new ArrayList<String>();
        if("-1".equals(msgBo.getsType())) {
            aisMsgList = serialDataUtil.generationBBM(iecCode);
        }else {
            aisMsgList = serialDataUtil.generationABM(iecCode, msgBo.getMmsi());
        }
        sendMessageServiceImpl.sendMessages(aisMsgList);
        return 0;
    }
}
