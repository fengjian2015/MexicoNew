package com.fly.ayudaconfiable.network.net.http.response;

import java.util.List;

/**
 * lucksoft
 * Created by AndroidDevelop on 2020/8/15.
 * 158045632@qq.com
 */
public class ReturnBean {

    private List<PaymentsBean> RefundPayments;
    private List<PaymentConfigBean> Payments;

    public List<PaymentsBean> getRefundPayments() {
        return RefundPayments;
    }

    public void setRefundPayments(List<PaymentsBean> refundPayments) {
        RefundPayments = refundPayments;
    }

    public List<PaymentConfigBean> getPayments() {
        return Payments;
    }

    public void setPayments(List<PaymentConfigBean> payments) {
        Payments = payments;
    }
}
