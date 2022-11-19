package com.fly.ayudaconfiable.network.net.http.response;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月6日,0006.
 * 158045632@qq.com
 */
public class ReservationStaffBean {
    private String ReservationName;
    private int ServiceTimes;
    private double Price;
    private String MeasureUnit;
    private String Images;
    private String LinkMobile;
    private List<StaffInfoBean> ReservationTechnicianList;

    public String getReservationName() {
        return ReservationName;
    }

    public void setReservationName(String ReservationName) {
        this.ReservationName = ReservationName;
    }

    public int getServiceTimes() {
        return ServiceTimes;
    }

    public void setServiceTimes(int ServiceTimes) {
        this.ServiceTimes = ServiceTimes;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public String getMeasureUnit() {
        return MeasureUnit;
    }

    public void setMeasureUnit(String MeasureUnit) {
        this.MeasureUnit = MeasureUnit;
    }

    public String getImages() {
        return Images;
    }

    public void setImages(String Images) {
        this.Images = Images;
    }

    public String getLinkMobile() {
        return LinkMobile;
    }

    public void setLinkMobile(String LinkMobile) {
        this.LinkMobile = LinkMobile;
    }

    public List<StaffInfoBean> getReservationTechnicianList() {
        return ReservationTechnicianList;
    }

    public void setReservationTechnicianList(List<StaffInfoBean> ReservationTechnicianList) {
        this.ReservationTechnicianList = ReservationTechnicianList;
    }

    public static class StaffInfoBean implements Parcelable {
        private String tecId;
        private String StaffID;
        private String StaffName;
        private String NickName;
        private String TechnicianTitle;
        private String Summary;
        private String Content;
        private String ClassID;
        private String ClassName;
        public boolean isSelected;

        public String getTecId() {
            return tecId;
        }

        public void setTecId(String tecId) {
            this.tecId = tecId;
        }

        public String getStaffID() {
            return StaffID;
        }

        public void setStaffID(String StaffID) {
            this.StaffID = StaffID;
        }

        public String getStaffName() {
            return StaffName;
        }

        public void setStaffName(String staffName) {
            StaffName = staffName;
        }

        public String getNickName() {
            return NickName;
        }

        public void setNickName(String NickName) {
            this.NickName = NickName;
        }

        public String getTechnicianTitle() {
            return TechnicianTitle;
        }

        public void setTechnicianTitle(String TechnicianTitle) {
            this.TechnicianTitle = TechnicianTitle;
        }

        public String getSummary() {
            return Summary;
        }

        public void setSummary(String Summary) {
            this.Summary = Summary;
        }

        public String getContent() {
            return Content;
        }

        public void setContent(String Content) {
            this.Content = Content;
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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.tecId);
            dest.writeString(this.StaffID);
            dest.writeString(this.StaffName);
            dest.writeString(this.NickName);
            dest.writeString(this.TechnicianTitle);
            dest.writeString(this.Summary);
            dest.writeString(this.Content);
            dest.writeString(this.ClassID);
            dest.writeString(this.ClassName);
            dest.writeByte(this.isSelected ? (byte) 1 : (byte) 0);
        }

        public void readFromParcel(Parcel source) {
            this.tecId = source.readString();
            this.StaffID = source.readString();
            this.StaffName = source.readString();
            this.NickName = source.readString();
            this.TechnicianTitle = source.readString();
            this.Summary = source.readString();
            this.Content = source.readString();
            this.ClassID = source.readString();
            this.ClassName = source.readString();
            this.isSelected = source.readByte() != 0;
        }

        public StaffInfoBean() {
        }

        protected StaffInfoBean(Parcel in) {
            this.tecId = in.readString();
            this.StaffID = in.readString();
            this.StaffName = in.readString();
            this.NickName = in.readString();
            this.TechnicianTitle = in.readString();
            this.Summary = in.readString();
            this.Content = in.readString();
            this.ClassID = in.readString();
            this.ClassName = in.readString();
            this.isSelected = in.readByte() != 0;
        }

        public static final Creator<StaffInfoBean> CREATOR = new Creator<StaffInfoBean>() {
            @Override
            public StaffInfoBean createFromParcel(Parcel source) {
                return new StaffInfoBean(source);
            }

            @Override
            public StaffInfoBean[] newArray(int size) {
                return new StaffInfoBean[size];
            }
        };
    }
}
