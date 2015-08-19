package com.scyb.aisbroadcast.bd.service;


import com.scyb.aisbroadcast.bd.bo.GeneralForecast;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2015/7/31
 * Time:10:57
 */
public interface IGeneralForecastService {

    /**
     *  保存常规预报
     */
    public void addGeneralForcastService(GeneralForecast generalForecast);

    /**
     *  发送常规预报
     * */
    public void sendGeneralForcastService(GeneralForecast generalForecast);

    /**
     *  定时播发预报
     * */
    public void sendGeneralForecastPlanService();
}
