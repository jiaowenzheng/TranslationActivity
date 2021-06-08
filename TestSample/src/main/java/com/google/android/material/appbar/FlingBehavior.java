package com.google.android.material.appbar;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;

/**
 *
 *  个人店铺页 appbar layout 滑动不流畅的问题
 *
 */
public final class FlingBehavior extends AppBarLayout.Behavior {
    private static final int TOP_CHILD_FLING_THRESHOLD = 3;
    private boolean isPositive;

    private static final int INVALID_POINTER = -1;

    @Nullable private Runnable flingRunnable;
    OverScroller scroller;

    private boolean isBeingDragged;
    private int activePointerId = INVALID_POINTER;
    private int lastMotionY;
    private int touchSlop = -1;
    @Nullable
    private VelocityTracker velocityTracker;

    public FlingBehavior() {
    }


    public FlingBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


//    @Override
//    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, float velocityX, float velocityY, boolean consumed) {
//        if (velocityY > 0 && !isPositive || velocityY < 0 && isPositive) {
//            velocityY = velocityY * -1;
//        }
//
//        if (target instanceof RecyclerView && velocityY < 0) {
//            final RecyclerView recyclerView = (RecyclerView) target;
//            final View firstChild = recyclerView.getChildAt(0);
//            final int childAdapterPosition = recyclerView.getChildAdapterPosition(firstChild);
//            consumed = childAdapterPosition > TOP_CHILD_FLING_THRESHOLD;
//        }
//
//        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
//    }
//
//
//    @Override
//    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, int dx, int dy, int[] consumed) {
//        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
//        isPositive = dy > 0;
//    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull  CoordinatorLayout parent, @NonNull  AppBarLayout child, @NonNull  MotionEvent ev) {
        if (touchSlop < 0) {
            touchSlop = ViewConfiguration.get(parent.getContext()).getScaledTouchSlop();
        }

        // Shortcut since we're being dragged
        if (ev.getActionMasked() == MotionEvent.ACTION_MOVE && isBeingDragged) {
            if (activePointerId == INVALID_POINTER) {
                // If we don't have a valid id, the touch down wasn't on content.
                return false;
            }
            int pointerIndex = ev.findPointerIndex(activePointerId);
            if (pointerIndex == -1) {
                return false;
            }

            int y = (int) ev.getY(pointerIndex);
            int yDiff = Math.abs(y - lastMotionY);
            if (yDiff > touchSlop) {
                lastMotionY = y;
                return true;
            }
        }

        if (ev.getActionMasked() == MotionEvent.ACTION_DOWN) {
            activePointerId = INVALID_POINTER;

            int x = (int) ev.getX();
            int y = (int) ev.getY();
            isBeingDragged = canDragView(child) && parent.isPointInChildBounds(child, x, y);
            if (isBeingDragged) {
                lastMotionY = y;
                activePointerId = ev.getPointerId(0);
                ensureVelocityTracker();

                // There is an animation in progress. Stop it and catch the view.
                if (scroller != null && !scroller.isFinished()) {
                    scroller.abortAnimation();
                    return true;
                }
            }
        }

        if (velocityTracker != null) {
            velocityTracker.addMovement(ev);
        }

        return false;
    }


    @Override
    public boolean onTouchEvent(@NonNull CoordinatorLayout parent, @NonNull  AppBarLayout child, @NonNull MotionEvent ev) {
        boolean consumeUp = false;
        switch (ev.getActionMasked()) {
            case MotionEvent.ACTION_MOVE:
                final int activePointerIndex = ev.findPointerIndex(activePointerId);
                if (activePointerIndex == -1) {
                    return false;
                }

                final int y = (int) ev.getY(activePointerIndex);
                int dy = lastMotionY - y;
                lastMotionY = y;
                // We're being dragged so scroll the ABL
                scroll(parent, child, dy, getMaxDragOffset(child), 0);
                break;
            case MotionEvent.ACTION_POINTER_UP:
                int newIndex = ev.getActionIndex() == 0 ? 1 : 0;
                activePointerId = ev.getPointerId(newIndex);
                lastMotionY = (int) (ev.getY(newIndex) + 0.5f);
                break;
            case MotionEvent.ACTION_UP:
                if (velocityTracker != null) {
                    consumeUp = true;
                    velocityTracker.addMovement(ev);
                    velocityTracker.computeCurrentVelocity(1000);
                    float yvel = velocityTracker.getYVelocity(activePointerId);
                    flingV2(parent, child, -getScrollRangeForDragFling(child), 0, yvel);
                }

                // $FALLTHROUGH
            case MotionEvent.ACTION_CANCEL:
                isBeingDragged = false;
                activePointerId = INVALID_POINTER;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    velocityTracker = null;
                }
                break;
        }

        if (velocityTracker != null) {
            velocityTracker.addMovement(ev);
        }

        return isBeingDragged || consumeUp;

    }

     boolean flingV2(
            CoordinatorLayout coordinatorLayout,
            @NonNull AppBarLayout layout,
            int minOffset,
            int maxOffset,
            float velocityY) {
        if (flingRunnable != null) {
            layout.removeCallbacks(flingRunnable);
            flingRunnable = null;
        }

        if (scroller == null) {
            scroller = new OverScroller(layout.getContext());
        }

        scroller.fling(
                0,
                getTopAndBottomOffset(), // curr
                0,
                Math.round(velocityY), // velocity.
                0,
                0, // x
                minOffset,
                maxOffset); // y

        if (scroller.computeScrollOffset()) {
            flingRunnable = new FlingRunnable(coordinatorLayout, layout);
            ViewCompat.postOnAnimation(layout, flingRunnable);
            return true;
        } else {
            onFlingFinished(coordinatorLayout, layout);
            return false;
        }
    }

    private class FlingRunnable implements Runnable {
        private final CoordinatorLayout parent;
        private final AppBarLayout layout;

        FlingRunnable(CoordinatorLayout parent, AppBarLayout layout) {
            this.parent = parent;
            this.layout = layout;
        }

        @Override
        public void run() {
            if (layout != null && scroller != null) {
                if (scroller.computeScrollOffset()) {
                    scroll();
                } else {
                    onFlingFinished(parent, layout);
                }
            }
        }

        private void scroll() {
            // 如果AppBarLayout滑到阈值，此时需要将fling事件传递下去
            if (scroller.getCurrY() <= -getScrollRangeForDragFling(layout) && scroller.getStartX() > scroller.getFinalY()) {
                setHeaderTopBottomOffset(parent, layout, -getScrollRangeForDragFling(layout));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    if (layout.startNestedScroll(View.SCROLL_AXIS_VERTICAL)) {
                        layout.dispatchNestedFling(scroller.getCurrVelocity(), scroller.getCurrVelocity(), false);
                    }
                }
                scroller.forceFinished(true);
            } else { // 如果AppBarLayout还没有滑到阈值，就让开心的滑动。
                setHeaderTopBottomOffset(parent, layout, scroller.getCurrY());
            }
            ViewCompat.postOnAnimation(layout, this);
        }
    }

    private void ensureVelocityTracker() {
        if (velocityTracker == null) {
            velocityTracker = VelocityTracker.obtain();
        }
    }

//    /**
//     * Called when a fling has finished, or the fling was initiated but there wasn't enough velocity
//     * to start it.
//     */
//    void onFlingFinished(CoordinatorLayout parent, AppBarLayout layout) {
//        // no-op
//    }
//
//    /** Return true if the view can be dragged. */
//    boolean canDragView(AppBarLayout view) {
//        return false;
//    }
//
//    /** Returns the maximum px offset when {@code view} is being dragged. */
//    int getMaxDragOffset(@NonNull AppBarLayout view) {
//        return -view.getHeight();
//    }
//
//    int getScrollRangeForDragFling(@NonNull AppBarLayout view) {
//        return view.getHeight();
//    }
}