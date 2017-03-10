package com.su.odb.adapter;

import android.content.Context;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.su.odb.serialporttest.R;
import com.su.odbsdk.bean.DeviceControlInfo;
import com.su.odbsdk.bean.ODBData;

import java.util.List;

/**
 * Created by Admin on 2016/7/30.
 */
public class ControlInfoAdapter extends BaseAdapter{
    private Context context;
    private List<DeviceControlInfo> infoList;
    private LayoutInflater inflater;

    public ControlInfoAdapter(Context context, List<DeviceControlInfo> infoList) {
        this.context = context;
        this.infoList = infoList;
        inflater=LayoutInflater.from(context);
    }

    public List<DeviceControlInfo> getInfoList() {
        return infoList;
    }

    public void setInfoList(List<DeviceControlInfo> infoList) {
        this.infoList = infoList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return infoList==null?0:infoList.size();
    }

    @Override
    public Object getItem(int position) {
        return infoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        DeviceControlInfo data= infoList.get(position);
        if(convertView==null){
            holder=new ViewHolder();
            convertView=inflater.inflate(R.layout.item_devicecontrol,parent,false);
            holder.createView(convertView);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        holder.controlInfoName.setText(data.getInfoName());
        holder.controlInfoSwitcher.setChecked(data.isOpened());
        return convertView;
    }

    class ViewHolder{
        private TextView controlInfoName;
        private SwitchCompat controlInfoSwitcher;


        public void createView(View view){
            controlInfoName= (TextView) view.findViewById(R.id.controlInfoName);
            controlInfoSwitcher= (SwitchCompat) view.findViewById(R.id.controlInfoSwitcher);
        }
    }


}
