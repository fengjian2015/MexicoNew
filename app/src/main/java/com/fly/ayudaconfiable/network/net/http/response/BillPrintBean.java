package com.fly.ayudaconfiable.network.net.http.response;

import java.util.List;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月8日,0008.
 * 158045632@qq.com
 * 商品消费跟充次消费共用
 */
public class BillPrintBean {

    private ResOrderBean order;
    private List<ResGoodDetail> details;
    private List<OilGivenPrintBean> giveaway;
    private PrintTemplateBean template;

    public ResOrderBean getOrder() {
        return order;
    }

    public void setOrder(ResOrderBean order) {
        this.order = order;
    }

    public PrintTemplateBean getTemplate() {
        return template;
    }

    public void setTemplate(PrintTemplateBean template) {
        this.template = template;
    }

    public List<ResGoodDetail> getDetails() {
        return details;
    }

    public void setDetails(List<ResGoodDetail> details) {
        this.details = details;
    }

    public List<OilGivenPrintBean> getGiveaway() {
        return giveaway;
    }

    public void setGiveaway(List<OilGivenPrintBean> giveaway) {
        this.giveaway = giveaway;
    }
}
