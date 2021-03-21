package com.translation.kotlin.lazy

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

internal class OnDestroyObserver(var lifecycle: Lifecycle?,val destroyed:() -> Unit):
    LifecycleEventObserver {

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        val state = source.lifecycle.currentState
        if (state == Lifecycle.State.DESTROYED){
            destroyed()
            lifecycle?.apply {
                removeObserver(this@OnDestroyObserver)
                lifecycle = null
            }
        }
    }

}