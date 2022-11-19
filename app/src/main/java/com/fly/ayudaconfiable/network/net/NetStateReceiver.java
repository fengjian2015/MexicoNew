package com.fly.ayudaconfiable.network.net;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;

import com.blankj.utilcode.util.StringUtils;
import com.fly.ayudaconfiable.network.net.http.NetClient;
import com.fly.ayudaconfiable.task.CheckOrderTask;
import com.fly.ayudaconfiable.task.ScheduledTask;
import com.fly.ayudaconfiable.utils.LogUtils;
import com.fly.ayudaconfiable.utils.ToastUtil;
import com.google.android.gms.common.api.Response;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NetStateReceiver extends BroadcastReceiver {
    public static final String REQUEST_ACTION = "sunmi.payment.action.entry";
    public static final String RESPONSE_ACTION = "sunmi.payment.action.result";
    public static final String SUNMIL3_ACTION = "sunmi.payment.L3.RESULT";

    public static final String LANDIL3_ACTION = ".com.yeahka.L3.RESULT";
    private static NetStateReceiver broadcastReceiver = null;
    private boolean isPayAvaiable = false;
    private Application.ActivityLifecycleCallbacks lifecycleCallbacks = null;
    private ResultCallback callback = null;
    private Gson mgson = new Gson();
    private boolean isFirst = true;
    final int NETWORK_NONE = 0;
    final int NETWORK_MOBILE = 1;
    final int NETWORK_WIFI = 2;
    final int NETWORK_ETHERNET = 3;
    final int NETWORK_OTHER = 100;
    private String recordOrderNo = "";

    public NetStateReceiver() {
        LogUtils.e("  !!!!!!!!! 检查 创建的次数 ############");
        /**
        if(BuildConfig.APP_TYPE == Constant.Pos_Landi) {
            if (BuildConfig.DEBUG) {
                isPayAvaiable = isAppInstalled(NewNakeApplication.getInstance().getApplicationContext(), "com.nqpay.usdk");
            } else {
                isPayAvaiable = isAppInstalled(NewNakeApplication.getInstance().getApplicationContext(), "com.allinpay.usdk");
            }
        }
        **/
        if(isPayAvaiable){
            LogUtils.v("  在运行 ");
        } else {
            LogUtils.v("  没有运行  ");
        }


    }

    public static synchronized NetStateReceiver getInstance() {
        if(broadcastReceiver == null){
            broadcastReceiver = new NetStateReceiver();
        }
        return broadcastReceiver;
    }


    public void setCallback(ResultCallback callback) {
        this.callback = callback;
    }

    public void saveOrderNo(String param) {
        this.recordOrderNo = param;
    }

    public interface ResultCallback {
        void callback(String result);
        void sunmil3back(Intent intent);
    }

    /** 记录一下上次联网正常的时间作对比 */
    private int lastNetWorkState = -1;
    private long lastConnectTime = 0, nowTime = 0;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        // 如果相等的话就说明网络状态发生了变化

        if ((context == null) || (intent == null)) {
            LogUtils.v("  返回  ");
            if(context == null){
                LogUtils.e("  context is null");
            }
            return;
        }
        LogUtils.v("  ====>  " + intent.getAction());

        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            int netWorkState = getNetWorkState(context);

            nowTime = System.currentTimeMillis();
            /** 有网络的情况下 多次间隔太短了，可能网络不稳定  **/
            if((lastNetWorkState == netWorkState) && (nowTime - lastConnectTime < 3000)){
                LogUtils.e(" 间隔时间太短了或者跟上次相同!!!  直接返回了");
                if(netWorkState == NETWORK_NONE) {
                    //SoundUtils.playSound(context, R.raw.network_disconnect);//这里断网不用了，推送服务那边报
                }
                return;
            }
            lastConnectTime = nowTime;
            lastNetWorkState = netWorkState;

            // 当网络发生变化，判断当前网络状态，并通过NetEvent回调当前网络状态
            if(netWorkState != NETWORK_NONE){

                LogUtils.f(" 本次联网成功 ，启动 10秒 延时 执行任务   ");
                if(isPayAvaiable) {
                    /** 延时 30秒去 检查一下 是否有未处理的订单 */
                    ScheduledTask.getInstance().runTask(new CheckOrderTask(), isFirst ? 16000 : 10000);
                    isFirst = false;
                } else {
                    LogUtils.v(" 没有收银台无需执行 ");
                }
            } else {
                LogUtils.f(" 网络断开了 ");

                //SoundUtils.playSound(context, R.raw.network_disconnect); //这里断网不用了，推送服务那边报
            }
        } else if (RESPONSE_ACTION.equals(intent.getAction())) {
            String jsonStr = intent.getStringExtra("response");
            LogUtils.i("jsonStr = " + jsonStr);
            LogUtils.v(" 支付界面不存的时候 , 在本类中处理 ,可能是因为异常了，需要 补单处理的 ");
            Response queryRes = mgson.fromJson(jsonStr, Response.class);
            if(!TextUtils.isEmpty(recordOrderNo)){

            } else {
                if (callback != null) {
                    callback.callback(jsonStr);
                } else {
                    LogUtils.v(" 支付界面不存的时候 , 在本类中处理 ,可能是因为异常了，需要 补单处理的 ");
                    processErCode(queryRes);
                }
            }
        } else if(SUNMIL3_ACTION.equals(intent.getAction())) {
            LogUtils.w("$$$$$$$$$$$$$$$$$ L3 $$$$$$$$$$$$$$$$$$$$");
            if (callback != null) {
                callback.sunmil3back(intent);
            }
            String resultInfo = "";
            final int resultCode = intent.getIntExtra("resultCode", -1);
            long amount = intent.getLongExtra("amount", 0);
            // 原交易凭证号
            String voucherNo = intent.getStringExtra("voucherNo");
            // 原参考号
            String referenceNo = intent.getStringExtra("referenceNo");
            String date = intent.getStringExtra("transDate");
            String transId = intent.getStringExtra("transId");
            String batchNo = intent.getStringExtra("batchNo");
            String cardNo = intent.getStringExtra("cardNo");
            String cardType = intent.getStringExtra("cardType");
            String issue = intent.getStringExtra("issue");
            String terminalId = intent.getStringExtra("terminalId");
            String merchantId = intent.getStringExtra("merchantId");
            String merchantName = intent.getStringExtra("merchantName");
            String merchantNameEn = intent.getStringExtra("merchantNameEn");
            int paymentType = intent.getIntExtra("paymentType", -2);
            String transTime = intent.getStringExtra("transTime");
            int errorCode = intent.getIntExtra("errorCode", 0);
            final String errorMsg = intent.getStringExtra("errorMsg");
            long balance = intent.getLongExtra("balance", 0);
            int transNum = intent.getIntExtra("transNum", 0);
            long totalAmount = intent.getLongExtra("totalAmount", 0L);
            LogUtils.d(" resultCode = " + resultCode);
            resultInfo = resultCode + "";
            if (amount != 0) {
                resultInfo = resultInfo + "\namount:" + amount;
            }
            if (!TextUtils.isEmpty(voucherNo)) {
                resultInfo = resultInfo + "\nvoucherNo:" + voucherNo;
            }
            if (!TextUtils.isEmpty(referenceNo)) {
                resultInfo = resultInfo + "\nreferenceNo:" + referenceNo;
            }
            if (!TextUtils.isEmpty(batchNo)) {
                resultInfo = resultInfo + "\nbatchNo:" + batchNo;
            }
            if (!TextUtils.isEmpty(cardNo)) {
                resultInfo = resultInfo + "\ncardNo:" + cardNo;
            }
            if (!TextUtils.isEmpty(cardType)) {
                resultInfo = resultInfo + "\ncardType:" + cardType;
            }
            if (!TextUtils.isEmpty(issue)) {
                resultInfo = resultInfo + "\nissue:" + issue;
            }
            if (!TextUtils.isEmpty(terminalId)) {
                resultInfo = resultInfo + "\nterminalId:" + terminalId;
            }
            if (!TextUtils.isEmpty(merchantId)) {
                resultInfo = resultInfo + "\nmerchantId:" + merchantId;
            }
            if(!TextUtils.isEmpty(merchantName)){
                resultInfo = resultInfo + "\nmerchantName:" + merchantName;
            }
            if (paymentType != -2) {
                resultInfo = resultInfo + "\npaymentType:" + paymentType;
            }
            if (!TextUtils.isEmpty(date)) {
                resultInfo = resultInfo + "\ntransDate:" + date;
            }
            if (!TextUtils.isEmpty(transTime)) {
                resultInfo = resultInfo + "\ntransTime:" + transTime;
            }
            if (errorCode != 0) {
                resultInfo = resultInfo + "\nerrorCode:" + errorCode;
            }
            if (!TextUtils.isEmpty(errorMsg)) {
                resultInfo = resultInfo + "\nerrorMsg:" + errorMsg;
            }
            if (balance != 0) {
                resultInfo = resultInfo + "\nbalance:" + balance;
            }
            if (!TextUtils.isEmpty(transId)) {
                resultInfo = resultInfo + "\ntransId:" + transId;
            }
            if (!TextUtils.isEmpty(merchantNameEn)) {
                resultInfo = resultInfo + "\nmerchantNameEn:" + merchantNameEn;
            }
            if (transNum != 0) {
                resultInfo = resultInfo + "\ntransNum:" + transNum;
            }
            if (totalAmount != 0) {
                resultInfo = resultInfo + "\ntotalAmount:" + totalAmount;
            }

            LogUtils.e(resultInfo);
            if (resultCode != -1) {
                // -1  失败，0 成功
                //batchNo:000001
                //cardNo:13457509538169013
                if (resultCode == 0) {
                    if (paymentType == 0) { //银行卡支付
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
                        String pay_time = formatter.format(new Date());
                        NetClient.getInstance().updatePaySate(transId, pay_time, 1, "01", merchantId, voucherNo, null);
                    }
                }

                if (StringUtils.isEmpty(cardNo)) {
                    ToastUtil.show("未获取到交易流水号");
                    return;
                }
                LogUtils.v("----------------------------");
            } else {//交易失败  errorMsg
                //ToastUtil.show(errorMsg);
            }
        } else if(LANDIL3_ACTION.equals(intent.getAction())) {
            LogUtils.d("   联迪乐刷返回  ");
            //LuckPayFactory.getInstance().setPayResult(context, intent);
        } else {
            Log.i("info","  other action 其它的 Action   ");
        }
    }

    public int getNetWorkState(Context context) {
        //得到连接管理器对象
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        //如果网络连接，判断该网络类型
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == (ConnectivityManager.TYPE_WIFI)) {
                LogUtils.f( "  current connect net type WiFi ");
                return NETWORK_WIFI;//wifi
            } else if (activeNetworkInfo.getType() == (ConnectivityManager.TYPE_MOBILE)) {
                LogUtils.f("  current connect net type  mobile ");
                return NETWORK_MOBILE;//mobile
            } else if(activeNetworkInfo.getType() == ConnectivityManager.TYPE_ETHERNET){
                LogUtils.f("   current connect net type  ethernet 有线网络  ");
                return NETWORK_ETHERNET;
            } else {
                LogUtils.e( " not process  其它  ");
            }
        } else {
            LogUtils.e( " no 无网络    ");
            //网络异常
            return NETWORK_NONE;
        }
        return NETWORK_NONE;
    }

    public boolean isAppInstalled(Context context, String packageName) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
            e.printStackTrace();
        }
        if(packageInfo == null){
            return false;
        } else {
            return true;
        }
    }

    /**
     错误码的处理
     */
    //"resultCode":"E07","resultMsg":"(E07)未开户！1. 您可尝试在设置内更新终端参数 2. 联系您的供货商确认是否开通支付服务，或咨询客服4009021168"
    private void processErCode(Response response){

    }

    private void submitData(String orderno){
        LogUtils.v(" 支付成功了 需要提交的  orderno:  " + orderno);
    }

    /**
     Result Code	Result Msg	建议显示内容
     T00	交易成功	交易成功
     T01	无效交易	(T01)无效交易，请重试
     T02	余额不足	(T02)余额不足，请更换支付方式
     T03	交易金额超限	(T03)交易金额超限，确认后重试
     T04	商户余额不足	(T04)商户余额不足，请检查后重试
     T05	密码错误	(T05)密码错误，请重试
     T06	重复交易	(T06)重复交易，请重新发起交易
     T07	交易失败	(T07)交易失败，请稍后重试
     T08	无效交易	(T08)暂不支持当日退款，请隔日再试
     T09	有作弊嫌疑	(T09)状态异常，请稍后重试或更换支付方式
     T10	MAC校验失败	(T10)MAC校验失败，请稍后重试
     T11	舞弊嫌疑	(T11)有舞弊嫌疑，请更换支付方式重试
     T12	支付失败，简易客户使用其他支付方式	(T12)支付失败，请稍后重试或更换支付方式
     T13	针对盛付通不支持当日部分退款情况	（T13）当日交易不支持部分退款，请隔日再试
     E01	无效商户	(E01)无效商户，请向您的供货商确认商户状态
     E02	无效金额	(E02)无效金额，请确认后重试
     E04	终端号无效	(E04)无效终端，请向您的供货商确认终端状态
     E05	验签失败	(E05)验签失败
     E06	SN号无效	(E06)无效SN，请向您的供货商检查SN状态
     E07	初始化失败	未开户！1. 您可尝试在设置内更新终端参数 2. 联系您的供货商确认是否开通支付服务，或咨询客服4009021168
     E08	SN号不存在	(E08)SN不存在，请向您的供货商确认后重试
     E09	无效门店	(E09)无效门店，请向您的供货商确认门店状态
     E10	SN号不能为空	(E10)SN号不能为空
     E11	商户号不能为空	(E11)商户号不能为空
     E12	交易日期不能为空	(E12)交易日期不能为空
     E13	交易日期无效	(E13)交易日期无效
     E14	终端未登记	(E14)终端未登记，请向您的供货商确认后重试
     E15	参数校验错误（框架返回码 -1）	(E15)参数校验错误
     E16	付款码已过期	(E16)付款码已过期，请刷新后重试
     E17	付款码无效	(E17)付款码无效，请确认后重试
     E18	无效的应用类型	(E18)无效的应用类型
     E19	查询不到此笔交易	(E19)找不到原交易，请确认后重试
     E20	无效的交易类型	(E20)无效的交易类型
     E21	无效的MIS订单号	(E21)无效的MIS订单号
     E22	退款金额有误	(E22)退款金额超限，请确认后重试
     E23	查询不到设备支付宝授权信息	(E23)查询不到设备支付宝授权信息
     E24	查询不到支付宝授权信息	(E24)查询不到支付宝授权信息
     E25	查询设备进件信息失败或未进件	(E25)查询设备进件信息失败或未进件
     E26	查询商户信息失败或商户信息不存在	(E26)查询商户信息失败或商户信息不存在
     E27	查询退款订单信息参数缺少	(E27)查询退款订单信息参数缺少
     E28	不是退款订单	(E28)退款订单无效，请重试
     E29	查询订单列表信息失败	(E29)查询订单列表信息失败
     E30	应用APPID填写错误	(E30)联系支付宝,确认APP_ID的状态
     E31	商户收款额度超限	(E31)收款额度超限，可联系支付宝95188提额
     E32	商户收款金额超过月限额	(E32)月收款额超限，联系支付宝95188提额
     E33	商家账号被冻结	(E33)商户账号被冻结，请咨询支付宝95188
     E34	二级商户信息创建失败	(E34)商户信息有误，请检查商户信息是否有效
     E35	二级商户类型非法	(E35)商户类型不合规，请检查商户信息是否有效
     E36	商户协议状态非正常状态	(E36)商户与支付宝的合同非正常状态
     E37	请求退款的交易被冻结	(E37)退款交易被冻结，联系支付宝确认
     E38	交易已完结	(E38)交易已完结无法退款，请确认退款交易信息是否正确
     E39	当前交易不允许退款	(E39)退款失败，请检查交易是否成功或商户是否支持退款
     D01	系统错误	（如果当前为支付交易POS无需显示，此返回码仅为状态，可调用查询订单API，查询当前订单的状态）
     D02	记录订单号失败	如果当前为退款或查询交易，pos显示：系统错误，请重试
     D03	原交易已撤销	(D03)原交易已撤销，请确认后重试
     D04	订单已关闭	(D04)订单已关闭，请重新发起交易
     D05	订单已支付	(D05)订单已支付
     D06	订单已撤销	(D06)订单已撤销
     D07	用户支付中	(D07)用户支付中，需要输入密码
     D08	订单未支付	(D08)订单未支付
     D09	订单支付失败	(D09)订单支付失败
     D10	订单异常	(D10)订单异常
     D11	订单号重复	(D11)订单号重复
     D12	记录订单号失败	(D12)记录订单号失败
     D13	更新订单号信息失败	(D13)更新订单号信息失败
     D14	查询不到订单信息	(D14)查询不到订单信息
     D15	记录退款信息失败	(D15)记录退款信息失败
     D16	更新退款信息失败	(D16)更新退款信息失败
     D17	查询总额失败（包含收款，退款，交易统计等）	(D17)总额查询失败，请稍后重试
     D18	订单信息有误	(D18)订单信息有误，请修改后重试
     S01	系统错误	(S01)系统错误
     S02	未知错误	(S02)未知错误
     S03	系统异常	(S03)系统异常
     S04	未开通支付通道	未开户！1. 您可尝试在设置内更新终端参数 2. 联系您的供货商确认是否开通支付服务，或咨询客服4009021168
     C01	参数下载失败	(C01)参数下载失败
     F01	交易超时	(F01)交易超时，请重试
     F02	系统异常	(F02)系统异常
     F03	请求支付宝支付接口失败	(F03)请求支付宝支付接口失败
     F04	请求支付宝退款接口失败	(F04)请求支付宝退款接口失败
     F05	请求支付宝订单详情接口失败	(F05)请求支付宝订单详情接口失败
     F06	请求支付宝退款详情接口失败	(F06)请求支付宝退款详情接口失败
     F07	请求盛付通支付接口失败	(F07)请求盛付通支付接口失败
     F08	交易异常，联系收单行或发卡行	(F08)交易异常，联系收单行或发卡行
     B00	调用成功	成功
     Q01	网络异常	网络异常
     Q02	网络超时	网络超时
     Q03	参数异常	参数异常
     Q04	服务器异常	服务器异常
     Q05	网络异常	网络异常
     Q06	请求取消	请求取消
     Q07	网络或服务器异常	网络或服务器异常，请重试
     Q08	交易取消	交易取消
     Q09	请求正在处理中	请求正在处理中
     Q10	功能暂不支持	功能暂不支持
     Q11	交易超时	交易超时
     Q12	支付宝人脸未授权	未授权，请打开商米收银台完成人脸授权后重试
     Q13	人脸支付手机号无效	无效的手机号，请重新输入
     Q14	收银台程序被关闭，交易状态未知	收银台服务已终止，您可通过查询接口获取交易状态
     Q15	未安装人脸支付组件	人脸支付服务未安装，请安装后重试
     Q16	打印机异常	打印机异常，请检查
     Q17	调用权限不足	调用权限不足
     Q18	取消交易成功
     Q19	取消交易失败	取消失败
     */
}