package com.scyb.aisbroadcast.webservice;


import com.scyb.aisbroadcast.webservice.bo.MessageBo;

import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

/**
 * Created by foo on 2017/6/30.
 */
@WebService @BindingType(value = SOAPBinding.SOAP12HTTP_BINDING)
public interface IMessageService {

    public int messageService(MessageBo msgBo);
}
