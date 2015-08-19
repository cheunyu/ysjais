package com.scyb.aisbroadcast.ais.service.impl;

import com.scyb.aisbroadcast.ais.service.ISendMessageService;
import org.apache.log4j.Logger;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2015/8/4
 * Time:9:08
 */
public class SendMessageServiceImpl implements ISendMessageService,ServletContextAware {

    private Logger log = Logger.getLogger(this.getClass());
    private ServletContext sce;

    @Override
    public void sendMessages(List<String> aisMsgList) {
        Socket socket = (Socket) sce.getAttribute("aisSocket");
        /*Ais岸台连接鉴权*/
        // 向服务器端发送数据
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(socket.getOutputStream());
            for(int i=0;i<aisMsgList.size();i++) {
                log.info(aisMsgList.get(i));
                pw.println(aisMsgList.get(i));
                pw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        sce = servletContext;
    }
}
