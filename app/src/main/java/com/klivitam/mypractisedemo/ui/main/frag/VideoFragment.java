package com.klivitam.mypractisedemo.ui.main.frag;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.jiangkunbo.common.base.BaseFragment;
import com.jiangkunbo.common.base.BaseFragmentAdapter;
import com.klivitam.mypractisedemo.R;
import com.klivitam.mypractisedemo.bean.VideoChannelTable;
import com.klivitam.mypractisedemo.ui.main.imp.IVideoContract;
import com.klivitam.mypractisedemo.ui.main.present.VideoFragmentPresent;
import com.klivitam.mypractisedemo.ui.video.frag.VideoItemsFragment;
import com.klivitam.mypractisedemo.utils.AppConfig;
import com.klivitam.mypractisedemo.utils.TabUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by klivitam on 17-8-10.
 */

public class VideoFragment extends BaseFragment<IVideoContract.Present> implements IVideoContract.View {
    @BindView(R.id.tabs1)
    TabLayout tabs;
    @BindView(R.id.view_pager1)
    ViewPager viewPager;
    private BaseFragmentAdapter fragmentAdapter;
    @Override
    protected void initEventandDatas(Bundle savedInstanceState) {

    }

    @Override
    protected IVideoContract.Present loadPresent() {
        return new VideoFragmentPresent();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video;
    }


    @Override
    public void initViews(List<VideoChannelTable> videoChannelTableList) {
        List<String> channelNames = new ArrayList<>();
        for (int i = 0; i < videoChannelTableList.size(); i++) {
            channelNames.add(videoChannelTableList.get(i).getChannelName());
        }
        fragmentAdapter = new BaseFragmentAdapter(getChildFragmentManager(), getFragmentList(videoChannelTableList), channelNames);
        viewPager.setAdapter(fragmentAdapter);
        tabs.setupWithViewPager(viewPager);
        TabUtils.dynamicSetTabLayoutMode(tabs);
        setPageChangeListener();

    }

    private void setPageChangeListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private Fragment createListFragments(VideoChannelTable videoChannelTable) {
        Fragment fragment = new VideosFragment();
        Bundle bundle = new Bundle();
        bundle.putString(AppConfig.VIDEO_TYPE, videoChannelTable.getChannelId());
        fragment.setArguments(bundle);
        return fragment;
    }
    private List<Fragment> getFragmentList(List<VideoChannelTable> list1) {
        List<Fragment> list = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            Fragment f = new VideoItemsFragment();
            Bundle bundle = new Bundle();
            bundle.putString(AppConfig.VIDEO_TYPE,list1.get(i).getChannelId());
            f.setArguments(bundle);
            list.add(f);
        }
        return list;
    }
}
