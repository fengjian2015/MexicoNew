package com.fly.ayudaconfiable.network.net.http.response;

import java.io.Serializable;
import java.util.List;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月7日,0007.
 * 158045632@qq.com
 */
public class RestingOrderDetailBean implements Serializable {

    /**
     * Details : [{"Id":"15453133015398400","IsModify":0,"UnitPrice":10,"IsPoint":1,"PointPercent":0,"MinDiscount":0,"IsDiscount":1,"Specials":8,"IsWeighable":0,"MeasureUnit":"份","Images":"/FileSys/GoodsIMG/150081/20210814083146367.jpeg","GoodsClass":"15410647729518592","ParentGoodsClassID":"15410647168628736","StockNum":26,"HasNormalGoods":0,"SpecsType":0,"SpecsName":"","StartTime":0,"EndTime":0,"TotalMinutes":0,"Staff":"null","IsEnableGoodsFlavor":1,"ComList":[],"Point":0,"IsLimit":1,"BatchCode":"","GoodsID":"15410654009325568","GoodsType":1,"GoodsCode":"20210809112152","GoodsName":"杜瑞点餐测试","DiscountPrice":13,"Number":1,"TotalMoney":13,"SpecsId":"","GoodsFlavorList":[]}]
     * HandCode : ttt
     * BillCode : XF15453133015382016
     * OrderType : 2
     * MemID : 150081
     * TotalMoney : 13.0
     * DiscountMoney : 13.0
     * TotalPoint : 0.0
     * Remark :
     * CreateTime : 0
     * OpenType : 0
     */

    private int OrderType;
    private long CreateTime;
    private int OpenType;
    private double TotalMoney;
    private double DiscountMoney;
    private double TotalPoint;
    private String HandCode;
    private String BillCode;
    private String MemID;
    private String Remark;
    private List<GoodDetailBean> Details;
    private MemCardBean MemberInfo;

    public String getHandCode() {
        return HandCode;
    }

    public void setHandCode(String HandCode) {
        this.HandCode = HandCode;
    }

    public String getBillCode() {
        return BillCode;
    }

    public void setBillCode(String BillCode) {
        this.BillCode = BillCode;
    }

    public int getOrderType() {
        return OrderType;
    }

    public void setOrderType(int OrderType) {
        this.OrderType = OrderType;
    }

    public String getMemID() {
        return MemID;
    }

    public void setMemID(String MemID) {
        this.MemID = MemID;
    }

    public double getTotalMoney() {
        return TotalMoney;
    }

    public void setTotalMoney(double TotalMoney) {
        this.TotalMoney = TotalMoney;
    }

    public double getDiscountMoney() {
        return DiscountMoney;
    }

    public void setDiscountMoney(double DiscountMoney) {
        this.DiscountMoney = DiscountMoney;
    }

    public double getTotalPoint() {
        return TotalPoint;
    }

    public void setTotalPoint(double TotalPoint) {
        this.TotalPoint = TotalPoint;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String Remark) {
        this.Remark = Remark;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long CreateTime) {
        this.CreateTime = CreateTime;
    }

    public int getOpenType() {
        return OpenType;
    }

    public void setOpenType(int OpenType) {
        this.OpenType = OpenType;
    }

    public List<GoodDetailBean> getDetails() {
        return Details;
    }

    public void setDetails(List<GoodDetailBean> details) {
        Details = details;
    }

    public MemCardBean getMemberInfo() {
        return MemberInfo;
    }

    public void setMemberInfo(MemCardBean memberInfo) {
        MemberInfo = memberInfo;
    }
}
