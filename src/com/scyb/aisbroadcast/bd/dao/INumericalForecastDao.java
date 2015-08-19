package com.scyb.aisbroadcast.bd.dao;

import com.scyb.aisbroadcast.bd.bo.NumericalForecast;
import com.scyb.aisbroadcast.common.dao.IBaseDao;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2015/8/4
 * Time:10:42
 */
public interface INumericalForecastDao extends IBaseDao {

    public void saveNumericalForecast(NumericalForecast numericalForecast);
}
