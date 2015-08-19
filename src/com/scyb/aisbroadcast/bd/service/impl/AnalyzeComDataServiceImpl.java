package com.scyb.aisbroadcast.bd.service.impl;

import com.scyb.aisbroadcast.bd.bo.GeneralForecast;
import com.scyb.aisbroadcast.bd.bo.LocationInfo;
import com.scyb.aisbroadcast.bd.bo.Message;
import com.scyb.aisbroadcast.bd.bo.NumericalForecast;
import com.scyb.aisbroadcast.bd.service.IAnalyzeComDataService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.scyb.aisbroadcast.bd.util.BDComUtil;
import org.apache.log4j.Logger;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2015/8/4
 * Time:11:13
 */
public class AnalyzeComDataServiceImpl implements IAnalyzeComDataService{

    private Logger log = Logger.getLogger(this.getClass());
    private BDComUtil bdComUtil;

    public void setBdComUtil(BDComUtil bdComUtil) {
        this.bdComUtil = bdComUtil;
    }

    @Override
    public GeneralForecast analyzeBdGeneralForecast(byte[] bytes) {
        String dataMsg = new String(bytes);
        String data[] = dataMsg.substring(19,dataMsg.length()-1).split(",");
        GeneralForecast generalForecast = new GeneralForecast();
        int mmsi = 0;
        if(bytes.length==55) {
            mmsi = Integer.valueOf(bdComUtil.toFullBinaryString(bytes[19], 8)+bdComUtil.toFullBinaryString(bytes[20], 8)+bdComUtil.toFullBinaryString(bytes[21], 8)+bdComUtil.toFullBinaryString(bytes[22], 8), 2);
        }
        generalForecast.setMmsi(String.valueOf(mmsi));
        generalForecast.setWaveHigh(data[2]);
        generalForecast.setWaterTemperature(data[3]);
        generalForecast.setTideHighTime(data[4]);
        generalForecast.setTideHigh(data[5]);
        generalForecast.setTideLowTime(data[6]);
        generalForecast.setTideLow(data[7]);
        generalForecast.setBdMsg(dataMsg.substring(19, dataMsg.length() - 1));
        return generalForecast;
    }

    @Override
    public NumericalForecast analyzeBdNumericalForecast(byte[] bytes) {
        String dataMsg = new String(bytes);
        String data[] = dataMsg.substring(19,dataMsg.length()-1).split(",");
        NumericalForecast numericalForecast = new NumericalForecast();
        int mmsi = 0;
        if(data[0].length() > 0) {
            mmsi = Integer.valueOf(bdComUtil.toFullBinaryString(bytes[19], 8)+bdComUtil.toFullBinaryString(bytes[20], 8)+bdComUtil.toFullBinaryString(bytes[21], 8)+bdComUtil.toFullBinaryString(bytes[22], 8), 2);
        }
        numericalForecast.setMmsi(String.valueOf(mmsi));

        long time = 0l;
        if(data[0].length() > 0) {
            time = Integer.valueOf(bdComUtil.toFullBinaryString(bytes[26], 8)+bdComUtil.toFullBinaryString(bytes[27], 8)+bdComUtil.toFullBinaryString(bytes[28], 8)+bdComUtil.toFullBinaryString(bytes[29], 8), 2);
        }else {
            time = Integer.valueOf(bdComUtil.toFullBinaryString(bytes[22], 8)+bdComUtil.toFullBinaryString(bytes[23], 8)+bdComUtil.toFullBinaryString(bytes[24], 8)+bdComUtil.toFullBinaryString(bytes[25], 8), 2);
        }
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time * 1000);
        numericalForecast.setForecastTime(String.valueOf(cal.get(Calendar.HOUR_OF_DAY)) + String.valueOf(cal.get(Calendar.MINUTE)) + String.valueOf(cal.get(Calendar.SECOND)));
        StringBuffer windSpeed = new StringBuffer();
        StringBuffer windDirection = new StringBuffer();
        StringBuffer waterSpeed = new StringBuffer();
        StringBuffer waterDirection = new StringBuffer();
        StringBuffer waveSpeed = new StringBuffer();
        StringBuffer waveDirection = new StringBuffer();
        for(int j=0;j<(data.length-3)/6;j++) {
            windSpeed.append(data[3+6*j]).append(",");
            windDirection.append(data[4+6*j]).append(",");
            waterSpeed.append(data[5+6*j]).append(",");
            waterDirection.append(data[6+6*j]).append(",");
            waveSpeed.append(data[7+6*j]).append(",");
            waveDirection.append(data[8+6*j]).append(",");
        }
        numericalForecast.setWindSpeedList(windSpeed.toString());
        numericalForecast.setWindDirectionList(windDirection.toString());
        numericalForecast.setWaterSpeedList(waterSpeed.toString());
        numericalForecast.setWaterDirectionList(waterDirection.toString());
        numericalForecast.setWaveHighList(waveSpeed.toString());
        numericalForecast.setWaveDirectionList(waveDirection.toString());
        numericalForecast.setBdMsg(dataMsg.substring(19,dataMsg.length()-1));
        return numericalForecast;
    }

    @Override
    public LocationInfo analyzeBdLocationInfo(byte[] bytes) {
        String dataMsg = new String(bytes);
        String data[] = dataMsg.substring(18,dataMsg.length()-2).split(",");
        LocationInfo locationInfo = new LocationInfo();
        List<String> locationList = new ArrayList<String>();
        for(int i=1;i<=data.length-1;i++) {
            locationList.add(data[i].split("&")[0]);
            locationList.add(data[i].split("&")[1]);
        }
        locationInfo.setL1Latitude(locationList.get(0));
        locationInfo.setL1Longitude(locationList.get(1));
        locationInfo.setL2Latitude(locationList.get(2));
        locationInfo.setL2Longitude(locationList.get(3));
        locationInfo.setL3Latitude(locationList.get(4));
        locationInfo.setL3Longitude(locationList.get(5));
        locationInfo.setL4Latitude(locationList.get(6));
        locationInfo.setL4Longitude(locationList.get(7));
        locationInfo.setL5Latitude(locationList.get(8));
        locationInfo.setL5Longitude(locationList.get(9));
        return locationInfo;
    }

    @Override
    public Message analyzeBdMessage(byte[] bytes) {
        String dataMsg = new String(bytes);
        String data[] = dataMsg.substring(18,dataMsg.length()-2).split(",");
        Message message = new Message();
        int mmsi = 0;
        if(data[0].length() > 0) {
            mmsi = Integer.valueOf(bdComUtil.toFullBinaryString(bytes[19], 8)+bdComUtil.toFullBinaryString(bytes[20], 8)+bdComUtil.toFullBinaryString(bytes[21], 8)+bdComUtil.toFullBinaryString(bytes[22], 8), 2);
        }
        message.setMmsi(String.valueOf(mmsi));
        message.setContent(data[2]);
        message.setBdMsg(dataMsg.substring(18,dataMsg.length()-1));
        return message;
    }
}
