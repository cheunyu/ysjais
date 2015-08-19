/**     
 * @Title: IEC1371ConvertSerialUtil.java    
 * @Package com.scyb.aisweather.vdl.util   
 * @Description: TODO(用一句话描述该文件做什么)    
 * @author A18ccms A18ccms_gmail_com     
 * @date 2014年9月22日 下午6:45:44    
 * @version V1.0    
 */
package com.scyb.aisbroadcast.ais.util;

import com.scyb.aisbroadcast.common.bo.GlobalVariable;
import org.apache.log4j.Logger;
import org.springframework.web.context.ContextLoader;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 *      @ClassName: IEC1371ConvertSerialUtil   
 *  @Description: TODO(IEC1371编码转换串口编码工具类)   
 *  @author cheunyu xiaoyuuii@hotmail.com  @date 2014年9月22日 下午6:45:44           
 */
public class IEC1371ConvertSerialUtil {

	@SuppressWarnings("unused")
	private Logger log = Logger.getLogger(this.getClass());
	private AscIIConvertBinaryUtil acbUtil = new AscIIConvertBinaryUtil();

	/**
	 *  @Title: convertSerial     @Description: TODO(对IEC1371补码后，八位二进制转六位二进制)   
	 *  @param @param iecCode  @param @return    设定文件  
	 *  @return String    返回类型    @throws   
	 */
	public String convertSerial(String iecCode) {
		@SuppressWarnings("unchecked")
		Map<String, String> sixbitMap = GlobalVariable.getSixbitMap();
		StringBuffer serialCode = new StringBuffer();
		for (int i = 0; i < iecCode.length() % 6; i++) {
			iecCode = iecCode + "0";
		}
		for (int i = 0; i < iecCode.length() / 6; i++) {
			int tmp = Integer.valueOf(iecCode.substring(i * 6, (i + 1) * 6), 2);
			Iterator<Entry<String, String>> iter = sixbitMap.entrySet().iterator();
			while (iter.hasNext()) {
				@SuppressWarnings("rawtypes")
				Entry entry = (Entry) iter.next();
				if (entry.getValue().equals(acbUtil.convertBin(tmp, 6))) {
					serialCode.append(entry.getKey());
				}
			}
		}
		return serialCode.toString();
	}

	/**
	 *  @Title: getSerialMessageCount     @Description: TODO(计算报文总条数)   
	 *  @param @param iecCode  @param @return    设定文件    @return int    返回类型  
	 *  @throws   
	 */
	public int getSerialMessageCount(String serialCode) {
		if (serialCode.length() <= 48) {
			return 1;
		} else {
			if ((serialCode.length() - 48) % 60 == 0) {
				return (serialCode.length() - 48) / 60 + 1;
			} else {
				return (serialCode.length() - 48) / 60 + 2;
			}
		}
	}

	/**
	 *  @Title: getMessageMap     @Description: TODO(按时隙分割报文)     @param @param
	 * serialCode  @param @param messageCount  @param @return    设定文件  
	 *  @return Map<Integer,String>    返回类型    @throws   
	 */
	public Map<Integer, String> getMessageMap(String serialCode, int messageCount) {
		Map<Integer, String> messageMap = new HashMap<Integer, String>();
		int temp = 0;
		for (int i = 0; i < messageCount; i++) {
			if (i == 0 && serialCode.length() < 48) {
				messageMap.put(1, serialCode.substring(0, serialCode.length()));
			} else if (i == 0 && serialCode.length() > 48) {
				messageMap.put(1, serialCode.substring(0, 48));
				temp = 48;
			} else if (serialCode.length() > temp + 60) {
				messageMap.put(i + 1, serialCode.substring(temp, temp + 60));
				temp = temp + 60;
			} else {
				messageMap.put(i + 1, serialCode.substring(temp, serialCode.length()));
			}

		}
		return messageMap;
	}
	
	/**
	 * @Title: getPaddingCode   
	 * @Description: TODO(六位二進制补位)   
	 * @param @param iecCode
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws   
	 */
	public String getPaddingCode(String iecCode) {
		return Integer.toString(iecCode.length() % 6);
	}
}
