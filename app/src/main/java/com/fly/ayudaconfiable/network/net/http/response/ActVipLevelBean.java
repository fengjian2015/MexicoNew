package com.fly.ayudaconfiable.network.net.http.response;

import java.util.List;

public class ActVipLevelBean {

    /**
     * allData : [{"Id":"15777277242587165","LevelName":"默认等级","IsDefault":1,"SaleMoney":0,"StartValue":0},{"Id":"15846862395652096","LevelName":"金卡","IsDefault":0,"SaleMoney":0,"StartValue":100}]
     * havaData :
     */

    private List<LevelBean> allData;

    public List<LevelBean> getAllData() {
        return allData;
    }

    public static class LevelBean {
        /**
         * Id : 15777277242587165
         * LevelName : 默认等级
         * IsDefault : 1
         * SaleMoney : 0.0
         * StartValue : 0.0
         */
        private boolean isSelected;
        private int IsDefault;
        private double SaleMoney;
        private double StartValue;
        private String Id = "";
        private String LevelName = "";

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getLevelName() {
            return LevelName;
        }

        public void setLevelName(String LevelName) {
            this.LevelName = LevelName;
        }

        public int getIsDefault() {
            return IsDefault;
        }

        public void setIsDefault(int IsDefault) {
            this.IsDefault = IsDefault;
        }

        public double getSaleMoney() {
            return SaleMoney;
        }

        public void setSaleMoney(double SaleMoney) {
            this.SaleMoney = SaleMoney;
        }

        public double getStartValue() {
            return StartValue;
        }

        public void setStartValue(double StartValue) {
            this.StartValue = StartValue;
        }
    }
}
