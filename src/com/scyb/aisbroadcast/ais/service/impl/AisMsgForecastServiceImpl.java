package com.scyb.aisbroadcast.ais.service.impl;

import com.scyb.aisbroadcast.ais.service.IAisMsgForecastService;
import com.scyb.aisbroadcast.bd.bo.GeneralForecast;
import com.scyb.aisbroadcast.bd.bo.LocationInfo;
import com.scyb.aisbroadcast.bd.bo.NumericalForecast;
import com.scyb.aisbroadcast.bd.service.ILocationInfoService;
import com.scyb.aisbroadcast.bd.service.INumericalForecastService;
import com.scyb.aisbroadcast.common.util.ConvertUtil;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2015/8/4
 * Time:10:53
 */
public class AisMsgForecastServiceImpl implements IAisMsgForecastService {

    private Logger log = Logger.getLogger(this.getClass());
    private ConvertUtil convertUtil;
    private ILocationInfoService locationInfoServiceImpl;

    public void setConvertUtil(ConvertUtil convertUtil) {
        this.convertUtil = convertUtil;
    }

    public void setLocationInfoServiceImpl(ILocationInfoService locationInfoServiceImpl) {
        this.locationInfoServiceImpl = locationInfoServiceImpl;
    }

    @Override
    public String generalForecastMsg(GeneralForecast generalForecast) {
        StringBuffer sb = new StringBuffer();
        sb.append("ROUTINE FORECAST IN YONG XING ISLAND WAVE HIGH:");
        sb.append(generalForecast.getWaveHigh()).append("M,WATER Temperature:");
        sb.append(generalForecast.getWaterTemperature()).append("°,WAVE HIGH:");
        sb.append(generalForecast.getTideHighTime()).append("UTC ");
        sb.append(generalForecast.getTideHigh()).append("CM, WAVE LOW:");
        sb.append(generalForecast.getTideLowTime()).append("UTC ");
        sb.append(generalForecast.getTideLow()).append("CM，FCSOA&MSA");
        return sb.toString();
    }

    @Override
    public List<String> numericalForecastMsg(NumericalForecast numericalForecast) {
        StringBuffer sb = new StringBuffer();
        List<String> numericalForecastList = new ArrayList<String>();
        String[] windSpeed = numericalForecast.getWindSpeedList().split(",");
        String[] windDirection = numericalForecast.getWindDirectionList().split(",");
        String[] waterSpeed = numericalForecast.getWaterSpeedList().split(",");
        String[] waterDirection = numericalForecast.getWaterDirectionList().split(",");
        String[] waveHigh = numericalForecast.getWaveHighList().split(",");
        String[] waveDirection = numericalForecast.getWaveDirectionList().split(",");
        LocationInfo locationInfo = locationInfoServiceImpl.getLocationInfoService();
        List<String> latitudeList = new ArrayList<String>();
        latitudeList.add(convertUtil.decConvertDfm(Integer.parseInt(locationInfo.getL1Latitude())));
        latitudeList.add(convertUtil.decConvertDfm(Integer.parseInt(locationInfo.getL2Latitude())));
        latitudeList.add(convertUtil.decConvertDfm(Integer.parseInt(locationInfo.getL3Latitude())));
        latitudeList.add(convertUtil.decConvertDfm(Integer.parseInt(locationInfo.getL4Latitude())));
        latitudeList.add(convertUtil.decConvertDfm(Integer.parseInt(locationInfo.getL5Latitude())));
        List<String> longitudeList = new ArrayList<String>();
        longitudeList.add(convertUtil.decConvertDfm(Integer.parseInt(locationInfo.getL1Longitude())));
        longitudeList.add(convertUtil.decConvertDfm(Integer.parseInt(locationInfo.getL2Longitude())));
        longitudeList.add(convertUtil.decConvertDfm(Integer.parseInt(locationInfo.getL3Longitude())));
        longitudeList.add(convertUtil.decConvertDfm(Integer.parseInt(locationInfo.getL4Longitude())));
        longitudeList.add(convertUtil.decConvertDfm(Integer.parseInt(locationInfo.getL5Longitude())));
        int index = numericalForecast.getWindSpeedList().split(",").length;
        for (int i=0;i<index;i++) {
            sb.append("NUMERICAL FORECAST IN N/E ");
            sb.append(numericalForecast.getForecastTime()).append("UTC ");
            sb.append(latitudeList.get(i)).append("N ");
            sb.append(longitudeList.get(i)).append("E ");
            sb.append("WIND SPEED:").append(windSpeed[i]).append("M/S,WIND DIRECTION:");
            sb.append(windDirection[i]).append("°,WATER SPEED:");
            sb.append(waterSpeed[i]).append("M/S,WATER DIRECTION:");
            sb.append(waterDirection[i]).append("°,WAVE HIGH:");
            sb.append(waveHigh[i]).append("M,WAVE DIRECTION:");
            sb.append(waveDirection[i]).append("° FCSOA&MSA");
            numericalForecastList.add(sb.toString());
            sb.delete(0, sb.length());
        }
        return numericalForecastList;
    }
}
