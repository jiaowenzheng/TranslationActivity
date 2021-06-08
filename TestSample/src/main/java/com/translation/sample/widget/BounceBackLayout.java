package com.translation.sample.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.translation.sample.R;

import static androidx.viewpager.widget.ViewPager.SCROLL_STATE_IDLE;

public class BounceBackLayout extends FrameLayout{

    /**
     * maximum z distance to translate child view
     */
    final static int DEFAULT_OVERSCROLL_TRANSLATION = 150;

    /**
     * duration of overscroll animation in ms
     */
    final private static int DEFAULT_OVERSCROLL_ANIMATION_DURATION = 400;

    @SuppressWarnings("unused")
    private final static String DEBUG_TAG = ViewPager.class.getSimpleName();
    private final static int INVALID_POINTER_ID = -1;

    final private OverscrollEffect mOverscrollEffect = new OverscrollEffect();
    final private Camera mCamera = new Camera();

    private ViewPager.OnPageChangeListener mScrollListener;
    private float mLastMotionX;
    private int mActivePointerId;
    private int mScrollPosition;
    private float mScrollPositionOffset;
    private int mTouchSlop;

    private float mOverscrollTranslation;
    private int mOverscrollAnimationDuration;

    private int mLastPosition = 0;

    private ViewPager2 mViewPager;

    public BounceBackLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

//        View view = (View) getParent();
//
//        Log.i("jiao","onFinishInflate children view ="+view+" count="+getChildCount());
//        while (view != null && !(view instanceof ViewPager2)){
//            view = (View) view.getParent();
//            Log.i("jiao","onFinishInflate while view="+view);
//        }
//
//        if (view != null){
//            Log.i("jiao","onFinishInflate BounceBackLayout viewPager2 ....");
//            mViewPager = (ViewPager2) view;
//            mViewPager.registerOnPageChangeCallback(callback);
//        }

        setStaticTransformationsEnabled(true);
        final ViewConfiguration configuration = ViewConfiguration.get(getContext());
        mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(configuration);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.i("jiao","onLayout ......");
        View view = (View) getParent();

        Log.i("jiao","onLayout children view ="+view+" count="+getChildCount());
        while (view != null && !(view instanceof ViewPager2)){
            view = (View) view.getParent();
            Log.i("jiao","onLayout while view="+view);
        }

        if (view != null){
            Log.i("jiao","onLayout BounceBackLayout viewPager2 ....");
            mViewPager = (ViewPager2) view;
            mViewPager.registerOnPageChangeCallback(callback);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.i("jiao","onSizeChanged ......");
    }

    private void init(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.BounceBackViewPager);
        mOverscrollTranslation = a.getDimension(R.styleable.BounceBackViewPager_overscroll_translation, DEFAULT_OVERSCROLL_TRANSLATION);
        mOverscrollAnimationDuration = a.getInt(R.styleable.BounceBackViewPager_overscroll_animation_duration, DEFAULT_OVERSCROLL_ANIMATION_DURATION);
        a.recycle();
    }

    public int getOverscrollAnimationDuration() {
        return mOverscrollAnimationDuration;
    }

    public void setOverscrollAnimationDuration(int mOverscrollAnimationDuration) {
        this.mOverscrollAnimationDuration = mOverscrollAnimationDuration;
    }

    public float getOverscrollTranslation() {
        return mOverscrollTranslation;
    }

    public void setOverscrollTranslation(int mOverscrollTranslation) {
        this.mOverscrollTranslation = mOverscrollTranslation;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener listener) {
        mScrollListener = listener;
    }

    private void invalidateVisibleChilds(final int position) {
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).invalidate();

        }
        //this.invalidate();
        // final View child = getChildAt(position);
        // final View previous = getChildAt(position - 1);
        // final View next = getChildAt(position + 1);
        // if (child != null) {
        // child.invalidate();
        // }
        // if (previous != null) {
        // previous.invalidate();
        // }
        // if (next != null) {
        // next.invalidate();
        // }
    }

    private ViewPager2.OnPageChangeCallback callback = new ViewPager2.OnPageChangeCallback() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            super.onPageScrolled(position, positionOffset, positionOffsetPixels);

            if (mScrollListener != null) {
                mScrollListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
            mScrollPosition = position;
            mScrollPositionOffset = positionOffset;
            mLastPosition = position;
            invalidateVisibleChilds(position);
        }

        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            if (mScrollListener != null) {
                mScrollListener.onPageSelected(position);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);
            if (mScrollListener != null) {
                mScrollListener.onPageScrollStateChanged(state);
            }
            if (state == SCROLL_STATE_IDLE) {
                mScrollPositionOffset = 0;
            }
        }
    };

//    private class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
//
//        @Override
//        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            if (mScrollListener != null) {
//                mScrollListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
//            }
//            mScrollPosition = position;
//            mScrollPositionOffset = positionOffset;
//            mLastPosition = position;
//            invalidateVisibleChilds(position);
//        }
//
//        @Override
//        public void onPageSelected(int position) {
//
//            if (mScrollListener != null) {
//                mScrollListener.onPageSelected(position);
//            }
//        }
//
//        @Override
//        public void onPageScrollStateChanged(final int state) {
//
//            if (mScrollListener != null) {
//                mScrollListener.onPageScrollStateChanged(state);
//            }
//            if (state == SCROLL_STATE_IDLE) {
//                mScrollPositionOffset = 0;
//            }
//        }
//    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            final int action = ev.getAction() & MotionEventCompat.ACTION_MASK;
            switch (action) {
                case MotionEvent.ACTION_DOWN: {
                    mLastMotionX = ev.getX();
                    mActivePointerId = MotionEventCompat.getPointerId(ev, 0);
                    break;
                }
                case MotionEventCompat.ACTION_POINTER_DOWN: {
                    final int index = MotionEventCompat.getActionIndex(ev);
                    final float x = MotionEventCompat.getX(ev, index);
                    mLastMotionX = x;
                    mActivePointerId = MotionEventCompat.getPointerId(ev, index);
                    break;
                }
            }
            return super.onInterceptTouchEvent(ev);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return false;
        }
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

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

//        View view = (View) getParent();
//        while (view != null && !(view instanceof ViewPager2)){
//            view = (View) view.getParent();
//            Log.i("jiao","onTouchEvent while view="+view);
//        }

        if (mViewPager == null){
            return super.onTouchEvent(ev);
        }

        boolean callSuper = false;

        final int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                callSuper = true;
                mLastMotionX = ev.getX();
                mActivePointerId = MotionEventCompat.getPointerId(ev, 0);
                break;
            }
            case MotionEventCompat.ACTION_POINTER_DOWN: {
                callSuper = true;
                final int index = MotionEventCompat.getActionIndex(ev);
                final float x = MotionEventCompat.getX(ev, index);
                mLastMotionX = x;
                mActivePointerId = MotionEventCompat.getPointerId(ev, index);
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                if (mActivePointerId != INVALID_POINTER_ID) {
                    // Scroll to follow the motion event
                    final int activePointerIndex = MotionEventCompat.findPointerIndex(ev, mActivePointerId);
                    final float x = MotionEventCompat.getX(ev, activePointerIndex);
                    final float deltaX = mLastMotionX - x;
                    final float oldScrollX = getScrollX();
                    final int width = getWidth();
//                    final int widthWithMargin = width + mViewPager.getPageMargin();
                    final int widthWithMargin = width + 0;
                    final int lastItemIndex = mViewPager.getAdapter().getItemCount() - 1;
                    final int currentItemIndex = mViewPager.getCurrentItem();
                    final float leftBound = Math.max(0, (currentItemIndex - 1) * widthWithMargin);
                    final float rightBound = Math.min(currentItemIndex + 1, lastItemIndex) * widthWithMargin;
                    final float scrollX = oldScrollX + deltaX;
                    if (mScrollPositionOffset == 0) {
                        if (scrollX < leftBound) {
                            if (leftBound == 0) {
                                final float over = deltaX + mTouchSlop;
                                mOverscrollEffect.setPull(over / width);
                            }
                        } else if (scrollX > rightBound) {
                            if (rightBound == lastItemIndex * widthWithMargin) {
                                final float over = scrollX - rightBound - mTouchSlop;
                                mOverscrollEffect.setPull(over / width);
                            }
                        }
                    } else {
                        mLastMotionX = x;
                    }
                } else {
                    mOverscrollEffect.onRelease();
                }
                break;
            }
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL: {
                callSuper = true;
                mActivePointerId = INVALID_POINTER_ID;
                mOverscrollEffect.onRelease();
                break;
            }
            case MotionEvent.ACTION_POINTER_UP: {
                final int pointerIndex = (ev.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
                final int pointerId = MotionEventCompat.getPointerId(ev, pointerIndex);
                if (pointerId == mActivePointerId) {
                    // This was our active pointer going up. Choose a new
                    // active pointer and adjust accordingly.
                    final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
                    mLastMotionX = ev.getX(newPointerIndex);
                    mActivePointerId = MotionEventCompat.getPointerId(ev, newPointerIndex);
                    callSuper = true;
                }
                break;
            }
        }

        if (mOverscrollEffect.isOverscrolling() && !callSuper) {
            return true;
        } else {
            return super.onTouchEvent(ev);
        }
    }

    @Override
    protected boolean getChildStaticTransformation(View child, Transformation t) {
        if (mViewPager == null){
            return false;
        }

        if (child.getWidth() == 0) {
            return false;
        }
        final int position = child.getLeft() / child.getWidth();
        final boolean isFirstOrLast = position == 0 || (position == mViewPager.getAdapter().getItemCount() - 1);
        if (mOverscrollEffect.isOverscrolling() && isFirstOrLast) {
            final float dx = getWidth() / 2;
            final int dy = getHeight() / 2;
            t.getMatrix().reset();
            final float translateX = (float) mOverscrollTranslation * (mOverscrollEffect.mOverscroll > 0
                    ? Math.min(mOverscrollEffect.mOverscroll, 1) : Math.max(mOverscrollEffect.mOverscroll, -1));
            mCamera.save();
            mCamera.translate(-translateX, 0, 0);
            mCamera.getMatrix(t.getMatrix());
            mCamera.restore();
            t.getMatrix().preTranslate(-dx, -dy);
            t.getMatrix().postTranslate(dx, dy);

            if (getChildCount() == 1) {
                this.invalidate();
            } else {
                child.invalidate();
            }
            return true;
        }
        return false;
    }
    /**
     * @author renard, extended by Piotr Zawadzki
     */
    private class OverscrollEffect {
        private float mOverscroll;
        private Animator mAnimator;

        /**
         * @param deltaDistance [0..1] 0->no overscroll, 1>full overscroll
         */
        public void setPull(final float deltaDistance) {
            mOverscroll = deltaDistance;
            invalidateVisibleChilds(mLastPosition);
        }

        /**
         * called when finger is released. starts to animate back to default position
         */
        private void onRelease() {
            if (mAnimator != null && mAnimator.isRunning()) {
                mAnimator.addListener(new Animator.AnimatorListener() {

                    @Override
                    public void onAnimationStart(Animator animation) {
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        startAnimation(0);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                    }
                });
                mAnimator.cancel();
            } else {
                startAnimation(0);
            }
        }

        private void startAnimation(final float target) {
            mAnimator = ObjectAnimator.ofFloat(this, "pull", mOverscroll, target);
            mAnimator.setInterpolator(new DecelerateInterpolator());
            final float scale = Math.abs(target - mOverscroll);
            mAnimator.setDuration((long) (mOverscrollAnimationDuration * scale));
            mAnimator.start();
        }

        private boolean isOverscrolling() {
            if (mScrollPosition == 0 && mOverscroll < 0) {
                return true;
            }
            final boolean isLast = (mViewPager.getAdapter().getItemCount() - 1) == mScrollPosition;
            if (isLast && mOverscroll > 0) {
                return true;
            }
            return false;
        }

    }

}
