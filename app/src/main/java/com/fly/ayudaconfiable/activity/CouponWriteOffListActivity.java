package com.fly.ayudaconfiable.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fly.ayudaconfiable.R;
import com.fly.ayudaconfiable.adapter.CouponWriteOffListAdapter;
import com.fly.ayudaconfiable.bean.event.HttpEvent;
import com.fly.ayudaconfiable.bean.response.IpResponse;
import com.fly.ayudaconfiable.network.HttpClient;
import com.fly.ayudaconfiable.network.bean.HttpErrorBean;
import com.fly.ayudaconfiable.network.bean.HttpResponse;
import com.fly.ayudaconfiable.network.net.http.InterfaceMethods;
import com.fly.ayudaconfiable.network.net.http.NetClient;
import com.fly.ayudaconfiable.network.net.http.TestInterfaces;
import com.fly.ayudaconfiable.network.net.http.response.BaseResult;
import com.fly.ayudaconfiable.network.net.http.response.CommResponse;
import com.fly.ayudaconfiable.network.net.http.response.MemCouponBean;
import com.fly.ayudaconfiable.observer.ObserverManager;
import com.fly.ayudaconfiable.utils.LogUtils;
import com.fly.ayudaconfiable.utils.SoftKeyboardUtils;
import com.fly.ayudaconfiable.utils.StatusBarUtil;
import com.fly.ayudaconfiable.utils.ToastUtil;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
import kotlin.jvm.functions.Function1;

public class CouponWriteOffListActivity extends BaseActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    SmartRefreshLayout refreshLayout;

    List<MemCouponBean> writeOffListBeans = new ArrayList<>();
    CouponWriteOffListAdapter couponWriteOffListAdapter = null;

    private String searhInput = "";

    public CouponWriteOffListActivity(@NonNull Function1 inflate) {
        super(inflate);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_couponlist);
        toolbar =findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recy);
        refreshLayout =findViewById(R.id.refreshLayout);
        searhInput = getIntent().getStringExtra("searchInput");
        if(TextUtils.isEmpty(searhInput)){
            ToastUtil.show("未获取到内容");
            return;
        }
        TestInterfaces.getInstance().getActivityList();
        iniview();
        HttpEvent.INSTANCE.getCOS();
    }

    private void iniview() {
        View toolbarview = initToolbar(toolbar);
        TextView title = toolbarview.findViewById(R.id.title);
        title.setText("优惠券核销");

        couponWriteOffListAdapter = new CouponWriteOffListAdapter(R.layout.couponwriter_item, writeOffListBeans);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(couponWriteOffListAdapter);

        couponWriteOffListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if(view.getId() == R.id.rtv_write_off){
                    if(position != -1 && position < writeOffListBeans.size()){
                        writeOffCoupon(writeOffListBeans.get(position).getConponCode());
                        ObserverManager.getManager().sendNotify(new Intent());
                    }
                }
            }
        });

        getConponListPage(searhInput);
    }

    protected View initToolbar(Toolbar toolbar) {
        View mToolbarView = null;
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowCustomEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(false);
            mToolbarView = getLayoutInflater().inflate(R.layout.universalhead, null);
            getSupportActionBar().setCustomView(mToolbarView);
            LinearLayout finsh = mToolbarView.findViewById(R.id.ll_finsh_op);
            /***左上角返回 **/
            finsh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SoftKeyboardUtils.hideSoftKeyboard(CouponWriteOffListActivity.this);
                }
            });
        }
        //imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        StatusBarUtil.setGradientColor(this, toolbar);
        return mToolbarView;
    }

    /**
     *{Page:1,Rows:10,MemID:"",ConponCode:"",UseType:"1"} UseType 使用类型：1 核销( ConponCode 传入卡号或券码) 2消费选择(MemID 必传)
     */
    public void getConponListPage(String coupon) {
        Map<String, String> params = new HashMap<String, String>();

        params.put("ConponCode", coupon);
        params.put("UseType", "1");

        params.put("Page", "1");
        params.put("Rows", "40");
        HttpClient.getInstance().httpService
                .getCOS()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new HttpResponse<IpResponse>(){
                            @Override
                            public void businessSuccess(@NonNull IpResponse data) {
                                LogUtils.d("  成功了 ");
                            }

                            @Override
                            public void businessFail(int statusCode, @NonNull HttpErrorBean httpErrorBean) {

                            }
                        });

        NetClient.postJsonAsyn(InterfaceMethods.GetConponLogListPage, params, new NetClient.ResultCallback<BaseResult<CommResponse<MemCouponBean>, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<CommResponse<MemCouponBean>, String, String> result) {
                LogUtils.d("  成功了 ");
                if (result != null && result.getData() != null) {
                    if (result.getData().getTotal() > 0) {
                        writeOffListBeans.addAll(result.getData().getList());
                    }
                } else {
                    refreshLayout.finishLoadMoreWithNoMoreData();
                }
                if (writeOffListBeans.size() == 0) {
                    ToastUtil.show("未找到相应的优惠券");
                }
                couponWriteOffListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(int statusCode, String message) {
                refreshLayout.finishLoadMoreWithNoMoreData();
                ToastUtil.show(message);
                startActivity(new Intent(CouponWriteOffListActivity.this,InitialCountingActivity.class));
            }
        });
    }

    //{ConponCode:""} 券码
    private void writeOffCoupon(String writeoffCode) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("ConponCode", writeoffCode);
        NetClient.postJsonAsyn(InterfaceMethods.WriteOffCoupon, params, new NetClient.ResultCallback<BaseResult<String, String, String>>() {
            @Override
            public void onSuccess(int statusCode, BaseResult<String, String, String> result) {
                LogUtils.d("  成功了 ");
                ToastUtil.show("核销成功");
            }

            @Override
            public void onFailure(int statusCode, String message) {
                ToastUtil.show(message);
            }
        });
    }

    @Override
    public void initView() {

    }
}
