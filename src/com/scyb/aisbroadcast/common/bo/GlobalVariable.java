package com.scyb.aisbroadcast.common.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlobalVariable {

    /*北斗串口号*/
    private static String bdCom;

    /*Ais串口号*/
    private static String aisCom;

    /*Ais Socket IP*/
    private static String aisSocketIp;

    /*Ais Socket Port*/
    private static int aisSocketPort;

    private static Map sixbitMap = new HashMap<String, String>();

    private static int generalForecastPlan = 5;

    private static int numericalForecastPlan = 5;

    private static List<String> numericalForecastMsgList = new ArrayList<String>();

    private static String generalForecastMsg = new String();


    public static String getGeneralForecastMsg() {
        return generalForecastMsg;
    }

    public static void setGeneralForecastMsg(String generalForecastMsg) {
        GlobalVariable.generalForecastMsg = generalForecastMsg;
    }

    public static List<String> getNumericalForecastMsgList() {
        return numericalForecastMsgList;
    }

    public static void setNumericalForecastMsgList(List<String> numericalForecastMsgList) {
        GlobalVariable.numericalForecastMsgList = numericalForecastMsgList;
    }

    public static String getAisSocketIp() {
        return aisSocketIp;
    }

    public static void setAisSocketIp(String aisSocketIp) {
        GlobalVariable.aisSocketIp = aisSocketIp;
    }

    public static int getAisSocketPort() {
        return aisSocketPort;
    }

    public static void setAisSocketPort(int aisSocketPort) {
        GlobalVariable.aisSocketPort = aisSocketPort;
    }

    public static String getBdCom() {
        return bdCom;
    }

    public static void setBdCom(String bdCom) {
        GlobalVariable.bdCom = bdCom;
    }

    public static String getAisCom() {
        return aisCom;
    }

    public static void setAisCom(String aisCom) {
        com.scyb.aisbroadcast.common.bo.GlobalVariable.aisCom = aisCom;
    }

    public static int getGeneralForecastPlan() {
        return generalForecastPlan;
    }

    public static void setGeneralForecastPlan(int generalForecastPlan) {
        GlobalVariable.generalForecastPlan = generalForecastPlan;
    }

    public static int getNumericalForecastPlan() {
        return numericalForecastPlan;
    }

    public static void setNumericalForecastPlan(int numericalForecastPlan) {
        GlobalVariable.numericalForecastPlan = numericalForecastPlan;
    }

    public static Map getSixbitMap() {
        sixbitMap.put("0", "000000");
        sixbitMap.put("1", "000001");
        sixbitMap.put("2", "000010");
        sixbitMap.put("3", "000011");
        sixbitMap.put("4", "000100");
        sixbitMap.put("5", "000101");
        sixbitMap.put("6", "000110");
        sixbitMap.put("7", "000111");
        sixbitMap.put("8", "001000");
        sixbitMap.put("9", "001001");
        sixbitMap.put(":", "001010");
        sixbitMap.put(";", "001011");
        sixbitMap.put("<", "001100");
        sixbitMap.put("=", "001101");
        sixbitMap.put(">", "001110");
        sixbitMap.put("?", "001111");
        sixbitMap.put("@", "010000");
        sixbitMap.put("A", "010001");
        sixbitMap.put("B", "010010");
        sixbitMap.put("C", "010011");
        sixbitMap.put("D", "010100");
        sixbitMap.put("E", "010101");
        sixbitMap.put("F", "010110");
        sixbitMap.put("G", "010111");
        sixbitMap.put("H", "011000");
        sixbitMap.put("I", "011001");
        sixbitMap.put("J", "011010");
        sixbitMap.put("K", "011011");
        sixbitMap.put("L", "011100");
        sixbitMap.put("M", "011101");
        sixbitMap.put("N", "011110");
        sixbitMap.put("O", "011111");
        sixbitMap.put("P", "100000");
        sixbitMap.put("Q", "100001");
        sixbitMap.put("R", "100010");
        sixbitMap.put("S", "100011");
        sixbitMap.put("T", "100100");
        sixbitMap.put("U", "100101");
        sixbitMap.put("V", "100110");
        sixbitMap.put("W", "100111");
        sixbitMap.put("`", "101000");
        sixbitMap.put("a", "101001");
        sixbitMap.put("b", "101010");
        sixbitMap.put("c", "101011");
        sixbitMap.put("d", "101100");
        sixbitMap.put("e", "101101");
        sixbitMap.put("f", "101110");
        sixbitMap.put("g", "101111");
        sixbitMap.put("h", "110000");
        sixbitMap.put("i", "110001");
        sixbitMap.put("j", "110010");
        sixbitMap.put("k", "110011");
        sixbitMap.put("l", "110100");
        sixbitMap.put("m", "110101");
        sixbitMap.put("n", "110110");
        sixbitMap.put("o", "110111");
        sixbitMap.put("p", "111000");
        sixbitMap.put("q", "111001");
        sixbitMap.put("r", "111010");
        sixbitMap.put("s", "111011");
        sixbitMap.put("t", "111100");
        sixbitMap.put("u", "111101");
        sixbitMap.put("v", "111110");
        sixbitMap.put("w", "111111");
        return sixbitMap;
    }

    public static void setSixbitMap(Map sixbitMap) {
        GlobalVariable.sixbitMap = sixbitMap;
    }
}