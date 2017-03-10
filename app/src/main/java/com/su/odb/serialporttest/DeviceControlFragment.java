package com.su.odb.serialporttest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.su.odb.adapter.ControlInfoAdapter;
import com.su.odbsdk.bean.DeviceControlInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2016/7/30.
 */
public class DeviceControlFragment extends Fragment{
      private  ListView listView;
    private String[] controlInfos=new String[]{"中控锁","喇叭","危险等","车窗","引擎"};
    private List<DeviceControlInfo> deviceControlInfos;
    private ControlInfoAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_devicecontrol,container,false);
        deviceControlInfos=new ArrayList<DeviceControlInfo>();
        for(int i=0;i<controlInfos.length;i++){
            DeviceControlInfo info=new DeviceControlInfo();
            info.setInfoName(controlInfos[i]);
            deviceControlInfos.add(info);
        }
        listView= (ListView) view.findViewById(R.id.deviceControlListView);
        adapter=new ControlInfoAdapter(getActivity(),deviceControlInfos);
        listView.setAdapter(adapter);
        return view;
    }
}
