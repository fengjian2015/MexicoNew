package com.fly.ayudaconfiable.network.net.http.response;

import java.io.Serializable;
import java.util.List;
/**
 * nakesoft
 * Created by 孔明 on 2019年7月16日,0016.
 * 158045632@qq.com
 */
public class MemCardBean implements Serializable {

    private static final long serialVersionUID = 7981362441812074384L;
    /**
     * Id : 14373044037711872
     * CardID : 123456
     * CardName : 孔明测试
     * Mobile :
     * LevelID : 14307947124357120
     * LevelName : vip八折卡
     * Money : 0
     * Point : 0
     * Avatar :
     * RemainingCount : 2
     * DiscountPercent : 0.8
     * ClassDiscountRulesList : [{"GoodsClassId":"14306356306343936","GoodsClassName":"分类3","Discount":0.2},{"GoodsClassId":"14327973508200448","GoodsClassName":"默认分类234","Discount":1},{"GoodsClassId":"14353404835002368","GoodsClassName":"ChANEl","Discount":0.95}]
     * PointPercent : 0
     * State : 0
     * IsBirthday : 0
     */
    private String Id = "";
    private String CardID = "";
    private String CardName = "";
    private String Mobile = "";
    private String LevelID = "";
    private String LevelName = "";
    private double Money;
    /*汽油余额*/
    private double PetrolMoney;
    /*柴油余额*/
    private double DieselOilMoney;
    /*天然气余额*/
    private double NaturalGasMoney;
    private double Point;
    private String Avatar = "";
    private String ShopID = "";
    private int RemainingCount;
    private double DiscountPercent;
    private double PointPercent;
    private int State;
    private int IsBirthday;
    private int IsExistPwd;
    private long PassDate;
    private long DauPassDate;
    private List<ClassDiscountRulesListBean> ClassDiscountRulesList;
    private String ClassDiscountRules = "";
    /*是否享受会员特价 0享受 1不享受*/
    private int IsEnjoyMemberPrice;
    /*全局新增会员每日优惠限制 0可用 1不可用*/
    private int IsNoUseMemberDiscount;

    public boolean isSelected = false;
    /*以下是子卡添加字段 是否是子卡*/
    /*是否限制子卡可用额度 1限制 0不限制 默认1*/
    private int IsLimitQuota = 1;
    private int IsDaughterCard;
    private String DauCardID = "";
    private String DaughterID = "";
    private String DauCardName = "";
    private int IsOpenPwd;
    private double SingleQuota;
    private double SurplusQuota;
    private double TotalPay;
    private double TotalPoint;
    private double TotalBuy;
    private String CreateTime = "";
    private String CreateTimeCh = "";
    private int Sex;
    private boolean canPlateSearch = false;
    private String PlateNumber = "";
    private String DauPlateNumber = "";

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

    public String getLevelID() {
        return LevelID;
    }

    public void setLevelID(String levelID) {
        LevelID = levelID;
    }

    public String getLevelName() {
        return LevelName;
    }

    public void setLevelName(String levelName) {
        LevelName = levelName;
    }

    public double getMoney() {
        return Money;
    }

    public void setMoney(double money) {
        Money = money;
    }

    public double getPetrolMoney() {
        return PetrolMoney;
    }

    public void setPetrolMoney(double petrolMoney) {
        PetrolMoney = petrolMoney;
    }

    public double getDieselOilMoney() {
        return DieselOilMoney;
    }

    public void setDieselOilMoney(double dieselOilMoney) {
        DieselOilMoney = dieselOilMoney;
    }

    public double getNaturalGasMoney() {
        return NaturalGasMoney;
    }

    public void setNaturalGasMoney(double naturalGasMoney) {
        NaturalGasMoney = naturalGasMoney;
    }

    public double getPoint() {
        return Point;
    }

    public void setPoint(double point) {
        Point = point;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public String getShopID() {
        return ShopID;
    }

    public void setShopID(String shopID) {
        ShopID = shopID;
    }

    public int getRemainingCount() {
        return RemainingCount;
    }

    public void setRemainingCount(int remainingCount) {
        RemainingCount = remainingCount;
    }

    public double getDiscountPercent() {
        return DiscountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        DiscountPercent = discountPercent;
    }

    public double getPointPercent() {
        return PointPercent;
    }

    public void setPointPercent(double pointPercent) {
        PointPercent = pointPercent;
    }

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }

    public int getIsBirthday() {
        return IsBirthday;
    }

    public void setIsBirthday(int isBirthday) {
        IsBirthday = isBirthday;
    }

    public int getIsExistPwd() {
        return IsExistPwd;
    }

    public void setIsExistPwd(int isExistPwd) {
        IsExistPwd = isExistPwd;
    }

    public List<ClassDiscountRulesListBean> getClassDiscountRulesList() {
        return ClassDiscountRulesList;
    }

    public void setClassDiscountRulesList(List<ClassDiscountRulesListBean> classDiscountRulesList) {
        ClassDiscountRulesList = classDiscountRulesList;
    }

    public String getClassDiscountRules() {
        return ClassDiscountRules;
    }

    public void setClassDiscountRules(String classDiscountRules) {
        ClassDiscountRules = classDiscountRules;
    }

    public long getPassDate() {
        return PassDate;
    }

    public void setPassDate(long passDate) {
        PassDate = passDate;
    }

    public long getDauPassDate() {
        return DauPassDate;
    }

    public void setDauPassDate(long dauPassDate) {
        DauPassDate = dauPassDate;
    }

    public int getIsLimitQuota() {
        return IsLimitQuota;
    }

    public void setIsLimitQuota(int isLimitQuota) {
        IsLimitQuota = isLimitQuota;
    }

    public int getIsDaughterCard() {
        return IsDaughterCard;
    }

    public void setIsDaughterCard(int isDaughterCard) {
        IsDaughterCard = isDaughterCard;
    }

    public String getDauCardID() {
        return DauCardID;
    }

    public void setDauCardID(String dauCardID) {
        DauCardID = dauCardID;
    }

    public String getDaughterID() {
        return DaughterID;
    }

    public void setDaughterID(String daughterID) {
        DaughterID = daughterID;
    }

    public String getDauCardName() {
        return DauCardName;
    }

    public void setDauCardName(String dauCardName) {
        DauCardName = dauCardName;
    }

    public int getIsOpenPwd() {
        return IsOpenPwd;
    }

    public void setIsOpenPwd(int isOpenPwd) {
        IsOpenPwd = isOpenPwd;
    }

    public double getSingleQuota() {
        return SingleQuota;
    }

    public void setSingleQuota(double singleQuota) {
        SingleQuota = singleQuota;
    }

    public double getSurplusQuota() {
        return SurplusQuota;
    }

    public void setSurplusQuota(double surplusQuota) {
        SurplusQuota = surplusQuota;
    }

    public double getTotalPay() {
        return TotalPay;
    }

    public void setTotalPay(double totalPay) {
        TotalPay = totalPay;
    }

    public double getTotalPoint() {
        return TotalPoint;
    }

    public void setTotalPoint(double totalPoint) {
        TotalPoint = totalPoint;
    }

    public double getTotalBuy() {
        return TotalBuy;
    }

    public void setTotalBuy(double totalBuy) {
        TotalBuy = totalBuy;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getCreateTimeCh() {
        return CreateTimeCh;
    }

    public void setCreateTimeCh(String createTimeCh) {
        CreateTimeCh = createTimeCh;
    }

    public int getSex() {
        return Sex;
    }

    public void setSex(int sex) {
        Sex = sex;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isCanPlateSearch() {
        return canPlateSearch;
    }

    public void setCanPlateSearch(boolean canPlateSearch) {
        this.canPlateSearch = canPlateSearch;
    }

    public String getPlateNumber() {
        return PlateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        PlateNumber = plateNumber;
    }

    public String getDauPlateNumber() {
        return DauPlateNumber;
    }

    public void setDauPlateNumber(String dauPlateNumber) {
        DauPlateNumber = dauPlateNumber;
    }

    public int getIsEnjoyMemberPrice() {
        return IsEnjoyMemberPrice;
    }

    public void setIsEnjoyMemberPrice(int isEnjoyMemberPrice) {
        IsEnjoyMemberPrice = isEnjoyMemberPrice;
    }

    public int getIsNoUseMemberDiscount() {
        return IsNoUseMemberDiscount;
    }

    public void setIsNoUseMemberDiscount(int isNoUseMemberDiscount) {
        IsNoUseMemberDiscount = isNoUseMemberDiscount;
    }

    @Override
    public String toString() {
        return "MemCardBean{" +
                "Id='" + Id + '\'' +
                ", CardID='" + CardID + '\'' +
                ", CardName='" + CardName + '\'' +
                ", Mobile='" + Mobile + '\'' +
                ", LevelID='" + LevelID + '\'' +
                ", LevelName='" + LevelName + '\'' +
                ", Money=" + Money +
                ", Point=" + Point +
                ", Avatar='" + Avatar + '\'' +
                ", ShopID='" + ShopID + '\'' +
                ", RemainingCount=" + RemainingCount +
                ", DiscountPercent=" + DiscountPercent +
                ", PointPercent=" + PointPercent +
                ", State=" + State +
                ", IsBirthday=" + IsBirthday +
                ", IsExistPwd=" + IsExistPwd +
                ", PassDate=" + PassDate +
                ", ClassDiscountRulesList=" + ClassDiscountRulesList +
                ", isSelected=" + isSelected +
                ", IsDaughterCard=" + IsDaughterCard +
                ", DauCardID='" + DauCardID + '\'' +
                ", DaughterID='" + DaughterID + '\'' +
                ", DauCardName='" + DauCardName + '\'' +
                ", IsOpenPwd=" + IsOpenPwd +
                ", SingleQuota=" + SingleQuota +
                ", SurplusQuota=" + SurplusQuota +
                ", TotalPay=" + TotalPay +
                ", TotalPoint=" + TotalPoint +
                ", TotalBuy=" + TotalBuy +
                ", CreateTime='" + CreateTime + '\'' +
                ", CreateTimeCh='" + CreateTimeCh + '\'' +
                ", Sex=" + Sex +
                '}';
    }


}
