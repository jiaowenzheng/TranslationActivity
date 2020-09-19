package com.translation.javajetpack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;

import android.os.Bundle;
import android.util.Log;

import com.translation.javajetpack.lifecycle.MyObserver;
import com.translation.javajetpack.view_model.UserModel;
import com.translation.javajetpack.view_model.UserModelFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getLifecycle().addObserver(new MyObserver());

        Log.i("jiao"," onCreate init ........");
        UserModel  userModel =  new ViewModelProvider(getViewModelStore(),new UserModelFactory()).get(UserModel.class);
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
}
