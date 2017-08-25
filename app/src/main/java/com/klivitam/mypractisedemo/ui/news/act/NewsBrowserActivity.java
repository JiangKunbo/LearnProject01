package com.klivitam.mypractisedemo.ui.news.act;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toolbar;

import com.jiangkunbo.common.base.BaseActivity;
import com.klivitam.mypractisedemo.R;
import com.klivitam.mypractisedemo.ui.news.imp.INewsBrowerContract;
import com.klivitam.mypractisedemo.ui.news.present.NewsBroserPresent;
import com.klivitam.mypractisedemo.utils.AppConfig;

import butterknife.BindView;

import static com.klivitam.mypractisedemo.utils.AppConfig.NEWS_POST_ID;

/**
 * Created by klivitam on 17-8-25.
 */

public class NewsBrowserActivity extends BaseActivity<INewsBrowerContract.Present> implements INewsBrowerContract.View {
    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;
    @BindView(R.id.web_view)
    WebView mWebView;

    @Override
    protected void initEventandDatas(Bundle savedInstanceState) {
        initWebView();
    }

    @Override
    public void setWebView(String s) {
        Log.i("jkb", "setWebView: "+s);
        mWebView.loadUrl(s);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url != null) view.loadUrl(url);
                return true;
            }
        });
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    mProgressBar.setVisibility(View.GONE);
                } else {
                    mProgressBar.setVisibility(View.VISIBLE);
                    mProgressBar.setProgress(newProgress);
                }
            }
        });
    }

    private void initWebView() {
        WebSettings webSettings = mWebView.getSettings();
        // 打开页面时， 自适应屏幕
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        // 便页面支持缩放
        webSettings.setJavaScriptEnabled(true); //支持js
        webSettings.setSupportZoom(true); //支持缩放
//        webSettings.setBuiltInZoomControls(true); // 放大和缩小的按钮，容易引发异常 http://blog.csdn.net/dreamer0924/article/details/34082687

        webSettings.setAppCacheEnabled(true);
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
    }

    @Override
    protected INewsBrowerContract.Present loadPresent() {
        return new NewsBroserPresent();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_news_detail_web;
    }

    @Override
    protected void onDestroy() {
        if (mWebView != null) {
            mWebView.removeAllViews();
            mWebView.destroy();
        }
        super.onDestroy();
    }

    @Override
    public String getPostId() {
        return getIntent().getStringExtra(NEWS_POST_ID);
    }
}
