package com.klivitam.mypractisedemo.ui.model;

import android.content.Context;

import com.klivitam.mypractisedemo.ui.imp.IBeautiContract;
import com.klivitam.mypractisedemo.ui.present.BeautiFragmentPresent;

/**
 * Created by klivitam on 17-8-11.
 */

public class BeautiFragmentModel implements IBeautiContract.Model {
    private Context context;
    private BeautiFragmentPresent present;

    public BeautiFragmentModel(Context context, BeautiFragmentPresent present) {
        this.context = context;
        this.present = present;
    }
}
