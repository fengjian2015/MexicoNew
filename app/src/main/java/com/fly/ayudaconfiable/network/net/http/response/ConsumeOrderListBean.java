package com.fly.ayudaconfiable.network.net.http.response;

import java.util.List;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月3日,0003.
 * 158045632@qq.com
 */
public class ConsumeOrderListBean {
    /**
     * total : 7
     * list : [{"TypeName":"快速消费","UserName":"哈哈","ShopName":"总店","ActualPayAmount":10,"Id":"14367503261497344","CardID":"0000","CardName":"散客","Mobile":"","CreateTime":20190803134007,"BillCode":"XF201908031340075386","OrderType":1,"MemID":"198","TotalMoney":10,"DiscountMoney":10,"TotalPoint":0,"Remark":""},{"TypeName":"快速消费","UserName":"哈哈","ShopName":"总店","ActualPayAmount":100,"Id":"14367388909041664","CardID":"0000","CardName":"散客","Mobile":"","CreateTime":20190803114347,"BillCode":"XF201908031143480034","OrderType":1,"MemID":"198","TotalMoney":100,"DiscountMoney":100,"TotalPoint":0,"Remark":""},{"TypeName":"快速消费","UserName":"哈哈","ShopName":"总店","ActualPayAmount":100,"Id":"14367361375565824","CardID":"0000","CardName":"散客","Mobile":"","CreateTime":20190803111547,"BillCode":"XF201908031115474935","OrderType":1,"MemID":"198","TotalMoney":100,"DiscountMoney":100,"TotalPoint":0,"Remark":""},{"TypeName":"快速消费","UserName":"哈哈","ShopName":"总店","ActualPayAmount":100,"Id":"14367360104544256","CardID":"0000","CardName":"散客","Mobile":"","CreateTime":20190803111429,"BillCode":"XF201908031114299158","OrderType":1,"MemID":"198","TotalMoney":100,"DiscountMoney":100,"TotalPoint":0,"Remark":""},{"TypeName":"快速消费","UserName":"哈哈","ShopName":"总店","ActualPayAmount":100,"Id":"14367314395215872","CardID":"0000","CardName":"散客","Mobile":"","CreateTime":20190803102800,"BillCode":"XF201908031028000403","OrderType":1,"MemID":"198","TotalMoney":100,"DiscountMoney":100,"TotalPoint":0,"Remark":""},{"TypeName":"快速消费","UserName":"哈哈","ShopName":"总店","ActualPayAmount":10,"Id":"14367311847274496","CardID":"0000","CardName":"散客","Mobile":"","CreateTime":20190803102524,"BillCode":"XF201908031025245418","OrderType":1,"MemID":"198","TotalMoney":10,"DiscountMoney":10,"TotalPoint":0,"Remark":""},{"TypeName":"快速消费","UserName":"哈哈","ShopName":"总店","ActualPayAmount":8,"Id":"14367309685143552","CardID":"11","CardName":"","Mobile":"","CreateTime":20190803102312,"BillCode":"XF201908031023126384","OrderType":1,"MemID":"14364803475421184","TotalMoney":10,"DiscountMoney":8,"TotalPoint":0.8,"Remark":""}]
     */

    private int total;
    private List<ConsumeOrderBean> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ConsumeOrderBean> getList() {
        return list;
    }

    public void setList(List<ConsumeOrderBean> list) {
        this.list = list;
    }
}
