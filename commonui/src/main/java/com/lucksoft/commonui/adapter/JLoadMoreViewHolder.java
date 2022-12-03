package com.lucksoft.commonui.adapter;

import android.view.View;
import android.widget.TextView;

import com.lucksoft.commonui.R;
import com.lucksoft.commonui.databinding.LoadMoreLayoutBinding;

import androidx.annotation.NonNull;

public class JLoadMoreViewHolder extends JViewHolder<LoadMoreBean, LoadMoreLayoutBinding> {

    public JLoadMoreViewHolder(@NonNull LoadMoreLayoutBinding itemView) {
        super(itemView);
    }

    public void bindLoadMoreHolder(LoadMoreBean loadMoreBean, JMultiTypeHFLAdapter.LoadMoreViewHolderDelegate loadMoreViewHolderDelegate) {
        if (loadMoreBean == null || loadMoreBean.getState() == null) {
            return;
        }
        switch (loadMoreBean.getState()) {
            case NONE:
                binding.loadMoreContainer.setVisibility(View.GONE);
                break;
            case LOADING:
                binding.loadMoreContainer.setVisibility(View.VISIBLE);
                binding.loadMoreProgress.setVisibility(View.VISIBLE);
                binding.loadMoreNoMore.setVisibility(View.INVISIBLE);
                ((TextView) itemView.findViewById(R.id.load_more_text)).setText(itemView.getResources().getString(R.string.loading));
                break;
            case LOADED_ERROR:
                binding.loadMoreContainer.setVisibility(View.VISIBLE);
                binding.loadMoreProgress.setVisibility(View.INVISIBLE);
                binding.loadMoreNoMore.setVisibility(View.VISIBLE);
                binding.loadMoreNoMore.setImageResource(R.drawable.common_load_more_error);
                binding.loadMoreText.setText(itemView.getResources().getString(R.string.load_error));
                break;
            case NO_MORE:
                binding.loadMoreContainer.setVisibility(View.VISIBLE);
                binding.loadMoreProgress.setVisibility(View.INVISIBLE);
                binding.loadMoreNoMore.setVisibility(View.INVISIBLE);
                binding.loadMoreNoMore.setImageResource(R.drawable.common_load_more_no_more);
                binding.loadMoreText.setText(itemView.getResources().getString(R.string.has_reach_bottom));
                break;
        }
        if (loadMoreViewHolderDelegate != null) {
            loadMoreViewHolderDelegate.invoker(this, loadMoreBean);
        }
    }
}
