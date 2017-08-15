package com.klivitam.mypractisedemo.ui.main.model;

import android.content.Context;

import com.klivitam.mypractisedemo.ui.main.imp.IBeautiContract;
import com.klivitam.mypractisedemo.ui.main.present.BeautiFragmentPresent;

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
