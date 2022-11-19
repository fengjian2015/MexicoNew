package com.fly.ayudaconfiable.network.net.http.response;

import java.util.List;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月3日,0003.
 * 158045632@qq.com
 */
public class PrintTemplateBean {
    /**
     * logo : {"name":"LOGO","key":"logo","size":8,"align":"center","value":"","bold":0,"iscustom":1,"enable":1}
     * header : [{"name":"店铺名称","key":"ShopName","size":8,"align":"left","bold":1,"iscustom":1,"enable":1},{"name":"小票标题","key":"TicketTitle","size":8,"align":"left","value":"3423423","bold":0,"iscustom":1,"enable":1},{"name":"小票类型","key":"TicketType","size":8,"align":"left","value":"快速消费","bold":0,"iscustom":0,"enable":1}]
     * top : [{"name":"订单编号","key":"BillCode","size":8,"align":"left","value":"XF201908031028000403","bold":0,"iscustom":0,"enable":1},{"name":"会员卡号","key":"CardID","size":8,"align":"left","value":"0000","bold":0,"iscustom":0,"enable":1},{"name":"卡面号","key":"OutCardID","size":8,"align":"left","bold":0,"iscustom":0,"enable":1},{"name":"会员姓名","key":"CardName","size":8,"align":"left","value":"散客","bold":0,"iscustom":0,"enable":1},{"name":"会员等级","key":"LevelName","size":8,"align":"left","value":"散客","bold":0,"iscustom":0,"enable":1},{"name":"手机号码","key":"Mobile","size":8,"align":"left","value":"","bold":0,"iscustom":0,"enable":1},{"name":"会员余额","key":"Money","size":8,"align":"left","value":"0.00","bold":0,"iscustom":0,"enable":1},{"name":"会员积分","key":"Point","size":8,"align":"left","value":"0.00","bold":0,"iscustom":0,"enable":1}]
     * bottom : [{"name":"订单时间","key":"CreateTime","size":8,"align":"left","value":"2019-08-03 10:28:00","bold":0,"iscustom":0,"enable":1},{"name":"联系方式","key":"LinkMobile","size":8,"align":"left","value":"15208885311","bold":0,"iscustom":0,"enable":1},{"name":"操作员","key":"UserName","size":8,"align":"left","value":"哈哈","bold":0,"iscustom":0,"enable":1},{"name":"地址","key":"Address","size":8,"align":"left","value":"东山大道","bold":0,"iscustom":0,"enable":1},{"name":"备注","key":"Remark","size":8,"align":"left","value":"","bold":0,"iscustom":0,"enable":1}]
     */
    private PrintLogoBean logo;
    private List<PrintHeaderBean> header;
    private List<PrintTopBean> top;
    private List<PrintBottomBean> bottom;
    /*新加字段*/
    private List<TicketField> below;
    private PrintFooterBean footer;
    private PrintLogoBean qrcode;
    private int IsPrintLogo;
    private int IsPrintQrcode;

    public List<PrintHeaderBean> getHeader() {
        return header;
    }

    public void setHeader(List<PrintHeaderBean> header) {
        this.header = header;
    }

    public List<PrintTopBean> getTop() {
        return top;
    }

    public void setTop(List<PrintTopBean> top) {
        this.top = top;
    }

    public List<PrintBottomBean> getBottom() {
        return bottom;
    }

    public void setBottom(List<PrintBottomBean> bottom) {
        this.bottom = bottom;
    }

    public List<TicketField> getBelow() {
        return below;
    }

    public void setBelow(List<TicketField> below) {
        this.below = below;
    }

    public PrintFooterBean getFooter() {
        return footer;
    }

    public void setFooter(PrintFooterBean footer) {
        this.footer = footer;
    }

    public PrintLogoBean getQrcode() {
        return qrcode;
    }

    public void setQrcode(PrintLogoBean qrcode) {
        this.qrcode = qrcode;
    }

    public PrintLogoBean getLogo() {
        return logo;
    }

    public void setLogo(PrintLogoBean logo) {
        this.logo = logo;
    }

    public int getIsPrintLogo() {
        return IsPrintLogo;
    }

    public void setIsPrintLogo(int isPrintLogo) {
        IsPrintLogo = isPrintLogo;
    }

    public int getIsPrintQrcode() {
        return IsPrintQrcode;
    }

    public void setIsPrintQrcode(int isPrintQrcode) {
        IsPrintQrcode = isPrintQrcode;
    }
}
