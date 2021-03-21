package com.translation.kotlin.lazy

import androidx.lifecycle.Lifecycle
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

abstract class LifeCycledBindingDelegate<F,T>(lifecycle: Lifecycle): ReadOnlyProperty<F,T> {

     var property: T? = null

    init {
        lifecycle.addOnDestroyOnce { destroy() }
    }

    private fun destroy(){
        property = null
    }

    override fun getValue(thisRef: F, property: KProperty<*>): T {
        TODO("Not yet implemented")
    }
}