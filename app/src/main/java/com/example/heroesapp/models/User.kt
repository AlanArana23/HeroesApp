package com.example.heroesapp.models

data class User(val email:String, val password: String){
    companion object{
        val users = listOf(
            User("alanfx3@gmail.com", "1234"),
            User("gus75@gmail.com", "5678"),
        )
    }
}
