package com.fly.ayudaconfiable.network.net.http.response;

/**
 * lucksoft
 * Created by AndroidDevelop on 2022/3/26.
 * 158045632@qq.com
 */
public class BankRevokeBean {
    /**
     * PayFlowNo : 60203261444085913378780432
     * VoucherNo : 000592
     * PayAmount : 545
     */

    private String PayFlowNo;
    private String VoucherNo;
    private double PayAmount;

    public String getPayFlowNo() {
        return PayFlowNo;
    }

    public void setPayFlowNo(String PayFlowNo) {
        this.PayFlowNo = PayFlowNo;
    }

    public String getVoucherNo() {
        return VoucherNo;
    }

    public void setVoucherNo(String VoucherNo) {
        this.VoucherNo = VoucherNo;
    }

    public double getPayAmount() {
        return PayAmount;
    }

    public void setPayAmount(double PayAmount) {
        this.PayAmount = PayAmount;
    }
}
