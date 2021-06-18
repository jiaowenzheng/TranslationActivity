package com.translation.sample.menu;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.translation.sample.R;

import java.util.ArrayList;
import java.util.List;

public class PopupWindowActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mMenuIv;
    private ImageView mMenuHomeIv;
    private ImageView mMenuSocialIv;
    private ImageView mMenuDiscoverIv;

    private View mTabView;
    private View mMenuBgView;
    private View mMenuDiscoverView;
    private View mMenuGrayBgView;

    private int mMenuMaxHeight;
    private int mMenuSpace;
    private int mMaxBottomMargin;
    private int mMinBottomMargin;
    private int mMenuMaxWidth;
    private int mMenuMinWidth;
    private int mMenuGrayViewMaxHeight;
    private boolean isRunAnimation;

    private Handler handler = new Handler();

    private List<View> mMenuViewList = new ArrayList<>(3);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);

        mMenuSpace = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,8,getResources().getDisplayMetrics());
        int radius = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,25,getResources().getDisplayMetrics());

        mTabView = findViewById(R.id.bottom_tab_layout);

        mMenuIv = findViewById(R.id.iv_menu);
        mMenuBgView = findViewById(R.id.menu_bg);
        mMenuHomeIv = findViewById(R.id.iv_menu_home);
        mMenuGrayBgView = findViewById(R.id.menu_gray_bg);
        mMenuSocialIv = findViewById(R.id.iv_menu_social);
        mMenuDiscoverIv = findViewById(R.id.iv_menu_discover);
        mMenuDiscoverView = findViewById(R.id.discover_layout);


        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(getResources().getColor(R.color.color_50_transparent));
        drawable.setCornerRadius(radius);
        mMenuGrayBgView.setBackground(drawable);

        mMenuIv.setOnClickListener(this);
        mMenuHomeIv.setOnClickListener(this);
        mMenuBgView.setOnClickListener(this);
        mMenuSocialIv.setOnClickListener(this);
        mMenuDiscoverIv.setOnClickListener(this);

        mMenuViewList.add(mMenuHomeIv);
        mMenuViewList.add(mMenuSocialIv);
        mMenuViewList.add(mMenuDiscoverView);

        mMenuIv.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mMenuIv.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                int bottomMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,5,getResources().getDisplayMetrics());
                int widthOffset = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,10,getResources().getDisplayMetrics());

                int menuWidth = mMenuHomeIv.getMeasuredWidth();
                int menuHeight = mMenuHomeIv.getMeasuredHeight();

                int size = mMenuViewList.size();
                mMenuMaxHeight = menuHeight * size + mMenuSpace * size;

                mMenuGrayViewMaxHeight = mMenuMaxHeight + menuHeight + mMenuSpace + bottomMargin / 2;

                mMenuMaxWidth = widthOffset + menuWidth;
                mMenuMinWidth = menuWidth;

                mMaxBottomMargin = (mTabView.getHeight() - menuHeight) / 2;
                mMinBottomMargin = mMaxBottomMargin - bottomMargin;

                ConstraintLayout.LayoutParams param = (ConstraintLayout.LayoutParams) mMenuGrayBgView.getLayoutParams();
                param.width = menuWidth;
                param.height = menuHeight;
                param.bottomMargin = mMaxBottomMargin;
                mMenuGrayBgView.setLayoutParams(param);
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_menu:
                if (isRunAnimation){
                    return;
                }

                if (checkMenuExpand()){
                    closeMenuViewAnimation(0);
                    mMenuBgView.setVisibility(View.GONE);
                }else {
                    isRunAnimation = true;
                    showMenuViewAnimation(mMenuMinWidth,mMenuMaxWidth,true);
                    mMenuBgView.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.iv_menu_home:
                closeMenuViewAnimation(1);
                break;
            case R.id.iv_menu_social:
                closeMenuViewAnimation(2);
                break;
            case R.id.iv_menu_discover:
                closeMenuViewAnimation(3);
                break;
            case R.id.menu_bg:
                closeMenuViewAnimation(0);
                break;
            default:
        }
    }

    private boolean checkMenuExpand(){
        if (mMenuDiscoverView.getVisibility() == View.VISIBLE
                || mMenuHomeIv.getVisibility() == View.VISIBLE
                || mMenuSocialIv.getVisibility() == View.VISIBLE){
            return true;
        }else {
            return false;
        }
    }

    private void closeMenuViewAnimation(int position){
        if (isRunAnimation){
            return;
        }

        isRunAnimation = true;

        setMenuPointBackground(position);

        handler.postDelayed(() -> {
            closeMenuView();
            heightAnimation(mMenuGrayViewMaxHeight,mMenuHomeIv.getHeight());

            bottomMarginAnimation(mMinBottomMargin,mMaxBottomMargin);
            showMenuViewAnimation(mMenuMaxWidth,mMenuMinWidth, false);
            mMenuBgView.setVisibility(View.GONE);
        },200);
    }

    private void setMenuPointBackground(int position){
        switch (position){
            case 1:
                mMenuIv.setImageResource(R.drawable.ic_menu_first_point);
                setMenuSelected(true,false,false);
                break;
            case 2:
                mMenuIv.setImageResource(R.drawable.ic_menu_second_point);
                setMenuSelected(false,true,false);
                break;
            case 3:
                mMenuIv.setImageResource(R.drawable.ic_menu_three_point);
                setMenuSelected(false,false,true);
                break;
            default:
        }
    }

    private void setMenuSelected(boolean firstSelected,boolean secondSelected,boolean threeSelected){
        mMenuHomeIv.setSelected(firstSelected);
        mMenuSocialIv.setSelected(secondSelected);
        mMenuDiscoverIv.setSelected(threeSelected);
    }

    private void showMenuViewAnimation(int startWidth, int endWidth, boolean isExpand){
        ValueAnimator objectAnimator = ValueAnimator.ofInt(startWidth,endWidth);
        objectAnimator.addUpdateListener(animation -> {
            ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) mMenuGrayBgView.getLayoutParams();
            params.width = (int) animation.getAnimatedValue();
            mMenuGrayBgView.setLayoutParams(params);
        });

        //展开
        if (isExpand){
            heightAnimation(mMenuHomeIv.getHeight(),mMenuGrayViewMaxHeight);
            bottomMarginAnimation(mMaxBottomMargin,mMinBottomMargin);
            openMenuView();
        }

        objectAnimator.setDuration(200);
        objectAnimator.start();
    }

    private void heightAnimation(int startHeight,int endHeight){
        ValueAnimator objectAnimator = ValueAnimator.ofInt(startHeight,endHeight);
        objectAnimator.addUpdateListener(animation -> {
            ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) mMenuGrayBgView.getLayoutParams();
            params.height = (int) animation.getAnimatedValue();
            mMenuGrayBgView.setLayoutParams(params);
            if (animation.getAnimatedFraction() >= 1){
                isRunAnimation = false;
            }
        });
        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator.setDuration(200);
        objectAnimator.start();
    }

    private void bottomMarginAnimation(int startMargin,int endMargin){
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) mMenuGrayBgView.getLayoutParams();
        ValueAnimator objectAnimator = ValueAnimator.ofInt(startMargin,endMargin);
        objectAnimator.addUpdateListener(animation -> {
            params.bottomMargin = (int) animation.getAnimatedValue();
            mMenuGrayBgView.setLayoutParams(params);
        });
        objectAnimator.setDuration(100);
        objectAnimator.start();
    }


    private void openMenuView(){
        int size = mMenuViewList.size();

        for (int i = 0;i < size;i++){
            View view = mMenuViewList.get(i);
            int height = mMenuMaxHeight;
            if (i != 0) {
                height = mMenuMaxHeight - view.getHeight() * i - (mMenuSpace * i);
            }

            view.setVisibility(View.VISIBLE);
            translationAnimation(view,-height,200,false);
        }
    }

    private void closeMenuView(){
        int size = mMenuViewList.size();

        for (int i = size - 1;i >= 0; i--) {
            View view = mMenuViewList.get(i);
            translationAnimation(view,0,200,true);
        }
    }

    private void translationAnimation(View view,int endY,int duration,boolean isClose){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view,View.TRANSLATION_Y,endY);
        objectAnimator.setDuration(duration);
        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator.addListener(new android.animation.AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(android.animation.Animator animation) {
                super.onAnimationEnd(animation);
                if (isClose){
                    view.setVisibility(View.INVISIBLE);
                }
            }
        });

        objectAnimator.start();
    }
}
