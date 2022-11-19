package com.fly.ayudaconfiable.network.net.http.response;

import java.util.List;

public class ActShopBean {

    /**
     * allData : [{"Id":"15777277242587165","LevelName":"默认等级","IsDefault":1,"SaleMoney":0,"StartValue":0},{"Id":"15846862395652096","LevelName":"金卡","IsDefault":0,"SaleMoney":0,"StartValue":100}]
     * havaData :
     */

    private List<ShopBean> allData;

    public List<ShopBean> getAllData() {
        return allData;
    }

    public static class ShopBean {
        /**
         * Id : 15777277242587165
         * LevelName : 默认等级
         * IsDefault : 1
         * SaleMoney : 0.0
         * StartValue : 0.0
         */
        private boolean isSelected;
        private String Id = "";
        private String ShopName = "";

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }

        public String getId() {
            return Id;
        }

        public void setId(String id) {
            Id = id;
        }

        public String getShopName() {
            return ShopName;
        }

        public void setShopName(String shopName) {
            ShopName = shopName;
        }
    }
}
