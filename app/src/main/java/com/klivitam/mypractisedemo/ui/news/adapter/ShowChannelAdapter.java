package com.klivitam.mypractisedemo.ui.news.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.MotionEvent;
import android.view.View;

import com.jiangkunbo.common.recylerview.CommonRecycleViewAdapter;
import com.jiangkunbo.common.recylerview.ItemDragHelperCallback;
import com.jiangkunbo.common.recylerview.ViewHolderHelper;
import com.jiangkunbo.common.widgets.OnNoDoubleClickListener;
import com.klivitam.mypractisedemo.R;
import com.klivitam.mypractisedemo.bean.NewChannelBean;

import java.util.Collections;

/**
 * Created by Administrator on 2017/8/12.
 */

public class ShowChannelAdapter extends CommonRecycleViewAdapter<NewChannelBean> implements
        ItemDragHelperCallback.OnItemMoveListener {

    private ItemDragHelperCallback mItemDragHelperCallback;
    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public void setItemDragHelperCallback(ItemDragHelperCallback itemDragHelperCallback) {
        mItemDragHelperCallback = itemDragHelperCallback;
    }

    public ShowChannelAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(getAll(), fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void convert(final ViewHolderHelper helper, final NewChannelBean s) {
        if (s != null && s.isChannelSelect()) {
            helper.setTextColor(R.id.news_channel_tv, ContextCompat.getColor(mContext, R.color.gray_deep));
        } else {
            helper.setTextColor(R.id.news_channel_tv, ContextCompat.getColor(mContext, R.color.gray));
        }
        helper.setText(R.id.news_channel_tv, s.getChannelName());
        if (mItemDragHelperCallback != null) {
            helper.itemView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (!s.isChannelSelect()) {
                        mItemDragHelperCallback.setLongPressEnabled(true);
                    } else {
                        mItemDragHelperCallback.setLongPressEnabled(false);
                    }
                    return false;
                }
            });
        }
        if (mOnItemClickListener != null) {
            helper.itemView.setOnClickListener(new OnNoDoubleClickListener() {
                @Override
                protected void onNoDoubleClick(View v) {
                    mOnItemClickListener.onItemClick(v, helper.getLayoutPosition());
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
