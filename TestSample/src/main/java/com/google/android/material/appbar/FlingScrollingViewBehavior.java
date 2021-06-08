package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;


/**
 * @program: RoadStore
 * @description:
 * @author: Mr.Wang
 * @create: 2021-06-06 10:30
 **/
public class FlingScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {


    public FlingScrollingViewBehavior() {
    }

    public FlingScrollingViewBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


//    @Override
//    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
//        return true;
//    }
//
//    @Override
//    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, float velocityX, float velocityY, boolean consumed) {
//        if (child != target) {
//            ((RecyclerView) (child)).fling((int) velocityX, (int) velocityY);
//        }
//        return true;
//    }
}