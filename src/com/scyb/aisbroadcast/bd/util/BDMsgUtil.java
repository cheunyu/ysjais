package com.scyb.aisbroadcast.bd.util;

import org.apache.log4j.Logger;

/**
 * Created with Intellij IDEA
 * User:foo
 * Date:2015/7/27
 * Time:14:33
 */
public class BDMsgUtil {

    private static byte dataByte[];
    private static byte txxxByte[];
    private static Logger log = Logger.getLogger("BeiDouUtil");
/*
    private static ISuccorMappingService succorMappingServiceImpl;
    private static IDistressService distressServiceImpl;

    public void setSuccorMappingServiceImpl(ISuccorMappingService succorMappingServiceImpl)
    {
        succorMappingServiceImpl = succorMappingServiceImpl;
    }

    public void setDistressServiceImpl(IDistressService distressServiceImpl) {
        distressServiceImpl = distressServiceImpl;
    }
    */

    /**
     * IC卡检测指令,
     * */
    public static byte[] getICJC() {
        dataByte = new byte[12];
        // 指令,$ICJC
        dataByte[0] = 36;
        dataByte[1] = 73;
        dataByte[2] = 67;
        dataByte[3] = 74;
        dataByte[4] = 67;
        // 长度
        dataByte[5] = 0;
        dataByte[6] = 12;
        // 用户地址
        dataByte[7] = (byte) (int) Integer.valueOf("00000110", 2);
        dataByte[8] = (byte) (int) Integer.valueOf("11110100", 2);
        dataByte[9] = (byte) (int) Integer.valueOf("01010011", 2);
        // 信息内容,帧号
        dataByte[10] = (byte) (int) Integer.valueOf("00000000", 2);
        // 校验和
        dataByte[11] = (byte) BDComUtil.getVerif(dataByte);

        return dataByte;
    }

    /**
     * IC信息指令
     * */
    public static void getICXX(byte[] dataByte) {
        StringBuffer binarySb = new StringBuffer();
        for (int i = 0; i < dataByte.length; i++) {
            if (dataByte[i] < 0) {
                binarySb.append(Integer.toBinaryString(dataByte[i]).substring(Integer.toBinaryString(dataByte[i]).length() - 8, Integer.toBinaryString(dataByte[i]).length())).append("-");
            } else {
                binarySb.append(BDComUtil.toFullBinaryString(dataByte[i], 8)).append("-");
            }
        }
        System.out.println("aaaaa");
        log.info(binarySb.toString());
    }

    /**
     * 通信申请 $TXSQ
     *
     * @param content
     *            电文内容
     * @param cardId
     *            SIM卡ID
     * */
    public static byte[] getTXSQ(String content, int cardId) {
        int byteLength = 19 + content.getBytes().length;
        dataByte = new byte[byteLength];
        // 指令$TXSQ
        dataByte[0] = (byte) (int) Integer.valueOf("00100100", 2);
        dataByte[1] = (byte) (int) Integer.valueOf("01010100", 2);
        dataByte[2] = (byte) (int) Integer.valueOf("01011000", 2);
        dataByte[3] = (byte) (int) Integer.valueOf("01010011", 2);
        dataByte[4] = (byte) (int) Integer.valueOf("01010001", 2);

        // 长度
        String distressDataLengthString = BDComUtil.toFullBinaryString(byteLength, 16);
        dataByte[5] = (byte) (int) Integer.valueOf(distressDataLengthString.substring(0, 7), 2);
        dataByte[6] = (byte) (int) Integer.valueOf(distressDataLengthString.substring(8, 16), 2);
        // 受控用户地址,发出电文指挥机ID:455763
        dataByte[7] = (byte) (int) Integer.valueOf("00000110", 2);
        dataByte[8] = (byte) (int) Integer.valueOf("11110100", 2);
        dataByte[9] = (byte) (int) Integer.valueOf("01010011", 2);
        // 信息类别,混合模式
        dataByte[10] = (byte) (int) Integer.valueOf("01000110", 2);
        // 用户地址,接收电文设备卡ID
        String cardIdString = BDComUtil.toFullBinaryString(cardId, 24);
        dataByte[11] = (byte) (int) Integer.valueOf(cardIdString.substring(0, 8), 2);
        dataByte[12] = (byte) (int) Integer.valueOf(cardIdString.substring(8, 16), 2);
        dataByte[13] = (byte) (int) Integer.valueOf(cardIdString.substring(16, 24), 2);
        // 电文内容长度
        byte[] contentByte = content.getBytes();
        System.out.println(contentByte.length);

        String contentLength = BDComUtil.toFullBinaryString((contentByte.length + 1) * 8, 16);
        dataByte[14] = (byte) (int) Integer.valueOf(contentLength.substring(0, 8), 2);
        dataByte[15] = (byte) (int) Integer.valueOf(contentLength.substring(8, 16), 2);
        // 是否应答,写死
        dataByte[16] = (byte) (int) Integer.valueOf("00000000", 2);
        /**
         * 电文内容 内容第一位为电文内容类型标示为,A4H-混合型,写死 内容数据从输入流赋值
         * */
        dataByte[17] = (byte) (int) Integer.valueOf("10100100", 2);
        for (int i = 0; i < contentByte.length; i++) {
            dataByte[18 + i] = contentByte[i];
        }
        dataByte[dataByte.length - 1] = (byte) BDComUtil.getVerif(dataByte);
        for(int i=0;i<dataByte.length;i++) {
            System.out.print(Integer.toHexString(dataByte[i])+" ");
        }
        return dataByte;
    }

    /**
     * 通信信息 $TXXX
     * */
    /*
    public static Object getTXXX(byte[] b, DistressMapping distressMapping, OutputStream outputStream) {
        Object obj = new Object();
        // 取电文内容前四字节判断是否求救信号
        byte[] flag = new byte[4];
        flag[0] = b[19];
        flag[1] = b[20];
        flag[2] = b[21];
        flag[3] = b[22];
        // 指挥机设备卡号
        int serverId = Integer.valueOf(BinaryUtil.toFullBinaryString(b[7], 8) + BinaryUtil.toFullBinaryString(b[8], 8) + BinaryUtil.toFullBinaryString(b[9], 8), 2);
        // 落水求救设备卡号
        int clientId = Integer.valueOf(BinaryUtil.toFullBinaryString(b[11], 8) + BinaryUtil.toFullBinaryString(b[12], 8) + BinaryUtil.toFullBinaryString(b[13], 8), 2);
        if (new String(flag).equals("SOS@")) {
            log.info("通信信息类别为求救信息@SOS.");
            // 电文长度
            int dataLength = Integer.valueOf(BinaryUtil.toFullBinaryString(b[5], 8) + BinaryUtil.toFullBinaryString(b[6], 8), 2);
            // 电文内容长度
            int contentLength = Integer.valueOf(BinaryUtil.toFullBinaryString(b[16], 8) + BinaryUtil.toFullBinaryString(b[17], 8), 2) / 8;
            // 求救内容
            StringBuffer sosContent = new StringBuffer();
            for (int i = 19; i < dataLength - 2; i++) {
                sosContent.append((char) b[i]);
            }
            log.info("电文内容 => " + sosContent.toString());
            Distress distress = new Distress();
            distress.setDistressMapping(distressMapping);
            distress.setServerId(Integer.toString(serverId));
            String lat = sosContent.toString().substring(sosContent.toString().indexOf("Lat") + 3, sosContent.toString().length()).replaceFirst(":", "°").replaceFirst(":", "\"") + "'";
            distress.setDistressLat(lat);
            String lon = sosContent.toString().substring(sosContent.toString().indexOf("Lng") + 3, sosContent.toString().indexOf("Lat") - 1).replaceFirst(":", "°").replaceFirst(":", "\"") + "'";
            distress.setDistressLon(lon);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat dateSDF = new SimpleDateFormat("yyyy-MM-dd");
            String date = dateSDF.format(new Date());
            String time = sosContent.toString().substring(sosContent.toString().indexOf("Time") + 4, sosContent.toString().indexOf("Lng") - 2);
            try {
                distress.setDistressTime(sdf.parse(date + " " + time));
                distress.setCreateTime(new Date());
                int lastViewTag = distressServiceImpl.getLastOfDistressViewTag(distressMapping.getCardId());
                if (lastViewTag == 0)
                    distress.setViewTag(Integer.toString(lastViewTag));
                else
                    distress.setViewTag("1");
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            obj = distress;
        } else {
            log.info("收到一条手持机通信信息.");
            StringBuffer sb = new StringBuffer();
            for (int k = 19; k < b.length - 2; k++) {
                if (BinaryUtil.toFullBinaryString(b[k], 8).startsWith("0")) {
                    // int a = Integer.parseInt(b[k],2);
                    sb.append((char) b[k]);
                } else { // ASCII大于128时即每byte高一位为"1"时进行中文解码
                    byte[] bytes = new byte[2];
                    bytes[0] = (byte) (int) Integer.valueOf(BinaryUtil.toFullBinaryString(b[k], 8), 2);
                    bytes[1] = (byte) (int) Integer.valueOf(BinaryUtil.toFullBinaryString(b[k + 1], 8), 2);
                    sb.append(new String(bytes));
                    k = k + 1;
                }
            }
            Succor succor = new Succor();
            SuccorMapping succorMapping = succorMappingServiceImpl.getSuccorMappingByCardId(Integer.toString(clientId));
            if (serverId == 455763) {
                log.info(clientId + "====>" + serverId);
                succor.setServerId(Integer.toString(serverId));
                succor.setSuccorMapping(succorMapping);
                succor.setClasses("2");
                log.info("转发通信信息电文");
                try {
                    String rediContent = sb.toString() + ",clientId" + clientId;
                    log.info("转发内容： " + rediContent);
                    outputStream.write(BeiDouUtil.getTXSQ(rediContent, 455764));
                    outputStream.close();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            } else if (clientId == 455763) {
                log.info(clientId + "====>" + serverId);
                succor.setServerId(Integer.toString(clientId));
                succor.setSuccorMapping(succorMapping);
                succor.setClasses("1");
            }
            succor.setOpenTag("1");
            succor.setContent(sb.toString());
            succor.setCreateTime(new Date());
            obj = succor;
        }
        return obj;
    }
 */
    /**
     * 定位申请 $DWSQ
     *
     * @param cardId
     *            SIM卡ID
     * */
    public static byte[] getDWSQ(int cardId) {
        dataByte = new byte[22];
        // 指令,$DWSQ
        dataByte[0] = 36;
        dataByte[1] = 68;
        dataByte[2] = 87;
        dataByte[3] = 83;
        dataByte[4] = 81;
        // 长度
        dataByte[5] = 0;
        dataByte[6] = 22;
        // 用户地址,接收定位电文设备卡ID
        String cardIdString = BDComUtil.toFullBinaryString(cardId, 24);
        dataByte[7] = (byte) (int) Integer.valueOf(cardIdString.substring(0, 8), 2);
        dataByte[8] = (byte) (int) Integer.valueOf(cardIdString.substring(8, 16), 2);
        dataByte[9] = (byte) (int) Integer.valueOf(cardIdString.substring(16, 24), 2);
        // 信息类别
        dataByte[10] = 4;
        dataByte[11] = 0;
        dataByte[12] = 0;
        dataByte[13] = 0;
        dataByte[14] = 0;
        dataByte[15] = 0;
        dataByte[16] = 0;
        dataByte[17] = 0;
        dataByte[18] = 0;
        dataByte[19] = 0;
        dataByte[20] = 0;
        // 校验和
        dataByte[21] = (byte) BDComUtil.getVerif(dataByte);
        return dataByte;
    }

    /**
     * 定位信息反馈 $DWXX
     * */
    /*
    public static SuccorLocation getDWXX(byte[] b) {
        // 指挥机设备卡号
        int clientId = Integer.valueOf(BinaryUtil.toFullBinaryString(b[7], 8) + BinaryUtil.toFullBinaryString(b[8], 8) + BinaryUtil.toFullBinaryString(b[9], 8), 2);
        int serverId = Integer.valueOf(BinaryUtil.toFullBinaryString(b[11], 8) + BinaryUtil.toFullBinaryString(b[12], 8) + BinaryUtil.toFullBinaryString(b[13], 8), 2);
        int hh = Integer.valueOf(BinaryUtil.toFullBinaryString(b[14], 8), 2);
        int mm = Integer.valueOf(BinaryUtil.toFullBinaryString(b[15], 8), 2);
        int ss = Integer.valueOf(BinaryUtil.toFullBinaryString(b[16], 8), 2);
        SuccorLocation sl = new SuccorLocation();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdfDate.format(new Date());
        String temp = date + " " + hh + ":" + mm + ":" + ss;
        Date d = null;
        try {
            d = sdf.parse(temp);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int londu = Integer.valueOf(BinaryUtil.toFullBinaryString(b[18], 8), 2);
        int lonfen = Integer.valueOf(BinaryUtil.toFullBinaryString(b[19], 8), 2);
        int lonmiao = Integer.valueOf(BinaryUtil.toFullBinaryString(b[20], 8), 2);
        int lonmiao2 = Integer.valueOf(BinaryUtil.toFullBinaryString(b[21], 8), 2);
        String lon = londu + "°" + lonfen + "′" + lonmiao + "." + lonmiao2 + "″";
        int latdu = Integer.valueOf(BinaryUtil.toFullBinaryString(b[22], 8), 2);
        int latfen = Integer.valueOf(BinaryUtil.toFullBinaryString(b[23], 8), 2);
        int latmiao = Integer.valueOf(BinaryUtil.toFullBinaryString(b[24], 8), 2);
        int latmiao2 = Integer.valueOf(BinaryUtil.toFullBinaryString(b[25], 8), 2);
        String lat = latdu + "°" + latfen + "′" + latmiao + "." + latmiao2 + "″";
        sl.setCreateTime(d);
        SuccorMapping succorMapping = succorMappingServiceImpl.getSuccorMappingByCardId(Integer.toString(clientId));
        sl.setSuccorMapping(succorMapping);
        sl.setServerId("455763");
        sl.setLat(lat);
        sl.setLon(lon);
        return sl;
    }
    */

    /**
     * 点名定位(通信申请扩展)
     *
     * @param cardId
     *            定位目标卡号
     * */
    public static byte[] getDMDW(int cardId) {
        dataByte = new byte[23];
        // 指令$TXSQ
        dataByte[0] = (byte) (int) Integer.valueOf("00100100", 2);
        dataByte[1] = (byte) (int) Integer.valueOf("01010100", 2);
        dataByte[2] = (byte) (int) Integer.valueOf("01011000", 2);
        dataByte[3] = (byte) (int) Integer.valueOf("01010011", 2);
        dataByte[4] = (byte) (int) Integer.valueOf("01010001", 2);
        // 长度
        dataByte[5] = 0;
        dataByte[6] = 23;
        // 受控用户地址,发出电文指挥机ID:455763
        dataByte[7] = (byte) (int) Integer.valueOf("00000110", 2);
        dataByte[8] = (byte) (int) Integer.valueOf("11110100", 2);
        dataByte[9] = (byte) (int) Integer.valueOf("01010011", 2);
        // 消息类别
        dataByte[10] = 0x46;
        // 用户地址,接收定位电文设备卡ID
        String cardIdString = BDComUtil.toFullBinaryString(cardId, 24);
        dataByte[11] = (byte) (int) Integer.valueOf(cardIdString.substring(0, 8), 2);
        dataByte[12] = (byte) (int) Integer.valueOf(cardIdString.substring(8, 16), 2);
        dataByte[13] = (byte) (int) Integer.valueOf(cardIdString.substring(16, 24), 2);
        // 常量
        dataByte[14] = 0;
        dataByte[15] = 0x28;
        dataByte[16] = 0;
        dataByte[17] = (byte) 0xA2;

        dataByte[18] = (byte) ((cardId * 8) >> 24);
        dataByte[19] = (byte) ((cardId * 8) >> 16);
        dataByte[20] = (byte) ((cardId * 8) >> 8);
        dataByte[21] = (byte) (cardId * 8);
        // 校验和
        dataByte[22] = (byte) BDComUtil.getVerif(dataByte);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < dataByte.length; i++) {
            sb.append(Integer.toHexString(dataByte[i])).append(" ");
        }
        return dataByte;
    }

}
