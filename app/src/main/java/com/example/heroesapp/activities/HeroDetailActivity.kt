package com.example.heroesapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.heroesapp.R

class HeroDetailActivity : AppCompatActivity() {

    lateinit var backbtn : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hero_detail)


        //Regresando al activity anterior
        backbtn = findViewById(R.id.back_list)
        backbtn.setOnClickListener{
            val intent = Intent(this@HeroDetailActivity, PublisherActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}