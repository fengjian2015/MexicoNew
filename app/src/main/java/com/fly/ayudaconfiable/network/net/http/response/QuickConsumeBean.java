package com.fly.ayudaconfiable.network.net.http.response;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月3日,0003.
 * 158045632@qq.com
 */
public class QuickConsumeBean {

    /**
     * order : {"BillCode":"XF201908031028000403","TotalMoney":100,"DiscountMoney":100,"TotalPoint":0,"ActivityAmount":0,"CouponAmount":0,"ZeroAmount":0,"SingleAmount":0,"Payments":[]}
     * template : {"logo":{"name":"LOGO","key":"logo","size":8,"align":"center","value":"","bold":0,"iscustom":1,"enable":1},"header":[{"name":"店铺名称","key":"ShopName","size":8,"align":"left","bold":1,"iscustom":1,"enable":1},{"name":"小票标题","key":"TicketTitle","size":8,"align":"left","value":"3423423","bold":0,"iscustom":1,"enable":1},{"name":"小票类型","key":"TicketType","size":8,"align":"left","value":"快速消费","bold":0,"iscustom":0,"enable":1}],"top":[{"name":"订单编号","key":"BillCode","size":8,"align":"left","value":"XF201908031028000403","bold":0,"iscustom":0,"enable":1},{"name":"会员卡号","key":"CardID","size":8,"align":"left","value":"0000","bold":0,"iscustom":0,"enable":1},{"name":"卡面号","key":"OutCardID","size":8,"align":"left","bold":0,"iscustom":0,"enable":1},{"name":"会员姓名","key":"CardName","size":8,"align":"left","value":"散客","bold":0,"iscustom":0,"enable":1},{"name":"会员等级","key":"LevelName","size":8,"align":"left","value":"散客","bold":0,"iscustom":0,"enable":1},{"name":"手机号码","key":"Mobile","size":8,"align":"left","value":"","bold":0,"iscustom":0,"enable":1},{"name":"会员余额","key":"Money","size":8,"align":"left","value":"0.00","bold":0,"iscustom":0,"enable":1},{"name":"会员积分","key":"Point","size":8,"align":"left","value":"0.00","bold":0,"iscustom":0,"enable":1}],"bottom":[{"name":"订单时间","key":"CreateTime","size":8,"align":"left","value":"2019-08-03 10:28:00","bold":0,"iscustom":0,"enable":1},{"name":"联系方式","key":"LinkMobile","size":8,"align":"left","value":"15208885311","bold":0,"iscustom":0,"enable":1},{"name":"操作员","key":"UserName","size":8,"align":"left","value":"哈哈","bold":0,"iscustom":0,"enable":1},{"name":"地址","key":"Address","size":8,"align":"left","value":"东山大道","bold":0,"iscustom":0,"enable":1},{"name":"备注","key":"Remark","size":8,"align":"left","value":"","bold":0,"iscustom":0,"enable":1}]}
     */

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
