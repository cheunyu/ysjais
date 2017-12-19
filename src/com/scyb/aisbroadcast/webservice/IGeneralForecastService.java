package com.scyb.aisbroadcast.webservice;


import com.scyb.aisbroadcast.webservice.bo.GeneralForecastBo;

import javax.jws.WebService;
import javax.xml.ws.BindingType;

/**
 * Created by foo on 2017/6/29.
 * 常规预报WebService服务接口
 */
@WebService @BindingType(value = "http://www.w3.org/2003/05/soap/bindings/HTTP/")
public interface IGeneralForecastService {

    /**
     * 接收常规预报数据
     * */
    public int generalForecastService(GeneralForecastBo generalForecastBo);
}
