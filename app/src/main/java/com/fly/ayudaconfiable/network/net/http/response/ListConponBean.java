package com.fly.ayudaconfiable.network.net.http.response;

import java.io.Serializable;

public class ListConponBean implements Serializable{
    /**
     * Id : 14332515879991296
     * Title : 优惠券
     * Category : 1
     * Quota : 111
     * UseType : 2
     * WithUseAmount : 222
     * DiscountWay : 2
     * DiscountValue : 1
     * DiscountStartValue : 333
     * DiscountEndValue : 444
     * ValidType : 2
     * ValidStartTime : 20190710
     * ValidEndTime : 20190730
     * ValidDays : 0
     * ReceiveMode : 3
     * ReceiveCost : 555
     * IsLimitReceiveTotal : 1
     * LimitReceiveTotal : 666
     * IsLimitUse : 1
     * LimitUseDays : 2
     * LimitUseCount : 3
     * IsLimitReceive : 1
     * LimitReceiveDays : 4
     * LimitReceiveCount : 5
     * LimitGoodsWay : 2
     * LimitGoods : 1,2
     * LimitShopWay : 3
     * LimitShop : 14272953155303455
     * IsAllowManyTimesUse : 1
     * IsAllowWechatShow : 1
     * Message : 优惠券
     使用时间：2019-07-10 - 2019-07-30
     优惠内容：订单满222元随机减333至444元
     其他限制：指定商品可用
     指定门店不可用
     一次性使用
     1天内限用1张
     1天内限领1张

     * SendCount : 0
     * UsedCount : 0
     * IsDelete : 0
     */

    private String Id;
    private String Title;
    private int Category;
    private double Quota;
    private int UseType;
    private double WithUseAmount;
    private int DiscountWay;
    private double DiscountValue;
    private double DiscountStartValue;
    private double DiscountEndValue;
    private int ValidType;
    private int ValidStartTime;
    private int ValidEndTime;
    private int ValidDays;
    private int ReceiveMode;
    private double ReceiveCost;
    private int IsLimitReceiveTotal;
    private int LimitReceiveTotal;
    private int IsLimitUse;
    private int LimitUseDays;
    private int LimitUseCount;
    private int IsLimitReceive;
    private int LimitReceiveDays;
    private int LimitReceiveCount;
    private int LimitGoodsWay;
    private String LimitGoods;
    private int LimitShopWay;
    private String LimitShop;
    private int IsAllowManyTimesUse;
    private int IsAllowWechatShow;
    private String Message;
    private int SendCount;
    private int UsedCount;
    private int IsDelete;

    private boolean isSelected = false;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getCategory() {
        return Category;
    }

    public void setCategory(int category) {
        Category = category;
    }

    public double getQuota() {
        return Quota;
    }

    public void setQuota(double quota) {
        Quota = quota;
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

    public int getDiscountWay() {
        return DiscountWay;
    }

    public void setDiscountWay(int discountWay) {
        DiscountWay = discountWay;
    }

    public double getDiscountValue() {
        return DiscountValue;
    }

    public void setDiscountValue(double discountValue) {
        DiscountValue = discountValue;
    }

    public double getDiscountStartValue() {
        return DiscountStartValue;
    }

    public void setDiscountStartValue(double discountStartValue) {
        DiscountStartValue = discountStartValue;
    }

    public double getDiscountEndValue() {
        return DiscountEndValue;
    }

    public void setDiscountEndValue(double discountEndValue) {
        DiscountEndValue = discountEndValue;
    }

    public int getValidType() {
        return ValidType;
    }

    public void setValidType(int validType) {
        ValidType = validType;
    }

    public int getValidStartTime() {
        return ValidStartTime;
    }

    public void setValidStartTime(int validStartTime) {
        ValidStartTime = validStartTime;
    }

    public int getValidEndTime() {
        return ValidEndTime;
    }

    public void setValidEndTime(int validEndTime) {
        ValidEndTime = validEndTime;
    }

    public int getValidDays() {
        return ValidDays;
    }

    public void setValidDays(int validDays) {
        ValidDays = validDays;
    }

    public int getReceiveMode() {
        return ReceiveMode;
    }

    public void setReceiveMode(int receiveMode) {
        ReceiveMode = receiveMode;
    }

    public double getReceiveCost() {
        return ReceiveCost;
    }

    public void setReceiveCost(double receiveCost) {
        ReceiveCost = receiveCost;
    }

    public int getIsLimitReceiveTotal() {
        return IsLimitReceiveTotal;
    }

    public void setIsLimitReceiveTotal(int isLimitReceiveTotal) {
        IsLimitReceiveTotal = isLimitReceiveTotal;
    }

    public int getLimitReceiveTotal() {
        return LimitReceiveTotal;
    }

    public void setLimitReceiveTotal(int limitReceiveTotal) {
        LimitReceiveTotal = limitReceiveTotal;
    }

    public int getIsLimitUse() {
        return IsLimitUse;
    }

    public void setIsLimitUse(int isLimitUse) {
        IsLimitUse = isLimitUse;
    }

    public int getLimitUseDays() {
        return LimitUseDays;
    }

    public void setLimitUseDays(int limitUseDays) {
        LimitUseDays = limitUseDays;
    }

    public int getLimitUseCount() {
        return LimitUseCount;
    }

    public void setLimitUseCount(int limitUseCount) {
        LimitUseCount = limitUseCount;
    }

    public int getIsLimitReceive() {
        return IsLimitReceive;
    }

    public void setIsLimitReceive(int isLimitReceive) {
        IsLimitReceive = isLimitReceive;
    }

    public int getLimitReceiveDays() {
        return LimitReceiveDays;
    }

    public void setLimitReceiveDays(int limitReceiveDays) {
        LimitReceiveDays = limitReceiveDays;
    }

    public int getLimitReceiveCount() {
        return LimitReceiveCount;
    }

    public void setLimitReceiveCount(int limitReceiveCount) {
        LimitReceiveCount = limitReceiveCount;
    }

    public int getLimitGoodsWay() {
        return LimitGoodsWay;
    }

    public void setLimitGoodsWay(int limitGoodsWay) {
        LimitGoodsWay = limitGoodsWay;
    }

    public String getLimitGoods() {
        return LimitGoods;
    }

    public void setLimitGoods(String limitGoods) {
        LimitGoods = limitGoods;
    }

    public int getLimitShopWay() {
        return LimitShopWay;
    }

    public void setLimitShopWay(int limitShopWay) {
        LimitShopWay = limitShopWay;
    }

    public String getLimitShop() {
        return LimitShop;
    }

    public void setLimitShop(String limitShop) {
        LimitShop = limitShop;
    }

    public int getIsAllowManyTimesUse() {
        return IsAllowManyTimesUse;
    }

    public void setIsAllowManyTimesUse(int isAllowManyTimesUse) {
        IsAllowManyTimesUse = isAllowManyTimesUse;
    }

    public int getIsAllowWechatShow() {
        return IsAllowWechatShow;
    }

    public void setIsAllowWechatShow(int isAllowWechatShow) {
        IsAllowWechatShow = isAllowWechatShow;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public int getSendCount() {
        return SendCount;
    }

    public void setSendCount(int sendCount) {
        SendCount = sendCount;
    }

    public int getUsedCount() {
        return UsedCount;
    }

    public void setUsedCount(int usedCount) {
        UsedCount = usedCount;
    }

    public int getIsDelete() {
        return IsDelete;
    }

    public void setIsDelete(int isDelete) {
        IsDelete = isDelete;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
