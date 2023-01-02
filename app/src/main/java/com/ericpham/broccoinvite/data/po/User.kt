package com.ericpham.broccoinvite.data.po

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String
) : Parcelable
