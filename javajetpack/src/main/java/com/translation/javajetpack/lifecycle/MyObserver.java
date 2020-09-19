package com.translation.javajetpack.lifecycle;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MyObserver implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void addElement(){
        Log.i("jiao"," addElement observer .... ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void removeElement(){
        Log.i("jiao"," removeElement observer .... ");
    }

}
