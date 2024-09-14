package com.example.heroesapp.adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.heroesapp.R
import com.example.heroesapp.activities.HeroDetailActivity
import com.example.heroesapp.activities.HeroesActivity
import com.example.heroesapp.models.CharacterItem
import com.squareup.picasso.Picasso
import java.util.Locale.Category

class CharacterItemAdapter(val itemList: List<CharacterItem>): RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hero_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        //Aqui se contiene toda la logica
        val items = itemList[position]
        holder.itemImage
        Picasso.get().load(items.imagen).into(holder.itemImage)

        //rama de test
        holder.itemView.setOnClickListener{
            Log.d("CharacterItemAdapter", "Item clicked: ${items.name}")
            val context = holder.itemView.context
            val intent = Intent(context, HeroDetailActivity::class.java)
            context.startActivity(intent)
        }
    }

}

class ItemViewHolder(val view: View): ViewHolder(view){
    val itemImage : ImageView = view.findViewById(R.id.item_image)
}