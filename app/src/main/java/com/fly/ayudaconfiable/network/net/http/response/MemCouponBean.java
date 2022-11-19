package com.fly.ayudaconfiable.network.net.http.response;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月31日,0031.
 * 158045632@qq.com
 */
public class MemCouponBean {


    /**
     * MemID : 14392753351964672
     * Mobile : 13412341236
     * CardName : q
     * Title : 代金券@li
     * ConponCode : D724EAB5
     * State : 0
     * SendTime : 20190829151806
     * ValidType : 1
     * UseTime : 0
     * Category : 1
     * UseType : 1
     * WithUseAmount : 0
     * Quota : 0  额度
     * ValidStartTime : 10101000000
     * ValidEndTime : 99991231235959
     */

    private String MemID;
    private String Mobile;
    private String CardName;
    private String Title;
    private String ConponCode;
    private int State;
    private long SendTime;
    private int ValidType;
    private long UseTime;
    private int Category;
    private int UseType;
    private double WithUseAmount;
    private double Quota;
    private long ValidStartTime;
    private long ValidEndTime;

    public String getMemID() {
        return MemID;
    }

    public void setMemID(String memID) {
        MemID = memID;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getCardName() {
        return CardName;
    }

    public void setCardName(String cardName) {
        CardName = cardName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getConponCode() {
        return ConponCode;
    }

    public void setConponCode(String conponCode) {
        ConponCode = conponCode;
    }

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }

    public long getSendTime() {
        return SendTime;
    }

    public void setSendTime(long sendTime) {
        SendTime = sendTime;
    }

    public int getValidType() {
        return ValidType;
    }

    public void setValidType(int validType) {
        ValidType = validType;
    }

    public long getUseTime() {
        return UseTime;
    }

    public void setUseTime(long useTime) {
        UseTime = useTime;
    }

    public int getCategory() {
        return Category;
    }

    public void setCategory(int category) {
        Category = category;
    }

    public int getUseType() {
        return UseType;
    }

    public void setUseType(int useType) {
        UseType = useType;
    }

    public double getWithUseAmount() {
        return WithUseAmount;
    }

    public void setWithUseAmount(double withUseAmount) {
        WithUseAmount = withUseAmount;
    }

    public double getQuota() {
        return Quota;
    }

    public void setQuota(double quota) {
        Quota = quota;
    }

    public long getValidStartTime() {
        return ValidStartTime;
    }

    public void setValidStartTime(long validStartTime) {
        ValidStartTime = validStartTime;
    }

    public long getValidEndTime() {
        return ValidEndTime;
    }

    public void setValidEndTime(long validEndTime) {
        ValidEndTime = validEndTime;
    }
}
