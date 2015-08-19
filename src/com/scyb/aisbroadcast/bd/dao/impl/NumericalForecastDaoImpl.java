package com.scyb.aisbroadcast.bd.dao.impl;

import com.scyb.aisbroadcast.bd.bo.NumericalForecast;
import com.scyb.aisbroadcast.bd.dao.INumericalForecastDao;
import com.scyb.aisbroadcast.common.dao.impl.BaseDaoImpl;
import org.apache.log4j.Logger;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2015/8/4
 * Time:10:43
 */
public class NumericalForecastDaoImpl extends BaseDaoImpl implements INumericalForecastDao {

    private Logger log = Logger.getLogger(this.getClass());
    @Override
    public void saveNumericalForecast(NumericalForecast numericalForecast) {
        super.save(numericalForecast);
    }
}
