package com.scyb.aisbroadcast.ais.service.impl;

import com.scyb.aisbroadcast.ais.service.IAisMsgForecastService;
import com.scyb.aisbroadcast.bd.bo.GeneralForecast;
import com.scyb.aisbroadcast.bd.bo.LocationInfo;
import com.scyb.aisbroadcast.bd.bo.NumericalForecast;
import com.scyb.aisbroadcast.bd.service.ILocationInfoService;
import com.scyb.aisbroadcast.bd.service.INumericalForecastService;
import com.scyb.aisbroadcast.common.util.ConvertUtil;
import com.scyb.aisbroadcast.webservice.bo.GeneralForecastBo;
import com.scyb.aisbroadcast.webservice.bo.NumericalForecastBo;
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

    public void setConvertUtil(ConvertUtil convertUtil) {
        this.convertUtil = convertUtil;
    }

    @Override
    /**
     * 转换为用户可见的字符常规预报信息
     * */
    public String generalForecastMsg(GeneralForecastBo generalForecastBo) {
        StringBuffer sb = new StringBuffer();
        sb.append("ROUTINE FORECAST IN YONG SHU ISLAND WAVE HIGH:");
        sb.append(generalForecastBo.getWaveHigh()).append("M,WATER TEMPERATURE:");
        sb.append(generalForecastBo.getWaterTemperature()).append("°,WAVE HIGH:");
        sb.append(generalForecastBo.getTideHighTime()).append("UTC ");
        sb.append(generalForecastBo.getTideHigh()).append("CM,WAVE LOW:");
        sb.append(generalForecastBo.getTideLowTime()).append("UTC ");
        sb.append(generalForecastBo.getTideLow()).append("CM,FCSOA&MSA");
        return sb.toString();
    }

    @Override
    /**
     * 转换为用户可见的字符数值预报信息
     * */
    public List<String> numericalForecastMsg(List<NumericalForecastBo> numericalForecastBoList) {
        StringBuffer sb = new StringBuffer();
        List<String> numericalForecastList = new ArrayList<String>();
        for (int i=0;i<numericalForecastBoList.size();i++) {
            sb.append("NUMERICAL FORECAST IN N/E ");
            sb.append(numericalForecastBoList.get(i).getForecastTime()).append("UTC ");
            sb.append(numericalForecastBoList.get(i).getLat()).append("N ");
            sb.append(numericalForecastBoList.get(i).getLon()).append("E ");
            sb.append("WIND SPEED:").append(numericalForecastBoList.get(i).getWindSpeed()).append("M/S,WIND DIRECTION:");
            sb.append(numericalForecastBoList.get(i).getWindDirection()).append("°,WATER SPEED:");
            sb.append(numericalForecastBoList.get(i).getWaterSpeed()).append("M/S,WATER DIRECTION:");
            sb.append(numericalForecastBoList.get(i).getWaterDirection()).append("°,WAVE HIGH:");
            sb.append(numericalForecastBoList.get(i).getWaveHigh()).append("M,WAVE DIRECTION:");
            sb.append(numericalForecastBoList.get(i).getWaveDirection()).append("°,FCSOA&MSA");
            numericalForecastList.add(sb.toString());
            sb.delete(0, sb.length());
        }
        return numericalForecastList;
    }
}
