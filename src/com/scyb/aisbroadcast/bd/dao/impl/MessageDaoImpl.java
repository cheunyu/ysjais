package com.scyb.aisbroadcast.bd.dao.impl;

import com.scyb.aisbroadcast.bd.bo.Message;
import com.scyb.aisbroadcast.bd.dao.IMessageDao;
import com.scyb.aisbroadcast.common.dao.impl.BaseDaoImpl;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2015/8/17
 * Time:10:48
 */
public class MessageDaoImpl extends BaseDaoImpl implements IMessageDao {

    @Override
    public void saveMessage(Message message) {
        super.save(message);
    }
}
