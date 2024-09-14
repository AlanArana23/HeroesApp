package com.example.heroesapp.models

//Creando una lista de usuarios con nombre y contraseña
data class User(val email:String, val password: String){
    companion object{
        val users = listOf(
            User("alanfx3@gmail.com", "1234"),
            User("gus75@gmail.com", "5678"),
        )
    }
}
