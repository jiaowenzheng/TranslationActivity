package com.translation.sample.widget;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView;

import com.translation.sample.R;

/**
 * @author JiaoWenZheng
 */
public class StrokeTextView extends AppCompatTextView {
    private TextView borderText = null;

    private int mStrokeColor = Color.BLACK;
    private int mStrokeWidth = 1;

    public StrokeTextView(Context context) {
        super(context);
        borderText = new TextView(context);
        init(context,null);
    }

    public StrokeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        borderText = new TextView(context,attrs);
        init(context,attrs);
    }

    public StrokeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        borderText = new TextView(context,attrs,defStyle);
        init(context,attrs);
    }

    public void init(Context context, AttributeSet attrs){

        if (attrs != null){
           TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.StrokeTextView);
            mStrokeWidth = typedArray.getInt(R.styleable.StrokeTextView_custom_stroke_width,mStrokeWidth);
            mStrokeColor = typedArray.getColor(R.styleable.StrokeTextView_custom_stroke_color,mStrokeColor);
            typedArray.recycle();
        }

        TextPaint tp1 = borderText.getPaint();
        //设置描边宽度
        tp1.setStrokeWidth(mStrokeWidth);
        //对文字只描边
        tp1.setStyle(Paint.Style.STROKE);
        //设置描边颜色
        borderText.setTextColor(mStrokeColor);
        borderText.setGravity(getGravity());
    }

    @Override
    public void setLayoutParams (ViewGroup.LayoutParams params){
        super.setLayoutParams(params);
        borderText.setLayoutParams(params);
    }

    @Override
    protected void onLayout (boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        borderText.layout(left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        CharSequence tt = borderText.getText();

        //两个TextView上的文字必须一致
        if(tt== null || !tt.equals(this.getText())){
            borderText.setText(getText());
            this.postInvalidate();
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        borderText.measure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        borderText.draw(canvas);
        super.onDraw(canvas);
    }
}
