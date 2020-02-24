package com.example.keepnotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.ieselcaminas.cristina.proyectoclase.R

class NotasAdapter(var items: ArrayList<NotasItem>) : RecyclerView.Adapter<NotasAdapter.TarjViewHolder>() {

    lateinit var onClick: (View) -> Unit

    init {
         this.items = items
    }

    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var titulo: TextView
        var contenido: TextView


         init {
             titulo = itemView.findViewById(R.id.titulo)
             contenido = itemView.findViewById(R.id.contenido)
         }

         fun bindTarjeta(t: NotasItem, onClick: (View) -> Unit) = with(itemView) {
             titulo.setText(t.titulo)
             contenido.setText(t.contenido)

             setOnClickListener{ onClick(itemView) }
         }


    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
         val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_nota, viewGroup, false)
         return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
         val item = items.get(pos)
         viewHolder.bindTarjeta(item, onClick)

    }

    override fun getItemCount(): Int {
         return items.size
    }
}