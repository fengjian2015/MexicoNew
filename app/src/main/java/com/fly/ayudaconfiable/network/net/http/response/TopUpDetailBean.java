package com.fly.ayudaconfiable.network.net.http.response;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月5日,0005.
 * 158045632@qq.com
 */
public class TopUpDetailBean {
    /**
     * code : 010
     * name : 支付宝
     * amount : 0
     */

    private String code;
    private String name;
    private double amount;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
