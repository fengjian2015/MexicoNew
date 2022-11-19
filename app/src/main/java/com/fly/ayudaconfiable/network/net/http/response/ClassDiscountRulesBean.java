package com.fly.ayudaconfiable.network.net.http.response;


import java.io.Serializable;

/**
 * nakesoft
 * Created by 孔明 on 2019年7月17日,0017.
 * 158045632@qq.com
 */
public class ClassDiscountRulesBean implements Serializable {
    /**
     * GoodsClassId : 14327973508200448
     * GoodsClassName : 默认分类234
     * Discount : 0.06
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
