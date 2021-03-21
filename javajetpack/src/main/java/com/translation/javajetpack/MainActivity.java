package com.translation.javajetpack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.translation.javajetpack.lifecycle.MyObserver;
import com.translation.javajetpack.view_model.UserModel;
import com.translation.javajetpack.view_model.UserModelFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private ImageView  cover;

    private String content="森系哥特（Woodland Goth）”又名“暗黑仙女美学（Dark Fairy-core）”是一种将哥特式文化的黑暗浪漫元素与浅色主题（例如花朵或柔软的林地动物）结合在一起的美学。\n" +
            "它从“精灵美学（Goblincore）”，“仙女美学（Fairycore）”，“田园派（ Cottagecore）”中寻找灵感，也和“哥特洛丽塔（Gothic Lolita）”，或“浪漫哥特（Romantic Goth）”相关。\n" +
            "废弃的建筑物或农舍；仙女；旧刻痕，例如瓷娃娃；蘑菇；采花；诗歌；蜡烛和旧灯；迷雾森林。\n" +
            "森系哥特的服饰都很花哨，对于与其相关的农业工作来说是不切实际的。\n" +
            "森系哥特的时尚：哥特式洛丽塔式大裙摆，通常在下面穿衬裙；手工编织的配件，例如羊毛帽或围巾；花饰首饰；花卉印花；丝袜或绑腿；阳伞。";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView contentTv = findViewById(R.id.tv_content);
        cover = findViewById(R.id.iv_cover);

//        getLifecycle().addObserver(new MyObserver());
//
//        parse();
//        Log.i("jiao"," onCreate init ........");
//        UserModel  userModel =  new ViewModelProvider(getViewModelStore(),new UserModelFactory()).get(UserModel.class);
//
//        checkPermission();
//        String content1 = "content://media/external/file/64073";
//        String content = "content://media/external/file/64482";
//
//        RequestOptions requestOptions = new RequestOptions();
//        requestOptions.centerCrop();
//        Glide.with(this)
//                .load("http://img8.ontheroadstore.com/upload/201210/1c1631d92f7a024f727de3b308bc7b6c.jpg?x-oss-process=image/resize,p_50/format,webp")
//                .apply(requestOptions)
//                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
//                .into(cover);


        String text = filterStringRegex(content);
        Log.i("jiao","text="+text);
        contentTv.setText(text);
    }

    public String filterStringRegex(String content){
        if (!TextUtils.isEmpty(content)){
            Pattern pattern = Pattern.compile("\\s*|\t|\r|\n");
            Matcher matcher = pattern.matcher(content);
            return matcher.replaceAll("");
        }

        return content;
    }

    /**
     *
     * android 6.0运行时权限检查
     *
     */
    public void checkPermission() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int storePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

            if (storePermission != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            } else if (storePermission == PackageManager.PERMISSION_DENIED) {
//                PermissionUtils utils = new PermissionUtils();
//                if (utils.isMIUI()) {
//                    new PermissionUtils().showOpenPermissionDialog(this);
//                } else {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
//                }
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("jiao"," onRestoreInstanceState init ........");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("jiao"," onSaveInstanceState init ........");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("jiao"," onRestart init ........");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("jiao"," onStart init ........");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("jiao"," onResume init ........");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("jiao"," onPause init ........");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("jiao"," onStop init ........");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("jiao"," onDestroy init ........");
    }

    public void parse(){
        String json = getFileString(this,"json.json");
        ProductDetailModel model = JSON.parseObject(json, ProductDetailModel.class);
        Log.i("jiao"," product = "+model.getPost());
    }

    /**
     * 获取asset 文件夹下的文件的内容
     *
     * @param context
     * @param fileName
     * @return
     */
    public static String getFileString(Context context,String fileName) {

        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assetManager = context.getAssets();
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

}
