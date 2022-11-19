package com.fly.ayudaconfiable.network.net.http.response;

import java.io.Serializable;

/**
 * nakesoft
 * Created by 孔明 on 2019年7月17日,0017.
 * 158045632@qq.com
 */
public class StartCountBean implements Serializable{
    /**
     * Id : 1
     * GoodsCode : 1001
     * GoodsName : 服务1
     * Qty : 4
     */

    private String Id;
    private String GoodsCode;
    private String GoodsName;
    private double Qty;

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

    public double getQty() {
        return Qty;
    }

    public void setQty(double qty) {
        Qty = qty;
    }

}
