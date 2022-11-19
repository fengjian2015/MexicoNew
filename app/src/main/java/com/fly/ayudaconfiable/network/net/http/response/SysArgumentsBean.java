package com.fly.ayudaconfiable.network.net.http.response;

import java.io.Serializable;
import java.util.List;

/**
 * nakesoft
 * Created by 孔明 on 2019年7月10日,0010.
 * 158045632@qq.com
 */

public class SysArgumentsBean implements Serializable {
    private static final long serialVersionUID = -7005608184114795270L;
    /**
     * MoneyPrecision : 2
     * PointPrecision : 2
     * IsAllowModifyGoodsPrice : 0
     * IsAllowModifyOrderTotal : 0
     * ZeroErasingUnit : 1
     * IsForbidInputCardID : 0
     * PointOffsetCashPrecent : 0.99
     * GoodsIsSharedBetweenShop : 0
     * IsEnableRevokePwd : 1
     * IsEnableECRules : 1
     * EWSCodeType : 3
     * EWSCodeFormat : 2
     * IsAllowModifyCommission : 0
     * ManyStaffCommissionWay : 1
     * IsSystemSMS : 1
     * IsSMSMemCountMerge : 0
     * IsEnableOrderArchive : 1
     * OrderArchiveDays : 90
     * IsAllowUseManyConpon : 0
     * IsEnableSecurityPwd : 0
     * MemberDefaultPwd : 123456789
     * IsVerifyMobileForRegister : 0
     * MemberIsSharedBetweenShop : 0
     * IsEnableMoneyWithdrawCash : 0
     * MoneyWithdrawCashPrecent : 1.23
     * DailyMoneyUseLimit : 333
     * PaymentConfig : [{"code":"001","name":"现金","icon":"wx.png"},{"code":"002","name":"余额","icon":"wx.png"},{"code":"003","name":"积分","icon":"wx.png"},{"code":"004","name":"银行卡","icon":"wx.png"}]
     * SankeDefaultPayment : 001
     * MemberDefaultPayment : 001
     */

    private int MoneyPrecision;
    private int PointPrecision;
    private int IsAllowModifyGoodsPrice;
    private int IsAllowModifyOrderTotal;
    private int ZeroErasingUnit;
    private int IsForbidInputCardID;
    private double PointOffsetCashPrecent;
    private int GoodsIsSharedBetweenShop;
    private int IsEnableRevokePwd;
    private int IsEnableECRules;
    private int EWSCodeType;
    private int EWSCodeFormat;
    private int IsAllowModifyCommission;
    private int ManyStaffCommissionWay;
    private int IsSystemSMS;
    private int IsSMSMemCountMerge;
    private int IsEnableOrderArchive;
    private int OrderArchiveDays;
    private int IsAllowUseManyConpon;
    private int IsAllowUseManyOilConpon;
    private int IsEnableSecurityPwd;
    private String MemberDefaultPwd;
    private int IsVerifyMobileForRegister;
    private int MemberIsSharedBetweenShop;
    private int IsEnableMoneyWithdrawCash;
    private double MoneyWithdrawCashPrecent;
    private long DailyMoneyUseLimit;
    private String SankeDefaultPayment;
    private String MemberDefaultPayment;
    private int RegisterIsAllowModifyAccount;
    private int BirthdayActivityRule;
    /*1：允许修改赠送金额 0：不允许*/
    private int IsAllowGiveWayMoney;
    private int DisableSankeConsume;
    /*是否允许商品负库存销售*/
    private int IsAallowNegativeInventory = 0;
    /*油品数量计算规则设置 0-舍弃 1-四舍五入 2-进一*/
    private int OilsNumComputeWay = 0;
    /*刷卡后是否保留会员信息 0-不保留  1-保留*/
    private int IsReservedMember = 0;
    /*是否手动输入水单号*/
    private int IsConsumeInputWaterBillCode;
    /*全局参数是否开启联合支付*/
    private int IsUnionPay;

    /*售卡时默认的支付方式*/
    private String MemberRegDefaultPayment;
    private List<PaymentConfigBean> PaymentConfig;
    private List<PaymentConfigBean> OilPaymentConfig;
    private List<MemberAccountBean> AccountSettingList;

    public int getMoneyPrecision() {
        return MoneyPrecision;
    }

    public void setMoneyPrecision(int MoneyPrecision) {
        this.MoneyPrecision = MoneyPrecision;
    }

    public int getPointPrecision() {
        return PointPrecision;
    }

    public void setPointPrecision(int PointPrecision) {
        this.PointPrecision = PointPrecision;
    }

    public int getIsAllowModifyGoodsPrice() {
        return IsAllowModifyGoodsPrice;
    }

    public void setIsAllowModifyGoodsPrice(int IsAllowModifyGoodsPrice) {
        this.IsAllowModifyGoodsPrice = IsAllowModifyGoodsPrice;
    }

    public int getIsAllowModifyOrderTotal() {
        return IsAllowModifyOrderTotal;
    }

    public void setIsAllowModifyOrderTotal(int IsAllowModifyOrderTotal) {
        this.IsAllowModifyOrderTotal = IsAllowModifyOrderTotal;
    }

    public int getZeroErasingUnit() {
        return ZeroErasingUnit;
    }

    public void setZeroErasingUnit(int ZeroErasingUnit) {
        this.ZeroErasingUnit = ZeroErasingUnit;
    }

    public int getIsForbidInputCardID() {
        return IsForbidInputCardID;
    }

    public void setIsForbidInputCardID(int IsForbidInputCardID) {
        this.IsForbidInputCardID = IsForbidInputCardID;
    }

    public double getPointOffsetCashPrecent() {
        return PointOffsetCashPrecent;
    }

    public void setPointOffsetCashPrecent(double PointOffsetCashPrecent) {
        this.PointOffsetCashPrecent = PointOffsetCashPrecent;
    }

    public int getGoodsIsSharedBetweenShop() {
        return GoodsIsSharedBetweenShop;
    }

    public void setGoodsIsSharedBetweenShop(int GoodsIsSharedBetweenShop) {
        this.GoodsIsSharedBetweenShop = GoodsIsSharedBetweenShop;
    }

    public int getIsEnableRevokePwd() {
        return IsEnableRevokePwd;
    }

    public void setIsEnableRevokePwd(int IsEnableRevokePwd) {
        this.IsEnableRevokePwd = IsEnableRevokePwd;
    }

    public int getIsEnableECRules() {
        return IsEnableECRules;
    }

    public void setIsEnableECRules(int IsEnableECRules) {
        this.IsEnableECRules = IsEnableECRules;
    }

    public int getEWSCodeType() {
        return EWSCodeType;
    }

    public void setEWSCodeType(int EWSCodeType) {
        this.EWSCodeType = EWSCodeType;
    }

    public int getEWSCodeFormat() {
        return EWSCodeFormat;
    }

    public void setEWSCodeFormat(int EWSCodeFormat) {
        this.EWSCodeFormat = EWSCodeFormat;
    }

    public int getIsAllowModifyCommission() {
        return IsAllowModifyCommission;
    }

    public void setIsAllowModifyCommission(int IsAllowModifyCommission) {
        this.IsAllowModifyCommission = IsAllowModifyCommission;
    }

    public int getManyStaffCommissionWay() {
        return ManyStaffCommissionWay;
    }

    public void setManyStaffCommissionWay(int ManyStaffCommissionWay) {
        this.ManyStaffCommissionWay = ManyStaffCommissionWay;
    }

    public int getIsSystemSMS() {
        return IsSystemSMS;
    }

    public void setIsSystemSMS(int IsSystemSMS) {
        this.IsSystemSMS = IsSystemSMS;
    }

    public int getIsSMSMemCountMerge() {
        return IsSMSMemCountMerge;
    }

    public void setIsSMSMemCountMerge(int IsSMSMemCountMerge) {
        this.IsSMSMemCountMerge = IsSMSMemCountMerge;
    }

    public int getIsEnableOrderArchive() {
        return IsEnableOrderArchive;
    }

    public void setIsEnableOrderArchive(int IsEnableOrderArchive) {
        this.IsEnableOrderArchive = IsEnableOrderArchive;
    }

    public int getOrderArchiveDays() {
        return OrderArchiveDays;
    }

    public void setOrderArchiveDays(int OrderArchiveDays) {
        this.OrderArchiveDays = OrderArchiveDays;
    }

    public int getIsAllowUseManyConpon() {
        return IsAllowUseManyConpon;
    }

    public void setIsAllowUseManyConpon(int IsAllowUseManyConpon) {
        this.IsAllowUseManyConpon = IsAllowUseManyConpon;
    }

    public int getIsAllowUseManyOilConpon() {
        return IsAllowUseManyOilConpon;
    }

    public void setIsAllowUseManyOilConpon(int isAllowUseManyOilConpon) {
        IsAllowUseManyOilConpon = isAllowUseManyOilConpon;
    }

    public int getIsEnableSecurityPwd() {
        return IsEnableSecurityPwd;
    }

    public void setIsEnableSecurityPwd(int IsEnableSecurityPwd) {
        this.IsEnableSecurityPwd = IsEnableSecurityPwd;
    }

    public String getMemberDefaultPwd() {
        return MemberDefaultPwd;
    }

    public void setMemberDefaultPwd(String MemberDefaultPwd) {
        this.MemberDefaultPwd = MemberDefaultPwd;
    }

    public int getIsVerifyMobileForRegister() {
        return IsVerifyMobileForRegister;
    }

    public void setIsVerifyMobileForRegister(int IsVerifyMobileForRegister) {
        this.IsVerifyMobileForRegister = IsVerifyMobileForRegister;
    }

    public int getMemberIsSharedBetweenShop() {
        return MemberIsSharedBetweenShop;
    }

    public void setMemberIsSharedBetweenShop(int MemberIsSharedBetweenShop) {
        this.MemberIsSharedBetweenShop = MemberIsSharedBetweenShop;
    }

    public int getIsEnableMoneyWithdrawCash() {
        return IsEnableMoneyWithdrawCash;
    }

    public void setIsEnableMoneyWithdrawCash(int IsEnableMoneyWithdrawCash) {
        this.IsEnableMoneyWithdrawCash = IsEnableMoneyWithdrawCash;
    }

    public double getMoneyWithdrawCashPrecent() {
        return MoneyWithdrawCashPrecent;
    }

    public void setMoneyWithdrawCashPrecent(double MoneyWithdrawCashPrecent) {
        this.MoneyWithdrawCashPrecent = MoneyWithdrawCashPrecent;
    }

    public long getDailyMoneyUseLimit() {
        return DailyMoneyUseLimit;
    }

    public void setDailyMoneyUseLimit(long DailyMoneyUseLimit) {
        this.DailyMoneyUseLimit = DailyMoneyUseLimit;
    }

    public String getSankeDefaultPayment() {
        return SankeDefaultPayment;
    }

    public void setSankeDefaultPayment(String SankeDefaultPayment) {
        this.SankeDefaultPayment = SankeDefaultPayment;
    }

    public String getMemberDefaultPayment() {
        return MemberDefaultPayment;
    }

    public void setMemberDefaultPayment(String MemberDefaultPayment) {
        this.MemberDefaultPayment = MemberDefaultPayment;
    }

    public int getRegisterIsAllowModifyAccount() {
        return RegisterIsAllowModifyAccount;
    }

    public void setRegisterIsAllowModifyAccount(int registerIsAllowModifyAccount) {
        RegisterIsAllowModifyAccount = registerIsAllowModifyAccount;
    }

    public int getBirthdayActivityRule() {
        return BirthdayActivityRule;
    }

    public void setBirthdayActivityRule(int birthdayActivityRule) {
        BirthdayActivityRule = birthdayActivityRule;
    }

    public int getIsAllowGiveWayMoney() {
        return IsAllowGiveWayMoney;
    }

    public void setIsAllowGiveWayMoney(int isAllowGiveWayMoney) {
        IsAllowGiveWayMoney = isAllowGiveWayMoney;
    }

    public int getDisableSankeConsume() {
        return DisableSankeConsume;
    }

    public void setDisableSankeConsume(int disableSankeConsume) {
        DisableSankeConsume = disableSankeConsume;
    }

    public int getIsAallowNegativeInventory() {
        return IsAallowNegativeInventory;
    }

    public void setIsAallowNegativeInventory(int isAallowNegativeInventory) {
        IsAallowNegativeInventory = isAallowNegativeInventory;
    }

    public int getOilsNumComputeWay() {
        return OilsNumComputeWay;
    }

    public void setOilsNumComputeWay(int oilsNumComputeWay) {
        OilsNumComputeWay = oilsNumComputeWay;
    }

    public int getIsReservedMember() {
        return IsReservedMember;
    }

    public void setIsReservedMember(int isReservedMember) {
        IsReservedMember = isReservedMember;
    }

    public int getIsConsumeInputWaterBillCode() {
        return IsConsumeInputWaterBillCode;
    }

    public void setIsConsumeInputWaterBillCode(int isConsumeInputWaterBillCode) {
        IsConsumeInputWaterBillCode = isConsumeInputWaterBillCode;
    }

    public int getIsUnionPay() {
        return IsUnionPay;
    }

    public void setIsUnionPay(int isUnionPay) {
        IsUnionPay = isUnionPay;
    }

    public String getMemberRegDefaultPayment() {
        return MemberRegDefaultPayment;
    }

    public void setMemberRegDefaultPayment(String memberRegDefaultPayment) {
        MemberRegDefaultPayment = memberRegDefaultPayment;
    }

    public List<PaymentConfigBean> getPaymentConfig() {
        return PaymentConfig;
    }

    public void setPaymentConfig(List<PaymentConfigBean> PaymentConfig) {
        this.PaymentConfig = PaymentConfig;
    }

    public List<PaymentConfigBean> getOilPaymentConfig() {
        return OilPaymentConfig;
    }

    public void setOilPaymentConfig(List<PaymentConfigBean> oilPaymentConfig) {
        OilPaymentConfig = oilPaymentConfig;
    }

    public List<MemberAccountBean> getAccountSettingList() {
        return AccountSettingList;
    }

    public void setAccountSettingList(List<MemberAccountBean> accountSettingList) {
        AccountSettingList = accountSettingList;
    }

    @Override
    public String toString() {
        return "SysArgumentsBean{" +
                "MoneyPrecision=" + MoneyPrecision +
                ", PointPrecision=" + PointPrecision +
                ", IsAllowModifyGoodsPrice=" + IsAllowModifyGoodsPrice +
                ", IsAllowModifyOrderTotal=" + IsAllowModifyOrderTotal +
                ", ZeroErasingUnit=" + ZeroErasingUnit +
                ", IsForbidInputCardID=" + IsForbidInputCardID +
                ", PointOffsetCashPrecent=" + PointOffsetCashPrecent +
                ", GoodsIsSharedBetweenShop=" + GoodsIsSharedBetweenShop +
                ", IsEnableRevokePwd=" + IsEnableRevokePwd +
                ", IsEnableECRules=" + IsEnableECRules +
                ", EWSCodeType=" + EWSCodeType +
                ", EWSCodeFormat=" + EWSCodeFormat +
                ", IsAllowModifyCommission=" + IsAllowModifyCommission +
                ", ManyStaffCommissionWay=" + ManyStaffCommissionWay +
                ", IsSystemSMS=" + IsSystemSMS +
                ", IsSMSMemCountMerge=" + IsSMSMemCountMerge +
                ", IsEnableOrderArchive=" + IsEnableOrderArchive +
                ", OrderArchiveDays=" + OrderArchiveDays +
                ", IsAllowUseManyConpon=" + IsAllowUseManyConpon +
                ", IsEnableSecurityPwd=" + IsEnableSecurityPwd +
                ", MemberDefaultPwd='" + MemberDefaultPwd + '\'' +
                ", IsVerifyMobileForRegister=" + IsVerifyMobileForRegister +
                ", MemberIsSharedBetweenShop=" + MemberIsSharedBetweenShop +
                ", IsEnableMoneyWithdrawCash=" + IsEnableMoneyWithdrawCash +
                ", MoneyWithdrawCashPrecent=" + MoneyWithdrawCashPrecent +
                ", DailyMoneyUseLimit=" + DailyMoneyUseLimit +
                ", SankeDefaultPayment='" + SankeDefaultPayment + '\'' +
                ", MemberDefaultPayment='" + MemberDefaultPayment + '\'' +
                ", RegisterIsAllowModifyAccount=" + RegisterIsAllowModifyAccount +
                ", BirthdayActivityRule=" + BirthdayActivityRule +
                ", IsAllowGiveWayMoney=" + IsAllowGiveWayMoney +
                ", DisableSankeConsume=" + DisableSankeConsume +
                ", MemberRegDefaultPayment='" + MemberRegDefaultPayment + '\'' +
                ", PaymentConfig=" + PaymentConfig +
                '}';
    }
}