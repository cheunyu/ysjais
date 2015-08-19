package com.scyb.aisbroadcast.bd.service.impl;

import com.scyb.aisbroadcast.ais.service.ISendMessageService;
import com.scyb.aisbroadcast.ais.util.CharacterConvertAisCodeUtil;
import com.scyb.aisbroadcast.ais.util.SerialDataUtil;
import com.scyb.aisbroadcast.bd.bo.Message;
import com.scyb.aisbroadcast.bd.dao.IMessageDao;
import com.scyb.aisbroadcast.bd.service.IMessageService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2015/8/17
 * Time:10:47
 */
public class MessageServiceImpl implements IMessageService {

    private IMessageDao messageDaoImpl;
    private CharacterConvertAisCodeUtil characterConvertAisCodeUtil;
    private ISendMessageService sendMessageServiceImpl;
    private SerialDataUtil serialDataUtil;

    public void setCharacterConvertAisCodeUtil(CharacterConvertAisCodeUtil characterConvertAisCodeUtil) {
        this.characterConvertAisCodeUtil = characterConvertAisCodeUtil;
    }

    public void setSendMessageServiceImpl(ISendMessageService sendMessageServiceImpl) {
        this.sendMessageServiceImpl = sendMessageServiceImpl;
    }

    public void setSerialDataUtil(SerialDataUtil serialDataUtil) {
        this.serialDataUtil = serialDataUtil;
    }

    public void setMessageDaoImpl(IMessageDao messageDaoImpl) {
        this.messageDaoImpl = messageDaoImpl;
    }

    @Override
    public void addMessageService(Message message) {
        messageDaoImpl.saveMessage(message);
    }

    @Override
    public void sendMessageService(Message message) {
        String iecCode = characterConvertAisCodeUtil.convertAisCode(message.getContent());
        List<String> aisMsgList = new ArrayList<String>();
        if("0".equals(message.getMmsi())) {
            aisMsgList = serialDataUtil.generationBBM(iecCode);
        }else {
            aisMsgList = serialDataUtil.generationABM(iecCode, message.getMmsi());
        }
        sendMessageServiceImpl.sendMessages(aisMsgList);
    }
}
