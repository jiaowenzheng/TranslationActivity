package com.translation.sample.animtator;

import android.view.View;
import android.view.ViewGroup;

/**
 * @program: TranslationActivity
 * @description:
 * @author: Mr.Wang
 * @create: 2021-06-26 22:39
 **/
public class ViewWrapper {

    private View mTargetView;

    public ViewWrapper(View targetView) {
        this.mTargetView = targetView;
    }

    public void setRealWidth(int width){
        mTargetView.getLayoutParams().width = width;
        mTargetView.requestLayout();
    }

    public void setBottomMargin(int bottomMargin){
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) mTargetView.getLayoutParams();
        params.bottomMargin = bottomMargin;
        mTargetView.setLayoutParams(params);
    }
}
