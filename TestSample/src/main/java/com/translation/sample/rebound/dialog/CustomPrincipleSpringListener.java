package com.translation.sample.rebound.dialog;

import android.animation.ObjectAnimator;
import android.view.View;

import com.facebook.rebound.SpringUtil;

public class CustomPrincipleSpringListener implements PrincipleSpring.PrincipleSpringListener{

    private View mView;
    private float mTranslationX;
    private int count;
    private boolean isDo;

    public CustomPrincipleSpringListener(View view, float translationX) {
        this.mView = view;
        this.mTranslationX = translationX;
    }

    @Override
    public void onPrincipleSpringStart(float value) {
    }

    @Override
    public void onPrincipleSpringStop(float value) {
    }

    @Override
    public void onPrincipleSpringUpdate(float value) {
        float selectedTranslateY = (float) SpringUtil.mapValueFromRangeToRange(value, 0, 1, mTranslationX, 0);
        mView.setTranslationX(-selectedTranslateY);

        //left
        if (mTranslationX > 0 && selectedTranslateY < 0) {
            count++;
        }

        //right
        if (mTranslationX < 0 && selectedTranslateY > 0) {
            count++;
        }

        if (count >= 1 && !isDo) {
            isDo = true;
            scaleAvatarView(mView);
        }
    }

    private void scaleAvatarView(View view){
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(view,View.SCALE_X,0.8f,1f);
        scaleXAnimator.setDuration(100);
        scaleXAnimator.start();

        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(view,View.SCALE_Y,0.8f,1f);
        scaleYAnimator.setDuration(100);
        scaleYAnimator.start();
    }
}
