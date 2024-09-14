package com.example.heroesapp.models

import android.os.Parcel
import android.os.Parcelable

data class CharacterItem(val id: Int, val name: String, val imageUrl: String) : Parcelable {

    // Constructor que toma un Parcel
    private constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    // Método para escribir en el Parcel
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(imageUrl)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<CharacterItem> {
        override fun createFromParcel(parcel: Parcel): CharacterItem {
            return CharacterItem(parcel)
        }

        override fun newArray(size: Int): Array<CharacterItem?> {
            return arrayOfNulls(size)
        }

        // Lista estática de personajes
        val characters = mutableListOf(
            CharacterItem(1, "Doctor Strange", "https://i.imgur.com/uBngvBU.jpeg"),
            CharacterItem(2, "Black Panther", "https://i.imgur.com/k5B2ZqS.jpeg"),
            CharacterItem(3, "Captain Marvel", "https://i.imgur.com/Q6OSNrx.jpeg"),
            CharacterItem(4, "Vision", "https://i.imgur.com/av2UR6Y.jpeg"),
            CharacterItem(5, "Ant-Man", "https://i.imgur.com/N7QMRRR.jpeg"),
            CharacterItem(6, "Hawkeye", "https://i.imgur.com/8evpxVX.jpeg"),
            CharacterItem(7, "Falcon", "https://i.imgur.com/QDC4zES.jpeg"),
            CharacterItem(8, "Winter Soldier", "https://i.imgur.com/t7lm6Ja.jpeg"),
            CharacterItem(9, "Black Widow", "https://i.imgur.com/KoSb8kW.jpeg"),
            CharacterItem(10, "Star-Lord", "https://i.imgur.com/l1A5jWF.jpeg"),
            CharacterItem(11, "Gamora", "https://i.imgur.com/2NZzRWZ.jpeg"),
            CharacterItem(12, "Drax", "https://i.imgur.com/3SZ2qZJ.jpeg"),
            CharacterItem(13, "Rocket Raccoon", "https://i.imgur.com/Tm2P8hJ.jpeg"),
            CharacterItem(14, "Groot", "https://i.imgur.com/vP6KHm9.jpeg"),
            CharacterItem(15, "Mantis", "https://i.imgur.com/lb9DJc8.jpeg"),
            CharacterItem(16, "Nebula", "https://i.imgur.com/fM4W4CN.jpeg"),
            CharacterItem(17, "Yondu", "https://i.imgur.com/Zn6R82h.jpeg"),
            CharacterItem(18, "Doctor Doom", "https://i.imgur.com/oGHMOXQ.jpeg"),
            CharacterItem(19, "Magneto", "https://i.imgur.com/5c6OGiC.jpeg"),
            CharacterItem(20, "Mystique", "https://i.imgur.com/dXHnFi7.jpeg")
        )
    }
}