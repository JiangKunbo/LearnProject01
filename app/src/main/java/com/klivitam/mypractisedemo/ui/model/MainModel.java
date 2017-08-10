package com.klivitam.mypractisedemo.ui.model;

import android.content.Context;

import com.klivitam.mypractisedemo.ui.imp.IMainContract;
import com.klivitam.mypractisedemo.ui.present.MainPresent;

/**
 * Created by klivitam on 17-8-10.
 */

public class MainModel implements IMainContract.Model {
    private Context context;
    private MainPresent present;

    public MainModel(MainPresent present,Context context) {
        this.context = context;
        this.present = present;
    }
}
