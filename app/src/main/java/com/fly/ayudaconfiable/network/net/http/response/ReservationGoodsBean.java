package com.fly.ayudaconfiable.network.net.http.response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * nakesoft
 * Created by 孔明 on 2019年7月17日,0017.
 * 158045632@qq.com
 */
public class ReservationGoodsBean {
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

    public static class ListBean implements Parcelable {
        private int Sort;
        private double TimeInterval;
        private double MinAppointmentDuration;
        private double MaxAppointmentDuration;
        private String RoomId;
        private String RoomName;
        private int BillMode;
        private String MeasureUnit;
        private int GoodsType;
        private int SellingPriceType;
        private String GoodsCode;
        private String Id;
        private String ShopID;
        private String ClassID;
        private String ClassName;
        private String GoodsID;
        private String GoodsName;
        private String GoodsImg;
        private String UsedShopID;
        private int ServiceMode;//项目服务方式 0到店服务 1上门服务 2全部
        private int ServiceTimes;
        private double Price;
        private double OldPrice;
        private int AvailableTimes;
        private String Content;
        private int State;
        private String IsEdit;
        public boolean isSelected;

        public int getSort() {
            return Sort;
        }

        public void setSort(int sort) {
            Sort = sort;
        }

        public double getTimeInterval() {
            return TimeInterval;
        }

        public void setTimeInterval(double timeInterval) {
            TimeInterval = timeInterval;
        }

        public double getMinAppointmentDuration() {
            return MinAppointmentDuration;
        }

        public void setMinAppointmentDuration(double minAppointmentDuration) {
            MinAppointmentDuration = minAppointmentDuration;
        }

        public double getMaxAppointmentDuration() {
            return MaxAppointmentDuration;
        }

        public void setMaxAppointmentDuration(double maxAppointmentDuration) {
            MaxAppointmentDuration = maxAppointmentDuration;
        }

        public String getRoomId() {
            return RoomId;
        }

        public void setRoomId(String roomId) {
            RoomId = roomId;
        }

        public String getRoomName() {
            return RoomName;
        }

        public void setRoomName(String roomName) {
            RoomName = roomName;
        }

        public int getBillMode() {
            return BillMode;
        }

        public void setBillMode(int billMode) {
            BillMode = billMode;
        }

        public String getMeasureUnit() {
            return MeasureUnit;
        }

        public void setMeasureUnit(String measureUnit) {
            MeasureUnit = measureUnit;
        }

        public int getGoodsType() {
            return GoodsType;
        }

        public void setGoodsType(int goodsType) {
            GoodsType = goodsType;
        }

        public int getSellingPriceType() {
            return SellingPriceType;
        }

        public void setSellingPriceType(int sellingPriceType) {
            SellingPriceType = sellingPriceType;
        }

        public String getGoodsCode() {
            return GoodsCode;
        }

        public void setGoodsCode(String goodsCode) {
            GoodsCode = goodsCode;
        }

        public String getId() {
            return Id;
        }

        public void setId(String id) {
            Id = id;
        }

        public String getShopID() {
            return ShopID;
        }

        public void setShopID(String shopID) {
            ShopID = shopID;
        }

        public String getClassID() {
            return ClassID;
        }

        public void setClassID(String classID) {
            ClassID = classID;
        }

        public String getClassName() {
            return ClassName;
        }

        public void setClassName(String className) {
            ClassName = className;
        }

        public String getGoodsID() {
            return GoodsID;
        }

        public void setGoodsID(String goodsID) {
            GoodsID = goodsID;
        }

        public String getGoodsName() {
            return GoodsName;
        }

        public void setGoodsName(String goodsName) {
            GoodsName = goodsName;
        }

        public String getGoodsImg() {
            return GoodsImg;
        }

        public void setGoodsImg(String goodsImg) {
            GoodsImg = goodsImg;
        }

        public String getUsedShopID() {
            return UsedShopID;
        }

        public void setUsedShopID(String usedShopID) {
            UsedShopID = usedShopID;
        }

        public int getServiceMode() {
            return ServiceMode;
        }

        public void setServiceMode(int serviceMode) {
            ServiceMode = serviceMode;
        }

        public int getServiceTimes() {
            return ServiceTimes;
        }

        public void setServiceTimes(int serviceTimes) {
            ServiceTimes = serviceTimes;
        }

        public double getPrice() {
            return Price;
        }

        public void setPrice(double price) {
            Price = price;
        }

        public double getOldPrice() {
            return OldPrice;
        }

        public void setOldPrice(double oldPrice) {
            OldPrice = oldPrice;
        }

        public int getAvailableTimes() {
            return AvailableTimes;
        }

        public void setAvailableTimes(int availableTimes) {
            AvailableTimes = availableTimes;
        }

        public String getContent() {
            return Content;
        }

        public void setContent(String content) {
            Content = content;
        }

        public int getState() {
            return State;
        }

        public void setState(int state) {
            State = state;
        }

        public String getIsEdit() {
            return IsEdit;
        }

        public void setIsEdit(String isEdit) {
            IsEdit = isEdit;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.Sort);
            dest.writeDouble(this.TimeInterval);
            dest.writeDouble(this.MinAppointmentDuration);
            dest.writeDouble(this.MaxAppointmentDuration);
            dest.writeString(this.RoomId);
            dest.writeString(this.RoomName);
            dest.writeInt(this.BillMode);
            dest.writeString(this.MeasureUnit);
            dest.writeInt(this.GoodsType);
            dest.writeInt(this.SellingPriceType);
            dest.writeString(this.GoodsCode);
            dest.writeString(this.Id);
            dest.writeString(this.ShopID);
            dest.writeString(this.ClassID);
            dest.writeString(this.ClassName);
            dest.writeString(this.GoodsID);
            dest.writeString(this.GoodsName);
            dest.writeString(this.GoodsImg);
            dest.writeString(this.UsedShopID);
            dest.writeInt(this.ServiceMode);
            dest.writeInt(this.ServiceTimes);
            dest.writeDouble(this.Price);
            dest.writeDouble(this.OldPrice);
            dest.writeInt(this.AvailableTimes);
            dest.writeString(this.Content);
            dest.writeInt(this.State);
            dest.writeString(this.IsEdit);
            dest.writeByte(this.isSelected ? (byte) 1 : (byte) 0);
        }

        public void readFromParcel(Parcel source) {
            this.Sort = source.readInt();
            this.TimeInterval = source.readDouble();
            this.MinAppointmentDuration = source.readDouble();
            this.MaxAppointmentDuration = source.readDouble();
            this.RoomId = source.readString();
            this.RoomName = source.readString();
            this.BillMode = source.readInt();
            this.MeasureUnit = source.readString();
            this.GoodsType = source.readInt();
            this.SellingPriceType = source.readInt();
            this.GoodsCode = source.readString();
            this.Id = source.readString();
            this.ShopID = source.readString();
            this.ClassID = source.readString();
            this.ClassName = source.readString();
            this.GoodsID = source.readString();
            this.GoodsName = source.readString();
            this.GoodsImg = source.readString();
            this.UsedShopID = source.readString();
            this.ServiceMode = source.readInt();
            this.ServiceTimes = source.readInt();
            this.Price = source.readDouble();
            this.OldPrice = source.readDouble();
            this.AvailableTimes = source.readInt();
            this.Content = source.readString();
            this.State = source.readInt();
            this.IsEdit = source.readString();
            this.isSelected = source.readByte() != 0;
        }

        public ListBean() {
        }

        protected ListBean(Parcel in) {
            this.Sort = in.readInt();
            this.TimeInterval = in.readDouble();
            this.MinAppointmentDuration = in.readDouble();
            this.MaxAppointmentDuration = in.readDouble();
            this.RoomId = in.readString();
            this.RoomName = in.readString();
            this.BillMode = in.readInt();
            this.MeasureUnit = in.readString();
            this.GoodsType = in.readInt();
            this.SellingPriceType = in.readInt();
            this.GoodsCode = in.readString();
            this.Id = in.readString();
            this.ShopID = in.readString();
            this.ClassID = in.readString();
            this.ClassName = in.readString();
            this.GoodsID = in.readString();
            this.GoodsName = in.readString();
            this.GoodsImg = in.readString();
            this.UsedShopID = in.readString();
            this.ServiceMode = in.readInt();
            this.ServiceTimes = in.readInt();
            this.Price = in.readDouble();
            this.OldPrice = in.readDouble();
            this.AvailableTimes = in.readInt();
            this.Content = in.readString();
            this.State = in.readInt();
            this.IsEdit = in.readString();
            this.isSelected = in.readByte() != 0;
        }

        public static final Creator<ListBean> CREATOR = new Creator<ListBean>() {
            @Override
            public ListBean createFromParcel(Parcel source) {
                return new ListBean(source);
            }

            @Override
            public ListBean[] newArray(int size) {
                return new ListBean[size];
            }
        };
    }
}
