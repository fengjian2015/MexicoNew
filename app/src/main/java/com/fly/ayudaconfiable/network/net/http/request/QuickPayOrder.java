package com.fly.ayudaconfiable.network.net.http.request;

public class QuickPayOrder {

    private int Source = 3;
    private int OrderType = 1;
    private double ActivityAmount = 0;
    private double CouponAmount = 0;
    private double ZeroAmount = 0;
    private double SingleAmount = 0;
    private double TotalMoney = 0;
    private double DiscountMoney = 0;
    private double TotalPoint = 0;
    private double TotalNum;
    private String MemID = "";
    private String Remark = "";

    public int getSource() {
        return Source;
    }

    public void setSource(int source) {
        Source = source;
    }

    public int getOrderType() {
        return OrderType;
    }

    public void setOrderType(int orderType) {
        OrderType = orderType;
    }

    public double getActivityAmount() {
        return ActivityAmount;
    }

    public void setActivityAmount(double activityAmount) {
        ActivityAmount = activityAmount;
    }

    public double getCouponAmount() {
        return CouponAmount;
    }

    public void setCouponAmount(double couponAmount) {
        CouponAmount = couponAmount;
    }

    public double getZeroAmount() {
        return ZeroAmount;
    }

    public void setZeroAmount(double zeroAmount) {
        ZeroAmount = zeroAmount;
    }

    public double getSingleAmount() {
        return SingleAmount;
    }

    public void setSingleAmount(double singleAmount) {
        SingleAmount = singleAmount;
    }

    public double getTotalMoney() {
        return TotalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        TotalMoney = totalMoney;
    }

    public double getDiscountMoney() {
        return DiscountMoney;
    }

    public void setDiscountMoney(double discountMoney) {
        DiscountMoney = discountMoney;
    }

    public double getTotalPoint() {
        return TotalPoint;
    }

    public void setTotalPoint(double totalPoint) {
        TotalPoint = totalPoint;
    }

    public double getTotalNum() {
        return TotalNum;
    }

    public void setTotalNum(double totalNum) {
        TotalNum = totalNum;
    }

    public String getMemID() {
        return MemID;
    }

    public void setMemID(String memID) {
        MemID = memID;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }
}
