package com.fly.ayudaconfiable.network.net.http.response;

import java.util.List;

public class WorkShiftDetailsBean {

    /**
     * ID : 15593507467065344
     * ShopID : 48194679
     * ShopName : 搜狗理发店
     * MasterName : 003
     * OperatorUid : 15375530059970560
     * StatisticalTime : 20211013150354
     * ShiftTurnOverType : 0
     * OrderTotalAmount : 9737.11
     * OrderDiscountAmount : -284.84
     * OrderRefundAmount : 0
     * OrderActualAmount : 20043.9
     * TotalInCome : 70302.03
     * OrderAmountStatistics : [{"code":"002","name":"余额","amount":13.15,"number":3},{"code":"MTYF1","name":"美团月付","amount":16.6,"number":1},{"code":"006","name":"汽油账户","amount":36,"number":2},{"code":"004","name":"银行卡","amount":217.93,"number":1},{"code":"001","name":"现金","amount":9738.27,"number":24},{"code":"hj","name":"合计","amount":10021.95,"number":31}]
     * PreferentialStatistics : [{"code":"activity","name":"优惠活动","amount":120,"number":12}]
     * MemberTopUpStatistics : []
     * OilStatistics : []
     * OilGunStatistics : []
     * OperatorStatistics : []
     * SummaryStatistics : [{"code":"MTYF1","name":"美团月付","amount":16.6,"number":1},{"code":"004","name":"银行卡","amount":217.93,"number":1},{"code":"001","name":"现金","amount":70067.5,"number":25},{"code":"hj","name":"合计","amount":70302.03,"number":27}]
     * MemberMoneyStatistics : {"TotalMoney":0,"Money":0,"GiveMoney":0}
     * MemberPointStatistics : {"MemberTotalPoint":0,"AddPoint":0,"UsePoint":0}
     * OpenCardNum : 0
     * PostageTotalAmount : 0
     * TurnOverTime : 20211216153724
     */
    //交班类型 0当前账户交班 1当前门店统一交班
    private int ShiftTurnOverType;
    private long StatisticalTime;
    private long TurnOverTime;
    private String OpenCardNum = "0";
    private String OrderTotalAmount = "0";
    private String OrderDiscountAmount = "0";
    private String OrderRefundAmount = "0";
    private String OrderActualAmount = "0";
    private String TotalInCome = "0";
    private String PostageTotalAmount = "0";
    private String ID = "";
    private String ShopID = "";
    private String ShopName = "";
    private String MasterName = "";
    private String OperatorUid = "";
    private String Remark = "";
    private MemberMoneyStatisticsBean MemberMoneyStatistics;
    private MemberPointStatisticsBean MemberPointStatistics;
    private SysShiftTurnOverParamBean SysShiftTurnOverParam;
    //订单金额统计
    private List<ItemBean> OrderAmountStatistics;
    //优惠统计
    private List<ItemBean> PreferentialStatistics;
    //退款统计
    private List<ItemBean> RefundAmountStatistics;
    //充值情况
//    private List<ItemBean> MemberTopUpStatistics;
    private MemberTopUpAccount MemberTopUpAccountStatistics;
    //充次统计
    private List<ItemBean> MemberRechargeCountStatistics;
    //油品统计
    private List<ItemBean> OilStatistics;
    //油枪统计
    private List<ItemBean> OilGunStatistics;
    //员工统计
    private List<ItemBean> OperatorStatistics;
    //汇总收入
    private List<ItemBean> SummaryStatistics;
    //售卡总额
    private List<ItemBean> SaleCardStatistics;
    //延期总额
    private List<ItemBean> MemberDelayStatistics;

    public int getShiftTurnOverType() {
        return ShiftTurnOverType;
    }

    public void setShiftTurnOverType(int shiftTurnOverType) {
        ShiftTurnOverType = shiftTurnOverType;
    }

    public long getStatisticalTime() {
        return StatisticalTime;
    }

    public void setStatisticalTime(long statisticalTime) {
        StatisticalTime = statisticalTime;
    }

    public long getTurnOverTime() {
        return TurnOverTime;
    }

    public void setTurnOverTime(long turnOverTime) {
        TurnOverTime = turnOverTime;
    }

    public String getOpenCardNum() {
        return OpenCardNum;
    }

    public void setOpenCardNum(String openCardNum) {
        OpenCardNum = openCardNum;
    }

    public String getOrderTotalAmount() {
        return OrderTotalAmount;
    }

    public void setOrderTotalAmount(String orderTotalAmount) {
        OrderTotalAmount = orderTotalAmount;
    }

    public String getOrderDiscountAmount() {
        return OrderDiscountAmount;
    }

    public void setOrderDiscountAmount(String orderDiscountAmount) {
        OrderDiscountAmount = orderDiscountAmount;
    }

    public String getOrderRefundAmount() {
        return OrderRefundAmount;
    }

    public void setOrderRefundAmount(String orderRefundAmount) {
        OrderRefundAmount = orderRefundAmount;
    }

    public String getOrderActualAmount() {
        return OrderActualAmount;
    }

    public void setOrderActualAmount(String orderActualAmount) {
        OrderActualAmount = orderActualAmount;
    }

    public String getTotalInCome() {
        return TotalInCome;
    }

    public void setTotalInCome(String totalInCome) {
        TotalInCome = totalInCome;
    }

    public String getPostageTotalAmount() {
        return PostageTotalAmount;
    }

    public void setPostageTotalAmount(String postageTotalAmount) {
        PostageTotalAmount = postageTotalAmount;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getShopID() {
        return ShopID;
    }

    public void setShopID(String shopID) {
        ShopID = shopID;
    }

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String shopName) {
        ShopName = shopName;
    }

    public String getMasterName() {
        return MasterName;
    }

    public void setMasterName(String masterName) {
        MasterName = masterName;
    }

    public String getOperatorUid() {
        return OperatorUid;
    }

    public void setOperatorUid(String operatorUid) {
        OperatorUid = operatorUid;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public MemberMoneyStatisticsBean getMemberMoneyStatistics() {
        return MemberMoneyStatistics;
    }

    public void setMemberMoneyStatistics(MemberMoneyStatisticsBean memberMoneyStatistics) {
        MemberMoneyStatistics = memberMoneyStatistics;
    }

    public MemberPointStatisticsBean getMemberPointStatistics() {
        return MemberPointStatistics;
    }

    public void setMemberPointStatistics(MemberPointStatisticsBean memberPointStatistics) {
        MemberPointStatistics = memberPointStatistics;
    }

    public SysShiftTurnOverParamBean getSysShiftTurnOverParam() {
        return SysShiftTurnOverParam;
    }

    public void setSysShiftTurnOverParam(SysShiftTurnOverParamBean sysShiftTurnOverParam) {
        SysShiftTurnOverParam = sysShiftTurnOverParam;
    }

    public List<ItemBean> getOrderAmountStatistics() {
        return OrderAmountStatistics;
    }

    public void setOrderAmountStatistics(List<ItemBean> orderAmountStatistics) {
        OrderAmountStatistics = orderAmountStatistics;
    }

    public List<ItemBean> getPreferentialStatistics() {
        return PreferentialStatistics;
    }

    public void setPreferentialStatistics(List<ItemBean> preferentialStatistics) {
        PreferentialStatistics = preferentialStatistics;
    }

    public List<ItemBean> getRefundAmountStatistics() {
        return RefundAmountStatistics;
    }

    public void setRefundAmountStatistics(List<ItemBean> refundAmountStatistics) {
        RefundAmountStatistics = refundAmountStatistics;
    }

//    public List<ItemBean> getMemberTopUpStatistics() {
//        return MemberTopUpStatistics;
//    }
//
//    public void setMemberTopUpStatistics(List<ItemBean> memberTopUpStatistics) {
//        MemberTopUpStatistics = memberTopUpStatistics;
//    }

    public MemberTopUpAccount getMemberTopUpAccountStatistics() {
        return MemberTopUpAccountStatistics;
    }

    public void setMemberTopUpAccountStatistics(MemberTopUpAccount memberTopUpAccountStatistics) {
        MemberTopUpAccountStatistics = memberTopUpAccountStatistics;
    }

    public List<ItemBean> getMemberRechargeCountStatistics() {
        return MemberRechargeCountStatistics;
    }

    public void setMemberRechargeCountStatistics(List<ItemBean> memberRechargeCountStatistics) {
        MemberRechargeCountStatistics = memberRechargeCountStatistics;
    }

    public List<ItemBean> getOilStatistics() {
        return OilStatistics;
    }

    public void setOilStatistics(List<ItemBean> oilStatistics) {
        OilStatistics = oilStatistics;
    }

    public List<ItemBean> getOilGunStatistics() {
        return OilGunStatistics;
    }

    public void setOilGunStatistics(List<ItemBean> oilGunStatistics) {
        OilGunStatistics = oilGunStatistics;
    }

    public List<ItemBean> getOperatorStatistics() {
        return OperatorStatistics;
    }

    public void setOperatorStatistics(List<ItemBean> operatorStatistics) {
        OperatorStatistics = operatorStatistics;
    }

    public List<ItemBean> getSummaryStatistics() {
        return SummaryStatistics;
    }

    public void setSummaryStatistics(List<ItemBean> summaryStatistics) {
        SummaryStatistics = summaryStatistics;
    }

    public List<ItemBean> getSaleCardStatistics() {
        return SaleCardStatistics;
    }

    public void setSaleCardStatistics(List<ItemBean> saleCardStatistics) {
        SaleCardStatistics = saleCardStatistics;
    }

    public List<ItemBean> getMemberDelayStatistics() {
        return MemberDelayStatistics;
    }

    public void setMemberDelayStatistics(List<ItemBean> memberDelayStatistics) {
        MemberDelayStatistics = memberDelayStatistics;
    }

    public static class MemberMoneyStatisticsBean {
        /**
         * TotalMoney : 0
         * Money : 0
         * GiveMoney : 0
         */

        private String TotalMoney = "";
        private String Money = "";
        private String GiveMoney = "";

        public String getTotalMoney() {
            return TotalMoney;
        }

        public void setTotalMoney(String totalMoney) {
            TotalMoney = totalMoney;
        }

        public String getMoney() {
            return Money;
        }

        public void setMoney(String money) {
            Money = money;
        }

        public String getGiveMoney() {
            return GiveMoney;
        }

        public void setGiveMoney(String giveMoney) {
            GiveMoney = giveMoney;
        }
    }

    public static class MemberPointStatisticsBean {
        /**
         * MemberTotalPoint : 0
         * AddPoint : 0
         * UsePoint : 0
         */

        private String TotalPoint = "";
        private String AddPoint = "";
        private String UsePoint = "";

        public String getTotalPoint() {
            return TotalPoint;
        }

        public void setTotalPoint(String totalPoint) {
            TotalPoint = totalPoint;
        }

        public String getAddPoint() {
            return AddPoint;
        }

        public void setAddPoint(String addPoint) {
            AddPoint = addPoint;
        }

        public String getUsePoint() {
            return UsePoint;
        }

        public void setUsePoint(String usePoint) {
            UsePoint = usePoint;
        }
    }

    public static class SysShiftTurnOverParamBean {

        private int IsAdminWork;
        private int IsShiftTurnOverOilConsumeData;
        private int IsShiftTurnOverMemberData;
        private int IsShiftTurnOverRechargeCountData;
        private int IsShiftTurnOverTopUpData;
        private int IsShiftTurnOverMemberMoneyData;
        private int IsShiftTurnOverMemberPointData;
        private int IsShiftTurnOverOilData;
        private int IsShiftTurnOverOilGunData;

        public int getIsAdminWork() {
            return IsAdminWork;
        }

        public void setIsAdminWork(int isAdminWork) {
            IsAdminWork = isAdminWork;
        }

        public int getIsShiftTurnOverOilConsumeData() {
            return IsShiftTurnOverOilConsumeData;
        }

        public void setIsShiftTurnOverOilConsumeData(int isShiftTurnOverOilConsumeData) {
            IsShiftTurnOverOilConsumeData = isShiftTurnOverOilConsumeData;
        }

        public int getIsShiftTurnOverMemberData() {
            return IsShiftTurnOverMemberData;
        }

        public void setIsShiftTurnOverMemberData(int isShiftTurnOverMemberData) {
            IsShiftTurnOverMemberData = isShiftTurnOverMemberData;
        }

        public int getIsShiftTurnOverRechargeCountData() {
            return IsShiftTurnOverRechargeCountData;
        }

        public void setIsShiftTurnOverRechargeCountData(int isShiftTurnOverRechargeCountData) {
            IsShiftTurnOverRechargeCountData = isShiftTurnOverRechargeCountData;
        }

        public int getIsShiftTurnOverTopUpData() {
            return IsShiftTurnOverTopUpData;
        }

        public void setIsShiftTurnOverTopUpData(int isShiftTurnOverTopUpData) {
            IsShiftTurnOverTopUpData = isShiftTurnOverTopUpData;
        }

        public int getIsShiftTurnOverMemberMoneyData() {
            return IsShiftTurnOverMemberMoneyData;
        }

        public void setIsShiftTurnOverMemberMoneyData(int isShiftTurnOverMemberMoneyData) {
            IsShiftTurnOverMemberMoneyData = isShiftTurnOverMemberMoneyData;
        }

        public int getIsShiftTurnOverMemberPointData() {
            return IsShiftTurnOverMemberPointData;
        }

        public void setIsShiftTurnOverMemberPointData(int isShiftTurnOverMemberPointData) {
            IsShiftTurnOverMemberPointData = isShiftTurnOverMemberPointData;
        }

        public int getIsShiftTurnOverOilData() {
            return IsShiftTurnOverOilData;
        }

        public void setIsShiftTurnOverOilData(int isShiftTurnOverOilData) {
            IsShiftTurnOverOilData = isShiftTurnOverOilData;
        }

        public int getIsShiftTurnOverOilGunData() {
            return IsShiftTurnOverOilGunData;
        }

        public void setIsShiftTurnOverOilGunData(int isShiftTurnOverOilGunData) {
            IsShiftTurnOverOilGunData = isShiftTurnOverOilGunData;
        }
    }

    public static class ItemBean {
        /**
         * code : 002
         * name : 余额
         * amount : 13.15
         * number : 3
         */

        private String amount = "";
        private String number = "";
        private String code = "";
        private String name = "";

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

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
    }

    /*充值改版新加*/
    public static class MemberTopUpAccount {

        //账户余额
        private List<ItemBean> MoneyStatistics;
        //汽油账户余额
        private List<ItemBean> PetrolMoneyStatistics;
        //柴油账户余额
        private List<ItemBean> DieselOilMoneyStatistics;
        //天然气账户余额
        private List<ItemBean> NaturalGasMoneyStatistics;
        //汇总
        private List<ItemBean> TopUpStatistics;

        public List<ItemBean> getMoneyStatistics() {
            return MoneyStatistics;
        }

        public List<ItemBean> getPetrolMoneyStatistics() {
            return PetrolMoneyStatistics;
        }

        public List<ItemBean> getDieselOilMoneyStatistics() {
            return DieselOilMoneyStatistics;
        }

        public List<ItemBean> getNaturalGasMoneyStatistics() {
            return NaturalGasMoneyStatistics;
        }

        public List<ItemBean> getTopUpStatistics() {
            return TopUpStatistics;
        }
    }

}
