package com.translation.sample.widget;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static android.view.MotionEvent.INVALID_POINTER_ID;

public class TempRecyclerView extends RecyclerView {

    public TempRecyclerView(@NonNull Context context) {
        this(context,null);
    }

    public TempRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {

    }
    LinearLayoutManager linearLayoutManager;
    @Override
    public void setLayoutManager(LayoutManager layout) {
        super.setLayoutManager(layout);
        linearLayoutManager = (LinearLayoutManager) layout;
    }

    int viewHeight = 0;
    @Override
    public void onScrollStateChanged(int state) {
        Log.d("bruce","state:"+state);
       // RecyclerView.SCROLL_STATE_DRAGGING 1 RecyclerView.SCROLL_STATE_IDLE 2
        super.onScrollStateChanged(state);

        if(state == 0){
            int postion = linearLayoutManager.findFirstVisibleItemPosition();
            View view = linearLayoutManager.findViewByPosition(postion);
            int top = view.getTop();
            int offset = 0;
            if(viewHeight == 0){
                viewHeight = view.getHeight();
            }
            Log.i("jiao","top="+top+" viewHeight="+viewHeight);
            if(top == 0){
                return;
            }
            else if(-top < viewHeight/2){
                offset = top;
            }
            else {
                offset = viewHeight+top;
            }

            Log.i("jiao","offset="+offset);

            smoothScrollBy(0, offset);
        }
    }

    int offsetY = 0;


    @Override
    public void onScrolled(int dx, int dy) {
        super.onScrolled(dx, dy);
//        offsetY+=dy;
//
//        int first = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
//        int last = linearLayoutManager.findLastCompletelyVisibleItemPosition();
//        View firstview = linearLayoutManager.findViewByPosition(first);
//        if(viewHeight == 0){
//            viewHeight = firstview.getHeight();
//        }
//        int offseta = firstview.getTop();
//        float sx = 1f+(float) offseta/viewHeight;
//        if(offsetY == 0){
//            View view = linearLayoutManager.findViewByPosition(first+1);
//            view.setScaleX(2);
//        }
//
//        firstview.setScaleX(sx);
//        View lastview = linearLayoutManager.findViewByPosition(last);
//        offseta = getHeight()-lastview.getBottom();
//        sx = 1f+(float) offseta/viewHeight;
//        lastview.setScaleX(sx);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        try {
            return super.dispatchTouchEvent(ev);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return false;
        }
    }


}
