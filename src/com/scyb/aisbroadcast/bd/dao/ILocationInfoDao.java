package com.scyb.aisbroadcast.bd.dao;

import com.scyb.aisbroadcast.bd.bo.LocationInfo;
import com.scyb.aisbroadcast.common.dao.IBaseDao;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2015/8/7
 * Time:10:37
 */
public interface ILocationInfoDao extends IBaseDao{

    public void saveLocationInfo(LocationInfo locationInfo);

    public LocationInfo getLocationInfo();
}
