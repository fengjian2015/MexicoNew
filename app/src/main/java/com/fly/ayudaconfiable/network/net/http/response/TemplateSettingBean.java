package com.fly.ayudaconfiable.network.net.http.response;

/**
 * nakesoft
 * 打印模板
 */
public class TemplateSettingBean  {



        /**
         * TicketTemplate : {"logo":{"name":"LOGO","key":"logo","size":8,"align":"center","value":"","bold":0,"iscustom":1,"enable":0},"header":[{"name":"店铺名称","key":"ShopName","size":9,"align":"left","value":"","bold":1,"iscustom":1,"enable":1},{"name":"小票标题","key":"TicketTitle","size":9,"align":"left","value":"","bold":0,"iscustom":1,"enable":1},{"name":"小票类型","key":"TicketType","size":9,"align":"left","value":"","bold":0,"iscustom":0,"enable":1}],"top":[{"name":"订单编号","key":"BillCode","size":9,"align":"left","value":"","bold":0,"iscustom":0,"enable":1},{"name":"会员卡号","key":"CardID","size":9,"align":"left","value":"","bold":0,"iscustom":0,"enable":1},{"name":"车牌号","key":"PlateNumber","size":9,"align":"left","value":"","bold":0,"iscustom":0,"enable":1},{"name":"卡面号","key":"OutCardID","size":9,"align":"left","value":"","bold":0,"iscustom":0,"enable":1},{"name":"会员姓名","key":"CardName","size":9,"align":"left","value":"","bold":0,"iscustom":0,"enable":1},{"name":"会员等级","key":"LevelName","size":9,"align":"left","value":"","bold":0,"iscustom":0,"enable":1},{"name":"手机号码","key":"Mobile","size":9,"align":"left","value":"","bold":0,"iscustom":0,"enable":1},{"name":"会员余额","key":"Money","size":9,"align":"left","value":"","bold":0,"iscustom":0,"enable":1},{"name":"会员积分","key":"Point","size":9,"align":"left","value":"","bold":0,"iscustom":0,"enable":1}],"bottom":[{"name":"操作时间","key":"CreateTime","size":9,"align":"left","value":"","bold":0,"iscustom":0,"enable":1},{"name":"联系方式","key":"LinkMobile","size":9,"align":"left","value":"","bold":0,"iscustom":0,"enable":1},{"name":"操作员","key":"UserName","size":9,"align":"left","value":"","bold":0,"iscustom":0,"enable":1},{"name":"地址","key":"Address","size":9,"align":"left","value":"","bold":0,"iscustom":0,"enable":0},{"name":"备注","key":"Remark","size":9,"align":"left","value":"","bold":0,"iscustom":0,"enable":0}],"footer":{"name":"脚注","key":"Footer","size":9,"align":"left","bold":0,"iscustom":1,"enable":1},"qrcode":{"name":"二维码","key":"QrCode","size":8,"align":"center","value":"","bold":0,"iscustom":1,"enable":0}}
         */

        private PrintTemplateBean TicketTemplate;

        public PrintTemplateBean getTicketTemplate() {
            return TicketTemplate;
        }

        public void setTicketTemplate(PrintTemplateBean TicketTemplate) {
            this.TicketTemplate = TicketTemplate;
        }


}
