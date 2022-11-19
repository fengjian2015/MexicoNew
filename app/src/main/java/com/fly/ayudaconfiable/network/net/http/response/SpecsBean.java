package com.fly.ayudaconfiable.network.net.http.response;

import java.io.Serializable;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月5日,0005.
 * 158045632@qq.com
 */
public class SpecsBean implements Serializable {
    /**
     * SpecsNo : 14331097945929728
     * XPrice : 5.0
     * Price : 5.0
     * StockNum : 5.0
     * Specials : 5.0
     * SpecsKeyID1 : 5
     * SpecsValueID1 : 5
     * SpecsKeyID2 : 5
     * SpecsValueID2 : 5
     * SpecsKeyID3 : 5
     * SpecsValueID3 : 5
     * SupplierId : 5
     */
    private String Id = "";
    private String SpecsNo = "";
    private double XPrice = 0;
    private double Price = 0;
    private int StockNum = 0;

    private int IsEnable;
    private String SpecsKey1 = "";
    private String SpecsKey2 = "";
    private String SpecsKey3 = "";
    private String SpecsValue1 = "";
    private String SpecsValue2 = "";
    private String SpecsValue3 = "";

    private double Specials = 0;
    private String SpecsKeyID1 = "";
    private String SpecsValueID1 = "";
    private String SpecsKeyID2 = "";
    private String SpecsValueID2 = "";
    private String SpecsKeyID3 = "";
    private String SpecsValueID3 = "";
    private String SupplierId = "";
    private String SupplierName = "";
    private String IsDelete = "0";//是否删除状态

    public boolean isModify = false;
    public boolean hasInitStock = false;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getSpecsNo() {
        return SpecsNo;
    }

    public void setSpecsNo(String SpecsNo) {
        this.SpecsNo = SpecsNo;
    }

    public double getXPrice() {
        return XPrice;
    }

    public void setXPrice(double XPrice) {
        this.XPrice = XPrice;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getStockNum() {
        return StockNum;
    }

    public void setStockNum(int StockNum) {
        this.StockNum = StockNum;
    }

    public double getSpecials() {
        return Specials;
    }

    public void setSpecials(double Specials) {
        this.Specials = Specials;
    }

    public String getSpecsKeyID1() {
        return SpecsKeyID1;
    }

    public void setSpecsKeyID1(String SpecsKeyID1) {
        this.SpecsKeyID1 = SpecsKeyID1;
    }

    public String getSpecsValueID1() {
        return SpecsValueID1;
    }

    public void setSpecsValueID1(String SpecsValueID1) {
        this.SpecsValueID1 = SpecsValueID1;
    }

    public String getSpecsKeyID2() {
        return SpecsKeyID2;
    }

    public void setSpecsKeyID2(String SpecsKeyID2) {
        this.SpecsKeyID2 = SpecsKeyID2;
    }

    public String getSpecsValueID2() {
        return SpecsValueID2;
    }

    public void setSpecsValueID2(String SpecsValueID2) {
        this.SpecsValueID2 = SpecsValueID2;
    }

    public String getSpecsKeyID3() {
        return SpecsKeyID3;
    }

    public void setSpecsKeyID3(String SpecsKeyID3) {
        this.SpecsKeyID3 = SpecsKeyID3;
    }

    public String getSpecsValueID3() {
        return SpecsValueID3;
    }

    public void setSpecsValueID3(String SpecsValueID3) {
        this.SpecsValueID3 = SpecsValueID3;
    }

    public String getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(String SupplierId) {
        this.SupplierId = SupplierId;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String SupplierName) {
        this.SupplierName = SupplierName;
    }

    public String getIsDelete() {
        return IsDelete;
    }

    public void setIsDelete(String IsDelete) {
        this.IsDelete = IsDelete;
    }

    public int getIsEnable() {
        return IsEnable;
    }

    public void setIsEnable(int isEnable) {
        IsEnable = isEnable;
    }

    public String getSpecsKey1() {
        return SpecsKey1;
    }

    public void setSpecsKey1(String specsKey1) {
        SpecsKey1 = specsKey1;
    }

    public String getSpecsKey2() {
        return SpecsKey2;
    }

    public void setSpecsKey2(String specsKey2) {
        SpecsKey2 = specsKey2;
    }

    public String getSpecsKey3() {
        return SpecsKey3;
    }

    public void setSpecsKey3(String specsKey3) {
        SpecsKey3 = specsKey3;
    }

    public String getSpecsValue1() {
        return SpecsValue1;
    }

    public void setSpecsValue1(String specsValue1) {
        SpecsValue1 = specsValue1;
    }

    public String getSpecsValue2() {
        return SpecsValue2;
    }

    public void setSpecsValue2(String specsValue2) {
        SpecsValue2 = specsValue2;
    }

    public String getSpecsValue3() {
        return SpecsValue3;
    }

    public void setSpecsValue3(String specsValue3) {
        SpecsValue3 = specsValue3;
    }

}
