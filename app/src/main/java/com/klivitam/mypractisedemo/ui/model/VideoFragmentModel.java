package com.klivitam.mypractisedemo.ui.model;

import android.content.Context;

import com.klivitam.mypractisedemo.ui.imp.IVideoContract;
import com.klivitam.mypractisedemo.ui.present.VideoFragmentPresent;

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
