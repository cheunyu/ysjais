package com.scyb.aisbroadcast.bd.dao;

import com.scyb.aisbroadcast.bd.bo.GeneralForecast;
import com.scyb.aisbroadcast.common.dao.IBaseDao;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2015/7/30
 * Time:16:25
 */
public interface IGeneralForecastDao extends IBaseDao {

    public void saveGeneralForecast(GeneralForecast gf);
}
