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
        var ios13Mobile = Mobile("Apple","iPhone 13","iOS 15","Dual 12MP Ultra Wide and Wide cameras")
        var samsungA50Mobile = Mobile("Samsung","A50","Android 9","Fingerprint (under display, optical),gyro, proximity, compass")
        var iosMobile11 = Mobile("Apple ","iPhone 11"," iOS 13","Water resistant,Increased battery life")
        val mobileList = mutableListOf<Mobile>(samsungA12Mobile,samsungA50Mobile,ios13Mobile,iosMobile11)
       // mobiles.value?.let { mobileList.addAll(it) }
        _mobiles.value= mobileList
    }
}