package com.klivitam.mypractisedemo.base.recyer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by klivitam on 17-8-12.
 */

public class BaseHelper extends RecyclerView.ViewHolder {
    private SparseArray<View> mViews;
    private View mConvertViews;
    private Context context;
    public BaseHelper(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
