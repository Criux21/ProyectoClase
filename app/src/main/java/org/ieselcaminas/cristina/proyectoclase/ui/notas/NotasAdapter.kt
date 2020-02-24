package com.example.keepnotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.ieselcaminas.cristina.proyectoclase.R

class NotasAdapter(var items: ArrayList<NotasItem>) : RecyclerView.Adapter<NotasAdapter.TarjViewHolder>() {

    lateinit var onClick: (View) -> Unit //hay que hacer el metodo on click manualmente **

    init { //items es nuestra array list de cartas
         this.items = items
    }

    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var texto: TextView

         init {
             texto = itemView.findViewById(R.id.textView)
         }

         fun bindTarjeta(t: NotasItem, onClick: (View) -> Unit) = with(itemView) {
             texto.setText(t.titulo)

             setOnClickListener{ onClick(itemView) }//junto con el onlick view de arriba, para lo del manual onclick*
         }


    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
         val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_nota, viewGroup, false)
         return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
         val item = items.get(pos)
         viewHolder.bindTarjeta(item, onClick) //onlClick para el manual*

        /*
         viewHolder.toolbar.setOnMenuItemClickListener() {
            when(it.getItemId()){
                (R.id.action_copiar) -> {items.add(viewHolder.adapterPosition, TextItem(item.nombre, item.logo))
                notifyItemInserted(viewHolder.adapterPosition)}

                (R.id.action_eliminar) -> {items.removeAt(viewHolder.adapterPosition)
                notifyItemRemoved(viewHolder.adapterPosition)}

            }
             true
        }

         */

    }



    override fun getItemCount(): Int {
         return items.size
    }
}