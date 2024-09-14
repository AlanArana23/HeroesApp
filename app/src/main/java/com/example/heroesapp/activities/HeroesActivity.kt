package com.example.heroesapp.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.heroesapp.R
import com.example.heroesapp.adapters.CharacterItemAdapter
import com.example.heroesapp.models.CharacterItem

class HeroesActivity : AppCompatActivity() {

    private lateinit var backHeroes: ImageView
    private lateinit var itemRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroes)
        initializeUI()
        configureRecyclerView()
        handleBackButton()
    }

    private fun initializeUI() {
        // Configura el color de fondo si se recibió un color en el Intent
        intent.getStringExtra("COLOR")?.let { colorHex ->
            val color = Color.parseColor(colorHex)
            window.decorView.setBackgroundColor(color)
        }

        // Inicializa las vistas
        backHeroes = findViewById(R.id.back_heroes)
        itemRecyclerView = findViewById(R.id.heroes_list)
    }

    private fun configureRecyclerView() {
        // Configura el RecyclerView con la lista filtrada de personajes
        itemRecyclerView.layoutManager = LinearLayoutManager(this)
        intent.getParcelableArrayListExtra<CharacterItem>("CHARACTERS_LIST")?.let { charactersList ->
            itemRecyclerView.adapter = CharacterItemAdapter(charactersList)
        }
    }

    private fun handleBackButton() {
        // Configura el botón de retroceso para regresar a PublisherActivity
        backHeroes.setOnClickListener {
            startActivity(Intent(this, PublisherActivity::class.java))
            finish()
        }
    }
}