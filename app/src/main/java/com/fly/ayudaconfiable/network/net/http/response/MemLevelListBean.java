package com.fly.ayudaconfiable.network.net.http.response;

import java.util.List;

/**
 * nakesoft
 * Created by 孔明 on 2019年7月16日,0016.
 * 158045632@qq.com
 */
public class MemLevelListBean {

    /**
     * status : 1
     * data : {"total":3,"list":[{"Id":"14307853800093696","LevelName":"vip九折卡","StartValue":100,"PointPercent":0.2,"PointInfo":"10|2","DiscountPercent":0.9,"StartCount":"[{\"Id\":\"1\",\"GoodsCode\":\"1001\",\"GoodsName\":\"服务1\",\"Qty\":4},{\"Id\":\"14333887240370176\",\"GoodsCode\":\"20190710194348\",\"GoodsName\":\"顶顶顶顶\",\"Qty\":5},{\"Id\":\"14333895325562880\",\"GoodsCode\":\"20190710195212\",\"GoodsName\":\"顶顶顶\",\"Qty\":6}]","TimeCardQty":99,"Remark":"会员等级","SaleMoney":10,"ClassDiscountRules":"[{\"GoodsClassId\":\"14327973508200448\",\"GoodsClassName\":\"默认分类234\",\"Discount\":0.06}]","FixedAmount":100,"IsDefault":0},{"Id":"14307947124357120","LevelName":"vip八折卡","StartValue":100,"PointPercent":0.1,"PointInfo":"10|1","DiscountPercent":0.8,"StartCount":"[{\"Id\":\"14333890641000448\",\"GoodsCode\":\"20190710194729\",\"GoodsName\":\"烦烦烦\",\"Qty\":4},{\"Id\":\"14333895325562880\",\"GoodsCode\":\"20190710195212\",\"GoodsName\":\"顶顶顶\",\"Qty\":1}]","TimeCardQty":99999,"Remark":"八张","SaleMoney":100,"ClassDiscountRules":"[{\"GoodsClassId\":\"14306356306343936\",\"GoodsClassName\":\"分类3\",\"Discount\":0.2},{\"GoodsClassId\":\"14327973508200448\",\"GoodsClassName\":\"默认分类234\",\"Discount\":1}]","FixedAmount":100,"IsDefault":1},{"Id":"14335254419929088","LevelName":"七折","StartValue":199,"PointPercent":0,"PointInfo":"0|0","DiscountPercent":1,"StartCount":"[{\"Id\":\"14331903895779328\",\"GoodsCode\":\"20190709100622\",\"GoodsName\":\"产品6\",\"Qty\":3},{\"Id\":\"14333890641000448\",\"GoodsCode\":\"20190710194729\",\"GoodsName\":\"烦烦烦\",\"Qty\":4}]","TimeCardQty":0,"SaleMoney":188,"ClassDiscountRules":"[{\"GoodsClassId\":\"14327973508200448\",\"GoodsClassName\":\"默认分类234\",\"Discount\":0.8}]","FixedAmount":0,"IsDefault":0}]}
     */

    private int status;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * total : 3
         * list : [{"Id":"14307853800093696","LevelName":"vip九折卡","StartValue":100,"PointPercent":0.2,"PointInfo":"10|2","DiscountPercent":0.9,"StartCount":"[{\"Id\":\"1\",\"GoodsCode\":\"1001\",\"GoodsName\":\"服务1\",\"Qty\":4},{\"Id\":\"14333887240370176\",\"GoodsCode\":\"20190710194348\",\"GoodsName\":\"顶顶顶顶\",\"Qty\":5},{\"Id\":\"14333895325562880\",\"GoodsCode\":\"20190710195212\",\"GoodsName\":\"顶顶顶\",\"Qty\":6}]","TimeCardQty":99,"Remark":"会员等级","SaleMoney":10,"ClassDiscountRules":"[{\"GoodsClassId\":\"14327973508200448\",\"GoodsClassName\":\"默认分类234\",\"Discount\":0.06}]","FixedAmount":100,"IsDefault":0},{"Id":"14307947124357120","LevelName":"vip八折卡","StartValue":100,"PointPercent":0.1,"PointInfo":"10|1","DiscountPercent":0.8,"StartCount":"[{\"Id\":\"14333890641000448\",\"GoodsCode\":\"20190710194729\",\"GoodsName\":\"烦烦烦\",\"Qty\":4},{\"Id\":\"14333895325562880\",\"GoodsCode\":\"20190710195212\",\"GoodsName\":\"顶顶顶\",\"Qty\":1}]","TimeCardQty":99999,"Remark":"八张","SaleMoney":100,"ClassDiscountRules":"[{\"GoodsClassId\":\"14306356306343936\",\"GoodsClassName\":\"分类3\",\"Discount\":0.2},{\"GoodsClassId\":\"14327973508200448\",\"GoodsClassName\":\"默认分类234\",\"Discount\":1}]","FixedAmount":100,"IsDefault":1},{"Id":"14335254419929088","LevelName":"七折","StartValue":199,"PointPercent":0,"PointInfo":"0|0","DiscountPercent":1,"StartCount":"[{\"Id\":\"14331903895779328\",\"GoodsCode\":\"20190709100622\",\"GoodsName\":\"产品6\",\"Qty\":3},{\"Id\":\"14333890641000448\",\"GoodsCode\":\"20190710194729\",\"GoodsName\":\"烦烦烦\",\"Qty\":4}]","TimeCardQty":0,"SaleMoney":188,"ClassDiscountRules":"[{\"GoodsClassId\":\"14327973508200448\",\"GoodsClassName\":\"默认分类234\",\"Discount\":0.8}]","FixedAmount":0,"IsDefault":0}]
         */

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

        public static class ListBean {
            /**
             * Id : 14307853800093696
             * LevelName : vip九折卡
             * StartValue : 100
             * PointPercent : 0.2
             * PointInfo : 10|2
             * DiscountPercent : 0.9
             * StartCount : [{"Id":"1","GoodsCode":"1001","GoodsName":"服务1","Qty":4},{"Id":"14333887240370176","GoodsCode":"20190710194348","GoodsName":"顶顶顶顶","Qty":5},{"Id":"14333895325562880","GoodsCode":"20190710195212","GoodsName":"顶顶顶","Qty":6}]
             * TimeCardQty : 99
             * Remark : 会员等级
             * SaleMoney : 10
             * ClassDiscountRules : [{"GoodsClassId":"14327973508200448","GoodsClassName":"默认分类234","Discount":0.06}]
             * FixedAmount : 100
             * IsDefault : 0
             */

            private String Id;
            private String LevelName;
            private int StartValue;
            private double PointPercent;
            private String PointInfo;
            private double DiscountPercent;
            private String StartCount;
            private int TimeCardQty;
            private String Remark;
            private int SaleMoney;
            private String ClassDiscountRules;
            private int FixedAmount;
            private int IsDefault;

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

            public int getStartValue() {
                return StartValue;
            }

            public void setStartValue(int StartValue) {
                this.StartValue = StartValue;
            }

            public double getPointPercent() {
                return PointPercent;
            }

            public void setPointPercent(double PointPercent) {
                this.PointPercent = PointPercent;
            }

            public String getPointInfo() {
                return PointInfo;
            }

            public void setPointInfo(String PointInfo) {
                this.PointInfo = PointInfo;
            }

            public double getDiscountPercent() {
                return DiscountPercent;
            }

            public void setDiscountPercent(double DiscountPercent) {
                this.DiscountPercent = DiscountPercent;
            }

            public String getStartCount() {
                return StartCount;
            }

            public void setStartCount(String StartCount) {
                this.StartCount = StartCount;
            }

            public int getTimeCardQty() {
                return TimeCardQty;
            }

            public void setTimeCardQty(int TimeCardQty) {
                this.TimeCardQty = TimeCardQty;
            }

            public String getRemark() {
                return Remark;
            }

            public void setRemark(String Remark) {
                this.Remark = Remark;
            }

            public int getSaleMoney() {
                return SaleMoney;
            }

            public void setSaleMoney(int SaleMoney) {
                this.SaleMoney = SaleMoney;
            }

            public String getClassDiscountRules() {
                return ClassDiscountRules;
            }

            public void setClassDiscountRules(String ClassDiscountRules) {
                this.ClassDiscountRules = ClassDiscountRules;
            }

            public int getFixedAmount() {
                return FixedAmount;
            }

            public void setFixedAmount(int FixedAmount) {
                this.FixedAmount = FixedAmount;
            }

            public int getIsDefault() {
                return IsDefault;
            }

            public void setIsDefault(int IsDefault) {
                this.IsDefault = IsDefault;
            }
        }
    }
}
