package com.klivitam.mypractisedemo.ui.model;

import android.content.Context;

import com.klivitam.mypractisedemo.ui.imp.IHomeContract;
import com.klivitam.mypractisedemo.ui.present.HomeFragmentPresent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by klivitam on 17-8-10.
 */

public class HomeFragmentModel implements IHomeContract.Model {
    private Context context;
    private HomeFragmentPresent present;

    public HomeFragmentModel(HomeFragmentPresent present, Context context) {
        this.context = context;
        this.present = present;
    }

    @Override
    public List<String> loadTabList() {
        List<String> s = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            s.add("列表"+i);
        }
        return s;
    }
}
