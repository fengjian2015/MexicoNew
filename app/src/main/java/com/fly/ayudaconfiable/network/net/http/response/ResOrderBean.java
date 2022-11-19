package com.fly.ayudaconfiable.network.net.http.response;

import java.io.Serializable;
import java.util.List;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月3日,0003.
 * 158045632@qq.com  ,所有消费共用的 返回订单信息
 */
public class ResOrderBean implements Serializable{
    /**
     * BillCode : XF201908031028000403
     * TotalMoney : 100
     * TotalMoney : 365
     * GiveMoney : 0
     * RealMoney : 365
     * GivePoint : 0
     * DiscountMoney : 100
     * TotalPoint : 0
     * ActivityAmount : 0
     * CouponAmount : 0
     * ZeroAmount : 0
     * SingleAmount : 0
     * Payments : []
     */

    private int ChangeType;
    private double ChangePoint;
    private double EndPoint;

    private String HandCode = "";
    private String Id= "";
    private String BillCode= "";
    private double TotalMoney;
    private double DiscountMoney;
    private double TotalPoint;
    private double ActivityAmount;
    private double CouponAmount;
    private double ZeroAmount;
    private double SingleAmount;
    private double GiveMoney;
    private double RealMoney;
    private double GivePoint;
    private double TotalNum;
    private double Postage;
    private double CardMoney;
    private int OrderType;
    private int OrderMain;//扫描点餐使用
    private String ShopName= "";//扫描点餐使用
    private List<PaymentsBean> Payments;

    public String getHandCode() {
        return HandCode;
    }

    public void setHandCode(String handCode) {
        HandCode = handCode;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getBillCode() {
        return BillCode;
    }

    public void setBillCode(String billCode) {
        BillCode = billCode;
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

    public double getGiveMoney() {
        return GiveMoney;
    }

    public void setGiveMoney(double giveMoney) {
        GiveMoney = giveMoney;
    }

    public double getRealMoney() {
        return RealMoney;
    }

    public void setRealMoney(double realMoney) {
        RealMoney = realMoney;
    }

    public double getGivePoint() {
        return GivePoint;
    }

    public void setGivePoint(double givePoint) {
        GivePoint = givePoint;
    }

    public double getTotalNum() {
        return TotalNum;
    }

    public void setTotalNum(double totalNum) {
        TotalNum = totalNum;
    }

    public double getPostage() {
        return Postage;
    }

    public void setPostage(double postage) {
        Postage = postage;
    }

    public double getCardMoney() {
        return CardMoney;
    }

    public void setCardMoney(double cardMoney) {
        CardMoney = cardMoney;
    }

    public int getOrderMain() {
        return OrderMain;
    }

    public void setOrderMain(int orderMain) {
        OrderMain = orderMain;
    }

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String shopName) {
        ShopName = shopName;
    }

    public List<PaymentsBean> getPayments() {
        return Payments;
    }

    public void setPayments(List<PaymentsBean> payments) {
        Payments = payments;
    }

    public int getChangeType() {
        return ChangeType;
    }

    public void setChangeType(int changeType) {
        ChangeType = changeType;
    }

    public double getChangePoint() {
        return ChangePoint;
    }

    public void setChangePoint(double changePoint) {
        ChangePoint = changePoint;
    }

    public double getEndPoint() {
        return EndPoint;
    }

    public void setEndPoint(double endPoint) {
        EndPoint = endPoint;
    }

    public int getOrderType() {
        return OrderType;
    }

    public void setOrderType(int orderType) {
        OrderType = orderType;
    }
}
