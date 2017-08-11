package com.klivitam.mypractisedemo.ui.model;

import android.content.Context;

import com.klivitam.mypractisedemo.ui.imp.IHomeNewsContract;
import com.klivitam.mypractisedemo.ui.present.HomeNewsFragmentPresent;

/**
 * Created by klivitam on 17-8-11.
 */

public class HomeNewFragmentModel implements IHomeNewsContract.Model {
    private Context context;
    private HomeNewsFragmentPresent present;

    public HomeNewFragmentModel(HomeNewsFragmentPresent present, Context context) {
        this.context = context;
        this.present = present;
    }
}
