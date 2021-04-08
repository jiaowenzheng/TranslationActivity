package com.translation.sample.popmenu;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.translation.sample.R;

public class PopupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_menu);

        View button1 = findViewById(R.id.tv_button_1);
        View button2 = findViewById(R.id.tv_button_2);
        View button3 = findViewById(R.id.tv_button_3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow(v);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow(v);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow(v);
            }
        });

    }

    private void showPopupWindow(View anchor){
        View contentView = getLayoutInflater().inflate(R.layout.popup_layout,null);
        View topLayout = contentView.findViewById(R.id.top_layout);
        View arrowIv = contentView.findViewById(R.id.iv_up_arrow);

        PopupWindow popupWindow = new PopupWindow(this);
        popupWindow.setContentView(contentView);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(true);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int radius = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,6,displayMetrics);
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(Color.WHITE);
        drawable.setCornerRadius(radius);
        topLayout.setBackground(drawable);

        float w = displayMetrics.widthPixels * 0.618f;
        float h = w / 2.97f;
        float arrowHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,20,displayMetrics);
        float leftMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,16,displayMetrics);
        float topMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,12,displayMetrics);

        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) topLayout.getLayoutParams();
        params.width = (int) w;
        params.height = (int) h;
        topLayout.setLayoutParams(params);

        int xOffset = 0;  // X轴偏移量
        int yOffset = 0; // y轴偏移量
        int arrowOffset = 0; // 箭头的偏移量

        int[] location = new int[2];
        anchor.getLocationOnScreen(location);

        Rect anchorRect = new Rect(location[0], location[1], location[0] + anchor.getWidth(), location[1] + anchor.getHeight());
        int screenWidth = displayMetrics.widthPixels;
        int rootWidth = (int) (w + leftMargin);
        int rootHeight = (int) (h + topMargin + arrowHeight / 2);

        contentView.measure(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//        int rootHeight = contentView.getMeasuredHeight(); //弹出框的高度
        Log.i("jiao","rootWidth="+rootWidth+" rootHeight="+rootHeight+" h="+h+" topMargin="+topMargin+" arrowHeight="+arrowHeight+" screenWidth="+screenWidth);

        //计算X轴偏移量
        if ((anchorRect.centerX() + rootWidth / 2.0) > screenWidth) {
            xOffset = anchorRect.centerX() - rootWidth / 2 - (rootWidth / 2 - (screenWidth - anchorRect.centerX())) - 6;
        } else if (anchorRect.centerX() - rootWidth / 2.0 < 0) {
            xOffset = 6;
        } else {
            xOffset = anchorRect.centerX() - (rootWidth / 2);
        }

        arrowOffset = anchorRect.centerX() - xOffset;
        Log.i("jiao","arrowOffset="+arrowOffset+" xOffset="+xOffset+" yOffset="+yOffset);

        // 弹出框在被点按钮上方
        yOffset = anchorRect.top - rootHeight ;
        showArrow(arrowIv,arrowOffset);

        popupWindow.showAtLocation(anchor, Gravity.NO_GRAVITY, xOffset, yOffset);
    }

    /**
     * 显示箭头
     *
     * @param
     * @return
     * @author Huangming
     * @date 2016/6/4
     * @modified [describe][editor][date]
     */
    private void showArrow(View arrowUp,int arrowOffset) {
        final int arrowWidth = arrowUp.getMeasuredWidth();

        Log.i("jiao"," arrowWidth="+arrowWidth);
        ViewGroup.MarginLayoutParams param = (ViewGroup.MarginLayoutParams) arrowUp.getLayoutParams();
        param.leftMargin = arrowOffset - arrowWidth / 2;
        arrowUp.setLayoutParams(param);

    }

    private void initLocation(){
//        int half = (int) (w / 2);
//
//        int center = location[0] - half;
//        int right = location[0] + half;
//
//        int offsetX = 0;
//        Log.i("jiao","location[0]="+location[0]+" location[1]="+location[1]+" half="+half+" center="+center+" right="+right);
//
//        boolean isCenter = false;
//        if (center > 0){
//            //居中
//            isCenter = true;
//            offsetX = half - view.getWidth() / 2;
//        }else if (right >= displayMetrics.widthPixels){
//            //检测靠右
//            offsetX = (int) w;
//        }else{
//
//        }
//
//        Log.i("jiao"," offsetX="+offsetX);
//
//        //计算箭头的移动位置
//        //宽度比值
//        float factor = view.getWidth() / w;
//        //button 中点坐标
//        float centerX = view.getWidth() / 2;
//        //计算出popWindow 对就的宽度
//        float ww = centerX * factor + arrowHeight + offsetX;
//        //计算popWindow 百分比
//        float wwPercent = ww / w;
//
//        //移动箭头按钮
//        ConstraintLayout.LayoutParams arrowParams = (ConstraintLayout.LayoutParams) arrowIv.getLayoutParams();
//        arrowParams.horizontalBias = isCenter ? 0.5f: wwPercent;
//        arrowIv.setLayoutParams(arrowParams);
    }
}
