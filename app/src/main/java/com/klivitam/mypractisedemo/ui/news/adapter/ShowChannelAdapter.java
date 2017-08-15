package com.klivitam.mypractisedemo.ui.news.adapter;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

import com.jiangkunbo.common.recylerview.CommonRecycleViewAdapter;
import com.jiangkunbo.common.recylerview.ItemDragHelperCallback;
import com.jiangkunbo.common.recylerview.ViewHolderHelper;
import com.jiangkunbo.common.widgets.OnNoDoubleClickListener;
import com.klivitam.mypractisedemo.R;

import java.util.Collections;

/**
 * Created by Administrator on 2017/8/12.
 */

public class ShowChannelAdapter extends CommonRecycleViewAdapter<String> implements
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
    public void convert(final ViewHolderHelper helper, String s) {
        helper.setText(R.id.news_channel_tv, s);
        if (s != null && mItemDragHelperCallback != null) {
            helper.itemView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    mItemDragHelperCallback.setLongPressEnabled(true);
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
