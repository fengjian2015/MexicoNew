package com.fly.ayudaconfiable.network.net.http.response;


import com.fly.ayudaconfiable.bean.FlavorBean;
import com.fly.ayudaconfiable.bean.MemCustomFieldBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * nakesoft
 * Created by 孔明 on 2019年7月16日,0016.
 * 158045632@qq.com
 */
public class GoodsByIdBean implements Serializable {

    /**
     * Id : 14412571883157504
     * GoodsCode : 1
     * GoodsName : 1
     * NameCode : 1
     * GoodsClass : 14380568184436736
     * GoodsType : 1
     * Price : 10.0
     * XPrice : 5.0
     * Images :
     * IsPoint : 1
     * PointType : 0.0
     * MinDiscount : 0.5
     * IsDiscount : 1
     * Remark :
     * IsGift : 0
     * ExchangePoint : 0.0
     * MeasureUnit : 个
     * Specials : 6.0
     * ShopID : 14272953155303424
     * CreateTime : 20190904094617
     * IsShelf : 1
     * IsWeighable : 0
     * GoodsCustomField : [{"FieldId":"14330915350738944","FieldValue":"红"},{"FieldId":"14352063877806080","FieldValue":"41号"},{"FieldId":"14352064456980480","FieldValue":"2020-01-01 00:00:00"},{"FieldId":"14352065662826496","FieldValue":"170"},{"FieldId":"14352066657761280","FieldValue":"26"},{"FieldId":"14381472338491392","FieldValue":"S"}]
     */
    private String Id;
    private String GoodsCode;
    private String GoodsName;
    private String NameCode;
    private String GoodsClass;
    private int GoodsType;
    private double Price;
    private double XPrice;
    private String Images;
    private int IsPoint;
    private double PointType;
    private double MinDiscount;
    private int IsDiscount;
    private String Remark;
    private int IsGift;
    private double ExchangePoint;
    private String MeasureUnit;
    private double Specials;
    private String ShopID;
    private long CreateTime;
    private int IsShelf;
    private int IsWeighable;
    private int IsEnableGoodsFlavor;

    private int Sort;
    private double StockNum;
    private List<MemCustomFieldBean> GoodsCustomField;
    private List<FlavorBean> GoodsFlavorList;

    private int SpecsType;
    private String SpecsName;
    private String SpecsList;
    private ArrayList<SpecsBean> AllSpecsList;

    public List<SpecsGoodsBean> specsGoods;

    /*计时添加*/

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

    public String getNameCode() {
        return NameCode;
    }

    public void setNameCode(String nameCode) {
        NameCode = nameCode;
    }

    public String getGoodsClass() {
        return GoodsClass;
    }

    public void setGoodsClass(String goodsClass) {
        GoodsClass = goodsClass;
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

    public double getXPrice() {
        return XPrice;
    }

    public void setXPrice(double XPrice) {
        this.XPrice = XPrice;
    }

    public String getImages() {
        return Images;
    }

    public void setImages(String images) {
        Images = images;
    }

    public int getIsPoint() {
        return IsPoint;
    }

    public void setIsPoint(int isPoint) {
        IsPoint = isPoint;
    }

    public double getPointType() {
        return PointType;
    }

    public void setPointType(double pointType) {
        PointType = pointType;
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

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public int getIsGift() {
        return IsGift;
    }

    public void setIsGift(int isGift) {
        IsGift = isGift;
    }

    public double getExchangePoint() {
        return ExchangePoint;
    }

    public void setExchangePoint(double exchangePoint) {
        ExchangePoint = exchangePoint;
    }

    public String getMeasureUnit() {
        return MeasureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        MeasureUnit = measureUnit;
    }

    public double getSpecials() {
        return Specials;
    }

    public void setSpecials(double specials) {
        Specials = specials;
    }

    public String getShopID() {
        return ShopID;
    }

    public void setShopID(String shopID) {
        ShopID = shopID;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public int getIsShelf() {
        return IsShelf;
    }

    public void setIsShelf(int isShelf) {
        IsShelf = isShelf;
    }

    public int getIsWeighable() {
        return IsWeighable;
    }

    public void setIsWeighable(int isWeighable) {
        IsWeighable = isWeighable;
    }

    public int getIsEnableGoodsFlavor() {
        return IsEnableGoodsFlavor;
    }

    public void setIsEnableGoodsFlavor(int isEnableGoodsFlavor) {
        IsEnableGoodsFlavor = isEnableGoodsFlavor;
    }

    public int getSort() {
        return Sort;
    }

    public void setSort(int sort) {
        Sort = sort;
    }

    public double getStockNum() {
        return StockNum;
    }

    public void setStockNum(double stockNum) {
        StockNum = stockNum;
    }

    public List<MemCustomFieldBean> getGoodsCustomField() {
        return GoodsCustomField;
    }

    public void setGoodsCustomField(List<MemCustomFieldBean> goodsCustomField) {
        GoodsCustomField = goodsCustomField;
    }

    public List<FlavorBean> getGoodsFlavorList() {
        return GoodsFlavorList;
    }

    public void setGoodsFlavorList(List<FlavorBean> goodsFlavorList) {
        GoodsFlavorList = goodsFlavorList;
    }

    public int getSpecsType() {
        return SpecsType;
    }

    public void setSpecsType(int specsType) {
        SpecsType = specsType;
    }

    public String getSpecsName() {
        return SpecsName;
    }

    public void setSpecsName(String specsName) {
        SpecsName = specsName;
    }

    public String getSpecsList() {
        return SpecsList;
    }

    public void setSpecsList(String specsList) {
        SpecsList = specsList;
    }

    public ArrayList<SpecsBean> getAllSpecsList() {
        return AllSpecsList;
    }

    public void setAllSpecsList(ArrayList<SpecsBean> allSpecsList) {
        AllSpecsList = allSpecsList;
    }

    public List<SpecsGoodsBean> getSpecsGoods() {
        return specsGoods;
    }

    public void setSpecsGoods(List<SpecsGoodsBean> specsGoods) {
        this.specsGoods = specsGoods;
    }

}
