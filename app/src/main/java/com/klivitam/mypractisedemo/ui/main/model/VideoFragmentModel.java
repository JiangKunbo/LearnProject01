package com.klivitam.mypractisedemo.ui.main.model;

import android.content.Context;

import com.klivitam.mypractisedemo.ui.main.imp.IVideoContract;
import com.klivitam.mypractisedemo.ui.main.present.VideoFragmentPresent;

/**
 * Created by klivitam on 17-8-10.
 */

public class VideoFragmentModel implements IVideoContract.Model {
    private Context context;
    private VideoFragmentPresent present;

    public VideoFragmentModel(VideoFragmentPresent present, Context context) {
        this.context = context;
        this.present = present;
    }
}
