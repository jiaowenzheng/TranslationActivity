package com.translation.sample.rebound.dialog;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.translation.sample.R;

/**
 * @author JiaoWenZheng
 */
public class MatchingDialog extends DialogFragment {

    private int mWidthDialog;
    private ImageView mLeftAvatar;
    private ImageView mRightAvatar;
    private ImageView mTitleTv;
    private View mMaskTitleView;

    private PrincipleSpring mLeftAvatarSpring;
    private PrincipleSpring mRightAvatarSpring;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, R.style.dialog_background_style);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        mWidthDialog = (int) (displayMetrics.widthPixels * 0.85f);

        int height = displayMetrics.heightPixels / 2;

        getDialog().setCanceledOnTouchOutside(true);
        getDialog().getWindow().getDecorView().setPadding(0, 0, 0, 0);
        getDialog().getWindow().setLayout(mWidthDialog, height);

        return inflater.inflate(R.layout.dialog_matching,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mLeftAvatar = view.findViewById(R.id.iv_avatar_left);
        mRightAvatar = view.findViewById(R.id.iv_avatar_right);

        mTitleTv = view.findViewById(R.id.iv_text_size);
        mMaskTitleView = view.findViewById(R.id.mask_white);

        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius(18);
        drawable.setColor(Color.WHITE);
        view.setBackground(drawable);

        RequestOptions requestOptions = new RequestOptions();

        Glide.with(this).load("https://img8.ontheroadstore.com/androidupload/20200708/742.png").into(mLeftAvatar);
        Glide.with(this).load("https://img8.ontheroadstore.com/androidupload/20200708/742.jpeg").into(mRightAvatar);

        int translationX = mWidthDialog / 4 ;
        int titleTranslationX = mWidthDialog / 3;

        mLeftAvatarSpring = new PrincipleSpring(350, 15);
        mRightAvatarSpring = new PrincipleSpring(350, 15);
        mLeftAvatarSpring.setListener(new CustomPrincipleSpringListener(mLeftAvatar,translationX));
        mRightAvatarSpring.setListener(new CustomPrincipleSpringListener(mRightAvatar,-translationX));

        //头像平移
        mLeftAvatar.setTranslationX(-translationX);
        mRightAvatar.setTranslationX(translationX);

        //title平移
        mTitleTv.setTranslationX(titleTranslationX);
        mMaskTitleView.setTranslationX(titleTranslationX);

        view.postDelayed(() -> playAnimator(titleTranslationX),300);
    }



    /**
     * 播放动画
     *
     * @param translationX
     */
    private void playAnimator(int translationX){
        ObjectAnimator titleAnimator = createTranslationAnimator(mTitleTv,-translationX / 4);
        ObjectAnimator maskViewAnimator = createTranslationAnimator(mMaskTitleView, mWidthDialog);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(titleAnimator,maskViewAnimator);
        animatorSet.start();

        mLeftAvatarSpring.start();
        mRightAvatarSpring.start();
    }

    /**
     * 创建平移动画
     *
     * @param view
     * @param translationX
     * @return
     */
    private ObjectAnimator createTranslationAnimator(View view,int translationX){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view,View.TRANSLATION_X,translationX);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(400);
        return animator;
    }
}
