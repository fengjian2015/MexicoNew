package com.fly.ayudaconfiable.network.net.http.response;

import java.io.Serializable;
import java.util.List;

/**
 * nakesoft
 * Created by 孔明 on 2019年7月17日,0017.
 * 158045632@qq.com
 */
public class ListMemLeveBean implements Serializable{
    /**
     * Id : 14307853800093696
     * LevelName : vip九折卡
     * StartValue : 100
     * PointPercent : 0.2
     * PointInfo : 10|2
     * DiscountPercent : 0.9
     * StartCount : [{"Id":"1","GoodsCode":"1001","GoodsName":"服务1","Qty":4},{"Id":"14333887240370176","GoodsCode":"20190710194348","GoodsName":"顶顶顶顶","Qty":5},{"Id":"14333895325562880","GoodsCode":"20190710195212","GoodsName":"顶顶顶","Qty":6}]
     * TimeCardQty : 99
     * Remark : 会员等级
     * SaleMoney : 10
     * ClassDiscountRules : [{"GoodsClassId":"14327973508200448","GoodsClassName":"默认分类234","Discount":0.06}]
     * FixedAmount : 100
     * IsDefault : 0
     */

    private String Id;
    private String LevelName;
    private double StartValue;
    private double PointPercent;
    private String PointInfo;
    private double DiscountPercent;
    private double TimeCardQty;
    private String Remark;
    private double SaleMoney;
    private double FixedAmount;
    private int IsDefault;
    private int IsOnlineDefault;
    private List<StartCountBean> StartCount;
    private List<ClassDiscountRulesBean> ClassDiscountRules;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getLevelName() {
        return LevelName;
    }

    public void setLevelName(String levelName) {
        LevelName = levelName;
    }

    public double getStartValue() {
        return StartValue;
    }

    public void setStartValue(double startValue) {
        StartValue = startValue;
    }

    public double getPointPercent() {
        return PointPercent;
    }

    public void setPointPercent(double pointPercent) {
        PointPercent = pointPercent;
    }

    public String getPointInfo() {
        return PointInfo;
    }

    public void setPointInfo(String pointInfo) {
        PointInfo = pointInfo;
    }

    public double getDiscountPercent() {
        return DiscountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        DiscountPercent = discountPercent;
    }

    public double getTimeCardQty() {
        return TimeCardQty;
    }

    public void setTimeCardQty(double timeCardQty) {
        TimeCardQty = timeCardQty;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public double getSaleMoney() {
        return SaleMoney;
    }

    public void setSaleMoney(double saleMoney) {
        SaleMoney = saleMoney;
    }

    public double getFixedAmount() {
        return FixedAmount;
    }

    public void setFixedAmount(double fixedAmount) {
        FixedAmount = fixedAmount;
    }

    public int getIsDefault() {
        return IsDefault;
    }

    public void setIsDefault(int isDefault) {
        IsDefault = isDefault;
    }

    public int getIsOnlineDefault() {
        return IsOnlineDefault;
    }

    public void setIsOnlineDefault(int isOnlineDefault) {
        IsOnlineDefault = isOnlineDefault;
    }

    public List<StartCountBean> getStartCount() {
        return StartCount;
    }

    public void setStartCount(List<StartCountBean> startCount) {
        StartCount = startCount;
    }

    public List<ClassDiscountRulesBean> getClassDiscountRules() {
        return ClassDiscountRules;
    }

    public void setClassDiscountRules(List<ClassDiscountRulesBean> classDiscountRules) {
        ClassDiscountRules = classDiscountRules;
    }

}
