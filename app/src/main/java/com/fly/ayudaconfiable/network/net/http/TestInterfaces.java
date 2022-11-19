package com.fly.ayudaconfiable.network.net.http;


import com.fly.ayudaconfiable.network.net.http.response.BaseResult;
import com.fly.ayudaconfiable.network.net.http.response.BindMemLeveBean;
import com.fly.ayudaconfiable.network.net.http.response.ConsumeOrderListBean;
import com.fly.ayudaconfiable.network.net.http.response.CustomFieldBean;
import com.fly.ayudaconfiable.network.net.http.response.GoodsByIdBean;
import com.fly.ayudaconfiable.network.net.http.response.GoodsClassBean;
import com.fly.ayudaconfiable.network.net.http.response.GoodsListBean;
import com.fly.ayudaconfiable.network.net.http.response.MasterInfoBean;
import com.fly.ayudaconfiable.network.net.http.response.MemCardBean;
import com.fly.ayudaconfiable.network.net.http.response.MemLevelManageBean;
import com.fly.ayudaconfiable.network.net.http.response.RecommendedSetBean;
import com.fly.ayudaconfiable.network.net.http.response.ShopBean;
import com.fly.ayudaconfiable.network.net.http.response.StaffClassBean;
import com.fly.ayudaconfiable.network.net.http.response.SysArgumentsBean;
import com.fly.ayudaconfiable.utils.LogUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * nakesoft
 * Created by 孔明 on 2019年7月10日,0010.
 * 158045632@qq.com
 */
public class TestInterfaces {

    private static volatile TestInterfaces singleton;

    private TestInterfaces() {}

    public static TestInterfaces getInstance() {
        if (singleton == null) {
            synchronized (TestInterfaces.class) {
                if (singleton == null) {
                    singleton = new TestInterfaces();
                }
            }
        }
        return singleton;
    }

    public void getShopList() {
        Map<String, String> params = new HashMap<String, String>();
        //params.put("CompCode", compCode);
        NetClient.postJsonAsyn(InterfaceMethods.GetShopList, params, new NetClient.ResultCallback<BaseResult<List<ShopBean>, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<List<ShopBean>, String, String> result) {
                LogUtils.d("  成功了 ");
                LogUtils.v("  个数 " + result.getData().size());
            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }

    public void getStaffClassList() {
        Map<String, String> params = new HashMap<String, String>();
        //params.put("CompCode", compCode);
        NetClient.postJsonAsyn(InterfaceMethods.GetStaffClassList, params, new NetClient.ResultCallback<BaseResult<List<StaffClassBean>, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<List<StaffClassBean>, String, String> result) {
                LogUtils.d("  成功了 ");

            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }

    public void getStaffList() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("ClassID", "123");
        NetClient.postJsonAsyn(InterfaceMethods.GetStaffList, params, new NetClient.ResultCallback<BaseResult<String, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<String, String, String> result) {
                LogUtils.d("  成功了 ");

            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }

    public void getActivityList() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("ActType", "3");
        NetClient.postJsonAsyn(InterfaceMethods.GetActivityList, params, new NetClient.ResultCallback<BaseResult<String, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<String, String, String> result) {
                LogUtils.d("  成功了 ");
                if(result.getData() == null) {
                    LogUtils.e("  数据为空 ");
                } else {
                    LogUtils.e("  数据不 为空 ");
                }
            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }

    public void getCustomFieldList() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("CustomType", "1");
        NetClient.postJsonAsyn(InterfaceMethods.GetCustomFieldList, params, new NetClient.ResultCallback<BaseResult<List<CustomFieldBean>, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<List<CustomFieldBean>, String, String> result) {
                LogUtils.d("  成功了 ");

            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }

    public void getMasterInfo() {
        Map<String, String> params = new HashMap<String, String>();
        //params.put("CompCode", compCode);
        NetClient.postJsonAsyn(InterfaceMethods.GetMasterInfo, params, new NetClient.ResultCallback<BaseResult<MasterInfoBean, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<MasterInfoBean, String, String> result) {
                LogUtils.d("  成功了 ");

            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }


    public void modifyMasterPassword() {
        Map<String, String> params = new HashMap<String, String>();
        //params.put("CompCode", compCode);
        NetClient.postJsonAsyn(InterfaceMethods.ModifyMasterPassword, params, new NetClient.ResultCallback<BaseResult<String, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<String, String, String> result) {
                LogUtils.d("  成功了 ");

            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }

    public void getGoodsClassList() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("ParentID", "0");
        NetClient.postJsonAsyn(InterfaceMethods.GetGoodsClassList, params, new NetClient.ResultCallback<BaseResult<List<GoodsClassBean>, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<List<GoodsClassBean>, String, String> result) {
                LogUtils.d("  成功了 ");

            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }

    public void getServiceGoodsPage() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Page", "1");
        params.put("Rows", "10");
        params.put("Key", "");
        NetClient.postJsonAsyn(InterfaceMethods.GetServiceGoodsPage, params, new NetClient.ResultCallback<BaseResult<String, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<String, String, String> result) {
                LogUtils.d("  成功了 ");

            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }

    public void getGoodsById() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Id", "123");
        NetClient.postJsonAsyn(InterfaceMethods.GetGoodsByID, params, new NetClient.ResultCallback<BaseResult<GoodsByIdBean, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<GoodsByIdBean, String, String> result) {
                LogUtils.d("  成功了 ");

            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }

    public void bindMemLevelList() {
        Map<String, String> params = new HashMap<String, String>();
        //params.put("CompCode", compCode);
        NetClient.postJsonAsyn(InterfaceMethods.BindMemLevelList, params, new NetClient.ResultCallback<BaseResult<List<BindMemLeveBean>, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<List<BindMemLeveBean>, String, String> result) {
                LogUtils.d("  成功了 ");

            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }

    public void getMemLevelList() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Page", "1");
        params.put("Rows", "20");
        NetClient.postJsonAsyn(InterfaceMethods.GetMemLevelList, params, new NetClient.ResultCallback<BaseResult<MemLevelManageBean, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<MemLevelManageBean, String, String> result) {
                LogUtils.d("  成功了 ");

            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }

    public void getMemLevelById() {
        Map<String, String> params = new HashMap<String, String>();
        //params.put("CompCode", compCode);
        NetClient.postJsonAsyn(InterfaceMethods.GetMemLevelByID, params, new NetClient.ResultCallback<BaseResult<String, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<String, String, String> result) {
                LogUtils.d("  成功了 ");

            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }


    public void saveMemLevel() {
        Map<String, String> params = new HashMap<String, String>();
        //params.put("CompCode", compCode);
        NetClient.postJsonAsyn(InterfaceMethods.SaveMemLevel, params, new NetClient.ResultCallback<BaseResult<String, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<String, String, String> result) {
                LogUtils.d("  成功了 ");

            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }

    public void deleteMemLevel() {
        Map<String, String> params = new HashMap<String, String>();
        //params.put("CompCode", compCode);
        NetClient.postJsonAsyn(InterfaceMethods.DeleteMemLevel, params, new NetClient.ResultCallback<BaseResult<String, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<String, String, String> result) {
                LogUtils.d("  成功了 ");

            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }

    public void saveClassDiscouontRulesList() {
        Map<String, String> params = new HashMap<String, String>();
        //params.put("CompCode", compCode);
        NetClient.postJsonAsyn(InterfaceMethods.SaveClassDiscountRulesList, params, new NetClient.ResultCallback<BaseResult<String, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<String, String, String> result) {
                LogUtils.d("  成功了 ");

            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }

    public void getRecommendedSet() {
        Map<String, String> params = new HashMap<String, String>();
        //params.put("CompCode", compCode);
        NetClient.postJsonAsyn(InterfaceMethods.GetRecommendedSet, params, new NetClient.ResultCallback<BaseResult<RecommendedSetBean, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<RecommendedSetBean, String, String> result) {
                LogUtils.d("  成功了 ");

            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }

    public void saveSysArguments() {
        Map<String, String> params = new HashMap<String, String>();
        //params.put("CompCode", compCode);
        NetClient.postJsonAsyn(InterfaceMethods.SaveSysArgument, params, new NetClient.ResultCallback<BaseResult<String, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<String, String, String> result) {
                LogUtils.d("  成功了 ");

            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }

    public void searchMemCardList() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("SearchCriteria", "123");
        params.put("Type", "0");
        params.put("Page", "1");
        params.put("Row", "20");

        NetClient.postJsonAsyn(InterfaceMethods.SearchMemCardList, params, new NetClient.ResultCallback<BaseResult<List<MemCardBean>, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<List<MemCardBean>, String, String> result) {
                LogUtils.d("  成功了 ");

            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }

    public void saveMemData() {
        Map<String, String> params = new HashMap<String, String>();
        //params.put("CompCode", compCode);
        NetClient.postJsonAsyn(InterfaceMethods.SaveMemberData, params, new NetClient.ResultCallback<BaseResult<String, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<String, String, String> result) {
                LogUtils.d("  成功了 ");

            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }

    public void deleteMemData() {
        Map<String, String> params = new HashMap<String, String>();
        //params.put("CompCode", compCode);
        NetClient.postJsonAsyn(InterfaceMethods.DeleteMemberData, params, new NetClient.ResultCallback<BaseResult<String, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<String, String, String> result) {
                LogUtils.d("  成功了 ");

            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }

    public void memChangeCardId() {
        Map<String, String> params = new HashMap<String, String>();
        //params.put("CompCode", compCode);
        NetClient.postJsonAsyn(InterfaceMethods.MemChangeCardID, params, new NetClient.ResultCallback<BaseResult<String, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<String, String, String> result) {
                LogUtils.d("  成功了 ");

            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }

    public void memUpadatePasswd() {
        Map<String, String> params = new HashMap<String, String>();
        //params.put("CompCode", compCode);
        NetClient.postJsonAsyn(InterfaceMethods.MemUpdatePassword, params, new NetClient.ResultCallback<BaseResult<String, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<String, String, String> result) {
                LogUtils.d("  成功了 ");

            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }

    public void MemPointAdjust() {
        Map<String, String> params = new HashMap<String, String>();
        //params.put("CompCode", compCode);
        NetClient.postJsonAsyn(InterfaceMethods.MemPointAdjust, params, new NetClient.ResultCallback<BaseResult<String, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<String, String, String> result) {
                LogUtils.d("  成功了 ");

            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }

    public void memLockSet() {
        Map<String, String> params = new HashMap<String, String>();
        //params.put("CompCode", compCode);
        NetClient.postJsonAsyn(InterfaceMethods.MemLockSet, params, new NetClient.ResultCallback<BaseResult<String, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<String, String, String> result) {
                LogUtils.d("  成功了 ");

            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }

    public void uploadImg() {
        Map<String, String> params = new HashMap<String, String>();
        //params.put("CompCode", compCode);
        /*
        NetClient.postJsonAsyn(InterfaceMethods.UploadImg, params, new NetClient.ResultCallback<BaseResult<String, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<String, String, String> result) {
                LogUtils.d("  成功了 ");

            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
        */
    }

    public void getSysArguments() {
        Map<String, String> params = new HashMap<>();
        NetClient.postJsonAsyn(InterfaceMethods.GetSysArgument, params, new NetClient.ResultCallback<BaseResult<SysArgumentsBean, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<SysArgumentsBean, String, String> result) {
                LogUtils.d("  成功了 ");

            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }

    public void RetrievePasswordSendCode() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Mobile", "15208885310");
        NetClient.postJsonAsyn(InterfaceMethods.RetrievePasswordSendCode, params, new NetClient.ResultCallback<BaseResult<String, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<String, String, String> result) {
                LogUtils.d("  成功了 ");
                //{"status":1,"code":"000000","msg":"发送成功","data":"4797"}
            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }

    public void checkValidataionCdoe() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Mobile", "15208885310");
        params.put("Code", "4797");
        NetClient.postJsonAsyn(InterfaceMethods.CheckValidationCode, params, new NetClient.ResultCallback<BaseResult<String, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<String, String, String> result) {
                LogUtils.d("  成功了 ");
                //{"status":1,"code":"000000","msg":"验证成功"}
            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }

    public void getGoodsListByPage() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Page", "1");
        params.put("Rows","20");
        params.put("Key", "");
        NetClient.postJsonAsyn(InterfaceMethods.GetGoodsListPage, params, new NetClient.ResultCallback<BaseResult<GoodsListBean, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<GoodsListBean, String, String> result) {
                LogUtils.d("  成功了 ");

            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }


    /***获取会员详情**/
    public void getMemDataByID() {
        Map<String, String> params = new HashMap<String, String>();
        //params.put("CompCode", compCode);
        NetClient.postJsonAsyn(InterfaceMethods.GetMemDataByID, params, new NetClient.ResultCallback<BaseResult<String, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<String, String, String> result) {
                LogUtils.d("  成功了 ");

            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }

    /***会员礼品兑换*/
    public void memRedeemGift() {
        Map<String, String> params = new HashMap<String, String>();
        //params.put("CompCode", compCode);
        NetClient.postJsonAsyn(InterfaceMethods.RedeemGift, params, new NetClient.ResultCallback<BaseResult<String, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<String, String, String> result) {
                LogUtils.d("  成功了 ");

            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }

    public void QuickConsume() {
        Map<String, String> params = new HashMap<String, String>();
        //params.put("CompCode", compCode);
        NetClient.postJsonAsyn(InterfaceMethods.QuickConsume, params, new NetClient.ResultCallback<BaseResult<String, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<String, String, String> result) {
                LogUtils.d("  成功了 ");

            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }

    /**消费订单 */
    public void getConsumeOrderList(){
        Map<String, String> params = new HashMap<String, String>();
        /**
         {"OrderType":订单类型,"BillCode":单据号,"CardCode":会员卡号、姓名、手机号,"Remark":备注,"RevokeState":撤单状态 0-未撤单、1-已撤掉,
         "PayMinQuota":实付金额-最小值,"PayMaxQuota":实付金额-最大值, "OptMinTime":消费金额-开始值,"OptMaxTime":消费金额-结束值,"Page":1,"Rows":20}
         */
        params.put("OrderType", "1");
        params.put("BillCode", "");
        params.put("CardCode", "");
        params.put("Remark", "");
        params.put("RevokeState", "0");
        params.put("PayMinQuota", "");
        params.put("PayMaxQuota", "");

        params.put("OptMinTime", "20190803000000");
        params.put("OptMaxTime", "20190803235959");

        params.put("Page", "1");
        params.put("Rows", "20");

        NetClient.postJsonAsyn(InterfaceMethods.GetConsumeOrderList, params, new NetClient.ResultCallback<BaseResult<ConsumeOrderListBean, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<ConsumeOrderListBean, String, String> result) {
                LogUtils.d("  成功了 ");

            }

            @Override
            public void onFailure(int statusCode, String message) {

            }
        });
    }
}
