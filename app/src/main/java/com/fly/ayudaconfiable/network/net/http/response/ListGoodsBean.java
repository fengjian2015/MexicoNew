package com.fly.ayudaconfiable.network.net.http.response;

import java.io.Serializable;

/**
 * nakesoft
 * Created by 孔明 on 2019年7月17日,0017.
 * 158045632@qq.com
 *  商品列表 展示的，用于修改
 */
public class ListGoodsBean implements Serializable{
    /**
     * Id : 14343187288668160
     * GoodsCode : 20190717092416
     * GoodsName : JAIJAI
     * GoodsClass : 14327973642582016
     * GoodsType : 1
     * Price : 1.0
     * StockNum : 0.0
     * Images :
     */

    private int IsShelf;
    private int GoodsType;
    private double Price;
    private double StockNum;
    private String Id="";
    private String GoodsCode="";
    private String GoodsName="";
    private String GoodsClass="";
    private String GoodsTypeName="";
    private String Images="";
    private String ShopID="";
    private String MeasureUnit="";
    /** 界面显示计数用，发送给后端用*/
    private double Qty;
    private int IsWeighable;
    private int SpecsType;
    private int ShelvesStatus;

    public int getIsShelf() {
        return IsShelf;
    }

    public void setIsShelf(int isShelf) {
        IsShelf = isShelf;
    }

    public int getGoodsType() {
        return GoodsType;
    }

    public void setGoodsType(int goodsType) {
        GoodsType = goodsType;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public double getStockNum() {
        return StockNum;
    }

    public void setStockNum(double stockNum) {
        StockNum = stockNum;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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

    public String getGoodsClass() {
        return GoodsClass;
    }

    public void setGoodsClass(String goodsClass) {
        GoodsClass = goodsClass;
    }

    public String getGoodsTypeName() {
        return GoodsTypeName;
    }

    public void setGoodsTypeName(String goodsTypeName) {
        GoodsTypeName = goodsTypeName;
    }

    public String getImages() {
        return Images;
    }

    public void setImages(String images) {
        Images = images;
    }

    public String getShopID() {
        return ShopID;
    }

    public void setShopID(String shopID) {
        ShopID = shopID;
    }

    public String getMeasureUnit() {
        return MeasureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        MeasureUnit = measureUnit;
    }

    public double getQty() {
        return Qty;
    }

    public void setQty(double qty) {
        Qty = qty;
    }

    public int getIsWeighable() {
        return IsWeighable;
    }

    public void setIsWeighable(int isWeighable) {
        IsWeighable = isWeighable;
    }

    public int getSpecsType() {
        return SpecsType;
    }

    public void setSpecsType(int specsType) {
        SpecsType = specsType;
    }

    public int getShelvesStatus() {
        return ShelvesStatus;
    }

    public void setShelvesStatus(int shelvesStatus) {
        ShelvesStatus = shelvesStatus;
    }
}
