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

    init {
        _mobiles.value=mutableListOf<Mobile>()
        insertMockData()
    }

    fun insertMockData() {
        addMobile(
            "Samsung",
            "Galaxy A12",
            "Android 10",
            "Finger Print (side-mounted) ,accelerometer"
        )
        addMobile("Samsung", "Galaxy S10", "Android 9", "Barometer, heart rate, SpO2")
        addMobile("Apple", "iPhone 13", "iOS 15", "Dual 12MP Ultra Wide and Wide cameras")
        addMobile(
            "Samsung",
            " Galaxy A50",
            "Android 9",
            "Fingerprint (under display, optical),gyro, proximity, compass"
        )
        addMobile("Apple ", "iPhone 11", " iOS 13", "Water resistant,Increased battery life")
        addMobile("Apple ", "iPhone 7", " iOS 10.0.1", "Fingerprint (front-mounted) ")
        addMobile("LG ", "G8 ThinQ", " Android 9", "Face ID, Hand ID, fingerprint (rear-mounted)")
        addMobile("Oppo", "A3s", " Android 8.1", "Accelerometer, gyro, proximity, compass")
        addMobile(
            "Nokia",
            "G21",
            " Android 11",
            "Fingerprint (side-mounted), accelerometer, proximity"
        )
    }

    fun addMobile(company: String, model: String, osVersion: String, feature: String) {
        var mobile = Mobile(company, model, osVersion, feature)
        _mobiles.value?.add(mobile)
        println(_mobiles.value)

    }

    fun addUserMobile() {
       addMobile(company, model, osVersion, feature)
    }
}