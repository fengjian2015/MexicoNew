package com.fly.ayudaconfiable.network.net.http.request;

import java.io.Serializable;
import java.util.List;

public class AccountChargeActGoodBean implements Serializable {

    private List<RechargeCountBean> RechargeCount;

    public List<RechargeCountBean> getRechargeCount() {
        return RechargeCount;
    }

    public void setRechargeCount(List<RechargeCountBean> RechargeCount) {
        this.RechargeCount = RechargeCount;
    }

    public static class RechargeCountBean implements Serializable {

        private int Number;
        private String Id = "";
        private String GoodsCode = "";
        private String GoodsName = "";

        public int getNumber() {
            return Number;
        }

        public void setNumber(int number) {
            Number = number;
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
    }
}
