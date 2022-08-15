package com.udacity.mobilestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.mobilestore.models.Mobile

class MobileViewModel : ViewModel() {
    private val _mobiles = MutableLiveData<MutableList<Mobile>>()
    val mobiles: LiveData<MutableList<Mobile>>
        get() = _mobiles
    var company = ""
    var model = ""
    var osVersion = ""
    var feature = ""
    var mobileList = mutableListOf<Mobile>()

    init {
        initMobiles()
    }

    private fun initMobiles() {
        var samsungA12Mobile = Mobile(
            "Samsung",
            "Galaxy A12",
            "Android 10",
            "Finger Print (side-mounted) ,accelerometer"
        )
        var samsungS10Mobile =
            Mobile("Samsung", "Galaxy S10", "Android 9", "Barometer, heart rate, SpO2")
        var ios13Mobile =
            Mobile("Apple", "iPhone 13", "iOS 15", "Dual 12MP Ultra Wide and Wide cameras")
        var samsungA50Mobile = Mobile(
            "Samsung",
            " Galaxy A50",
            "Android 9",
            "Fingerprint (under display, optical),gyro, proximity, compass"
        )
        var iosMobile11 =
            Mobile("Apple ", "iPhone 11", " iOS 13", "Water resistant,Increased battery life")
        var iosMobile7 = Mobile("Apple ", "iPhone 7", " iOS 10.0.1", "Fingerprint (front-mounted) ")
        var lgMobileG8 =
            Mobile("LG ", "G8 ThinQ", " Android 9", "Face ID, Hand ID, fingerprint (rear-mounted)")
        var oppoMobileA3 =
            Mobile("Oppo", "A3s", " Android 8.1", "Accelerometer, gyro, proximity, compass")
        var nokiaG21 = Mobile(
            "Nokia",
            "G21",
            " Android 11",
            "Fingerprint (side-mounted), accelerometer, proximity"
        )
        mobileList = mutableListOf<Mobile>(
            samsungA12Mobile,
            samsungA50Mobile,
            samsungS10Mobile,
            ios13Mobile,
            iosMobile11,
            iosMobile7,
            lgMobileG8,
            oppoMobileA3,
            nokiaG21
        )
        // mobiles.value?.let { mobileList.addAll(it) }
        _mobiles.value = mobileList
    }

    fun addMobile() {
        var mobile = Mobile(company, model, osVersion, feature)
        mobileList.add(mobile)
        _mobiles.value = mobileList

    }

    fun resetMobile() {
        company=""
        model=""
        osVersion=""
        feature=""
    }

    fun validate():Boolean{
        return ! company.equals("")&& !model.equals("")&& !osVersion.equals("")&& !feature.equals("")
    }
}