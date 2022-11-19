package com.fly.ayudaconfiable.network.net.http.response;


import java.io.Serializable;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月7日,0007.
 * 158045632@qq.com
 */
public class GoodDetailBean implements Serializable {

    /**
     * IsModify : 0
     * UnitPrice : 10.0
     * IsPoint : 1
     * PointPercent : 0.0
     * MinDiscount : 0.0
     * IsDiscount : 1
     * Specials : 0.0
     * IsWeighable : 0
     * MeasureUnit :
     * Images :
     * GoodsClass : 14353401696466944
     * StockNum : 10.0
     * SpecsType : 1
     * SpecsName : 星河银,8G+64G,4G全网通
     * MemberCountCardID : 15036956180101120
     * Point : 0.0
     * BatchCode :
     * GoodsID : 14483702623778816
     * GoodsType : 1
     * GoodsCode : 20191024152250185
     * GoodsName : 多规格15
     * DiscountPrice : 10.0
     * Number : 1.0
     * TotalMoney : 10.0
     * SpecsId : 14483702628251648
     */

    private int IsModify;
    private double UnitPrice;
    private int IsPoint;
    private double PointPercent;
    private double MinDiscount;
    private int IsDiscount;
    private double Specials;
    private int IsWeighable;
    private double StockNum;
    private int SpecsType;
    private double Point;
    private int GoodsType;
    private double DiscountPrice;
    private double Number;
    private double TotalMoney;
    private String MeasureUnit="";
    private String Images="";
    private String GoodsClass="";
    private String SpecsName="";
    private String MemberCountCardID="";
    private String BatchCode="";
    private String Id="";
    private String GoodsID="";
    private String GoodsCode="";
    private String GoodsName="";
    private String SpecsId="";
    private int IsEnableGoodsFlavor = 0;

    public int getIsModify() {
        return IsModify;
    }

    public void setIsModify(int isModify) {
        IsModify = isModify;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        UnitPrice = unitPrice;
    }

    public int getIsPoint() {
        return IsPoint;
    }

    public void setIsPoint(int isPoint) {
        IsPoint = isPoint;
    }

    public double getPointPercent() {
        return PointPercent;
    }

    public void setPointPercent(double pointPercent) {
        PointPercent = pointPercent;
    }

    public double getMinDiscount() {
        return MinDiscount;
    }

    public void setMinDiscount(double minDiscount) {
        MinDiscount = minDiscount;
    }

    public int getIsDiscount() {
        return IsDiscount;
    }

    public void setIsDiscount(int isDiscount) {
        IsDiscount = isDiscount;
    }

    public double getSpecials() {
        return Specials;
    }

    public void setSpecials(double specials) {
        Specials = specials;
    }

    public int getIsWeighable() {
        return IsWeighable;
    }

    public void setIsWeighable(int isWeighable) {
        IsWeighable = isWeighable;
    }

    public double getStockNum() {
        return StockNum;
    }

    public void setStockNum(double stockNum) {
        StockNum = stockNum;
    }

    public int getSpecsType() {
        return SpecsType;
    }

    public void setSpecsType(int specsType) {
        SpecsType = specsType;
    }

    public double getPoint() {
        return Point;
    }

    public void setPoint(double point) {
        Point = point;
    }

    public int getGoodsType() {
        return GoodsType;
    }

    public void setGoodsType(int goodsType) {
        GoodsType = goodsType;
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

    public String getMeasureUnit() {
        return MeasureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        MeasureUnit = measureUnit;
    }

    public String getImages() {
        return Images;
    }

    public void setImages(String images) {
        Images = images;
    }

    public String getGoodsClass() {
        return GoodsClass;
    }

    public void setGoodsClass(String goodsClass) {
        GoodsClass = goodsClass;
    }

    public String getSpecsName() {
        return SpecsName;
    }

    public void setSpecsName(String specsName) {
        SpecsName = specsName;
    }

    public String getMemberCountCardID() {
        return MemberCountCardID;
    }

    public void setMemberCountCardID(String memberCountCardID) {
        MemberCountCardID = memberCountCardID;
    }

    public String getBatchCode() {
        return BatchCode;
    }

    public void setBatchCode(String batchCode) {
        BatchCode = batchCode;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getGoodsID() {
        return GoodsID;
    }

    public void setGoodsID(String goodsID) {
        GoodsID = goodsID;
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

    public String getSpecsId() {
        return SpecsId;
    }

    public void setSpecsId(String specsId) {
        SpecsId = specsId;
    }

    public int getIsEnableGoodsFlavor() {
        return IsEnableGoodsFlavor;
    }

    public void setIsEnableGoodsFlavor(int isEnableGoodsFlavor) {
        IsEnableGoodsFlavor = isEnableGoodsFlavor;
    }
}
