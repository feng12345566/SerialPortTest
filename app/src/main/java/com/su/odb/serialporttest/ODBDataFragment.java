package com.su.odb.serialporttest;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.su.odb.adapter.StreamDataAdapter;
import com.su.odbsdk.bean.ODBData;
import com.su.sdk.OBDCmd;
import com.su.sdk.ObdData;
import com.su.sdk.ObdUtil;
import com.su.sdk.OnReceiveListener;
import com.su.sdk.ResponseData;
import com.su.sdk.ResponsePraser;

import java.util.ArrayList;
import java.util.List;

import android_serialport_api.SerialManager;


public class ODBDataFragment extends Fragment {
    private boolean flag=true;
    private StreamDataAdapter adapter;
    private TextView pageTitle;
    private String[] items=new String[]{"转速","车速","瞬时油耗","百公里耗油","总里程（公里）","发动机负荷计算值","冷却液温度","进气温度","空气流量","节气门绝对位置",
    "车辆电瓶电压","发动机状态","长期原油修正","气缸1点火提前角","进气管绝对压力","ODB类型","方向盘角度"};



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_odbdata, container, false);
        pageTitle= (TextView) view.findViewById(R.id.pageTitle);
        pageTitle.setText("数据信息：");
        ListView listView= (ListView) view.findViewById(R.id.dataLisView);
        List<ODBData> odbDatas=new ArrayList<ODBData>();
        for(int i=0;i<items.length;i++) {
            ODBData data = new ODBData(items[i], "", "");
            odbDatas.add(data);
        }
        adapter=new StreamDataAdapter(getActivity(),odbDatas);
        listView.setAdapter(adapter);
        return view;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            flag=true;
            getObdData();
        }else{
            flag=false;
        }
    }


    private void updataList(ObdData obdData){
        final List<ODBData> datas=adapter.getOdbDataList();
        for(int i=0;i<datas.size();i++){
            ODBData data=datas.get(i);
            String key=data.getKey();
            if(key==items[0]){
                data.setValue(obdData.getRotateSpeed()+"");
                data.setUnit("rpm");
            }else if(key==items[1]){
                data.setValue(obdData.getSpeed()+"");
                data.setUnit("Km/h");
            }else if(key==items[2]){
                data.setValue(obdData.getInstantaneousOilPerHour()+"");
                data.setUnit("L/H");
            }else if(key==items[3]){
                data.setValue(obdData.getInstantaneousOilPerKilKm()+"");
                data.setUnit("L/100Km");
            }else if(key==items[4]){
                data.setValue(obdData.getKm()+"");
                data.setUnit("Km");
            }else if(key==items[5]){
                data.setValue(obdData.getEngineLoad()+"");
                data.setUnit("%");
            }else if(key==items[6]){
                data.setValue(obdData.getCoolantTemp()+"");
                data.setUnit("℃");
            }else if(key==items[7]){
                data.setValue(obdData.getTemp()+"");
                data.setUnit("℃");
            }else if(key==items[8]){
                data.setValue(obdData.getAirMassFlow()+"");
                data.setUnit("g/s");
            }else if(key==items[9]){
                data.setValue(obdData.getThrottlePos()+"");
                data.setUnit("%");
            }else if(key==items[10]){
                data.setValue(obdData.getVoltage()+"");
                data.setUnit("V");
            }else if(key==items[11]){
                data.setValue(obdData.isEngine()?"正常":"异常");
                data.setUnit("");
            }else if(key==items[12]){
                data.setValue(obdData.getFuelTrim()+"");
                data.setUnit("%");
            }else if(key==items[13]){
                data.setValue(obdData.getIgnitionAdvanceAngle()+"");
                data.setUnit("°");
            }else if(key==items[14]){
                data.setValue(obdData.getManifoldPressure()+"");
                data.setUnit("");
            }else if(key==items[15]){
                data.setValue(obdData.getOBDType()+"");
                data.setUnit("");
            }

            datas.set(i,data);
        }
        Message message=new Message();
        message.obj=datas;
        message.what=0;
        handler.sendMessage(message);
    }

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            List<ODBData> datas= (List<ODBData>) msg.obj;
            adapter.setOdbDataList(datas);
        }
    };


    private void getObdData(){
        SerialManager.getInstance().registerReceiveListener(new OnReceiveListener() {
            @Override
            public void onBytesReceive(byte[] data) {
                Log.e("onBytesReceive", ObdUtil.bytesToHexString(data)) ;
                ResponseData responseData= ResponsePraser.parse(data);
                 if(responseData.getCmdType()==1){
                     updataList(responseData.getData());
                 }
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag) {
                    SerialManager.getInstance().sendBytes(ObdUtil.hexStringToByte(OBDCmd.CMD_STREAM));
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    @Override
    public void onDestroy() {

        super.onDestroy();
    }
}
