package com.su.sdk;

import android.util.Log;

import com.google.gson.Gson;

/**
 * 数据接收解析器
 * Created by Admin on 2016/8/7.
 */
public class ResponsePraser {

    /**
     * 解析接收数据
     * @param data   接收原始数据
     * @return  解析结果
     */
    public static  ResponseData parse(byte[] data){
        if(data==null||data.length<6){
            return null;
        }
        int cmdType=ObdUtil.byte2Int(data[2]);
        ResponseData responseData=new ResponseData();
        responseData.setCmdType(cmdType);
        switch (cmdType){
            case 1:
                if(data.length!=32){
                    Log.e("ResponsePraser","接收数据流信息异常");
                }else{
                    ObdData obdData=new ObdData();
                    obdData.setEngineLoad(ObdUtil.byte2Int(data[4]));
                    obdData.setCoolantTemp(ObdUtil.byte2Int(data[5])-40);
                    byte[] rotate=ObdUtil.subBytes(data,6,2);
                    obdData.setRotateSpeed(ObdUtil.bytesToInt2(rotate,0));
                    byte[] km=ObdUtil.subBytes(data,8,4);
                    obdData.setKm(ObdUtil.bytesToInt2(km,0));
                    obdData.setSpeed(ObdUtil.byte2Int(data[12]));
                    obdData.setTemp(ObdUtil.byte2Int(data[13]));
                    obdData.setAirMassFlow((ObdUtil.byte2Int(data[14])*256+ObdUtil.byte2Int(data[15])));
                    obdData.setThrottlePos(ObdUtil.byte2Int(data[16]));
                    obdData.setVoltage(ObdUtil.byte2Int(data[17]));
                    obdData.setErrState(ObdUtil.byte2Int(data[18]));
                    obdData.setFuelTrim((ObdUtil.byte2Int(data[19])-128)*100.0/128);
                    obdData.setIgnitionAdvanceAngle(ObdUtil.byte2Int(data[20])-64);
                    obdData.setManifoldPressure(ObdUtil.byte2Int(data[21]));
                    int type=ObdUtil.byte2Int(data[22]);
                    if(type<13) {
                        String[] typeStr = new String[]{"OBD II", "OBD", "OBD and OBD II", "OBD I", "NO OBD", "EOBD", "EOBD and OBD II", "EOBD and OBD", "EOBD, OBD and OBD II", "JOBD", "JOBD and OBD II", "JOBD and EOBD", "JOBD, EOBD and OBD II"};
                        obdData.setOBDType(typeStr[type - 1]);
                    }
                    obdData.setInstantaneousOilPerHour(ObdUtil.byte2Int(data[23]));
                    obdData.setInstantaneousOilPerKilKm(ObdUtil.byte2Int(data[24]));
                    responseData.setData(obdData);
                }
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                if(data.length!=32){
                    Log.e("ResponsePraser","接收发动机故障信息异常");
                }else {

                }
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                if(data.length!=12){
                    Log.e("ResponsePraser","接收剩余燃油信息异常");
                }else {
                    ObdData obdData=new ObdData();
                    byte[] oil=ObdUtil.subBytes(data,4,4);
                    obdData.setOilLeft(ObdUtil.bytesToInt2(oil,0));
                    responseData.setData(obdData);
                }
                break;

            case 24:
                if(data.length!=14){
                    Log.e("ResponsePraser","接收电压信息异常");
                }else {
                    ObdData obdData=new ObdData();
                    byte[] voltage=ObdUtil.subBytes(data,4,4);
                    obdData.setVoltage(ObdUtil.bytesToInt2(voltage,0)/1000.0);
                    responseData.setData(obdData);
                }
                break;

        }

        Gson gson=new Gson();
        Log.e("ResponseData",gson.toJson(responseData));
        return responseData;
    }
}
