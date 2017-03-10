package com.su.sdk;

/**
 * Created by Admin on 2016/8/6.
 */
public class ObdData {

    //清除故障是否成功
    private boolean clearErr;
    //里程信息
    private int km;
    //转速
    private int rotateSpeed;


    /**
     * 空气流量
     */
    private double airMassFlow;

    //发动机是否正常
    private boolean engine;
    //变速箱是否正常
    private boolean  gearbox;
    //刹车是否正常
    private boolean brake;
    //安全气囊是否正常
    private boolean srs;

    /**
     * 发动机负荷值
     */
    private int engineLoad;

    /**
     * 冷却液温度
     */
    private int coolantTemp;


    /**
     * 车速
     */
    private int speed;


    /**
     * 进气温度
     */
    private int temp;


    /**
     * 节气门绝对位置
     */
    private int  throttlePos;


    /**
     * 电瓶电压
     */
    private double voltage;

    /**
     * 燃油修正
     */
    private  double fuelTrim;


    /**
     * 故障状态
     */
    private int errState;


    /**
     * 点火提前角
     */
    private double ignitionAdvanceAngle;


    /**
     * 进气管压力
     */
    private int manifoldPressure;


    /**
     * OBD类型
     */
    private String OBDType;


    /**
     * 瞬时油耗 (按小时计量)
     */
    private int instantaneousOilPerHour;


    /**
     * 瞬时油耗 (按百公里计量)
     */
    private double instantaneousOilPerKilKm;


    private  double oilLeft;


    public double getOilLeft() {
        return oilLeft;
    }

    public void setOilLeft(double oilLeft) {
        this.oilLeft = oilLeft;
    }

    public int getManifoldPressure() {
        return manifoldPressure;
    }

    public void setManifoldPressure(int manifoldPressure) {
        this.manifoldPressure = manifoldPressure;
    }

    public double getIgnitionAdvanceAngle() {
        return ignitionAdvanceAngle;
    }

    public void setIgnitionAdvanceAngle(double ignitionAdvanceAngle) {
        this.ignitionAdvanceAngle = ignitionAdvanceAngle;
    }

    public int getRotateSpeed() {
        return rotateSpeed;
    }

    public void setRotateSpeed(int rotateSpeed) {
        this.rotateSpeed = rotateSpeed;
    }


    public boolean isClearErr() {
        return clearErr;
    }

    public void setClearErr(boolean clearErr) {
        this.clearErr = clearErr;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public boolean isEngine() {
        return engine;
    }

    public void setEngine(boolean engine) {
        this.engine = engine;
    }

    public boolean isGearbox() {
        return gearbox;
    }

    public void setGearbox(boolean gearbox) {
        this.gearbox = gearbox;
    }

    public boolean isBrake() {
        return brake;
    }

    public void setBrake(boolean brake) {
        this.brake = brake;
    }

    public boolean isSrs() {
        return srs;
    }

    public void setSrs(boolean srs) {
        this.srs = srs;
    }

    public int getEngineLoad() {
        return engineLoad;
    }

    public void setEngineLoad(int engineLoad) {
        this.engineLoad = engineLoad;
    }

    public int getCoolantTemp() {
        return coolantTemp;
    }

    public void setCoolantTemp(int coolantTemp) {
        this.coolantTemp = coolantTemp;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public double getAirMassFlow() {
        return airMassFlow;
    }

    public void setAirMassFlow(double airMassFlow) {
        this.airMassFlow = airMassFlow;
    }

    public int getThrottlePos() {
        return throttlePos;
    }

    /**
     * 设置节气门绝对位置
     * @param throttlePos  节气门绝对位置
     */
    public void setThrottlePos(int throttlePos) {
        this.throttlePos = throttlePos;
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public double getFuelTrim() {
        return fuelTrim;
    }

    public void setFuelTrim(double fuelTrim) {
        this.fuelTrim = fuelTrim;
    }

    public int getErrState() {
        return errState;
    }

    public void setErrState(int errState) {
        this.errState = errState;
    }

    public String getOBDType() {
        return OBDType;
    }

    public void setOBDType(String OBDType) {
        this.OBDType = OBDType;
    }

    public int getInstantaneousOilPerHour() {
        return instantaneousOilPerHour;
    }

    public void setInstantaneousOilPerHour(int instantaneousOilPerHour) {
        this.instantaneousOilPerHour = instantaneousOilPerHour;
    }

    public double getInstantaneousOilPerKilKm() {
        return instantaneousOilPerKilKm;
    }

    public void setInstantaneousOilPerKilKm(double instantaneousOilPerKilKm) {
        this.instantaneousOilPerKilKm = instantaneousOilPerKilKm;
    }


}
