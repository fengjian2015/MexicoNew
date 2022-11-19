package com.fly.ayudaconfiable.network.net.http.response;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月8日,0008.
 * 158045632@qq.com
 */
public class TopUpBean {

    private ResOrderBean order;
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
}
