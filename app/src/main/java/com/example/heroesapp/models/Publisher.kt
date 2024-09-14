package com.example.heroesapp.models

data class Publisher(val id: Int, val name: String, val image: String){
    companion object{
        val publishers = mutableListOf<Publisher>(
            Publisher(1,"Dc", "https://i.imgur.com/dXDmuiK.png"),
            Publisher(2,"Marvel","https://i.imgur.com/DpgvPgc.png")
        )
    }
}
