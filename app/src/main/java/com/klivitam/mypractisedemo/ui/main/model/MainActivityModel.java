package com.klivitam.mypractisedemo.ui.main.model;

import android.content.Context;

import com.klivitam.mypractisedemo.ui.main.imp.IMainContract;
import com.klivitam.mypractisedemo.ui.main.present.MainActivityPresent;

/**
 * Created by klivitam on 17-8-10.
 */

public class MainActivityModel implements IMainContract.Model {
    private Context context;
    private MainActivityPresent present;

    public MainActivityModel(MainActivityPresent present, Context context) {
        this.context = context;
        this.present = present;
    }
}
