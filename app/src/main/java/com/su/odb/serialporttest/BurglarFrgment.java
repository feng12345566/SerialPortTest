package com.su.odb.serialporttest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.su.odb.adapter.StreamDataAdapter;
import com.su.odbsdk.bean.ODBData;

import java.util.ArrayList;
import java.util.List;

/**
 * 防盗信息
 * Created by Admin on 2016/8/2.
 */
public class BurglarFrgment extends Fragment{
    private StreamDataAdapter adapter;
    private TextView pageTitle;
    private String[] items=new String[]{"左前门","右前门","左后门","右后门","尾箱门","中控锁","小灯","远光灯","近光灯","雾灯","危险灯","左转向灯","右转向灯","主驾驶安全带","副驾驶安全带","ACC信号","档位"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_odbdata, container, false);
        pageTitle= (TextView) view.findViewById(R.id.pageTitle);
        pageTitle.setText("防盗信息：");
        ListView listView= (ListView) view.findViewById(R.id.dataLisView);
        List<ODBData> odbDatas=new ArrayList<ODBData>();
        for(int i=0;i<items.length;i++) {
            ODBData data = new ODBData(items[i], "关", "");
            odbDatas.add(data);
        }
        adapter=new StreamDataAdapter(getActivity(),odbDatas);
        listView.setAdapter(adapter);

        return view;
    }
}
