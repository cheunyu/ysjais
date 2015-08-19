package com.scyb.aisbroadcast.common.listener;

import com.scyb.aisbroadcast.bd.util.BDComUtil;
import com.scyb.aisbroadcast.bd.util.BDInfoUtil;
import com.scyb.aisbroadcast.common.bo.GlobalVariable;
import gnu.io.*;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.TooManyListenersException;

/**
 *  监听北斗串口接口数据
 * */
public class ComContextListener implements ServletContextListener, SerialPortEventListener,
        Runnable {

    private InputStream inputStream;
    private OutputStream outputStream;
    private Logger log = Logger.getLogger(this.getClass());
    private BDInfoUtil bdInfoUtil;
    private ServletContextEvent sce;


    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent sc) {
        ApplicationContext ac1 = WebApplicationContextUtils.getRequiredWebApplicationContext(sc
                .getServletContext());
        sce = sc;
        bdInfoUtil = (BDInfoUtil) ac1.getBean("bdInfoUtil");
        Enumeration portList = CommPortIdentifier.getPortIdentifiers();
        while (portList.hasMoreElements()) {
            CommPortIdentifier portId = (CommPortIdentifier) portList.nextElement();
//            log.info("检测已开启串口" + portId.getName());
            if (portId.getName().equals(GlobalVariable.getBdCom())) {
                try {
                    log.info(portId.getName() + "北斗串口已连接.");
                    SerialPort serialPort = (SerialPort) portId.open("SimpleReadApp", 2000);
                    /*获取北斗串口输入流*/
                    inputStream = serialPort.getInputStream();
                    /*获取北斗串口输出流*/
                    outputStream = serialPort.getOutputStream();
                    sc.getServletContext().setAttribute("outputStream", outputStream);
                    serialPort.addEventListener(this);
                    serialPort.notifyOnDataAvailable(true);
                    serialPort.setSerialPortParams(115200, SerialPort.DATABITS_8,
                            SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                    Thread readThread = new Thread(this);
                    readThread.start();
                } catch (PortInUseException | IOException | TooManyListenersException | UnsupportedCommOperationException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public void serialEvent(SerialPortEvent event) {
        if (event.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
//                log.info("串口接收数据---"+inputStream.available()+"byte");
                byte[] b = new byte[inputStream.available()];
                if (inputStream.available() > 0) {
                    inputStream.read(b);
                }
                //过虑串口数据拼接完整多条数据内容
                byte[] dataByte = BDComUtil.filterByte(b);
                if (dataByte != null) {
                    bdInfoUtil.checkDataType(dataByte, outputStream, sce);
                }
                inputStream.close();
                // log.info("转发通信信息");
                // outputStream.write(distressServiceImpl.redirect(b,
                // distressDataLength));
            } catch (IOException e) {
            }
        }
    }

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
