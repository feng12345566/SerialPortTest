package com.su.sdk;

/**
 * 请求命令构造类
 */
public class OBDCmd {
    /**
     * 获取数据流信息
     */
    public static final String CMD_STREAM = "546B010060580D0A";
    /**
     * 获取转速
     */
    public static final String CMD_ROATESPEED = "546B020060A80D0A";
    /**
     * 车辆体检
     */
    public static final String CMD_CARHALTH = "546B010060580D0A";
    /**
     * 读取里程
     */
    public static final String CMD_KM = "546B040063080D0A";
    /**
     * 读取发动机故障信息
     */
    public static final String CMD_READENGINEERR = "546B060062680D0A";
    /**
     * 清除发动机故障信息
     */
    public static final String CMD_CLEARENGINEERR = "546B050062980D0A";
    /**
     * 获取VIN信息
     */
    public static final String CMD_VIN = "546B070063F80D0A";
    /**
     * 读取剩余油量
     */
    public static final String CMD_OILLEFT = "546B080066080D0A";
    /**
     * 获取睡眠信息
     */
    public static final String CMD_SLEEPINFOGET = "546B17006E380D0A";
    /**
     * 获取电压
     */
    public static final String CMD_VOLTAGE = "546B18006BC80D0A";
    /**
     * 获取行驶速度
     */
    public static final String CMD_DRIVESPEED = "546B19006A580D0A";


    /**
     * 设置睡眠参数
     * @param sleep 是否开启睡眠
     * @param time  睡眠时间 （秒）
     * @return   睡眠参数命令
     */
    public static String createSleepInfo(boolean sleep, int time) {
        StringBuffer sb = new StringBuffer();
        sb.append("546B1602");
        sb.append(sleep?"01":"00");
        sb.append(ObdUtil.intToHex(time));
        sb.append("8C0F0D0A");
        return sb.toString();
    }

    /**
     * 清除某个系统的故障码
     * @param sysId 系统
     * @return 请求16进制字符串
     */
    public static String createClearErr(String sysId) {
        StringBuffer sb = new StringBuffer();
        sb.append("546B1101");
        sb.append(sysId);
        sb.append("99BD0D0A");
        return sb.toString();
    }

    /**
     * 读取某个系统的故障码
     * @param sysId  系统id
     * @return  请求16进制字符串
     */
    public static String creatReadErr(String sysId) {
        StringBuffer sb = new StringBuffer();
        sb.append("546B1201");
        sb.append(sysId);
        sb.append("69BD0D0A");
        return sb.toString();
    }


    /**
     * 系统id常量
     */
    public class SysId {
        /**
         *发动机系统
         */
       public static final String ECM="00";
        /**
         *自动变速箱系统
         */
        public static final String TCM="01";
        /**
         *刹车系统
         */
        public static final String ABS="03";
        /**
         *发动机系统
         */
        public static final String SRS="15";
    }
}
