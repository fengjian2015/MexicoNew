package com.fly.ayudaconfiable.network.net.http.request;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月9日,0009.
 * 158045632@qq.com
 */
public class GiftExchangeDetail {
    /**
     * GoodsID : null
     * GoodsType : 0
     * GoodsCode : null
     * GoodsName : null
     * DiscountPrice : 0
     * Number : 0
     * TotalMoney : 0
     */
    /***
     * 礼品 这里的定义有点歧义，当产品用的，取出来的是id, 这里变成GoodID,
     * 兑换积分用的是 DiscountPrice， 即积分数
     */
    private String GoodsID;
    private int GoodsType;
    private String GoodsCode;
    private String GoodsName;
    private double DiscountPrice;
    private double Number;
    private double TotalMoney;

    public String getGoodsID() {
        return GoodsID;
    }

    public void setGoodsID(String goodsID) {
        GoodsID = goodsID;
    }

    public int getGoodsType() {
        return GoodsType;
    }

    public void setGoodsType(int goodsType) {
        GoodsType = goodsType;
    }

    public String getGoodsCode() {
        return GoodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        GoodsCode = goodsCode;
    }

    public String getGoodsName() {
        return GoodsName;
    }

    public void setGoodsName(String goodsName) {
        GoodsName = goodsName;
    }

    public double getDiscountPrice() {
        return DiscountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        DiscountPrice = discountPrice;
    }

    public double getNumber() {
        return Number;
    }

    public void setNumber(double number) {
        Number = number;
    }

    public double getTotalMoney() {
        return TotalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        TotalMoney = totalMoney;
    }
}
