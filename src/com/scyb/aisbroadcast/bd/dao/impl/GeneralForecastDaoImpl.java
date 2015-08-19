package com.scyb.aisbroadcast.bd.dao.impl;

import com.scyb.aisbroadcast.bd.bo.GeneralForecast;
import com.scyb.aisbroadcast.bd.dao.IGeneralForecastDao;
import com.scyb.aisbroadcast.common.dao.impl.BaseDaoImpl;
import org.apache.log4j.Logger;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2015/7/30
 * Time:16:27
 */
public class GeneralForecastDaoImpl extends BaseDaoImpl implements IGeneralForecastDao {

    private Logger log = Logger.getLogger(this.getClass());

    @Override
    public void saveGeneralForecast(GeneralForecast gf) {
        super.save(gf);
    }
}
