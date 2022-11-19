package com.fly.ayudaconfiable.adapter;

import android.view.View;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fly.ayudaconfiable.R;
import com.fly.ayudaconfiable.network.net.http.response.MemCouponBean;
import com.fly.ayudaconfiable.utils.TimeUtil;

import java.util.List;

public class CouponWriteOffListAdapter  extends BaseQuickAdapter<MemCouponBean, BaseViewHolder> {
    public CouponWriteOffListAdapter(int layoutResId, @Nullable List<MemCouponBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MemCouponBean item) {
        helper.setText(R.id.tv_coupon_title, item.getTitle());
        //tv_left_value1 tv_left_value1 最左边 显示的
        //DiscountWay优惠方式：1-固定、2-随机、3-指定礼品、4-全免、5-减免部分
        /*
        int discountWay = item.getDiscountWay();
        switch (discountWay){
            case 1:
                helper.setText(R.id.tv_left_value2, Double.toString(item.getDiscountValue()));
                break;
            case 2:
                helper.setText(R.id.tv_left_value2, Double.toString(item.getDiscountValue()));
                break;
            case 3:
                helper.setText(R.id.tv_left_value1, Double.toString(item.getDiscountValue()));
                helper.setText(R.id.tv_left_value2, "折");
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                break;
        }
        */
        //helper.setText(R.id.tv_left_value2, Double.toString(item.getQuota()));

        //tv_coupon_type 类型 Category优惠卷类别1-代金券、2-折扣券、3-兑换券、4-运费券
        String category = "未知";
        int categoryType = item.getCategory();
        helper.getView(R.id.tv_left_value1).setVisibility(View.VISIBLE);
        switch (categoryType) {
            case 1:
                helper.setText(R.id.tv_left_value1, "¥");
                helper.setText(R.id.tv_left_value2, Double.toString(item.getQuota()));
                helper.setText(R.id.tv_left_value3, "");
                category = "代金券";
                break;
            case 2:
                helper.setText(R.id.tv_left_value1, "");
                helper.setText(R.id.tv_left_value2, String.format("%.1f", 10 * item.getQuota()));
                helper.setText(R.id.tv_left_value3, "折");
                category = "折扣券";
                break;
            case 3:
                category = "兑换券";
                helper.getView(R.id.tv_left_value1).setVisibility(View.GONE);
                helper.setText(R.id.tv_left_value2, "兑");
                helper.setText(R.id.tv_left_value3, "");
                break;
            case 4:
                category = "运费券";
                break;
            default:
                break;
        }
        helper.setText(R.id.tv_coupon_type, category);
        //tv_use_restrictions  ，使用 限制，使用类型：1-无门槛、2-满多少金额  WithUseAmount  满多少金额
        int useType = item.getUseType();
        if(useType == 1){
            helper.setText(R.id.tv_use_restrictions, "•无门槛");
        } else {//if(useType == 2)
            helper.setText(R.id.tv_use_restrictions, "•满" + Double.toString(item.getWithUseAmount()) + "元可用");
        }

        //ValidType 有效期类型：1-永久、2-时间范围、3-领券当日起N天、4-领券次日起N天
        String validTimeStr = "";
        int validType = item.getValidType();
        switch (validType){
            case 1:
                validTimeStr = "•永久有效";
                break;
            case 2:
            case 3://ValidDays 领券当日起N天
            case 4://领券次日起8天
                //ValidStartTime
                //有效期开始时间
                //bigint(20)
                //ValidEndTime
                //ValidEndTime
                //有效期结束时间
                String startTime = TimeUtil.getTime(item.getValidStartTime());
                String endTime = TimeUtil.getTime(item.getValidEndTime());
                validTimeStr = "•" + startTime + "至" + endTime;
                break;
            default:
                break;
        }
        // tv_effective_time 有效时间
        helper.setText(R.id.tv_effective_time, validTimeStr);

        helper.addOnClickListener(R.id.rtv_write_off);
        //LinearLayout opt = helper.getView(R.id.menu_lay);
        //LinearLayout recvAndWriteOff = helper.getView(R.id.ll_operates);
    }
}
