/**     
 * @Title: NMEA0183ConvertBinary.java    
 * @Package com.scyb.aisweather.vdl.util   
 * @Description: TODO(用一句话描述该文件做什么)    
 * @author A18ccms A18ccms_gmail_com     
 * @date 2014年11月10日 上午11:09:43    
 * @version V1.0    
 */
package com.scyb.aisbroadcast.ais.util;

/**
 *      @ClassName: NMEA0183ConvertBinary   
 *  @Description: TODO(这里用一句话描述这个类的作用)     @author cheunyu xiaoyuuii@hotmail.com
 *  @date 2014年11月10日 上午11:09:43           
 */
public class NMEA0183ConvertBinaryUtil {

	private AscIIConvertBinaryUtil acbUtil = new AscIIConvertBinaryUtil();

	public String convert(String vdlMessage) {
		StringBuffer sb = new StringBuffer();
		byte b[];
		for (int i = 0; i < vdlMessage.length(); i++) {
			b = vdlMessage.substring(i, i + 1).getBytes();
			for (int j = 0; j < b.length; j++) {
				int tmp = b[j] + 0x28;
				if (tmp > 0x80) {
					tmp = tmp + 0x20;
				} else {
					tmp = tmp + 0x28;
				}
				sb.append(acbUtil.convertBin(tmp, 6));
			}
		}
		return sb.toString();
	}

}
