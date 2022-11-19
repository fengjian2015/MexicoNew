package com.fly.ayudaconfiable.network.net.http.response;

/**
 * nakesoft
 * Created by 孔明 on 2019年7月16日,0016.
 * 158045632@qq.com
 */
public class BindMemLeveBean {
    /**
     * Id : 14307947124357120
     * LevelName : vip八折卡
     * IsDefault : 1
     * SaleMoney : 100.0
     * StartValue : 100.0
     */

    private String Id;
    private String LevelName;
    private int IsDefault;
    private double SaleMoney;
    private double StartValue;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getLevelName() {
        return LevelName;
    }

    public void setLevelName(String LevelName) {
        this.LevelName = LevelName;
    }

    public int getIsDefault() {
        return IsDefault;
    }

    public void setIsDefault(int IsDefault) {
        this.IsDefault = IsDefault;
    }

    public double getSaleMoney() {
        return SaleMoney;
    }

    public void setSaleMoney(double SaleMoney) {
        this.SaleMoney = SaleMoney;
    }

    public double getStartValue() {
        return StartValue;
    }

    public void setStartValue(double StartValue) {
        this.StartValue = StartValue;
    }
}
