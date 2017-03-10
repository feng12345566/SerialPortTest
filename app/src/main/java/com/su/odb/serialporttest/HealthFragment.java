package com.su.odb.serialporttest;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.LinearLayout;
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
import java.util.logging.Logger;

import android_serialport_api.SerialManager;

/**
 * Created by Admin on 2016/8/2.
 */
public class HealthFragment extends Fragment {

    private StreamDataAdapter adapter;
    private TextView pageTitle;
    private String[] items=new String[]{"发动机系统","自动变速箱系统","刹车系统","安全气囊系统","剩余燃油","故障码","电池电压","环境温度","电池历史电压"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_odbdata, container, false);
        pageTitle= (TextView) view.findViewById(R.id.pageTitle);
        pageTitle.setText("健康信息：");
        ListView listView= (ListView) view.findViewById(R.id.dataLisView);
        List<ODBData> odbDatas=new ArrayList<ODBData>();
        for(int i=0;i<items.length;i++) {
            ODBData data = new ODBData(items[i], "", "");
            odbDatas.add(data);
        }
        adapter=new StreamDataAdapter(getActivity(),odbDatas);
        LinearLayout ll=new LinearLayout(getActivity());
        ll.setOrientation(LinearLayout.HORIZONTAL);
        ll.setLayoutParams(new AbsListView.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        Button button=new Button(getActivity());
        button.setText("开始体检");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getHealthData();
            }
        });
        ll.addView(button);
        listView.addHeaderView(ll);
        listView.setAdapter(adapter);

        return view;
    }



    private void updataList(ResponseData responseData){
         List<ODBData> datas=adapter.getOdbDataList();
        switch (responseData.getCmdType()){
            case 8:
                ODBData odbData=datas.get(4);
                double oil=responseData.getData().getOilLeft();
                int startand=8*16*16;
                Log.e("startand",startand+"");
                if(oil>startand) {
                    odbData.setValue((oil-startand)/10+ "");
                    odbData.setUnit("%");
                }else{
                    odbData.setValue(oil/10 + "");
                    odbData.setUnit("L");
                }
                datas.set(4,odbData);
                break;
            case 24:
                ODBData odbData1=datas.get(6);
                odbData1.setValue(responseData.getData().getVoltage()+"");
                odbData1.setUnit("V");
                datas.set(6,odbData1);
                break;
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


    private void getHealthData(){
        SerialManager.getInstance().registerReceiveListener(new OnReceiveListener() {
            @Override
            public void onBytesReceive(byte[] data) {
                Log.e("onBytesReceive", ObdUtil.bytesToHexString(data)) ;
                ResponseData responseData= ResponsePraser.parse(data);
                updataList(responseData);
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {

                    SerialManager.getInstance().sendBytes(ObdUtil.hexStringToByte(OBDCmd.CMD_OILLEFT));
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                SerialManager.getInstance().sendBytes(ObdUtil.hexStringToByte(OBDCmd.CMD_VOLTAGE));
            }
        }).start();

    }



}
