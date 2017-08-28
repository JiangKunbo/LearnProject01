package com.klivitam.mypractisedemo.bean;

/**
 * Created by klivitam on 17-8-28.
 */

public class VideoChannelTable {
    private String channelId;
    private String channelName;

    public VideoChannelTable(String channelId,String channelName){
        this.channelId=channelId;
        this.channelName=channelName;
    }
    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}