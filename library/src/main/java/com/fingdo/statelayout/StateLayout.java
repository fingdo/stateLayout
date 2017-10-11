package com.fingdo.statelayout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.fingdo.statelayout.anim.ViewAnimProvider;
import com.fingdo.statelayout.bean.EmptyItem;
import com.fingdo.statelayout.bean.ErrorItem;
import com.fingdo.statelayout.bean.LoadingItem;
import com.fingdo.statelayout.bean.LoginItem;
import com.fingdo.statelayout.bean.NoNetworkItem;
import com.fingdo.statelayout.bean.TimeOutItem;
import com.fingdo.statelayout.helper.AnimationHelper;
import com.fingdo.statelayout.helper.LayoutHelper;
import com.fingdo.statelayout.holder.EmptyViewHolder;
import com.fingdo.statelayout.holder.ErrorViewHolder;
import com.fingdo.statelayout.holder.LoadingViewHolder;
import com.fingdo.statelayout.holder.LoginViewHolder;
import com.fingdo.statelayout.holder.NoNetworkViewHolder;
import com.fingdo.statelayout.holder.TimeOutViewHolder;


/**
 * <pre>
 *     author : fingdo
 *     e-mail : fingdo@qq.com
 *     time   : 2017/03/10
 *     desc   : 多状态Layout动态切换
 *     version: 1.0
 * </pre>
 */

public class StateLayout extends FrameLayout {

    public static final int ERROR = 1;
    public static final int EMPTY = 2;
    public static final int TIMEOUT = 3;
    public static final int NOT_NETWORK = 4;
    public static final int LOADING = 5;
    public static final int LOGIN = 6;

    private View contentView;
    private View emptyView;
    private View errorView;
    private View loadingView;
    private View timeOutView;
    private View notNetworkView;
    private View loginView;

    private ErrorItem errorItem;
    private NoNetworkItem noNetworkItem;
    private EmptyItem emptyItem;
    private LoadingItem loadingItem;
    private TimeOutItem timeOutItem;
    private LoginItem loginItem;

    private OnViewRefreshListener mListener;

    private ViewAnimProvider viewAnimProvider;
    private boolean useAnimation = false;

    public OnViewRefreshListener getRefreshLListener() {
        return mListener;
    }

    public void setRefreshListener(OnViewRefreshListener listener) {
        this.mListener = listener;
    }

    public void setErrorItem(ErrorItem errorItem) {
        this.errorItem = errorItem;
    }

    public void setNoNetworkItem(NoNetworkItem noNetworkItem) {
        this.noNetworkItem = noNetworkItem;
    }

    public void setEmptyItem(EmptyItem emptyItem) {
        this.emptyItem = emptyItem;
    }

    public void setLoadingItem(LoadingItem loadingItem) {
        this.loadingItem = loadingItem;
    }

    public void setTimeOutItem(TimeOutItem timeOutItem) {
        this.timeOutItem = timeOutItem;
    }

    public void setLoginItem(LoginItem loginItem) {
        this.loginItem = loginItem;
    }

    private View currentShowingView;

    public StateLayout(Context context) {
        this(context, null);
    }

    public StateLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public StateLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutHelper.parseAttr(context, attrs, this);

        LayoutInflater inflater = LayoutInflater.from(context);

        errorView = LayoutHelper.getErrorView(inflater, errorItem, this);

        emptyView = LayoutHelper.getEmptyView(inflater, emptyItem);

        notNetworkView = LayoutHelper.getNoNetworkView(inflater, noNetworkItem, this);

        timeOutView = LayoutHelper.getTimeOutView(inflater, timeOutItem, this);

        loadingView = LayoutHelper.getLoadingView(inflater, loadingItem);

        loginView = LayoutHelper.getLoginView(inflater, loginItem, this);
    }

    private void checkIsContentView(View view) {
        if (contentView == null && view != errorView && view != notNetworkView
                && view != loadingView && view != timeOutView && view != loginView
                && view != emptyView) {
            contentView = view;
            currentShowingView = contentView;
        }
    }

    //************ showView ************//

    /**
     * 展示错误的界面
     */
    public void showErrorView() {
        if (errorView.getParent() == null) {
            addView(errorView);
        }
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, errorView);
        currentShowingView = errorView;
    }

    /**
     * 展示错误的界面
     *
     * @param msgId 提示语
     */
    public void showErrorView(int msgId) {
        if (errorView.getParent() == null) {
            addView(errorView);
        }
        setTipText(ERROR, msgId);
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, errorView);
        currentShowingView = errorView;
    }

    /**
     * 展示错误的界面
     *
     * @param msg 提示语
     */
    public void showErrorView(String msg) {
        if (errorView.getParent() == null) {
            addView(errorView);
        }
        setTipText(ERROR, msg);
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, errorView);
        currentShowingView = errorView;
    }

    /**
     * 展示错误的界面
     *
     * @param msgId 提示语
     * @param imgId 图片Id
     */
    public void showErrorView(int msgId, int imgId) {
        if (errorView.getParent() == null) {
            addView(errorView);
        }
        setTipText(ERROR, msgId);
        setTipImg(ERROR, imgId);
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, errorView);
        currentShowingView = errorView;
    }

    /**
     * 展示错误的界面
     *
     * @param msg   提示语
     * @param imgId 图片Id
     */
    public void showErrorView(String msg, int imgId) {
        if (errorView.getParent() == null) {
            addView(errorView);
        }
        setTipText(ERROR, msg);
        setTipImg(ERROR, imgId);
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, errorView);
        currentShowingView = errorView;
    }

    /**
     * 展示空数据的界面
     */
    public void showEmptyView() {
        if (emptyView.getParent() == null) {
            addView(emptyView);
        }
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, emptyView);
        currentShowingView = emptyView;
    }

    /**
     * 展示空数据的界面
     *
     * @param msgId 提示语
     */
    public void showEmptyView(int msgId) {
        if (emptyView.getParent() == null) {
            addView(emptyView);
        }
        setTipText(EMPTY, msgId);
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, emptyView);
        currentShowingView = emptyView;
    }

    /**
     * 展示空数据的界面
     *
     * @param msg 提示语
     */
    public void showEmptyView(String msg) {
        if (emptyView.getParent() == null) {
            addView(emptyView);
        }
        setTipText(EMPTY, msg);
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, emptyView);
        currentShowingView = emptyView;
    }

    /**
     * 展示空数据的界面
     *
     * @param msgId 提示语
     * @param imgId 图片Id
     */
    public void showEmptyView(int msgId, int imgId) {
        if (emptyView.getParent() == null) {
            addView(emptyView);
        }
        setTipText(EMPTY, msgId);
        setTipImg(EMPTY, imgId);
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, emptyView);
        currentShowingView = emptyView;
    }

    /**
     * 展示空数据的界面
     *
     * @param msg   提示语
     * @param imgId 图片Id
     */
    public void showEmptyView(String msg, int imgId) {
        if (emptyView.getParent() == null) {
            addView(emptyView);
        }
        setTipText(EMPTY, msg);
        setTipImg(EMPTY, imgId);
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, emptyView);
        currentShowingView = emptyView;
    }

    /**
     * 展示超时的界面
     */
    public void showTimeoutView() {
        if (timeOutView.getParent() == null) {
            addView(timeOutView);
        }
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, timeOutView);
        currentShowingView = timeOutView;
    }

    /**
     * 展示超时的界面
     *
     * @param msgId 提示语
     */
    public void showTimeoutView(int msgId) {
        if (timeOutView.getParent() == null) {
            addView(timeOutView);
        }
        setTipText(TIMEOUT, msgId);
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, timeOutView);
        currentShowingView = timeOutView;
    }

    /**
     * 展示超时的界面
     *
     * @param msg 提示语
     */
    public void showTimeoutView(String msg) {
        if (timeOutView.getParent() == null) {
            addView(timeOutView);
        }
        setTipText(TIMEOUT, msg);
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, timeOutView);
        currentShowingView = timeOutView;
    }

    /**
     * 展示超时的界面
     *
     * @param msgId 提示语
     * @param imgId 图片Id
     */
    public void showTimeoutView(int msgId, int imgId) {
        if (timeOutView.getParent() == null) {
            addView(timeOutView);
        }
        setTipText(TIMEOUT, msgId);
        setTipImg(TIMEOUT, imgId);
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, timeOutView);
        currentShowingView = timeOutView;
    }

    /**
     * 展示超时的界面
     *
     * @param msg   提示语
     * @param imgId 图片Id
     */
    public void showTimeoutView(String msg, int imgId) {
        if (timeOutView.getParent() == null) {
            addView(timeOutView);
        }
        setTipText(TIMEOUT, msg);
        setTipImg(TIMEOUT, imgId);
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, timeOutView);
        currentShowingView = timeOutView;
    }

    /**
     * 展示没有网络的界面
     */
    public void showNoNetworkView() {
        if (notNetworkView.getParent() == null) {
            addView(notNetworkView);
        }
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, notNetworkView);
        currentShowingView = notNetworkView;
    }

    /**
     * 展示没有网络的界面
     *
     * @param msgId 提示语
     */
    public void showNoNetworkView(int msgId) {
        if (notNetworkView.getParent() == null) {
            addView(notNetworkView);
        }
        setTipText(NOT_NETWORK, msgId);
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, notNetworkView);
        currentShowingView = notNetworkView;
    }

    /**
     * 展示没有网络的界面
     *
     * @param msg 提示语
     */
    public void showNoNetworkView(String msg) {
        if (notNetworkView.getParent() == null) {
            addView(notNetworkView);
        }
        setTipText(NOT_NETWORK, msg);
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, notNetworkView);
        currentShowingView = notNetworkView;
    }

    /**
     * 展示没有网络的界面
     *
     * @param msgId 提示语
     * @param imgId 图片Id
     */
    public void showNoNetworkView(int msgId, int imgId) {
        if (notNetworkView.getParent() == null) {
            addView(notNetworkView);
        }
        setTipText(NOT_NETWORK, msgId);
        setTipImg(NOT_NETWORK, imgId);
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, notNetworkView);
        currentShowingView = notNetworkView;
    }

    /**
     * 展示登录的界面
     */
    public void showLoginView() {
        if (loginView.getParent() == null) {
            addView(loginView);
        }
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, loginView);
        currentShowingView = loginView;
    }

    /**
     * 展示登录的界面
     *
     * @param msgId 提示语
     */
    public void showLoginView(int msgId) {
        if (loginView.getParent() == null) {
            addView(loginView);
        }
        setTipText(LOGIN, msgId);
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, loginView);
        currentShowingView = loginView;
    }

    /**
     * 展示登录的界面
     *
     * @param msg 提示语
     */
    public void showLoginView(String msg) {
        if (loginView.getParent() == null) {
            addView(loginView);
        }
        setTipText(LOGIN, msg);
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, loginView);
        currentShowingView = loginView;
    }

    /**
     * 展示登录的界面
     *
     * @param msgId 提示语
     * @param imgId 图片Id
     */
    public void showLoginView(int msgId, int imgId) {
        if (loginView.getParent() == null) {
            addView(loginView);
        }
        setTipText(LOGIN, msgId);
        setTipImg(LOGIN, imgId);
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, loginView);
        currentShowingView = loginView;
    }

    /**
     * 展示登录的界面
     *
     * @param msg   提示语
     * @param imgId 图片Id
     */
    public void showLoginView(String msg, int imgId) {
        if (loginView.getParent() == null) {
            addView(loginView);
        }
        setTipText(LOGIN, msg);
        setTipImg(LOGIN, imgId);
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, loginView);
        currentShowingView = loginView;
    }


    /**
     * 展示加载中的界面
     */
    public void showLoadingView() {
        if (loadingView.getParent() == null) {
            addView(loadingView);
        }
        setLoadingView(null, true);
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, loadingView);
        currentShowingView = loadingView;
    }

    /**
     * 展示加载中的界面
     *
     * @param view 进度条部分
     */
    public void showLoadingView(View view) {
        if (loadingView.getParent() == null) {
            addView(loadingView);
        }
        setLoadingView(view, true);
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, loadingView);
        currentShowingView = loadingView;
    }

    /**
     * 展示加载中的界面
     *
     * @param view    进度条部分
     * @param showTip 是否显示提示
     */
    public void showLoadingView(View view, boolean showTip) {
        if (loadingView.getParent() == null) {
            addView(loadingView);
        }
        setLoadingView(view, showTip);
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, loadingView);
        currentShowingView = loadingView;
    }


    /**
     * 展示加载中的界面
     *
     * @param msgId 提示语
     */
    public void showLoadingView(int msgId) {
        if (loadingView.getParent() == null) {
            addView(loadingView);
        }
        setTipText(LOADING, msgId);
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, loadingView);
        currentShowingView = loadingView;
    }

    /**
     * 展示加载中的界面
     *
     * @param msg 提示语
     */
    public void showLoadingView(String msg) {
        if (loadingView.getParent() == null) {
            addView(loadingView);
        }
        setTipText(LOADING, msg);
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, loadingView);
        currentShowingView = loadingView;
    }

    /**
     * 展示内容的界面
     */
    public void showContentView() {
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, contentView);
        currentShowingView = contentView;
    }

    /**
     * 添加用户自定义的View
     *
     * @param view 自定义View
     */
    public void showCustomView(View view) {
        if (view.getParent() == null) { //当前的view没有父类
            addView(view);
        } else {
            view.setLayoutParams(this.getLayoutParams());
        }
        AnimationHelper.switchViewByAnim(useAnimation, viewAnimProvider, currentShowingView, view);
        currentShowingView = view;
    }

    //************ update ************//

    /**
     * 修改提示文字
     *
     * @param type 传入修改哪个
     * @param text 文字
     */
    public void setTipText(int type, String text) {
        if (text == null) { //text is null
            return;
        }
        switch (type) {
            case ERROR:
                ((ErrorViewHolder) errorView.getTag()).tvTip.setText(text);
                break;
            case EMPTY:
                ((EmptyViewHolder) emptyView.getTag()).tvTip.setText(text);
                break;
            case TIMEOUT:
                ((TimeOutViewHolder) timeOutView.getTag()).tvTip.setText(text);
                break;
            case NOT_NETWORK:
                ((NoNetworkViewHolder) notNetworkView.getTag()).tvTip.setText(text);
                break;
            case LOADING:
                ((LoadingViewHolder) loadingView.getTag()).tvTip.setText(text);
                break;
            case LOGIN:
                ((LoginViewHolder) loginView.getTag()).tvTip.setText(text);
                break;
        }
    }

    /**
     * 修改提示文字
     *
     * @param type   传入修改哪个
     * @param textId 文字资源id
     */
    public void setTipText(int type, int textId) {
        switch (type) {
            case ERROR:
                ((ErrorViewHolder) errorView.getTag()).tvTip.setText(textId);
                break;
            case EMPTY:
                ((EmptyViewHolder) emptyView.getTag()).tvTip.setText(textId);
                break;
            case TIMEOUT:
                ((TimeOutViewHolder) timeOutView.getTag()).tvTip.setText(textId);
                break;
            case NOT_NETWORK:
                ((NoNetworkViewHolder) notNetworkView.getTag()).tvTip.setText(textId);
                break;
            case LOADING:
                ((LoadingViewHolder) loadingView.getTag()).tvTip.setText(textId);
                break;
            case LOGIN:
                ((LoginViewHolder) loginView.getTag()).tvTip.setText(textId);
                break;
        }
    }

    /**
     * 设置提示图片资源
     *
     * @param type     传入修改哪个，除了Loading
     * @param drawable 图片资源drawable
     */
    public void setTipImg(int type, Drawable drawable) {
        switch (type) {
            case ERROR:
                ((ErrorViewHolder) errorView.getTag()).ivImg.setBackgroundDrawable(drawable);
                break;
            case EMPTY:
                ((EmptyViewHolder) emptyView.getTag()).ivImg.setBackgroundDrawable(drawable);
                break;
            case TIMEOUT:
                ((TimeOutViewHolder) timeOutView.getTag()).ivImg.setBackgroundDrawable(drawable);
                break;
            case NOT_NETWORK:
                ((NoNetworkViewHolder) notNetworkView.getTag()).ivImg.setBackgroundDrawable(drawable);
                break;
            case LOGIN:
                ((LoginViewHolder) loginView.getTag()).ivImg.setBackgroundDrawable(drawable);
                break;
        }
    }

    /**
     * 设置提示图片资源
     *
     * @param type  传入修改哪个，除了Loading
     * @param imgId 图片资源id
     */
    public void setTipImg(int type, int imgId) {
        switch (type) {
            case ERROR:
                ((ErrorViewHolder) errorView.getTag()).ivImg.setImageResource(imgId);
                break;
            case EMPTY:
                ((EmptyViewHolder) emptyView.getTag()).ivImg.setImageResource(imgId);
                break;
            case TIMEOUT:
                ((TimeOutViewHolder) timeOutView.getTag()).ivImg.setImageResource(imgId);
                break;
            case NOT_NETWORK:
                ((NoNetworkViewHolder) notNetworkView.getTag()).ivImg.setImageResource(imgId);
                break;
            case LOGIN:
                ((LoginViewHolder) loginView.getTag()).ivImg.setImageResource(imgId);
                break;
        }
    }

    /**
     * 设置加载界面的View
     *
     * @param view 显示的View
     */
    public void setLoadingView(View view, boolean showTip) {
        LoadingViewHolder holder = (LoadingViewHolder) loadingView.getTag();
        if (view != null) {
            holder.frameLayout.removeAllViews();
            holder.frameLayout.addView(view);
        }
        if (showTip) {
            holder.tvTip.setVisibility(VISIBLE);
        } else {
            holder.tvTip.setVisibility(GONE);
        }
    }

    //************ animation ************//

    public void setViewSwitchAnimProvider(ViewAnimProvider animProvider) {
        if (animProvider != null) {
            this.viewAnimProvider = animProvider;
        }
    }

    public ViewAnimProvider getViewAnimProvider() {
        return viewAnimProvider;
    }

    public boolean isUseAnimation() {
        return useAnimation;
    }

    public void setUseAnimation(boolean useAnimation) {
        this.useAnimation = useAnimation;
    }

    //************ callBack ************//
    public interface OnViewRefreshListener {
        //刷新界面
        void refreshClick();

        //登录点击
        void loginClick();
    }

    //************ addView ************//
    @Override
    public void addView(View child) {
        checkIsContentView(child);
        super.addView(child);
    }

    @Override
    public void addView(View child, int index) {
        checkIsContentView(child);
        super.addView(child, index);
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        checkIsContentView(child);
        super.addView(child, index, params);
    }

    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        checkIsContentView(child);
        super.addView(child, params);
    }

    @Override
    public void addView(View child, int width, int height) {
        checkIsContentView(child);
        super.addView(child, width, height);
    }

    @Override
    protected boolean addViewInLayout(View child, int index, ViewGroup.LayoutParams params) {
        checkIsContentView(child);
        return super.addViewInLayout(child, index, params);
    }

    @Override
    protected boolean addViewInLayout(View child, int index, ViewGroup.LayoutParams params, boolean preventRequestLayout) {
        checkIsContentView(child);
        return super.addViewInLayout(child, index, params, preventRequestLayout);
    }
}
