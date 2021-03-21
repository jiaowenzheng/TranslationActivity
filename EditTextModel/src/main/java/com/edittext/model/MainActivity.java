package com.edittext.model;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestOptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView avatar = findViewById(R.id.iv_avatar);

        RequestOptions options = new RequestOptions();
        options.transform(new CropCircleTransformation(this));

        Glide.with(this)
                .asBitmap()
                .load("http://img8.ontheroadstore.com/iosupload/20201109/NjhaSEYwcnFWVXpmQ3BIWXI0VWdoQT09.jpg")
                .apply(options)
                .into(avatar);

    }
}