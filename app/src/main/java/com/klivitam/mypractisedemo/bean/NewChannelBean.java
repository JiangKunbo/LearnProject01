package com.klivitam.mypractisedemo.bean;

import java.io.Serializable;

/**
 * Created by klivitam on 17-8-12.
 */

public class NewChannelBean implements Serializable {
    private String channelId;
    private String channelName;
    private boolean channelSelect;
    private String channelType;

    public NewChannelBean(String channelId, String channelName, boolean channelSelect, String channelType) {
        this.channelId = channelId;
        this.channelName = channelName;
        this.channelSelect = channelSelect;
        this.channelType = channelType;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public boolean isChannelSelect() {
        return channelSelect;
    }

    public void setChannelSelect(boolean channelSelect) {
        this.channelSelect = channelSelect;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }
}
