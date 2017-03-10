package com.su.sdk;

/**
 * Created by Admin on 2016/8/7.
 */
public class ResponseData {
    //请求类型
    private int cmdType;

    private ObdData data;

    public int getCmdType() {
        return cmdType;
    }

    public void setCmdType(int cmdType) {
        this.cmdType = cmdType;
    }

    public ObdData getData() {
        return data;
    }

    public void setData(ObdData data) {
        this.data = data;
    }
}
