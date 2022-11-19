package com.fly.ayudaconfiable.network.net.http.response;

public class OilpayRecordBean {

    /**
     * BillCode : JY15206696712599552
     * TotalPoint : 0.0
     * ShopName : 丽丽家
     * CreateTime : 20210318093201
     * UserName : drr
     * DiscountMoney : 167.88
     * OrderType : 10
     */

    private int OrderType;
    private double TotalPoint;
    private double DiscountMoney;
    private long CreateTime;
    private String BillCode = "";
    private String ShopName = "";
    private String UserName = "";

    public String getBillCode() {
        return BillCode;
    }

    public void setBillCode(String BillCode) {
        this.BillCode = BillCode;
    }

    public double getTotalPoint() {
        return TotalPoint;
    }

    public void setTotalPoint(double TotalPoint) {
        this.TotalPoint = TotalPoint;
    }

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String ShopName) {
        this.ShopName = ShopName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long CreateTime) {
        this.CreateTime = CreateTime;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public double getDiscountMoney() {
        return DiscountMoney;
    }

    public void setDiscountMoney(double DiscountMoney) {
        this.DiscountMoney = DiscountMoney;
    }

    public int getOrderType() {
        return OrderType;
    }

    public void setOrderType(int OrderType) {
        this.OrderType = OrderType;
    }

}
