package com.fly.ayudaconfiable.network.net.http.response;


import java.io.Serializable;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月3日,0003.
 * 158045632@qq.com
 */
public class PaymentsBean implements Serializable{
    /**
    "PaymentCode": "支付方式编码",
    "PayAmount": "支付金额",
    "PayContent": "积分支付扣除数量或者在线支付流水号"
     001现金
     002余额支付
     003积分支付
     004银行卡
     020支付宝
     010微信支付
     999优惠券
     */
    private String PaymentCode = "";
    private double PayAmount = 0.00;
    private String PayContent = "";
    private String PaymentName = "";

    public String getPaymentCode() {
        return PaymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        PaymentCode = paymentCode;
    }

    public double getPayAmount() {
        return PayAmount;
    }

    public void setPayAmount(double payAmount) {
        PayAmount = payAmount;
    }

    public String getPayContent() {
        return PayContent;
    }

    public void setPayContent(String payContent) {
        PayContent = payContent;
    }

    public String getPaymentName() {
        return PaymentName;
    }

    public void setPaymentName(String paymentName) {
        PaymentName = paymentName;
    }

}
