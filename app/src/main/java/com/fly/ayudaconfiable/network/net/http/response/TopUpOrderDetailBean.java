package com.fly.ayudaconfiable.network.net.http.response;


import java.io.Serializable;
import java.util.List;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月5日,0005.
 * 158045632@qq.com
 */
public class TopUpOrderDetailBean implements Serializable {
    /**
     * Id : 14424164451973120
     * BillCode : CZ20190912000002
     * CreateTime : 20190912141852
     * CardID : 1511
     * CardName : 1511
     * LevelName : 123
     * TotalMoney : 100.0
     * RealMoney : 10100.0
     * UserName : 哈哈11
     * ShopName : 总店
     * Remark :
     * RevokeState : 0
     * RevokeTime : 0
     * Payments : [{"PaymentName":"现金","PayAmount":100}]
     * ActInfo : [{"ActTypeName":"优惠信息","ActMsg":"赠送余额10000.00元,赠送积分1000.000分,就一张0912@li1张,随机折扣0910@li1张,折扣券0907@li1张,代金券0907@li1张"}]
     */

    private String Id;
    private String BillCode;
    private long CreateTime;
    private String CardID;
    private String CardName;
    private String LevelName;
    private String Mobile;
    private String Avatar;
    private double TotalMoney;
    private double RealMoney;
    private String UserName;
    private String ShopName;
    private String Remark;
    private int RevokeState;
    private int RevokeTime;
    private List<PaymentsBean> Payments;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getBillCode() {
        return BillCode;
    }

    public void setBillCode(String BillCode) {
        this.BillCode = BillCode;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long CreateTime) {
        this.CreateTime = CreateTime;
    }

    public String getCardID() {
        return CardID;
    }

    public void setCardID(String CardID) {
        this.CardID = CardID;
    }

    public String getCardName() {
        return CardName;
    }

    public void setCardName(String CardName) {
        this.CardName = CardName;
    }

    public String getLevelName() {
        return LevelName;
    }

    public void setLevelName(String LevelName) {
        this.LevelName = LevelName;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String Avatar) {
        this.Avatar = Avatar;
    }

    public double getTotalMoney() {
        return TotalMoney;
    }

    public void setTotalMoney(double TotalMoney) {
        this.TotalMoney = TotalMoney;
    }

    public double getRealMoney() {
        return RealMoney;
    }

    public void setRealMoney(double RealMoney) {
        this.RealMoney = RealMoney;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String ShopName) {
        this.ShopName = ShopName;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String Remark) {
        this.Remark = Remark;
    }

    public int getRevokeState() {
        return RevokeState;
    }

    public void setRevokeState(int RevokeState) {
        this.RevokeState = RevokeState;
    }

    public int getRevokeTime() {
        return RevokeTime;
    }

    public void setRevokeTime(int RevokeTime) {
        this.RevokeTime = RevokeTime;
    }

    public List<PaymentsBean> getPayments() {
        return Payments;
    }

    public void setPayments(List<PaymentsBean> Payments) {
        this.Payments = Payments;
    }

}
