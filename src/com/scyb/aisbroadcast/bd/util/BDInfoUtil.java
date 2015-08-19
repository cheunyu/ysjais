package com.scyb.aisbroadcast.bd.util;

import com.scyb.aisbroadcast.ais.service.IAisMsgForecastService;
import com.scyb.aisbroadcast.bd.bo.GeneralForecast;
import com.scyb.aisbroadcast.bd.bo.LocationInfo;
import com.scyb.aisbroadcast.bd.bo.Message;
import com.scyb.aisbroadcast.bd.bo.NumericalForecast;
import com.scyb.aisbroadcast.bd.service.*;
import com.scyb.aisbroadcast.common.bo.GlobalVariable;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import java.io.OutputStream;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2015/7/27
 * Time:14:31
 */
public class BDInfoUtil {

    private Logger log = Logger.getLogger(this.getClass());
    private BDMsgUtil bdMsgUtil = new BDMsgUtil();
    private IGeneralForecastService generalForecastServiceImpl;
    private INumericalForecastService numericalForecastServiceImpl;
    private ILocationInfoService locationInfoServiceImpl;
    private IAnalyzeComDataService analyzeComDataServiceImpl;
    private IAisMsgForecastService aisMsgForecastServiceImpl;
    private IMessageService messageServiceImpl;

    /**
     * 鉴定接收的数据指令类别
     *
     * @param dataByte 数据字节
     */
    public void checkDataType(byte[] dataByte, OutputStream outputStream, ServletContextEvent sce) {
        String dataStr = new String(dataByte);
        log.info("接收数据字符串" + dataStr);
        if (dataStr.indexOf("ICXX") > -1) {
            log.info("接收到ICXX信息.");
        } else if (dataStr.indexOf("TXXX") > -1) {//通信信息类别
            int clientId = Integer.valueOf(BDComUtil.toFullBinaryString(dataByte[11], 8) + BDComUtil.toFullBinaryString(dataByte[12], 8) + BDComUtil.toFullBinaryString(dataByte[13], 8), 2);
            ApplicationContext ac1 = WebApplicationContextUtils.getRequiredWebApplicationContext(sce
                    .getServletContext());
            analyzeComDataServiceImpl = (IAnalyzeComDataService) ac1.getBean("analyzeComDataServiceImpl");
            aisMsgForecastServiceImpl = (IAisMsgForecastService) ac1.getBean("aisMsgForecastServiceImpl");
            log.info((char)dataByte[24]);
            if ((char) dataByte[24] == 'C' || (char) dataByte[20] == 'C') {
                log.info("收到一条常规预报.发送方:" + clientId);
                generalForecastServiceImpl = (IGeneralForecastService) ac1.getBean("generalForecastServiceImpl");
                /*解析常规预报电文，封装数据*/
                GeneralForecast generalForecast = analyzeComDataServiceImpl.analyzeBdGeneralForecast(dataByte);
                /*保存常规预报*/
                generalForecastServiceImpl.addGeneralForcastService(generalForecast);
                if("0".equals(generalForecast.getMmsi())) {
                    GlobalVariable.setGeneralForecastMsg(aisMsgForecastServiceImpl.generalForecastMsg(generalForecast));
//                    generalForecastServiceImpl.sendGeneralForecastPlanService();
                }else {
                    /*发送常规预报，6号报文*/
                    generalForecastServiceImpl.sendGeneralForcastService(generalForecast);
                }

            } else if ((char) dataByte[24] == 'N' || (char) dataByte[20] == 'N') {
                log.info("收到一条数值预报.发送方:" + clientId);
                numericalForecastServiceImpl = (INumericalForecastService) ac1.getBean("numericalForecastServiceImpl");
                /*解析数值预报电文，封装数据*/
                NumericalForecast numericalForecast = analyzeComDataServiceImpl.analyzeBdNumericalForecast(dataByte);
                /*保存数值预报*/
                numericalForecastServiceImpl.addNumericalForcastService(numericalForecast);
                if("0".equals(numericalForecast.getMmsi())) {
                    GlobalVariable.setNumericalForecastMsgList(aisMsgForecastServiceImpl.numericalForecastMsg(numericalForecast));
                }else {
                    /*发送常规预报,多点预报需要数据处理完整开始播发*/
                    numericalForecastServiceImpl.sendNumericalForcastService(numericalForecast);
                }
            } else if ((char) dataByte[24] == 'M' || (char) dataByte[20] == 'M') {
                log.info("收到一条数值预报.发送方:" + clientId);
                messageServiceImpl = (IMessageService) ac1.getBean("messageServiceImpl");
                /*解析短信息电文，封装数据*/
                Message message = analyzeComDataServiceImpl.analyzeBdMessage(dataByte);
                /*保存短信息*/
                messageServiceImpl.addMessageService(message);
                /*发送短信息,多条数据处理完整开始播发*/
                messageServiceImpl.sendMessageService(message);
            } else if((char) dataByte[19] == 'P') {
                log.info("收到一条位置设置电文.发送方:" + clientId);
                locationInfoServiceImpl = (ILocationInfoService) ac1.getBean("locationInfoServiceImpl");
                 /*解析位置设置电文，封装数据*/
                LocationInfo locationInfo = analyzeComDataServiceImpl.analyzeBdLocationInfo(dataByte);
                log.info(1);
                /*保存数值预报*/
                locationInfoServiceImpl.addLocationInfoService(locationInfo);
            }
        }
    }
}
