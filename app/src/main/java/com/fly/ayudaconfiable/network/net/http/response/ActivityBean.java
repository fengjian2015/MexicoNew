package com.fly.ayudaconfiable.network.net.http.response;

import java.io.Serializable;
import java.util.List;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月5日,0005.
 * 158045632@qq.com
 */
public class ActivityBean implements Serializable {

    /**
     * Id : 14341898873681920
     * ActName : 测试消费返利
     * ActType : 1
     * LimitUsedAmount : 200
     * IsGiveMoney : 0
     * GiveMoney : 0
     * IsGivePoint : 0
     * GivePoint : 0
     * IsGiveConpon : 1
     * GiveConpon : [{"Id":"14332517962364928","Qty":22,"Name":"测试代金券"}]
     * IsReduceAmount : 1
     * ReduceAmount : 11
     * ValidType : 2
     * ValidStartTime : 0
     * ValidEndTime : 0
     * ValidDays : 1,2,3,4,5,6
     * <p>
     * "ActIsDouble": 0, 满送金额翻倍：0-否、1-是
     * "SubIsDouble": 0,满减金额翻倍 0否 1是
     * "PointIsDouble": 0,积分翻倍0否 1是
     */

    public int AccountType;
    private int ActType;
    private int IsGiveMoney;
    private int IsGivePoint;
    private int IsGiveConpon;
    private int IsReduceAmount;
    private int ValidType;
    private int ActIsDouble;
    private int SubIsDouble;
    private int PointIsDouble;
    private int RewardAccountType;
    private double LimitUsedAmount;
    private double GiveMoney;
    private double GivePoint;
    public double realReduceAmount;
    private double ReduceAmount;
    private long CreateTime;
    private long ValidStartTime;
    private long ValidEndTime;
    private String Id = "";
    private String ActName = "";
    private String ValidDays = "";
    private List<GiveConponBean> GiveConpon;
    //适用支付方式 0全部 1指定支付方式
    private int PaymentWay;
    //指定支付方式Code 逗号分隔
    private String PaymentCodeStr;
    //非接口返回的
    public boolean isSelected = false;

    public int getAccountType() {
        return AccountType;
    }

    public void setAccountType(int accountType) {
        AccountType = accountType;
    }

    public int getActType() {
        return ActType;
    }

    public void setActType(int actType) {
        ActType = actType;
    }

    public int getIsGiveMoney() {
        return IsGiveMoney;
    }

    public void setIsGiveMoney(int isGiveMoney) {
        IsGiveMoney = isGiveMoney;
    }

    public int getIsGivePoint() {
        return IsGivePoint;
    }

    public void setIsGivePoint(int isGivePoint) {
        IsGivePoint = isGivePoint;
    }

    public int getIsGiveConpon() {
        return IsGiveConpon;
    }

    public void setIsGiveConpon(int isGiveConpon) {
        IsGiveConpon = isGiveConpon;
    }

    public int getIsReduceAmount() {
        return IsReduceAmount;
    }

    public void setIsReduceAmount(int isReduceAmount) {
        IsReduceAmount = isReduceAmount;
    }

    public int getValidType() {
        return ValidType;
    }

    public void setValidType(int validType) {
        ValidType = validType;
    }

    public int getActIsDouble() {
        return ActIsDouble;
    }

    public void setActIsDouble(int actIsDouble) {
        ActIsDouble = actIsDouble;
    }

    public int getSubIsDouble() {
        return SubIsDouble;
    }

    public void setSubIsDouble(int subIsDouble) {
        SubIsDouble = subIsDouble;
    }

    public int getPointIsDouble() {
        return PointIsDouble;
    }

    public void setPointIsDouble(int pointIsDouble) {
        PointIsDouble = pointIsDouble;
    }

    public int getRewardAccountType() {
        return RewardAccountType;
    }

    public void setRewardAccountType(int rewardAccountType) {
        RewardAccountType = rewardAccountType;
    }

    public double getLimitUsedAmount() {
        return LimitUsedAmount;
    }

    public void setLimitUsedAmount(double limitUsedAmount) {
        LimitUsedAmount = limitUsedAmount;
    }

    public double getGiveMoney() {
        return GiveMoney;
    }

    public void setGiveMoney(double giveMoney) {
        GiveMoney = giveMoney;
    }

    public double getGivePoint() {
        return GivePoint;
    }

    public void setGivePoint(double givePoint) {
        GivePoint = givePoint;
    }

    public double getRealReduceAmount() {
        return realReduceAmount;
    }

    public void setRealReduceAmount(double realReduceAmount) {
        this.realReduceAmount = realReduceAmount;
    }

    public double getReduceAmount() {
        return ReduceAmount;
    }

    public void setReduceAmount(double reduceAmount) {
        ReduceAmount = reduceAmount;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public long getValidStartTime() {
        return ValidStartTime;
    }

    public void setValidStartTime(long validStartTime) {
        ValidStartTime = validStartTime;
    }

    public long getValidEndTime() {
        return ValidEndTime;
    }

    public void setValidEndTime(long validEndTime) {
        ValidEndTime = validEndTime;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getActName() {
        return ActName;
    }

    public void setActName(String actName) {
        ActName = actName;
    }

    public String getValidDays() {
        return ValidDays;
    }

    public void setValidDays(String validDays) {
        ValidDays = validDays;
    }

    public List<GiveConponBean> getGiveConpon() {
        return GiveConpon;
    }

    public void setGiveConpon(List<GiveConponBean> giveConpon) {
        GiveConpon = giveConpon;
    }

    public int getPaymentWay() {
        return PaymentWay;
    }

    public void setPaymentWay(int paymentWay) {
        PaymentWay = paymentWay;
    }

    public String getPaymentCodeStr() {
        return PaymentCodeStr;
    }

    public void setPaymentCodeStr(String paymentCodeStr) {
        PaymentCodeStr = paymentCodeStr;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
