package com.dicoding.wisata_banymuas
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WisataBanyumas(
    val name: String,
    val description: String,
    val photo: String

) : Parcelable
