package com.andre.pokedex_android.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andre.pokedex_android.R
import com.andre.pokedex_android.domain.Pokemon
import kotlinx.android.synthetic.main.pokemon_items.view.*

class PokemonAdapter(
    private val items: List<Pokemon> //Uma boa pratica privar essa constante pois
): RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        /**
         * Bindview é o metodo que sabe como compor do viewholder
         * que sabe como compor os itens dessa view
         */
        holder.bindView(item)
    }

    override fun getItemCount() = items.size

    /**
     * Cada Card de Pokemon precisa ser passado como item list para o View Holder
     * Para cada card tenha um viewholder por tras e vai ter um XML do layout por tras
     * ele ira instaciar o Pokemon item
     */
   class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
       fun bindView(item: Pokemon) = with(itemView){
               val ivPokemon = findViewById<ImageView>(R.id.ivPokemon)
               val ivNumber = findViewById<TextView>(R.id.tvNumber)
               val ivName = findViewById<TextView>(R.id.tvName)
               val ivType1 = findViewById<TextView>(R.id.tvType01)
               val ivType2 = findViewById<TextView>(R.id.tvType02)
               // TODO: Load image with Glide

               tvNumber.text =  "N° ${item.number}"
               tvName.text = item.name
               tvType01.text = item.types[0].name

               if (item.types.size > 1){
                   tvType02.visibility = View.VISIBLE
               } else {
                   tvType02.visibility = View.GONE
               }
           }
       }
   }
