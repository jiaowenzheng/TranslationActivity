package com.translation.kotlin.lazy

import android.view.View
import androidx.annotation.IdRes
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlin.reflect.KProperty

class BindView<T: View>(
    private val targetClazz: Class<T>,
    private val rootViewProvider: ViewProvider,
    @IdRes val resId: Int,
    lifecycle: Lifecycle,
    private var onBind: (T.() -> Unit)?
): LifeCycledBindingDelegate<Any,T>(lifecycle) {

    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        return this.property ?: let {

            val rootView = rootViewProvider.provide()
            val v = rootView.findViewById<T>(resId)
                ?: throw IllegalStateException("could not findViewById by id ")

            v.apply {
                this@BindView.property = this
                onBind?.invoke(this)
                onBind = null
            }
        }

    }
}