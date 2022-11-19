package com.fly.ayudaconfiable.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fly.ayudaconfiable.R;
import com.fly.ayudaconfiable.adapter.InitialCountingAdapter;
import com.fly.ayudaconfiable.bean.event.HttpEvent;
import com.fly.ayudaconfiable.bean.response.ProtocolLinkBeanResponse;
import com.fly.ayudaconfiable.databinding.ActivityInitialCountingBinding;
import com.fly.ayudaconfiable.network.HttpClient;
import com.fly.ayudaconfiable.network.bean.HttpErrorBean;
import com.fly.ayudaconfiable.network.bean.HttpResponse;
import com.fly.ayudaconfiable.network.net.NetStateReceiver;
import com.fly.ayudaconfiable.network.net.http.response.ShowGoodsBean;
import com.fly.ayudaconfiable.observer.ObserverManager;
import com.fly.ayudaconfiable.utils.LogUtils;
import com.fly.ayudaconfiable.utils.SoftKeyboardUtils;
import com.fly.ayudaconfiable.utils.StatusBarUtil;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
import kotlin.jvm.functions.Function1;

public class InitialCountingActivity extends BaseActivity<ActivityInitialCountingBinding> {

    String TAG = "NewPackage";
    Toolbar toolbar;
    RecyclerView recyclerView;

    private List<ShowGoodsBean> addedGoods ;
    private InitialCountingAdapter recycleAdapter = null;

    public InitialCountingActivity(@NonNull Function1 inflate) {
        super(inflate);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_counting);
        initview();
        HttpEvent.INSTANCE.getSunmi();
        NetStateReceiver.getInstance().saveOrderNo("69225465");
        ObserverManager.getManager().registerObserver(observerIntent -> {
            recycleAdapter.notifyDataSetChanged();
        });
    }
    protected View initToolbar(Toolbar toolbar) {
        View mToolbarView = null;
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowCustomEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(false);
            mToolbarView = getLayoutInflater().inflate(R.layout.universalhead, null);
            Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            getSupportActionBar().setCustomView(mToolbarView, layoutParams);
            LinearLayout finsh = mToolbarView.findViewById(R.id.ll_finsh_op);
            /***左上角返回 **/
            finsh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SoftKeyboardUtils.hideSoftKeyboard(InitialCountingActivity.this);
                }
            });
        }
        //imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        StatusBarUtil.setGradientColor(this, toolbar);
        return mToolbarView;
    }

    private void initview() {

        View toolbarview = initToolbar(toolbar);
        TextView title = toolbarview.findViewById(R.id.title);
        title.setText("初始化计次项目");

        LinearLayout layout = toolbarview.findViewById(R.id.right_lay_two);
        ImageView imageView = toolbarview.findViewById(R.id.right_img_two);
        layout.setVisibility(View.VISIBLE);
        imageView.setImageResource(R.mipmap.add);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(InitialCountingActivity.this, StartActivity.class),140);
            }
        });

        recycleAdapter = new InitialCountingAdapter(this, addedGoods);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        //设置为垂直布局，这也是默认的
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        //设置Adapter
        recyclerView.setAdapter(recycleAdapter);
        //设置分隔线
        //recyclerView.addItemDecoration( new DividerGridItemDecoration(this));

        recycleAdapter.notifyDataSetChanged();
        HttpClient.getInstance().httpService
                .getSunmi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new HttpResponse<ProtocolLinkBeanResponse>(){
                    @Override
                    public void businessSuccess(@NonNull ProtocolLinkBeanResponse data) {
                        LogUtils.d("  成功了 ");
                        recycleAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void businessFail(int statusCode, @NonNull HttpErrorBean httpErrorBean) {

                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        LogUtils.v("  requestCode: " + requestCode + "   resultCode: " + resultCode);

        recycleAdapter.notifyDataSetChanged();
    }

    @Override
    public void initView() {
    }
}
