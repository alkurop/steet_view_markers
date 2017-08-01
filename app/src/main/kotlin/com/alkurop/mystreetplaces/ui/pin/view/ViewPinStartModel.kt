package com.alkurop.mystreetplaces.ui.pin.view

import android.os.Parcel
import android.os.Parcelable

data class ViewPinStartModel(val shoudShowStreetNavigation: Boolean = false,
                             val shouldShowMap: Boolean = false,
                             val pinId:String) : Parcelable {
    companion object {
        @JvmField val CREATOR: Parcelable.Creator<ViewPinStartModel> = object : Parcelable.Creator<ViewPinStartModel> {
            override fun createFromParcel(source: Parcel): ViewPinStartModel = ViewPinStartModel(source)
            override fun newArray(size: Int): Array<ViewPinStartModel?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
    1 == source.readInt(),
    1 == source.readInt(),
    source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt((if (shoudShowStreetNavigation) 1 else 0))
        dest.writeInt((if (shouldShowMap) 1 else 0))
        dest.writeString(pinId)
    }
}