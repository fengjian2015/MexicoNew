package com.fly.ayudaconfiable.network.net.http.response;

import java.util.List;

public class WorkShiftRecordBean {

    /**
     * total : 1
     * list : [{"Id":"15593507467065344","OperatorUid":"15375530059970560","UserName":"003","OrderTotalAmount":10047.11,"OrderDiscountAmount":-274.64,"OrderRefundAmount":0,"OrderActualAmount":20643.5,"TotalInCome":70601.83,"ShopID":"48194679","ShopName":"搜狗理发店","StatisticalTime":20211013150354,"TurnOverTime":20211217151005,"ShiftTurnOverType":0}]
     */

    private int total;
    private List<ListBean> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * Id : 15593507467065344
         * OperatorUid : 15375530059970560
         * UserName : 003
         * OrderTotalAmount : 10047.11
         * OrderDiscountAmount : -274.64
         * OrderRefundAmount : 0
         * OrderActualAmount : 20643.5
         * TotalInCome : 70601.83
         * ShopID : 48194679
         * ShopName : 搜狗理发店
         * StatisticalTime : 20211013150354
         * TurnOverTime : 20211217151005
         * ShiftTurnOverType : 0
         */

        private String Id = "";
        private String OperatorUid = "";
        private String UserName = "";
        private String ShopID = "";
        private String ShopName = "";
        private int ShiftTurnOverType;
        private double OrderTotalAmount;
        private double OrderDiscountAmount;
        private double OrderRefundAmount;
        private double OrderActualAmount;
        private double TotalInCome;
        private long StatisticalTime;
        private long TurnOverTime;

        public String getId() {
            return Id;
        }

        public void setId(String id) {
            Id = id;
        }

        public String getOperatorUid() {
            return OperatorUid;
        }

        public void setOperatorUid(String operatorUid) {
            OperatorUid = operatorUid;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String userName) {
            UserName = userName;
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

        public int getShiftTurnOverType() {
            return ShiftTurnOverType;
        }

        public void setShiftTurnOverType(int shiftTurnOverType) {
            ShiftTurnOverType = shiftTurnOverType;
        }

        public double getOrderTotalAmount() {
            return OrderTotalAmount;
        }

        public void setOrderTotalAmount(double orderTotalAmount) {
            OrderTotalAmount = orderTotalAmount;
        }

        public double getOrderDiscountAmount() {
            return OrderDiscountAmount;
        }

        public void setOrderDiscountAmount(double orderDiscountAmount) {
            OrderDiscountAmount = orderDiscountAmount;
        }

        public double getOrderRefundAmount() {
            return OrderRefundAmount;
        }

        public void setOrderRefundAmount(double orderRefundAmount) {
            OrderRefundAmount = orderRefundAmount;
        }

        public double getOrderActualAmount() {
            return OrderActualAmount;
        }

        public void setOrderActualAmount(double orderActualAmount) {
            OrderActualAmount = orderActualAmount;
        }

        public double getTotalInCome() {
            return TotalInCome;
        }

        public void setTotalInCome(double totalInCome) {
            TotalInCome = totalInCome;
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
    }
}
