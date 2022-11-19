package com.fly.ayudaconfiable.network.net.http.response;

import java.util.List;

/**
 * nakesoft
 * Created by 孔明 on 2019年7月17日,0017.
 * 158045632@qq.com
 */
public class MemLevelManageBean {

    /**
     * total : 3
     * list : [{"Id":"14307853800093696","LevelName":"vip九折卡","StartValue":100,"PointPercent":0.2,"PointInfo":"10|2","DiscountPercent":0.9,"StartCount":[{"Id":"1","GoodsCode":"1001","GoodsName":"服务1","Qty":4},{"Id":"14333887240370176","GoodsCode":"20190710194348","GoodsName":"顶顶顶顶","Qty":5},{"Id":"14333895325562880","GoodsCode":"20190710195212","GoodsName":"顶顶顶","Qty":6}],"TimeCardQty":99,"Remark":"会员等级","SaleMoney":10,"ClassDiscountRules":[{"GoodsClassId":"14327973508200448","GoodsClassName":"默认分类234","Discount":0.06}],"FixedAmount":100,"IsDefault":0},{"Id":"14307947124357120","LevelName":"vip八折卡","StartValue":100,"PointPercent":0.1,"PointInfo":"10|1","DiscountPercent":0.8,"StartCount":[{"Id":"14333890641000448","GoodsCode":"20190710194729","GoodsName":"烦烦烦","Qty":4},{"Id":"14333895325562880","GoodsCode":"20190710195212","GoodsName":"顶顶顶","Qty":1}],"TimeCardQty":99999,"Remark":"八张","SaleMoney":100,"ClassDiscountRules":[{"GoodsClassId":"14306356306343936","GoodsClassName":"分类3","Discount":0.2},{"GoodsClassId":"14327973508200448","GoodsClassName":"默认分类234","Discount":1}],"FixedAmount":100,"IsDefault":1},{"Id":"14335254419929088","LevelName":"七折","StartValue":199,"PointPercent":0,"PointInfo":"0|0","DiscountPercent":1,"StartCount":[{"Id":"14331903895779328","GoodsCode":"20190709100622","GoodsName":"产品6","Qty":3},{"Id":"14333890641000448","GoodsCode":"20190710194729","GoodsName":"烦烦烦","Qty":4}],"TimeCardQty":0,"SaleMoney":188,"FixedAmount":0,"IsDefault":0}]
     */

    private int total;
    private List<ListMemLeveBean> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ListMemLeveBean> getList() {
        return list;
    }

    public void setList(List<ListMemLeveBean> list) {
        this.list = list;
    }

}
