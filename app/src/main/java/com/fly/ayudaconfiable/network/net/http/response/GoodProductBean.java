package com.fly.ayudaconfiable.network.net.http.response;

import java.util.List;

/**
 * nakesoft
 * Created by 孔明 on 2019年7月17日,0017.
 * 158045632@qq.com
 */
public class GoodProductBean {

    /**
     * total : 10
     * list : [{"StockNum":0,"Number":0,"PassDate":0,"IsCombo":0,"GoodsType":2,"Id":"2","GoodsCode":"1002","GoodsName":"服务22","Price":5,"Images":"/FileSys/GoodsIMG/198/20190710203744912.jpeg","IsPoint":1,"PointType":0,"MinDiscount":1,"IsDiscount":1,"MeasureUnit":"订单","Specials":0},{"StockNum":0,"Number":0,"PassDate":0,"IsCombo":0,"GoodsType":1,"Id":"14343187288668160","GoodsCode":"20190717092416","GoodsName":"JAIJAI","Price":1,"IsPoint":0,"PointType":1,"MinDiscount":1,"IsDiscount":0,"MeasureUnit":"1","Specials":1},{"StockNum":0,"Number":0,"PassDate":0,"IsCombo":0,"GoodsType":0,"Id":"14340798724470784","GoodsCode":"12","GoodsName":"test","Price":0,"Images":"","IsPoint":0,"PointType":0,"MinDiscount":0,"IsDiscount":0,"MeasureUnit":"","Specials":0},{"StockNum":0,"Number":0,"PassDate":0,"IsCombo":0,"GoodsType":2,"Id":"14336476312139776","GoodsCode":"20190712153702","GoodsName":"订单A","Price":0,"IsPoint":1,"PointType":0,"MinDiscount":0,"IsDiscount":1,"MeasureUnit":"123","Specials":0},{"StockNum":14,"Number":0,"PassDate":0,"IsCombo":0,"GoodsType":1,"Id":"14333905302304768","GoodsCode":"20190710200217","GoodsName":"日日日月娥也f","Price":0,"IsPoint":0,"PointType":0,"MinDiscount":0,"IsDiscount":0,"MeasureUnit":"方法","Specials":0},{"StockNum":23,"Number":0,"PassDate":0,"IsCombo":0,"GoodsType":1,"Id":"14333892534679552","GoodsCode":"20190710194918","GoodsName":"顶顶顶23","Price":0,"Images":"/FileSys/GoodsIMG/198/20190710202637754.png","IsPoint":0,"PointType":0,"MinDiscount":0,"IsDiscount":0,"Specials":0},{"StockNum":22,"Number":0,"PassDate":0,"IsCombo":0,"GoodsType":1,"Id":"14331884102121472","GoodsCode":"20190709094603","GoodsName":"产品3","Price":12345,"Images":"/FileSys/GoodsIMG/198/20190709094557180.png","IsPoint":1,"PointType":1,"MinDiscount":0.2,"IsDiscount":1,"Specials":0},{"StockNum":0,"Number":0,"PassDate":0,"IsCombo":0,"GoodsType":1,"Id":"14331833951991808","GoodsCode":"20190709085517","GoodsName":"产品4","Price":123,"IsPoint":0,"PointType":0,"MinDiscount":0,"IsDiscount":0,"Specials":0},{"StockNum":0,"Number":0,"PassDate":0,"IsCombo":0,"GoodsType":1,"Id":"14331139254990848","GoodsCode":"20190708210816","GoodsName":"产品22","Price":123,"IsPoint":1,"PointType":2,"MinDiscount":0.8,"IsDiscount":1,"Specials":0},{"StockNum":0,"Number":0,"PassDate":0,"IsCombo":0,"GoodsType":2,"Id":"1","GoodsCode":"1001","GoodsName":"服务1","Price":10,"Images":"","IsPoint":1,"PointType":0,"MinDiscount":1,"IsDiscount":1,"MeasureUnit":"-","Specials":0}]
     */

    private int total;
    private List<ShowGoodsBean> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ShowGoodsBean> getList() {
        return list;
    }

    public void setList(List<ShowGoodsBean> list) {
        this.list = list;
    }

}
