package com.udacity.mobilestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.mobilestore.models.Mobile

class MobileViewModel : ViewModel() {
    private val _mobiles = MutableLiveData<MutableList<Mobile>>()
    val mobiles: LiveData<MutableList<Mobile>>
           get() = _mobiles
    init {
       initMobiles()
    }

    private fun initMobiles() {
        var samsungA12Mobile = Mobile("Samsung","Galaxy A12","Android 10","Finger Print (side-mounted) ,accelerometer")
        var iosMobile = Mobile("Apple","iPhone 13"," iOS 15","Water resistant,Increased battery life")
        val mobileList = mutableListOf<Mobile>(samsungA12Mobile,iosMobile)
       // mobiles.value?.let { mobileList.addAll(it) }
        _mobiles.value= mobileList
        TODO("Not yet implemented")
    }
}