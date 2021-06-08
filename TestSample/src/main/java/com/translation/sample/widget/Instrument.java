package com.translation.sample.widget;

import android.animation.ObjectAnimator;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

class Instrument {
    private static Instrument mInstrument;
    public static Instrument getInstance(){
        if(mInstrument == null){
            mInstrument = new Instrument();
        }
        return mInstrument;
    }

    public float getTranslationY(View view){
        if(view == null){
            return 0;
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            return view.getTranslationY();
        }else{
            return ViewHelper.getTranslationY(view);
        }
    }

    public void slidingByDelta(View view ,float delta){
        if(view == null){
            return;
        }
        view.clearAnimation();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            view.setTranslationY(delta);
        }else{
            ViewHelper.setTranslationY(view, delta);
        }
    }

    public void slidingToY(View view ,float y){
        if(view == null){
            return;
        }
        view.clearAnimation();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            view.setY(y);
        }else{
            ViewHelper.setY(view, y);
        }
    }

    public void reset(View view, long duration){
        if(view == null){
            return;
        }
        view.clearAnimation();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            android.animation.ObjectAnimator.ofFloat(view, "translationY", 0F).setDuration(duration).start();
        }else{
            ObjectAnimator.ofFloat(view, "translationY", 0F).setDuration(duration).start();
        }
    }

    public void smoothTo(View view ,float y, long duration){
        if(view == null){
            return;
        }
        view.clearAnimation();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            android.animation.ObjectAnimator.ofFloat(view, "translationY", y).setDuration(duration).start();
        }else{
            ObjectAnimator.ofFloat(view, "translationY", y).setDuration(duration).start();
        }
    }
}
