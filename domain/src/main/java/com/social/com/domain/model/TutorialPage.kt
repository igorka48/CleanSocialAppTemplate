package com.social.com.domain.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by igor on 3/16/17.
 */
data class TutorialPage(val title: String?) : Parcelable {
    companion object {
        @JvmField val CREATOR: Parcelable.Creator<TutorialPage> = object : Parcelable.Creator<TutorialPage> {
            override fun createFromParcel(source: Parcel): TutorialPage = TutorialPage(source)
            override fun newArray(size: Int): Array<TutorialPage?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(source.readString())

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(title)
    }
}