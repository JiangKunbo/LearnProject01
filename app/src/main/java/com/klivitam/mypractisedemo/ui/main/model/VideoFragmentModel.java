package com.klivitam.mypractisedemo.ui.main.model;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

import com.klivitam.mypractisedemo.MyApplication;
import com.klivitam.mypractisedemo.R;
import com.klivitam.mypractisedemo.bean.VideoChannelTable;
import com.klivitam.mypractisedemo.ui.main.imp.IVideoContract;
import com.klivitam.mypractisedemo.ui.main.present.VideoFragmentPresent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by klivitam on 17-8-10.
 */

public class VideoFragmentModel implements IVideoContract.Model {

    @Override
    public List<VideoChannelTable> loadVideosChannelsMine() {
        List<String> channelName = Arrays.asList(MyApplication.getInstance().getResources().getStringArray(R.array.video_channel_name));
        List<String> channelId = Arrays.asList(MyApplication.getInstance().getResources().getStringArray(R.array.video_channel_id));
        ArrayList<VideoChannelTable>newsChannelTables=new ArrayList<>();
        for (int i = 0; i < channelName.size(); i++) {
            VideoChannelTable entity = new VideoChannelTable(channelId.get(i), channelName.get(i));
            newsChannelTables.add(entity);
        }
        return newsChannelTables;
    }
}
