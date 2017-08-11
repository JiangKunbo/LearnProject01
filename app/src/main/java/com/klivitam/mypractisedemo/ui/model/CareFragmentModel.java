package com.klivitam.mypractisedemo.ui.model;

import android.content.Context;

import com.klivitam.mypractisedemo.ui.imp.ICareContract;
import com.klivitam.mypractisedemo.ui.present.CareFragmentPresent;

/**
 * Created by klivitam on 17-8-10.
 */

public class CareFragmentModel implements ICareContract.Model {
    private Context context;
    private CareFragmentPresent present;

    public CareFragmentModel(CareFragmentPresent present, Context context) {
        this.context = context;
        this.present = present;
    }
}
