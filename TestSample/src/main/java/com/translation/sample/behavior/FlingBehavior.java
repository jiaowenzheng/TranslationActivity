package com.translation.sample.behavior;

import android.content.Context;
import android.hardware.SensorManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;

/**
 * @program: TranslationActivity
 * @description:
 * @author: Mr.Wang
 * @create: 2021-06-06 13:02
 **/
public final class FlingBehavior extends AppBarLayout.Behavior {

    private boolean a;

    public FlingBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, float velocityX, float velocityY, boolean consumed) {
        if ((velocityY > 0.0f && !this.a) || (velocityY < 0.0f && this.a)) {
            velocityY *= -1.0f;
        }
        if ((target instanceof RecyclerView) && velocityY < 0.0f) {
            RecyclerView recyclerView = (RecyclerView) target;
            if (recyclerView.getChildAdapterPosition(recyclerView.getChildAt(0)) > 3) {
                consumed = true;
            } else {
                consumed = false;
            }
        }
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        this.a = dy > 0;
    }
}