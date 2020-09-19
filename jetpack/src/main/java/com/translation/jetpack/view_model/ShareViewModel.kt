package com.translation.jetpack.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShareViewModel : ViewModel() {

    val user = MutableLiveData<String>()

}