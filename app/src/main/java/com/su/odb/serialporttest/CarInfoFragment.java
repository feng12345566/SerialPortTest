package com.su.odb.serialporttest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.su.sdk.OBDCmd;
import com.su.sdk.ObdUtil;
import com.su.sdk.OnReceiveListener;
import com.su.sdk.ResponseData;
import com.su.sdk.ResponsePraser;

import android_serialport_api.SerialManager;

/**
 * Created by Admin on 2016/7/29.
 */
public class CarInfoFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_carinfo,container,false);

        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            getDeviceInfo();
        }
    }


    private void getDeviceInfo(){
        SerialManager.getInstance().registerReceiveListener(new OnReceiveListener() {
            @Override
            public void onBytesReceive(byte[] data) {
                Log.e("onBytesReceive", ObdUtil.bytesToHexString(data)) ;
                ResponseData responseData=ResponsePraser.parse(data);
                switch (responseData.getCmdType()){

                }
            }
        });
        SerialManager.getInstance().sendBytes(ObdUtil.hexStringToByte(OBDCmd.CMD_VIN));

    }
}
