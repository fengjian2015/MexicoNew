package com.fly.ayudaconfiable.network.net.http.response;

import java.util.List;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月9日,0009.
 * 158045632@qq.com
 */
public class RedeemGiftBean {
    private ResOrderBean order;
    private List<ResGoodDetail> details;
    private PrintTemplateBean template;

    public ResOrderBean getOrder() {
        return order;
    }

    public void setOrder(ResOrderBean order) {
        this.order = order;
    }

    public List<ResGoodDetail> getDetails() {
        return details;
    }

    public void setDetails(List<ResGoodDetail> details) {
        this.details = details;
    }

    public PrintTemplateBean getTemplate() {
        return template;
    }

    public void setTemplate(PrintTemplateBean template) {
        this.template = template;
    }
}
