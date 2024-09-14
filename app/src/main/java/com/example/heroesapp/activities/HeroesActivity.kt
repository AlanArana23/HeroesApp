package com.example.heroesapp.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.heroesapp.MainActivity
import com.example.heroesapp.R
import com.example.heroesapp.adapters.CharacterItemAdapter
import com.example.heroesapp.models.CharacterItem


class HeroesActivity : AppCompatActivity() {

    lateinit var backHeroes : ImageView
    lateinit var itemRecyclerView: RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_heroes)

        // Recibe el color enviado desde PublisherActivity
        val colorHex = intent.getStringExtra("COLOR")
        colorHex?.let {
            val color = Color.parseColor(it)
            window.decorView.setBackgroundColor(color) // Aplica el color de fondo
        }

        // Recibe la lista de personajes filtrados
        val charactersList = intent.getParcelableArrayListExtra<CharacterItem>("CHARACTERS_LIST")

        // Inicializa el botón de retroceso
        backHeroes = findViewById(R.id.back_heroes)
        backHeroes.setOnClickListener{
            val intent = Intent(this@HeroesActivity, PublisherActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Configura el RecyclerView con la lista filtrada de personajes
        itemRecyclerView = findViewById(R.id.heroes_list)
        itemRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // Verifica que la lista de personajes no sea nula
        charactersList?.let {
            itemRecyclerView.adapter = CharacterItemAdapter(it)
        }
    }
}
