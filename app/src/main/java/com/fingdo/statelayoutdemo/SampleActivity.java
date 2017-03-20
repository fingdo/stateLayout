package com.fingdo.statelayoutdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.fingdo.statelayout.StateLayout;


/**
 * <pre>
 *     author : fingdo
 *     e-mail : fingdo@qq.com
 *     time   : 2017/03/10
 *     desc   : 测试StateLayout
 *     version: 1.0
 * </pre>
 */

public class SampleActivity extends AppCompatActivity implements View.OnClickListener {


    private StateLayout stateLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        stateLayout = (StateLayout) findViewById(R.id.state_layout);


        //提前设置
        //设置空数据提示文字
        //stateLayout.setTipText(StateLayout.EMPTY, "empty tip text");
        //stateLayout.setTipText(StateLayout.EMPTY, R.string.empty_tip);
        //空数据提示图标
        //stateLayout.setTipImg(StateLayout.EMPTY, R.drawable.ic_state_empty);
        //stateLayout.setTipImg(StateLayout.EMPTY, getResources().getDrawable(R.drawable.ic_state_empty));


        //展示内容的界面
//        stateLayout.showContentView();
        //展示加载中的界面
//        stateLayout.showLoadingView();

        //展示没有网络的界面
//        stateLayout.showNoNetworkView();
        //展示超时的界面
//        stateLayout.showTimeoutView();
        //展示空数据的界面
//        stateLayout.showEmptyView();
        //展示错误的界面
//        stateLayout.showErrorView();
        //展示登录的界面
//        stateLayout.showLoginView();


        //显示加载界面
//        stateLayout.showLoadingView();

        //显示自定义界面
//        stateLayout.showCustomView();





        stateLayout.setUseAnimation(true);
//        stateLayout.setViewSwitchAnimProvider(new FadeScaleViewAnimProvider());
        stateLayout.setRefreshListener(new StateLayout.OnViewRefreshListener() {
            @Override
            public void refreshClick() {
                Toast.makeText(SampleActivity.this, R.string.toast_refresh, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void loginClick() {
                Toast.makeText(SampleActivity.this, R.string.toast_sign_in, Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btn_content).setOnClickListener(this);
        findViewById(R.id.btn_empty).setOnClickListener(this);
        findViewById(R.id.btn_error).setOnClickListener(this);
        findViewById(R.id.btn_loading).setOnClickListener(this);
        findViewById(R.id.btn_time_out).setOnClickListener(this);
        findViewById(R.id.btn_not_network).setOnClickListener(this);
        findViewById(R.id.btn_login).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_content:
                stateLayout.showContentView();
//                stateLayout.setTipText(StateLayout.EMPTY, "12345");
//                stateLayout.setTipImg(StateLayout.EMPTY, R.mipmap.ic_launcher);
                break;
            case R.id.btn_empty:
                stateLayout.showEmptyView();
//                stateLayout.setTipText(StateLayout.ERROR, "12345");
//                stateLayout.setTipImg(StateLayout.ERROR, R.mipmap.ic_launcher);
                break;
            case R.id.btn_error:
                stateLayout.showErrorView();
//                stateLayout.setTipText(StateLayout.LOADING, "12345");
                break;
            case R.id.btn_loading:
                stateLayout.showLoadingView();
//                stateLayout.setTipText(StateLayout.TIMEOUT, "12345");
//                stateLayout.setTipImg(StateLayout.TIMEOUT, R.mipmap.ic_launcher);
                break;
            case R.id.btn_time_out:
                stateLayout.showTimeoutView();
//                stateLayout.setTipText(StateLayout.NOT_NETWORK, "12345");
//                stateLayout.setTipImg(StateLayout.NOT_NETWORK, R.mipmap.ic_launcher);
                break;
            case R.id.btn_not_network:
                stateLayout.showNoNetworkView();
                break;
            case R.id.btn_login:
                stateLayout.showLoginView();
                break;
        }
    }
}
