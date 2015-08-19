package com.scyb.aisbroadcast.bd.service.impl;

import com.scyb.aisbroadcast.bd.bo.LocationInfo;
import com.scyb.aisbroadcast.bd.dao.ILocationInfoDao;
import com.scyb.aisbroadcast.bd.service.ILocationInfoService;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2015/8/7
 * Time:10:36
 */
public class LocationInfoServiceImpl implements ILocationInfoService{

    private ILocationInfoDao locationInfoDaoImpl;

    public void setLocationInfoDaoImpl(ILocationInfoDao locationInfoDaoImpl) {
        this.locationInfoDaoImpl = locationInfoDaoImpl;
    }

    @Override
    public void addLocationInfoService(LocationInfo locationInfo) {
        locationInfoDaoImpl.saveLocationInfo(locationInfo);
    }

    @Override
    public LocationInfo getLocationInfoService() {
        return locationInfoDaoImpl.getLocationInfo();
    }
}
