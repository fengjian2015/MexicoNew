package com.fly.ayudaconfiable.network.net.http.response;

import java.util.List;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月8日,0008.
 * 158045632@qq.com
 */
public class ResGoodDetail {

    /**
     * Id : 14906593041610752
     * VenueName : 国际象棋
     * Price : 10.0
     * StartTime : 20200818093036
     * EndTime : 20200818105959
     * TotalMoney : 10.0
     * Point : 0.0
     * Details : [{"GoodsType":2,"GoodsCode":"20200505151922","GoodsName":"刮痧","DiscountPrice":161.28,"Number":2,"TotalMoney":322.56,"OverCount":0,"MeasureUnit":"次","IsWeighable":0,"PassDate":0},{"GoodsType":2,"GoodsCode":"20200505151814","GoodsName":"肩颈疏通","DiscountPrice":161.28,"Number":2,"TotalMoney":322.56,"OverCount":0,"MeasureUnit":"次","IsWeighable":0,"PassDate":0},{"GoodsType":2,"GoodsCode":"20200505152131","GoodsName":"艾灸","DiscountPrice":94.08,"Number":1,"TotalMoney":94.08,"OverCount":0,"MeasureUnit":"次","IsWeighable":0,"PassDate":0}]
     * NoCharge : 0
     * IsPay : 1
     * OrderVenueId : 14906605611055104
     * TimeLength : 2分钟
     * OutTotalMoney : 19.8500
     * OutTimeLength : 1小时27分钟23秒
     * TotalTimeLength : 1小时29分钟23秒
     * SumTotalMoney : 29.85
     * Payments : []
     */

    private String Id = "";
    private String VenueName = "";
    private double Price;
    private long StartTime;
    private long EndTime;
    private double TotalMoney;
    private double Point;
    private int NoCharge;
    private int IsPay;
    private int IsLimit = 1;
    private String OrderVenueId = "";
    private String TimeLength = "";
    private String OutTotalMoney = "";
    private String OutTimeLength = "";
    private String TotalTimeLength = "";
    private double SumTotalMoney;
    private String ChargingDuration = "";
    private List<DetailsBean> Details;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getVenueName() {
        return VenueName;
    }

    public void setVenueName(String VenueName) {
        this.VenueName = VenueName;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public long getStartTime() {
        return StartTime;
    }

    public void setStartTime(long StartTime) {
        this.StartTime = StartTime;
    }

    public long getEndTime() {
        return EndTime;
    }

    public void setEndTime(long EndTime) {
        this.EndTime = EndTime;
    }

    public double getTotalMoney() {
        return TotalMoney;
    }

    public void setTotalMoney(double TotalMoney) {
        this.TotalMoney = TotalMoney;
    }

    public double getPoint() {
        return Point;
    }

    public void setPoint(double Point) {
        this.Point = Point;
    }

    public int getNoCharge() {
        return NoCharge;
    }

    public void setNoCharge(int NoCharge) {
        this.NoCharge = NoCharge;
    }

    public int getIsPay() {
        return IsPay;
    }

    public void setIsPay(int IsPay) {
        this.IsPay = IsPay;
    }

    public int getIsLimit() {
        return IsLimit;
    }

    public void setIsLimit(int isLimit) {
        IsLimit = isLimit;
    }

    public String getOrderVenueId() {
        return OrderVenueId;
    }

    public void setOrderVenueId(String OrderVenueId) {
        this.OrderVenueId = OrderVenueId;
    }

    public String getTimeLength() {
        return TimeLength;
    }

    public void setTimeLength(String TimeLength) {
        this.TimeLength = TimeLength;
    }

    public String getOutTotalMoney() {
        return OutTotalMoney;
    }

    public void setOutTotalMoney(String OutTotalMoney) {
        this.OutTotalMoney = OutTotalMoney;
    }

    public String getOutTimeLength() {
        return OutTimeLength;
    }

    public void setOutTimeLength(String OutTimeLength) {
        this.OutTimeLength = OutTimeLength;
    }

    public String getTotalTimeLength() {
        return TotalTimeLength;
    }

    public void setTotalTimeLength(String TotalTimeLength) {
        this.TotalTimeLength = TotalTimeLength;
    }

    public double getSumTotalMoney() {
        return SumTotalMoney;
    }

    public void setSumTotalMoney(double SumTotalMoney) {
        this.SumTotalMoney = SumTotalMoney;
    }

    public String getChargingDuration() {
        return ChargingDuration;
    }

    public void setChargingDuration(String chargingDuration) {
        ChargingDuration = chargingDuration;
    }

    public List<DetailsBean> getDetails() {
        return Details;
    }

    public void setDetails(List<DetailsBean> Details) {
        this.Details = Details;
    }

    public static class DetailsBean {
        /**
         * GoodsType : 2
         * GoodsCode : 20200505151922
         * GoodsName : 刮痧
         * DiscountPrice : 161.28
         * Number : 2.0
         * TotalMoney : 322.56
         * OverCount : 0.0
         * MeasureUnit : 次
         * IsWeighable : 0
         * PassDate : 0
         */

        private int GoodsType;
        private String GoodsCode = "";
        private String GoodsName = "";
        private double DiscountPrice;
        private String SpecsName = "";
        private double Number;
        private double TotalMoney;
        private double OverCount;
        private String MeasureUnit = "";
        private int IsWeighable;
        private int PassDate;
        private int IsLimit = 1;
        private String ChargingDuration = "";

        public int getGoodsType() {
            return GoodsType;
        }

        public void setGoodsType(int GoodsType) {
            this.GoodsType = GoodsType;
        }

        public String getGoodsCode() {
            return GoodsCode;
        }

        public void setGoodsCode(String GoodsCode) {
            this.GoodsCode = GoodsCode;
        }

        public String getGoodsName() {
            return GoodsName;
        }

        public void setGoodsName(String GoodsName) {
            this.GoodsName = GoodsName;
        }

        public double getDiscountPrice() {
            return DiscountPrice;
        }

        public void setDiscountPrice(double DiscountPrice) {
            this.DiscountPrice = DiscountPrice;
        }

        public String getSpecsName() {
            return SpecsName;
        }

        public void setSpecsName(String specsName) {
            SpecsName = specsName;
        }

        public double getNumber() {
            return Number;
        }

        public void setNumber(double Number) {
            this.Number = Number;
        }

        public double getTotalMoney() {
            return TotalMoney;
        }

        public void setTotalMoney(double TotalMoney) {
            this.TotalMoney = TotalMoney;
        }

        public double getOverCount() {
            return OverCount;
        }

        public void setOverCount(double OverCount) {
            this.OverCount = OverCount;
        }

        public String getMeasureUnit() {
            return MeasureUnit;
        }

        public void setMeasureUnit(String MeasureUnit) {
            this.MeasureUnit = MeasureUnit;
        }

        public int getIsWeighable() {
            return IsWeighable;
        }

        public void setIsWeighable(int IsWeighable) {
            this.IsWeighable = IsWeighable;
        }

        public int getPassDate() {
            return PassDate;
        }

        public void setPassDate(int PassDate) {
            this.PassDate = PassDate;
        }

        public int getIsLimit() {
            return IsLimit;
        }

        public void setIsLimit(int isLimit) {
            IsLimit = isLimit;
        }

        public String getChargingDuration() {
            return ChargingDuration;
        }

        public void setChargingDuration(String chargingDuration) {
            ChargingDuration = chargingDuration;
        }
    }

    //以上是场地消费 以下是其他消费 共用一个bean 比较好处理=================================================================

    /**
     * GoodsType : 1
     * GoodsCode : 20191023150448203
     * GoodsName : 称重1
     * DiscountPrice : 0.0
     * Number : 1.0
     * TotalMoney : 0.0
     * SpecsName : 133
     * OverCount : 0.0
     * MeasureUnit : kg
     * IsWeighable : 0
     * PassDate : 20210723
     */
    private int GoodsType;
    private String GoodsCode = "";
    private String GoodsName = "";
    private double DiscountPrice;
    private double Number;
    private String SpecsName = "";
    private double OverCount;
    private String MeasureUnit = "";
    private String OilGunNum = "";
    private String ActivityInfo = "";
    private int IsWeighable;
    private long PassDate;

    public String getOilGunNum() {
        return OilGunNum;
    }

    public void setOilGunNum(String oilGunNum) {
        OilGunNum = oilGunNum;
    }

    public String getActivityInfo() {
        return ActivityInfo;
    }

    public void setActivityInfo(String activityInfo) {
        ActivityInfo = activityInfo;
    }

    public int getGoodsType() {
        return GoodsType;
    }

    public void setGoodsType(int GoodsType) {
        this.GoodsType = GoodsType;
    }

    public String getGoodsCode() {
        return GoodsCode;
    }

    public void setGoodsCode(String GoodsCode) {
        this.GoodsCode = GoodsCode;
    }

    public String getGoodsName() {
        return GoodsName;
    }

    public void setGoodsName(String GoodsName) {
        this.GoodsName = GoodsName;
    }

    public double getDiscountPrice() {
        return DiscountPrice;
    }

    public void setDiscountPrice(double DiscountPrice) {
        this.DiscountPrice = DiscountPrice;
    }

    public double getNumber() {
        return Number;
    }

    public void setNumber(double Number) {
        this.Number = Number;
    }

    public String getSpecsName() {
        return SpecsName;
    }

    public void setSpecsName(String SpecsName) {
        this.SpecsName = SpecsName;
    }

    public double getOverCount() {
        return OverCount;
    }

    public void setOverCount(double OverCount) {
        this.OverCount = OverCount;
    }

    public String getMeasureUnit() {
        return MeasureUnit;
    }

    public void setMeasureUnit(String MeasureUnit) {
        this.MeasureUnit = MeasureUnit;
    }

    public int getIsWeighable() {
        return IsWeighable;
    }

    public void setIsWeighable(int IsWeighable) {
        this.IsWeighable = IsWeighable;
    }

    public long getPassDate() {
        return PassDate;
    }

    public void setPassDate(long PassDate) {
        this.PassDate = PassDate;
    }

}
