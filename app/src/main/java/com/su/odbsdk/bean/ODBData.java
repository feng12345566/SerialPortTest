package com.su.odbsdk.bean;

/**
 * Created by Admin on 2016/7/30.
 */
public class ODBData {
    private  String cmd;
    //数据项目名称
    private String key;
    //数据值
    private String value;
    private String unit;

    public ODBData(String key, String value, String unit) {
        this.key = key;
        this.value = value;
        this.unit = unit;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
