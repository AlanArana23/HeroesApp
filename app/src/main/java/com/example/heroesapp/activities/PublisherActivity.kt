package com.example.heroesapp.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
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
import com.example.heroesapp.models.Publisher
import java.util.concurrent.Flow

class PublisherActivity : AppCompatActivity() {
    lateinit var logoutBtn : ImageView
    //Referencia a nuestro recyclerView

    //Referenciando al boton de dc
    //Referenciando al boton de marvel
    lateinit var dcBtn : ImageButton
    lateinit var marvelBtn : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.publisher_activity)
        val sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE)
        logoutBtn = findViewById(R.id.logoutBtn)

        //Encontrar nuestros elementos por id
        dcBtn = findViewById(R.id.dc)
        marvelBtn = findViewById(R.id.marvel)



        logoutBtn.setOnClickListener{
            Log.i("LOGOUT","CERRANDO SESION")
            val editor = sharedPreferences.edit()
            editor.remove("isLogged")
            editor.apply()

            // Para navegar entre activities usamos intent
            val intent = Intent(this@PublisherActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        dcBtn.setOnClickListener {
            val dcCharacters = CharacterItem.characters.filter { it.id in 11..20 } // Filtrar los personajes de DC
            val intent = Intent(this@PublisherActivity, HeroesActivity::class.java)
            intent.putParcelableArrayListExtra("CHARACTERS_LIST", ArrayList(dcCharacters)) // Pasar los personajes de DC
            intent.putExtra("COLOR", "#0078F2") // Pasar el color azul para DC
            startActivity(intent)
        }

        marvelBtn.setOnClickListener {
            val marvelCharacters = CharacterItem.characters.filter { it.id in 1..10 } // Filtrar los personajes de Marvel
            val intent = Intent(this@PublisherActivity, HeroesActivity::class.java)
            intent.putParcelableArrayListExtra("CHARACTERS_LIST", ArrayList(marvelCharacters)) // Pasar los personajes de Marvel
            intent.putExtra("COLOR", "#ED1D24") // Pasar el color rojo para Marvel
            startActivity(intent)
        }
    }
}