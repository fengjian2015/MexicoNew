package com.fly.ayudaconfiable.network.net.http.response;

import java.util.List;

/**
 * nakesoft
 * Created by 孔明 on 2019年7月17日,0017.
 * 158045632@qq.com
 */
public class GoodsListBean {

    /**
     * total : 29
     * list : {"TotalPrice":27173,"TotalNum":85,"Goods":[{"Id":"14343187288668160","GoodsCode":"20190717092416","GoodsName":"JAIJAI","GoodsClass":"14327973642582016","GoodsType":1,"Price":1,"StockNum":0},{"Id":"14340798724470784","GoodsCode":"12","GoodsName":"test","GoodsClass":"","GoodsType":0,"Price":0,"Images":"","StockNum":0},{"Id":"14331139254990848","GoodsCode":"20190708210816","GoodsName":"产品22","GoodsClass":"14327973508200448","GoodsType":1,"Price":123,"StockNum":0},{"Id":"14331884102121472","GoodsCode":"20190709094603","GoodsName":"产品3","GoodsClass":"14327973508200448","GoodsType":1,"Price":12345,"Images":"/FileSys/GoodsIMG/198/20190709094557180.png","StockNum":1},{"Id":"14331884102121472","GoodsCode":"20190709094603","GoodsName":"产品3","GoodsClass":"14327973508200448","GoodsType":1,"Price":12345,"Images":"/FileSys/GoodsIMG/198/20190709094557180.png","StockNum":21},{"Id":"14331833951991808","GoodsCode":"20190709085517","GoodsName":"产品4","GoodsClass":"14327973642582016","GoodsType":1,"Price":123,"StockNum":0},{"Id":"14331891721222144","GoodsCode":"20190709095359","GoodsName":"产品5","GoodsClass":"14327973508200448","GoodsType":1,"Price":1,"Images":"0","StockNum":3},{"Id":"14331891721222144","GoodsCode":"20190709095359","GoodsName":"产品5","GoodsClass":"14327973508200448","GoodsType":1,"Price":1,"Images":"0","StockNum":1},{"Id":"14331903895779328","GoodsCode":"20190709100622","GoodsName":"产品6","GoodsClass":"14327973508200448","GoodsType":2,"Price":123,"Images":"/FileSys/GoodsIMG/198/20190709100620033.png","StockNum":0},{"Id":"14333900549486592","GoodsCode":"20190710195733","GoodsName":"察觉到基督教","GoodsClass":"14306356306343936","GoodsType":2,"Price":0,"Images":"/FileSys/GoodsIMG/198/20190710203355655.jpeg","StockNum":0},{"Id":"14333898201446400","GoodsCode":"20190710195508","GoodsName":"撒旦撒","GoodsClass":"14327973508200448","GoodsType":2,"Price":0,"StockNum":0},{"Id":"14333905302304768","GoodsCode":"20190710200217","GoodsName":"日日日月娥也f","GoodsClass":"14327973642582016","GoodsType":1,"Price":0,"StockNum":13},{"Id":"14333905302304768","GoodsCode":"20190710200217","GoodsName":"日日日月娥也f","GoodsClass":"14327973642582016","GoodsType":1,"Price":0,"StockNum":1},{"Id":"1","GoodsCode":"1001","GoodsName":"服务1","GoodsClass":"14272953160251392","GoodsType":2,"Price":10,"Images":"","StockNum":0},{"Id":"2","GoodsCode":"1002","GoodsName":"服务22","GoodsClass":"14272953160251392","GoodsType":2,"Price":5,"Images":"/FileSys/GoodsIMG/198/20190710203744912.jpeg","StockNum":0},{"Id":"14333890641000448","GoodsCode":"20190710194729","GoodsName":"烦烦烦","GoodsClass":"14327973508200448","GoodsType":2,"Price":0,"StockNum":0},{"Id":"14333884072458240","GoodsCode":"20190710194034","GoodsName":"烦烦烦","GoodsClass":"14327973508200448","GoodsType":1,"Price":2,"StockNum":1},{"Id":"14333884072458240","GoodsCode":"20190710194034","GoodsName":"烦烦烦","GoodsClass":"14327973508200448","GoodsType":1,"Price":2,"StockNum":9},{"Id":"14333901676607488","GoodsCode":"20190710195836","GoodsName":"订单","GoodsClass":"14327973642582016","GoodsType":2,"Price":0,"StockNum":0},{"Id":"14333903965878272","GoodsCode":"20190710200101","GoodsName":"订单","GoodsClass":"14327973642582016","GoodsType":1,"Price":0,"StockNum":1}]}
     */

    private int total;
    private ListBean list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ListBean getList() {
        return list;
    }

    public void setList(ListBean list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * TotalPrice : 27173.0
         * TotalNum : 85.0
         * Goods : [{"Id":"14343187288668160","GoodsCode":"20190717092416","GoodsName":"JAIJAI","GoodsClass":"14327973642582016","GoodsType":1,"Price":1,"StockNum":0},{"Id":"14340798724470784","GoodsCode":"12","GoodsName":"test","GoodsClass":"","GoodsType":0,"Price":0,"Images":"","StockNum":0},{"Id":"14331139254990848","GoodsCode":"20190708210816","GoodsName":"产品22","GoodsClass":"14327973508200448","GoodsType":1,"Price":123,"StockNum":0},{"Id":"14331884102121472","GoodsCode":"20190709094603","GoodsName":"产品3","GoodsClass":"14327973508200448","GoodsType":1,"Price":12345,"Images":"/FileSys/GoodsIMG/198/20190709094557180.png","StockNum":1},{"Id":"14331884102121472","GoodsCode":"20190709094603","GoodsName":"产品3","GoodsClass":"14327973508200448","GoodsType":1,"Price":12345,"Images":"/FileSys/GoodsIMG/198/20190709094557180.png","StockNum":21},{"Id":"14331833951991808","GoodsCode":"20190709085517","GoodsName":"产品4","GoodsClass":"14327973642582016","GoodsType":1,"Price":123,"StockNum":0},{"Id":"14331891721222144","GoodsCode":"20190709095359","GoodsName":"产品5","GoodsClass":"14327973508200448","GoodsType":1,"Price":1,"Images":"0","StockNum":3},{"Id":"14331891721222144","GoodsCode":"20190709095359","GoodsName":"产品5","GoodsClass":"14327973508200448","GoodsType":1,"Price":1,"Images":"0","StockNum":1},{"Id":"14331903895779328","GoodsCode":"20190709100622","GoodsName":"产品6","GoodsClass":"14327973508200448","GoodsType":2,"Price":123,"Images":"/FileSys/GoodsIMG/198/20190709100620033.png","StockNum":0},{"Id":"14333900549486592","GoodsCode":"20190710195733","GoodsName":"察觉到基督教","GoodsClass":"14306356306343936","GoodsType":2,"Price":0,"Images":"/FileSys/GoodsIMG/198/20190710203355655.jpeg","StockNum":0},{"Id":"14333898201446400","GoodsCode":"20190710195508","GoodsName":"撒旦撒","GoodsClass":"14327973508200448","GoodsType":2,"Price":0,"StockNum":0},{"Id":"14333905302304768","GoodsCode":"20190710200217","GoodsName":"日日日月娥也f","GoodsClass":"14327973642582016","GoodsType":1,"Price":0,"StockNum":13},{"Id":"14333905302304768","GoodsCode":"20190710200217","GoodsName":"日日日月娥也f","GoodsClass":"14327973642582016","GoodsType":1,"Price":0,"StockNum":1},{"Id":"1","GoodsCode":"1001","GoodsName":"服务1","GoodsClass":"14272953160251392","GoodsType":2,"Price":10,"Images":"","StockNum":0},{"Id":"2","GoodsCode":"1002","GoodsName":"服务22","GoodsClass":"14272953160251392","GoodsType":2,"Price":5,"Images":"/FileSys/GoodsIMG/198/20190710203744912.jpeg","StockNum":0},{"Id":"14333890641000448","GoodsCode":"20190710194729","GoodsName":"烦烦烦","GoodsClass":"14327973508200448","GoodsType":2,"Price":0,"StockNum":0},{"Id":"14333884072458240","GoodsCode":"20190710194034","GoodsName":"烦烦烦","GoodsClass":"14327973508200448","GoodsType":1,"Price":2,"StockNum":1},{"Id":"14333884072458240","GoodsCode":"20190710194034","GoodsName":"烦烦烦","GoodsClass":"14327973508200448","GoodsType":1,"Price":2,"StockNum":9},{"Id":"14333901676607488","GoodsCode":"20190710195836","GoodsName":"订单","GoodsClass":"14327973642582016","GoodsType":2,"Price":0,"StockNum":0},{"Id":"14333903965878272","GoodsCode":"20190710200101","GoodsName":"订单","GoodsClass":"14327973642582016","GoodsType":1,"Price":0,"StockNum":1}]
         */

        private double TotalPrice;
        private double TotalNum;
        private List<ListGoodsBean> Goods;

        public double getTotalPrice() {
            return TotalPrice;
        }

        public void setTotalPrice(double TotalPrice) {
            this.TotalPrice = TotalPrice;
        }

        public double getTotalNum() {
            return TotalNum;
        }

        public void setTotalNum(double TotalNum) {
            this.TotalNum = TotalNum;
        }

        public List<ListGoodsBean> getGoods() {
            return Goods;
        }

        public void setGoods(List<ListGoodsBean> Goods) {
            this.Goods = Goods;
        }

    }
}
