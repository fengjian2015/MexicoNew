package com.fly.ayudaconfiable.network.net.http.response;

import java.io.Serializable;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月8日,0008.
 * 158045632@qq.com
 */
public class ClassDiscountRulesListBean implements Serializable {
    private static final long serialVersionUID = -2158876024586068024L;
    /**
     * GoodsClassId : 14306356306343936
     * GoodsClassName : 分类3
     * Discount : 0.2
     */

    private String GoodsClassId;
    private String GoodsClassName;
    private double Discount;

    public String getGoodsClassId() {
        return GoodsClassId;
    }

    public void setGoodsClassId(String goodsClassId) {
        GoodsClassId = goodsClassId;
    }

    public String getGoodsClassName() {
        return GoodsClassName;
    }

    public void setGoodsClassName(String goodsClassName) {
        GoodsClassName = goodsClassName;
    }

    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(double discount) {
        Discount = discount;
    }
}
