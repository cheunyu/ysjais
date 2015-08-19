package com.scyb.aisbroadcast.bd.dao.impl;

import com.scyb.aisbroadcast.bd.bo.LocationInfo;
import com.scyb.aisbroadcast.bd.dao.ILocationInfoDao;
import com.scyb.aisbroadcast.common.dao.impl.BaseDaoImpl;

import java.util.List;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2015/8/7
 * Time:10:38
 */
public class LocationInfoDaoImpl extends BaseDaoImpl implements ILocationInfoDao{

    @Override
    public void saveLocationInfo(LocationInfo locationInfo) {
        super.save(locationInfo);
    }

    @Override
    public LocationInfo getLocationInfo() {
        String hql = "from LocationInfo";
        List<LocationInfo> locationInfoList = super.queryList(hql);
        return locationInfoList.get(0);
    }
}
