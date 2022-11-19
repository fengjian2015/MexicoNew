package com.fly.ayudaconfiable.network.net.http.response;

public class OilGivenPrintBean {

    /**
     * GoodsName : 玻璃水
     * GoodsType : 1
     * GiveawayNum : 1
     */

    private String GoodsName="";
    private int GoodsType;
    private double GiveawayNum;

    public String getGoodsName() {
        return GoodsName;
    }

    public void setGoodsName(String GoodsName) {
        this.GoodsName = GoodsName;
    }

    public int getGoodsType() {
        return GoodsType;
    }

    public void setGoodsType(int GoodsType) {
        this.GoodsType = GoodsType;
    }

    public double getGiveawayNum() {
        return GiveawayNum;
    }

    public void setGiveawayNum(double GiveawayNum) {
        this.GiveawayNum = GiveawayNum;
    }
}
