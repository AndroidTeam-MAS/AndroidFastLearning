package com.example.myapplication.Activity

import android.os.Parcel
import android.os.Parcelable

data class userClass(
    var firstname: String?,
    var lastname: String?,
    var telephone: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(firstname)
        parcel.writeString(lastname)
        parcel.writeString(telephone)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<userClass> {
        override fun createFromParcel(parcel: Parcel): userClass {
            return userClass(parcel)
        }

        override fun newArray(size: Int): Array<userClass?> {
            return arrayOfNulls(size)
        }
    }
}