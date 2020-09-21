package com.example.skymobiletest.homeScreen

import android.os.Parcel
import android.os.Parcelable

// Inline function to create Parcel Creator
inline fun <reified T : Parcelable> createParcel(crossinline createFromParcel: (Parcel) -> T?): Parcelable.Creator<T> =
    object : Parcelable.Creator<T> {
        override fun createFromParcel(source: Parcel): T? = createFromParcel(source)
        override fun newArray(size: Int): Array<out T?> = arrayOfNulls(size)
    }

// custom readParcelable to avoid reflection
fun <T : Parcelable> Parcel.readParcelable(creator: Parcelable.Creator<T>): T? {
    if (readString() != null) return creator.createFromParcel(this) else return null
}

open class MovieModel(
    var id: String,
    var title: String,
    var overview: String,
    var duration: String,
    var release_year: String,
    var cover_url: String
) : Parcelable {

    constructor(parcelIn: Parcel) : this(
        id = parcelIn.readString(),
        title = parcelIn.readString(),
        overview = parcelIn.readString(),
        duration = parcelIn.readString(),
        release_year = parcelIn.readString(),
        cover_url = parcelIn.readString()
    )


    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(id)
        dest.writeString(title)
        dest.writeString(overview)
        dest.writeString(duration)
        dest.writeString(release_year)
        dest.writeString(cover_url)
    }

    companion object {
        @JvmField
        @Suppress("unused")
        val CREATOR = createParcel { MovieModel(it) }
    }
}


class MovieViewModel(
    var backdrops_url: String? = null,
    id: String,
    title: String,
    overview: String,
    duration: String,
    release_year: String,
    cover_url: String
) : MovieModel(
    id,
    title,
    overview,
    duration,
    release_year,
    cover_url
) {

    constructor(parcelIn: Parcel) : this(
        backdrops_url = parcelIn.readString(),
        id = parcelIn.readString(),
        title = parcelIn.readString(),
        overview = parcelIn.readString(),
        duration = parcelIn.readString(),
        release_year = parcelIn.readString(),
        cover_url = parcelIn.readString()
    )


    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(backdrops_url)
        super.writeToParcel(dest, flags)

    }

    companion object {
        @JvmField
        @Suppress("unused")
        val CREATOR = createParcel { MovieViewModel(it) }
    }

}