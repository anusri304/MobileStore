package com.udacity.mobilestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class Mobile(var company: String,  var model: String, var osVersion: String,var feature: String)
