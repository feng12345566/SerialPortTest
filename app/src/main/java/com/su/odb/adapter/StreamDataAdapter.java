package com.su.odb.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.gson.Gson;
import com.su.odb.serialporttest.R;
import com.su.odbsdk.bean.ODBData;

import java.util.List;

/**
 * Created by Admin on 2016/7/30.
 */
public class StreamDataAdapter extends BaseAdapter{
    private Context context;
    private List<ODBData> odbDataList;
    private LayoutInflater inflater;

    public StreamDataAdapter( Context context,List<ODBData> odbDataList) {
        this.odbDataList = odbDataList;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    public List<ODBData> getOdbDataList() {
        return odbDataList;
    }

    public void setOdbDataList(List<ODBData> odbDataList) {
        this.odbDataList = odbDataList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return odbDataList==null?0:odbDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return odbDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
       ODBData data= odbDataList.get(position);
        if(convertView==null){
            holder=new ViewHolder();
            convertView=inflater.inflate(R.layout.item_streamdata,parent,false);
            holder.createView(convertView);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        holder.itemKey.setText(data.getKey());
        holder.itemValue.setText(data.getValue()+" "+data.getUnit());
        return convertView;
    }


    class ViewHolder{
        private TextView itemKey;
        private TextView itemValue;


        public void createView(View view){
            itemKey= (TextView) view.findViewById(R.id.streamKey);
            itemValue= (TextView) view.findViewById(R.id.streamValue);
        }
    }
}
