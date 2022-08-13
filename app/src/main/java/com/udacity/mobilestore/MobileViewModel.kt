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
        var samsungA12Mobile = Mobile("Samsung 123","Galaxy A12","Android 10","Finger Print (side-mounted) ,accelerometer")
        var iosMobile = Mobile("Apple","iPhone 13"," iOS 15","Water resistant,Increased battery life")
        var iosMobile1 = Mobile("Apple 1","iPhone 13"," iOS 15","Water resistant,Increased battery life")
        var iosMobile2 = Mobile("Apple 2","iPhone 13"," iOS 15","Water resistant,Increased battery life")
        val mobileList = mutableListOf<Mobile>(samsungA12Mobile,iosMobile,iosMobile1,iosMobile2)
       // mobiles.value?.let { mobileList.addAll(it) }
        _mobiles.value= mobileList
    }
}