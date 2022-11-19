package com.fly.ayudaconfiable.network.net.http.response;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * nakesoft
 * Created by 孔明 on 2019年7月10日,0010.
 * 158045632@qq.com
 */
public class LoginBean implements Serializable, Parcelable {
    private static final long serialVersionUID = 6368576355138436708L;
    /**
     * CompID : 198
     * CompCode : lucksoft
     * VersionType : 1
     * ShopID : 14272953155303424
     * ShopName : 总店
     * MasterID : 14272953155336192
     * AccountName : admin
     * MShopID : 14272953155303424
     * MasterName : 黄兴林3
     * RoleId : admin
     * PermissionJson :
     * Mobile : 15208885311
     * MerchantCode : 852600277000007
     * TerminalID : 10509254
     * PayChannelType : 01
     * IsEnableQuickPayment : 1
     * SignKey : d1fd95ac651a4bb38e821fbbc449aac4
     * M1Type : 1
     * Token : ew0KICAidHlwIjogIkpXVCIsDQogICJhbGciOiAiSFMyNTYiDQp9.ew0KICAiQ29tcENvZGUiOiAibHVja3NvZnQiLA0KICAiU2Vzc2lvbklkIjogIjY3MTlkMzBkNWZjYzRjNWY4OWEzMTUxZGI3OWIxYzU0IiwNCiAgIlVzZXJJZCI6ICIxNDI3Mjk1MzE1NTMzNjE5MiIsDQogICJTb3VyY2UiOiAzLA0KICAiTG9naW5JUCI6ICIxOTIuMTY4LjAuOTMiLA0KICAiTG9naW5BdCI6ICIyMDE5LTA3LTEwIDA5OjI2OjA4IiwNCiAgIkV4cGlyeUF0IjogIjIwMTktMDctMTEgMDk6MjY6MDgiDQp9.UXj9OX09TdYoOgpbnz5H7EtU_Ac4h3GRVvsKpONmIC0
     * Images : null
     * SmsState : 0
     * SmsSign :
     * SysArguments : {"MoneyPrecision":2,"PointPrecision":2,"IsAllowModifyGoodsPrice":0,"IsAllowModifyOrderTotal":0,"ZeroErasingUnit":1,"IsForbidInputCardID":0,"PointOffsetCashPrecent":0.99,"GoodsIsSharedBetweenShop":0,"IsEnableRevokePwd":1,"IsEnableECRules":1,"EWSCodeType":3,"EWSCodeFormat":2,"IsAllowModifyCommission":0,"ManyStaffCommissionWay":1,"IsSystemSMS":1,"IsSMSMemCountMerge":0,"IsEnableOrderArchive":1,"OrderArchiveDays":90,"IsAllowUseManyConpon":0,"IsEnableSecurityPwd":0,"MemberDefaultPwd":"123456789","IsVerifyMobileForRegister":0,"MemberIsSharedBetweenShop":0,"IsEnableMoneyWithdrawCash":0,"MoneyWithdrawCashPrecent":1.23,"DailyMoneyUseLimit":333,"PaymentConfig":[{"code":"001","name":"现金","icon":"wx.png"},{"code":"002","name":"余额","icon":"wx.png"},{"code":"003","name":"积分","icon":"wx.png"},{"code":"004","name":"银行卡","icon":"wx.png"}],"SankeDefaultPayment":"001","MemberDefaultPayment":"001"}
     * ImageServerPath : https://skin1.600vip.cn
     */

    private int CompID;
    private String CompCode;
    private int VersionType;
    //当前门店ID
    private String ShopID;
    private String ShopName;
    private String MasterAccount;
    private String MasterID;
    private String AccountName;
    //总店
    private String MShopID;
    private String MasterName;
    private String RoleId;
    private String PermissionJson;
    private String Mobile;
    private String MerchantCode;
    private String TerminalID;
    private String PayChannelType;
    private int IsEnableQuickPayment;
    private String SignKey = "";
    private int M1Type;
    private String Token;
    private String Images;
    private int SmsState;
    private String SmsSign;
    private SysArgumentsBean SysArguments;
    private String ImageServerPath;
    private int HavePwd;
    private int IsQuickPay = 1;

    private String VersionName = "";// 版本名称
    private int ExpireDays; //到期天数
    private int Type;//1-试用版本、2-永久正式、3-计时收费
    private String PassDate;
    private String AgentAccount = "";
    private int IsShangMiCashier; //商米严选
    private int isEnableOnlineRechargeSms;
    private String OnlineRechargeSmsUrl = "";
    private int IsEnableCountCombo;

    private String SysTemUrl = "";//行业案例地址
    private String CustomerNickName = "";//客服人员昵称
    private String HeadImage = "";//客服人员头像
    private String WechatNumber = "";//客服人员微信号
    private String WechatQRCode = "";//客服人员微信二维码

    private String CompName = "";
    private String LinkName = "";
    private String LinkMobile = "";
    /*是否弹出企业账户安全管理 0否1是 ADMIN账户第一次登录都要弹 后台已处理*/
    private int IsOpenAccountSecurity;
    /*是否弹出客服提醒 0不自动弹 1自动弹不可关闭，只能退出登录 2自动弹可关闭*/
    private int IsOpenCustomerRemind;
    /*客服提醒内容*/
    private String RemindMsg = "";
    /*是否显示账户安全管理下次提醒按钮 0否1是*/
    private int IsShowNextTimeBtn;
    /*版本权限*/
    private String SoftModuleJson = "";
    public int accountType = 0;// 0正常  1体验账户   2体验总账户
    public int BillSearchMonthLimit;//单据管理可以返回去查多少个月的记录
    /*花呗分期期数 3,6,12 逗号分隔*/
    public String FenQiNum="";
    public int PushType;  //推送类型 0阿里云 1自研方式

    public int getCompID() {
        return CompID;
    }

    public void setCompID(int CompID) {
        this.CompID = CompID;
    }

    public String getCompCode() {
        return CompCode;
    }

    public void setCompCode(String CompCode) {
        this.CompCode = CompCode;
    }

    public int getVersionType() {
        return VersionType;
    }

    public void setVersionType(int VersionType) {
        this.VersionType = VersionType;
    }

    public String getShopID() {
        return ShopID;
    }

    public void setShopID(String ShopID) {
        this.ShopID = ShopID;
    }

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String ShopName) {
        this.ShopName = ShopName;
    }

    public String getMasterID() {
        return MasterID;
    }

    public void setMasterID(String MasterID) {
        this.MasterID = MasterID;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String AccountName) {
        this.AccountName = AccountName;
    }

    public String getMShopID() {
        return MShopID;
    }

    public void setMShopID(String MShopID) {
        this.MShopID = MShopID;
    }

    public String getMasterName() {
        return MasterName;
    }

    public void setMasterName(String MasterName) {
        this.MasterName = MasterName;
    }

    public String getRoleId() {
        return RoleId;
    }

    public void setRoleId(String RoleId) {
        this.RoleId = RoleId;
    }

    public String getPermissionJson() {
        return PermissionJson;
    }

    public void setPermissionJson(String PermissionJson) {
        this.PermissionJson = PermissionJson;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public String getMerchantCode() {
        return MerchantCode;
    }

    public void setMerchantCode(String MerchantCode) {
        this.MerchantCode = MerchantCode;
    }

    public String getTerminalID() {
        return TerminalID;
    }

    public void setTerminalID(String TerminalID) {
        this.TerminalID = TerminalID;
    }

    public String getPayChannelType() {
        return PayChannelType;
    }

    public void setPayChannelType(String PayChannelType) {
        this.PayChannelType = PayChannelType;
    }

    public int getIsEnableQuickPayment() {
        return IsEnableQuickPayment;
    }

    public void setIsEnableQuickPayment(int IsEnableQuickPayment) {
        this.IsEnableQuickPayment = IsEnableQuickPayment;
    }

    public String getSignKey() {
        return SignKey;
    }

    public void setSignKey(String SignKey) {
        this.SignKey = SignKey;
    }

    public int getM1Type() {
        return M1Type;
    }

    public void setM1Type(int M1Type) {
        this.M1Type = M1Type;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }

    public String getImages() {
        return Images;
    }

    public void setImages(String Images) {
        this.Images = Images;
    }

    public int getSmsState() {
        return SmsState;
    }

    public void setSmsState(int SmsState) {
        this.SmsState = SmsState;
    }

    public String getSmsSign() {
        return SmsSign;
    }

    public void setSmsSign(String SmsSign) {
        this.SmsSign = SmsSign;
    }

    public SysArgumentsBean getSysArguments() {
        return SysArguments;
    }

    public void setSysArguments(SysArgumentsBean SysArguments) {
        this.SysArguments = SysArguments;
    }

    public String getImageServerPath() {
        return ImageServerPath;
    }

    public void setImageServerPath(String ImageServerPath) {
        this.ImageServerPath = ImageServerPath;
    }

    public int getHavePwd() {
        return HavePwd;
    }

    public void setHavePwd(int HavePwd) {
        this.HavePwd = HavePwd;
    }

    public String getMasterAccount() {
        return MasterAccount;
    }

    public void setMasterAccount(String masterAccount) {
        MasterAccount = masterAccount;
    }

    public int getIsQuickPay() {
        return IsQuickPay;
    }

    public void setIsQuickPay(int isQuickPay) {
        IsQuickPay = isQuickPay;
    }

    public String getVersionName() {
        return VersionName;
    }

    public void setVersionName(String versionName) {
        VersionName = versionName;
    }

    public int getExpireDays() {
        return ExpireDays;
    }

    public void setExpireDays(int expireDays) {
        ExpireDays = expireDays;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public String getPassDate() {
        return PassDate;
    }

    public void setPassDate(String passDate) {
        PassDate = passDate;
    }

    public String getAgentAccount() {
        return AgentAccount;
    }

    public void setAgentAccount(String agentAccount) {
        AgentAccount = agentAccount;
    }

    public int getIsShangMiCashier() {
        return IsShangMiCashier;
    }

    public void setIsShangMiCashier(int isShangMiCashier) {
        IsShangMiCashier = isShangMiCashier;
    }

    public int getIsEnableOnlineRechargeSms() {
        return isEnableOnlineRechargeSms;
    }

    public void setIsEnableOnlineRechargeSms(int isEnableOnlineRechargeSms) {
        this.isEnableOnlineRechargeSms = isEnableOnlineRechargeSms;
    }

    public String getOnlineRechargeSmsUrl() {
        return OnlineRechargeSmsUrl;
    }

    public void setOnlineRechargeSmsUrl(String onlineRechargeSmsUrl) {
        OnlineRechargeSmsUrl = onlineRechargeSmsUrl;
    }

    public int getIsEnableCountCombo() {
        return IsEnableCountCombo;
    }

    public void setIsEnableCountCombo(int isEnableCountCombo) {
        IsEnableCountCombo = isEnableCountCombo;
    }

    public String getSysTemUrl() {
        return SysTemUrl;
    }

    public void setSysTemUrl(String sysTemUrl) {
        SysTemUrl = sysTemUrl;
    }

    public String getCustomerNickName() {
        return CustomerNickName;
    }

    public void setCustomerNickName(String customerNickName) {
        CustomerNickName = customerNickName;
    }

    public String getHeadImage() {
        return HeadImage;
    }

    public void setHeadImage(String headImage) {
        HeadImage = headImage;
    }

    public String getWechatNumber() {
        return WechatNumber;
    }

    public void setWechatNumber(String wechatNumber) {
        WechatNumber = wechatNumber;
    }

    public String getWechatQRCode() {
        return WechatQRCode;
    }

    public void setWechatQRCode(String wechatQRCode) {
        WechatQRCode = wechatQRCode;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCompName() {
        return CompName;
    }

    public void setCompName(String compName) {
        CompName = compName;
    }

    public String getLinkName() {
        return LinkName;
    }

    public void setLinkName(String linkName) {
        LinkName = linkName;
    }

    public String getLinkMobile() {
        return LinkMobile;
    }

    public void setLinkMobile(String linkMobile) {
        LinkMobile = linkMobile;
    }

    public int getIsOpenAccountSecurity() {
        return IsOpenAccountSecurity;
    }

    public void setIsOpenAccountSecurity(int isOpenAccountSecurity) {
        IsOpenAccountSecurity = isOpenAccountSecurity;
    }

    public int getIsOpenCustomerRemind() {
        return IsOpenCustomerRemind;
    }

    public void setIsOpenCustomerRemind(int isOpenCustomerRemind) {
        IsOpenCustomerRemind = isOpenCustomerRemind;
    }

    public String getRemindMsg() {
        return RemindMsg;
    }

    public void setRemindMsg(String remindMsg) {
        RemindMsg = remindMsg;
    }

    public int getIsShowNextTimeBtn() {
        return IsShowNextTimeBtn;
    }

    public void setIsShowNextTimeBtn(int isShowNextTimeBtn) {
        IsShowNextTimeBtn = isShowNextTimeBtn;
    }

    public String getSoftModuleJson() {
        return SoftModuleJson;
    }

    public void setSoftModuleJson(String softModuleJson) {
        SoftModuleJson = softModuleJson;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public int getBillSearchMonthLimit() {
        return BillSearchMonthLimit;
    }

    public void setBillSearchMonthLimit(int billSearchMonthLimit) {
        BillSearchMonthLimit = billSearchMonthLimit;
    }

    public String getFenQiNum() {
        return FenQiNum;
    }

    public void setFenQiNum(String fenQiNum) {
        FenQiNum = fenQiNum;
    }

    public int getPushType() {
        return PushType;
    }

    public void setPushType(int pushType) {
        PushType = pushType;
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "CompID=" + CompID +
                ", CompCode='" + CompCode + '\'' +
                ", VersionType=" + VersionType +
                ", ShopID='" + ShopID + '\'' +
                ", ShopName='" + ShopName + '\'' +
                ", MasterAccount='" + MasterAccount + '\'' +
                ", MasterID='" + MasterID + '\'' +
                ", AccountName='" + AccountName + '\'' +
                ", MShopID='" + MShopID + '\'' +
                ", MasterName='" + MasterName + '\'' +
                ", RoleId='" + RoleId + '\'' +
                ", PermissionJson='" + PermissionJson + '\'' +
                ", Mobile='" + Mobile + '\'' +
                ", MerchantCode='" + MerchantCode + '\'' +
                ", TerminalID='" + TerminalID + '\'' +
                ", PayChannelType='" + PayChannelType + '\'' +
                ", IsEnableQuickPayment=" + IsEnableQuickPayment +
                ", SignKey='" + SignKey + '\'' +
                ", M1Type=" + M1Type +
                ", Token='" + Token + '\'' +
                ", Images='" + Images + '\'' +
                ", SmsState=" + SmsState +
                ", SmsSign='" + SmsSign + '\'' +
                ", SysArguments=" + SysArguments +
                ", ImageServerPath='" + ImageServerPath + '\'' +
                ", HavePwd=" + HavePwd +
                ", IsQuickPay=" + IsQuickPay +
                ", VersionName='" + VersionName + '\'' +
                ", ExpireDays=" + ExpireDays +
                ", Type=" + Type +
                ", PassDate='" + PassDate + '\'' +
                ", AgentAccount='" + AgentAccount + '\'' +
                ", IsShangMiCashier=" + IsShangMiCashier +
                ", isEnableOnlineRechargeSms=" + isEnableOnlineRechargeSms +
                ", OnlineRechargeSmsUrl='" + OnlineRechargeSmsUrl + '\'' +
                ", IsEnableCountCombo=" + IsEnableCountCombo +
                ", SysTemUrl='" + SysTemUrl + '\'' +
                ", CustomerNickName='" + CustomerNickName + '\'' +
                ", HeadImage='" + HeadImage + '\'' +
                ", WechatNumber='" + WechatNumber + '\'' +
                ", WechatQRCode='" + WechatQRCode + '\'' +
                ", CompName='" + CompName + '\'' +
                ", LinkName='" + LinkName + '\'' +
                ", LinkMobile='" + LinkMobile + '\'' +
                ", IsOpenAccountSecurity=" + IsOpenAccountSecurity +
                ", IsOpenCustomerRemind=" + IsOpenCustomerRemind +
                ", RemindMsg='" + RemindMsg + '\'' +
                ", IsShowNextTimeBtn=" + IsShowNextTimeBtn +
                ", SoftModuleJson='" + SoftModuleJson + '\'' +
                ", accountType=" + accountType +
                ", BillSearchMonthLimit=" + BillSearchMonthLimit +
                ", FenQiNum='" + FenQiNum + '\'' +
                ", PushType=" + PushType +
                '}';
    }

    public LoginBean() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.CompID);
        dest.writeString(this.CompCode);
        dest.writeInt(this.VersionType);
        dest.writeString(this.ShopID);
        dest.writeString(this.ShopName);
        dest.writeString(this.MasterAccount);
        dest.writeString(this.MasterID);
        dest.writeString(this.AccountName);
        dest.writeString(this.MShopID);
        dest.writeString(this.MasterName);
        dest.writeString(this.RoleId);
        dest.writeString(this.PermissionJson);
        dest.writeString(this.Mobile);
        dest.writeString(this.MerchantCode);
        dest.writeString(this.TerminalID);
        dest.writeString(this.PayChannelType);
        dest.writeInt(this.IsEnableQuickPayment);
        dest.writeString(this.SignKey);
        dest.writeInt(this.M1Type);
        dest.writeString(this.Token);
        dest.writeString(this.Images);
        dest.writeInt(this.SmsState);
        dest.writeString(this.SmsSign);
        dest.writeSerializable(this.SysArguments);
        dest.writeString(this.ImageServerPath);
        dest.writeInt(this.HavePwd);
        dest.writeInt(this.IsQuickPay);
        dest.writeString(this.VersionName);
        dest.writeInt(this.ExpireDays);
        dest.writeInt(this.Type);
        dest.writeString(this.PassDate);
        dest.writeString(this.AgentAccount);
        dest.writeInt(this.IsShangMiCashier);
        dest.writeInt(this.isEnableOnlineRechargeSms);
        dest.writeString(this.OnlineRechargeSmsUrl);
        dest.writeInt(this.IsEnableCountCombo);
        dest.writeString(this.SysTemUrl);
        dest.writeString(this.CustomerNickName);
        dest.writeString(this.HeadImage);
        dest.writeString(this.WechatNumber);
        dest.writeString(this.WechatQRCode);
        dest.writeString(this.CompName);
        dest.writeString(this.LinkName);
        dest.writeString(this.LinkMobile);
        dest.writeInt(this.IsOpenAccountSecurity);
        dest.writeInt(this.IsOpenCustomerRemind);
        dest.writeString(this.RemindMsg);
        dest.writeInt(this.IsShowNextTimeBtn);
        dest.writeString(this.SoftModuleJson);
        dest.writeInt(this.accountType);
        dest.writeInt(this.BillSearchMonthLimit);
        dest.writeString(this.FenQiNum);
        dest.writeInt(this.PushType);
    }

    protected LoginBean(Parcel in) {
        this.CompID = in.readInt();
        this.CompCode = in.readString();
        this.VersionType = in.readInt();
        this.ShopID = in.readString();
        this.ShopName = in.readString();
        this.MasterAccount = in.readString();
        this.MasterID = in.readString();
        this.AccountName = in.readString();
        this.MShopID = in.readString();
        this.MasterName = in.readString();
        this.RoleId = in.readString();
        this.PermissionJson = in.readString();
        this.Mobile = in.readString();
        this.MerchantCode = in.readString();
        this.TerminalID = in.readString();
        this.PayChannelType = in.readString();
        this.IsEnableQuickPayment = in.readInt();
        this.SignKey = in.readString();
        this.M1Type = in.readInt();
        this.Token = in.readString();
        this.Images = in.readString();
        this.SmsState = in.readInt();
        this.SmsSign = in.readString();
        this.SysArguments = (SysArgumentsBean) in.readSerializable();
        this.ImageServerPath = in.readString();
        this.HavePwd = in.readInt();
        this.IsQuickPay = in.readInt();
        this.VersionName = in.readString();
        this.ExpireDays = in.readInt();
        this.Type = in.readInt();
        this.PassDate = in.readString();
        this.AgentAccount = in.readString();
        this.IsShangMiCashier = in.readInt();
        this.isEnableOnlineRechargeSms = in.readInt();
        this.OnlineRechargeSmsUrl = in.readString();
        this.IsEnableCountCombo = in.readInt();
        this.SysTemUrl = in.readString();
        this.CustomerNickName = in.readString();
        this.HeadImage = in.readString();
        this.WechatNumber = in.readString();
        this.WechatQRCode = in.readString();
        this.CompName = in.readString();
        this.LinkName = in.readString();
        this.LinkMobile = in.readString();
        this.IsOpenAccountSecurity = in.readInt();
        this.IsOpenCustomerRemind = in.readInt();
        this.RemindMsg = in.readString();
        this.IsShowNextTimeBtn = in.readInt();
        this.SoftModuleJson = in.readString();
        this.accountType = in.readInt();
        this.BillSearchMonthLimit = in.readInt();
        this.FenQiNum = in.readString();
        this.PushType = in.readInt();
    }

    public static final Creator<LoginBean> CREATOR = new Creator<LoginBean>() {
        @Override
        public LoginBean createFromParcel(Parcel source) {
            return new LoginBean(source);
        }

        @Override
        public LoginBean[] newArray(int size) {
            return new LoginBean[size];
        }
    };
}
