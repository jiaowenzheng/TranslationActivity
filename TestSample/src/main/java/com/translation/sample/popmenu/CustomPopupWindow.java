package com.translation.sample.popmenu;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.translation.sample.R;

public class CustomPopupWindow extends PopupWindow {

    private View mRootView;

    public CustomPopupWindow(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context){
        View contentView = LayoutInflater.from(context).inflate(R.layout.popup_layout,null);

        View topLayout = contentView.findViewById(R.id.top_layout);
        View arrowIv = contentView.findViewById(R.id.iv_up_arrow);

        DisplayMetrics displayMetrics = contentView.getResources().getDisplayMetrics();

        int radius = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,6,displayMetrics);
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(Color.WHITE);
        drawable.setCornerRadius(radius);
        topLayout.setBackground(drawable);

        setContentView(contentView);
        setBackgroundDrawable(new ColorDrawable());
        setOutsideTouchable(true);

        float w = displayMetrics.widthPixels * 0.618f;
        float h = w / 2.97f;

        float arrowHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,20,displayMetrics);
        float leftMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,16,displayMetrics);
        float topMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,12,displayMetrics);

        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) topLayout.getLayoutParams();
        params.width = (int) w;
        params.height = (int) h;

        topLayout.setLayoutParams(params);

    }

}
