package com.fly.ayudaconfiable.network.net.http.request;

import java.io.Serializable;
import java.util.List;

public class ApplyTimeSlotBean implements Serializable {

    private List<TimeSlotBean> TimeSlot;

    public List<TimeSlotBean> getTimeSlot() {
        return TimeSlot;
    }

    public void setTimeSlot(List<TimeSlotBean> TimeSlot) {
        this.TimeSlot = TimeSlot;
    }

    public static class TimeSlotBean implements Serializable {
        /**
         * Type : 0
         * DateStr : 1,2,4,6
         * StartTime : 00:00
         * EndTime : 23:59
         */

        private int Type;
        private String DateStr;
        private String StartTime;
        private String EndTime;

        public int getType() {
            return Type;
        }

        public void setType(int Type) {
            this.Type = Type;
        }

        public String getDateStr() {
            return DateStr;
        }

        public void setDateStr(String DateStr) {
            this.DateStr = DateStr;
        }

        public String getStartTime() {
            return StartTime;
        }

        public void setStartTime(String StartTime) {
            this.StartTime = StartTime;
        }

        public String getEndTime() {
            return EndTime;
        }

        public void setEndTime(String EndTime) {
            this.EndTime = EndTime;
        }
    }
}
