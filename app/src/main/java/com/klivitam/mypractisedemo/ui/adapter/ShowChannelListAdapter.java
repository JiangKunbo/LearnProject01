package com.klivitam.mypractisedemo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.klivitam.mypractisedemo.R;
import com.klivitam.mypractisedemo.wdiget.ItemDragHelperCallback;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by klivitam on 17-8-12.
 */

public class ShowChannelListAdapter extends RecyclerView.Adapter<ShowChannelListAdapter.ViewHelper> implements ItemDragHelperCallback.OnItemMoveListener {
    private int layout_id = R.layout.item_list_channel;
    private List<String> mList;
    private ItemDragHelperCallback mItemDragHelperCallback;
    private OnItemListener onItemListener;

    public ShowChannelListAdapter() {
    }

    public void setOnItemListener(OnItemListener onItemListener) {
        this.onItemListener = onItemListener;
    }

    public void setItemDragHelperCallback(ItemDragHelperCallback itemDragHelperCallback) {
        mItemDragHelperCallback = itemDragHelperCallback;
    }

    public void setList(List<String> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override
    public ViewHelper onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHelper(LayoutInflater.from(parent.getContext()).inflate(layout_id, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHelper holder, int position) {
        if (null != mList.get(position)) {
            holder.mChannelTxt.setText(mList.get(position));
            holder.mChannelTxt.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    mItemDragHelperCallback.setLongPressEnabled(true);
                    return false;
                }
            });
            holder.mChannelTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemListener.OnItemClick(view,holder.getLayoutPosition());
                }
            });
        }
    }
    public void removeItem(int positon){
        mList.remove(positon);
        notifyDataSetChanged();

    }
    public void addItem(String positon){
        mList.add(positon);

    }

    @Override
    public int getItemCount() {
        return (null != mList) && mList.size() > 0 ? mList.size() : 0;
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mList, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    class ViewHelper extends RecyclerView.ViewHolder {
        @BindView(R.id.news_channel_tv)
        TextView mChannelTxt;

        public ViewHelper(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemListener {
        void OnItemClick(View view, int positopn);
    }
}
