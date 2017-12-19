package com.scyb.aisbroadcast.ais.service;

import com.scyb.aisbroadcast.webservice.bo.GeneralForecastBo;
import com.scyb.aisbroadcast.webservice.bo.MessageBo;
import com.scyb.aisbroadcast.webservice.bo.NumericalForecastBo;

import java.util.List;

/**
 * Created by foo on 2017/7/3.
 */
public interface IAisMsgCommondService {

    /**
     * 常规预报AIS消息控制
     * */
    public int generalForecastCommond(GeneralForecastBo generalForecastBo);

    /**
     * 数值预报AIS消息控制
     * */
    public int numericalForecastCommond(List<NumericalForecastBo> numericalForecastBoList);

    /**
     * 短消息控制
     * */
    public int messageCommond(MessageBo msgBo);
}
