package com.fingdo.statelayout.anim;

import android.view.animation.Animation;

/**
 * <pre>
 *     author : fingdo
 *     e-mail : fingdo@qq.com
 *     time   : 2017/03/13
 *     desc   : 基类ViewAnimProvider
 *     version: 1.0
 * </pre>
 */

public interface ViewAnimProvider {

    Animation showAnimation();

    Animation hideAnimation();

}
