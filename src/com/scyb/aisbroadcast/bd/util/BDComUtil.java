package com.scyb.aisbroadcast.bd.util;

import org.apache.log4j.Logger;

public class BDComUtil {

    private static byte[] dataByteFinal;
    private static int dataInd = 0;
    private static Logger log = Logger.getLogger("BDComUtil");
    private static int dataLength = 0;
    private static byte[] dataByteTemp = null;

    /**
     * 补全二进制
     *
     * @param num      整型数据
     * @param subIndex 转换二进制保留位数
     */
    public static String toFullBinaryString(int num, int subIndex) {
        char[] chs = new char[subIndex];
        for (int i = 0, k = chs.length; i < k; i++) {
            chs[k - i - 1] = ((num >> i) & 1) == 0 ? '0' : '1';
        }
        return new String(chs);
    }

    /**
     * 校验和
     */
    public static int getVerif(byte[] b) {
        int k = 0;
        for (int i = 0; i < b.length; i++) {
            if (i == 0) {
                k = b[i] ^ b[i + 1];
            } else if (i > 0 && i < b.length - 1) {
                k = k ^ b[i + 1];
            }
        }
        return k;
    }

    /**
     * 过虑串口数据拼接完整多条数据内容
     * 以一条信息为例，从指挥机底层信号进行分包，进入COM数据并一定是一次进入，也可能2-3次才能完整。记录第一个包携带的电文长度数据做返回结果最终数组长度。
     *
     * @param dataByte 串口每次接收的原始字节数组
     * @return dataByteFinal or null 如果一条电文没有一次接收完整返回null，直到多条数据拼接成一条完整电文返回电文字节数组
     */
    public static byte[] filterByte(byte[] dataByte) {
        //判断首字节是否是北斗电文起始标示符"$"
        if (new String(dataByte).indexOf("$") == 0) {
            //获取电文长度
            dataLength = Integer.valueOf(BDComUtil.toFullBinaryString(dataByte[5], 8) + BDComUtil.toFullBinaryString(dataByte[6], 8), 2);
            //初始化最终处理后的字节数组，长度不包含CRC和校验位两个BYTE
            dataByteFinal = new byte[dataLength];
            dataInd = 0;
        }
        /* 用于调试监控*/
//        log.info("本次电文总长度" + dataLength + "字节");
//        log.info("单包电文长度：" + dataByte.length);
//        log.info("分包计数下标：" + dataInd);
		/* 屏蔽$ZJXX后台输入*/
        if (dataLength != 21)
            BDComUtil.getHexAndString(dataByte);
        //数据拼包，每次接收的单包原始字节数组向最终拼接字节数组赋值
        for (int i = 0; i < dataByte.length; i++) {
            dataByteFinal[dataInd++] = dataByte[i];
        }
		/* 用于调试监控*/
//        log.info("当前最终数组最后一位下标值：" + dataByteFinal[dataByteFinal.length-1]);
        //如果校验和为00H,表示一条电文还没有接收完整。
        if (dataByteFinal[dataByteFinal.length - 1] == 0) {
            log.info("单包接收" + dataByte.length + "字节.");
            log.info("没有完整接收电文内容，继续处理...");
            return null;
        } else {
            //重置最终拼接数组下标
            dataInd = 0;
//            log.info("一条电文接收完成.");
            return dataByteFinal;
        }
    }

    /**
     * @param dataByte 单包数据数组
     * @return void 字符串
     * @throws
     * @Title: getHexAndString
     * @Description: TODO(输出单包字符串内容)
     */
    public static void getHexAndString(byte[] dataByte) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < dataByte.length; i++) {
            sb.append(Integer.toHexString(dataByte[i]) + " ");
        }
//        log.info(sb.toString());
    }
}