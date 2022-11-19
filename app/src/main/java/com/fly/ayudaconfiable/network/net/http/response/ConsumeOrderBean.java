package com.fly.ayudaconfiable.network.net.http.response;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月3日,0003.
 * 158045632@qq.com
 */
public class ConsumeOrderBean {
    /**
     * TypeName : 快速消费
     * UserName : 哈哈
     * ShopName : 总店
     * ActualPayAmount : 10
     * Id : 14367503261497344
     * CardID : 0000
     * CardName : 散客
     * Mobile :
     * CreateTime : 20190803134007
     * BillCode : XF201908031340075386
     * OrderType : 1
     * MemID : 198
     * TotalMoney : 10
     * DiscountMoney : 10
     * TotalPoint : 0
     * Remark :
     */

    private String TypeName;
    private String UserName;
    private String ShopName;
    private double ActualPayAmount;
    private String Id;
    private String CardID;
    private String CardName;
    private String Mobile;
    private String Avatar;
    private long CreateTime;
    private String BillCode;
    private int OrderType;
    private String MemID;
    private double TotalMoney;
    private double DiscountMoney;
    private double TotalPoint;
    private String Remark;

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String typeName) {
        TypeName = typeName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String shopName) {
        ShopName = shopName;
    }

    public double getActualPayAmount() {
        return ActualPayAmount;
    }

    public void setActualPayAmount(double actualPayAmount) {
        ActualPayAmount = actualPayAmount;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getCardID() {
        return CardID;
    }

    public void setCardID(String cardID) {
        CardID = cardID;
    }

    public String getCardName() {
        return CardName;
    }

    public void setCardName(String cardName) {
        CardName = cardName;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String Avatar) {
        Avatar = Avatar;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getBillCode() {
        return BillCode;
    }

    public void setBillCode(String billCode) {
        BillCode = billCode;
    }

    public int getOrderType() {
        return OrderType;
    }

    public void setOrderType(int orderType) {
        OrderType = orderType;
    }

    public String getMemID() {
        return MemID;
    }

    public void setMemID(String memID) {
        MemID = memID;
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

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }
}
