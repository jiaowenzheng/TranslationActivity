package com.translation.sample.menu;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
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

    private ImageView mMenuHomePressedIv;
    private ImageView mMenuSocialPressedIv;
    private ImageView mMenuDiscoverPressedIv;

    private View mTabView;
    private View mMenuBgView;
    private View mMenuDiscoverView;
    private View mMenuHomeView;
    private View mMenuSocialView;
    private View mMenuGrayBgView;

    private int mLastMenu;
    private int mMenuMaxHeight;
    private int mMenuSpace;
    private int mMaxBottomMargin;
    private int mMinBottomMargin;
    private int mMenuMaxWidth;
    private int mMenuMinWidth;
    private int mMenuGrayViewMaxHeight;
    private boolean isRunAnimation;
    private boolean isExpand = false;

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

        mMenuHomePressedIv = findViewById(R.id.iv_menu_home_pressed);
        mMenuSocialPressedIv = findViewById(R.id.iv_menu_social_pressed);
        mMenuDiscoverPressedIv = findViewById(R.id.iv_menu_discover_pressed);

        mMenuHomeView = findViewById(R.id.menu_home_layout);
        mMenuSocialView = findViewById(R.id.menu_social_layout);
        mMenuDiscoverView = findViewById(R.id.menu_discover_layout);

        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(getResources().getColor(R.color.color_50_transparent));
        drawable.setCornerRadius(radius);
        mMenuGrayBgView.setBackground(drawable);

        mMenuIv.setOnClickListener(this);
        mMenuHomeIv.setOnClickListener(this);
        mMenuBgView.setOnClickListener(this);
        mMenuSocialIv.setOnClickListener(this);
        mMenuDiscoverIv.setOnClickListener(this);

        mMenuHomePressedIv.setOnClickListener(this);
        mMenuSocialPressedIv.setOnClickListener(this);
        mMenuDiscoverPressedIv.setOnClickListener(this);

        mMenuViewList.add(mMenuHomeView);
        mMenuViewList.add(mMenuSocialView);
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

                if (isExpand){
                    closeMenuViewAnimation(0,false);
                    mMenuBgView.setVisibility(View.GONE);
                }else {
                    isRunAnimation = true;
                    showMenuViewAnimation(mMenuMinWidth,mMenuMaxWidth,true);
                    mMenuBgView.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.iv_menu_home:
                closeMenuViewAnimation(1,false);
                break;
            case R.id.iv_menu_home_pressed:
                closeMenuViewAnimation(1,true);
                break;
            case R.id.iv_menu_social:
                closeMenuViewAnimation(2,false);
                break;
            case R.id.iv_menu_social_pressed:
                closeMenuViewAnimation(2,true);
                break;
            case R.id.iv_menu_discover:
                closeMenuViewAnimation(3,false);
                break;
            case R.id.iv_menu_discover_pressed:
                closeMenuViewAnimation(3,true);
                break;
            case R.id.menu_bg:
                closeMenuViewAnimation(0,false);
                break;
            default:
        }
    }


    private void closeMenuViewAnimation(int position,boolean isPressed){
        if (isRunAnimation){
            return;
        }

        isRunAnimation = true;

        setMenuPointBackground(position,isPressed);

        handler.postDelayed(() -> {
            closeMenuView();
            changeBackgroundHeightAnimation(mMenuGrayViewMaxHeight,mMenuHomeIv.getHeight());

            changeBackgroundBottomMarginAnimation(mMinBottomMargin,mMaxBottomMargin);
            showMenuViewAnimation(mMenuMaxWidth,mMenuMinWidth, false);
            mMenuBgView.setVisibility(View.GONE);
        },250);
    }

    private void setMenuPointBackground(int position,boolean isPressed){
        switch (position){
            case 1:
                if (mLastMenu == 1) return;
                mMenuIv.setImageResource(R.drawable.ic_menu_first_point);
                menuAnimationByLast(mMenuHomeIv,mMenuHomePressedIv,isPressed);
                mLastMenu = 1;
                break;
            case 2:
                if (mLastMenu == 2) return;
                mMenuIv.setImageResource(R.drawable.ic_menu_second_point);
                menuAnimationByLast(mMenuSocialIv,mMenuSocialPressedIv,isPressed);
                mLastMenu = 2;
                break;
            case 3:
                if (mLastMenu == 3) return;
                mMenuIv.setImageResource(R.drawable.ic_menu_three_point);
                menuAnimationByLast(mMenuDiscoverIv,mMenuDiscoverPressedIv,isPressed);
                mLastMenu = 3;
                break;
            default:
        }
    }

    private void menuAnimationByLast(View normalMenu,View pressedMenu,boolean isPressed){
        if (mLastMenu == 1){
            if (isPressed){
                alphaMenuAnimation(pressedMenu,normalMenu,mMenuHomeIv,mMenuHomePressedIv);
            }else{
                alphaMenuAnimation(normalMenu,pressedMenu,mMenuHomeIv,mMenuHomePressedIv);
            }
        }else if (mLastMenu == 2){
            if (isPressed){
                alphaMenuAnimation(pressedMenu,normalMenu,mMenuSocialIv,mMenuSocialPressedIv);
            }else{
                alphaMenuAnimation(normalMenu,pressedMenu,mMenuSocialIv,mMenuSocialPressedIv);
            }
        }else if (mLastMenu == 3){
            if (isPressed){
                alphaMenuAnimation(pressedMenu,normalMenu,mMenuDiscoverIv,mMenuDiscoverPressedIv);
            }else{
                alphaMenuAnimation(normalMenu,pressedMenu,mMenuDiscoverIv,mMenuDiscoverPressedIv);
            }
        }else if (mLastMenu == 0){
            alphaAnimation(pressedMenu,0,1);
            alphaAnimation(normalMenu,1,0);
        }
    }


    private void alphaMenuAnimation(View normalMenu,View pressedMenu,View lastNormalMenu,View lastPressedMenu){
        if (lastNormalMenu.getAlpha() == 0){
            alphaAnimation(lastNormalMenu,0,1);
            alphaAnimation(lastPressedMenu,1,0);
        }else if (lastPressedMenu.getAlpha() == 0){
            alphaAnimation(lastPressedMenu,0,1);
            alphaAnimation(lastNormalMenu,1,0);
        }

        alphaAnimation(normalMenu,1,0);
        alphaAnimation(pressedMenu,0,1);
    }

    private void alphaAnimation(View view,int from,int to){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view,View.ALPHA,from,to);
        objectAnimator.setDuration(200);
        objectAnimator.start();
    }


    private void showMenuViewAnimation(int startWidth, int endWidth, boolean isExpand){
        //改变menu 背景 宽度动画
        changeBackgroundWidthAnimation(startWidth,endWidth);
        //展开
        if (isExpand){
            //改变menu 背景高度
            changeBackgroundHeightAnimation(mMenuHomeIv.getHeight(),mMenuGrayViewMaxHeight);
            //改变menu 背景 距底部距离 设置bottomMargin
            changeBackgroundBottomMarginAnimation(mMaxBottomMargin,mMinBottomMargin);
            //向上平移三个 Menu 菜单
            openMenuAnimation();
        }

        this.isExpand = isExpand;
    }

    private void changeBackgroundWidthAnimation(int startWidth, int endWidth){
        ValueAnimator objectAnimator = ValueAnimator.ofInt(startWidth,endWidth);
        objectAnimator.addUpdateListener(animation -> {
            ViewGroup.LayoutParams params = mMenuGrayBgView.getLayoutParams();
            params.width = (int) animation.getAnimatedValue();
            mMenuGrayBgView.setLayoutParams(params);
        });

        objectAnimator.setDuration(200);
        objectAnimator.start();
    }

    private void changeBackgroundHeightAnimation(int startHeight, int endHeight){
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

    private void changeBackgroundBottomMarginAnimation(int startMargin, int endMargin){
        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) mMenuGrayBgView.getLayoutParams();
        ValueAnimator objectAnimator = ValueAnimator.ofInt(startMargin,endMargin);
        objectAnimator.addUpdateListener(animation -> {
            params.bottomMargin = (int) animation.getAnimatedValue();
            mMenuGrayBgView.setLayoutParams(params);
        });
        objectAnimator.setDuration(100);
        objectAnimator.start();
    }


    private void openMenuAnimation(){
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
