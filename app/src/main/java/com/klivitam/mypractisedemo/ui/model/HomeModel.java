package com.klivitam.mypractisedemo.ui.model;

import android.content.Context;

import com.klivitam.mypractisedemo.base.imp.IContract;
import com.klivitam.mypractisedemo.ui.imp.IHomeContract;
import com.klivitam.mypractisedemo.ui.present.HomePresent;

/**
 * Created by klivitam on 17-8-10.
 */

public class HomeModel implements IHomeContract.Model {
    private Context context;
    private HomePresent present;

    public HomeModel(HomePresent present,Context context) {
        this.context = context;
        this.present = present;
    }
}
