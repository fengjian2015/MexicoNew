package com.fly.ayudaconfiable.network.net.http.response;

import java.io.Serializable;

/**
 * nakesoft
 * Created by 孔明 on 2019年7月10日,0010.
 * 158045632@qq.com
 */

public class PaymentConfigBean implements Serializable {
    private static final long serialVersionUID = -6687039347624017596L;
    /**
     * code : 001
     * name : 现金
     * icon : wx.png
     */

    private String code = "";
    private String name = "";
    private String icon = "";

    public int selected = 0;
    private String payTradeNo="";
    private String payThirdType="";

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPayTradeNo() {
        return payTradeNo;
    }

    public void setPayTradeNo(String payTradeNo) {
        this.payTradeNo = payTradeNo;
    }

    public String getPayThirdType() {
        return payThirdType;
    }

    public void setPayThirdType(String payThirdType) {
        this.payThirdType = payThirdType;
    }

    @Override
    public String toString() {
        return "PaymentConfigBean{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}