package com.fly.ayudaconfiable.network.net.http.response;

import java.util.List;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月19日,0019.
 * 158045632@qq.com
 */
public class TodayStatementStatisticsData {

    /**
     * OpenCardNum : 0
     * SaleCardAmount : 0
     * MemberDelayTotalCash : 0
     * MemberDelayTotalMoney : 0
     * ConsumeTotalAmount : 210
     * PostageTotalAmount : 0
     * ConsumeDetail : [{"code":"001","name":"现金","amount":10}]
     * PreferentialDetail : {"ActivityAmount":200,"CouponAmount":0,"ZeroAmount":0,"SingleAmount":0}
     * RedeemTotalPoint : 0
     * TopUpTotalAmount : 0
     * TopUpDetail : []
     * WithdrawalCashTotalAmount : 0
     * TopUpGiveAmount : 0
     * RechargeCountTotalAmount : 0
     * RechargeCountDetail : []
     * ReturnGoodsTotalAmount : 0
     * TotalInCome : 10
     * TotalInComeDetail : [{"code":"001","name":"现金","amount":10}]
     */

    private int OpenCardNum;
    private double SaleCardAmount;
    private double MemberDelayTotalCash;
    private double MemberDelayTotalMoney;
    private double ConsumeTotalAmount;
    private double PostageTotalAmount;
    private PreferentialDetailBean PreferentialDetail;
    private PreferentialDetailBean RechargeCountPreferentialDetail;
    private double RedeemTotalPoint;
    private double TopUpTotalAmount;
    private double WithdrawalCashTotalAmount;
    private double TopUpGiveAmount;
    private double RechargeCountTotalAmount;
    private double ReturnGoodsTotalAmount;
    private double TotalInCome;
    private List<PayTypeBean> ConsumeDetail;
    private List<PayTypeBean> TopUpDetail;
    private List<PayTypeBean> RechargeCountDetail;
    private List<PayTypeBean> TotalInComeDetail;
    private List<PayTypeBean> ReturnGoodsDetail;
    private List<PayTypeBean> SaleCardDetail;
    private List<PayTypeBean> MemberDelayDetail;

    public int getOpenCardNum() {
        return OpenCardNum;
    }

    public void setOpenCardNum(int openCardNum) {
        OpenCardNum = openCardNum;
    }

    public double getSaleCardAmount() {
        return SaleCardAmount;
    }

    public void setSaleCardAmount(double saleCardAmount) {
        SaleCardAmount = saleCardAmount;
    }

    public double getMemberDelayTotalCash() {
        return MemberDelayTotalCash;
    }

    public void setMemberDelayTotalCash(double memberDelayTotalCash) {
        MemberDelayTotalCash = memberDelayTotalCash;
    }

    public double getMemberDelayTotalMoney() {
        return MemberDelayTotalMoney;
    }

    public void setMemberDelayTotalMoney(double memberDelayTotalMoney) {
        MemberDelayTotalMoney = memberDelayTotalMoney;
    }

    public double getConsumeTotalAmount() {
        return ConsumeTotalAmount;
    }

    public void setConsumeTotalAmount(double consumeTotalAmount) {
        ConsumeTotalAmount = consumeTotalAmount;
    }

    public double getPostageTotalAmount() {
        return PostageTotalAmount;
    }

    public void setPostageTotalAmount(double postageTotalAmount) {
        PostageTotalAmount = postageTotalAmount;
    }

    public PreferentialDetailBean getPreferentialDetail() {
        return PreferentialDetail;
    }

    public void setPreferentialDetail(PreferentialDetailBean preferentialDetail) {
        PreferentialDetail = preferentialDetail;
    }

    public double getRedeemTotalPoint() {
        return RedeemTotalPoint;
    }

    public void setRedeemTotalPoint(double redeemTotalPoint) {
        RedeemTotalPoint = redeemTotalPoint;
    }

    public double getTopUpTotalAmount() {
        return TopUpTotalAmount;
    }

    public void setTopUpTotalAmount(double topUpTotalAmount) {
        TopUpTotalAmount = topUpTotalAmount;
    }

    public double getWithdrawalCashTotalAmount() {
        return WithdrawalCashTotalAmount;
    }

    public void setWithdrawalCashTotalAmount(double withdrawalCashTotalAmount) {
        WithdrawalCashTotalAmount = withdrawalCashTotalAmount;
    }

    public double getTopUpGiveAmount() {
        return TopUpGiveAmount;
    }

    public void setTopUpGiveAmount(double topUpGiveAmount) {
        TopUpGiveAmount = topUpGiveAmount;
    }

    public double getRechargeCountTotalAmount() {
        return RechargeCountTotalAmount;
    }

    public void setRechargeCountTotalAmount(double rechargeCountTotalAmount) {
        RechargeCountTotalAmount = rechargeCountTotalAmount;
    }

    public double getReturnGoodsTotalAmount() {
        return ReturnGoodsTotalAmount;
    }

    public void setReturnGoodsTotalAmount(double returnGoodsTotalAmount) {
        ReturnGoodsTotalAmount = returnGoodsTotalAmount;
    }

    public double getTotalInCome() {
        return TotalInCome;
    }

    public void setTotalInCome(double totalInCome) {
        TotalInCome = totalInCome;
    }

    public List<PayTypeBean> getConsumeDetail() {
        return ConsumeDetail;
    }

    public void setConsumeDetail(List<PayTypeBean> consumeDetail) {
        ConsumeDetail = consumeDetail;
    }

    public List<PayTypeBean> getTopUpDetail() {
        return TopUpDetail;
    }

    public void setTopUpDetail(List<PayTypeBean> topUpDetail) {
        TopUpDetail = topUpDetail;
    }

    public List<PayTypeBean> getRechargeCountDetail() {
        return RechargeCountDetail;
    }

    public void setRechargeCountDetail(List<PayTypeBean> rechargeCountDetail) {
        RechargeCountDetail = rechargeCountDetail;
    }

    public List<PayTypeBean> getTotalInComeDetail() {
        return TotalInComeDetail;
    }

    public void setTotalInComeDetail(List<PayTypeBean> totalInComeDetail) {
        TotalInComeDetail = totalInComeDetail;
    }

    public PreferentialDetailBean getRechargeCountPreferentialDetail() {
        return RechargeCountPreferentialDetail;
    }

    public void setRechargeCountPreferentialDetail(PreferentialDetailBean rechargeCountPreferentialDetail) {
        RechargeCountPreferentialDetail = rechargeCountPreferentialDetail;
    }

    public List<PayTypeBean> getReturnGoodsDetail() {
        return ReturnGoodsDetail;
    }

    public void setReturnGoodsDetail(List<PayTypeBean> returnGoodsDetail) {
        ReturnGoodsDetail = returnGoodsDetail;
    }

    public List<PayTypeBean> getSaleCardDetail() {
        return SaleCardDetail;
    }

    public void setSaleCardDetail(List<PayTypeBean> saleCardDetail) {
        SaleCardDetail = saleCardDetail;
    }

    public List<PayTypeBean> getMemberDelayDetail() {
        return MemberDelayDetail;
    }

    public void setMemberDelayDetail(List<PayTypeBean> memberDelayDetail) {
        MemberDelayDetail = memberDelayDetail;
    }
}
