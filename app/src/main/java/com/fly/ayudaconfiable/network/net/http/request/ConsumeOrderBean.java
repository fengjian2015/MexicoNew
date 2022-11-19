package com.fly.ayudaconfiable.network.net.http.request;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月3日,0003.
 * 158045632@qq.com
 * 商品消费  跟计次消费共用的, 挂单 也是共用的
 */
public class ConsumeOrderBean {
    /**
     * ActivityAmount : 优惠活动优惠金额
     * CouponAmount : 优惠券优惠金额
     * ZeroAmount : 抹零金额
     * SingleAmount : 整单优惠金额
     * Source : 消费来源
     * BillCode : 订单号
     * TotalNum: 计次数量
     * ShopID: 店铺名称
     * OrderType : 订单类型
     * MemID : 会员ID
     * TotalMoney : 订单总金额
     * DiscountMoney : 折后总金额
     * TotalPoint : 获得积分
     * Remark : 消费备注
     */

    private int Source = 3;
    private int IsResting = 1;
    private int OrderType;
    private int Status = 0;//点餐订单的状态
    /*0普通消费 1手牌开单 2房台开单*/
    private int OpenType;
    private double ActivityAmount = 0;
    private double CouponAmount = 0;
    private double ZeroAmount = 0;
    private double SingleAmount = 0;
    private double TotalMoney = 0;
    private double DiscountMoney = 0;
    private double TotalPoint = 0;
    private double TotalNum;
    private String BillCode = "";
    private String MemID = "";
    private String Remark = "";
    private String ShopID = "";
    private String HandCode = "";
    private String CreateTime = "0"; //订单在机器上的时间，补单时用
    private String DeskNo = "";//点餐的房台号
    private String OrderId = "";//点餐订单的ID
    private String RoomID = "";
    private String OpenStaffID = "";
    private String WaterBillCode = "";
    private String ReservationOrderID = "";//预约订单ID

    public int getSource() {
        return Source;
    }

    public void setSource(int source) {
        Source = source;
    }

    public int getIsResting() {
        return IsResting;
    }

    public void setIsResting(int isResting) {
        IsResting = isResting;
    }

    public int getOrderType() {
        return OrderType;
    }

    public void setOrderType(int orderType) {
        OrderType = orderType;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public int getOpenType() {
        return OpenType;
    }

    public void setOpenType(int openType) {
        OpenType = openType;
    }

    public double getActivityAmount() {
        return ActivityAmount;
    }

    public void setActivityAmount(double activityAmount) {
        ActivityAmount = activityAmount;
    }

    public double getCouponAmount() {
        return CouponAmount;
    }

    public void setCouponAmount(double couponAmount) {
        CouponAmount = couponAmount;
    }

    public double getZeroAmount() {
        return ZeroAmount;
    }

    public void setZeroAmount(double zeroAmount) {
        ZeroAmount = zeroAmount;
    }

    public double getSingleAmount() {
        return SingleAmount;
    }

    public void setSingleAmount(double singleAmount) {
        SingleAmount = singleAmount;
    }

    public double getTotalMoney() {
        return TotalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        TotalMoney = totalMoney;
    }

    public double getDiscountMoney() {
        return DiscountMoney;
    }

    public void setDiscountMoney(double discountMoney) {
        DiscountMoney = discountMoney;
    }

    public double getTotalPoint() {
        return TotalPoint;
    }

    public void setTotalPoint(double totalPoint) {
        TotalPoint = totalPoint;
    }

    public double getTotalNum() {
        return TotalNum;
    }

    public void setTotalNum(double totalNum) {
        TotalNum = totalNum;
    }

    public String getBillCode() {
        return BillCode;
    }

    public void setBillCode(String billCode) {
        BillCode = billCode;
    }

    public String getMemID() {
        return MemID;
    }

    public void setMemID(String memID) {
        MemID = memID;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getShopID() {
        return ShopID;
    }

    public void setShopID(String shopID) {
        ShopID = shopID;
    }

    public String getHandCode() {
        return HandCode;
    }

    public void setHandCode(String handCode) {
        HandCode = handCode;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getDeskNo() {
        return DeskNo;
    }

    public void setDeskNo(String deskNo) {
        DeskNo = deskNo;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getRoomID() {
        return RoomID;
    }

    public void setRoomID(String roomID) {
        RoomID = roomID;
    }

    public String getOpenStaffID() {
        return OpenStaffID;
    }

    public void setOpenStaffID(String openStaffID) {
        OpenStaffID = openStaffID;
    }

    public String getWaterBillCode() {
        return WaterBillCode;
    }

    public void setWaterBillCode(String waterBillCode) {
        WaterBillCode = waterBillCode;
    }

    public String getReservationOrderID() {
        return ReservationOrderID;
    }

    public void setReservationOrderID(String reservationOrderID) {
        ReservationOrderID = reservationOrderID;
    }
}
