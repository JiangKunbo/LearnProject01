package com.klivitam.mypractisedemo.ui.video.frag;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jiangkunbo.common.base.BaseFragment;
import com.jiangkunbo.common.recylerview.CommonRecycleViewAdapter;
import com.jiangkunbo.common.recylerview.ViewHolderHelper;
import com.klivitam.mypractisedemo.R;
import com.klivitam.mypractisedemo.bean.VideoDataBean;
import com.klivitam.mypractisedemo.ui.main.imp.IVideoContract;
import com.klivitam.mypractisedemo.ui.video.imp.IVideosItemContract;
import com.klivitam.mypractisedemo.ui.video.model.VideoItemModel;
import com.klivitam.mypractisedemo.ui.video.present.VideoItemPresent;
import com.klivitam.mypractisedemo.utils.AppConfig;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by klivitam on 17-8-28.
 */

public class VideoItemsFragment extends BaseFragment<IVideosItemContract.Present> implements IVideosItemContract.View {
    @BindView(R.id.refresh_layout)
    RefreshLayout mRefreshLayout;
    @BindView(R.id.list_news)
    RecyclerView mRecyclerView;
    private String mVideoType;
    private CommonRecycleViewAdapter<VideoDataBean> videoListAdapter;

    @Override
    protected void initEventandDatas(Bundle savedInstanceState) {
        if (getArguments() != null) {
            mVideoType = getArguments().getString(AppConfig.VIDEO_TYPE);
        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        videoListAdapter = new CommonRecycleViewAdapter<VideoDataBean>(getContext(), R.layout.item_video_list) {
            @Override
            public void convert(ViewHolderHelper helper, VideoDataBean videoData) {
                helper.setImageRoundUrl(R.id.iv_logo, videoData.getTopicImg());
                helper.setText(R.id.tv_from, videoData.getTopicName());
                helper.setText(R.id.tv_play_time, String.format(getResources().getString(R.string.video_play_times), String.valueOf(videoData.getPlayCount())));
                JCVideoPlayerStandard jcVideoPlayerStandard = helper.getView(R.id.videoplayer);
                boolean setUp = jcVideoPlayerStandard.setUp(
                        videoData.getMp4_url(),
                        JCVideoPlayer.SCREEN_LAYOUT_LIST,
                        "haha");
                if (setUp) {
                    Glide.with(mContext).load(videoData.getCover())
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .centerCrop()
                            .error(R.drawable.ic_empty_picture)
                            .crossFade().into(jcVideoPlayerStandard.thumbImageView);
                }
            }
        };
    }

    @Override
    protected IVideosItemContract.Present loadPresent() {
        return new VideoItemPresent();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_new;
    }
}
