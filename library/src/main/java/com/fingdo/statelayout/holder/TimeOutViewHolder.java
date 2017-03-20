package com.fingdo.statelayout.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fingdo.statelayout.R;

public class TimeOutViewHolder extends BaseHolder {

    public ImageView ivImg;

    public TimeOutViewHolder(View view) {
        tvTip = (TextView) view.findViewById(R.id.tv_message);
        ivImg = (ImageView) view.findViewById(R.id.iv_img);
    }


}
