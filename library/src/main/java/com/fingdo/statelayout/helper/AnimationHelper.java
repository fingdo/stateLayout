package com.fingdo.statelayout.helper;

import android.view.View;
import android.view.animation.Animation;

import com.fingdo.statelayout.anim.FadeScaleViewAnimProvider;
import com.fingdo.statelayout.anim.ViewAnimProvider;

/**
 * <pre>
 *     author : fingdo
 *     e-mail : fingdo@qq.com
 *     time   : 2017/03/14
 *     desc   : 动画帮助类
 *     version: 1.0
 * </pre>
 */

public class AnimationHelper {


    /**
     * 切换布局
     * @param useAnimation 是否使用动画
     * @param viewAnimProvider 动画持有类
     * @param fromView 开始View
     * @param toView 结束View
     */
    public static void switchViewByAnim(boolean useAnimation, ViewAnimProvider viewAnimProvider,
                                        final View fromView, View toView) {
        if (fromView == toView)
            return;
        if (useAnimation) {
            if (viewAnimProvider == null) {
                //使用默认动画
                viewAnimProvider = new FadeScaleViewAnimProvider();
            }
            Animation hideAnimation = viewAnimProvider.hideAnimation();
            Animation showAnimation = viewAnimProvider.showAnimation();

            if (fromView != null) {
                if (hideAnimation != null) {
                    hideAnimation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            fromView.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    hideAnimation.setFillAfter(false);
                    fromView.startAnimation(hideAnimation);
                } else {
                    fromView.setVisibility(View.GONE);
                }
            }
            if (toView != null) {
                if (toView.getVisibility() != View.VISIBLE) {
                    toView.setVisibility(View.VISIBLE);
                }
                if (showAnimation != null) {
                    showAnimation.setFillAfter(false);
                    toView.startAnimation(showAnimation);
                }
            }
        } else {
            if (fromView != null) {
                fromView.setVisibility(View.GONE);
            }
            if (toView != null) {
                toView.setVisibility(View.VISIBLE);
            }
        }


    }

}
