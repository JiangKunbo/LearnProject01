package com.klivitam.mypractisedemo.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.klivitam.mypractisedemo.R;
import com.klivitam.mypractisedemo.bean.NewChannelBean;

import java.util.List;

/**
 * Created by klivitam on 17-8-12.
 */

public class HomeNewListAdapter extends RecyclerView.Adapter<HomeNewListAdapter.ViewHelper> {
    private List<NewChannelBean> lists;

    public HomeNewListAdapter() {
    }

    public void setLists(List<NewChannelBean> lists) {
        this.lists = lists;
    }

    @Override
    public ViewHelper onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHelper(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHelper holder, int position) {

    }

    @Override
    public int getItemCount() {
        return (null != lists) && (lists.size() > 0) ? lists.size() : 0;
    }

    class ViewHelper extends RecyclerView.ViewHolder {

        public ViewHelper(View itemView) {
            super(itemView);
        }
    }
}
