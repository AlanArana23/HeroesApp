package com.example.heroesapp.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.heroesapp.MainActivity
import com.example.heroesapp.R
import com.example.heroesapp.models.CharacterItem

class PublisherActivity : AppCompatActivity() {

    private lateinit var logoutBtn: ImageView
    private lateinit var dcBtn: ImageButton
    private lateinit var marvelBtn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.publisher_activity)

        initializeUI()
        setupLogoutButton()
        setupPublisherButtons()
    }

    private fun initializeUI() {
        // Inicializa las vistas
        logoutBtn = findViewById(R.id.logoutBtn)
        dcBtn = findViewById(R.id.dc)
        marvelBtn = findViewById(R.id.marvel)
    }

    private fun setupLogoutButton() {
        // Configura el botón de cerrar sesión
        val sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE)

        logoutBtn.setOnClickListener {
            Log.i("LOGOUT", "CERRANDO SESION")
            with(sharedPreferences.edit()) {
                remove("isLogged")
                apply()
            }

            // Navegar a MainActivity al cerrar sesión
            startActivity(Intent(this@PublisherActivity, MainActivity::class.java))
            finish()
        }
    }

    private fun setupPublisherButtons() {
        // Configura los botones de DC y Marvel
        dcBtn.setOnClickListener {
            navigateToHeroesActivity(
                CharacterItem.characters.filter { it.id in 11..20 },
                "#0078F2" // Color azul para DC
            )
        }

        marvelBtn.setOnClickListener {
            navigateToHeroesActivity(
                CharacterItem.characters.filter { it.id in 1..10 },
                "#ED1D24" // Color rojo para Marvel
            )
        }
    }

    private fun navigateToHeroesActivity(characters: List<CharacterItem>, color: String) {
        // Navega a HeroesActivity con la lista de personajes y el color correspondiente
        val intent = Intent(this@PublisherActivity, HeroesActivity::class.java).apply {
            putParcelableArrayListExtra("CHARACTERS_LIST", ArrayList(characters))
            putExtra("COLOR", color)
        }
        startActivity(intent)
    }
}