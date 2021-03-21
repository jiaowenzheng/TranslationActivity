package com.translation.kotlin.lazy

import android.view.View
import androidx.activity.ComponentActivity
import androidx.annotation.LayoutRes
import androidx.lifecycle.Lifecycle

const val MESSAGE_MSG = 1

fun Lifecycle.addOnDestroyOnce(destroyed: () -> Unit){
    addObserver(OnDestroyObserver(this,destroyed))
}

inline fun <reified T : View> ComponentActivity.bindView(@LayoutRes resId: Int)=
    BindView(
        targetClazz = T::class.java,
        rootViewProvider = object : ViewProvider{
            override fun provide(): View {
                return this@bindView.window.decorView
            }
        },
        resId = resId,
        lifecycle = this.lifecycle,
        onBind = null
    )

inline fun <reified T: View> Any.bindView(
    rootViewProvider: ViewProvider,
    @LayoutRes resId: Int,
    lifecycle: Lifecycle,
    noinline onBind:(T.() -> Unit)?
)=
    BindView(
        targetClazz = T::class.java,
        rootViewProvider = rootViewProvider,
        resId = resId,
        lifecycle = lifecycle,
        onBind = onBind
    )
