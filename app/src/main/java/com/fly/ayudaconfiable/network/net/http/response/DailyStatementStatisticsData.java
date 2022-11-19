package com.fly.ayudaconfiable.network.net.http.response;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月16日,0016.
 * 158045632@qq.com
 */
public class DailyStatementStatisticsData {

    /**
     * ConsumeCount : 10
     * OpenCardNum : 6
     * ConsumeTotalAmount : 6207.19
     * RechargeCountTotalAmount : 0
     * TopUpTotalAmount : 300
     */

    private int ConsumeCount;
    private int OpenCardNum;
    private double ConsumeTotalAmount;
    private double RechargeCountTotalAmount;
    private double TopUpTotalAmount;

    public int getConsumeCount() {
        return ConsumeCount;
    }

    public void setConsumeCount(int consumeCount) {
        ConsumeCount = consumeCount;
    }

    public int getOpenCardNum() {
        return OpenCardNum;
    }

    public void setOpenCardNum(int openCardNum) {
        OpenCardNum = openCardNum;
    }

    public double getConsumeTotalAmount() {
        return ConsumeTotalAmount;
    }

    public void setConsumeTotalAmount(double consumeTotalAmount) {
        ConsumeTotalAmount = consumeTotalAmount;
    }

    public double getRechargeCountTotalAmount() {
        return RechargeCountTotalAmount;
    }

    public void setRechargeCountTotalAmount(double rechargeCountTotalAmount) {
        RechargeCountTotalAmount = rechargeCountTotalAmount;
    }

    public double getTopUpTotalAmount() {
        return TopUpTotalAmount;
    }

    public void setTopUpTotalAmount(double topUpTotalAmount) {
        TopUpTotalAmount = topUpTotalAmount;
    }
}
