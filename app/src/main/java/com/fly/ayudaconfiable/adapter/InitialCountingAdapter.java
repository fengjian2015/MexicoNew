package com.fly.ayudaconfiable.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.fly.ayudaconfiable.R;
import com.fly.ayudaconfiable.network.net.http.response.ShowGoodsBean;
import com.flyco.roundview.RoundRelativeLayout;

import java.util.List;

/**
 * nakesoft
 * Created by 孔明 on 2019年8月28日,0028.
 * 158045632@qq.com
 */
public class InitialCountingAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<ShowGoodsBean> slected;

    public InitialCountingAdapter(Context context, List<ShowGoodsBean> entityList) {
        this.mContext = context;
        this.slected = entityList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.select_good_in_package_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        final ShowGoodsBean item = slected.get(position);

        ViewHolder viewHolder = (ViewHolder) holder;
        boolean hasSet = false;
        ImageView imageView = viewHolder.ivGoodImg;
        String goodimg = item.getImages();
        if (TextUtils.isEmpty(goodimg)) {

        } else {
            if (goodimg.startsWith("/")) {
                hasSet = true;

                RequestOptions options = new RequestOptions();
                options.transforms(new CenterCrop(), new RoundedCorners(13));
                options.placeholder(R.mipmap.icon_goods);
                Glide.with(imageView).load(goodimg).apply(options).into(imageView);
            }
        }

        if (!hasSet) {
            imageView.setImageResource(R.mipmap.icon_goods);
        }

        viewHolder.tvGoodName.setText(item.getGoodsName());
        viewHolder.tvGoodUnitPrice.setText(Double.toString(item.getPrice()));
        viewHolder.tvGoodStockNum.setText(Double.toString(item.getCurrentQuantity()));

        if (item.getGoodsType() == 1) {
            viewHolder.tvGoodType.setText("普通类商品");
        } else if (item.getGoodsType() == 2) {
            viewHolder.tvGoodType.setText("服务类商品");
        }

        viewHolder.shopAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.setCurrentQuantity(item.getCurrentQuantity() + 1);
                notifyDataSetChanged();
            }
        });
        viewHolder.shopDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item.getCurrentQuantity() == 1) {
                    item.setCurrentQuantity(0);
                    slected.remove(holder.getAdapterPosition());
                } else {
                    item.setCurrentQuantity(item.getCurrentQuantity() - 1);
                }
                notifyDataSetChanged();
            }
        });
        viewHolder.shopSize.setText(Double.toString(item.getCurrentQuantity()));
    }

    @Override
    public int getItemCount() {
        if (slected == null) {
            return 0;
        } else {
            return slected.size();
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivGoodImg;
        TextView tvGoodName;
        TextView dj;
        TextView dw;
        TextView tvGoodUnitPrice;
        TextView dwText;
        TextView tvLableNum;
        TextView tvGoodStockNum;
        TextView lbText;
        TextView tvGoodType;
        ImageView shopDel;
        TextView shopSize;
        ImageView shopAdd;
        RoundRelativeLayout linearLayout;

        ViewHolder(View view) {
            super(view);
            ivGoodImg = view.findViewById(R.id.iv_good_img);
            tvGoodName = view.findViewById(R.id.tv_good_name);
            dj = view.findViewById(R.id.dj);
            dw = view.findViewById(R.id.dw);
            tvGoodUnitPrice = view.findViewById(R.id.tv_good_unit_price);
            dwText = view.findViewById(R.id.dw_text);
            tvLableNum = view.findViewById(R.id.tv_lable_num);
            tvGoodStockNum = view.findViewById(R.id.tv_good_stock_num);
            lbText = view.findViewById(R.id.lb_text);
            tvGoodType = view.findViewById(R.id.tv_good_type);
            shopDel = view.findViewById(R.id.shop_del);
            shopSize = view.findViewById(R.id.shop_size);
            shopAdd = view.findViewById(R.id.shop_add);
            linearLayout = view.findViewById(R.id.linear_layout);

        }
    }
}
