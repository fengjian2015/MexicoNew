package com.fly.ayudaconfiable.network.net.http.response;

import java.io.Serializable;
import java.util.List;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月8日,0008.
 * 158045632@qq.com
 * 作废
 */
public class MemRechargeOrder implements Serializable {

    /**
     * BillCode : CZ201908081609103136
     * TotalMoney : 365
     * GiveMoney : 0
     * RealMoney : 365
     * GivePoint : 0
     * Payments : [{"PaymentName":"现金","PayAmount":365}]
     */

    private String BillCode;
    private double TotalMoney;
    private double GiveMoney;
    private double RealMoney;
    private double GivePoint;
    private List<PaymentsBean> Payments;

    public String getBillCode() {
        return BillCode;
    }

    public void setBillCode(String billCode) {
        BillCode = billCode;
    }

    public double getTotalMoney() {
        return TotalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        TotalMoney = totalMoney;
    }

    public double getGiveMoney() {
        return GiveMoney;
    }

    public void setGiveMoney(double giveMoney) {
        GiveMoney = giveMoney;
    }

    public double getRealMoney() {
        return RealMoney;
    }

    public void setRealMoney(double realMoney) {
        RealMoney = realMoney;
    }

    public double getGivePoint() {
        return GivePoint;
    }

    public void setGivePoint(double givePoint) {
        GivePoint = givePoint;
    }

    public List<PaymentsBean> getPayments() {
        return Payments;
    }

    public void setPayments(List<PaymentsBean> payments) {
        Payments = payments;
    }
}
