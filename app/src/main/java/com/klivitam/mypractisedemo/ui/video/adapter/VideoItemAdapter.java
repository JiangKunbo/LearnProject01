package com.klivitam.mypractisedemo.ui.video.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.klivitam.mypractisedemo.R;
import com.klivitam.mypractisedemo.bean.VideoDataBean;

import java.util.List;

/**
 * Created by klivitam on 17-8-28.
 */

public class VideoItemAdapter extends RecyclerView.Adapter<VideoItemAdapter.ViewHelper> {
    private List<VideoDataBean> list;

    public void setList(List<VideoDataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public ViewHelper onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHelper(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_videos,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHelper holder, int position) {

    }

    @Override
    public int getItemCount() {
        return (null != list) && (list.size() > 0) ? list.size() : 0;
    }

    class ViewHelper extends RecyclerView.ViewHolder {

        public ViewHelper(View itemView) {
            super(itemView);
        }
    }
}
