package com.klivitam.mypractisedemo.base.recyer;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by klivitam on 17-8-12.
 */

public class BaseRecyerView extends RecyclerView.Adapter<BaseHelper> {


    @Override
    public BaseHelper onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(BaseHelper holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
