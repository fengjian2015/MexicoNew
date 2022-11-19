package com.fly.ayudaconfiable.network.net.http.response;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月5日,0005.
 * 158045632@qq.com
 */
public class GoodsSpecsInfo {
    /**
     * SpecsID : 14479540011694082
     * Price : 10.0
     * Specials : 0.0
     * StockNum : 100.0
     */
    private String SpecsID;
    private String SpecsNo;//货号
    private double Price;
    private double Specials;
    private double StockNum;

    public String specsName = null;

    public String getSpecsID() {
        return SpecsID;
    }

    public void setSpecsID(String SpecsID) {
        this.SpecsID = SpecsID;
    }

    public String getSpecsNo() {
        return SpecsNo;
    }

    public void setSpecsNo(String specsNo) {
        SpecsNo = specsNo;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public double getSpecials() {
        return Specials;
    }

    public void setSpecials(double Specials) {
        this.Specials = Specials;
    }

    public double getStockNum() {
        return StockNum;
    }

    public void setStockNum(double StockNum) {
        this.StockNum = StockNum;
    }
}
