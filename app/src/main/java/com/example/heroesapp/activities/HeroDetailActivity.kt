package com.example.heroesapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.heroesapp.R

class HeroDetailActivity : AppCompatActivity() {

    private lateinit var backButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_detail)
        initializeUI()
        handleBackButton()
    }

    private fun initializeUI() {
        // Inicializa las vistas
        backButton = findViewById(R.id.back_list)
    }

    private fun handleBackButton() {
        // Configura el botón de retroceso para regresar a PublisherActivity
        backButton.setOnClickListener {
            startActivity(Intent(this, PublisherActivity::class.java))
            finish()
        }
    }
}