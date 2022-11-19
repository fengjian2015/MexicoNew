package com.fly.ayudaconfiable.network.net.http.response;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * nakesoft
 * Created by 孔明 on 2019年7月17日,0017.
 * 158045632@qq.com
 * 展示 商品 ，用于购买的
 */
public class ShowGoodsBean implements Serializable {

    /**
     * StockNum : 0
     * Number : 0
     * PassDate : 0
     * IsCombo : 0
     * GoodsType : 2
     * Id : 2
     * GoodsCode : 1002
     * GoodsName : 服务22
     * Price : 5
     * Images : /FileSys/GoodsIMG/198/20190710203744912.jpeg
     * IsPoint : 1
     * PointType : 0
     * MinDiscount : 1
     * IsDiscount : 1
     * MeasureUnit : 订单
     * Specials : 0
     */

    /*是否普通套餐商品*/
    private int IsCombo;
    private int IsLimit = 1;
    private int GoodsType;
    private int IsPoint;
    private int IsDiscount;
    private int IsWeighable;
    private int SpecsType;
    private int isModify;
    private int EffectiveValue = 1;
    private int EffectiveType = 4;
    /*IsEnableGoodsFlavor 是否启用商品规格 0否 1是*/
    private int IsEnableGoodsFlavor;
    /*会员的计次项目是否过期*/
    private int IsBeOverdue;
    private int IsGiveCountCard;
    private int HasNormalGoods;
    public double Point;
    private double StockNum;
    private double TotalNum;
    private double Number;
    private double Price;
    private double PointType;
    private double MinDiscount;
    private double Specials;
    /*当前商品的当前选中数量*/
    private double CurrentQuantity;
    private double SelectAmount;
    private double payPrice;
    private double totalPrice;
    private double couponAmount;
    private double startPrice;
    private double startSpecials;
    /*口味商品当前在购物车中已经选中的总数量*/
    private double totalSelectCount;
    /*计时商品的起始计算价*/
    private double TimeGoodsStartPrice;
    private double OriginalMoney;
    private long PassDate;
    /*本地添加字段 套餐商品是否需要判断库存 依据是里面是否包含有普通商品
    但凡有一个就需要判断库存 但此值已用HasNormalGoods替换后台有返回这个*/
    private boolean comboHasStock;
    private boolean isChargeTimeProduct;
    private boolean isRest;
    /*是否来自于取单数据*/
    private boolean fromRest;

    /*美业ITEM新加*/
    private String Id = "";
    private String GoodsID = "";
    private String GID = "";
    private String GoodsCode = "";
    private String GoodsName = "";
    private String GoodsTypeName = "";
    private String GoodsClass = "";
    private String ParentGoodsClassID = "";
    private String Images = "";
    private String MeasureUnit = "";
    private String BatchCode = "";
    private String MemberCountCardID = "";
    private String SpecsName = "";
    private String SpecsList = "";
    private String SpecsDetail = "";
    private String SpecsID = "";
    //点餐需要的
    private String OrderDetailID = "";
    /*计时商品数据*/
    private String StartTime = "0";
    private String EndTime = "0";
    private String TotalMinutes = "00:00";
    private ArrayList<StaffAndClassBean> selectedStaff;
    private List<ComboGoodsBean> ComboDetail;
    private List<SpecsGoodsBean> specsGoods;

    public int getIsCombo() {
        return IsCombo;
    }

    public void setIsCombo(int isCombo) {
        IsCombo = isCombo;
    }

    public int getIsLimit() {
        return IsLimit;
    }

    public void setIsLimit(int isLimit) {
        IsLimit = isLimit;
    }

    public int getGoodsType() {
        return GoodsType;
    }

    public void setGoodsType(int goodsType) {
        GoodsType = goodsType;
    }

    public int getIsPoint() {
        return IsPoint;
    }

    public void setIsPoint(int isPoint) {
        IsPoint = isPoint;
    }

    public int getIsDiscount() {
        return IsDiscount;
    }

    public void setIsDiscount(int isDiscount) {
        IsDiscount = isDiscount;
    }

    public int getIsWeighable() {
        return IsWeighable;
    }

    public void setIsWeighable(int isWeighable) {
        IsWeighable = isWeighable;
    }

    public int getSpecsType() {
        return SpecsType;
    }

    public void setSpecsType(int specsType) {
        SpecsType = specsType;
    }

    public int getIsModify() {
        return isModify;
    }

    public void setIsModify(int isModify) {
        this.isModify = isModify;
    }

    public int getEffectiveValue() {
        return EffectiveValue;
    }

    public void setEffectiveValue(int effectiveValue) {
        EffectiveValue = effectiveValue;
    }

    public int getEffectiveType() {
        return EffectiveType;
    }

    public void setEffectiveType(int effectiveType) {
        EffectiveType = effectiveType;
    }

    public int getIsEnableGoodsFlavor() {
        return IsEnableGoodsFlavor;
    }

    public void setIsEnableGoodsFlavor(int isEnableGoodsFlavor) {
        IsEnableGoodsFlavor = isEnableGoodsFlavor;
    }

    public int getIsBeOverdue() {
        return IsBeOverdue;
    }

    public void setIsBeOverdue(int isBeOverdue) {
        IsBeOverdue = isBeOverdue;
    }

    public int getIsGiveCountCard() {
        return IsGiveCountCard;
    }

    public void setIsGiveCountCard(int isGiveCountCard) {
        IsGiveCountCard = isGiveCountCard;
    }

    public int getHasNormalGoods() {
        return HasNormalGoods;
    }

    public void setHasNormalGoods(int hasNormalGoods) {
        HasNormalGoods = hasNormalGoods;
    }

    public double getPoint() {
        return Point;
    }

    public void setPoint(double point) {
        Point = point;
    }

    public double getStockNum() {
        return StockNum;
    }

    public void setStockNum(double stockNum) {
        StockNum = stockNum;
    }

    public double getTotalNum() {
        return TotalNum;
    }

    public void setTotalNum(double totalNum) {
        TotalNum = totalNum;
    }

    public double getNumber() {
        return Number;
    }

    public void setNumber(double number) {
        Number = number;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public double getPointType() {
        return PointType;
    }

    public void setPointType(double pointType) {
        PointType = pointType;
    }

    public double getMinDiscount() {
        return MinDiscount;
    }

    public void setMinDiscount(double minDiscount) {
        MinDiscount = minDiscount;
    }

    public double getSpecials() {
        return Specials;
    }

    public void setSpecials(double specials) {
        Specials = specials;
    }

    public double getCurrentQuantity() {
        return CurrentQuantity;
    }

    public void setCurrentQuantity(double currentQuantity) {
        CurrentQuantity = currentQuantity;
    }

    public double getSelectAmount() {
        return SelectAmount;
    }

    public void setSelectAmount(double selectAmount) {
        SelectAmount = selectAmount;
    }

    public double getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(double payPrice) {
        this.payPrice = payPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(double couponAmount) {
        this.couponAmount = couponAmount;
    }

    public double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(double startPrice) {
        this.startPrice = startPrice;
    }

    public double getStartSpecials() {
        return startSpecials;
    }

    public void setStartSpecials(double startSpecials) {
        this.startSpecials = startSpecials;
    }

    public double getTotalSelectCount() {
        return totalSelectCount;
    }

    public void setTotalSelectCount(double totalSelectCount) {
        this.totalSelectCount = totalSelectCount;
    }

    public double getTimeGoodsStartPrice() {
        return TimeGoodsStartPrice;
    }

    public void setTimeGoodsStartPrice(double timeGoodsStartPrice) {
        TimeGoodsStartPrice = timeGoodsStartPrice;
    }

    public double getOriginalMoney() {
        return OriginalMoney;
    }

    public void setOriginalMoney(double originalMoney) {
        OriginalMoney = originalMoney;
    }

    public long getPassDate() {
        return PassDate;
    }

    public void setPassDate(long passDate) {
        PassDate = passDate;
    }

    public boolean isComboHasStock() {
        return comboHasStock;
    }

    public void setComboHasStock(boolean comboHasStock) {
        this.comboHasStock = comboHasStock;
    }

    public boolean isChargeTimeProduct() {
        return isChargeTimeProduct;
    }

    public void setChargeTimeProduct(boolean chargeTimeProduct) {
        isChargeTimeProduct = chargeTimeProduct;
    }

    public boolean isRest() {
        return isRest;
    }

    public void setRest(boolean rest) {
        isRest = rest;
    }

    public boolean isFromRest() {
        return fromRest;
    }

    public void setFromRest(boolean fromRest) {
        this.fromRest = fromRest;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getGoodsID() {
        return GoodsID;
    }

    public void setGoodsID(String goodsID) {
        GoodsID = goodsID;
    }

    public String getGID() {
        return GID;
    }

    public void setGID(String GID) {
        this.GID = GID;
    }

    public String getGoodsCode() {
        return GoodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        GoodsCode = goodsCode;
    }

    public String getGoodsName() {
        return GoodsName;
    }

    public void setGoodsName(String goodsName) {
        GoodsName = goodsName;
    }

    public String getGoodsTypeName() {
        return GoodsTypeName;
    }

    public void setGoodsTypeName(String goodsTypeName) {
        GoodsTypeName = goodsTypeName;
    }

    public String getGoodsClass() {
        return GoodsClass;
    }

    public void setGoodsClass(String goodsClass) {
        GoodsClass = goodsClass;
    }

    public String getParentGoodsClassID() {
        return ParentGoodsClassID;
    }

    public void setParentGoodsClassID(String parentGoodsClassID) {
        ParentGoodsClassID = parentGoodsClassID;
    }

    public String getImages() {
        return Images;
    }

    public void setImages(String images) {
        Images = images;
    }

    public String getMeasureUnit() {
        return MeasureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        MeasureUnit = measureUnit;
    }

    public String getBatchCode() {
        return BatchCode;
    }

    public void setBatchCode(String batchCode) {
        BatchCode = batchCode;
    }

    public String getMemberCountCardID() {
        return MemberCountCardID;
    }

    public void setMemberCountCardID(String memberCountCardID) {
        MemberCountCardID = memberCountCardID;
    }

    public String getSpecsName() {
        return SpecsName;
    }

    public void setSpecsName(String specsName) {
        SpecsName = specsName;
    }

    public String getSpecsList() {
        return SpecsList;
    }

    public void setSpecsList(String specsList) {
        SpecsList = specsList;
    }

    public String getSpecsDetail() {
        return SpecsDetail;
    }

    public void setSpecsDetail(String specsDetail) {
        SpecsDetail = specsDetail;
    }

    public String getSpecsID() {
        return SpecsID;
    }

    public void setSpecsID(String specsID) {
        SpecsID = specsID;
    }

    public String getOrderDetailID() {
        return OrderDetailID;
    }

    public void setOrderDetailID(String orderDetailID) {
        OrderDetailID = orderDetailID;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public String getTotalMinutes() {
        return TotalMinutes;
    }

    public void setTotalMinutes(String totalMinutes) {
        TotalMinutes = totalMinutes;
    }

    public ArrayList<StaffAndClassBean> getSelectedStaff() {
        return selectedStaff;
    }

    public void setSelectedStaff(ArrayList<StaffAndClassBean> selectedStaff) {
        this.selectedStaff = selectedStaff;
    }

    public List<ComboGoodsBean> getComboDetail() {
        return ComboDetail;
    }

    public void setComboDetail(List<ComboGoodsBean> comboDetail) {
        ComboDetail = comboDetail;
    }

    public List<SpecsGoodsBean> getSpecsGoods() {
        return specsGoods;
    }

    public void setSpecsGoods(List<SpecsGoodsBean> specsGoods) {
        this.specsGoods = specsGoods;
    }


    /*普通套餐商品内的各种商品*/
    public static class ComboGoodsBean implements Serializable {
        /**
         * Id : 14436588043548672
         * GoodsCode : 33
         * GoodsName : 333
         * Qty : 1.0
         * GoodsType : 2
         */
        private int GoodsType;
        private double Qty;
        private String Id = "";
        private String GoodsCode = "";
        private String GoodsName = "";

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
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

        public double getQty() {
            return Qty;
        }

        public void setQty(double Qty) {
            this.Qty = Qty;
        }

        public int getGoodsType() {
            return GoodsType;
        }

        public void setGoodsType(int GoodsType) {
            this.GoodsType = GoodsType;
        }
    }

    public ShowGoodsBean cloneSelf(ShowGoodsBean bean) {
        ShowGoodsBean goodsInfo = new ShowGoodsBean();
        goodsInfo.setId(bean.getId());
        goodsInfo.setGID(bean.getGID());
        goodsInfo.setOrderDetailID(bean.getOrderDetailID());
        goodsInfo.setParentGoodsClassID(bean.getParentGoodsClassID());
        goodsInfo.setStockNum(bean.getStockNum());
        goodsInfo.setTotalNum(bean.getTotalNum());
        goodsInfo.setNumber(bean.getNumber());
        goodsInfo.setPassDate(bean.getPassDate());
        goodsInfo.setIsCombo(bean.getIsCombo());
        goodsInfo.setIsLimit(bean.getIsLimit());
        goodsInfo.setGoodsType(bean.getGoodsType());
        goodsInfo.setIsPoint(bean.getIsPoint());
        goodsInfo.setPointType(bean.getPointType());
        goodsInfo.setGoodsCode(bean.getGoodsCode());
        goodsInfo.setGoodsName(bean.getGoodsName());
        goodsInfo.setGoodsTypeName(bean.getGoodsTypeName());
        goodsInfo.setGoodsClass(bean.getGoodsClass());
        goodsInfo.setTotalPrice(bean.getTotalPrice());
        goodsInfo.setImages(bean.getImages());
        goodsInfo.setIsPoint(bean.getIsPoint());
        goodsInfo.setPointType(bean.getPointType());
        goodsInfo.setMinDiscount(bean.getMinDiscount());
        goodsInfo.setIsDiscount(bean.getIsDiscount());
        goodsInfo.setSpecsID(bean.getSpecsID());
        goodsInfo.setSpecsList(bean.getSpecsList());
        goodsInfo.setSpecsDetail(bean.getSpecsDetail());
        goodsInfo.setMeasureUnit(bean.getMeasureUnit());
        goodsInfo.setSelectAmount(bean.getSelectAmount());
        goodsInfo.setBatchCode(bean.getBatchCode());
        goodsInfo.setMemberCountCardID(bean.getMemberCountCardID());
        goodsInfo.setIsWeighable(bean.getIsWeighable());
        goodsInfo.setSpecsType(bean.getSpecsType());
        goodsInfo.setSpecsName(bean.getSpecsName());
        goodsInfo.setCouponAmount(bean.getCouponAmount());
        goodsInfo.setStartPrice(bean.getStartPrice());
        goodsInfo.setStartSpecials(bean.getStartSpecials());
        goodsInfo.setComboDetail(bean.getComboDetail());
        goodsInfo.setIsModify(bean.getIsModify());
        goodsInfo.setPayPrice(bean.getPayPrice());
        goodsInfo.setSpecsGoods(bean.getSpecsGoods());
        goodsInfo.setPrice(bean.getPrice());
        goodsInfo.setHasNormalGoods(bean.getHasNormalGoods());
        goodsInfo.setCurrentQuantity(bean.getCurrentQuantity());
        goodsInfo.setSpecials(bean.getSpecials());
        goodsInfo.setIsEnableGoodsFlavor(bean.getIsEnableGoodsFlavor());
        goodsInfo.setSelectedStaff(bean.getSelectedStaff());
        if (bean.getGoodsType() == 3) {
            goodsInfo.setNumber(1);
            goodsInfo.setCurrentQuantity(1);
            goodsInfo.setTimeGoodsStartPrice(bean.getTimeGoodsStartPrice());
            goodsInfo.setPrice(bean.getTimeGoodsStartPrice());
            goodsInfo.setStartPrice(bean.getTimeGoodsStartPrice());
            goodsInfo.setOriginalMoney(bean.getTimeGoodsStartPrice());
            goodsInfo.setStartTime(bean.getStartTime());
            goodsInfo.setEndTime(bean.getEndTime());
            goodsInfo.setTotalMinutes(bean.getTotalMinutes());
        }
        return goodsInfo;
    }

}
